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

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GMPPProtocolDecoder extends CumulativeProtocolDecoder implements GMPPProtocol
{
    private final static Logger logger = LoggerFactory.getLogger ( GMPPProtocolDecoder.class );

    private final ThreadLocal<Charset> decoderLocal = new ThreadLocal<Charset> () {
        @Override
        protected Charset initialValue ()
        {
            return Charset.forName ( "utf-8" );
        }
    };

    private final static boolean disableIntern = Boolean.getBoolean ( "org.eclipse.scada.net.mina.GMPPProtocolDecoder.disableIntern" );

    private String decodeStringFromStream ( final IoBuffer buffer, final int size )
    {
        final ByteBuffer data = buffer.buf ().slice ();
        data.limit ( size );

        final String result = this.decoderLocal.get ().decode ( data ).toString ();

        buffer.skip ( size );

        if ( disableIntern )
        {
            return result;
        }
        else
        {
            return result.intern ();
        }
    }

    private Value decodeValueFromStream ( final IoBuffer buffer )
    {
        final int type = buffer.getInt ();
        final int len = buffer.getInt ();

        logger.trace ( "Additional data: {} len: {}", type, len );

        switch ( type )
        {
        case VT_LONG:
            return LongValue.valueOf ( buffer.getLong () );
        case VT_INTEGER:
            return IntegerValue.valueOf ( buffer.getInt () );
        case VT_STRING:
            return new StringValue ( decodeStringFromStream ( buffer, len ) );
        case VT_DOUBLE:
            return decodeDoubleValueFromStream ( buffer );
        case VT_BOOLEAN:
            return BooleanValue.valueOf ( buffer.get () != 0 );
        case VT_VOID:
            return VoidValue.INSTANCE;
            // nothing to read
        case VT_LIST:
            return decodeListValueFromStream ( buffer );
        case VT_MAP:
            return decodeMapValueFromStream ( buffer );
        default:
            // unknown type: only consume data
            buffer.position ( buffer.position () + len );
            break;
        }
        return null;
    }

    private DoubleValue decodeDoubleValueFromStream ( final IoBuffer buffer )
    {
        final double d = Double.longBitsToDouble ( buffer.getLong () );
        return new DoubleValue ( d );
    }

    private ListValue decodeListValueFromStream ( final IoBuffer buffer )
    {
        final int items = buffer.getInt ();

        final ArrayList<Value> values = new ArrayList<Value> ( items );

        for ( int i = 0; i < items; i++ )
        {
            values.add ( decodeValueFromStream ( buffer ) );
        }

        return new ListValue ( values );
    }

    private MapValue decodeMapValueFromStream ( final IoBuffer buffer )
    {
        final int items = buffer.getInt ();

        final Map<String, Value> values = new HashMap<String, Value> ( items );

        for ( int i = 0; i < items; i++ )
        {
            final Value value = decodeValueFromStream ( buffer );
            final String key = decodeStringFromStream ( buffer, buffer.getInt () );
            values.put ( key, value );
        }

        return new MapValue ( values );
    }

    private Message decodeMessageFromStream ( final IoBuffer inputBuffer )
    {
        // read the packet
        final Message message = new Message ();
        message.setCommandCode ( inputBuffer.getInt () );
        message.setTimestamp ( inputBuffer.getLong () );
        message.setSequence ( inputBuffer.getLong () );
        message.setReplySequence ( inputBuffer.getLong () );

        inputBuffer.getInt (); // re-read to remove from buffer

        final Value value = decodeValueFromStream ( inputBuffer );
        if ( value instanceof MapValue )
        {
            message.setValues ( (MapValue)value );
        }

        return message;
    }

    @Override
    protected boolean doDecode ( final IoSession session, final IoBuffer inputBuffer, final ProtocolDecoderOutput out ) throws Exception
    {
        while ( inputBuffer.remaining () >= HEADER_SIZE )
        {
            // peek body size
            final int bodySize = inputBuffer.getInt ( inputBuffer.position () + 4 + 8 + 8 + 8 );

            if ( inputBuffer.remaining () < HEADER_SIZE + bodySize )
            {
                // message is not complete so skip for next try
                return false;
            }

            final Message message = decodeMessageFromStream ( inputBuffer );

            if ( message != null )
            {
                out.write ( message );
            }

        }
        return false;
    }

}
