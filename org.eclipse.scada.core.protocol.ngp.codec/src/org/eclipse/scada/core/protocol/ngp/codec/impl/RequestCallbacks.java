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
package org.eclipse.scada.core.protocol.ngp.codec.impl;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryContext;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCallbacks implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( RequestCallbacks.class );

    public static final int MESSAGE_CODE = 257;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.core.data.message.RequestCallbacks.class;
    }

    @Override
    public org.eclipse.scada.core.data.message.RequestCallbacks decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // message code
        {
            final int messageCode = _data.getInt ();

            if ( messageCode != MESSAGE_CODE )
            {
                throw new IllegalStateException ( String.format ( "Expected messageCode %s but found %s", MESSAGE_CODE, messageCode ) );
            }
        }

        final byte numberOfFields = _data.get ();

        // decode attributes

        org.eclipse.scada.core.data.Request request = null;
        long callbackHandlerId = 0L;
        java.util.List<org.eclipse.scada.core.data.CallbackRequest> callbacks = null;
        Long timeoutMillis = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    request = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeRequest ( _context, _data, false );
                }
                    break;
                case 2:
                {
                    callbackHandlerId = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 3:
                {
                    callbacks = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeListCallbackRequest ( _context, _data, true );
                }
                    break;
                case 4:
                {
                    timeoutMillis = _context.decodeLong ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.message.RequestCallbacks ( request, callbackHandlerId, callbacks, timeoutMillis );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.core.data.message.RequestCallbacks value = (org.eclipse.scada.core.data.message.RequestCallbacks)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)4 );

        // encode attributes
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeRequest ( context, data, (byte)1, value.getRequest () );
        context.encodePrimitiveLong ( data, (byte)2, value.getCallbackHandlerId () );
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeCollectionCallbackRequest ( context, data, (byte)3, value.getCallbacks () );
        context.encodeLong ( data, (byte)4, value.getTimeoutMillis () );

        data.flip ();
        return data;
    }

}
