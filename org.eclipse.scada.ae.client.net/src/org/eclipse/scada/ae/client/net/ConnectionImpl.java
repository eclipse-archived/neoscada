/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.client.net;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.client.EventListener;
import org.eclipse.scada.ae.client.MonitorListener;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.QueryState;
import org.eclipse.scada.ae.net.BrowserMessageHelper;
import org.eclipse.scada.ae.net.EventMessageHelper;
import org.eclipse.scada.ae.net.Messages;
import org.eclipse.scada.ae.net.MonitorMessageHelper;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.net.MessageFuture;
import org.eclipse.scada.core.client.net.SessionConnectionBase;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.net.base.MessageListener;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.utils.MessageCreator;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionImpl extends SessionConnectionBase implements org.eclipse.scada.ae.client.Connection
{

    private static final String MESSAGE_QUERY_ID = "queryId";

    static
    {
        DriverFactoryImpl.registerDriver ();
    }

    public static final String VERSION = "0.1.0";

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionImpl.class );

    private final Map<String, MonitorListener> monitorListeners = new HashMap<String, MonitorListener> ();

    private final Map<String, EventListener> eventListeners = new HashMap<String, EventListener> ();

    private final Set<BrowserListener> browserListeners = new CopyOnWriteArraySet<BrowserListener> ();

    private final Map<String, BrowserEntry> browserCache = new HashMap<String, BrowserEntry> ();

    private final Map<Long, QueryImpl> queries = new HashMap<Long, QueryImpl> ();

    private final Random random = new Random ();

    @Override
    public String getRequiredVersion ()
    {
        return VERSION;
    }

    public ConnectionImpl ( final ConnectionInformation connectionInformantion )
    {
        super ( connectionInformantion );

        init ();
    }

    protected void init ()
    {
        this.messenger.setHandler ( Messages.CC_CONDITIONS_STATUS, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleConditionStatus ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_CONDITIONS_DATA, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleConditionData ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_EVENT_POOL_STATUS, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleEventStatus ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_EVENT_POOL_DATA, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleEventData ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_BROWSER_UPDATE, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleBrowserUpdate ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_QUERY_STATUS_CHANGED, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleQueryStateChange ( message );
            }
        } );

        this.messenger.setHandler ( Messages.CC_QUERY_DATA, new MessageListener () {

            @Override
            public void messageReceived ( final Message message ) throws Exception
            {
                ConnectionImpl.this.handleQueryData ( message );
            }
        } );
    }

    protected void handleQueryData ( final Message message )
    {
        final Long queryId = queryIdFromMessage ( message );
        if ( queryId == null )
        {
            logger.warn ( "Query update without query id" );
            return;
        }

        synchronized ( this )
        {
            final QueryImpl query = this.queries.get ( queryId );
            if ( query == null )
            {
                logger.warn ( "Unknown query {}", queryId );
                return;
            }
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    query.handleData ( EventMessageHelper.fromValue ( message.getValues ().get ( "data" ) ) );
                }
            } );
        }

        this.messenger.sendMessage ( MessageCreator.createACK ( message ) );
    }

    protected void handleQueryStateChange ( final Message message )
    {
        final Long queryId = queryIdFromMessage ( message );
        if ( queryId == null )
        {
            logger.warn ( "Query update without query id" );
            return;
        }

        final QueryState state = queryStateFromMessage ( message );
        if ( state == null )
        {
            logger.warn ( "Query update without query state" );
            return;
        }

        final String error;
        {
            final Value errorValue = message.getValues ().get ( "error" );
            error = errorValue != null ? errorValue.toString () : null;
        }

        synchronized ( this )
        {
            final QueryImpl query = this.queries.get ( queryId );
            if ( query == null )
            {
                logger.warn ( "Unknown query {}", queryId );
                return;
            }
            switch ( state )
            {
                case DISCONNECTED:
                    // dispose if we are disconnected
                    this.queries.remove ( queryId );
                    this.executor.execute ( new Runnable () {

                        @Override
                        public void run ()
                        {
                            query.dispose ();
                        }
                    } );
                    break;
                default:
                    fireQueryStateChange ( query, state, error != null ? new RuntimeException ( error ).fillInStackTrace () : null );
                    break;
            }

        }
    }

    /**
     * Extract the query state from the message
     * 
     * @param message
     *            the message
     * @return the extracted query state or <code>null</code> if there was none
     */
    private QueryState queryStateFromMessage ( final Message message )
    {
        QueryState state = null;
        {
            final Value value = message.getValues ().get ( "state" );
            if ( value instanceof StringValue )
            {
                state = QueryState.valueOf ( ( (StringValue)value ).getValue () );
            }
        }
        return state;
    }

    /**
     * Extract the query id from the message
     * 
     * @param message
     *            the message
     * @return the extracted query id or <code>null</code> if there was none
     */
    private Long queryIdFromMessage ( final Message message )
    {
        Long queryId = null;
        {
            final Value value = message.getValues ().get ( MESSAGE_QUERY_ID );
            if ( value instanceof LongValue )
            {
                queryId = ( (LongValue)value ).getValue ();
            }
        }
        return queryId;
    }

    protected synchronized void handleBrowserUpdate ( final Message message )
    {
        final List<BrowserEntry> added = BrowserMessageHelper.fromValue ( message.getValues ().get ( "added" ) );
        final Set<String> removed = BrowserMessageHelper.fromValueRemoved ( message.getValues ().get ( "removed" ) );
        final boolean full = message.getValues ().containsKey ( "full" );

        // perform update
        if ( full )
        {
            this.browserCache.clear ();
        }
        if ( removed != null )
        {
            for ( final String id : removed )
            {
                this.browserCache.remove ( id );
            }
        }
        if ( added != null )
        {
            for ( final BrowserEntry entry : added )
            {
                this.browserCache.put ( entry.getId (), entry );
            }
        }
        fireBrowserListener ( added, removed, full );
    }

    protected synchronized void handleEventData ( final Message message )
    {
        String queryId = null;
        {
            final Value value = message.getValues ().get ( MESSAGE_QUERY_ID );
            if ( value instanceof StringValue )
            {
                queryId = ( (StringValue)value ).getValue ();
            }
        }

        final List<Event> data = EventMessageHelper.fromValue ( message.getValues ().get ( "events" ) );

        if ( queryId != null && data != null )
        {
            EventListener listener;
            synchronized ( this.eventListeners )
            {
                listener = this.eventListeners.get ( queryId );
            }
            fireEventDataChange ( listener, data );
        }

        this.messenger.sendMessage ( MessageCreator.createACK ( message ) );
    }

    private void fireEventDataChange ( final EventListener listener, final List<Event> data )
    {
        logger.debug ( "Received: {} events", data.size () );

        if ( listener == null )
        {
            return;
        }

        try
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.dataChanged ( data );
                }
            } );

        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to notify", e );
        }
    }

    protected synchronized void handleConditionData ( final Message message )
    {
        try
        {
            logger.debug ( "Got condition data" );

            String queryId = null;
            {
                final Value value = message.getValues ().get ( MESSAGE_QUERY_ID );
                if ( value instanceof StringValue )
                {
                    queryId = ( (StringValue)value ).getValue ();
                }
            }

            final List<MonitorStatusInformation> data = MonitorMessageHelper.fromValue ( message.getValues ().get ( "conditions.addedOrUpdated" ) );
            final Set<String> removed = MonitorMessageHelper.fromValueRemoved ( message.getValues ().get ( "conditions.removed" ) );

            if ( queryId != null && ( data != null || removed != null ) )
            {
                final MonitorListener listener = this.monitorListeners.get ( queryId );
                fireConditionDataChange ( listener, data, removed, false );
            }
            else
            {
                logger.info ( "Nothing to notify" );
            }
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to handle condition data", e );
        }

    }

    private void fireConditionDataChange ( final MonitorListener listener, final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        if ( listener == null )
        {
            logger.warn ( "Condition change data without a listener" );
            return;
        }

        try
        {
            logger.debug ( "notify condition data change" );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.dataChanged ( addedOrUpdated, removed, full );
                }
            } );

        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to notify", e );
        }
    }

    protected synchronized void handleEventStatus ( final Message message )
    {

        String queryId = null;
        {
            final Value value = message.getValues ().get ( MESSAGE_QUERY_ID );
            if ( value instanceof StringValue )
            {
                queryId = ( (StringValue)value ).getValue ();
            }
        }

        SubscriptionState status = null;
        {
            final Value value = message.getValues ().get ( "status" );
            if ( value instanceof StringValue )
            {
                final String statusString = ( (StringValue)value ).getValue ();
                status = SubscriptionState.valueOf ( statusString );
            }
        }

        if ( queryId != null && status != null )
        {
            logger.debug ( "event status change: {} -> {}", new Object[] { queryId, status } );
            final EventListener listener = this.eventListeners.get ( queryId );
            fireEventStatusChange ( listener, status );
        }
    }

    protected synchronized void handleConditionStatus ( final Message message )
    {
        String queryId = null;
        {
            final Value value = message.getValues ().get ( MESSAGE_QUERY_ID );
            if ( value instanceof StringValue )
            {
                queryId = ( (StringValue)value ).getValue ();
            }
        }

        SubscriptionState status = null;
        {
            final Value value = message.getValues ().get ( "status" );
            if ( value instanceof StringValue )
            {
                final String statusString = ( (StringValue)value ).getValue ();
                status = SubscriptionState.valueOf ( statusString );
            }
        }

        if ( queryId != null && status != null )
        {
            final MonitorListener listener = this.monitorListeners.get ( queryId );
            fireConditionStatusChange ( listener, status );
        }
    }

    public Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public synchronized Query createQuery ( final String queryType, final String queryData, final QueryListener listener )
    {
        if ( !isConnected () )
        {
            // FIXME: return disconnected query
            return null;
        }

        // search for a new query id
        Long l;
        do
        {
            l = this.random.nextLong ();
        } while ( this.queries.containsValue ( l ) );

        logger.debug ( "Using new query id: {}" );

        // create new query
        final QueryImpl query = new QueryImpl ( this, l, listener );
        this.queries.put ( l, query );

        // fire state change
        fireQueryStateChange ( query, QueryState.CONNECTING, null );

        // send create request
        sendCreateQuery ( l, queryType, queryData );

        return query;
    }

    private void sendCreateQuery ( final long queryId, final String queryType, final String queryData )
    {
        final Message message = new Message ( Messages.CC_QUERY_CREATE );

        message.getValues ().put ( MESSAGE_QUERY_ID, new LongValue ( queryId ) );
        message.getValues ().put ( "queryType", new StringValue ( queryType ) );
        message.getValues ().put ( "queryData", new StringValue ( queryData ) );

        this.messenger.sendMessage ( message );
    }

    @Override
    public synchronized void setMonitorListener ( final String conditionQueryId, final MonitorListener listener )
    {
        if ( listener == null )
        {
            clearConditionListener ( conditionQueryId );
        }
        else
        {
            updateConditionListener ( conditionQueryId, listener );
        }
    }

    private void updateConditionListener ( final String conditionQueryId, final MonitorListener listener )
    {
        MonitorListener oldListener;

        oldListener = this.monitorListeners.put ( conditionQueryId, listener );
        if ( oldListener == listener )
        {
            return;
        }

        if ( oldListener != null )
        {
            // notify old listener first
            fireConditionStatusChange ( oldListener, SubscriptionState.DISCONNECTED );
        }
        else
        {
            // request data
            sendSubscribeConditions ( conditionQueryId, true );
        }

        // initially send DISCONNECTED
        fireConditionStatusChange ( listener, SubscriptionState.DISCONNECTED );
    }

    private void clearConditionListener ( final String conditionQueryId )
    {
        MonitorListener oldListener;

        oldListener = this.monitorListeners.remove ( conditionQueryId );
        if ( oldListener != null )
        {
            sendSubscribeConditions ( conditionQueryId, false );
        }
        if ( oldListener != null )
        {
            fireConditionStatusChange ( oldListener, SubscriptionState.DISCONNECTED );
        }
    }

    /**
     * Send a message to request (un)subscription
     * 
     * @param conditionQueryId
     *            the condition query id
     * @param flag
     *            <code>true</code> for subscription, <code>false</code>
     *            otherwise
     */
    private void sendSubscribeConditions ( final String conditionQueryId, final boolean flag )
    {
        logger.info ( "Requesting conditions: " + conditionQueryId + "/" + flag );

        final Message message = new Message ( flag ? Messages.CC_SUBSCRIBE_CONDITIONS : Messages.CC_UNSUBSCRIBE_CONDITIONS );

        message.getValues ().put ( MESSAGE_QUERY_ID, new StringValue ( conditionQueryId ) );

        this.messenger.sendMessage ( message );
    }

    private void fireConditionStatusChange ( final MonitorListener listener, final SubscriptionState status )
    {
        if ( listener == null )
        {
            return;
        }

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                listener.statusChanged ( status );
            }
        } );
    }

    @Override
    public synchronized void setEventListener ( final String eventQueryId, final EventListener listener )
    {
        if ( listener == null )
        {
            clearEventListener ( eventQueryId );
        }
        else
        {
            updateEventListener ( eventQueryId, listener );
        }
    }

    private void updateEventListener ( final String eventQueryId, final EventListener listener )
    {
        EventListener oldListener;

        oldListener = this.eventListeners.put ( eventQueryId, listener );
        if ( oldListener == listener )
        {
            return;
        }

        if ( oldListener != null )
        {
            // notify old listener first
            fireEventStatusChange ( oldListener, SubscriptionState.DISCONNECTED );
        }
        else
        {
            // request data
            sendSubscribeEventQuery ( eventQueryId, true );
        }

        // initially send DISCONNECTED
        fireEventStatusChange ( listener, SubscriptionState.DISCONNECTED );
    }

    private void clearEventListener ( final String eventQueryId )
    {
        final EventListener oldListener = this.eventListeners.remove ( eventQueryId );
        if ( oldListener != null )
        {
            sendSubscribeEventQuery ( eventQueryId, false );
        }
        if ( oldListener != null )
        {
            fireEventStatusChange ( oldListener, SubscriptionState.DISCONNECTED );
        }
    }

    private void fireEventStatusChange ( final EventListener listener, final SubscriptionState status )
    {
        if ( listener == null )
        {
            return;
        }

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                listener.statusChanged ( status );
            }
        } );
    }

    /**
     * Send a message to request (un)subscription
     * 
     * @param eventQueryId
     *            the event query id
     * @param flag
     *            <code>true</code> for subscription, <code>false</code>
     *            otherwise
     */
    private void sendSubscribeEventQuery ( final String eventQueryId, final boolean flag )
    {
        final Message message = new Message ( flag ? Messages.CC_SUBSCRIBE_EVENT_POOL : Messages.CC_UNSUBSCRIBE_EVENT_POOL );

        message.getValues ().put ( MESSAGE_QUERY_ID, new StringValue ( eventQueryId ) );

        this.messenger.sendMessage ( message );
    }

    @Override
    protected synchronized void onConnectionBound ()
    {
        super.onConnectionBound ();

        for ( final String key : this.eventListeners.keySet () )
        {
            sendSubscribeEventQuery ( key, true );
        }
        for ( final String key : this.monitorListeners.keySet () )
        {
            sendSubscribeConditions ( key, true );
        }
    }

    @Override
    public synchronized void sessionClosed ( final IoSession session ) throws Exception
    {
        // set states to DISCONNECTED
        for ( final MonitorListener listener : this.monitorListeners.values () )
        {
            fireConditionStatusChange ( listener, SubscriptionState.DISCONNECTED );
        }
        for ( final EventListener listener : this.eventListeners.values () )
        {
            fireEventStatusChange ( listener, SubscriptionState.DISCONNECTED );
        }
        for ( final QueryImpl query : this.queries.values () )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    query.dispose ();
                }
            } );
        }
        this.queries.clear ();

        this.browserCache.clear ();
        fireBrowserListener ( null, null, true );

        super.sessionClosed ( session );
    }

    private void fireQueryStateChange ( final QueryImpl query, final QueryState state, final Throwable error )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                query.handleStateChange ( state, error );
            }
        } );
    }

    @Override
    public synchronized void addBrowserListener ( final BrowserListener listener )
    {
        if ( listener == null )
        {
            return;
        }

        if ( this.browserListeners.add ( listener ) )
        {
            final List<BrowserEntry> addedOrChanged = new ArrayList<BrowserEntry> ( this.browserCache.values () );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.dataChanged ( addedOrChanged, null, true );
                }
            } );

        }
    }

    @Override
    public synchronized void removeBrowserListener ( final BrowserListener listener )
    {
        if ( listener == null )
        {
            return;
        }
        this.browserListeners.remove ( listener );
    }

    protected void fireBrowserListener ( final List<BrowserEntry> added, final Set<String> removed, final boolean full )
    {
        final Set<BrowserListener> listeners = new HashSet<BrowserListener> ( this.browserListeners );

        if ( listeners.isEmpty () )
        {
            return;
        }

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {

                for ( final BrowserListener listener : listeners )
                {
                    try
                    {
                        listener.dataChanged ( added, removed, full );
                    }
                    catch ( final Throwable e )
                    {
                        logger.warn ( "Failed to notify browser change", e );
                    }
                }

            }
        } );
    }

    @Override
    public NotifyFuture<Void> acknowledge ( final String monitorId, final Date aknTimestamp, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        logger.debug ( "Sending ACK: {} / {}", new Object[] { monitorId, aknTimestamp } );

        final Message message = new Message ( Messages.CC_CONDITION_AKN );
        message.getValues ().put ( "id", new StringValue ( monitorId ) );
        // if we don't have a timestamp provided use current time
        if ( aknTimestamp != null )
        {
            message.getValues ().put ( "aknTimestamp", new LongValue ( aknTimestamp.getTime () ) );
        }
        else
        {
            message.getValues ().put ( "aknTimestamp", new LongValue ( System.currentTimeMillis () ) );
        }

        MessageHelper.encodeOperationParameters ( operationParameters, message );

        final MessageFuture<Void> messageListenerer = new MessageFuture<Void> () {
            @Override
            protected Void process ( final Message message ) throws Exception
            {
                return null;
            }
        };

        this.messenger.sendMessage ( message, messageListenerer );

        return messageListenerer;
    }

    public synchronized void closeQuery ( final long queryId )
    {
        final QueryImpl query = this.queries.get ( queryId );
        if ( query == null )
        {
            logger.warn ( "Query {} closed", queryId );
            return;
        }
        sendCloseQuery ( queryId );
    }

    private void sendCloseQuery ( final long queryId )
    {
        final Message message = new Message ( Messages.CC_QUERY_CLOSE );

        message.getValues ().put ( MESSAGE_QUERY_ID, new LongValue ( queryId ) );

        this.messenger.sendMessage ( message );
    }

    public synchronized void loadMore ( final long queryId, final int count )
    {
        final QueryImpl query = this.queries.get ( queryId );
        if ( query == null )
        {
            logger.warn ( "Query {} closed", queryId );
            return;
        }
        sendLoadMoreQuery ( queryId, count );
    }

    private void sendLoadMoreQuery ( final long queryId, final int count )
    {
        final Message message = new Message ( Messages.CC_QUERY_LOAD_MORE );

        message.getValues ().put ( MESSAGE_QUERY_ID, new LongValue ( queryId ) );
        message.getValues ().put ( "count", new IntegerValue ( count ) );

        this.messenger.sendMessage ( message );
    }
}
