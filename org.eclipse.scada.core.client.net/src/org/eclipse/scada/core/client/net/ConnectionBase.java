/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.client.net;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.core.info.StatisticsProvider;
import org.eclipse.scada.core.net.ConnectionHelper;
import org.eclipse.scada.net.base.PingService;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.IoSessionSender;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.net.mina.SocketImpl;
import org.eclipse.scada.sec.callback.CallbackFactory;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ConnectionBase implements Connection, IoHandler, StatisticsProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionBase.class );

    private static final Object STATS_PINGS_SENT = new Object ();

    private static final Object STATS_SESSION_BYTES_READ = new Object ();

    private static final Object STATS_SESSION_BYTES_WRITTEN = new Object ();

    private static final Object STATS_CALLS_CONNECT = new Object ();

    private static final Object STATS_CALLS_DISCONNECT = new Object ();

    private static final Object STATS_NUMERIC_STATE = new Object ();

    private final Set<ConnectionStateListener> connectionStateListeners = new CopyOnWriteArraySet<ConnectionStateListener> ();

    private volatile ConnectionState connectionState = ConnectionState.CLOSED;

    private static final int DEFAULT_TIMEOUT = 10000;

    protected volatile IoSession session;

    protected final Messenger messenger;

    private final ConnectionInformation connectionInformation;

    private final IoConnector connector;

    private final PingService pingService;

    private ConnectFuture connectingFuture;

    private final ExecutorService lookupExecutor;

    private SocketAddress remoteAddress;

    private volatile Map<String, String> properties;

    protected final StatisticsImpl statistics = new StatisticsImpl ();

    public ConnectionBase ( final ConnectionInformation connectionInformation )
    {
        super ();
        this.connectionInformation = connectionInformation;

        // the lookup executor has at max one thread and kills this if idle for one minute
        this.lookupExecutor = new ThreadPoolExecutor ( 0, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable> (), new NamedThreadFactory ( "ConnectionBaseExecutor/" + connectionInformation.toMaskedString () ) );

        this.messenger = new Messenger ( getMessageTimeout (), this.statistics );

        this.pingService = new PingService ( this.messenger );

        this.connector = createConnector ();

        this.statistics.setLabel ( STATS_PINGS_SENT, "Pings sent" );
        this.statistics.setLabel ( STATS_SESSION_BYTES_READ, "Bytes read in session" );
        this.statistics.setLabel ( STATS_SESSION_BYTES_WRITTEN, "Bytes written in session" );

        this.statistics.setLabel ( STATS_CALLS_CONNECT, "Calls to connect" );
        this.statistics.setLabel ( STATS_CALLS_DISCONNECT, "Calls to disconnect" );

        this.statistics.setLabel ( STATS_NUMERIC_STATE, "Numeric state" );
    }

    @Override
    public void setCallbackFactory ( final CallbackFactory callbackFactory )
    {
        // no-op
    }

    protected synchronized void switchState ( final ConnectionState state, final Throwable error, final Map<String, String> properties )
    {
        logger.debug ( "Requesting state switch {} -> {}", this.connectionState, state );
        if ( this.connectionState == state )
        {
            logger.info ( "We already are in state: {}", state );
            return;
        }

        switch ( this.connectionState )
        {
            case CLOSED:
                handleSwitchClosed ( state );
                break;
            case CONNECTING:
                handleSwitchConnecting ( state, error );
                break;
            case CONNECTED:
                handleSwitchConnected ( state, error, properties );
                break;
            case BOUND:
                handleSwitchBound ( state, error );
                break;
            case CLOSING:
                handleSwitchClosing ( state, error );
                break;
            case LOOKUP:
                handleSwitchLookup ( state, error );
                break;
        }
    }

    /**
     * Handle when we are in state LOOKUP
     * 
     * @param state
     *            the target state
     */

    private void handleSwitchLookup ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CONNECTING:
                performConnect ();
                break;
            case CLOSED:
                requestClose ( error );
                break;
            case CLOSING:
                requestClose ( error );
                break;
            default:
                break;
        }
    }

    /**
     * Handle when we are in state CLOSING
     * 
     * @param state
     *            the target state
     */

    private void handleSwitchClosing ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSED:
                requestClose ( error );
                onConnectionClosed ();
                break;
            default:
                break;
        }
    }

    /**
     * Handle when we are in state BOUND
     * 
     * @param state
     *            the target state
     */

    private void handleSwitchBound ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSING:
                requestClose ( error );
                onConnectionClosed ();
                break;
            case CLOSED:
                requestClose ( error );
                onConnectionClosed ();
                break;
            default:
                break;
        }
    }

    /**
     * Handle when we are in state CONNECTED
     * 
     * @param state
     *            the target state
     */

    private void handleSwitchConnected ( final ConnectionState state, final Throwable error, final Map<String, String> properties )
    {
        switch ( state )
        {
            case CLOSING:
                requestClose ( error );
                onConnectionClosed ();
                break;
            case CLOSED:
                requestClose ( error );
                onConnectionClosed ();
                break;
            case BOUND:
                this.properties = properties;
                setState ( ConnectionState.BOUND, error );
                onConnectionBound ();
                break;
            default:
                break;
        }
    }

    /**
     * We want to be closed ... maybe we already are
     * 
     * @param error
     */
    private void requestClose ( final Throwable error )
    {
        logger.debug ( "Performing close stuff" );
        try
        {
            this.messenger.disconnected ();

            if ( this.session != null )
            {
                this.session.close ( true );
            }

            this.session = null;
            this.connectingFuture = null;
            this.properties = null;
        }
        finally
        {
            setState ( ConnectionState.CLOSED, error );
        }
    }

    /**
     * Handle when we are in state CONNECTING
     * 
     * @param state
     *            the target state
     */
    private void handleSwitchConnecting ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSING:
                requestClose ( error );
                break;
            case CONNECTED:
                setState ( ConnectionState.CONNECTED, null );
                onConnectionEstablished ();
                break;
            case CLOSED:
                requestClose ( error );
                onConnectionClosed ();
                break;
            default:
                break;
        }
    }

    /**
     * Handle when we are in state CLOSED
     * 
     * @param state
     *            the target state
     */
    private void handleSwitchClosed ( final ConnectionState state )
    {
        switch ( state )
        {
            case CONNECTING:
                if ( this.remoteAddress != null )
                {
                    performConnect ();
                }
                else
                {
                    performLookup ();
                }
                break;
            default:
                break;
        }
    }

    /**
     * request a disconnect
     */
    @Override
    public void disconnect ()
    {
        this.statistics.changeCurrentValue ( STATS_CALLS_DISCONNECT, 1 );
        disconnect ( null );
    }

    /**
     * request a disconnect
     * 
     * @param error
     *            optionally the error that caused the request to close
     */
    protected void disconnect ( final Throwable error )
    {
        logger.info ( "Requested disconnect" );

        switchState ( ConnectionState.CLOSING, error, null );
    }

    @Override
    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    @Override
    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connectionStateListeners.add ( connectionStateListener );
    }

    @Override
    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connectionStateListeners.remove ( connectionStateListener );
    }

    @Override
    public ConnectionState getState ()
    {
        return this.connectionState;
    }

    /**
     * set new state internally
     * 
     * @param connectionState
     * @param error
     *            additional error information or <code>null</code> if we don't
     *            have an error.
     */
    private void setState ( final ConnectionState connectionState, final Throwable error )
    {
        boolean trigger = false;
        synchronized ( this )
        {
            if ( this.connectionState != connectionState )
            {
                this.statistics.setCurrentValue ( STATS_NUMERIC_STATE, connectionState.ordinal () );
                this.connectionState = connectionState;
                trigger = true;
            }
        }
        if ( trigger )
        {
            notifyStateChange ( connectionState, error );
        }
    }

    /**
     * Notify state change listeners
     * 
     * @param connectionState
     *            new state
     * @param error
     *            additional error information or <code>null</code> if we don't
     *            have an error.
     */
    private void notifyStateChange ( final ConnectionState connectionState, final Throwable error )
    {
        for ( final ConnectionStateListener listener : this.connectionStateListeners )
        {
            try
            {
                listener.stateChange ( this, connectionState, error );
            }
            catch ( final Exception e )
            {
                logger.info ( "Failed to handle state change", e );
            }
        }
    }

    protected void setupConnector ( final ConnectionInformation connectionInformation, final IoConnector connector )
    {
        // set connector timeout
        connector.setConnectTimeoutMillis ( getConnectTimeout () );

        // build filter chain
        ConnectionHelper.setupFilterChain ( connectionInformation, connector.getFilterChain (), true );
    }

    public boolean isConnected ()
    {
        return this.session != null;
    }

    @Override
    public void connect ( final CallbackHandler callbackHandler )
    {
        // this is unsupported for the "net" protocol
        connect ();
    }

    @Override
    public synchronized void connect ()
    {
        logger.debug ( "Requesting connect in state {}", this.connectionState );

        this.statistics.changeCurrentValue ( STATS_CALLS_CONNECT, 1 );

        if ( this.connectionState == ConnectionState.CLOSED )
        {
            switchState ( ConnectionState.CONNECTING, null, null );
        }
    }

    protected synchronized void performLookup ()
    {
        setState ( ConnectionState.LOOKUP, null );

        this.lookupExecutor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                doLookup ();
            }
        } );
    }

    protected void resolvedRemoteAddress ( final SocketAddress address, final Throwable e )
    {
        logger.debug ( "Completed resolving remote address: {}", address );
        if ( e != null )
        {
            logger.warn ( "Failed to resolve: " + address, e );
        }

        if ( this.connectionState != ConnectionState.LOOKUP )
        {
            logger.info ( "Connection state {} is not LOOKUP", this.connectionState );
            return;
        }
        synchronized ( this )
        {
            if ( this.connectionState != ConnectionState.LOOKUP )
            {
                logger.info ( "Connection state {} is not LOOKUP for the second time", this.connectionState );
                return;
            }
            if ( e == null )
            {
                // lookup successful ... re-trigger connecting
                this.remoteAddress = address;
                switchState ( ConnectionState.CONNECTING, null, null );
            }
            else
            {
                // lookup failed
                switchState ( ConnectionState.CLOSED, e, null );
            }
        }

    }

    protected synchronized void performConnect ()
    {
        setState ( ConnectionState.CONNECTING, null );

        try
        {
            this.connectingFuture = this.connector.connect ( this.remoteAddress );

            this.connectingFuture.addListener ( new IoFutureListener<ConnectFuture> () {

                @Override
                public void operationComplete ( final ConnectFuture future )
                {
                    logger.debug ( "Connect operation complete" );
                    try
                    {
                        future.getSession ();
                    }
                    catch ( final Throwable e )
                    {
                        logger.debug ( "Operation failed", e );
                        ConnectionBase.this.lookupExecutor.execute ( new Runnable () {
                            @Override
                            public void run ()
                            {
                                ConnectionBase.this.connectFailed ( future, e );
                            };
                        } );
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create future", e );
            connectFailed ( this.connectingFuture, e );
        }
    }

    /**
     * called when a connection attempt failed
     * 
     * @param future
     * @param e
     *            the error
     */
    protected synchronized void connectFailed ( final ConnectFuture future, final Throwable e )
    {
        String connection = "";
        if ( this.connectionInformation != null )
        {
            connection += " " + this.connectionInformation.toMaskedString ();
        }
        logger.info ( "Connection attempt failed" + connection, e );

        if ( future == this.connectingFuture )
        {
            this.connectingFuture = null;

            switchState ( ConnectionState.CLOSED, e, null );
        }
    }

    private String getSocketImpl ()
    {
        return this.connectionInformation.getProperties ().get ( "socketImpl" );
    }

    private IoConnector createConnector ()
    {
        final SocketImpl socketImpl = SocketImpl.fromName ( getSocketImpl () );

        final IoConnector connector = socketImpl.createConnector ();

        connector.setHandler ( this );

        setupConnector ( this.connectionInformation, connector );

        return connector;
    }

    /**
     * Cancel an open connection ... for debug purposes only
     */
    public void cancelConnection ()
    {
        this.session.close ( true );
    }

    protected void onConnectionClosed ()
    {
        this.pingService.stop ();
        this.properties = null;
    }

    protected void onConnectionEstablished ()
    {
        setBound ( new Properties () );
    }

    /**
     * Set the {@link ConnectionState#BOUND} including the session properties
     * 
     * @param properties
     */
    public void setBound ( final Properties properties )
    {
        logger.debug ( "Request BOUND state" );
        this.pingService.start ();
        switchState ( ConnectionState.BOUND, null, convertProperties ( properties ) );
    }

    /**
     * Convert properties to map
     * 
     * @param properties
     *            the properties to convert
     * @return the converted map
     */
    private Map<String, String> convertProperties ( final Properties properties )
    {
        if ( properties == null )
        {
            return null;
        }

        final Map<String, String> result = new HashMap<String, String> ( 1 );
        for ( final Map.Entry<Object, Object> entry : properties.entrySet () )
        {
            if ( entry.getKey () != null && entry.getValue () != null )
            {
                result.put ( entry.getKey ().toString (), entry.getValue ().toString () );
            }
        }
        return result;
    }

    protected void onConnectionBound ()
    {
    }

    @Override
    public synchronized void exceptionCaught ( final IoSession session, final Throwable cause ) throws Exception
    {
        logger.error ( String.format ( "Connection exception for connection: %s", this.connectionInformation != null ? this.connectionInformation.toMaskedString () : "<null>" ), cause );
        if ( session == this.session )
        {
            requestClose ( cause );
        }
    }

    @Override
    public void messageReceived ( final IoSession session, final Object message ) throws Exception
    {
        if ( session == this.session )
        {
            this.statistics.setCurrentValue ( STATS_SESSION_BYTES_READ, session.getReadBytes () );
            // only accept current session stuff
            if ( message instanceof Message )
            {
                this.messenger.messageReceived ( (Message)message );
            }
        }
    }

    @Override
    public void messageSent ( final IoSession session, final Object message ) throws Exception
    {
        this.statistics.setCurrentValue ( STATS_SESSION_BYTES_WRITTEN, session.getWrittenBytes () );
        this.statistics.setCurrentValue ( IoSessionSender.STATS_QUEUED_BYTES, session.getScheduledWriteBytes () );
    }

    @Override
    public synchronized void sessionClosed ( final IoSession session ) throws Exception
    {
        logger.info ( "Session closed: {}", session );
        if ( session == this.session )
        {
            switchState ( ConnectionState.CLOSED, null, null );
        }
    }

    @Override
    public synchronized void sessionCreated ( final IoSession session ) throws Exception
    {
        logger.info ( "Session created: {}", session );

        session.getConfig ().setReaderIdleTime ( getPingPeriod () / 1000 );

        final IoSessionConfig config = session.getConfig ();
        if ( config instanceof SocketSessionConfig )
        {
            final Integer sendBuffer = getSocketSendBufferSize ();
            if ( sendBuffer != null )
            {
                ( (SocketSessionConfig)config ).setSendBufferSize ( sendBuffer );
            }
            final Integer receiveBuffer = getSocketReceiveBufferSize ();
            if ( receiveBuffer != null )
            {
                ( (SocketSessionConfig)config ).setReceiveBufferSize ( receiveBuffer );
            }
        }

        if ( this.session == null )
        {
            this.session = session;
        }
        else
        {
            logger.error ( "Created a new session with an existing one! (existing: {})", this.session );
        }
    }

    @Override
    public void sessionIdle ( final IoSession session, final IdleStatus status ) throws Exception
    {
        logger.debug ( "Session idle: {} - {}", status, session );

        if ( session != this.session )
        {
            return;
        }

        this.pingService.sendPing ();
        this.statistics.changeCurrentValue ( STATS_PINGS_SENT, 1 );
    }

    @Override
    public synchronized void sessionOpened ( final IoSession session ) throws Exception
    {
        logger.info ( "Session opened: {}", session );

        if ( session == this.session )
        {
            this.messenger.connected ( new IoSessionSender ( session, this.statistics ) );

            switchState ( ConnectionState.CONNECTED, null, null );
        }
    }

    /**
     * get the timeout used for connecting to the remote host
     * 
     * @return the timeout in milliseconds
     */
    public int getConnectTimeout ()
    {
        return getIntProperty ( "connectTimeout", getIntProperty ( "timeout", DEFAULT_TIMEOUT ) );
    }

    public int getPingPeriod ()
    {
        return getIntProperty ( "pingPeriod", getIntProperty ( "timeout", DEFAULT_TIMEOUT ) / getIntProperty ( "pingFrequency", 3 ) );
    }

    public Integer getSocketReceiveBufferSize ()
    {
        return getIntProperty ( "socketReceiveBufferSize", Integer.getInteger ( "org.eclipse.scada.core.client.net.socketReceiveBufferSize", null ) );
    }

    public Integer getSocketSendBufferSize ()
    {
        return getIntProperty ( "socketSendBufferSize", Integer.getInteger ( "org.eclipse.scada.core.client.net.socketSendBufferSize", null ) );
    }

    public int getMessageTimeout ()
    {
        return getIntProperty ( "messageTimeout", getIntProperty ( "timeout", DEFAULT_TIMEOUT ) );
    }

    protected Integer getIntProperty ( final String propertyName, final Integer defaultValue )
    {
        try
        {
            final String timeout = this.connectionInformation.getProperties ().get ( propertyName );
            final int i = Integer.parseInt ( timeout );
            if ( i <= 0 )
            {
                return defaultValue;
            }
            return i;
        }
        catch ( final Throwable e )
        {
            return defaultValue;
        }
    }

    @Override
    protected void finalize () throws Throwable
    {
        logger.info ( "Finalized" );
        this.lookupExecutor.shutdown ();
        super.finalize ();
    }

    /**
     * Does the actual lookup
     */
    private void doLookup ()
    {
        try
        {
            final SocketImpl socketImpl = SocketImpl.fromName ( getSocketImpl () );
            final SocketAddress address = socketImpl.doLookup ( ConnectionBase.this.connectionInformation.getTarget (), ConnectionBase.this.connectionInformation.getSecondaryTarget () );
            ConnectionBase.this.resolvedRemoteAddress ( address, null );
        }
        catch ( final Throwable e )
        {
            ConnectionBase.this.resolvedRemoteAddress ( null, e );
        }
    }

    @Override
    public void dispose ()
    {
        disconnect ( null );
        this.lookupExecutor.shutdown ();
        this.connector.dispose ();
    }

    @Override
    public Map<String, String> getSessionProperties ()
    {
        final Map<String, String> properties = this.properties;
        if ( properties != null )
        {
            return Collections.unmodifiableMap ( properties );
        }
        else
        {
            return Collections.emptyMap ();
        }
    }

    @Override
    public Collection<StatisticEntry> getStatistics ()
    {
        return this.statistics.getEntries ();
    }

}
