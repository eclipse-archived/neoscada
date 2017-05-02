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

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;

import java.net.InetSocketAddress;

import org.eclipse.scada.protocol.syslog.SyslogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiverSession
{
    private final static Logger logger = LoggerFactory.getLogger ( ReceiverSession.class );

    private final SocketChannel channel;

    private final ChannelHandler channelHandler = new ChannelDuplexHandler ()
    {
        @Override
        public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
        {
            if ( msg instanceof SyslogMessage )
            {
                handleMessage ( (SyslogMessage)msg );
            }
        }

        @Override
        public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
        {
            handleOpened ();
        }

        @Override
        public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
        {
            handleClosed ();
        }

        @Override
        public void exceptionCaught ( final ChannelHandlerContext ctx, final Throwable cause ) throws Exception
        {
            logger.warn ( "Failed to process - " + ctx, cause );
            ctx.close ();
        }
    };

    private final ReceiverHandler handler;

    public ReceiverSession ( final SocketChannel ch, final ReceiverHandler handler )
    {
        this.channel = ch;
        this.handler = handler;
        this.channel.pipeline ().addLast ( this.channelHandler );
    }

    protected void handleOpened ()
    {
        this.handler.opened ( this );
    }

    protected void handleMessage ( final SyslogMessage msg )
    {
        this.handler.message ( this, msg );
    }

    protected void handleClosed ()
    {
        logger.info ( "Session closed - ctx: {}", this.channel );
        this.handler.closed ( this );
    }

    public void close ()
    {
        this.channel.close ();
    }

    public InetSocketAddress getRemoteAddress ()
    {
        return this.channel.remoteAddress ();
    }
}
