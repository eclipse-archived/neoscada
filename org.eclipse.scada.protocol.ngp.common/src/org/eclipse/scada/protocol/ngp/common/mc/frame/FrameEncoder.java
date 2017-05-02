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
 *     IBH SYSTEMS GmbH - add logging
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common.mc.frame;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameEncoder implements ProtocolEncoder
{
    private final static Logger logger = LoggerFactory.getLogger ( FrameEncoder.class );

    public FrameEncoder ()
    {
    }

    @Override
    public void dispose ( final IoSession session ) throws Exception
    {
    }

    @Override
    public void encode ( final IoSession session, final Object message, final ProtocolEncoderOutput output ) throws Exception
    {
        if ( ! ( message instanceof Frame ) )
        {
            throw new IllegalStateException ( String.format ( "Can only encode messages of type Frame but got %s", message.getClass () ) );
        }

        final Frame frame = (Frame)message;

        if ( logger.isTraceEnabled () )
        {
            logger.trace ( "Encode frame - type: {}, data: {}", frame.getType (), frame.getData () );
        }

        final IoBuffer buffer = IoBuffer.allocate ( 1 + 1 + 4 + frame.getData ().remaining () );
        buffer.put ( (byte)0x01 ); // version - #0
        buffer.put ( (byte)frame.getType ().ordinal () ); // frame type - #1
        buffer.putInt ( frame.getData ().remaining () ); // data size - #2
        buffer.put ( frame.getData () ); // data - #6
        buffer.flip ();

        output.write ( buffer );
    }
}