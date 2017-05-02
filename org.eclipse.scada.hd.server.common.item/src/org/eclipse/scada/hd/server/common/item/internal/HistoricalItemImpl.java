/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.common.item.internal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker.ServiceListener;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.eclipse.scada.hd.server.common.StorageHistoricalItem;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class HistoricalItemImpl implements HistoricalItem, DataSourceListener
{
    private class WrapperQuery implements Query
    {
        private final Query query;

        public WrapperQuery ( final Query query )
        {
            this.query = query;
        }

        @Override
        public void changeParameters ( final QueryParameters parameters )
        {
            this.query.changeParameters ( parameters );
        }

        @Override
        public void close ()
        {
            HistoricalItemImpl.this.openQueries.remove ( this );
            this.query.close ();
        }

        public boolean isValid ()
        {
            return this.query != null;
        }
    }

    private final static Logger logger = LoggerFactory.getLogger ( HistoricalItemImpl.class );

    private static final int DEFAULT_MAX_BUFFER_SIZE = 1024;

    private final HistoricalItemInformation itemInformation;

    private String dataSourceId;

    private final SingleServiceTracker<StorageHistoricalItem> storageTracker;

    private StorageHistoricalItem service;

    private final Set<Query> openQueries = new HashSet<Query> ();

    private final ObjectPoolTracker<DataSource> poolTracker;

    private SingleDataSourceTracker dataSourceTracker;

    private DataSource dataSource;

    private final Queue<DataItemValue> valueBuffer;

    private int maxBufferSize = DEFAULT_MAX_BUFFER_SIZE;

    public HistoricalItemImpl ( final HistoricalItemInformation itemInformation, final String masterId, final BundleContext context ) throws InvalidSyntaxException
    {
        this.itemInformation = itemInformation;
        this.dataSourceId = masterId;

        this.valueBuffer = new LinkedList<DataItemValue> ();

        this.storageTracker = new SingleServiceTracker<StorageHistoricalItem> ( context, FilterUtil.createAndFilter ( StorageHistoricalItem.class.getName (), new MapBuilder<String, String> ().put ( Constants.SERVICE_PID, itemInformation.getItemId () ).getMap () ), new SingleServiceListener<StorageHistoricalItem> () {

            @Override
            public void serviceChange ( final ServiceReference<StorageHistoricalItem> reference, final StorageHistoricalItem service )
            {
                HistoricalItemImpl.this.setStorage ( service );
            }
        } );
        this.poolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
    }

    protected synchronized void setDataSource ( final DataSource service )
    {
        logger.info ( "Set data source item: {}", service );

        if ( this.dataSource != null )
        {
            this.dataSource.removeListener ( this );
        }
        this.dataSource = service;
        if ( this.dataSource != null )
        {
            this.dataSource.addListener ( this );
        }
    }

    protected synchronized void setStorage ( final StorageHistoricalItem service )
    {
        logger.info ( "Setting storage: {}", service );

        if ( this.service == service )
        {
            return;
        }

        // close all open queries
        closeOpenQueries ();

        // remember the new service
        this.service = service;

        if ( this.service != null )
        {
            logger.info ( String.format ( "Pushing %s entries from value buffer", this.valueBuffer.size () ) );
            while ( !this.valueBuffer.isEmpty () )
            {
                service.updateData ( this.valueBuffer.poll () );
            }
        }
    }

    public void start () throws InvalidSyntaxException
    {
        logger.info ( "Start HistoricalItem: {}", this.itemInformation.getItemId () );

        this.storageTracker.open ();
        this.poolTracker.open ();
        updateDataSource ();
    }

    public void stop ()
    {
        logger.info ( "Stop HistoricalItem: {}", this.itemInformation.getItemId () );

        this.storageTracker.close ();
        if ( this.dataSourceTracker != null )
        {
            this.dataSourceTracker.close ();
            this.dataSourceTracker = null;
        }
        this.poolTracker.close ();
    }

    public HistoricalItemImpl ( final String id, final Map<String, Variant> attributes, final String masterId, final BundleContext context ) throws InvalidSyntaxException
    {
        this ( new HistoricalItemInformation ( id, attributes ), masterId, context );
    }

    @Override
    public synchronized Query createQuery ( final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        final Profiler p = new Profiler ( "hi.createQuery" );
        p.setLogger ( logger );

        if ( this.service == null )
        {
            logger.warn ( "We have no service. We cannot create a query" );
            return null;
        }

        p.start ( "call shi.createQuery" );

        final WrapperQuery query = new WrapperQuery ( this.service.createQuery ( parameters, listener, updateData ) );
        if ( query.isValid () )
        {
            this.openQueries.add ( query );
        }
        else
        {
            logger.warn ( "We have an invalid query" );
        }

        p.stop ().log ();

        return query;
    }

    @Override
    public HistoricalItemInformation getInformation ()
    {
        return this.itemInformation;
    }

    private void closeOpenQueries ()
    {
        for ( final Query query : this.openQueries )
        {
            query.close ();
        }
        this.openQueries.clear ();
    }

    @Override
    public void stateChanged ( final DataItemValue value )
    {
        logger.debug ( "state changed: {}", value );

        synchronized ( this )
        {
            if ( this.service != null )
            {
                this.service.updateData ( value );
            }
            else
            {
                logger.debug ( "State change ignored: {} missing storage", this.itemInformation.getItemId () );
                final int size = this.valueBuffer.size ();
                if ( size < this.maxBufferSize )
                {
                    logger.debug ( "State change recorded: buffer size: {}", size );
                    this.valueBuffer.add ( value );
                }
            }
        }
    }

    public void update ( final Map<String, String> properties ) throws InvalidSyntaxException
    {
        final String dataSourceId = properties.get ( DataSource.DATA_SOURCE_ID );

        synchronized ( this )
        {
            logger.info ( "Updating..." );

            try
            {
                this.maxBufferSize = Integer.parseInt ( properties.get ( "maxBufferSize" ) );
            }
            catch ( final NumberFormatException e )
            {
                this.maxBufferSize = DEFAULT_MAX_BUFFER_SIZE;
            }
            this.dataSourceId = dataSourceId;
            updateDataSource ();

            logger.info ( "Updating... done" );
        }
    }

    private void updateDataSource () throws InvalidSyntaxException
    {
        logger.debug ( "updateDataSource ()" );
        if ( this.dataSourceTracker != null )
        {
            this.dataSourceTracker.close ();
            this.dataSourceTracker = null;
        }
        if ( this.dataSourceId != null )
        {
            logger.debug ( "track datasource " + this.dataSourceId );
            this.dataSourceTracker = new SingleDataSourceTracker ( this.poolTracker, this.dataSourceId, new ServiceListener () {
                @Override
                public void dataSourceChanged ( final DataSource dataSource )
                {
                    setDataSource ( dataSource );
                }
            } );
            this.dataSourceTracker.open ();
        }
    }
}
