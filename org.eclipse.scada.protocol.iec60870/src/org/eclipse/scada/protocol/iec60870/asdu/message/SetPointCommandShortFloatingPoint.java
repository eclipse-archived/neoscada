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

@ASDU ( id = 50, name = "C_SE_NC_1", informationStructure = InformationStructure.SINGLE )
public class SetPointCommandShortFloatingPoint extends AbstractInformationObjectMessage implements MirrorableMessage<SetPointCommandShortFloatingPoint>
{
    private final byte type;

    private final boolean execute;

    private final float value;

    public SetPointCommandShortFloatingPoint ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final float value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress );
        this.value = value;
        this.type = type;
        this.execute = execute;
    }

    public SetPointCommandShortFloatingPoint ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final float value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    public byte getType ()
    {
        return this.type;
    }

    public float getValue ()
    {
        return this.value;
    }

    public boolean isExecute ()
    {
        return this.execute;
    }

    @Override
    public SetPointCommandShortFloatingPoint mirror ( final Cause cause, final boolean positive )
    {
        return new SetPointCommandShortFloatingPoint ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.value, this.type, this.execute );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, null, this.header, out );

        this.informationObjectAddress.encode ( options, out );

        out.writeFloat ( this.value );

        byte b = 0;

        b |= this.type & 0b011111111;
        b |= this.execute ? 0 : 0b100000000;

        out.writeByte ( b );
    }

    public static SetPointCommandShortFloatingPoint parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final float value = data.readFloat ();

        final byte b = data.readByte ();

        final byte type = (byte) ( b & 0b011111111 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        return new SetPointCommandShortFloatingPoint ( header, address, value, type, execute );
    }

}
