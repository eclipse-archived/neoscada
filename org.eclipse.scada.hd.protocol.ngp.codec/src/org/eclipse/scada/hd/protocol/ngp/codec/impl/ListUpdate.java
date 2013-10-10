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
package org.eclipse.scada.hd.protocol.ngp.codec.impl;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryContext;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListUpdate implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( ListUpdate.class );

    public static final int MESSAGE_CODE = 12547;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.hd.data.message.ListUpdate.class;
    }

    @Override
    public org.eclipse.scada.hd.data.message.ListUpdate decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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

        java.util.Set<org.eclipse.scada.hd.data.HistoricalItemInformation> addedOrModified = null;
        java.util.Set<String> removed = null;
        boolean fullUpdate = false;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    addedOrModified = org.eclipse.scada.hd.protocol.ngp.codec.Structures.decodeSetHistoricalItemInformation ( _context, _data, true );
                }
                    break;
                case 2:
                {
                    removed = _context.decodeStringSet ( _data );
                }
                    break;
                case 3:
                {
                    fullUpdate = _context.decodePrimitiveBoolean ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.message.ListUpdate ( addedOrModified, removed, fullUpdate );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.hd.data.message.ListUpdate value = (org.eclipse.scada.hd.data.message.ListUpdate)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)3 );

        // encode attributes
        org.eclipse.scada.hd.protocol.ngp.codec.Structures.encodeCollectionHistoricalItemInformation ( context, data, (byte)1, value.getAddedOrModified () );
        context.encodeStringCollection ( data, (byte)2, value.getRemoved () );
        context.encodePrimitiveBoolean ( data, (byte)3, value.isFullUpdate () );

        data.flip ();
        return data;
    }

}
