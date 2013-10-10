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


package org.eclipse.scada.ngp.common.codec.osbp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.message.DataMessage;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageDecoder;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageEncoder;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.MessageProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryProtocol implements MessageProtocol, MessageEncoder, MessageDecoder
{
    private final static Logger logger = LoggerFactory.getLogger ( BinaryProtocol.class );

    private final Map<Integer, BinaryMessageCodec> codeMap = new TreeMap<Integer, BinaryMessageCodec> ();

    private final Map<Class<?>, BinaryMessageCodec> classMap = new HashMap<Class<?>, BinaryMessageCodec> ();

    private final BinaryContext context;

    public BinaryProtocol ( final BinaryContext context, final Collection<BinaryMessageCodec> codecs )
    {
        this.context = context;

        // build up maps
        for ( final BinaryMessageCodec codec : codecs )
        {
            this.codeMap.put ( codec.getMessageCode (), codec );
            this.classMap.put ( codec.getMessageClass (), codec );
        }
    }

    @Override
    public MessageEncoder getEncoder ()
    {
        return this;
    }

    @Override
    public MessageDecoder getDecoder ()
    {
        return this;
    }

    @Override
    public Object decodeMessage ( final DataMessage message ) throws Exception
    {
        final IoBuffer data = message.getData ();

        // we only peek
        final int messageCode = data.getInt ( 0 );

        logger.trace ( "Decoding message: {}", messageCode );

        final BinaryMessageCodec codec = this.codeMap.get ( messageCode );
        if ( codec == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to decode unknown message code: 0x%08x", messageCode ) );
        }

        return codec.decodeMessage ( this.context, data );
    }

    @Override
    public DataMessage encodeMessage ( final Object message ) throws Exception
    {
        if ( message == null )
        {
            throw new NullPointerException ( "Unable to encode null messages" );
        }

        final BinaryMessageCodec codec = this.classMap.get ( message.getClass () );
        if ( codec == null )
        {
            throw new IllegalArgumentException ( String.format ( "Message class is unknown. Unable to encode: %s", message.getClass () ) );
        }

        return new DataMessage ( codec.encodeMessage ( this.context, message ) );
    }

}
