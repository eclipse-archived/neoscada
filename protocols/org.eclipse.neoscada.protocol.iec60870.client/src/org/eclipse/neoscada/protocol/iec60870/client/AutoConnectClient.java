/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.client;

import java.net.InetSocketAddress;
import java.nio.channels.UnresolvedAddressException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.InetAddresses;

import io.netty.channel.Channel;

/**
 * A client implementation which automatically opens the connection re-connect
 * in case of disconnects
 */
public class AutoConnectClient implements AutoCloseable
{
    private final static Logger logger = LoggerFactory.getLogger ( AutoConnectClient.class );

    private static final AtomicLong counter = new AtomicLong ();

    private final ConnectionStateListener listener = new ConnectionStateListener () {

        @Override
        public void disconnected ( final Throwable error )
        {
            handleDisconnected ( error );
        }

        @Override
        public void connected ( final Channel channel )
        {
            handleConnected ();
        }
    };

    private final StateListener stateListener;

    private volatile ScheduledExecutorService executor;

    private final ProtocolOptions options;

    private final InetSocketAddress address;

    private Client client;

    private final ModulesFactory modulesFactory;

    public static enum State
    {
        SLEEPING,
        DISCONNECTED,
        LOOKUP,
        CONNECTING,
        CONNECTED;
    }

    public interface StateListener
    {
        public void stateChanged ( State state, Throwable e );
    }

    public interface ModulesFactory
    {
        public List<ClientModule> createModules ();
    }

    public AutoConnectClient ( final String host, final int port, final ProtocolOptions options, final ModulesFactory modulesFactory, final StateListener stateListener )
    {
        this.executor = new ScheduledExportedExecutorService ( makeName ( host, port ), 1 );
        this.stateListener = stateListener;
        this.options = options;
        this.modulesFactory = modulesFactory;
        this.address = makeAddress ( host, port );

        triggerConnect ( 0 );
    }

    private InetSocketAddress makeAddress ( final String host, final int port )
    {
        try
        {
            // try numeric ip address first
            return new InetSocketAddress ( InetAddresses.forString ( host ), port );
        }
        catch ( final IllegalArgumentException e )
        {
            // assume as hostname
            return InetSocketAddress.createUnresolved ( host, port );
        }
    }

    private synchronized void triggerConnect ( final long delay )
    {
        logger.debug ( "Trigger reconnect: {} ms delay", delay );

        if ( delay > 0 )
        {
            fireState ( State.SLEEPING );
        }

        if ( this.executor == null )
        {
            // got disposed
            return;
        }

        this.executor.schedule ( new Runnable () {

            @Override
            public void run ()
            {
                processConnect ();
            }
        }, delay, TimeUnit.MILLISECONDS );
    }

    protected void lookup ()
    {
        fireState ( State.LOOKUP );

        // performing lookup
        final InetSocketAddress address = new InetSocketAddress ( this.address.getHostString (), this.address.getPort () );
        if ( address.isUnresolved () )
        {
            final UnresolvedAddressException e = new UnresolvedAddressException ();
            handleDisconnected ( e );
        }

        synchronized ( this )
        {
            if ( this.executor == null )
            {
                // we got disposed, do nothing
                return;
            }
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    createClient ( address );
                }
            } );
        }
    }

    protected synchronized void createClient ( final InetSocketAddress resolvedAddress )
    {
        fireState ( State.CONNECTING );
        logger.debug ( "Creating new client instance" );

        if ( this.executor == null )
        {
            // got disposed
            return;
        }

        this.client = new Client ( resolvedAddress, this.listener, this.options, this.modulesFactory.createModules () );
        this.client.connect ();
    }

    public boolean writeCommand ( final Object command )
    {
        Client client;

        synchronized ( this )
        {
            client = this.client;
        }

        if ( client != null )
        {
            client.writeCommand ( command );
            return true;
        }
        return false;
    }

    private void fireState ( final State state )
    {
        fireState ( state, null );
    }

    private void fireState ( final State state, final Throwable e )
    {
        logger.info ( "State changed: {}", state );
        if ( e != null )
        {
            logger.info ( "State failure", e );
        }

        if ( this.stateListener != null && this.executor != null )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    AutoConnectClient.this.stateListener.stateChanged ( state, e );
                }
            } );
        }
    }

    @Override
    public void close ()
    {
        logger.debug ( "Closing instance" );

        final ExecutorService service = this.executor;
        this.executor = null; // mark disposed

        try
        {
            closeClient ();
        }
        finally
        {
            service.shutdown ();
        }
    }

    private synchronized void closeClient ()
    {
        logger.debug ( "Closing client" );

        if ( this.client == null )
        {
            return;
        }

        try
        {
            this.client.close ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to close client", e );
        }
        this.client = null;
    }

    private static String makeName ( final String host, final int port )
    {
        return String.format ( "%s/%s/%s", host, port, counter.incrementAndGet () );
    }

    protected synchronized void handleConnected ()
    {
        fireState ( State.CONNECTED );
    }

    private synchronized void handleDisconnected ( final Throwable error )
    {
        logger.info ( "handleDisconnected" );

        closeClient ();
        fireState ( State.DISCONNECTED, error );

        triggerConnect ( 10_000 );
    }

    public synchronized void reconnect ()
    {
        logger.warn ( "Reconnect requested" );

        if ( this.client != null )
        {
            try
            {
                this.client.close ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to close client", e );
                throw new RuntimeException ( e );
            }
        }
    }

    private void processConnect ()
    {
        if ( this.executor == null )
        {
            return;
        }

        if ( AutoConnectClient.this.address.isUnresolved () )
        {
            lookup ();
        }
        else
        {
            createClient ( AutoConnectClient.this.address );
        }
    }

    public void requestStartData ()
    {
        if ( this.client != null )
        {
            try
            {
                this.client.requestStartData ();
            }
            catch ( Exception e )
            {
                logger.warn ( "Failed to send StartDT", e );
            }
        }
    }
}
