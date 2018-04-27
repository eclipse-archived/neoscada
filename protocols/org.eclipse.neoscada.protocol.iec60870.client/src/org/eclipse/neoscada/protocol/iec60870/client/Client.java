/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.client;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.apci.APDUDecoder;
import org.eclipse.neoscada.protocol.iec60870.apci.APDUEncoder;
import org.eclipse.neoscada.protocol.iec60870.apci.MessageChannel;
import org.eclipse.neoscada.protocol.iec60870.asdu.MessageManager;
import org.eclipse.neoscada.protocol.iec60870.io.Module;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class Client implements AutoCloseable
{
    private final static Logger logger = LoggerFactory.getLogger ( Client.class );

    private final ProtocolOptions options;

    private final MessageManager manager;

    private final Bootstrap bootstrap;

    private final ClientModule[] modules;

    private final SocketAddress address;

    private final ExecutorService executor;

    private SettableFuture<Void> connectFuture;

    private Channel channel;

    private final NioEventLoopGroup group;

    private final ConnectionStateListener listener;

    public Client ( final SocketAddress address, final ConnectionStateListener listener, final ProtocolOptions options, final List<ClientModule> modules )
    {
        this.address = address;
        this.options = options;

        this.listener = listener;

        this.manager = new MessageManager ( options );

        this.group = new NioEventLoopGroup ();

        this.bootstrap = new Bootstrap ();
        this.bootstrap.group ( this.group );
        this.bootstrap.channel ( NioSocketChannel.class );

        this.bootstrap.handler ( new ChannelInitializer<SocketChannel> () {

            @Override
            protected void initChannel ( final SocketChannel ch ) throws Exception
            {
                handleInitChannel ( ch );
            }
        } );

        this.modules = modules.toArray ( new ClientModule[modules.size ()] );
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "IEC60870Client/" + address ) );

        for ( final ClientModule module : modules )
        {
            module.initializeClient ( this, this.manager );
        }
    }

    public synchronized ListenableFuture<Void> connect ()
    {
        if ( this.connectFuture != null )
        {
            return this.connectFuture;
        }

        final ChannelFuture channelFuture = this.bootstrap.connect ( this.address );
        this.connectFuture = SettableFuture.create ();

        channelFuture.addListener ( new GenericFutureListener<ChannelFuture> () {

            @Override
            public void operationComplete ( final ChannelFuture future ) throws Exception
            {
                handleOperationComplete ( Client.this.connectFuture, future );
            }
        } );

        return this.connectFuture;
    }

    protected synchronized void handleOperationComplete ( final SettableFuture<Void> result, final ChannelFuture future )
    {
        if ( this.connectFuture != result )
        {
            // this should never happen
            return;
        }

        this.connectFuture = null;

        try
        {
            future.get ();
            this.channel = future.channel ();

            fireConnected ( this.channel );
            result.set ( null );
        }
        catch ( final InterruptedException | ExecutionException e )
        {
            fireDisconnected ( e );
            result.setException ( e );
        }
    }

    private void fireConnected ( final Channel channel )
    {
        if ( this.listener != null )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    Client.this.listener.connected ( channel );
                };
            } );
        }
    }

    private void fireDisconnected ( final Exception e )
    {
        if ( this.listener == null )
        {
            return;
        }

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                Client.this.listener.disconnected ( e );
            };
        } );
    }

    protected void handleInitChannel ( final SocketChannel ch )
    {
        // add the APCI/APDU handler
        ch.pipeline ().addLast ( new APDUDecoder () );
        ch.pipeline ().addLast ( new APDUEncoder () );

        // add logging
        if ( Boolean.getBoolean ( "org.eclipse.scada.protocol.iec60870.trace" ) )
        {
            ch.pipeline ().addLast ( new LoggingHandler ( LogLevel.TRACE ) );
        }

        final MessageChannel messageChannel = new MessageChannel ( this.options, this.manager );

        // message channel
        ch.pipeline ().addLast ( messageChannel );

        // now add all server modules

        for ( final Module module : this.modules )
        {
            module.initializeChannel ( ch, messageChannel );
        }

        // finally add the default exception catcher

        ch.pipeline ().addLast ( new ChannelDuplexHandler () {
            @Override
            public void exceptionCaught ( final ChannelHandlerContext ctx, final Throwable cause ) throws Exception
            {
                logger.warn ( "Close connection due to uncaught exception", cause );
                ctx.close ();
            }

            @Override
            public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
            {
                super.channelInactive ( ctx );
                fireDisconnected ( null );
            }
        } );
    }

    @Override
    public void close () throws Exception
    {
        synchronized ( this )
        {
            if ( this.channel != null )
            {
                this.channel.close ();
                this.channel = null;
            }

            for ( final Module module : this.modules )
            {
                module.dispose ();
            }
        }

        logger.debug ( "Shutting down main group" );
        final Future<?> f = this.group.shutdownGracefully ();
        f.addListener ( new GenericFutureListener<Future<Object>> () {
            @Override
            public void operationComplete ( final Future<Object> arg0 ) throws Exception
            {
                disposeExecutor ();
            }
        } );
    }

    protected void disposeExecutor ()
    {
        logger.debug ( "Shutting down executor" );
        this.executor.shutdown ();
    }

    public void writeCommand ( final Object command )
    {
        this.channel.writeAndFlush ( command );
    }

    public void requestStartData ()
    {
        for ( final ClientModule module : this.modules )
        {
            module.requestStartData();
        }
    }
}
