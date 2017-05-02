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
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.util.AttributeKey;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.eclipse.scada.protocol.relp.data.Frame;
import org.eclipse.scada.protocol.syslog.Constants;

public class FrameCodec extends ChannelDuplexHandler
{
    public static enum State
    {
        TXNR,
        COMMAND,
        LENGTH,
        DATA,
        TRAILER
    }

    private static final AttributeKey<State> ATTR_STATE = AttributeKey.valueOf ( "relp.frame.state" );

    private static final AttributeKey<ByteBuf> ATTR_TXNR_BUFFER = AttributeKey.valueOf ( "relp.frame.txnr.buffer" );

    private static final AttributeKey<ByteBuf> ATTR_COMMAND_BUFFER = AttributeKey.valueOf ( "relp.frame.command.buffer" );

    private static final AttributeKey<ByteBuf> ATTR_LENGTH_BUFFER = AttributeKey.valueOf ( "relp.frame.length.buffer" );

    private static final AttributeKey<ByteBuf> ATTR_DATA_BUFFER = AttributeKey.valueOf ( "relp.frame.data.buffer" );

    private static final AttributeKey<Integer> ATTR_EXPECTED_LENGTH = AttributeKey.valueOf ( "relp.expected.length" );

    private static final Charset LENGTH_CHARSET = StandardCharsets.US_ASCII;

    private static final Charset TXNR_CHARSET = StandardCharsets.US_ASCII;

    private static final Charset COMMAND_CHARSET = StandardCharsets.US_ASCII;

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        if ( msg instanceof ByteBuf )
        {
            while ( ( (ByteBuf)msg ).isReadable () )
            {
                performRead ( ctx, ( (ByteBuf)msg ).readByte (), (ByteBuf)msg );
            }
            ( (ByteBuf)msg ).release ();
        }
        else
        {
            super.channelRead ( ctx, msg );
        }
    }

    @Override
    public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
    {
        ctx.attr ( ATTR_STATE ).set ( State.TXNR );
        ctx.attr ( ATTR_TXNR_BUFFER ).set ( Unpooled.buffer () );
        ctx.attr ( ATTR_COMMAND_BUFFER ).set ( Unpooled.buffer () );
        ctx.attr ( ATTR_LENGTH_BUFFER ).set ( Unpooled.buffer () );
        ctx.attr ( ATTR_DATA_BUFFER ).set ( Unpooled.buffer () );
        super.channelActive ( ctx );
    }

    @Override
    public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
    {
        ctx.attr ( ATTR_TXNR_BUFFER ).getAndRemove ().release ();
        ctx.attr ( ATTR_COMMAND_BUFFER ).getAndRemove ().release ();
        ctx.attr ( ATTR_LENGTH_BUFFER ).getAndRemove ().release ();
        ctx.attr ( ATTR_DATA_BUFFER ).getAndRemove ().release ();
        super.channelInactive ( ctx );
    }

    private void performRead ( final ChannelHandlerContext ctx, final byte b, final ByteBuf msg )
    {
        switch ( ctx.attr ( ATTR_STATE ).get () )
        {
            case TXNR:
                processTXNR ( ctx, b );
                break;
            case COMMAND:
                processCOMMAND ( ctx, b );
                break;
            case LENGTH:
                processLENGTH ( ctx, b );
                break;
            case DATA:
                processDATA ( ctx, b );
                break;
            case TRAILER:
                processTRAILER ( ctx, b, msg );
                break;
        }
    }

    private void processTRAILER ( final ChannelHandlerContext ctx, final byte b, final ByteBuf msg )
    {
        if ( b != Constants.LF )
        {
            throw new CodecException ( String.format ( "Expected trailer byte (LF) but found 0x%02X: Remaining buffer: %s", b, ByteBufUtil.hexDump ( msg, msg.readerIndex (), msg.readableBytes () ) ) );
        }

        final int length = ctx.attr ( ATTR_EXPECTED_LENGTH ).get ();
        final long txnr = Long.parseLong ( ctx.attr ( ATTR_TXNR_BUFFER ).get ().toString ( TXNR_CHARSET ) );
        final String command = ctx.attr ( ATTR_COMMAND_BUFFER ).get ().toString ( COMMAND_CHARSET );
        final ByteBuf data = ctx.attr ( ATTR_DATA_BUFFER ).get ().readSlice ( length );

        final Frame frame = new Frame ( txnr, command, data );

        ctx.fireChannelRead ( frame );

        ctx.attr ( ATTR_STATE ).set ( State.TXNR );
        ctx.attr ( ATTR_TXNR_BUFFER ).get ().clear ();
        ctx.attr ( ATTR_COMMAND_BUFFER ).get ().clear ();
        ctx.attr ( ATTR_LENGTH_BUFFER ).get ().clear ();
        ctx.attr ( ATTR_DATA_BUFFER ).get ().clear ();
    }

    private void processDATA ( final ChannelHandlerContext ctx, final byte b )
    {
        final ByteBuf data = ctx.attr ( ATTR_DATA_BUFFER ).get ();
        data.writeByte ( b );
        if ( data.readableBytes () >= ctx.attr ( ATTR_EXPECTED_LENGTH ).get () )
        {
            ctx.attr ( ATTR_STATE ).set ( State.TRAILER );
        }
    }

    private void processLENGTH ( final ChannelHandlerContext ctx, final byte b )
    {
        final ByteBuf lengthBuffer = ctx.attr ( ATTR_LENGTH_BUFFER ).get ();

        if ( b == Constants.SP || lengthBuffer.readableBytes () > 0 && b == Constants.LF )
        {
            // either we have a SP or at least one byte (possibly "0") and a LF

            final int length = Integer.parseInt ( lengthBuffer.toString ( LENGTH_CHARSET ) );

            ctx.attr ( ATTR_EXPECTED_LENGTH ).set ( length );
            ctx.attr ( ATTR_STATE ).set ( State.DATA );
        }
        else
        {
            lengthBuffer.writeByte ( b );
        }
    }

    private void processCOMMAND ( final ChannelHandlerContext ctx, final byte b )
    {
        if ( b == Constants.SP )
        {
            ctx.attr ( ATTR_STATE ).set ( State.LENGTH );
        }
        else
        {
            ctx.attr ( ATTR_COMMAND_BUFFER ).get ().writeByte ( b );
        }
    }

    private void processTXNR ( final ChannelHandlerContext ctx, final byte b )
    {
        if ( b == Constants.SP )
        {
            ctx.attr ( ATTR_STATE ).set ( State.COMMAND );
        }
        else
        {
            if ( b < 0x30 || b > 0x39 )
            {
                throw new CodecException ( String.format ( "Invalid character found: 0x%1$02x (%1$s)", b, (char)b ) );
            }
            ctx.attr ( ATTR_TXNR_BUFFER ).get ().writeByte ( b );
        }
    }

    @Override
    public void write ( final ChannelHandlerContext ctx, final Object msg, final ChannelPromise promise ) throws Exception
    {
        if ( msg instanceof Frame )
        {
            processFrame ( ctx, (Frame)msg, promise );
        }
    }

    protected void processFrame ( final ChannelHandlerContext ctx, final Frame frame, final ChannelPromise promise )
    {
        final int length = frame.getData () == null ? 0 : frame.getData ().readableBytes ();

        final ByteBuf data = ctx.alloc ().buffer ();
        data.writeBytes ( String.format ( "%s", frame.getTransactionId () ).getBytes ( TXNR_CHARSET ) );
        data.writeByte ( Constants.SP );
        data.writeBytes ( frame.getCommand ().getBytes ( COMMAND_CHARSET ) );
        data.writeByte ( Constants.SP );
        data.writeBytes ( String.format ( "%s", length ).getBytes ( LENGTH_CHARSET ) );

        if ( length > 0 )
        {
            data.writeByte ( Constants.SP );
            data.writeBytes ( frame.getData () );
        }

        if ( frame.getData () != null )
        {
            frame.getData ().release ();
        }

        data.writeByte ( Constants.LF );

        ctx.write ( data );
    }
}
