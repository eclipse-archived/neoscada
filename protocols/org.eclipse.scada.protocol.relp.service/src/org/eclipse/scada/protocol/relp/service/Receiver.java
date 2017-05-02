/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.relp.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.eclipse.scada.protocol.relp.FrameCodec;
import org.eclipse.scada.protocol.relp.FrameProcessor;
import org.eclipse.scada.protocol.relp.Helper;
import org.eclipse.scada.protocol.relp.RelpExceptionHandler;
import org.eclipse.scada.protocol.relp.RelpHandler;
import org.eclipse.scada.protocol.syslog.SyslogCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver implements AutoCloseable
{
    private final static Logger logger = LoggerFactory.getLogger ( Receiver.class );

    private final NioEventLoopGroup bossGroup;

    private final NioEventLoopGroup workerGroup;

    private final ServerBootstrap bootstrap;

    private final Channel channel;

    private final ReceiverHandlerFactory factory;

    public Receiver ( final ReceiverHandlerFactory factory, final int port )
    {
        this ( factory, new InetSocketAddress ( port ) );
    }

    public Receiver ( final ReceiverHandlerFactory factory, final SocketAddress addr )
    {
        this.factory = factory;

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

        this.channel = this.bootstrap.bind ( addr ).channel ();

        logger.info ( "Receiver running ..." );
    }

    protected void handleInitChannel ( final SocketChannel ch )
    {
        logger.debug ( "Create new sessesion - channel: {}", ch );

        ch.pipeline ().addLast ( "frame.decoder", new FrameCodec () );
        ch.pipeline ().addLast ( "frame.processor", new FrameProcessor () );
        ch.pipeline ().addLast ( "relp.handler", new RelpHandler () );
        ch.pipeline ().addLast ( "syslog", new SyslogCodec ( Helper.RELP ) );
        ch.pipeline ().addLast ( "exception", new RelpExceptionHandler () );

        final ReceiverHandler handler = this.factory.createHandler ();

        new ReceiverSession ( ch, handler );
    }

    @Override
    public void close ()
    {
        this.channel.close ();
        this.workerGroup.shutdownGracefully ();
        this.bossGroup.shutdownGracefully ();
    }
}
