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
package org.eclipse.scada.protocol.syslog;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.CodecException;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.protocol.syslog.time.TimestampParser;

/**
 * Decode syslog messages
 * <p>
 * <em>Note:</em> This filter expects the <em>complete</em> message on the data
 * buffer
 * </p>
 */
public class SyslogCodec extends ChannelDuplexHandler
{
    private static final byte PRI_START = 0x3c; // '<'

    private static final byte PRI_END = 0x3e; // '<'

    private static final byte COLON = 0x3a; // ':'

    private final TimestampParser timestampParser;

    public SyslogCodec ( final TimestampParser timestampParser )
    {
        this.timestampParser = timestampParser;
    }

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        if ( msg instanceof ByteBuf )
        {
            processMessage ( ctx, (ByteBuf)msg );
        }
    }

    protected void processMessage ( final ChannelHandlerContext ctx, final ByteBuf msg )
    {
        if ( msg.readByte () != PRI_START )
        {
            throw new CodecException ( "PRI start not found" );
        }

        final int prival = decodePrival ( msg );

        final Severity severity = Severity.values ()[prival % 8];
        final Facility facility = Facility.values ()[prival / 8];

        final Calendar timestamp = this.timestampParser.parseTimestamp ( msg );
        final String hostname = decodeHostname ( msg );
        final String[] process = decodeProcess ( msg );
        final String processName = process[0];
        final Long processId = process.length > 1 ? Long.parseLong ( process[1] ) : null;
        final String message = decodeMessage ( msg );

        ctx.fireChannelRead ( new SyslogMessage ( facility, severity, timestamp, hostname, processName, processId, message ) );
    }

    private String decodeMessage ( final ByteBuf msg )
    {
        final String data = msg.toString ( StandardCharsets.UTF_8 );

        final StringBuilder sb = new StringBuilder ();

        for ( int i = 0; i < data.length (); i++ )
        {
            final char c = data.charAt ( i );
            if ( c == '#' )
            {
                try
                {
                    final int code = Integer.parseInt ( data.substring ( i + 1, i + 4 ), 8 );
                    sb.append ( (char)code );
                    i += 3;
                }
                catch ( final NumberFormatException e )
                {
                    sb.append ( c );
                }
            }
            else
            {
                sb.append ( c );
            }
        }

        return sb.toString ();
    }

    private static final Pattern PROCESS_PATTERN = Pattern.compile ( "(.*)\\[(\\d+)\\]" );

    private String[] decodeProcess ( final ByteBuf msg )
    {
        // split by colon
        final int spaceIndex = msg.bytesBefore ( COLON );
        if ( spaceIndex < 0 )
        {
            throw new CodecException ( "Unable to find process name" );
        }

        final String process = msg.readSlice ( spaceIndex ).toString ( StandardCharsets.US_ASCII );
        msg.skipBytes ( 1 ); // COLON
        if ( msg.isReadable () )
        {
            msg.skipBytes ( 1 ); // SPACE
        }

        final Matcher m = PROCESS_PATTERN.matcher ( process );
        if ( m.matches () )
        {
            return new String[] { m.group ( 1 ), m.group ( 2 ) };
        }

        return new String[] { process };
    }

    private String decodeHostname ( final ByteBuf msg )
    {
        // split by first space
        final int spaceIndex = msg.bytesBefore ( Constants.SP );
        if ( spaceIndex < 0 )
        {
            throw new CodecException ( "Unable to find hostname" );
        }

        final String hostname = msg.readSlice ( spaceIndex ).toString ( StandardCharsets.US_ASCII );

        msg.skipBytes ( 1 ); // SPACE

        return hostname;
    }

    private int decodePrival ( final ByteBuf msg )
    {
        final ByteBuffer privalBuffer = ByteBuffer.wrap ( new byte[3] );
        byte b;
        do
        {
            b = msg.readByte ();
            if ( b == PRI_END )
            {
                break;
            }
            if ( !privalBuffer.hasRemaining () )
            {
                throw new CodecException ( "PRI value must be <=3 bytes" );
            }
            privalBuffer.put ( b );
        } while ( true );

        privalBuffer.flip ();
        final int prival = Integer.parseInt ( StandardCharsets.US_ASCII.decode ( privalBuffer ).toString () );
        return prival;
    }
}
