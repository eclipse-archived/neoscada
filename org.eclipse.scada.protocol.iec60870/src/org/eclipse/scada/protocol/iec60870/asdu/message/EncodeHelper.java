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
package org.eclipse.scada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;

public final class EncodeHelper
{
    private EncodeHelper ()
    {
    }

    public static void encodeHeader ( final byte typeId, final InformationStructure informationStructure, final ProtocolOptions options, final Integer size, final ASDUHeader header, final ByteBuf out )
    {
        final byte lengthInformation;
        if ( size == null )
        {
            lengthInformation = informationStructure.encode ( 1 );
        }
        else
        {
            lengthInformation = informationStructure.encode ( size );
        }

        out.writeByte ( typeId );
        out.writeByte ( lengthInformation );
        header.getCauseOfTransmission ().encode ( options, out );
        header.getAsduAddress ().encode ( options, out );
    }

    public static void encodeHeader ( final Object message, final ProtocolOptions options, final Integer size, final ASDUHeader header, final ByteBuf out )
    {
        final ASDU asdu = message.getClass ().getAnnotation ( ASDU.class );
        if ( asdu == null )
        {
            throw new IllegalArgumentException ( String.format ( "Message type %s does not have @%s annotation", message.getClass (), ASDU.class.getName () ) );
        }

        encodeHeader ( asdu.id (), asdu.informationStructure (), options, size, header, out );
    }
}
