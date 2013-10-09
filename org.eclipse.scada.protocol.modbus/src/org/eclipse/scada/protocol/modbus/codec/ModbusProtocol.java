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

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.modbus.Constants;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.Pdu;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataResponse;
import org.eclipse.scada.protocol.modbus.message.WriteSingleCoilRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataResponse;

public class ModbusProtocol
{
    public static Pdu encodeAsMaster ( final BaseMessage message )
    {
        final IoBuffer data = IoBuffer.allocate ( 256 );
        if ( message instanceof ReadRequest )
        {
            final ReadRequest readMessage = (ReadRequest)message;
            data.put ( readMessage.getFunctionCode () );
            data.putUnsignedShort ( readMessage.getStartAddress () );
            data.putUnsignedShort ( readMessage.getQuantity () );
        }
        else if ( message instanceof WriteDataRequest )
        {
            final WriteDataRequest writeMessage = (WriteDataRequest)message;
            final int numberOfRegisters = writeMessage.getData ().length / 2;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getStartAddress () );
            data.putUnsignedShort ( numberOfRegisters );
            data.putUnsigned ( writeMessage.getData ().length );
            data.put ( writeMessage.getData () );
        }
        else if ( message instanceof WriteSingleCoilRequest )
        {
            final WriteSingleCoilRequest writeMessage = (WriteSingleCoilRequest)message;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getAddress () );
            data.put ( writeMessage.getValue () ? (byte)0xFF : (byte)0x00 );
            data.put ( (byte)0x00 );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unsupported message type: %s", message.getClass () ) );
        }

        data.flip ();
        return new Pdu ( message.getUnitIdentifier (), data );
    }

    public static Object decodeAsMaster ( final Pdu message )
    {
        final IoBuffer data = message.getData ();

        final byte functionCode = data.get ();

        if ( ( functionCode & Constants.FUNCTION_CODE_ERROR_FLAG ) != 0 )
        {
            final byte exceptionCode = data.get ();
            return new ErrorResponse ( message.getUnitIdentifier (), (byte) ( functionCode & ~Constants.FUNCTION_CODE_ERROR_FLAG ), exceptionCode );
        }

        switch ( functionCode )
        {
            case Constants.FUNCTION_CODE_READ_COILS:
            case Constants.FUNCTION_CODE_READ_DISCRETE_INPUTS:
            case Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS:
            case Constants.FUNCTION_CODE_READ_INPUT_REGISTERS:
                return new ReadResponse ( message.getUnitIdentifier (), functionCode, readBytes ( data ) );
            case Constants.FUNCTION_CODE_WRITE_SINGLE_COIL:
            case Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER:
                return new WriteSingleDataResponse ( message.getUnitIdentifier (), functionCode, IoBuffer.wrap ( new byte[] { data.get (), data.get () } ) );
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                return new WriteMultiDataResponse ( message.getUnitIdentifier (), functionCode, data.getShort (), data.getShort () );
            default:
                throw new IllegalStateException ( String.format ( "Function code %02x is not supported", functionCode ) );
        }
    }

    private static IoBuffer readBytes ( final IoBuffer buffer )
    {
        final short numOfBytes = buffer.getUnsigned ();
        final byte[] result = new byte[numOfBytes];
        buffer.get ( result, 0, numOfBytes );
        return IoBuffer.wrap ( result );
    }
}
