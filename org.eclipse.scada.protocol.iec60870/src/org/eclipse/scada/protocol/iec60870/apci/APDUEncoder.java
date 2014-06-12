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
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.ReferenceCountUtil;

import java.nio.ByteOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APDUEncoder extends MessageToByteEncoder<APCIBase>
{
    private final static Logger logger = LoggerFactory.getLogger ( APDUEncoder.class );

    public APDUEncoder ()
    {
        super ( APCIBase.class );
    }

    @Override
    protected void encode ( final ChannelHandlerContext ctx, final APCIBase msg, final ByteBuf out ) throws Exception
    {
        logger.trace ( "encode - ctx: {}, msg: {}", ctx, msg );

        if ( msg instanceof UnnumberedControl )
        {
            handleUFormat ( (UnnumberedControl)msg, out );
        }
        else if ( msg instanceof Supervisory )
        {
            handleSFormat ( (Supervisory)msg, out );
        }
        else if ( msg instanceof InformationTransfer )
        {
            handleIFormat ( (InformationTransfer)msg, out );
        }
    }

    private void handleIFormat ( final InformationTransfer msg, ByteBuf out )
    {
        final ByteBuf data = msg.getData ();
        try
        {
            out = out.order ( ByteOrder.LITTLE_ENDIAN );

            final int len = data.readableBytes ();

            if ( len > Constants.APCI_MAX_DATA_LENGTH )
            {
                throw new EncoderException ( String.format ( "Packet too big - %s bytes", len ) );
            }

            out.ensureWritable ( 6 + len );
            out.writeByte ( Constants.START_BYTE );
            out.writeByte ( 4 + len );
            out.writeShort ( msg.getSendSequenceNumber () << 1 );
            out.writeShort ( msg.getReceiveSequenceNumber () << 1 );
            out.writeBytes ( data );
        }
        finally
        {
            ReferenceCountUtil.release ( msg.getData () );
        }
    }

    private void handleSFormat ( final Supervisory msg, ByteBuf out )
    {
        out = out.order ( ByteOrder.LITTLE_ENDIAN );

        out.ensureWritable ( 6 );
        out.writeByte ( Constants.START_BYTE );
        out.writeByte ( 4 );
        out.writeBytes ( new byte[] { 0x01, 0x00 } );
        out.writeShort ( msg.getReceiveSequenceNumber () << 1 );
    }

    private void handleUFormat ( final UnnumberedControl msg, final ByteBuf out )
    {
        out.ensureWritable ( 6 );
        out.writeByte ( Constants.START_BYTE );
        out.writeByte ( 4 );
        out.writeByte ( msg.getFunction ().getNumericValue () | 0x03 /* bits 1 and 2*/);
        out.writeZero ( 3 );
    }
}
