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
package org.eclipse.neoscada.protocol.iec60870.server;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.apci.APDUDecoder;
import org.eclipse.neoscada.protocol.iec60870.apci.APDUEncoder;
import org.eclipse.neoscada.protocol.iec60870.apci.MessageChannel;
import org.eclipse.neoscada.protocol.iec60870.asdu.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;

public class Server implements AutoCloseable
{
    private final static Logger logger = LoggerFactory.getLogger ( Server.class );

    private final ServerBootstrap bootstrap;

    private final Channel channel;

    private final EventLoopGroup bossGroup;

    private final EventLoopGroup workerGroup;

    private final ServerModule[] modules;

    private final ProtocolOptions options;

    private final MessageManager manager;

    public Server ( final short port, final ProtocolOptions options, final List<ServerModule> modules )
    {
        this ( 0xFFFF & port, options, modules );
    }

    public Server ( final int port, final ProtocolOptions options, final List<ServerModule> modules )
    {
        this ( new InetSocketAddress ( port ), options, modules );
    }

    public Server ( final SocketAddress address, final ProtocolOptions options, final List<ServerModule> modules )
    {
        this.options = options;

        this.manager = new MessageManager ( this.options );

        this.bossGroup = new NioEventLoopGroup ();
        this.workerGroup = new NioEventLoopGroup ();
        this.bootstrap = new ServerBootstrap ();
        this.bootstrap.group ( this.bossGroup, this.workerGroup );
        this.bootstrap.channel ( NioServerSocketChannel.class );
        this.bootstrap.option ( ChannelOption.SO_BACKLOG, 5 );
        this.bootstrap.option ( ChannelOption.SO_REUSEADDR, true );
        this.bootstrap.childHandler ( new ChannelInitializer<SocketChannel> () {

            @Override
            protected void initChannel ( final SocketChannel ch ) throws Exception
            {
                handleInitChannel ( ch );
            }
        } );

        this.modules = modules.toArray ( new ServerModule[modules.size ()] );
        for ( final ServerModule module : modules )
        {
            module.initializeServer ( this, this.manager );
        }

        this.channel = this.bootstrap.bind ( address ).channel ();
    }

    public Server ( final short port, final List<ServerModule> modules )
    {
        this ( 0xFFFF & port, modules );
    }

    public Server ( final int port, final List<ServerModule> modules )
    {
        this ( port, new ProtocolOptions.Builder ().build (), modules );
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

        for ( final ServerModule module : this.modules )
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
        } );
    }

    @Override
    public void close () throws Exception
    {
        this.channel.close ();

        for ( final ServerModule module : this.modules )
        {
            module.dispose ();
        }

        this.bossGroup.shutdownGracefully ();
        this.workerGroup.shutdownGracefully ();
    }

    public void closeAndWait () throws Exception
    {
        ChannelFuture channelFuture = this.channel.close ();
        channelFuture.get ();

        for ( final ServerModule module : this.modules )
        {
            module.dispose ();
        }

        Future<?> bossGroupFuture = this.bossGroup.shutdownGracefully ();
        bossGroupFuture.get ();
        Future<?> workerGroupFuture = this.workerGroup.shutdownGracefully ();
        workerGroupFuture.get ();
    }
}
