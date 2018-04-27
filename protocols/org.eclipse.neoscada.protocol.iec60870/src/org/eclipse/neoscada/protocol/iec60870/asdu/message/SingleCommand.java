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

@ASDU ( id = 45, name = "C_SC_NA_1", informationStructure = InformationStructure.SINGLE )
public class SingleCommand extends AbstractSingleCommand implements ValueCommandMessage
{
    public SingleCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final boolean state, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, state ? CommandValue.TRUE () : CommandValue.FALSE (), false, type, execute );
    }

    public SingleCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final boolean state )
    {
        this ( header, informationObjectAddress, state, (byte)0, true );
    }

    @Override
    public SingleCommand mirror ( final Cause cause, final boolean positive )
    {
        return new SingleCommand ( this.header.clone ( cause, positive ), this.informationObjectAddress, isState (), getType (), isExecute () );
    }

    public static SingleCommand parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final byte b = data.readByte ();

        final boolean state = ( b & 0b00000001 ) > 0;
        final byte type = (byte) ( ( b & 0b011111100 ) >> 2 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        return new SingleCommand ( header, address, state, type, execute );
    }

}
