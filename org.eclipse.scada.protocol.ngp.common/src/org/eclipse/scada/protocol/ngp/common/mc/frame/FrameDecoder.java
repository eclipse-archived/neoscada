/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - minor cleanups and fixes
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common.mc.frame;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame.FrameType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameDecoder extends CumulativeProtocolDecoder
{

    private static final int HEADER_SIZE = 6;

    private final static Logger logger = LoggerFactory.getLogger ( FrameDecoder.class );

    public FrameDecoder ()
    {
    }

    @Override
    protected boolean doDecode ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput output ) throws Exception
    {
        logger.trace ( "decode data - session: {}, data: {}", session, data );

        if ( data.remaining () < HEADER_SIZE )
        {
            return false;
        }

        final int position = data.position ();

        final byte version = data.get ( position ); // peek at version
        if ( version != 0x01 )
        {
            throw new IllegalStateException ( String.format ( "Version 0x%02x is not supported.", version ) );
        }

        final int frameTypeOrdinal = data.get ( position + 1 ); // peek at frame type
        final FrameType frameType = FrameType.values ()[frameTypeOrdinal]; // may case an exception, that is ok then

        final int dataLength = data.getInt ( position + 2 ); // we need to look at "here" + 2

        logger.trace ( "Data length: {}, remainingData: {}", dataLength, data.remaining () - 6 );

        if ( data.remaining () < HEADER_SIZE + dataLength )
        {
            return false;
        }

        // consume fields
        data.get (); // version - #0
        data.get (); // frame type - #1
        data.getInt (); // dataLength - #2

        // data - #6
        final IoBuffer frameData = data.getSlice ( dataLength ); // this also consumes the buffer 'data'

        final Frame frame = new Frame ( frameType, frameData );

        logger.trace ( "Decoded frame: {} ... {} bytes remaining", frame, data.remaining () );
        output.write ( frame );

        return true;
    }
}