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

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.Pdu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusSlaveProtocolFilter extends IoFilterAdapter
{

    private final static Logger logger = LoggerFactory.getLogger ( ModbusSlaveProtocolFilter.class );

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        if ( writeRequest.getMessage () instanceof BaseMessage )
        {
            final Pdu pdu = ModbusProtocol.encodeAsSlave ( (BaseMessage)writeRequest.getMessage () );
            nextFilter.filterWrite ( session, new WriteRequestWrapper ( writeRequest ) {
                @Override
                public Object getMessage ()
                {
                    return pdu;
                };
            } );
        }
        else
        {
            nextFilter.filterWrite ( session, writeRequest );
        }
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        logger.trace ( "messageReceived - session: {}, message: {}", session, message );

        if ( message instanceof Pdu )
        {
            nextFilter.messageReceived ( session, ModbusProtocol.decodeAsSlave ( (Pdu)message ) );
        }
        else
        {
            nextFilter.messageReceived ( session, message );
        }
    }
}
