/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecException;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.eclipse.scada.protocol.arduino.messages.CommonMessage;
import org.eclipse.scada.protocol.arduino.messages.ConfigurationMessage;
import org.eclipse.scada.protocol.arduino.messages.DataMessage;
import org.eclipse.scada.protocol.arduino.messages.WriteRequestMessage;

public class ArduinoCodec implements ProtocolEncoder, ProtocolDecoder
{

    private final Charset charset;

    public ArduinoCodec ()
    {
        this.charset = Charset.forName ( "ISO-8859-1" );
    }

    @Override
    public void decode ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput output ) throws Exception
    {
        final short magic = data.getShort ();
        final byte version = data.get ();
        final int sequence = data.getInt ();
        final byte commandCode = data.get ();

        if ( magic != 1202 )
        {
            throw new ProtocolCodecException ( String.format ( "Magic code should be 1202 but is %s", magic ) );
        }
        if ( version != 1 )
        {
            throw new ProtocolCodecException ( String.format ( "Version should be %s but is %s", 1, version ) );
        }

        decodeMessage ( sequence, commandCode, data, output );
    }

    private void decodeMessage ( final int sequence, final byte commandCode, final IoBuffer data, final ProtocolDecoderOutput output ) throws ProtocolCodecException
    {
        switch ( commandCode )
        {
            case 3:
                decodeResponseConfiguration ( data, output, sequence );
                break;
            case 5:
                decodeResponseData ( data, output, sequence );
                break;
        }

    }

    private void decodeResponseData ( final IoBuffer data, final ProtocolDecoderOutput output, final int sequence ) throws ProtocolCodecException
    {
        final byte nin = data.get ();

        final Object[] vars = new Object[nin];

        for ( int i = 0; i < nin; i++ )
        {
            vars[i] = decodeData ( data );
        }

        final DataMessage msg = new DataMessage ( sequence, CommandCode.RESPOND_DATA, vars );
        output.write ( msg );
    }

    private Object decodeData ( final IoBuffer data ) throws ProtocolCodecException
    {
        data.order ( ByteOrder.LITTLE_ENDIAN );

        final byte dataType = data.get ();
        switch ( dataType )
        {
            case 0:
                return null;
            case 1:
                return data.get () != 0x00;
            case 2:
                return data.getInt ();
            case 3:
                return data.getLong ();
            case 4:
                return data.getFloat ();
            default:
                throw new ProtocolCodecException ( String.format ( "Data type %02x is unknown", dataType ) );
        }

    }

    private void decodeResponseConfiguration ( final IoBuffer data, final ProtocolDecoderOutput output, final int sequence )
    {
        final byte nin = data.get ();
        final byte nout = data.get ();

        @SuppressWarnings ( "unchecked" )
        final Map<Integer, Object> parameters[] = new Map[nin + nout];

        while ( data.hasRemaining () )
        {
            final byte type = data.get ();
            final byte signalNumber = data.get ();
            final byte len = data.get ();

            final byte[] dataBuffer = new byte[len];
            data.get ( dataBuffer );

            if ( parameters[signalNumber] == null )
            {
                parameters[signalNumber] = new HashMap<Integer, Object> ();
            }
            parameters[signalNumber].put ( (int)type, convertData ( type, dataBuffer ) );
        }

        final ConfigurationMessage msg = new ConfigurationMessage ( sequence, CommandCode.RESPOND_CONFIGURATION, parameters );
        output.write ( msg );
    }

    private Object convertData ( final byte type, final byte[] dataBuffer )
    {
        switch ( type )
        {
            case 0x01:
                return dataBuffer[0];
            case 0x02:
                return String.valueOf ( this.charset.decode ( ByteBuffer.wrap ( dataBuffer ) ) );
            default:
                return dataBuffer;
        }
    }

    @Override
    public void finishDecode ( final IoSession session, final ProtocolDecoderOutput output ) throws Exception
    {
    }

    @Override
    public void dispose ( final IoSession session ) throws Exception
    {
    }

    @Override
    public void encode ( final IoSession session, final Object message, final ProtocolEncoderOutput output ) throws Exception
    {
        final IoBuffer data = IoBuffer.allocate ( 0 );
        data.order ( ByteOrder.LITTLE_ENDIAN );
        data.setAutoExpand ( true );

        if ( message instanceof WriteRequestMessage )
        {
            encodeHeader ( data, (CommonMessage)message );
            encodeWriteRequest ( data, (WriteRequestMessage)message );
        }
        else if ( message instanceof CommonMessage )
        {
            encodeHeader ( data, (CommonMessage)message );
        }
        data.flip ();
        output.write ( data );
    }

    private void encodeWriteRequest ( final IoBuffer data, final WriteRequestMessage message )
    {
        data.putShort ( message.getIndex () );
        final Object value = message.getData ();
        if ( value == null )
        {
            data.put ( (byte)0x00 );
        }
        else if ( value instanceof Boolean )
        {
            data.put ( (byte)0x01 );
            data.put ( (byte) ( (Boolean)value ? 0xFF : 0x00 ) );
        }
        else if ( value instanceof Float || value instanceof Double )
        {
            data.put ( (byte)0x04 );
            data.putFloat ( ( (Number)value ).floatValue () );
        }
        else if ( value instanceof Long )
        {
            data.put ( (byte)0x03 );
            data.putLong ( ( (Number)value ).longValue () );
        }
        else if ( value instanceof Number )
        {
            data.put ( (byte)0x02 );
            data.putInt ( ( (Number)value ).intValue () );
        }
        else if ( value instanceof String )
        {
            data.put ( (byte)0x02 );
            data.putInt ( Integer.parseInt ( (String)value ) );
        }
        else
        {
            throw new RuntimeException ( String.format ( "Unable to write request of type %s", value.getClass () ) );
        }
    }

    private void encodeHeader ( final IoBuffer data, final CommonMessage message )
    {
        data.putShort ( (short)1202 );
        data.put ( (byte)0x01 );
        data.putInt ( message.getSequence () );
        data.put ( message.getCommandCode ().getCommandCode () );
    }

}
