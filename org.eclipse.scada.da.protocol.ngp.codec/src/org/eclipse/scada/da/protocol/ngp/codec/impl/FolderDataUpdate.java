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

public class FolderDataUpdate implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( FolderDataUpdate.class );

    public static final int MESSAGE_CODE = 4611;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.da.data.message.FolderDataUpdate.class;
    }

    @Override
    public org.eclipse.scada.da.data.message.FolderDataUpdate decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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

        java.util.List<String> location = null;
        java.util.List<org.eclipse.scada.da.data.BrowserEntry> addedOrModified = null;
        java.util.Set<String> removed = null;
        boolean full = false;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    location = _context.decodeStringList ( _data );
                }
                    break;
                case 2:
                {
                    addedOrModified = org.eclipse.scada.da.protocol.ngp.codec.Structures.decodeListBrowserEntry ( _context, _data, true );
                }
                    break;
                case 3:
                {
                    removed = _context.decodeStringSet ( _data );
                }
                    break;
                case 4:
                {
                    full = _context.decodePrimitiveBoolean ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.da.data.message.FolderDataUpdate ( location, addedOrModified, removed, full );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.da.data.message.FolderDataUpdate value = (org.eclipse.scada.da.data.message.FolderDataUpdate)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)4 );

        // encode attributes
        context.encodeStringCollection ( data, (byte)1, value.getLocation () );
        org.eclipse.scada.da.protocol.ngp.codec.Structures.encodeCollectionBrowserEntry ( context, data, (byte)2, value.getAddedOrModified () );
        context.encodeStringCollection ( data, (byte)3, value.getRemoved () );
        context.encodePrimitiveBoolean ( data, (byte)4, value.isFull () );

        data.flip ();
        return data;
    }

}
