/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.io.common;

import java.net.SocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class StreamBaseDevice extends GenericBaseDevice implements BaseDevice
{

    private static final Logger logger = LoggerFactory.getLogger ( StreamBaseDevice.class );

    public static final int CONNECT_TIMEOUT = Integer.getInteger ( "org.eclipse.scada.da.server.io.common.connectTimeout", 5 * 1000 );

    private SocketConnector connector;

    private final SocketAddress address;

    protected IoSession session;

    private long timeoutTime = Integer.getInteger ( "org.eclipse.scada.da.server.io.common.defaultTimeout", 10 * 1000 );

    public StreamBaseDevice ( final SocketAddress address )
    {
        super ();
        this.address = address;
    }

    protected abstract void setupConnector ( SocketConnector connector );

    @Override
    public boolean isConnected ()
    {
        return this.session != null;
    }

    @Override
    public synchronized void connect ()
    {
        if ( isConnected () )
        {
            logger.info ( "Already connected" );
            return;
        }

        if ( this.connector == null )
        {
            this.connector = new NioSocketConnector ();
            this.connector.setHandler ( this );
            if ( Boolean.getBoolean ( "org.eclipse.scada.da.server.io.common.trace" ) )
            {
                this.connector.getFilterChain ().addLast ( "logger", new LoggingFilter () );
            }
            setupConnector ( this.connector );
        }

        final ConnectFuture cu = this.connector.connect ( this.address );
        cu.addListener ( new IoFutureListener<ConnectFuture> () {

            @Override
            public void operationComplete ( final ConnectFuture future )
            {
                try
                {
                    future.getSession ();
                }
                catch ( final Throwable e )
                {
                    StreamBaseDevice.this.fireConnectionFailed ( e );
                }
            }
        } );
    }

    @Override
    public synchronized void dispose ()
    {
        if ( this.connector != null )
        {
            this.connector.dispose ();
            this.connector = null;
        }
    }

    @Override
    public void sessionCreated ( final IoSession session ) throws Exception
    {
        logger.debug ( "Session created" );

        // set for session
        session.getConfig ().setIdleTime ( IdleStatus.BOTH_IDLE, (int) ( this.timeoutTime / 1000 ) );
    }

    protected void setTimeout ( final long timeout )
    {
        logger.info ( "Settings timeout: {}", timeout );
        this.timeoutTime = timeout;
        if ( this.session != null )
        {
            this.session.getConfig ().setIdleTime ( IdleStatus.BOTH_IDLE, (int) ( this.timeoutTime / 1000 ) );
        }
    }

    @Override
    public void sessionOpened ( final IoSession session ) throws Exception
    {
        logger.debug ( "Session opened" );
        this.session = session;
        fireConnected ();
    }

    @Override
    public void sessionIdle ( final IoSession session, final IdleStatus status ) throws Exception
    {
        logger.debug ( "Close session due to idle time" );
        session.close ( true );
    }

    @Override
    public void sessionClosed ( final IoSession session ) throws Exception
    {
        logger.debug ( "Session closed" );

        this.session = null;
        for ( final ConnectionListener listener : this.connectionListeners )
        {
            listener.closed ( null );
        }
    }

    /**
     * Write a message to the outbound connection or fail if there is not open
     * connection at the moment
     * 
     * @param message
     *            the message to wrtite
     * @throws NotConnectedException
     *             thrown if there is no connection at the moment
     */
    protected void writeMessage ( final Object message ) throws NotConnectedException
    {
        final IoSession session = this.session;
        if ( session != null )
        {
            session.write ( message );
        }
        else
        {
            throw new NotConnectedException ();
        }
    }

    /**
     * Write a message to the outbound connection or ignore it if there is no
     * open connection at the moment
     * 
     * @param message
     *            the message to write
     */
    protected void writeMessageIgnore ( final Object message )
    {
        final IoSession session = this.session;
        if ( session != null )
        {
            session.write ( message );
        }
    }

}