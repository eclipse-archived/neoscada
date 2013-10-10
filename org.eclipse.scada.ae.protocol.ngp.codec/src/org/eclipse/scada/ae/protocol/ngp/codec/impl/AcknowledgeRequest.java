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
package org.eclipse.scada.ae.protocol.ngp.codec.impl;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryContext;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcknowledgeRequest implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( AcknowledgeRequest.class );

    public static final int MESSAGE_CODE = 9217;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.ae.data.message.AcknowledgeRequest.class;
    }

    @Override
    public org.eclipse.scada.ae.data.message.AcknowledgeRequest decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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
        String monitorId = null;
        Long aknTimestamp = null;
        org.eclipse.scada.core.data.OperationParameters operationParameters = null;
        Long callbackHandlerId = null;

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
                    monitorId = _context.decodeString ( _data );
                }
                    break;
                case 3:
                {
                    aknTimestamp = _context.decodeLong ( _data );
                }
                    break;
                case 4:
                {
                    operationParameters = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeOperationParameters ( _context, _data, true );
                }
                    break;
                case 5:
                {
                    callbackHandlerId = _context.decodeLong ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.ae.data.message.AcknowledgeRequest ( request, monitorId, aknTimestamp, operationParameters, callbackHandlerId );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.ae.data.message.AcknowledgeRequest value = (org.eclipse.scada.ae.data.message.AcknowledgeRequest)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)5 );

        // encode attributes
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeRequest ( context, data, (byte)1, value.getRequest () );
        context.encodeString ( data, (byte)2, value.getMonitorId () );
        context.encodeLong ( data, (byte)3, value.getAknTimestamp () );
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeOperationParameters ( context, data, (byte)4, value.getOperationParameters () );
        context.encodeLong ( data, (byte)5, value.getCallbackHandlerId () );

        data.flip ();
        return data;
    }

}
