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
import org.eclipse.scada.core.ngp.common.codec.osbp.BinaryContext;
import org.eclipse.scada.core.ngp.common.codec.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemDataUpdate implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( ItemDataUpdate.class );

    public static final int MESSAGE_CODE = 4099;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.da.data.message.ItemDataUpdate.class;
    }

    @Override
    public org.eclipse.scada.da.data.message.ItemDataUpdate decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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
        org.eclipse.scada.core.Variant value = null;
        java.util.Map<String, org.eclipse.scada.core.Variant> addedOrUpdated = null;
        java.util.Set<String> removed = null;
        boolean cacheValue = false;

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
                    value = _context.decodeVariant ( _data );
                }
                    break;
                case 3:
                {
                    addedOrUpdated = _context.decodeVariantMap ( _data );
                }
                    break;
                case 4:
                {
                    removed = _context.decodeStringSet ( _data );
                }
                    break;
                case 5:
                {
                    cacheValue = _context.decodePrimitiveBoolean ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.da.data.message.ItemDataUpdate ( itemId, value, addedOrUpdated, removed, cacheValue );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.da.data.message.ItemDataUpdate value = (org.eclipse.scada.da.data.message.ItemDataUpdate)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)5 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getItemId () );
        context.encodeVariant ( data, (byte)2, value.getValue () );
        context.encodeVariantMap ( data, (byte)3, value.getAddedOrUpdated () );
        context.encodeStringCollection ( data, (byte)4, value.getRemoved () );
        context.encodePrimitiveBoolean ( data, (byte)5, value.isCacheValue () );

        data.flip ();
        return data;
    }

}
