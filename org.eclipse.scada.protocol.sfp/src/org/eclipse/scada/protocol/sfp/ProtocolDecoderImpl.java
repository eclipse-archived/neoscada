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
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolCodecException;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.protocol.sfp.messages.BrowseAdded;
import org.eclipse.scada.protocol.sfp.messages.DataType;
import org.eclipse.scada.protocol.sfp.messages.DataUpdate;
import org.eclipse.scada.protocol.sfp.messages.Hello;
import org.eclipse.scada.protocol.sfp.messages.Messages;
import org.eclipse.scada.protocol.sfp.messages.ReadAll;
import org.eclipse.scada.protocol.sfp.messages.SubscribeBrowse;
import org.eclipse.scada.protocol.sfp.messages.UnsubscribeBrowse;
import org.eclipse.scada.protocol.sfp.messages.Welcome;
import org.eclipse.scada.protocol.sfp.messages.WriteCommand;
import org.eclipse.scada.protocol.sfp.messages.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocolDecoderImpl extends CumulativeProtocolDecoder
{
    private final static Logger logger = LoggerFactory.getLogger ( ProtocolDecoderImpl.class );

    private final Charset defaultCharset;

    public ProtocolDecoderImpl ()
    {
        this.defaultCharset = Charset.forName ( Sessions.DEFAULT_CHARSET_NAME );
    }

    @Override
    protected boolean doDecode ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws Exception
    {
        byte marker1;
        byte marker2;

        do
        {
            if ( data.remaining () < 2 ) // we may only eat the start when there could be a packet after it
            {
                return false;
            }

            // peek marker
            marker1 = data.get ( data.position () + 0 );
            marker2 = data.get ( data.position () + 1 );

            // TODO: re-think the idea of just skipping

            if ( marker1 != 0x12 || marker2 != 0x02 )
            {
                data.skip ( 2 ); // eat garbage
            }
        } while ( marker1 != 0x12 || marker2 != 0x02 );

        if ( data.remaining () < 3 )
        {
            return false;
        }

        data.order ( Sessions.isLittleEndian ( session ) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN );

        final byte command = data.get ( data.position () + 2 );
        switch ( command )
        {
            case Messages.MC_HELLO:
                return processHello ( session, data, out );
            case Messages.MC_WELCOME:
                return processWelcome ( session, data, out );
            case Messages.MC_READ_ALL:
                out.write ( new ReadAll () );
                return true;
            case Messages.MC_DATA_UPDATE:
                return processDataUpdate ( session, data, out );
            case Messages.MC_START_BROWSE:
                out.write ( new SubscribeBrowse () );
                return true;
            case Messages.MC_STOP_BROWSE:
                out.write ( new UnsubscribeBrowse () );
                return true;
            case Messages.MC_NS_ADDED:
                return processBrowseAdded ( session, data, out );
            case Messages.MC_WRITE_COMMAND:
                return processWriteCommand ( session, data, out );
            case Messages.MC_WRITE_RESULT:
                return processWriteResult ( session, data, out );
        }

        throw new ProtocolCodecException ( String.format ( "Message code %02x is unkown", command ) );
    }

    private boolean processWriteCommand ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        final int registerNumber = data.getUnsignedShort ();
        final int operationId = data.getInt ();
        final Variant value = decodeVariant ( session, data );

        out.write ( new WriteCommand ( registerNumber, value, operationId ) );

        return true;
    }

    private boolean processWriteResult ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        try
        {
            final int operationId = data.getInt ();
            final int errorCode = data.getUnsignedShort ();
            final String errorMessage = decodeString ( session, data );

            out.write ( new WriteResult ( operationId, errorCode, errorMessage ) );
        }
        catch ( final CharacterCodingException e )
        {
            throw new ProtocolCodecException ( e );
        }

        return true;
    }

    private String decodeString ( final IoSession session, final IoBuffer data ) throws CharacterCodingException
    {
        final String result = data.getPrefixedString ( Sessions.getCharsetDecoder ( session ) );
        if ( result.isEmpty () )
        {
            return null;
        }
        else
        {
            return result;
        }
    }

    private boolean processDataUpdate ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        final int count = data.getUnsignedShort ();
        final List<DataUpdate.Entry> entries = new ArrayList<DataUpdate.Entry> ( count );
        for ( int i = 0; i < count; i++ )
        {
            entries.add ( decodeDataUpdateEntry ( data, session ) );
        }

        out.write ( new DataUpdate ( entries ) );

        return true;
    }

    /**
     * Decode a variant from the stream
     *
     * @return a decoded variant or <code>null</code> if the data type was
     *         {@link DataType#DEAD}
     * @throws ProtocolCodecException
     */
    private Variant decodeVariant ( final IoSession session, final IoBuffer data ) throws ProtocolCodecException
    {
        final byte b = data.get ();
        final DataType dataType = DataType.fromByte ( b );
        if ( dataType == null )
        {
            throw new ProtocolCodecException ( String.format ( "Data type %02x is unkown", b ) );
        }

        switch ( dataType )
        {
            case DEAD:
                return null;
            case NULL:
                return Variant.NULL;
            case BOOLEAN:
                return Variant.valueOf ( data.get () != 0x00 );
            case INT32:
                return Variant.valueOf ( data.getInt () );
            case INT64:
                return Variant.valueOf ( data.getInt () );
            case DOUBLE:
                return Variant.valueOf ( data.getDouble () );
            case STRING:
                try
                {
                    return Variant.valueOf ( decodeString ( session, data ) );
                }
                catch ( final CharacterCodingException e )
                {
                    throw new ProtocolCodecException ( e );
                }
            default:
                throw new ProtocolCodecException ( String.format ( "Data type %s is unkown", b ) );
        }
    }

    private DataUpdate.Entry decodeDataUpdateEntry ( final IoBuffer data, final IoSession session ) throws ProtocolCodecException
    {
        final int register = data.getUnsignedShort ();
        final byte missedUpdates = data.get ();
        final long timestamp = data.getLong ();
        final Set<DataUpdate.State> states = data.getEnumSetShort ( DataUpdate.State.class );

        final Variant value = decodeVariant ( session, data );

        return new DataUpdate.Entry ( register, value, timestamp, states, missedUpdates );
    }

    private boolean processWelcome ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        final EnumSet<Welcome.Features> features = data.getEnumSetShort ( Welcome.Features.class );

        final CharsetDecoder decoder = this.defaultCharset.newDecoder ();

        final int count = data.getUnsignedShort ();
        final Map<String, String> properties = new HashMap<String, String> ( count );

        for ( int i = 0; i < count; i++ )
        {
            try
            {
                final String key = data.getPrefixedString ( decoder );
                final String value = data.getPrefixedString ( decoder );

                properties.put ( key, value );
            }
            catch ( final CharacterCodingException e )
            {
                throw new ProtocolCodecException ( e );
            }
        }

        if ( features.contains ( Welcome.Features.LITTLE_ENDIAN ) )
        {
            logger.info ( "Setting little endian" );
            Sessions.setLittleEndian ( session );
        }

        out.write ( new Welcome ( features, properties ) );

        return true;
    }

    private boolean processBrowseAdded ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        final int count = data.getUnsignedShort ();

        final List<BrowseAdded.Entry> entries = new ArrayList<BrowseAdded.Entry> ( count );

        for ( int i = 0; i < count; i++ )
        {
            entries.add ( decodeBrowserAddEntry ( data, session ) );
        }

        out.write ( new BrowseAdded ( entries ) );

        return true;
    }

    private BrowseAdded.Entry decodeBrowserAddEntry ( final IoBuffer data, final IoSession session ) throws ProtocolCodecException
    {
        final short register = (short)data.getUnsignedShort ();
        // FIXME: validate if short works

        final byte b = data.get ();
        final DataType dataType = DataType.fromByte ( b );

        if ( dataType == null )
        {
            throw new ProtocolCodecException ( String.format ( "Data type %s is unkown", b ) );
        }

        final Set<BrowseAdded.Entry.Flags> flags = data.getEnumSet ( BrowseAdded.Entry.Flags.class );

        final CharsetDecoder decoder = Sessions.getCharsetDecoder ( session );

        try
        {
            final String name = data.getPrefixedString ( decoder );
            final String description = data.getPrefixedString ( decoder );
            final String unit = data.getPrefixedString ( decoder );
            return new BrowseAdded.Entry ( register, name, description, unit, dataType, flags );
        }
        catch ( final CharacterCodingException e )
        {
            throw new ProtocolCodecException ( e );
        }

    }

    private boolean processHello ( final IoSession session, final IoBuffer data, final ProtocolDecoderOutput out ) throws ProtocolCodecException
    {
        final int len = messageLength ( data );
        if ( len < 0 )
        {
            return false;
        }

        final byte version = data.get ();
        if ( version != 0x01 )
        {
            throw new ProtocolCodecException ( String.format ( "Protocol version %s is unsupported", version ) );
        }

        final short nodeId = data.getShort ();
        final EnumSet<Hello.Features> features = data.getEnumSetShort ( Hello.Features.class );

        out.write ( new Hello ( nodeId, features ) );

        return true;
    }

    private int messageLength ( final IoBuffer data )
    {
        final int len = data.getUnsignedShort ( data.position () + 3 );
        if ( data.remaining () < 5 + len )
        {
            return -1;
        }

        data.skip ( 5 );

        return len;
    }

}
