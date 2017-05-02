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
import org.eclipse.scada.core.ngp.common.codec.osbp.BinaryContext;
import org.eclipse.scada.core.ngp.common.codec.osbp.BinaryMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateQueryData implements BinaryMessageCodec
{
    private final static Logger logger = LoggerFactory.getLogger ( UpdateQueryData.class );

    public static final int MESSAGE_CODE = 12295;

    @Override
    public int getMessageCode ()
    {
        return MESSAGE_CODE;
    }

    @Override
    public Class<?> getMessageClass ()
    {
        return org.eclipse.scada.hd.data.message.UpdateQueryData.class;
    }

    @Override
    public org.eclipse.scada.hd.data.message.UpdateQueryData decodeMessage ( final BinaryContext _context, final IoBuffer _data ) throws Exception
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

        long queryId = 0L;
        int index = 0;
        java.util.List<org.eclipse.scada.hd.data.ValueInformation> valueInformation = null;
        java.util.List<org.eclipse.scada.hd.data.ValueEntry> values = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    queryId = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 2:
                {
                    index = _context.decodePrimitiveInt ( _data );
                }
                    break;
                case 3:
                {
                    valueInformation = org.eclipse.scada.hd.protocol.ngp.codec.Structures.decodeListValueInformation ( _context, _data, true );
                }
                    break;
                case 4:
                {
                    values = org.eclipse.scada.hd.protocol.ngp.codec.Structures.decodeListValueEntry ( _context, _data, true );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.message.UpdateQueryData ( queryId, index, valueInformation, values );
    }

    @Override
    public IoBuffer encodeMessage ( final BinaryContext context, final Object objectMessage ) throws Exception
    {
        final org.eclipse.scada.hd.data.message.UpdateQueryData value = (org.eclipse.scada.hd.data.message.UpdateQueryData)objectMessage;

        final IoBuffer data = IoBuffer.allocate ( 64 );
        data.setAutoExpand ( true );

        // encode message base
        data.putInt ( MESSAGE_CODE );

        // number of fields 
        data.put ( (byte)4 );

        // encode attributes
        context.encodePrimitiveLong ( data, (byte)1, value.getQueryId () );
        context.encodePrimitiveInt ( data, (byte)2, value.getIndex () );
        org.eclipse.scada.hd.protocol.ngp.codec.Structures.encodeCollectionValueInformation ( context, data, (byte)3, value.getValueInformation () );
        org.eclipse.scada.hd.protocol.ngp.codec.Structures.encodeCollectionValueEntry ( context, data, (byte)4, value.getValues () );

        data.flip ();
        return data;
    }

}
