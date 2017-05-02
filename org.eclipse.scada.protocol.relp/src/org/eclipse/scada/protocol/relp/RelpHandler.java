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
package org.eclipse.scada.protocol.relp;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.protocol.relp.data.OpenRequest;
import org.eclipse.scada.protocol.relp.data.ServerCloseMessage;
import org.eclipse.scada.protocol.relp.data.SyslogRequest;
import org.eclipse.scada.protocol.syslog.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelpHandler extends ChannelDuplexHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( RelpHandler.class );

    private boolean opened;

    private final int timeout;

    private ScheduledFuture<?> timeoutTask;

    public RelpHandler ()
    {
        this ( Integer.getInteger ( "org.eclipse.scada.protocol.relp.openTimeout", 20_000 ) );
    }

    public RelpHandler ( final int timeout )
    {
        this.timeout = timeout;
    }

    @Override
    public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
    {
        // wait for "open" .. start timeout
        if ( this.timeout > 0 )
        {
            logger.debug ( "Adding timeout: {} seconds", this.timeout );
            this.timeoutTask = ctx.executor ().schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    processTimeout ( ctx );
                }
            }, this.timeout, TimeUnit.MILLISECONDS );
        }
    }

    protected void processTimeout ( final ChannelHandlerContext ctx )
    {
        ctx.writeAndFlush ( ServerCloseMessage.INSTANCE );
        ctx.close ();
    }

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        if ( msg instanceof OpenRequest )
        {
            handleOpen ( ctx, (OpenRequest)msg );
        }
        else if ( msg instanceof SyslogRequest )
        {
            handleSyslog ( ctx, (SyslogRequest)msg );
        }
    }

    protected void handleSyslog ( final ChannelHandlerContext ctx, final SyslogRequest msg )
    {
        logger.debug ( "Process syslog command: {}", msg );
        ctx.fireChannelRead ( msg.getData () );
        ctx.writeAndFlush ( msg.replyOk () );
    }

    protected void handleOpen ( final ChannelHandlerContext ctx, final OpenRequest msg )
    {
        if ( this.opened )
        {
            logger.warn ( "Duplicate open request. Closing channel." );
            ctx.close ();
            return;
        }

        this.opened = true;

        logger.debug ( "Removing timeout" );
        if ( this.timeoutTask != null )
        {
            this.timeoutTask.cancel ( false );
        }

        logger.debug ( "Process open command: {}", msg );

        final String cs = msg.getOffers ().get ( Constants.OFFER_COMMANDS );
        if ( cs == null )
        {
            ctx.write ( ServerCloseMessage.INSTANCE );
            throw new IllegalStateException ( "Offer 'commands' not found in open command" );
        }

        final Set<String> commands = new HashSet<> ( Arrays.asList ( cs.split ( "," ) ) );

        logger.debug ( "Supported commands: {}", commands );

        if ( !commands.contains ( "syslog" ) )
        {
            ctx.write ( ServerCloseMessage.INSTANCE );
            throw new IllegalStateException ( "Command 'syslog' not supported" );
        }

        final Map<String, String> result = new HashMap<> ( 1 );
        result.put ( Constants.OFFER_COMMANDS, "syslog" );
        result.put ( Constants.OFFER_PROTOCOL_VERSION, "0" );

        ctx.writeAndFlush ( msg.replyOk ( result ) );
        ctx.fireChannelActive ();
    }
}
