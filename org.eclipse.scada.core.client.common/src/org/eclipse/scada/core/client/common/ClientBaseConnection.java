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
package org.eclipse.scada.core.client.common;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.net.ssl.SSLSession;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.client.PrivilegeListener;
import org.eclipse.scada.protocol.common.IoLoggerFilterChainBuilder;
import org.eclipse.scada.protocol.common.StatisticsFilter;
import org.eclipse.scada.sec.callback.CallbackFactory;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ClientBaseConnection extends BaseConnection implements Connection
{

    private final static Logger logger = LoggerFactory.getLogger ( ClientBaseConnection.class );

    private static final Object STATS_CURRENT_STATE = new Object ();

    private static final Object STATS_CONNECT_CALLS = new Object ();

    private static final Object STATS_DISCONNECT_CALLS = new Object ();

    private static final Object STATS_MESSAGES_SENT = new Object ();

    private static final Object STATS_MESSAGES_RECEIVED = new Object ();

    private static final Object STATS_CREATION_TIMESTAMP = new Object ();

    private static final Object STATS_LAST_CONNECT_TIMESTAMP = new Object ();

    private static final Object STATS_LAST_BOUND_TIMESTAMP = new Object ();

    private final NioSocketConnector connector;

    private volatile ConnectionState connectionState = ConnectionState.CLOSED;

    private InetAddress address;

    private ConnectFuture connectFuture;

    private IoSession session;

    private final StateNotifier stateNotifier;

    private final IoHandler handler;

    private final IoLoggerFilterChainBuilder chainBuilder;

    private final Set<PrivilegeListener> privilegeListeners = new LinkedHashSet<PrivilegeListener> ();

    private volatile Set<String> currentPrivileges;

    private final Object writeLock = new Object ();

    protected volatile CallbackHandler connectCallbackHandler;

    protected CallbackFactory callbackFactory;

    private volatile boolean disposed;

    public ClientBaseConnection ( final IoHandlerFactory handlerFactory, final IoLoggerFilterChainBuilder chainBuilder, final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( connectionInformation );

        this.stateNotifier = new StateNotifier ( this.executor, this );

        this.handler = handlerFactory.create ( this );

        this.connector = new NioSocketConnector ();

        this.chainBuilder = chainBuilder;
        this.chainBuilder.setLoggerName ( ClientBaseConnection.class.getName () + ".protocol" );

        this.connector.setFilterChainBuilder ( this.chainBuilder );
        this.connector.setHandler ( this.handler );

        this.statistics.setLabel ( STATS_CURRENT_STATE, "Numeric connection state" );
        this.statistics.setLabel ( STATS_CONNECT_CALLS, "Calls to connect" );
        this.statistics.setLabel ( STATS_DISCONNECT_CALLS, "Calls to disconnect" );

        this.statistics.setLabel ( STATS_MESSAGES_SENT, "Messages sent" );
        this.statistics.setLabel ( STATS_MESSAGES_RECEIVED, "Messages received" );

        this.statistics.setLabel ( STATS_CREATION_TIMESTAMP, "Timestamp of creation (in seconds)" );
        this.statistics.setCurrentValue ( STATS_CREATION_TIMESTAMP, Math.floor ( System.currentTimeMillis () / 1000 ) );

        this.statistics.setLabel ( STATS_LAST_CONNECT_TIMESTAMP, "Timestamp of last CONNECT (in seconds)" );
        this.statistics.setLabel ( STATS_LAST_BOUND_TIMESTAMP, "Timestamp of last BOUND (in seconds)" );
    }

    @Override
    public void setCallbackFactory ( final CallbackFactory callbackFactory )
    {
        this.callbackFactory = callbackFactory;
    }

    @Override
    public void connect ()
    {
        this.statistics.changeCurrentValue ( STATS_CONNECT_CALLS, 1 );
        switchState ( ConnectionState.CONNECTING, null );
    }

    @Override
    public void connect ( final CallbackHandler callbackHandler )
    {
        this.connectCallbackHandler = callbackHandler;
        connect ();
    }

    @Override
    public void disconnect ()
    {
        this.statistics.changeCurrentValue ( STATS_DISCONNECT_CALLS, 1 );
        switchState ( ConnectionState.CLOSING, null );
    }

    protected synchronized void switchState ( final ConnectionState state, final Throwable error )
    {
        logger.debug ( "Switching state : {} -> {}", this.connectionState, state );

        final ConnectionState oldState = this.connectionState;
        if ( oldState == state )
        {
            return;
        }

        switch ( oldState )
        {
            case CLOSED:
                switchFromClosed ( state, error );
                break;
            case CONNECTED:
                switchFromConnected ( state, error );
                break;
            case CONNECTING:
                switchFromConnecting ( state, error );
                break;
            case BOUND:
                switchFromBound ( state, error );
                break;
            case CLOSING:
                break;
            case LOOKUP:
                switchFromLookup ( state, error );
                break;
        }
    }

    private void switchFromConnecting ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSED:
                performDisconnected ( error );
                break;
            case CONNECTED:
                handleConnected ();
                break;
            case CLOSING:
                requestClose ();
                break;
        }
    }

    private void handleConnected ()
    {
        this.statistics.setCurrentValue ( STATS_LAST_CONNECT_TIMESTAMP, Math.floor ( System.currentTimeMillis () / 1000 ) );

        setState ( ConnectionState.CONNECTED, null );
        onConnectionConnected ();
    }

    /**
     * Called when the connection got bound
     * <p>
     * This method is called while the connection lock is held.
     * </p>
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    protected void onConnectionBound ()
    {
    }

    /**
     * Called when the connection got connected
     * <p>
     * This method is called while the connection lock is held.
     * </p>
     * <p>
     * The default implementation switches directly to
     * {@link ConnectionState#BOUND}
     * </p>
     */
    protected void onConnectionConnected ()
    {
        switchState ( ConnectionState.BOUND, null );
    }

    /**
     * Called when the connection got closed
     * <p>
     * This method is called while the connection lock is held.
     * </p>
     * <p>
     * The default implementation does nothing.
     * </p>
     */
    protected void onConnectionClosed ()
    {
        this.connectCallbackHandler = null;
        firePrivilegeChange ( Collections.<String> emptySet () );
    }

    private void switchFromBound ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSING:
                requestClose ();
                break;
            case CLOSED:
                performDisconnected ( error );
                break;
        }
    }

    private void switchFromLookup ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSED:
                //$FALL-THROUGH$
            case CLOSING:
                performDisconnected ( error );
                break;
        }
    }

    private void switchFromConnected ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CLOSING:
                requestClose ();
                break;
            case CLOSED:
                performDisconnected ( error );
                break;
            case BOUND:
                performBound ();
                break;
        }
    }

    private void performBound ()
    {
        this.connectCallbackHandler = null;
        this.statistics.setCurrentValue ( STATS_LAST_BOUND_TIMESTAMP, Math.floor ( System.currentTimeMillis () / 1000 ) );

        setState ( ConnectionState.BOUND, null );
        onConnectionBound ();
    }

    private void requestClose ()
    {
        if ( this.session != null )
        {
            this.session.close ( false );
        }
        else
        {
            logger.debug ( "We have no session. Perform disconnected instead!" );
            performDisconnected ( null );
        }
    }

    protected synchronized void performDisconnected ( final Throwable error )
    {
        this.connectCallbackHandler = null;

        if ( this.session != null )
        {
            this.session.close ( true );
            this.session.removeAttribute ( StatisticsFilter.STATS_KEY );
            this.session = null;
        }
        setState ( ConnectionState.CLOSED, error );
        onConnectionClosed ();
    }

    private void switchFromClosed ( final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case CONNECTING:
                initConnect ();
                break;
        }
    }

    private void initConnect ()
    {
        if ( this.address == null )
        {
            beginLookup ();
        }
        else
        {
            startConnect ();
        }
    }

    private synchronized void startConnect ()
    {
        setState ( ConnectionState.CONNECTING, null );
        this.connectFuture = this.connector.connect ( new InetSocketAddress ( this.address, this.connectionInformation.getSecondaryTarget () ) );
        this.connectFuture.addListener ( new IoFutureListener<ConnectFuture> () {

            @Override
            public void operationComplete ( final ConnectFuture future )
            {
                handleConnectComplete ( future );
            }
        } );
    }

    protected synchronized void handleConnectComplete ( final ConnectFuture future )
    {
        if ( this.connectFuture != future )
        {
            logger.warn ( "handleConnectComplete got called with wrong future - current: {}, called: {}", this.connectFuture, future );
            return;
        }

        this.connectFuture = null;

        final Throwable error = future.getException ();
        if ( error != null )
        {
            setState ( ConnectionState.CLOSED, error );
            return;
        }

        try
        {
            setSession ( future.getSession () );
        }
        catch ( final Throwable e )
        {
            setState ( ConnectionState.CLOSED, e );
        }
    }

    private void setSession ( final IoSession session )
    {
        if ( this.session != null )
        {
            logger.warn ( "Failed to set session ... there is still one set" );
        }
        this.session = session;
        this.session.setAttribute ( StatisticsFilter.STATS_KEY, this.statistics );
    }

    private void beginLookup ()
    {
        setState ( ConnectionState.LOOKUP, null );

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                performLookup ( ClientBaseConnection.this.connectionInformation.getTarget () );
            }
        } );
    }

    private void performLookup ( final String host )
    {
        logger.info ( "Beginning lookup of '{}'", host );

        final InetAddress address;
        try
        {
            address = InetAddress.getByName ( host );
        }
        catch ( final Throwable e )
        {
            endLookup ( null, e );
            return;
        }

        try
        {
            endLookup ( address, null );
        }
        catch ( final Throwable e )
        {
            setState ( ConnectionState.CLOSED, e );
        }
    }

    private synchronized void endLookup ( final InetAddress address, final Throwable error )
    {
        logger.debug ( "endLookup - address: {}, error: {}", address, error );

        if ( this.connectionState != ConnectionState.LOOKUP )
        {
            logger.warn ( "Lookup ended but we are not tryining to connet anymore. Might be OK if somebody disconnected." );
            return;
        }

        if ( address != null )
        {
            this.address = address;
            // trigger connect
            startConnect ();
        }
        else
        {
            setState ( ConnectionState.CLOSED, error );
        }
    }

    public boolean isDisposed ()
    {
        return this.disposed;
    }

    @Override
    public synchronized void dispose ()
    {
        this.disposed = true;

        performDisconnected ( null );

        // no state notifications after this call
        this.stateNotifier.dispose ();

        this.connector.dispose ();
        super.dispose ();
    }

    protected synchronized void setState ( final ConnectionState connectionState, final Throwable error )
    {
        logger.debug ( "Setting state - {} -> {}", this.connectionState, connectionState );

        this.statistics.setCurrentValue ( STATS_CURRENT_STATE, connectionState.ordinal () );

        if ( this.connectionState == connectionState )
        {
            return;
        }

        this.connectionState = connectionState;

        this.stateNotifier.fireConnectionStateChange ( connectionState, error );
    }

    @Override
    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.stateNotifier.addConnectionStateListener ( connectionStateListener );
    }

    @Override
    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.stateNotifier.removeConnectionStateListener ( connectionStateListener );
    }

    @Override
    public ConnectionState getState ()
    {
        return this.connectionState;
    }

    protected synchronized void performClosed ( final IoSession session, final Throwable error )
    {
        if ( this.session == null )
        {
            logger.debug ( "We seem already closed" );
        }
        else if ( this.session != session )
        {
            logger.warn ( "Received 'closed' from wrong session" );
            return;
        }
        performDisconnected ( error );
    }

    public synchronized void performOpened ( final IoSession session )
    {
        if ( this.session != session )
        {
            logger.warn ( "Received 'opened' from wrong session" );
            return;
        }
        switchState ( ConnectionState.CONNECTED, null );
    }

    public synchronized void messageReceived ( final IoSession session, final Object message )
    {
        logger.trace ( "Received message: {}", message );

        if ( this.session != session )
        {
            logger.warn ( "Received 'message' from wrong session (current: {}, message: {})", this.session, session );
            return;
        }
        this.statistics.changeCurrentValue ( STATS_MESSAGES_RECEIVED, 1 );
        handleMessage ( message );
    }

    /**
     * Handle a message that came in by the current session.
     * <p>
     * Note that the method is called while holding the lock the connection
     * itself.
     * </p>
     * 
     * @param message
     *            the received message
     */
    protected abstract void handleMessage ( final Object message );

    /**
     * Send a message if a connection exists
     * <p>
     * Works like {@link #sendMessage(Object)}, but the connection is not
     * established it will throw an exception instead of silently ignoring the
     * fact.
     * </p>
     * 
     * @param message
     *            the message to send
     * @throws NoConnectionException
     *             thrown in case no connection currently exists
     */
    protected synchronized void sendMessageChecked ( final Object message ) throws NoConnectionException
    {
        logger.debug ( "Sending message: {}", message );

        if ( this.session == null )
        {
            logger.warn ( "Failed to send message without connection: {}", message );
            throw new NoConnectionException ();
        }

        if ( getState () != ConnectionState.BOUND && getState () != ConnectionState.CONNECTED )
        {
            logger.warn ( "Tried to send message in wrong connection state ({}): {}", getState (), message );
            throw new NoConnectionException ();
        }

        processSendMessage ( message );
    }

    protected synchronized void sendMessage ( final Object message )
    {
        logger.debug ( "Sending message: {}", message );

        if ( this.session == null )
        {
            logger.warn ( "Failed to send message without connection: {}", message );
            return;
        }

        if ( getState () != ConnectionState.BOUND && getState () != ConnectionState.CONNECTED )
        {
            logger.warn ( "Tried to send message in wrong connection state ({}): {}", getState (), message );
            return;
        }

        processSendMessage ( message );
    }

    private void processSendMessage ( final Object message )
    {
        this.statistics.changeCurrentValue ( STATS_MESSAGES_SENT, 1 );

        synchronized ( this.writeLock )
        {
            // only one thread may write at a time, otherwise MINA's filters may get corrupted
            // also see https://issues.apache.org/jira/browse/DIRMINA-653
            this.session.write ( message );
        }
    }

    public SSLSession getSslSession ()
    {
        final IoSession session = this.session;
        if ( session == null )
        {
            return null;
        }
        final Object sslSession = session.getAttribute ( SslFilter.SSL_SESSION );

        if ( sslSession instanceof SSLSession )
        {
            return (SSLSession)sslSession;
        }
        else
        {
            return null;
        }
    }

    @Override
    public synchronized void addPrivilegeListener ( final PrivilegeListener listener )
    {
        if ( this.privilegeListeners.add ( listener ) )
        {
            final Set<String> granted = this.currentPrivileges;
            // send current state
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.privilegesChanged ( granted );
                }
            } );
        }
    }

    @Override
    public synchronized void removePrivilegeListener ( final PrivilegeListener listener )
    {
        this.privilegeListeners.remove ( listener );
    }

    @Override
    public Set<String> getPrivileges ()
    {
        return Collections.unmodifiableSet ( this.currentPrivileges );
    }

    /*
     * Must only be called from the IO loop
     */
    protected synchronized void firePrivilegeChange ( final Set<String> granted )
    {
        this.currentPrivileges = granted;

        for ( final PrivilegeListener listener : this.privilegeListeners )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.privilegesChanged ( granted );
                }
            } );
        }
    }

    protected IoSession getSession ()
    {
        return this.session;
    }
}
