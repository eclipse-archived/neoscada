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
import org.eclipse.scada.protocol.modbus.Constants;
import org.eclipse.scada.protocol.modbus.message.BaseMessage;
import org.eclipse.scada.protocol.modbus.message.ErrorResponse;
import org.eclipse.scada.protocol.modbus.message.Pdu;
import org.eclipse.scada.protocol.modbus.message.ReadRequest;
import org.eclipse.scada.protocol.modbus.message.ReadResponse;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteMultiDataResponse;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataRequest;
import org.eclipse.scada.protocol.modbus.message.WriteSingleDataResponse;

public class ModbusProtocol
{
    public static Pdu encodeAsMaster ( final BaseMessage message, final ByteOrder dataOrder )
    {
        final IoBuffer data = IoBuffer.allocate ( 256 );
        if ( message instanceof ReadRequest )
        {
            final ReadRequest readMessage = (ReadRequest)message;
            data.put ( readMessage.getFunctionCode () );
            data.putUnsignedShort ( readMessage.getStartAddress () );
            data.putUnsignedShort ( readMessage.getQuantity () );
        }
        else if ( message instanceof WriteMultiDataRequest )
        {
            final WriteMultiDataRequest writeMessage = (WriteMultiDataRequest)message;
            final int numberOfRegisters = writeMessage.getData ().length / 2;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getStartAddress () );
            data.putUnsignedShort ( numberOfRegisters );
            data.putUnsigned ( writeMessage.getData ().length );

            encodeData ( data, IoBuffer.wrap ( writeMessage.getData () ), dataOrder );
        }
        else if ( message instanceof WriteSingleDataRequest )
        {
            final WriteSingleDataRequest writeMessage = (WriteSingleDataRequest)message;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getAddress () );

            // change byte order first

            final ByteOrder bo = data.order ();
            data.order ( dataOrder );
            data.putUnsignedShort ( writeMessage.getValue () );
            data.order ( bo );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unsupported message type: %s", message.getClass () ) );
        }

        data.flip ();
        return new Pdu ( message.getTransactionId (), message.getUnitIdentifier (), data );
    }

    public static Pdu encodeAsSlave ( final BaseMessage message, final ByteOrder dataOrder )
    {
        final IoBuffer data = IoBuffer.allocate ( 256 );
        if ( message instanceof ReadResponse )
        {
            final ReadResponse readResponseMessage = (ReadResponse)message;
            data.put ( readResponseMessage.getFunctionCode () );
            final int length = readResponseMessage.getData ().remaining ();
            data.put ( (byte)length );
            encodeData ( data, readResponseMessage.getData (), dataOrder );
        }
        else if ( message instanceof WriteMultiDataResponse )
        {
            final WriteMultiDataResponse writeResponseMessage = (WriteMultiDataResponse)message;
            data.put ( writeResponseMessage.getFunctionCode () );
            data.putUnsignedShort ( writeResponseMessage.getStartAddress () );
            data.putUnsignedShort ( writeResponseMessage.getNumRegisters () );
        }
        else if ( message instanceof WriteSingleDataResponse )
        {
            final WriteSingleDataResponse writeResponseMessage = (WriteSingleDataResponse)message;
            data.put ( writeResponseMessage.getFunctionCode () );
            data.putUnsignedShort ( writeResponseMessage.getAddress () );

            final ByteOrder bo = data.order ();
            data.order ( dataOrder );
            data.putUnsignedShort ( writeResponseMessage.getValue () );
            data.order ( bo );
        }
        else if ( message instanceof ErrorResponse )
        {
            final ErrorResponse errorResponseMessage = (ErrorResponse)message;
            data.put ( errorResponseMessage.getFunctionCode () );
            data.put ( errorResponseMessage.getExceptionCode () );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unsupported message type: %s", message.getClass () ) );
        }

        data.flip ();
        return new Pdu ( message.getTransactionId (), message.getUnitIdentifier (), data );
    }

    public static Object decodeAsMaster ( final Pdu message, final ByteOrder dataOrder )
    {
        final IoBuffer data = message.getData ();

        final byte functionCode = data.get ();

        if ( ( functionCode & Constants.FUNCTION_CODE_ERROR_FLAG ) != 0 )
        {
            final byte exceptionCode = data.get ();
            return new ErrorResponse ( message.getTransactionId (), message.getUnitIdentifier (), (byte) ( functionCode & ~Constants.FUNCTION_CODE_ERROR_FLAG ), exceptionCode );
        }

        switch ( functionCode )
        {
            case Constants.FUNCTION_CODE_READ_COILS:
            case Constants.FUNCTION_CODE_READ_DISCRETE_INPUTS:
            case Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS:
            case Constants.FUNCTION_CODE_READ_INPUT_REGISTERS:
                return new ReadResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, readBytes ( data, dataOrder ) );
            case Constants.FUNCTION_CODE_WRITE_SINGLE_COIL:
            case Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER:
            {
                final int address = data.getUnsignedShort ();

                final ByteOrder bo = data.order ();
                data.order ( dataOrder );
                final int value = data.getUnsignedShort ();
                data.order ( bo );

                return new WriteSingleDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, address, value );
            }
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_COILS:
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                return new WriteMultiDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, data.getUnsignedShort (), data.getUnsignedShort () );
            default:
                throw new IllegalStateException ( String.format ( "Function code %02x is not supported", functionCode ) );
        }
    }

    public static Object decodeAsSlave ( final Pdu message, final ByteOrder dataOrder )
    {
        final IoBuffer data = message.getData ();

        final byte functionCode = data.get ();

        switch ( functionCode )
        {
            case Constants.FUNCTION_CODE_READ_COILS:
            case Constants.FUNCTION_CODE_READ_DISCRETE_INPUTS:
            case Constants.FUNCTION_CODE_READ_HOLDING_REGISTERS:
            case Constants.FUNCTION_CODE_READ_INPUT_REGISTERS:
                return new ReadRequest ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, data.getUnsignedShort (), data.getUnsignedShort () );
            case Constants.FUNCTION_CODE_WRITE_SINGLE_COIL:
            case Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER:
            {
                final int address = data.getUnsignedShort ();

                final ByteOrder bo = data.order ();
                data.order ( dataOrder );
                final int value = data.getUnsignedShort ();
                data.order ( bo );

                return new WriteSingleDataRequest ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, address, value );
            }
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_COILS:
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                final int startAddress = data.getUnsignedShort ();
                return new WriteMultiDataRequest ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, startAddress, readRemaining ( data, dataOrder ) );
            default:
                throw new IllegalStateException ( String.format ( "Function code %02x is not supported", functionCode ) );
        }
    }

    private static byte[] readRemaining ( final IoBuffer data, final ByteOrder dataOrder )
    {
        final byte[] b = new byte[data.remaining ()];
        data.get ( b );
        return convert ( b, dataOrder );
    }

    private static void encodeData ( final IoBuffer target, final IoBuffer source, final ByteOrder order )
    {
        final ByteOrder bo = target.order ();
        target.order ( order );

        while ( source.remaining () > 1 )
        {
            target.putUnsignedShort ( source.getUnsignedShort () );
        }

        target.order ( bo );
    }

    private static IoBuffer readBytes ( final IoBuffer buffer, final ByteOrder dataOrder )
    {
        final short numOfBytes = buffer.getUnsigned ();
        final byte[] result = new byte[numOfBytes];
        buffer.get ( result );
        return IoBuffer.wrap ( convert ( result, dataOrder ) );
    }

    private static byte[] convert ( final byte[] result, final ByteOrder dataOrder )
    {
        if ( dataOrder.equals ( ByteOrder.BIG_ENDIAN ) )
        {
            return result;
        }

        byte t;
        for ( int i = 0; i < result.length / 2; i++ )
        {
            t = result[i * 2];
            result[i * 2] = result[i * 2 + 1];
            result[i * 2 + 1] = t;
        }
        return result;
    }
}
