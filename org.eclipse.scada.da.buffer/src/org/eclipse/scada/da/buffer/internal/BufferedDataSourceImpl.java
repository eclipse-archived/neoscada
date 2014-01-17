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

    private BundleContext context;

    private ScheduledExecutorService scheduler;

    private ObjectPoolTracker<DataSource> poolTracker;

    private DataNodeTracker dataNodeTracker;

    private String configurationId;

    private ObjectPoolImpl<BufferedDataSource> objectPool;

    private String dataSourceId;

    private Variant initialValue;

    private long trigger;

    private long range;

    private DataItemValueRange valueRange;

    private String nodeId;

    private boolean triggerOnly;

    private Persistence persistence;

    private Set<BufferedDataSourceListener> listeners = new CopyOnWriteArraySet<BufferedDataSourceListener> ();

    private Object listenersLock = new Object ();

    private ScheduledFuture<?> triggerFuture;

    private boolean initialPersistentValuesLoaded = false;

    private SingleObjectPoolServiceTracker<DataSource> dataSourceTracker;

    private DataSource dataSource;

    public BufferedDataSourceImpl ( BundleContext context, ScheduledExecutorService scheduler, ObjectPoolTracker<DataSource> poolTracker, DataNodeTracker dataNodeTracker, String configurationId, ObjectPoolImpl<BufferedDataSource> objectPool )
    {
        this.context = context;
        this.scheduler = scheduler;
        this.poolTracker = poolTracker;
        this.dataNodeTracker = dataNodeTracker;
        this.configurationId = configurationId;
        this.objectPool = objectPool;
    }

    public void update ( Map<String, String> parameters )
    {
        if ( this.triggerFuture != null )
        {
            this.triggerFuture.cancel ( false );
            this.triggerFuture = null;
        }

        ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        this.dataSourceId = cfg.getStringChecked ( DataSource.DATA_SOURCE_ID, String.format ( "'%s' must be set", DataSource.DATA_SOURCE_ID ) );
        this.initialValue = cfg.getVariant ( "initialValue", Variant.NULL );
        this.trigger = cfg.getLongChecked ( "trigger", "'trigger' must be set" ); //$NON-NLS-1$
        this.range = cfg.getLongChecked ( "range", "'range' must be set" ); //$NON-NLS-1$
        this.triggerOnly = cfg.getBoolean ( "triggerOnly", false );
        this.persistence = cfg.getEnum ( "persistence", Persistence.class, Persistence.NONE );

        this.valueRange = new DataItemValueRange ( range );
        this.valueRange.add ( new DataItemValueLight ( this.initialValue, SubscriptionState.CONNECTED, 0, false, false ) );

        this.nodeId = cfg.getString ( "node.id", "org.eclipse.scada.da.buffer/" + this.dataSourceId + "/" + range );

        // check regularly for any change in status
        this.triggerFuture = this.scheduler.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                try
                {
                    valueRange.checkRange ();
                    sendUpdate ( true );
                }
                catch ( final Exception e )
                {
                    logger.error ( "failed to run checkRange () or call handleChange ()", e );
                }
            }
        }, this.trigger, this.trigger, TimeUnit.SECONDS );

        // 
        this.dataSourceTracker = new SingleObjectPoolServiceTracker<DataSource> ( this.poolTracker, dataSourceId, new ServiceListener<DataSource> () {
            @Override
            public void serviceChange ( final DataSource service, final Dictionary<?, ?> properties )
            {
                setDataSource ( service );
            }
        } );
        this.dataSourceTracker.open ();
        if ( persistence != Persistence.REQUIRED )
        {
            this.dataNodeTracker.addListener ( nodeId, this );
            addService ();
        }

        scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                valueRange.checkRange ();
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
        if ( dataNodeTracker != null )
        {
            dataNodeTracker.removeListener ( BufferedDataSourceImpl.this.nodeId, BufferedDataSourceImpl.this );
        }
        synchronized ( listenersLock )
        {
            BufferedDataSourceImpl.this.listeners.clear ();
        }
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public void nodeChanged ( DataNode node )
    {
        // we are only interested in the initial values anyway 
        if ( initialPersistentValuesLoaded )
        {
            return;
        }
        try
        {
            SortedSet<DataItemValueLight> initialValues = null;
            if ( node != null )
            {
                initialValues = (SortedSet<DataItemValueLight>)node.getDataAsObject ( context.getBundle () );
            }
            initialPersistentValuesLoaded = true;
            if ( initialValues != null )
            {
                for ( DataItemValueLight dataItemValue : initialValues )
                {
                    valueRange.add ( dataItemValue );
                }
            }
            if ( persistence == Persistence.REQUIRED )
            {
                addService ();
            }
        }
        catch ( Exception e )
        {
            logger.warn ( "could not load old persistent values", e );
        }
        scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                sendUpdate ( false );
            }
        } );
    }

    @Override
    public void stateChanged ( DataItemValue value )
    {
        valueRange.add ( DataItemValueLight.valueOf ( value ) );
        if ( persistence != Persistence.NONE )
        {
            DataItemValueRangeState state = valueRange.getState ();
            TreeSet<DataItemValueLight> valuesToPersist = new TreeSet<DataItemValueLight> ();
            valuesToPersist.add ( state.getFirstValue () );
            valuesToPersist.addAll ( state.getValues () );
            dataNodeTracker.write ( new DataNode ( nodeId, valuesToPersist ) );
        }
        scheduler.submit ( new Runnable () {
            @Override
            public void run ()
            {
                sendUpdate ( false );
            }
        } );
    }

    private void sendUpdate ( boolean triggered )
    {
        if ( dataSource == null )
        {
            return;
        }
        if ( persistence == Persistence.REQUIRED && !initialPersistentValuesLoaded )
        {
            return;
        }
        if ( ( triggerOnly && triggered ) || ( !triggerOnly ) )
        {
            for ( BufferedDataSourceListener listener : listeners )
            {
                listener.stateChanged ( valueRange );
            }
        }
    }

    @Override
    public void addListener ( final BufferedDataSourceListener listener )
    {
        synchronized ( listenersLock )
        {
            listeners.add ( listener );
        }
    }

    @Override
    public void removeListener ( final BufferedDataSourceListener listener )
    {
        synchronized ( listenersLock )
        {
            listeners.remove ( listener );
        }
    }

    private void addService ()
    {
        final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
        properties.put ( BUFFERED_DATA_SOURCE_ID, configurationId );
        this.objectPool.addService ( configurationId, this, properties );
    }

    private void removeService ()
    {
        this.objectPool.removeService ( configurationId, this );
    }
}
