/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.io;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.osgi.factory.DataItemFactory;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractConnectionDevice
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractConnectionDevice.class );

    protected static enum ConnectionState
    {
        CONNECTING,
        CONNECTED,
        DISCONNECTED;
    }

    protected final ScheduledExecutorService executor;

    protected final BundleContext context;

    protected final String id;

    protected final DataItemFactory itemFactory;

    private final String itemPrefix;

    private final AtomicBoolean disposed = new AtomicBoolean ( false );

    private String host;

    private Short port;

    private ConnectionState state = ConnectionState.DISCONNECTED;

    private final IoHandler handler = new IoHandler () {
        @Override
        public void exceptionCaught ( final IoSession session, final Throwable error ) throws Exception
        {
            handleExceptionCaught ( session, error );
        }

        @Override
        public void messageSent ( final IoSession session, final Object message ) throws Exception
        {
            handleMessageSent ( session, message );
        }

        @Override
        public void sessionCreated ( final IoSession session ) throws Exception
        {
            handleSessionCreated ( session );
        }

        @Override
        public void sessionClosed ( final IoSession session ) throws Exception
        {
            handleSessionClosed ( session );
        }

        @Override
        public void sessionIdle ( final IoSession session, final IdleStatus idleStatus ) throws Exception
        {
            handleSessionIdle ( session, idleStatus );
        }

        @Override
        public void sessionOpened ( final IoSession session ) throws Exception
        {
            handleSessionOpened ( session );
        }

        @Override
        public void messageReceived ( final IoSession session, final Object message ) throws Exception
        {
            handleMessageReceived ( session, message );
        }
    };

    private NioSocketConnector connector;

    private IoSession session;

    private final DataItemInputChained stateItem;

    private final DataItemInputChained connectionItem;

    private int connectTimeout;

    private String name;

    private boolean enabled;

    private final NioProcessor processor;

    private ScheduledExecutorService createdExecutor;

    public AbstractConnectionDevice ( final BundleContext context, final String id, final NioProcessor processor, final ScheduledExecutorService executor, final String itemPrefix )
    {
        this.id = id;
        this.processor = processor;
        this.context = context;
        this.itemPrefix = itemPrefix;
        this.executor = executor;
        this.itemFactory = new DataItemFactory ( context, executor, getItemId ( null ) );

        this.stateItem = this.itemFactory.createInput ( "state", Collections.<String, Variant> emptyMap () );
        this.connectionItem = this.itemFactory.createInput ( "connection", Collections.<String, Variant> emptyMap () );
    }

    public AbstractConnectionDevice ( final BundleContext context, final String id, final NioProcessor processor, final String threadPrefix, final String itemPrefix )
    {
        this ( context, id, processor, Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( threadPrefix + "/" + id ) ), itemPrefix );
        this.createdExecutor = this.executor;
    }

    public String getItemId ( final String localId )
    {
        if ( localId == null )
        {
            return this.itemPrefix + "." + this.id;
        }
        else
        {
            return this.itemPrefix + "." + this.id + "." + localId;
        }
    }

    public String getVarItemId ( final String localId )
    {
        String name = this.name;
        if ( name == null )
        {
            name = this.id;
        }

        return getItemId ( localId );
    }

    protected ScheduledExecutorService getExecutor ()
    {
        return this.executor;
    }

    public void dispose ()
    {
        if ( this.disposed.compareAndSet ( false, true ) )
        {
            performDispose ();
        }
    }

    protected void performDispose ()
    {
        disconnect ();

        this.stateItem.updateData ( Variant.valueOf ( "DISPOSED" ), null, null );

        if ( this.connector != null )
        {
            this.connector.dispose ();
            this.connector = null;
        }

        this.itemFactory.dispose ();

        if ( this.createdExecutor != null )
        {
            this.createdExecutor.shutdown ();
        }
    }

    protected void configure ( final Map<String, String> properties ) throws Exception
    {
        this.host = properties.get ( "host" );
        this.port = Short.valueOf ( properties.get ( "port" ) );
        this.connectTimeout = getTimeout ( properties, "connectTimeout", 5000/*ms*/);
        this.name = properties.get ( "name" );
        this.enabled = parseEnabled ( properties );

        final Map<String, Variant> stateProps = new HashMap<String, Variant> ();
        stateProps.put ( "host", Variant.valueOf ( this.host ) );
        stateProps.put ( "port", Variant.valueOf ( this.port ) );
        stateProps.put ( "enabled", Variant.valueOf ( this.enabled ) );
        this.stateItem.updateData ( null, stateProps, AttributeMode.UPDATE );

        synchronized ( this )
        {
            disconnect ();
            if ( this.enabled )
            {
                connect ();
            }
        }
    }

    private boolean parseEnabled ( final Map<String, String> properties )
    {
        final String str = properties.get ( "disabled" );
        if ( str == null )
        {
            return true;
        }
        return !Boolean.parseBoolean ( str );
    }

    protected static int getTimeout ( final Map<String, String> properties, final String specificTimeoutKey, final int defaultValue )
    {
        String timeout = properties.get ( specificTimeoutKey );
        if ( timeout != null )
        {
            return Integer.valueOf ( timeout );
        }
        timeout = properties.get ( "timeout" );
        if ( timeout != null )
        {
            return Integer.valueOf ( timeout );
        }
        return defaultValue;
    }

    private synchronized void connect ()
    {
        if ( this.state != ConnectionState.DISCONNECTED )
        {
            logger.warn ( "Tried to connect in state: {}", this.state );
            return;
        }

        if ( this.session != null )
        {
            logger.error ( "We already have a session: {}", this.session );
            logger.error ( "Connect error", new IllegalStateException ().fillInStackTrace () );
            return;
        }

        if ( this.connector == null )
        {
            if ( this.processor != null )
            {
                this.connector = new NioSocketConnector ( this.processor );
            }
            else
            {
                this.connector = new NioSocketConnector ();
            }

            this.connector.setHandler ( this.handler );

            // this.connector.getFilterChain ().addLast ( "logger", new LoggingFilter ( this.getClass ().getName () ) );
            configureConnector ( this.connector );
            this.connector.setConnectTimeoutMillis ( this.connectTimeout );
        }

        setState ( ConnectionState.CONNECTING );

        final ConnectFuture future = this.connector.connect ( new InetSocketAddress ( this.host, this.port ) );
        future.addListener ( new IoFutureListener<IoFuture> () {

            @Override
            public void operationComplete ( final IoFuture future )
            {
                try
                {
                    // set new session
                    setSession ( future.getSession () );
                }
                catch ( final Exception e )
                {
                    // handle case of re-connect failure
                    disconnected ( e );
                }
            }
        } );
    }

    protected abstract void configureConnector ( NioSocketConnector connector );

    private void setState ( final ConnectionState state )
    {
        this.state = state;
        this.stateItem.updateData ( Variant.valueOf ( state.toString () ), null, null );
        this.connectionItem.updateData ( Variant.valueOf ( state == ConnectionState.CONNECTED ), null, null );
    }

    protected synchronized void setSession ( final IoSession session )
    {
        if ( this.session != null && session != null )
        {
            logger.error ( "We already have a session set!", new IllegalStateException () );
        }

        if ( session != null )
        {
            setState ( ConnectionState.CONNECTED );
        }
        else
        {
            logger.info ( "Disconnected" );
            setState ( ConnectionState.DISCONNECTED );
            handleSessionDisconnected ();
        }
        this.session = session;
    }

    protected void handleSessionDisconnected ()
    {
    }

    private synchronized void disconnected ( final Exception e )
    {
        if ( this.disposed.get () )
        {
            return;
        }

        this.stateItem.updateData ( null, Collections.singletonMap ( "connectionError", Variant.valueOf ( ExceptionHelper.getMessage ( e ) ) ), AttributeMode.UPDATE );

        setSession ( null );
        if ( this.enabled )
        {
            this.executor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    connect ();
                }
            }, 1000, TimeUnit.MILLISECONDS );
        }
    }

    protected synchronized void disconnect ()
    {
        if ( this.session != null )
        {
            if ( !this.session.isClosing () )
            {
                logger.info ( "Close session: {}", this.session );
                this.session.close ( true );
            }
            else
            {
                logger.warn ( "Session already closing: {}", this.session );
            }
            // session will be set to null using #sessionClosed()
        }
        else
        {
            logger.warn ( "Disconnected without session" );
        }
    }

    protected synchronized void handleExceptionCaught ( final IoSession session, final Throwable error ) throws Exception
    {
        logger.warn ( "Exception caught", error );

        if ( ! ( error instanceof WrongSessionException ) )
        {
            disconnect ();
        }
    }

    protected synchronized void handleMessageReceived ( final IoSession session, final Object message ) throws Exception
    {
        logger.debug ( "Message received: {}", message );
        checkSession ( session );
    }

    protected synchronized void handleMessageSent ( final IoSession session, final Object message ) throws Exception
    {
        logger.debug ( "Message sent: {}", message );
        checkSession ( session );
    }

    protected void checkSession ( final IoSession session )
    {
        if ( this.session != session && this.session != null )
        {
            logger.warn ( "Wrong session called: {} <-> {}", this.session, session );
            throw new WrongSessionException ();
        }
    }

    protected synchronized void handleSessionClosed ( final IoSession session ) throws Exception
    {
        logger.warn ( "Connection lost: {}", session );
        if ( this.session != null )
        {
            checkSession ( session );
        }

        disconnected ( null );
    }

    protected synchronized void handleSessionCreated ( final IoSession session ) throws Exception
    {
        logger.info ( "Session created: {}", session );
    }

    protected synchronized void handleSessionIdle ( final IoSession session, final IdleStatus status ) throws Exception
    {
        logger.warn ( "Got idle: {} / {}", status, session );

        checkSession ( session );

        disconnect ();
    }

    protected synchronized void handleSessionOpened ( final IoSession session ) throws Exception
    {
        logger.info ( "Session opened: {}", session );

        if ( this.session != null )
        {
            checkSession ( session );
        }

        // we don't set the session here since we set it already in the connect future
    }

}
