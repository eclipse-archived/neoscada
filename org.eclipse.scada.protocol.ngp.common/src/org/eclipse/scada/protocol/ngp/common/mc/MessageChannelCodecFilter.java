/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/


package org.eclipse.scada.protocol.ngp.common.mc;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.core.write.WriteRequestWrapper;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame;
import org.eclipse.scada.protocol.ngp.common.mc.frame.Frame.FrameType;
import org.eclipse.scada.protocol.ngp.common.mc.message.AcceptMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.CloseMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.DataMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.HelloMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.StartMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageChannelCodecFilter extends IoFilterAdapter
{

    private final static Logger logger = LoggerFactory.getLogger ( MessageChannelCodecFilter.class );

    private final class WriteRequestWrapperExtension extends WriteRequestWrapper
    {
        private final Object message;

        private WriteRequestWrapperExtension ( final WriteRequest parentRequest, final Object message )
        {
            super ( parentRequest );
            this.message = message;
        }

        @Override
        public Object getMessage ()
        {
            return this.message;
        }
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        logger.trace ( "messageReceived: {}", message );

        if ( ! ( message instanceof Frame ) )
        {
            throw new IllegalStateException ( "Can only handle Frame messages" );
        }

        final Frame frame = (Frame)message;
        switch ( frame.getType () )
        {
            case MESSAGE:
                // data messages are simply passed on
                nextFilter.messageReceived ( session, new DataMessage ( frame.getData () ) );
                break;
            case HELLO:
                nextFilter.messageReceived ( session, decodeHelloFrame ( session, frame.getData () ) );
                break;
            case ACCEPT:
                nextFilter.messageReceived ( session, decodeAcceptFrame ( session, frame.getData () ) );
                break;
            case CLOSE:
                nextFilter.messageReceived ( session, decodeCloseFrame ( session, frame.getData () ) );
                break;
            case START:
                nextFilter.messageReceived ( session, new StartMessage () );
                break;
            case PING:
                break;
            case PONG:
                break;
        }
    }

    private CloseMessage decodeCloseFrame ( final IoSession session, final IoBuffer data ) throws CharacterCodingException
    {
        return new CloseMessage ( data.getString ( getCharsetDecoder ( session ) ), data.getInt () );
    }

    private AcceptMessage decodeAcceptFrame ( final IoSession session, final IoBuffer data ) throws CharacterCodingException
    {
        return new AcceptMessage ( decodeProperties ( session, data ) );
    }

    private HelloMessage decodeHelloFrame ( final IoSession session, final IoBuffer data ) throws CharacterCodingException
    {
        return new HelloMessage ( decodeProperties ( session, data ) );
    }

    private Map<String, String> decodeProperties ( final IoSession session, final IoBuffer data ) throws CharacterCodingException
    {
        final int count = data.getInt ();

        final Map<String, String> result = new HashMap<String, String> ( count );

        final CharsetDecoder decoder = getCharsetDecoder ( session );

        for ( int i = 0; i < count; i++ )
        {
            final String key = data.getString ( decoder );
            final String value = data.getString ( decoder );
            result.put ( key, value );
        }

        return result;
    }

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        if ( writeRequest.getMessage () instanceof CloseMessage )
        {
            nextFilter.filterWrite ( session, new WriteRequestWrapperExtension ( writeRequest, encodeCloseMessage ( session, (CloseMessage)writeRequest.getMessage () ) ) );
        }
        else if ( writeRequest.getMessage () instanceof HelloMessage )
        {
            nextFilter.filterWrite ( session, new WriteRequestWrapperExtension ( writeRequest, encodeHelloMessage ( session, (HelloMessage)writeRequest.getMessage () ) ) );
        }
        else if ( writeRequest.getMessage () instanceof AcceptMessage )
        {
            nextFilter.filterWrite ( session, new WriteRequestWrapperExtension ( writeRequest, encodeAcceptMessage ( session, (AcceptMessage)writeRequest.getMessage () ) ) );
        }
        else if ( writeRequest.getMessage () instanceof StartMessage )
        {
            nextFilter.filterWrite ( session, new WriteRequestWrapperExtension ( writeRequest, encodeStartMessage ( session ) ) );
        }
        else if ( writeRequest.getMessage () instanceof DataMessage )
        {
            nextFilter.filterWrite ( session, new WriteRequestWrapperExtension ( writeRequest, makeMessageFrame ( (DataMessage)writeRequest.getMessage () ) ) );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "Unable to process message of type: %s", writeRequest.getMessage ().getClass () ) );
        }
    }

    private Frame makeMessageFrame ( final DataMessage message )
    {
        return new Frame ( FrameType.MESSAGE, message.getData () );
    }

    private Frame encodeStartMessage ( final IoSession session ) throws CharacterCodingException
    {
        return new Frame ( FrameType.START );
    }

    private Frame encodeAcceptMessage ( final IoSession session, final AcceptMessage message ) throws CharacterCodingException
    {
        return new Frame ( FrameType.ACCEPT, encodeProperties ( session, message.getProperties () ) );
    }

    private Frame encodeHelloMessage ( final IoSession session, final HelloMessage message ) throws CharacterCodingException
    {
        return new Frame ( FrameType.HELLO, encodeProperties ( session, message.getProperties () ) );
    }

    private IoBuffer encodeProperties ( final IoSession session, final Map<String, String> properties ) throws CharacterCodingException
    {
        final IoBuffer data = IoBuffer.allocate ( 0 );
        data.setAutoExpand ( true );

        data.putInt ( properties.size () );

        final CharsetEncoder encoder = getCharsetEncoder ( session );

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            final String key = entry.getKey ();
            final String value = entry.getValue ();

            data.putString ( key, encoder );
            data.put ( (byte)0x00 );
            data.putString ( value, encoder );
            data.put ( (byte)0x00 );
        }

        data.flip ();

        return data;
    }

    private Frame encodeCloseMessage ( final IoSession session, final CloseMessage message ) throws CharacterCodingException
    {
        final IoBuffer data = IoBuffer.allocate ( 0 );
        data.setAutoExpand ( true );
        data.putString ( message.getMessage (), getCharsetEncoder ( session ) );
        data.put ( (byte)0x00 );
        data.putInt ( message.getCode () );

        data.flip ();

        return new Frame ( FrameType.CLOSE, data );
    }

    private CharsetEncoder getCharsetEncoder ( final IoSession session )
    {
        if ( session.containsAttribute ( "charsetEncoder" ) )
        {
            return (CharsetEncoder)session.getAttribute ( "charsetEncoder" );
        }

        final CharsetEncoder encoder = Charset.forName ( "UTF-8" ).newEncoder ();
        session.setAttribute ( "charsetEncoder", encoder );
        return encoder;
    }

    private CharsetDecoder getCharsetDecoder ( final IoSession session )
    {
        if ( session.containsAttribute ( "charsetDecoder" ) )
        {
            return (CharsetDecoder)session.getAttribute ( "charsetDecoder" );
        }

        final CharsetDecoder decoder = Charset.forName ( "UTF-8" ).newDecoder ();
        session.setAttribute ( "charsetDecoder", decoder );
        return decoder;
    }

}
