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

    /**
     * Convert the string to a {@link ByteOrder}
     * 
     * @param string
     *            the string to convert
     * @param defaultOrder
     *            the default data byte order to use when
     *            <code>string</string> is <code>null</code>
     * @return the byte order
     * @throws IllegalArgumentException
     *             if the string is neither <code>null</code>, "BIG_ENDIAN" nor
     *             "LITTLE_ENDIAN"
     */
    public static ByteOrder makeOrder ( final String string, final ByteOrder defaultOrder )
    {
        if ( string == null )
        {
            return defaultOrder;
        }

        if ( ByteOrder.BIG_ENDIAN.toString ().equals ( string ) )
        {
            return ByteOrder.BIG_ENDIAN;
        }
        if ( ByteOrder.LITTLE_ENDIAN.toString ().equals ( string ) )
        {
            return ByteOrder.LITTLE_ENDIAN;
        }
        throw new IllegalArgumentException ( String.format ( "'%s' is not a valid byte order", string ) );
    }

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
        else if ( message instanceof WriteMultiDataRequest )
        {
            final WriteMultiDataRequest writeMessage = (WriteMultiDataRequest)message;
            final int numberOfRegisters = writeMessage.getData ().length / 2;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getStartAddress () );
            data.putUnsignedShort ( numberOfRegisters );
            data.putUnsigned ( writeMessage.getData ().length );
            data.put ( writeMessage.getData () );
        }
        else if ( message instanceof WriteSingleDataRequest )
        {
            final WriteSingleDataRequest writeMessage = (WriteSingleDataRequest)message;
            data.put ( writeMessage.getFunctionCode () );
            data.putUnsignedShort ( writeMessage.getAddress () );
            data.putUnsignedShort ( writeMessage.getValue () );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unsupported message type: %s", message.getClass () ) );
        }

        data.flip ();
        return new Pdu ( message.getTransactionId (), message.getUnitIdentifier (), data );
    }

    public static Pdu encodeAsSlave ( final BaseMessage message )
    {
        final IoBuffer data = IoBuffer.allocate ( 256 );
        if ( message instanceof ReadResponse )
        {
            final ReadResponse readResponseMessage = (ReadResponse)message;
            data.put ( readResponseMessage.getFunctionCode () );
            final int length = readResponseMessage.getData ().remaining ();
            data.put ( (byte)length );
            final byte[] remainingData = new byte[length];
            readResponseMessage.getData ().get ( remainingData );
            data.put ( remainingData );
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
            data.putUnsignedShort ( writeResponseMessage.getValue () );
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

    public static Object decodeAsMaster ( final Pdu message )
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
                return new ReadResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, readBytes ( data ) );
            case Constants.FUNCTION_CODE_WRITE_SINGLE_COIL:
            case Constants.FUNCTION_CODE_WRITE_SINGLE_REGISTER:
                return new WriteSingleDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, data.getUnsignedShort (), data.getUnsignedShort () );
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_COILS:
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                return new WriteMultiDataResponse ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, data.getUnsignedShort (), data.getUnsignedShort () );
            default:
                throw new IllegalStateException ( String.format ( "Function code %02x is not supported", functionCode ) );
        }
    }

    public static Object decodeAsSlave ( final Pdu message )
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
                return new WriteSingleDataRequest ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, data.getUnsignedShort (), data.getUnsignedShort () );
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_COILS:
            case Constants.FUNCTION_CODE_WRITE_MULTIPLE_REGISTERS:
                final int startAddress = data.getUnsignedShort ();
                final byte[] b = new byte[data.remaining ()];
                data.get ( b );
                return new WriteMultiDataRequest ( message.getTransactionId (), message.getUnitIdentifier (), functionCode, startAddress, b );
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

    public static IoBuffer convertData ( final IoBuffer data, final ByteOrder dataOrder )
    {
        if ( dataOrder == ByteOrder.BIG_ENDIAN )
        {
            return data;
        }

        final IoBuffer result = IoBuffer.allocate ( data.capacity () );
        result.order ( dataOrder );

        for ( int i = 0; i < data.remaining () / 2; i++ )
        {
            // convert to LITTLE_ENDIAN
            result.putUnsignedShort ( data.getUnsignedShort ( i * 2 ) );
        }

        // the byte order we use is BIG_ENDIAN
        result.order ( ByteOrder.BIG_ENDIAN );

        return result;
    }

    public static byte[] encodeData ( final byte[] data, final ByteOrder dataOrder )
    {
        if ( dataOrder == ByteOrder.BIG_ENDIAN )
        {
            return data;
        }

        byte t;
        for ( int i = 0; i < data.length / 2; i++ )
        {
            t = data[i * 2];
            data[i * 2] = data[i * 2 + 1];
            data[i * 2 + 1] = t;
        }
        return data;
    }
}
