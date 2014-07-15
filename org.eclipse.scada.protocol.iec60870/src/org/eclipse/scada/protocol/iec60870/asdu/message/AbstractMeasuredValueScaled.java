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
import java.util.List;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.TypeHelper;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

public abstract class AbstractMeasuredValueScaled extends AbstractMessage
{
    protected final List<InformationEntry<Short>> entries;

    private final boolean withTimestamp;

    public AbstractMeasuredValueScaled ( final ASDUHeader header, final List<InformationEntry<Short>> entries, final boolean withTimestamp )
    {
        super ( header );
        this.entries = entries;
        this.withTimestamp = withTimestamp;
    }

    public List<InformationEntry<Short>> getEntries ()
    {
        return this.entries;
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.entries.size (), this.header, out );

        for ( final InformationEntry<Short> entry : this.entries )
        {
            entry.getAddress ().encode ( options, out );
            TypeHelper.encodeScaledValue ( options, out, entry.getValue (), this.withTimestamp );
        }
    }

    protected static List<InformationEntry<Short>> parseEntries ( final ProtocolOptions options, final byte length, final ByteBuf data, final boolean withTimestamp )
    {
        final List<InformationEntry<Short>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );
            final Value<Short> value = TypeHelper.parseScaledValue ( options, data, withTimestamp );
            values.add ( new InformationEntry<> ( address, value ) );
        }
        return values;
    }

}