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
package org.eclipse.scada.da.protocol.ngp.codec.impl;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryContext;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemStateUpdate implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( ItemStateUpdate.class );

    public static final int MESSAGE_CODE = 4100;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.da.data.message.ItemStateUpdate.class;
    }

    @Override
    public org.eclipse.scada.da.data.message.ItemStateUpdate decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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

        String itemId = null;
        org.eclipse.scada.core.data.SubscriptionState subscriptionState = null;
        org.eclipse.scada.core.data.ErrorInformation errorInformation = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    itemId = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    subscriptionState = _context.decodeEnum ( _data, org.eclipse.scada.core.data.SubscriptionState.class );
                }
                    break;
                case 3:
                {
                    errorInformation = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeErrorInformation ( _context, _data, true );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.da.data.message.ItemStateUpdate ( itemId, subscriptionState, errorInformation );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.da.data.message.ItemStateUpdate value = (org.eclipse.scada.da.data.message.ItemStateUpdate)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)3 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getItemId () );
        context.encodeEnum ( data, (byte)2, value.getSubscriptionState () );
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeErrorInformation ( context, data, (byte)3, value.getErrorInformation () );

        data.flip ();
        return data;
    }

}
