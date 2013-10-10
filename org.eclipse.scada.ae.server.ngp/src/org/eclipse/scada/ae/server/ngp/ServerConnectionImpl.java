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
package org.eclipse.scada.ae.server.ngp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.UnknownQueryException;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.data.EventInformation;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
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
import org.eclipse.scada.ae.server.EventListener;
import org.eclipse.scada.ae.server.MonitorListener;
import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.ae.server.Session;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.data.ErrorInformation;
import org.eclipse.scada.core.data.Response;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.ngp.ServiceServerConnection;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerConnectionImpl extends ServiceServerConnection<Session, Service>
{
    private final static Logger logger = LoggerFactory.getLogger ( ServerConnectionImpl.class );

    private BrowserListenerManager browserListenerManager;

    private final Map<Long, QueryImpl> queries = new HashMap<Long, QueryImpl> ();

    public ServerConnectionImpl ( final IoSession session, final Service service )
    {
        super ( session, service );
    }

    @Override
    public void dispose ()
    {
        for ( final QueryImpl query : this.queries.values () )
        {
            query.close ();
        }
        this.queries.clear ();
        super.dispose ();
    }

    /**
     * @since 1.1
     */
    @Override
    protected void initializeSession ( final Session session )
    {
        super.initializeSession ( session );
        session.setMonitorListener ( new MonitorListener () {

            @Override
            public void dataChanged ( final String subscriptionId, final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
            {
                handleMonitorDataChanged ( subscriptionId, addedOrUpdated, removed, full );
            }

            @Override
            public void updateStatus ( final Object topic, final SubscriptionState subscriptionState )
            {
                handleMonitorStatusChange ( topic.toString (), subscriptionState );
            }
        } );
        session.setEventListener ( new EventListener () {

            @Override
            public void dataChanged ( final String poolId, final List<Event> addedEvents )
            {
                handleEventDataChange ( poolId, addedEvents );
            }

            @Override
            public void updateStatus ( final Object topic, final SubscriptionState subscriptionState )
            {
                handleEventStatusChange ( topic.toString (), subscriptionState );
            }
        } );
    }

    protected void handleEventDataChange ( final String eventPoolId, final List<Event> addedEvents )
    {
        sendMessage ( new EventPoolDataUpdate ( eventPoolId, convert ( addedEvents ) ) );
    }

    protected void handleMonitorDataChanged ( final String monitorPoolId, final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        sendMessage ( new MonitorPoolDataUpdate ( monitorPoolId, addedOrUpdated, removed, full ) );
    }

    protected void handleEventStatusChange ( final String eventPoolId, final SubscriptionState state )
    {
        sendMessage ( new EventPoolStatusUpdate ( eventPoolId, state ) );
    }

    protected void handleMonitorStatusChange ( final String monitorPoolId, final SubscriptionState state )
    {
        sendMessage ( new MonitorPoolStatusUpdate ( monitorPoolId, state ) );
    }

    @Override
    public void messageReceived ( final Object message ) throws Exception
    {
        logger.trace ( "Received message: {}", message );

        if ( message instanceof StartBrowse )
        {
            handleStartBrowse ();
        }
        else if ( message instanceof StopBrowse )
        {
            handleStopBrowse ();
        }
        else if ( message instanceof SubscribeMonitorPool )
        {
            handleSubscribeMonitorPool ( (SubscribeMonitorPool)message );
        }
        else if ( message instanceof UnsubscribeMonitorPool )
        {
            handleUnsubscribeMonitorPool ( (UnsubscribeMonitorPool)message );
        }
        else if ( message instanceof SubscribeEventPool )
        {
            handleSubscribeEventPool ( (SubscribeEventPool)message );
        }
        else if ( message instanceof UnsubscribeEventPool )
        {
            handleUnsubscribeEventPool ( (UnsubscribeEventPool)message );
        }
        else if ( message instanceof CloseQuery )
        {
            handleCloseQuery ( (CloseQuery)message );
        }
        else if ( message instanceof CreateQuery )
        {
            handleCreateQuery ( (CreateQuery)message );
        }
        else if ( message instanceof LoadMore )
        {
            handleLoadMore ( (LoadMore)message );
        }
        else if ( message instanceof AcknowledgeRequest )
        {
            handleAknRequest ( (AcknowledgeRequest)message );
        }
        else
        {
            super.messageReceived ( message );
        }
    }

    private void handleAknRequest ( final AcknowledgeRequest message ) throws InvalidSessionException
    {
        final Date timestamp = message.getAknTimestamp () == null ? null : new Date ( message.getAknTimestamp () );

        final CallbackHandler callbackHandler = createCallbackHandler ( message.getCallbackHandlerId () );

        final NotifyFuture<Void> future = this.service.acknowledge ( this.session, message.getMonitorId (), timestamp, message.getOperationParameters (), callbackHandler );

        future.addListener ( new FutureListener<Void> () {

            @Override
            public void complete ( final Future<Void> future )
            {
                try
                {
                    future.get ();
                    sendMessage ( new AcknowledgeResponse ( new Response ( message.getRequest () ), null ) );
                }
                catch ( final Exception e )
                {
                    sendMessage ( new AcknowledgeResponse ( new Response ( message.getRequest () ), new ErrorInformation ( 0x01L, "Permission denied", ExceptionHelper.formatted ( e ) ) ) );
                }
            }
        } );
    }

    private void handleCreateQuery ( final CreateQuery message ) throws InvalidSessionException
    {
        final long queryId = message.getQueryId ();
        if ( this.queries.containsKey ( queryId ) )
        {
            throw new IllegalStateException ( String.format ( "Query Id %s already exists", queryId ) );
        }

        final QueryImpl query = new QueryImpl ( queryId, this );

        final Query queryHandle = this.service.createQuery ( this.session, message.getQueryType (), message.getQueryData (), query );
        query.setQuery ( queryHandle );
        this.queries.put ( queryId, query );
    }

    private void handleLoadMore ( final LoadMore message )
    {
        final QueryImpl query = this.queries.get ( message.getQueryId () );
        if ( query == null )
        {
            return;
        }
        query.loadMore ( message.getCount () );
    }

    private void handleCloseQuery ( final CloseQuery message )
    {
        final QueryImpl query = this.queries.get ( message.getQueryId () );
        if ( query == null )
        {
            return;
        }
        query.close ();
    }

    private void handleSubscribeMonitorPool ( final SubscribeMonitorPool message ) throws Exception
    {
        try
        {
            this.service.subscribeConditionQuery ( this.session, message.getMonitorPoolId () );
        }
        catch ( final UnknownQueryException e )
        {
            logger.warn ( "Subscribe to unknwn query", e );
        }
    }

    private void handleUnsubscribeMonitorPool ( final UnsubscribeMonitorPool message ) throws Exception
    {
        this.service.unsubscribeConditionQuery ( this.session, message.getMonitorPoolId () );
    }

    private void handleSubscribeEventPool ( final SubscribeEventPool message ) throws Exception
    {
        try
        {
            this.service.subscribeEventQuery ( this.session, message.getEventPoolId () );
        }
        catch ( final UnknownQueryException e )
        {
            logger.warn ( "Subscribe to unknwn query", e );
        }
    }

    private void handleUnsubscribeEventPool ( final UnsubscribeEventPool message ) throws Exception
    {
        this.service.unsubscribeEventQuery ( this.session, message.getEventPoolId () );
    }

    private void handleStopBrowse ()
    {
        if ( this.browserListenerManager == null )
        {
            return;
        }

        this.session.setBrowserListener ( null );
        this.browserListenerManager = null;
    }

    private void handleStartBrowse ()
    {
        if ( this.browserListenerManager != null )
        {
            return;
        }

        this.browserListenerManager = new BrowserListenerManager ( this );
        this.session.setBrowserListener ( this.browserListenerManager );
    }

    public synchronized void sendQueryData ( final QueryImpl queryImpl, final List<Event> events )
    {
        final QueryImpl query = this.queries.get ( queryImpl.getQueryId () );
        if ( query == null )
        {
            return;
        }

        sendMessage ( new UpdateQueryData ( query.getQueryId (), convert ( events ) ) );
    }

    public synchronized void sendQueryState ( final QueryImpl queryImpl, final QueryState state, final Throwable error )
    {
        final QueryImpl query = this.queries.get ( queryImpl.getQueryId () );
        if ( query == null )
        {
            return;
        }

        sendMessage ( new UpdateQueryState ( query.getQueryId (), state, new ErrorInformation ( null, error == null ? null : error.getMessage (), ExceptionHelper.formatted ( error ) ) ) );
    }

    private List<EventInformation> convert ( final List<Event> events )
    {
        final List<EventInformation> result = new ArrayList<EventInformation> ( events.size () );

        for ( final Event event : events )
        {
            result.add ( convertEvent ( event ) );
        }

        return result;
    }

    private EventInformation convertEvent ( final Event event )
    {
        return new EventInformation ( event.getId ().toString (), event.getSourceTimestamp ().getTime (), event.getEntryTimestamp ().getTime (), event.getAttributes () );
    }

    public synchronized void handleBrowseDataChanged ( final BrowserListenerManager browserListenerManager, final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        if ( this.browserListenerManager != browserListenerManager )
        {
            return;
        }

        sendMessage ( new BrowseData ( addedOrUpdated, removed, full ) );
    }

}
