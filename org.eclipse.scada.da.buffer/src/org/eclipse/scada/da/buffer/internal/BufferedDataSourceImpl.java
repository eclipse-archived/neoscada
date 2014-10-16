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
package org.eclipse.scada.da.buffer.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.buffer.BufferedDataSource;
import org.eclipse.scada.da.buffer.BufferedDataSourceListener;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.data.DataItemValueLight;
import org.eclipse.scada.da.datasource.data.DataItemValueRange;
import org.eclipse.scada.da.datasource.data.DataItemValueRange.DataItemValueRangeState;
import org.eclipse.scada.ds.DataListener;
import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.DataNodeTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker.ServiceListener;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferedDataSourceImpl implements BufferedDataSource, DataListener, DataSourceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( BufferedDataSourceImpl.class );

    private final BundleContext context;

    private final ScheduledExecutorService scheduler;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final DataNodeTracker dataNodeTracker;

    private final String configurationId;

    private final ObjectPoolImpl<BufferedDataSource> objectPool;

    private String dataSourceId;

    private Variant initialValue;

    private long trigger;

    private long range;

    private DataItemValueRange valueRange;

    private String nodeId;

    private boolean triggerOnly;

    private Persistence persistence;

    private final Set<BufferedDataSourceListener> listeners = new CopyOnWriteArraySet<BufferedDataSourceListener> ();

    private final Object listenersLock = new Object ();

    private ScheduledFuture<?> triggerFuture;

    private boolean initialPersistentValuesLoaded = false;

    private SingleObjectPoolServiceTracker<DataSource> dataSourceTracker;

    private DataSource dataSource;

    public BufferedDataSourceImpl ( final BundleContext context, final ScheduledExecutorService scheduler, final ObjectPoolTracker<DataSource> poolTracker, final DataNodeTracker dataNodeTracker, final String configurationId, final ObjectPoolImpl<BufferedDataSource> objectPool )
    {
        this.context = context;
        this.scheduler = scheduler;
        this.poolTracker = poolTracker;
        this.dataNodeTracker = dataNodeTracker;
        this.configurationId = configurationId;
        this.objectPool = objectPool;
    }

    public void update ( final Map<String, String> parameters )
    {
        logger.info ( "Update configuration" );

        if ( this.triggerFuture != null )
        {
            this.triggerFuture.cancel ( false );
            this.triggerFuture = null;
        }

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        this.dataSourceId = cfg.getStringChecked ( DataSource.DATA_SOURCE_ID, String.format ( "'%s' must be set", DataSource.DATA_SOURCE_ID ) );
        this.initialValue = cfg.getVariant ( "initialValue", Variant.NULL );
        this.trigger = cfg.getLongChecked ( "trigger", "'trigger' must be set" ); //$NON-NLS-1$
        this.range = cfg.getLongChecked ( "range", "'range' must be set" ); //$NON-NLS-1$
        this.triggerOnly = cfg.getBoolean ( "triggerOnly", false );
        this.persistence = cfg.getEnum ( "persistence", Persistence.class, Persistence.NONE );

        this.valueRange = new DataItemValueRange ( this.range );
        this.valueRange.add ( new DataItemValueLight ( this.initialValue, SubscriptionState.CONNECTED, 0, false, false ) );

        this.nodeId = cfg.getString ( "node.id", "org.eclipse.scada.da.buffer/" + this.dataSourceId + "/" + this.range );

        // check regularly for any change in status
        this.triggerFuture = this.scheduler.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                try
                {
                    BufferedDataSourceImpl.this.valueRange.checkRange ();
                    sendUpdate ( true );
                }
                catch ( final Exception e )
                {
                    logger.error ( "failed to run checkRange () or call handleChange ()", e );
                }
            }
        }, this.trigger, this.trigger, TimeUnit.SECONDS );

        //
        this.dataSourceTracker = new SingleObjectPoolServiceTracker<DataSource> ( this.poolTracker, this.dataSourceId, new ServiceListener<DataSource> () {
            @Override
            public void serviceChange ( final DataSource service, final Dictionary<?, ?> properties )
            {
                setDataSource ( service );
            }
        } );
        this.dataSourceTracker.open ();
        if ( this.persistence != Persistence.REQUIRED )
        {
            this.dataNodeTracker.addListener ( this.nodeId, this );
            addService ();
        }

        this.scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                BufferedDataSourceImpl.this.valueRange.checkRange ();
                sendUpdate ( false );
            }
        } );
    }

    private synchronized void setDataSource ( final DataSource service )
    {
        if ( service == null && BufferedDataSourceImpl.this.dataSource != null )
        {
            BufferedDataSourceImpl.this.dataSource.removeListener ( BufferedDataSourceImpl.this );
        }
        else
        {
            BufferedDataSourceImpl.this.dataSource = service;
            BufferedDataSourceImpl.this.dataSource.addListener ( BufferedDataSourceImpl.this );
        }
    }

    public void dispose ()
    {
        removeService ();
        setDataSource ( null );
        if ( this.dataNodeTracker != null )
        {
            this.dataNodeTracker.removeListener ( BufferedDataSourceImpl.this.nodeId, BufferedDataSourceImpl.this );
        }
        synchronized ( this.listenersLock )
        {
            BufferedDataSourceImpl.this.listeners.clear ();
        }
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public void nodeChanged ( final DataNode node )
    {
        // we are only interested in the initial values anyway
        if ( this.initialPersistentValuesLoaded )
        {
            return;
        }
        try
        {
            SortedSet<DataItemValueLight> initialValues = null;
            if ( node != null )
            {
                initialValues = (SortedSet<DataItemValueLight>)node.getDataAsObject ( this.context.getBundle () );
            }
            this.initialPersistentValuesLoaded = true;
            if ( initialValues != null )
            {
                for ( final DataItemValueLight dataItemValue : initialValues )
                {
                    this.valueRange.add ( dataItemValue );
                }
            }
            if ( this.persistence == Persistence.REQUIRED )
            {
                addService ();
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "could not load old persistent values", e );
        }
        this.scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                sendUpdate ( false );
            }
        } );
    }

    @Override
    public void stateChanged ( final DataItemValue value )
    {
        logger.debug ( "State changed - value: {}", value );

        this.valueRange.add ( DataItemValueLight.valueOf ( value ) );
        if ( this.persistence != Persistence.NONE )
        {
            logger.trace ( "Storing update" );
            final DataItemValueRangeState state = this.valueRange.getState ();
            final TreeSet<DataItemValueLight> valuesToPersist = new TreeSet<DataItemValueLight> ();
            valuesToPersist.add ( state.getFirstValue () );
            valuesToPersist.addAll ( state.getValues () );
            this.dataNodeTracker.write ( new DataNode ( this.nodeId, valuesToPersist ) );
        }

        logger.trace ( "Sending update" );

        this.scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                sendUpdate ( false );
            }
        } );
    }

    private void sendUpdate ( final boolean triggered )
    {
        logger.debug ( "sendUpdate - triggered: {}, dataSource: {}, persistence: {}, initialPersistentValuesLoaded: {}, triggerOnly: {}", triggered, this.dataSource, this.persistence, this.initialPersistentValuesLoaded, this.triggerOnly );

        if ( this.dataSource == null )
        {
            return;
        }
        if ( this.persistence == Persistence.REQUIRED && !this.initialPersistentValuesLoaded )
        {
            return;
        }
        if ( this.triggerOnly && triggered || !this.triggerOnly )
        {
            for ( final BufferedDataSourceListener listener : this.listeners )
            {
                try
                {
                    listener.stateChanged ( this.valueRange );
                }
                catch ( final Exception e )
                {
                    logger.info ( "Failed to call listener", e );
                }
            }
        }
    }

    @Override
    public void addListener ( final BufferedDataSourceListener listener )
    {
        synchronized ( this.listenersLock )
        {
            this.listeners.add ( listener );
        }
    }

    @Override
    public void removeListener ( final BufferedDataSourceListener listener )
    {
        synchronized ( this.listenersLock )
        {
            this.listeners.remove ( listener );
        }
    }

    private void addService ()
    {
        final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
        properties.put ( BUFFERED_DATA_SOURCE_ID, this.configurationId );
        this.objectPool.addService ( this.configurationId, this, properties );
    }

    private void removeService ()
    {
        this.objectPool.removeService ( this.configurationId, this );
    }
}
