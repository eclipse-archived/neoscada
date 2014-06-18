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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;
import org.eclipse.scada.protocol.iec60870.asdu.types.TypeHelper;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

@ASDU ( id = 1, name = "M_SP_NA_1", informationStructure = InformationStructure.SEQUENCE )
public class SinglePointInformationSequence extends AbstractMessage
{
    private final InformationObjectAddress startAddress;

    private final List<Value<Boolean>> values;

    private SinglePointInformationSequence ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        super ( header );
        this.startAddress = startAddress;
        this.values = values;
    }

    public static SinglePointInformationSequence parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress startAddress = InformationObjectAddress.parse ( options, data );

        final List<Value<Boolean>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            values.add ( TypeHelper.parseBooleanValue ( options, data, false ) );
        }

        return new SinglePointInformationSequence ( header, startAddress, values );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.values.size (), this.header, out );

        this.startAddress.encode ( options, out );

        for ( final Value<Boolean> value : this.values )
        {
            TypeHelper.encodeBooleanValue ( options, out, value, false );
        }
    }

    public static SinglePointInformationSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final Value<Boolean> value )
    {
        return createInternal ( startAddress, header, Collections.singletonList ( value ) );
    }

    public static SinglePointInformationSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Boolean>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( startAddress, header, new ArrayList<> ( values ) );
    }

    private static SinglePointInformationSequence createInternal ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Boolean>> values )
    {
        return new SinglePointInformationSequence ( header, startAddress, values );
    }

}
