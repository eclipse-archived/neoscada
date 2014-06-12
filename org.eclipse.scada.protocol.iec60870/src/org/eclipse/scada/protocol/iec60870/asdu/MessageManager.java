/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.apci.InformationTransfer;
import org.eclipse.scada.protocol.iec60870.asdu.message.EncodeHelper;
import org.eclipse.scada.protocol.iec60870.asdu.message.Encodeable;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;
import org.eclipse.scada.protocol.iec60870.asdu.types.StandardCause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageManager
{

    private final static Logger logger = LoggerFactory.getLogger ( MessageManager.class );

    private static class MessageTypeId
    {
        private final byte typeId;

        private final InformationStructure informationStructure;

        public MessageTypeId ( final byte typeId, final InformationStructure informationStructure )
        {
            this.typeId = typeId;
            this.informationStructure = informationStructure;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.informationStructure == null ? 0 : this.informationStructure.hashCode () );
            result = prime * result + this.typeId;
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final MessageTypeId other = (MessageTypeId)obj;
            if ( this.informationStructure != other.informationStructure )
            {
                return false;
            }
            if ( this.typeId != other.typeId )
            {
                return false;
            }
            return true;
        }

        public static MessageTypeId valueOf ( final byte typeId, final InformationStructure informationStructure )
        {
            // TODO: this could be cached as well since we only have 256 * 2 options here
            return new MessageTypeId ( typeId, informationStructure );
        }

    }

    /**
     * A map of registered codecs
     */
    /*
     * TODO: this could also be an array in order to improve performance. We only have 256 * 2 codec possibilities. 
     */
    private final Map<MessageTypeId, MessageCodec> codecs = new ConcurrentHashMap<> ();

    private final ProtocolOptions options;

    public MessageManager ( final ProtocolOptions options )
    {
        this.options = options;
    }

    public ByteBuf receiveMessage ( final InformationTransfer informationTransfer, final List<Object> out )
    {
        if ( logger.isDebugEnabled () )
        {
            logger.debug ( "Received message: {} -> {}", informationTransfer, informationTransfer.getData () != null ? ByteBufUtil.hexDump ( informationTransfer.getData () ) : null );
        }

        final ByteBuf data = informationTransfer.getData ();

        final byte typeId = data.readByte ();
        final byte subTypeId = data.readByte ();

        final InformationStructure informationStructure = ( subTypeId & 0b10000000 ) > 0 ? InformationStructure.SEQUENCE : InformationStructure.SINGLE;
        final byte length = (byte) ( ~0b10000000 & subTypeId );

        final CauseOfTransmission causeOfTransmission = CauseOfTransmission.parse ( this.options, data );
        final ASDUAddress asduAddress = ASDUAddress.parse ( this.options, data );

        final ASDUHeader header = new ASDUHeader ( causeOfTransmission, asduAddress );

        final MessageCodec codec = this.codecs.get ( MessageTypeId.valueOf ( typeId, informationStructure ) );
        if ( codec == null )
        {
            return mirrorUnknown ( data, typeId, informationStructure, length, header, StandardCause.UNKNOWN_TYPE );
        }

        out.add ( codec.parse ( this.options, length, header, data ) );
        return null;
    }

    private ByteBuf mirrorUnknown ( final ByteBuf data, final byte typeId, final InformationStructure informationStructure, final byte size, final ASDUHeader header, final Cause newCause )
    {
        logger.debug ( "Mirror unknown message -> {}", newCause );
        final ByteBuf reply = Unpooled.buffer ();

        EncodeHelper.encodeHeader ( typeId, informationStructure, this.options, (int)size, header.clone ( newCause ), reply );

        reply.writeBytes ( data ); // copy data

        return reply;
    }

    public void encodeMessage ( final Object msg, ByteBuf buf )
    {
        logger.debug ( "Encode message: {}", msg );

        final ASDU asdu = msg.getClass ().getAnnotation ( ASDU.class );
        if ( asdu == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to send message of type %s, no %s annotation found", msg.getClass (), ASDU.class.getName () ) );
        }

        final MessageCodec codec = this.codecs.get ( new MessageTypeId ( asdu.id (), asdu.informationStructure () ) );
        if ( codec == null )
        {
            throw new IllegalStateException ( String.format ( "Unable to send message of type %s, no codec is registered", msg.getClass () ) );
        }

        try
        {
            buf = buf.order ( ByteOrder.LITTLE_ENDIAN );
            codec.encode ( this.options, msg, buf );
            logger.debug ( "Encoded to {} bytes", buf.writerIndex () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to encode message", e );
            throw new RuntimeException ( e );
        }
    }

    protected void handleUnknownMessage ( final byte typeId, final ASDUHeader header, final ByteBuf data )
    {
        // FIXME: do nothing at the moment
        logger.info ( "Received unknown message - typeId: {}, header: {}, data: {}", (int)typeId, header, ByteBufUtil.hexDump ( data ) );
    }

    protected void registerCodec ( final MessageTypeId messageTypeId, final MessageCodec codec )
    {
        this.codecs.put ( messageTypeId, codec );
    }

    public void registerCodec ( final byte typeId, final InformationStructure informationStructure, final MessageCodec codec )
    {
        registerCodec ( new MessageTypeId ( typeId, informationStructure ), codec );
    }

    /**
     * Register a message class to the protocol stack
     * <p>
     * If the requirements posed by this method don't fit the message class to
     * be registered it is possible to write a complete custom message codec
     * using {@link #registerCodec(byte, InformationStructure, MessageCodec)}.
     * </p>
     * <p>
     * The message class must:
     * <ul>
     * <li>Provide a static method with the signature :
     * <code>public static T parse ( ProtocolOptions, byte, ASDUHeader, ByteBuf )</code>
     * </li>
     * <li>Provide a non-static method with the signature :
     * <code>public void encode ( ProtocolOptions, ByteBuf )</code></li>
     * </ul>
     * </p>
     * <p>
     * In addition the class should implement the following interfaces
     * <dl>
     * <dt>{@link Encodeable}</dt>
     * <dd>Providing an interface for the required
     * {@link Encodeable#encode(ProtocolOptions, ByteBuf)} method.</dd>
     * <dt>{@link Dumpable}</dt>
     * <dd>In order to provide a common way to dump the message structure to
     * some log</dd>
     * </dl>
     * </p>
     * 
     * @param clazz
     *            the message class to register
     */
    public <T> void registerClass ( final Class<T> clazz )
    {
        logger.debug ( "Registering {}", clazz );

        final ASDU asdu = clazz.getAnnotation ( ASDU.class );
        if ( asdu == null )
        {
            throw new IllegalArgumentException ( String.format ( "Class %s must have the annotation %s", clazz.getName (), ASDU.class.getName () ) );
        }

        final MethodType parseMethodType = MethodType.methodType ( clazz, ProtocolOptions.class, byte.class, ASDUHeader.class, ByteBuf.class );

        MethodHandle parseMethod;
        try
        {
            parseMethod = MethodHandles.lookup ().findStatic ( clazz, "parse", parseMethodType );
        }
        catch ( IllegalAccessException | NoSuchMethodException e )
        {
            throw new IllegalArgumentException ( String.format ( "The class %s must have a static method named 'parse' with the signature %s", clazz.getName (), parseMethodType ) );
        }

        final MethodType encodeMethodType = MethodType.methodType ( void.class, ProtocolOptions.class, ByteBuf.class );
        MethodHandle encodeMethod;
        try
        {
            encodeMethod = MethodHandles.lookup ().findVirtual ( clazz, "encode", encodeMethodType );
        }
        catch ( IllegalAccessException | NoSuchMethodException e )
        {
            throw new IllegalArgumentException ( String.format ( "The class %s must have a method named 'encode' with the signature %s", clazz.getName (), encodeMethodType ) );
        }

        registerCodec ( new MessageTypeId ( asdu.id (), asdu.informationStructure () ), new ReflectionMessageCodec<T> ( clazz, parseMethod, encodeMethod ) );
    }
}
