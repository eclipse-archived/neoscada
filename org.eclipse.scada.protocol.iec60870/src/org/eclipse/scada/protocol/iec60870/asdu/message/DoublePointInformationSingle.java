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
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

@ASDU ( id = 1, name = "M_DP_NA_1", informationStructure = InformationStructure.SINGLE )
public class DoublePointInformationSingle extends AbstractDoublePointBaseSingle
{
    private DoublePointInformationSingle ( final ASDUHeader header, final List<InformationEntry<DoublePoint>> entries )
    {
        super ( header, entries, false );
    }

    public static DoublePointInformationSingle parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        return new DoublePointInformationSingle ( header, parseEntries ( options, length, data, false ) );
    }

    public static DoublePointInformationSingle create ( final ASDUHeader header, final InformationObjectAddress address, final Value<DoublePoint> value )
    {
        return createInternal ( header, Collections.singletonList ( new InformationEntry<> ( address, value ) ) );
    }

    public static DoublePointInformationSingle create ( final ASDUHeader header, final List<InformationEntry<DoublePoint>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( header, new ArrayList<> ( values ) );
    }

    private static DoublePointInformationSingle createInternal ( final ASDUHeader header, final List<InformationEntry<DoublePoint>> values )
    {
        return new DoublePointInformationSingle ( header, values );
    }

}
