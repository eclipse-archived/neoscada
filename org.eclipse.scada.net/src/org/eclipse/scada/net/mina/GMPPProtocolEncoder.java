/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.eclipse.scada.net.base.data.BooleanValue;
import org.eclipse.scada.net.base.data.DoubleValue;
import org.eclipse.scada.net.base.data.IntegerValue;
import org.eclipse.scada.net.base.data.ListValue;
import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.net.base.data.Value;
import org.eclipse.scada.net.base.data.VoidValue;
import org.eclipse.scada.net.codec.InvalidValueTypeException;

public class GMPPProtocolEncoder implements ProtocolEncoder, GMPPProtocol
{
    private final ThreadLocal<CharsetEncoder> encoderLocal = new ThreadLocal<CharsetEncoder> () {
        @Override
        protected CharsetEncoder initialValue ()
        {
            return Charset.forName ( "utf-8" ).newEncoder ();
        }
    };

    @Override
    public void dispose ( final IoSession session ) throws Exception
    {
        // Do nothing
    }

    @Override
    public void encode ( final IoSession session, final Object message, final ProtocolEncoderOutput out ) throws Exception
    {
        if ( message instanceof Message )
        {
            out.write ( code ( (Message)message ) );
        }
        else if ( message instanceof IoBuffer && ! ( (IoBuffer)message ).hasRemaining () )
        {
            System.err.println ( "Empty buffer" );
            out.write ( message );
        }
        else
        {
            throw new IllegalArgumentException ( "Protocol encoder can only handle messages of type 'Message'" );
        }
    }

    private void encodeToStream ( final IoBuffer buffer, final String data )
    {
        buffer.putInt ( 0 );
        final int pos = buffer.position ();

        try
        {
            buffer.putString ( data, this.encoderLocal.get () );
            final int afterPos = buffer.position ();
            final int len = afterPos - pos;
            buffer.putInt ( pos - 4, len );
        }
        catch ( final CharacterCodingException e )
        {
            throw new RuntimeException ( "Failed to encode", e );
        }
    }

    private void encodeToStream ( final IoBuffer buffer, final IntegerValue value )
    {
        buffer.putInt ( VT_INTEGER );
        buffer.putInt ( 4 );
        buffer.putInt ( value.value );
    }

    private void encodeToStream ( final IoBuffer buffer, final LongValue value )
    {
        buffer.putInt ( VT_LONG );
        buffer.putInt ( 8 );
        buffer.putLong ( value.getValue () );
    }

    private void encodeToStream ( final IoBuffer buffer, final DoubleValue value )
    {
        buffer.putInt ( VT_DOUBLE );
        buffer.putInt ( 8 );
        buffer.putLong ( Double.doubleToRawLongBits ( value.getValue () ) );
    }

    private void encodeToStream ( final IoBuffer buffer, final VoidValue value )
    {
        buffer.putInt ( VT_VOID );
        buffer.putInt ( 0 );
    }

    private void encodeToStream ( final IoBuffer buffer, final BooleanValue value )
    {
        buffer.putInt ( VT_BOOLEAN );
        buffer.putInt ( 1 );
        buffer.put ( value.getValue () ? (byte)0xFF : (byte)0x00 );
    }

    private void encodeToStream ( final IoBuffer buffer, final StringValue value )
    {
        buffer.putInt ( VT_STRING );
        encodeToStream ( buffer, value.getValue () );
    }

    private void encodeToStream ( final IoBuffer buffer, final ListValue value ) throws InvalidValueTypeException
    {
        buffer.putInt ( VT_LIST );
        final int position = buffer.position (); // remember position
        buffer.putInt ( 0 ); // dummy size length

        final int startPos = buffer.position ();
        buffer.putInt ( value.getValues ().size () );

        for ( final Value valueEntry : value.getValues () )
        {
            codeValue ( buffer, valueEntry );
        }
        final int size = buffer.position () - startPos;

        buffer.putInt ( position, size ); // set value size
    }

    private void encodeToStream ( final IoBuffer buffer, final MapValue value ) throws InvalidValueTypeException
    {
        buffer.putInt ( VT_MAP );
        final int position = buffer.position (); // remember position
        buffer.putInt ( 0 ); // dummy size length

        final int startPos = buffer.position ();
        buffer.putInt ( value.getValues ().size () );

        for ( final Map.Entry<String, Value> valueEntry : value.getValues ().entrySet () )
        {
            codeValue ( buffer, valueEntry.getKey (), valueEntry.getValue () );
        }
        final int size = buffer.position () - startPos;

        buffer.putInt ( position, size ); // set value size
    }

    private void codeValue ( final IoBuffer buffer, final Value value ) throws InvalidValueTypeException
    {
        if ( value == null )
        {
            // at least provide some more information
            throw new NullPointerException ( "Trying to encode a 'null' value. Use VoidValue instead!" );
        }
        final Class<?> clazz = value.getClass ();

        if ( clazz == StringValue.class )
        {
            encodeToStream ( buffer, (StringValue)value );
        }
        else if ( clazz == BooleanValue.class )
        {
            encodeToStream ( buffer, (BooleanValue)value );
        }
        else if ( clazz == IntegerValue.class )
        {
            encodeToStream ( buffer, (IntegerValue)value );
        }
        else if ( clazz == LongValue.class )
        {
            encodeToStream ( buffer, (LongValue)value );
        }
        else if ( clazz == DoubleValue.class )
        {
            encodeToStream ( buffer, (DoubleValue)value );
        }
        else if ( clazz == VoidValue.class )
        {
            encodeToStream ( buffer, (VoidValue)value );
        }
        else if ( clazz == ListValue.class )
        {
            encodeToStream ( buffer, (ListValue)value );
        }
        else if ( clazz == MapValue.class )
        {
            encodeToStream ( buffer, (MapValue)value );
        }
        else
        {
            throw new InvalidValueTypeException ( String.format ( "The type '%s' is unknown", value.getClass ().getName () ) );
        }
    }

    private void codeValue ( final IoBuffer buffer, final String name, final Value value ) throws InvalidValueTypeException
    {
        codeValue ( buffer, value );
        encodeToStream ( buffer, name );
    }

    public IoBuffer code ( final Message message ) throws InvalidValueTypeException
    {
        final IoBuffer outputBuffer = IoBuffer.allocate ( HEADER_SIZE );

        outputBuffer.setAutoExpand ( true );
        outputBuffer.clear ();

        outputBuffer.putInt ( message.getCommandCode () );
        outputBuffer.putLong ( message.getTimestamp () );
        outputBuffer.putLong ( message.getSequence () );
        outputBuffer.putLong ( message.getReplySequence () );
        final int sizePos = outputBuffer.position ();
        outputBuffer.putInt ( 0 ); // dummy body size

        final int startPos = outputBuffer.position ();
        codeValue ( outputBuffer, message.getValues () );
        final int bodySize = outputBuffer.position () - startPos;
        outputBuffer.putInt ( sizePos, bodySize );

        outputBuffer.flip ();

        return outputBuffer;
    }
}
