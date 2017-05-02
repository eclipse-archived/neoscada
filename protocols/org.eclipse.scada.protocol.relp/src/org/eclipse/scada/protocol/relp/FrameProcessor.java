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

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.scada.protocol.relp.data.AbstractGenericResponse;
import org.eclipse.scada.protocol.relp.data.Frame;
import org.eclipse.scada.protocol.relp.data.OpenRequest;
import org.eclipse.scada.protocol.relp.data.OpenResponse;
import org.eclipse.scada.protocol.relp.data.ServerCloseMessage;
import org.eclipse.scada.protocol.relp.data.SyslogRequest;
import org.eclipse.scada.protocol.relp.data.SyslogResponse;
import org.eclipse.scada.protocol.syslog.Constants;

public class FrameProcessor extends ChannelDuplexHandler
{

    private static final Charset CHARSET_OPEN = StandardCharsets.US_ASCII;

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        if ( msg instanceof Frame )
        {
            processFrame ( ctx, (Frame)msg );
        }
        else
        {
            super.channelRead ( ctx, msg );
        }
    }

    @Override
    public void write ( final ChannelHandlerContext ctx, final Object msg, final ChannelPromise promise ) throws Exception
    {
        if ( msg instanceof OpenResponse )
        {
            writeOpenResponse ( ctx, (OpenResponse)msg, promise );
        }
        else if ( msg instanceof SyslogResponse )
        {
            writeGenericResponse ( ctx, (AbstractGenericResponse)msg, promise );
        }
        else if ( msg instanceof ServerCloseMessage )
        {
            ctx.write ( new Frame ( 0, "serverclose", (ByteBuf)null ) );
        }
        else
        {
            super.write ( ctx, msg, promise );
        }
    }

    protected void writeGenericResponse ( final ChannelHandlerContext ctx, final AbstractGenericResponse msg, final ChannelPromise promise )
    {
        ctx.write ( createCommonResponse ( msg.getTransactionId (), msg.getCode (), msg.getMessage (), null ) );
    }

    protected void writeOpenResponse ( final ChannelHandlerContext ctx, final OpenResponse msg, final ChannelPromise promise )
    {
        final StringBuilder sb = new StringBuilder ();

        int i = 0;
        for ( final Map.Entry<String, String> entry : msg.getOffers ().entrySet () )
        {
            if ( i > 0 )
            {
                sb.append ( Constants.LF_STRING );
            }

            sb.append ( entry.getKey () );

            if ( entry.getValue () != null )
            {
                sb.append ( '=' );
                sb.append ( entry.getValue () );
            }
            i++;
        }

        ctx.write ( createCommonResponse ( msg.getTransactionId (), msg.getCode (), msg.getMessage (), sb ) );
    }

    private Frame createCommonResponse ( final long transactionId, final int code, final String message, final StringBuilder data )
    {
        final StringBuilder sb = new StringBuilder ();

        // code
        sb.append ( code );

        // message
        if ( message != null && !message.isEmpty () )
        {
            sb.append ( Constants.SP_STRING );
            sb.append ( message );
        }

        // data
        if ( data != null )
        {
            sb.append ( Constants.LF_STRING );
            sb.append ( data );
        }

        // pack into frame
        return new Frame ( transactionId, Constants.CMD_RESPONSE, sb.toString () );
    }

    private void processFrame ( final ChannelHandlerContext ctx, final Frame frame )
    {
        if ( frame.getCommand () == null )
        {
            throw new IllegalStateException ( "Null command" );
        }

        switch ( frame.getCommand () )
        {
            case Constants.CMD_OPEN:
                handleOpen ( ctx, frame );
                break;
            case Constants.CMD_SYSLOG:
                handleSyslog ( ctx, frame );
                break;
        }
    }

    private void handleSyslog ( final ChannelHandlerContext ctx, final Frame frame )
    {
        ctx.fireChannelRead ( new SyslogRequest ( frame.getTransactionId (), frame.getData () ) );
    }

    protected void handleOpen ( final ChannelHandlerContext ctx, final Frame frame )
    {
        final String data = frame.getData ().toString ( CHARSET_OPEN );
        final StringTokenizer tok = new StringTokenizer ( data, Constants.LF_STRING );

        final Map<String, String> offers = new HashMap<> ();

        while ( tok.hasMoreTokens () )
        {
            final String tpl = tok.nextToken ();
            final String[] fields = tpl.split ( "=", 2 );
            if ( fields.length > 1 )
            {
                offers.put ( fields[0], fields[1] );
            }
            else
            {
                offers.put ( fields[0], fields[0] );
            }
        }

        ctx.fireChannelRead ( new OpenRequest ( frame.getTransactionId (), offers ) );
    }
}
