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
package org.eclipse.scada.ca.protocol.ngp.codec.impl;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryContext;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplyDiffRequest implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( ApplyDiffRequest.class );

    public static final int MESSAGE_CODE = 16641;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.ca.data.message.ApplyDiffRequest.class;
    }

    @Override
    public org.eclipse.scada.ca.data.message.ApplyDiffRequest decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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
        java.util.List<org.eclipse.scada.ca.data.DiffEntry> diffs = null;
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
                    diffs = org.eclipse.scada.ca.protocol.ngp.codec.Structures.decodeListDiffEntry ( _context, _data, true );
                }
                    break;
                case 3:
                {
                    operationParameters = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeOperationParameters ( _context, _data, true );
                }
                    break;
                case 4:
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
        return new org.eclipse.scada.ca.data.message.ApplyDiffRequest ( request, diffs, operationParameters, callbackHandlerId );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.ca.data.message.ApplyDiffRequest value = (org.eclipse.scada.ca.data.message.ApplyDiffRequest)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)4 );

        // encode attributes
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeRequest ( context, data, (byte)1, value.getRequest () );
        org.eclipse.scada.ca.protocol.ngp.codec.Structures.encodeCollectionDiffEntry ( context, data, (byte)2, value.getDiffs () );
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeOperationParameters ( context, data, (byte)3, value.getOperationParameters () );
        context.encodeLong ( data, (byte)4, value.getCallbackHandlerId () );

        data.flip ();
        return data;
    }

}
