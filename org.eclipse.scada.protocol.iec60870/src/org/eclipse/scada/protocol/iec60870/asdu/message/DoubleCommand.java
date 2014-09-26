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
import org.eclipse.scada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationStructure;

@ASDU ( id = 46, name = "C_DC_NA_1", informationStructure = InformationStructure.SINGLE )
public class DoubleCommand extends AbstractInformationObjectMessage implements MirrorableMessage<DoubleCommand>
{
    private final boolean state;

    private final byte type;

    private final boolean execute;

    public DoubleCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final boolean state, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress );
        this.state = state;
        this.type = type;
        this.execute = execute;
    }

    public DoubleCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final boolean state )
    {
        this ( header, informationObjectAddress, state, (byte)0, true );
    }

    public byte getType ()
    {
        return this.type;
    }

    public boolean isState ()
    {
        return this.state;
    }

    public boolean getState ()
    {
        return this.state;
    }

    public boolean isExecute ()
    {
        return this.execute;
    }

    @Override
    public DoubleCommand mirror ( final Cause cause, final boolean positive )
    {
        return new DoubleCommand ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.state, this.type, this.execute );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, null, this.header, out );
        byte b = 0;

        b |= this.state ? 0b00000010 : 0b00000001;
        b |= this.type << 2 & 0b011111100;
        b |= this.execute ? 0 : 0b100000000;

        this.informationObjectAddress.encode ( options, out );

        out.writeByte ( b );
    }

    public static DoubleCommand parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final byte b = data.readByte ();

        final boolean state = ( b & 0b00000001 ) > 0;
        final byte type = (byte) ( ( b & 0b011111100 ) >> 2 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        return new DoubleCommand ( header, address, state, type, execute );
    }

}
