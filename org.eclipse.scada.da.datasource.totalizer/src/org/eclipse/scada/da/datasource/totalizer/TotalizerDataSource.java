/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.totalizer;

import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.buffer.BufferedDataSource;
import org.eclipse.scada.da.buffer.BufferedDataSourceListener;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.base.AbstractInputDataSource;
import org.eclipse.scada.da.datasource.data.DataItemValueLight;
import org.eclipse.scada.da.datasource.data.DataItemValueRange;
import org.eclipse.scada.da.datasource.data.DataItemValueRange.DataItemValueRangeState;
import org.eclipse.scada.ds.DataListener;
import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.DataNodeTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker.ServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotalizerDataSource extends AbstractInputDataSource implements BufferedDataSourceListener, ServiceListener<BufferedDataSource>, DataListener
{
    private final static Logger logger = LoggerFactory.getLogger ( TotalizerDataSource.class );

    // initialized by constructor

    private final ScheduledExecutorService scheduler;

    private final ObjectPoolTracker<BufferedDataSource> poolTracker;

    // initialized by update
    private String bufferedDataSourceId;

    private SingleObjectPoolServiceTracker<BufferedDataSource> objectPoolTracker;

    private final DataNodeTracker dataNodeTracker;

    private BufferedDataSource bufferedDataSource;

    private Double total = 0.0;

    private long lastTimestamp = System.currentTimeMillis ();

    private ScheduledFuture<?> scheduledFuture;

    private TimeUnit unit;

    private String nodeId;

    public TotalizerDataSource ( final ScheduledExecutorService scheduler, final ObjectPoolTracker<BufferedDataSource> poolTracker, final DataNodeTracker dataNodeTracker )
    {
        super ();
        this.scheduler = scheduler;
        this.poolTracker = poolTracker;
        this.dataNodeTracker = dataNodeTracker;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.scheduler;
    }

    public void update ( final Map<String, String> parameters )
    {
        if ( scheduledFuture != null )
        {
            scheduledFuture.cancel ( false );
        }
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.bufferedDataSourceId = cfg.getStringChecked ( BufferedDataSource.BUFFERED_DATA_SOURCE_ID, String.format ( "'%s' must be set", BufferedDataSource.BUFFERED_DATA_SOURCE_ID ) ); //$NON-NLS-1$
        final TimeUnit reset = cfg.getEnumChecked ( "reset", TimeUnit.class, "'reset' must be set" );
        unit = cfg.getEnumChecked ( "unit", TimeUnit.class, "'unit' must be set" );
        final EnumSet<TimeUnit> allowed = EnumSet.of ( TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS );
        if ( ( !allowed.contains ( reset ) ) || ( !allowed.contains ( unit ) ) )
        {
            throw new IllegalArgumentException ( "only " + allowed + " TimeUnits are allowed" );
        }

        this.nodeId = cfg.getString ( "node.id", "org.eclipse.scada.da.datasource.totalizer/" + this.bufferedDataSourceId );

        this.objectPoolTracker = new SingleObjectPoolServiceTracker<BufferedDataSource> ( this.poolTracker, this.bufferedDataSourceId, this );
        this.objectPoolTracker.open ();

        this.dataNodeTracker.addListener ( nodeId, this );

        scheduledFuture = scheduler.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                reset ();
            }
        }, toNearestInstant ( System.currentTimeMillis (), reset ), reset.toMillis ( 1 ), TimeUnit.MILLISECONDS );
    }

    private void reset ()
    {
        logger.debug ( "reset totalizer for {}", this.bufferedDataSourceId );
        this.total = 0.0;
        this.lastTimestamp = System.currentTimeMillis ();
    }

    private void updateTotal ( final DataItemValueRangeState dataItemValueRangeState )
    {
        logger.trace ( "updateTotal" );
        DataItemValueLight diLast = dataItemValueRangeState.getFirstValue ();
        final long now = System.currentTimeMillis ();
        logger.trace ( "{}", dataItemValueRangeState );
        for ( final DataItemValueLight di : dataItemValueRangeState.getValues () )
        {
            if ( di.getTimestamp () > lastTimestamp )
            {
                final Long delta = di.getTimestamp () - lastTimestamp;
                final Long baseUnit = TimeUnit.MILLISECONDS.convert ( 1, unit );
                final double factor = delta.doubleValue () / baseUnit.doubleValue ();
                final double v = di.getValue ().asDouble ( 0.0 ) * factor;
                logger.trace ( "range: update total, delta t = {}, baseUnit = {}, factor = {}, v = {}", delta, baseUnit, factor, v );
                total += v;
                lastTimestamp = di.getTimestamp ();
            }
            diLast = di;
        }
        if ( now > diLast.getTimestamp () )
        {
            final Long delta = now - lastTimestamp;
            final Long baseUnit = TimeUnit.MILLISECONDS.convert ( 1, unit );
            final double factor = delta.doubleValue () / baseUnit.doubleValue ();
            final double v = diLast.getValue ().asDouble ( 0.0 ) * factor;
            logger.trace ( "last: update total, delta t = {}, baseUnit = {}, factor = {}, v = {}", delta, baseUnit, factor, v );
            total += v;
            lastTimestamp = now;
        }

        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "timestamp", Variant.valueOf ( lastTimestamp ) );
        dataNodeTracker.write ( new DataNode ( nodeId, new TotalizerState ( lastTimestamp, total ) ) );
        this.updateData ( new DataItemValue ( Variant.valueOf ( total ), attributes, SubscriptionState.CONNECTED ) );
    }

    @Override
    public void stateChanged ( final DataItemValueRange dataItemValueRange )
    {
        updateTotal ( dataItemValueRange.getState () );
    }

    public void dispose ()
    {
        if ( scheduledFuture != null )
        {
            scheduledFuture.cancel ( false );
        }
        if ( this.scheduler != null )
        {
            scheduler.shutdownNow ();
        }
        if ( this.objectPoolTracker != null )
        {
            this.objectPoolTracker.close ();
            this.objectPoolTracker = null;
        }
        setBufferedDataSource ( null );
    }

    @Override
    public void serviceChange ( final BufferedDataSource service, final Dictionary<?, ?> properties )
    {
        setBufferedDataSource ( service );
    }

    @Override
    public void nodeChanged ( final DataNode node )
    {
        if ( node != null )
        {
            final TotalizerState state = (TotalizerState)node.getDataAsObject ( getClass ().getClassLoader (), new TotalizerState ( new Date ().getTime (), 0.0 ) );
            this.total = state.getTotal ();
            this.lastTimestamp = state.getTimestamp ();
        }
    }

    private synchronized void setBufferedDataSource ( final BufferedDataSource service )
    {
        if ( ( service == null ) && ( this.bufferedDataSource != null ) )
        {
            this.bufferedDataSource.removeListener ( this );
        }
        else
        {
            this.bufferedDataSource = service;
            this.bufferedDataSource.addListener ( this );
        }
    }

    private long toNearestInstant ( final long timestamp, final TimeUnit reset )
    {
        final GregorianCalendar cal = new GregorianCalendar ();
        cal.setTimeInMillis ( timestamp );
        switch ( reset )
        {
            case DAYS:
                cal.add ( Calendar.DAY_OF_YEAR, 1 );
                cal.set ( Calendar.HOUR, 0 );
                cal.set ( Calendar.MINUTE, 0 );
                cal.set ( Calendar.SECOND, 0 );
                cal.set ( Calendar.MILLISECOND, 0 );
                break;
            case HOURS:
                cal.add ( Calendar.HOUR, 1 );
                cal.set ( Calendar.MINUTE, 0 );
                cal.set ( Calendar.SECOND, 0 );
                cal.set ( Calendar.MILLISECOND, 0 );
                break;
            case MINUTES:
                cal.add ( Calendar.MINUTE, 1 );
                cal.set ( Calendar.SECOND, 0 );
                cal.set ( Calendar.MILLISECOND, 0 );
                break;
            case SECONDS:
                cal.add ( Calendar.SECOND, 1 );
                cal.set ( Calendar.MILLISECOND, 0 );
                break;
            default:
                break;
        }
        // in worst case this is the same time as the given one
        return cal.getTimeInMillis () - timestamp;
    }
}
