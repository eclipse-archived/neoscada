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
import org.eclipse.scada.protocol.iec60870.asdu.types.DoublePoint;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;
import org.eclipse.scada.protocol.iec60870.asdu.types.TypeHelper;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

@ASDU ( id = 1, name = "M_DP_NA_1", informationStructure = InformationStructure.SEQUENCE )
public class DoublePointInformationSequence extends AbstractMessage
{
    private final InformationObjectAddress startAddress;

    private final List<Value<DoublePoint>> values;

    private DoublePointInformationSequence ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<DoublePoint>> values )
    {
        super ( header );
        this.startAddress = startAddress;
        this.values = values;
    }

    public InformationObjectAddress getStartAddress ()
    {
        return this.startAddress;
    }

    public List<Value<DoublePoint>> getValues ()
    {
        return this.values;
    }

    public static DoublePointInformationSequence parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress startAddress = InformationObjectAddress.parse ( options, data );

        final List<Value<DoublePoint>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            values.add ( TypeHelper.parseDoublePointValue ( options, data, false ) );
        }

        return new DoublePointInformationSequence ( header, startAddress, values );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.values.size (), this.header, out );

        this.startAddress.encode ( options, out );

        for ( final Value<DoublePoint> value : this.values )
        {
            TypeHelper.encodeDoublePointValue ( options, out, value, false );
        }
    }

    public static DoublePointInformationSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final Value<DoublePoint> value )
    {
        return createInternal ( startAddress, header, Collections.singletonList ( value ) );
    }

    public static DoublePointInformationSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<DoublePoint>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( startAddress, header, new ArrayList<> ( values ) );
    }

    private static DoublePointInformationSequence createInternal ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<DoublePoint>> values )
    {
        return new DoublePointInformationSequence ( header, startAddress, values );
    }

}
