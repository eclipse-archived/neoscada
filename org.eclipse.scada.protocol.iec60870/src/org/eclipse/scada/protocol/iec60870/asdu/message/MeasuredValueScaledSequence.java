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

@ASDU ( id = 11, name = "M_ME_NB_1", informationStructure = InformationStructure.SEQUENCE )
public class MeasuredValueScaledSequence extends AbstractMessage
{
    private final InformationObjectAddress startAddress;

    private final List<Value<Short>> values;

    private MeasuredValueScaledSequence ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Short>> values )
    {
        super ( header );
        this.startAddress = startAddress;
        this.values = values;
    }

    public List<Value<Short>> getValues ()
    {
        return this.values;
    }

    public InformationObjectAddress getStartAddress ()
    {
        return this.startAddress;
    }

    public static MeasuredValueScaledSequence parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress startAddress = InformationObjectAddress.parse ( options, data );

        final List<Value<Short>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            values.add ( TypeHelper.parseScaledValue ( options, data, false ) );
        }

        return new MeasuredValueScaledSequence ( header, startAddress, values );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.values.size (), this.header, out );

        this.startAddress.encode ( options, out );

        for ( final Value<Short> value : this.values )
        {
            TypeHelper.encodeScaledValue ( options, out, value, false );
        }
    }

    public static MeasuredValueScaledSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final Value<Short> value )
    {
        return createInternal ( startAddress, header, Collections.singletonList ( value ) );
    }

    public static MeasuredValueScaledSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Short>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( startAddress, header, new ArrayList<> ( values ) );
    }

    private static MeasuredValueScaledSequence createInternal ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Short>> values )
    {
        return new MeasuredValueScaledSequence ( header, startAddress, values );
    }

}
