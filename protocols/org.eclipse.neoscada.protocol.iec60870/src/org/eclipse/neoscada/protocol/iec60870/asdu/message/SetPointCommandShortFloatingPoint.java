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

@ASDU ( id = 50, name = "C_SE_NC_1", informationStructure = InformationStructure.SINGLE )
public class SetPointCommandShortFloatingPoint extends AbstractSetPointCommandShortFloatingPoint implements ValueCommandMessage
{
    public SetPointCommandShortFloatingPoint ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final float value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, new CommandValue<Float> ( value, System.currentTimeMillis () ), false, type, execute );
    }

    public SetPointCommandShortFloatingPoint ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final float value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    @Override
    public SetPointCommandShortFloatingPoint mirror ( final Cause cause, final boolean positive )
    {
        return new SetPointCommandShortFloatingPoint ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.getValue ().getValue (), this.getType (), this.isExecute () );
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
