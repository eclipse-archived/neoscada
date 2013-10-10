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
package org.eclipse.scada.ae.client.ngp;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.client.Connection;
import org.eclipse.scada.ae.client.EventListener;
import org.eclipse.scada.ae.client.MonitorListener;
import org.eclipse.scada.ae.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.ae.data.QueryState;
import org.eclipse.scada.ae.data.message.AcknowledgeRequest;
import org.eclipse.scada.ae.data.message.AcknowledgeResponse;
import org.eclipse.scada.ae.data.message.BrowseData;
import org.eclipse.scada.ae.data.message.CloseQuery;
import org.eclipse.scada.ae.data.message.CreateQuery;
import org.eclipse.scada.ae.data.message.EventPoolDataUpdate;
import org.eclipse.scada.ae.data.message.EventPoolStatusUpdate;
import org.eclipse.scada.ae.data.message.LoadMore;
import org.eclipse.scada.ae.data.message.MonitorPoolDataUpdate;
import org.eclipse.scada.ae.data.message.MonitorPoolStatusUpdate;
import org.eclipse.scada.ae.data.message.StartBrowse;
import org.eclipse.scada.ae.data.message.StopBrowse;
import org.eclipse.scada.ae.data.message.SubscribeEventPool;
import org.eclipse.scada.ae.data.message.SubscribeMonitorPool;
import org.eclipse.scada.ae.data.message.UnsubscribeEventPool;
import org.eclipse.scada.ae.data.message.UnsubscribeMonitorPool;
import org.eclipse.scada.ae.data.message.UpdateQueryData;
import org.eclipse.scada.ae.data.message.UpdateQueryState;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ngp.ConnectionBaseImpl;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.Request;
import org.eclipse.scada.core.data.ResponseMessage;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.ExecutorFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends ConnectionBaseImpl implements Connection
{
    /**
     * A dummy query which is only disconnected
     * 
     * @author Jens Reimann
     */
    public static class DisconnectedQuery implements Query
    {
        public DisconnectedQuery ( final ExecutorService executor, final QueryListener listener, final Throwable error )
        {
            executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.queryStateChanged ( QueryState.DISCONNECTED, error );
                }
            } );
        }

        @Override
        public void loadMore ( final int count )
        {
        }

        @Override
        public void close ()
        {
        }
    }

    public static class AcknowledgeFuture extends ExecutorFuture<Void> implements FutureListener<ResponseMessage>
    {
        public AcknowledgeFuture ( final Executor executor, final NotifyFuture<ResponseMessage> future )
        {
            super ( executor );
            future.addListener ( this );
        }

        @Override
        public void complete ( final Future<ResponseMessage> future )
        {
            try
            {
                final ResponseMessage response = future.get ();
                if ( response instanceof AcknowledgeResponse )
                {
                    if ( ( (AcknowledgeResponse)response ).getErrorInformation () == null )
                    {
                        setResult ( null );
                    }
                    else
                    {
                        setError ( new OperationException ( ( (AcknowledgeResponse)response ).getErrorInformation ().getMessage () ).fillInStackTrace () );
                    }
                }
                else
                {
                    setError ( new IllegalStateException ( String.format ( "Wrong reply - expected: %s, got: %s", AcknowledgeResponse.class, response ) ) );
                }
            }
            catch ( final Exception e )
            {
                setError ( e );
            }
        }
    }

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    private final BrowserManager browserManager;

    private final MonitorManager monitorManager;

    private final EventManager eventManager;

    private final QueryManager queryManager;

    public ConnectionImpl ( final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( new ProtocolConfigurationFactoryImpl ( connectionInformation ), connectionInformation );
        this.browserManager = new BrowserManager ( this.executor, this );
        this.monitorManager = new MonitorManager ( this.executor, this );
        this.eventManager = new EventManager ( this.executor, this );
        this.queryManager = new QueryManager ( this.executor, this );
    }

    @Override
    public synchronized void dispose ()
    {
        this.browserManager.dispose ();
        this.monitorManager.dispose ();
        this.eventManager.dispose ();
        this.queryManager.dispose ();
        super.dispose ();
    }

    @Override
    protected void onConnectionClosed ()
    {
        super.onConnectionClosed ();
        this.browserManager.onClosed ();
        this.monitorManager.onClosed ();
        this.eventManager.onClosed ();
        this.queryManager.onClosed ();
    }

    @Override
    protected void onConnectionBound ()
    {
        super.onConnectionBound ();
        this.browserManager.onBound ();
        this.monitorManager.onBound ();
        this.eventManager.onBound ();
        this.queryManager.onBound ();
    }

    @Override
    public synchronized void addBrowserListener ( final BrowserListener listener )
    {
        this.browserManager.addBrowserListener ( listener );
    }

    @Override
    public synchronized void removeBrowserListener ( final BrowserListener listener )
    {
        this.browserManager.removeBrowserListener ( listener );
    }

    @Override
    public synchronized void setEventListener ( final String eventQueryId, final EventListener listener )
    {
        this.eventManager.setEventListener ( eventQueryId, listener );
    }

    @Override
    public synchronized void setMonitorListener ( final String monitorQueryId, final MonitorListener listener )
    {
        this.monitorManager.setMonitorListener ( monitorQueryId, listener );
    }

    @Override
    public synchronized Query createQuery ( final String queryType, final String queryData, final QueryListener listener )
    {
        if ( getState () != ConnectionState.BOUND )
        {
            return new DisconnectedQuery ( this.executor, listener, new IllegalStateException ( "Connection is not BOUND" ).fillInStackTrace () );
        }
        else
        {
            return this.queryManager.createQuery ( queryType, queryData, listener );
        }
    }

    @Override
    public NotifyFuture<Void> acknowledge ( final String monitorId, final Date aknTimestamp, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        final Request request = nextRequest ();
        final Long callbackHandlerId = registerCallbackHandler ( request, callbackHandler );
        return new AcknowledgeFuture ( this.executor, sendRequestMessage ( new AcknowledgeRequest ( nextRequest (), monitorId, makeTimestamp ( aknTimestamp ), operationParameters, callbackHandlerId ) ) );
    }

    @Override
    protected synchronized void handleMessage ( final Object message )
    {
        if ( message instanceof MonitorPoolDataUpdate )
        {
            handleMonitorPoolDataUpdate ( (MonitorPoolDataUpdate)message );
        }
        else if ( message instanceof MonitorPoolStatusUpdate )
        {
            handleMonitorPoolStatusUpdate ( (MonitorPoolStatusUpdate)message );
        }
        if ( message instanceof EventPoolDataUpdate )
        {
            handleEventPoolDataUpdate ( (EventPoolDataUpdate)message );
        }
        else if ( message instanceof EventPoolStatusUpdate )
        {
            handleEventPoolStatusUpdate ( (EventPoolStatusUpdate)message );
        }
        else if ( message instanceof UpdateQueryData )
        {
            handleUpdateQueryData ( (UpdateQueryData)message );
        }
        else if ( message instanceof UpdateQueryState )
        {
            handleUpdateQueryState ( (UpdateQueryState)message );
        }
        else if ( message instanceof BrowseData )
        {
            handleBrowseData ( (BrowseData)message );
        }
        else
        {
            super.handleMessage ( message );
        }
    }

    private void handleBrowseData ( final BrowseData message )
    {
        this.browserManager.updateData ( message.getAddedOrUpdated (), message.getRemoved () );
    }

    private void handleUpdateQueryState ( final UpdateQueryState message )
    {
        this.queryManager.updateQueryState ( message.getQueryId (), message.getState (), message.getError () );
    }

    private void handleUpdateQueryData ( final UpdateQueryData message )
    {
        this.queryManager.updateQueryData ( message.getQueryId (), message.getEvents () );
    }

    private void handleMonitorPoolStatusUpdate ( final MonitorPoolStatusUpdate message )
    {
        this.monitorManager.handleStatusUpdate ( message.getMonitorPoolId (), message.getState () );
    }

    private void handleMonitorPoolDataUpdate ( final MonitorPoolDataUpdate message )
    {
        this.monitorManager.handleDataUpdate ( message.getMonitorPoolId (), message.getAddedOrUpdated (), message.getRemoved (), message.isFull () );
    }

    private void handleEventPoolStatusUpdate ( final EventPoolStatusUpdate message )
    {
        this.eventManager.handleStatusUpdate ( message.getEventPoolId (), message.getState () );
    }

    private void handleEventPoolDataUpdate ( final EventPoolDataUpdate message )
    {
        this.eventManager.handleDataUpdate ( message.getEventPoolId (), message.getAddedEvents () );
    }

    public void sendStartBrowse ()
    {
        logger.debug ( "Starting browsing" );
        sendMessage ( new StartBrowse () );
    }

    public void sendStopBrowse ()
    {
        logger.debug ( "Stop browsing" );
        sendMessage ( new StopBrowse () );
    }

    public void sendSubscribeMonitorPool ( final String monitorPoolId )
    {
        logger.debug ( "Subscribe to monitor pool: {}", monitorPoolId );
        sendMessage ( new SubscribeMonitorPool ( monitorPoolId ) );
    }

    public void sendUnsubscribeMonitorPool ( final String monitorPoolId )
    {
        logger.debug ( "Unsubscribe from monitor pool: {}", monitorPoolId );
        sendMessage ( new UnsubscribeMonitorPool ( monitorPoolId ) );
    }

    public void sendSubscribeEventPool ( final String eventPoolId )
    {
        logger.debug ( "Subscribe to event pool: {}", eventPoolId );
        sendMessage ( new SubscribeEventPool ( eventPoolId ) );
    }

    public void sendUnsubscribeEventPool ( final String eventPoolId )
    {
        logger.debug ( "Unsubscribe from event pool: {}", eventPoolId );
        sendMessage ( new UnsubscribeEventPool ( eventPoolId ) );
    }

    private static Long makeTimestamp ( final Date timestamp )
    {
        if ( timestamp == null )
        {
            return null;
        }
        return timestamp.getTime ();
    }

    public void sendCloseQuery ( final long queryId )
    {
        sendMessage ( new CloseQuery ( queryId ) );
    }

    public void sendLoadMore ( final long queryId, final int count )
    {
        sendMessage ( new LoadMore ( queryId, count ) );
    }

    public void sendCreateQuery ( final long queryId, final String queryType, final String queryData )
    {
        sendMessage ( new CreateQuery ( queryId, queryType, queryData ) );
    }

}
