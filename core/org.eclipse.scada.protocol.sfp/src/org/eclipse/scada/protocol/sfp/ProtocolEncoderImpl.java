/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.sfp;

import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecException;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.protocol.sfp.messages.BrowseAdded;
import org.eclipse.scada.protocol.sfp.messages.DataType;
import org.eclipse.scada.protocol.sfp.messages.DataUpdate;
import org.eclipse.scada.protocol.sfp.messages.DataUpdate.Entry;
import org.eclipse.scada.protocol.sfp.messages.Hello;
import org.eclipse.scada.protocol.sfp.messages.Messages;
import org.eclipse.scada.protocol.sfp.messages.ReadAll;
import org.eclipse.scada.protocol.sfp.messages.SubscribeBrowse;
import org.eclipse.scada.protocol.sfp.messages.UnsubscribeBrowse;
import org.eclipse.scada.protocol.sfp.messages.Welcome;
import org.eclipse.scada.protocol.sfp.messages.WriteCommand;
import org.eclipse.scada.protocol.sfp.messages.WriteResult;

public class ProtocolEncoderImpl implements ProtocolEncoder
{

    private final Charset defaultCharset;

    public ProtocolEncoderImpl ()
    {
        this.defaultCharset = Charset.forName ( Sessions.DEFAULT_CHARSET_NAME );
    }

    @Override
    public void dispose ( final IoSession session ) throws Exception
    {
    }

    protected IoBuffer createMessage ( final IoSession session, final byte command, final boolean longMessage )
    {
        final IoBuffer data = IoBuffer.allocate ( 3 );
        data.setAutoExpand ( true );

        if ( Sessions.isLittleEndian ( session ) )
        {
            data.order ( ByteOrder.LITTLE_ENDIAN );
        }

        data.put ( (byte)0x12 );
        data.put ( (byte)0x02 );
        data.put ( command );
        if ( longMessage )
        {
            data.putShort ( (short)0 );
        }
        return data;
    }

    @Override
    public void encode ( final IoSession session, final Object message, final ProtocolEncoderOutput out ) throws Exception
    {
        IoBuffer data = null;
        if ( message instanceof Hello )
        {
            data = createMessage ( session, Messages.MC_HELLO, true );

            data.put ( (byte)0x01 ); // version

            data.putShort ( ( (Hello)message ).getNodeId () );
            data.putEnumSetShort ( ( (Hello)message ).getFeatures () );

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }
        else if ( message instanceof Welcome )
        {
            data = createMessage ( session, Messages.MC_WELCOME, true );

            // put bit set
            data.putEnumSetShort ( ( (Welcome)message ).getFeatures () );
            encodeProperties ( data, ( (Welcome)message ).getProperties () );

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }
        else if ( message instanceof ReadAll )
        {
            data = createMessage ( session, Messages.MC_READ_ALL, false );

        }
        else if ( message instanceof DataUpdate )
        {
            data = createMessage ( session, Messages.MC_DATA_UPDATE, true );

            data.putUnsignedShort ( ( (DataUpdate)message ).getEntries ().size () );
            // put values
            for ( final DataUpdate.Entry entry : ( (DataUpdate)message ).getEntries () )
            {
                encodeEntry ( session, data, entry );
            }

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }
        else if ( message instanceof SubscribeBrowse )
        {
            data = createMessage ( session, Messages.MC_START_BROWSE, false );
        }
        else if ( message instanceof UnsubscribeBrowse )
        {
            data = createMessage ( session, Messages.MC_STOP_BROWSE, false );
        }
        else if ( message instanceof BrowseAdded )
        {
            data = createMessage ( session, Messages.MC_NS_ADDED, true );

            // put browse update
            encodeBrowseUpdate ( session, message, data );

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }
        else if ( message instanceof WriteCommand )
        {
            data = createMessage ( session, Messages.MC_WRITE_COMMAND, true );

            data.putUnsignedShort ( ( (WriteCommand)message ).getRegisterNumber () );
            data.putInt ( ( (WriteCommand)message ).getOperationId () );
            encodeVariant ( session, data, ( (WriteCommand)message ).getValue () );

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }
        else if ( message instanceof WriteResult )
        {
            data = createMessage ( session, Messages.MC_WRITE_RESULT, true );

            data.putInt ( ( (WriteResult)message ).getOperationId () );
            data.putUnsignedShort ( ( (WriteResult)message ).getErrorCode () );

            data.putPrefixedString ( ( (WriteResult)message ).getErrorMessage (), Sessions.getCharsetEncoder ( session ) );

            data.putUnsignedShort ( 3, data.position () - 3 ); // fill length
        }

        if ( data != null )
        {
            data.flip ();
            out.write ( data );
        }
        else
        {
            throw new ProtocolCodecException ( String.format ( "Message %s is not supported", message.getClass ().getName () ) );
        }
    }

    private void encodeBrowseUpdate ( final IoSession session, final Object message, final IoBuffer data ) throws ProtocolCodecException
    {
        // length
        data.putUnsignedShort ( ( (BrowseAdded)message ).getEntries ().size () );

        final CharsetEncoder encoder = Sessions.getCharsetEncoder ( session );

        // data
        for ( final BrowseAdded.Entry entry : ( (BrowseAdded)message ).getEntries () )
        {
            data.putUnsignedShort ( entry.getRegister () );
            data.put ( entry.getDataType ().getDataType () );
            data.putEnumSet ( entry.getFlags () );

            try
            {
                data.putPrefixedString ( entry.getName (), encoder );
                data.putPrefixedString ( entry.getDescription (), encoder );
                data.putPrefixedString ( entry.getUnit (), encoder );
            }
            catch ( final CharacterCodingException e )
            {
                throw new ProtocolCodecException ( e );
            }
        }
    }

    private void encodeProperties ( final IoBuffer data, final Map<String, String> properties ) throws ProtocolCodecException
    {
        final CharsetEncoder encoder = this.defaultCharset.newEncoder ();

        data.putUnsignedShort ( properties.size () );
        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            try
            {
                data.putPrefixedString ( entry.getKey (), encoder );
                data.putPrefixedString ( entry.getValue (), encoder );
            }
            catch ( final CharacterCodingException e )
            {
                throw new ProtocolCodecException ( e );
            }
        }
    }

    private void encodeVariant ( final IoSession session, final IoBuffer data, final Variant value ) throws ProtocolCodecException
    {
        if ( value == null )
        {
            data.put ( DataType.DEAD.getDataType () ); // dead
        }
        else if ( value.isNull () )
        {
            data.put ( DataType.NULL.getDataType () );
        }
        else if ( value.isBoolean () )
        {
            data.put ( DataType.BOOLEAN.getDataType () );
            data.put ( (byte) ( value.asBoolean () ? 0xFF : 0x00 ) );
        }
        else if ( value.isInteger () )
        {
            data.put ( DataType.INT32.getDataType () );
            data.putInt ( value.asInteger ( null ) );
        }
        else if ( value.isLong () )
        {
            data.put ( DataType.INT64.getDataType () );
            data.putLong ( value.asLong ( null ) );
        }
        else if ( value.isDouble () )
        {
            data.put ( DataType.DOUBLE.getDataType () );
            data.putDouble ( value.asDouble ( null ) );
        }
        else if ( value.isString () )
        {
            data.put ( DataType.STRING.getDataType () );
            try
            {
                data.putPrefixedString ( value.asString ( null ), Sessions.getCharsetEncoder ( session ) );
            }
            catch ( final CharacterCodingException e )
            {
                throw new ProtocolCodecException ( e );
            }
        }
    }

    private void encodeEntry ( final IoSession session, final IoBuffer data, final Entry entry ) throws ProtocolCodecException
    {
        data.putUnsignedShort ( entry.getRegister () );
        data.put ( entry.getMissedUpdates () );
        data.putLong ( entry.getTimestamp () );
        data.putEnumSetShort ( entry.getStates () );

        // put payload
        encodeVariant ( session, data, entry.getValue () );
    }

}