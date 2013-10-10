/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.client.ngp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ngp.ConnectionBaseImpl;
import org.eclipse.scada.hd.ItemListListener;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.client.Connection;
import org.eclipse.scada.hd.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.message.ChangeQueryParameters;
import org.eclipse.scada.hd.data.message.CloseQuery;
import org.eclipse.scada.hd.data.message.CreateQuery;
import org.eclipse.scada.hd.data.message.ListUpdate;
import org.eclipse.scada.hd.data.message.StartBrowse;
import org.eclipse.scada.hd.data.message.StopBrowse;
import org.eclipse.scada.hd.data.message.UpdateQueryData;
import org.eclipse.scada.hd.data.message.UpdateQueryParameters;
import org.eclipse.scada.hd.data.message.UpdateQueryState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends ConnectionBaseImpl implements Connection
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    private static final Object STATS_OPEN_QUERIES = new Object ();

    private final ItemManager itemManager;

    private final Map<Long, QueryImpl> queries = new HashMap<Long, QueryImpl> ();

    private final Random queryIdRandom = new Random ();

    public ConnectionImpl ( final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( new ProtocolConfigurationFactoryImpl ( connectionInformation ), connectionInformation );
        this.itemManager = new ItemManager ( this.executor, this );

        this.statistics.setLabel ( STATS_OPEN_QUERIES, "Open queries" );
    }

    @Override
    public synchronized void dispose ()
    {
        this.itemManager.dispose ();
        super.dispose ();
    }

    @Override
    protected void onConnectionBound ()
    {
        this.itemManager.onConnectionBound ();
    }

    @Override
    protected void onConnectionClosed ()
    {
        super.onConnectionClosed ();

        this.itemManager.onConnectionClosed ();

        // make a copy in order to prevent a ConcurrentModificationException
        final Collection<QueryImpl> queries = new ArrayList<QueryImpl> ( this.queries.values () );
        // clear the list now so that the closeQuery calls will see that the query is already closed
        this.queries.clear ();

        this.statistics.setCurrentValue ( STATS_OPEN_QUERIES, this.queries.size () );

        // close all queries
        for ( final QueryImpl query : queries )
        {
            try
            {
                query.close ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to close query on disconnect", e );
            }
        }
    }

    @Override
    public synchronized Query createQuery ( final String itemId, final QueryParameters parameters, final QueryListener listener, final boolean updateData )
    {
        if ( getState () != ConnectionState.BOUND )
        {
            return new ErrorQueryImpl ( this.executor, listener );
        }
        else
        {
            final long queryId = findFreeQueryId ();

            final QueryImpl query = new QueryImpl ( this.executor, this, queryId, itemId, parameters, listener );
            this.queries.put ( queryId, query );
            this.statistics.setCurrentValue ( STATS_OPEN_QUERIES, this.queries.size () );

            sendCreateQuery ( queryId, itemId, parameters, updateData );

            return query;
        }
    }

    private long findFreeQueryId ()
    {
        long queryId;
        do
        {
            queryId = this.queryIdRandom.nextLong ();
        } while ( this.queries.containsKey ( queryId ) );
        return queryId;
    }

    @Override
    public synchronized void addListListener ( final ItemListListener listener )
    {
        this.itemManager.addListListener ( listener );
    }

    @Override
    public synchronized void removeListListener ( final ItemListListener listener )
    {
        this.itemManager.removeListListener ( listener );
    }

    protected void closeQuery ( final Long queryId )
    {
        if ( queryId == null )
        {
            return;
        }

        synchronized ( this )
        {
            if ( this.queries.remove ( queryId ) != null )
            {
                sendCloseQuery ( queryId );
                this.statistics.setCurrentValue ( STATS_OPEN_QUERIES, this.queries.size () );
            }
        }
    }

    protected void updateQueryParameters ( final QueryImpl query, final QueryParameters parameters )
    {
        final Long id = query.getId ();
        if ( id == null )
        {
            return;
        }

        sendQueryUpdateParameters ( query.getId (), parameters );
    }

    @Override
    protected synchronized void handleMessage ( final Object message )
    {
        if ( message instanceof UpdateQueryState )
        {
            handleUpdateQueryState ( (UpdateQueryState)message );
        }
        else if ( message instanceof UpdateQueryParameters )
        {
            handleUpdateQueryParameters ( (UpdateQueryParameters)message );
        }
        else if ( message instanceof UpdateQueryData )
        {
            handleUpdateQueryData ( (UpdateQueryData)message );
        }
        else if ( message instanceof ListUpdate )
        {
            handleListUpdate ( (ListUpdate)message );
        }
        else
        {
            super.handleMessage ( message );
        }
    }

    private void handleListUpdate ( final ListUpdate message )
    {
        logger.debug ( "List update - addedOrModified: {}, removed: {}, full: {}", new Object[] { message.getAddedOrModified (), message.getRemoved (), message.isFullUpdate () } );

        this.itemManager.handleListUpdate ( message.getAddedOrModified (), message.getRemoved (), message.isFullUpdate () );
    }

    private void handleUpdateQueryData ( final UpdateQueryData message )
    {
        final QueryImpl query = this.queries.get ( message.getQueryId () );
        if ( query == null )
        {
            logger.info ( "Query is already closed" );
            return;
        }

        query.handleUpdateData ( message.getIndex (), message.getValues (), message.getValueInformation () );
    }

    private void handleUpdateQueryParameters ( final UpdateQueryParameters message )
    {
        final QueryImpl query = this.queries.get ( message.getQueryId () );
        if ( query == null )
        {
            logger.info ( "Query is already closed" );
            return;
        }

        query.handleUpdateParameter ( message.getQueryParameters (), message.getValueTypes () );
    }

    private void handleUpdateQueryState ( final UpdateQueryState message )
    {
        final QueryImpl query = this.queries.get ( message.getQueryId () );
        if ( query == null )
        {
            logger.info ( "Query is already closed" );
            return;
        }

        query.handleUpdateStatus ( QueryState.valueOf ( message.getState () ) );
    }

    void sendCreateQuery ( final long queryId, final String itemId, final QueryParameters parameters, final boolean updateData )
    {
        sendMessage ( new CreateQuery ( nextRequest (), queryId, itemId, updateData, parameters ) );
    }

    protected void sendCloseQuery ( final long queryId )
    {
        sendMessage ( new CloseQuery ( queryId ) );
    }

    protected void sendQueryUpdateParameters ( final long id, final QueryParameters parameters )
    {
        sendMessage ( new ChangeQueryParameters ( id, parameters ) );
    }

    protected void sendBrowseRequestState ( final boolean state )
    {
        logger.debug ( "Requesting browse state: {}", state );

        if ( state )
        {
            sendMessage ( new StartBrowse () );
        }
        else
        {
            sendMessage ( new StopBrowse () );
        }
    }
}
