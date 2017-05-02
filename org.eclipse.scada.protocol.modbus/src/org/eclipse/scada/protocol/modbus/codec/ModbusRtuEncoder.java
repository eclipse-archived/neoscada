/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.codec;

import java.nio.ByteOrder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.eclipse.scada.protocol.common.Checksum;
import org.eclipse.scada.protocol.modbus.message.Pdu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusRtuEncoder extends ProtocolEncoderAdapter
{

    private final static Logger logger = LoggerFactory.getLogger ( ModbusRtuEncoder.class );

    @Override
    public void encode ( final IoSession session, final Object message, final ProtocolEncoderOutput out ) throws Exception
    {
        logger.debug ( "Encoding: {}", message );
        final Pdu request = (Pdu)message;

        final IoBuffer buffer = IoBuffer.allocate ( request.getData ().remaining () + 3 );
        buffer.setAutoExpand ( true );

        final IoBuffer pdu = request.getData ();

        // put slave id
        buffer.put ( request.getUnitIdentifier () );
        // put data
        buffer.put ( pdu );

        // make and put crc
        final int crc = Checksum.crc16 ( buffer.array (), 0, pdu.limit () + 1 ); // including slave address
        buffer.order ( ByteOrder.LITTLE_ENDIAN );
        buffer.putShort ( (short)crc );

        buffer.flip ();

        logger.trace ( "Encoded to: {}", buffer );

        out.write ( buffer );
    }

}
