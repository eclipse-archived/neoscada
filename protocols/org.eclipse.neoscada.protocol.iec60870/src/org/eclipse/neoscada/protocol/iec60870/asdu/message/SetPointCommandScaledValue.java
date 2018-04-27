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
package org.eclipse.neoscada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationStructure;

@ASDU ( id = 49, name = "C_SE_NB_1", informationStructure = InformationStructure.SINGLE )
public class SetPointCommandScaledValue extends AbstractSetPointCommandScaledValue implements ValueCommandMessage
{
    public SetPointCommandScaledValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final short value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, new CommandValue<Short> ( value, System.currentTimeMillis () ), false, type, execute );
    }

    public SetPointCommandScaledValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final short value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    @Override
    public SetPointCommandScaledValue mirror ( final Cause cause, final boolean positive )
    {
        return new SetPointCommandScaledValue ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.getValue ().getValue (), this.getType (), this.isExecute () );
    }

    public static SetPointCommandScaledValue parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final short value = data.readShort ();

        final byte b = data.readByte ();

        final byte type = (byte) ( b & 0b011111111 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        return new SetPointCommandScaledValue ( header, address, value, type, execute );
    }
}
