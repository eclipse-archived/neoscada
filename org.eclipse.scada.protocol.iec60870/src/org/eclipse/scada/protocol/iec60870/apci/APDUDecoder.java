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
package org.eclipse.scada.protocol.iec60870.apci;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;

import java.nio.ByteOrder;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.apci.UnnumberedControl.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APDUDecoder extends ByteToMessageDecoder
{

    private final static Logger logger = LoggerFactory.getLogger ( APDUDecoder.class );

    @Override
    protected void decode ( final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> out ) throws Exception
    {
        if ( logger.isTraceEnabled () )
        {
            logger.trace ( "decode - bytes: {}", ByteBufUtil.hexDump ( in ) );
        }

        if ( in.readableBytes () < Constants.APCI_MIN_LENGTH )
        {
            return;
        }

        final byte start = in.getByte ( 0 );
        if ( start != Constants.START_BYTE )
        {
            throw new DecoderException ( String.format ( "ACPI must start with 0x%02x but did with 0x%02x", Constants.START_BYTE, start ) );
        }

        final short len = in.getUnsignedByte ( 1 );

        if ( len > Constants.APCI_MAX_DATA_LENGTH )
        {
            throw new DecoderException ( String.format ( "APCI has a maximum length of %s bytes, but we received %s", Constants.APCI_MAX_DATA_LENGTH, len ) );
        }

        if ( in.readableBytes () < len + 2 )
        {
            return;
        }

        // we have the full InformationTransfer

        // skip start & len
        in.skipBytes ( 2 );

        // read control fields
        final ByteBuf controlFields = in.readSlice ( 4 );

        final ByteBuf data;
        if ( len > 4 )
        {
            data = Unpooled.copiedBuffer ( in.readSlice ( len - 4 ) ).order ( ByteOrder.LITTLE_ENDIAN );
        }
        else
        {
            data = null;
        }

        // now add the PDU

        out.add ( decode ( controlFields, data ) );
    }

    private APCIBase decode ( ByteBuf controlFields, final ByteBuf data )
    {
        logger.trace ( "Control Fields: {}", ByteBufUtil.hexDump ( controlFields ) );

        controlFields = controlFields.order ( ByteOrder.LITTLE_ENDIAN );

        final byte first = controlFields.getByte ( 0 );
        if ( ( first & 0x01 ) == 0 )
        {
            // I format
            final int sendSequenceNumber = controlFields.readUnsignedShort () >> 1;
            final int receiveSequenceNumber = controlFields.readUnsignedShort () >> 1;
            logger.debug ( "S: {}, R: {}", sendSequenceNumber, receiveSequenceNumber );
            return new InformationTransfer ( sendSequenceNumber, receiveSequenceNumber, data );
        }
        else if ( ( first & 0x03 ) == 1 )
        {
            // S format
            controlFields.skipBytes ( 2 );
            final int receiveSequenceNumber = controlFields.readUnsignedShort () >> 1;
            return new Supervisory ( receiveSequenceNumber );
        }
        else if ( ( first & 0x03 ) == 3 )
        {
            // U format
            final Function function = convertFunction ( controlFields.readUnsignedByte () );
            return new UnnumberedControl ( function );
        }

        // this should actually never happen

        throw new DecoderException ( "Invalid control fields" );
    }

    private Function convertFunction ( final int functions )
    {
        switch ( functions )
        {
            case 0x03 | 4:
                return Function.STARTDT_ACT;
            case 0x03 | 8:
                return Function.STARTDT_CONFIRM;
            case 0x03 | 16:
                return Function.STOPDT_ACT;
            case 0x03 | 32:
                return Function.STOPDT_CONFIRM;
            case 0x03 | 64:
                return Function.TESTFR_ACT;
            case 0x03 | 128:
                return Function.TESTFR_CONFIRM;
            default:
                throw new DecoderException ( String.format ( "Invalid function codes for U-format (%02x)", functions ) );
        }
    }
}
