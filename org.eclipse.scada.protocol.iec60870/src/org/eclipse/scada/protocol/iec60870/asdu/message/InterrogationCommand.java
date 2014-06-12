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

@ASDU ( id = 100, name = "C_IC_NA_1" )
public class InterrogationCommand extends AbstractInformationObjectMessage
{
    private final short qualifierOfInterrogation;

    public InterrogationCommand ( final ASDUHeader header, final short qualifierOfInterrogation )
    {
        this ( header, InformationObjectAddress.DEFAULT, qualifierOfInterrogation );
    }

    public InterrogationCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final short qualifierOfInterrogation )
    {
        super ( header, informationObjectAddress );
        this.qualifierOfInterrogation = qualifierOfInterrogation;
    }

    public short getQualifierOfInterrogation ()
    {
        return this.qualifierOfInterrogation;
    }

    public static InterrogationCommand parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress informationObjectAddress = InformationObjectAddress.parse ( options, data );
        final short qualifierOfInterrogation = data.readUnsignedByte ();
        final InterrogationCommand result = new InterrogationCommand ( header, informationObjectAddress, qualifierOfInterrogation );
        return result;
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, null, this.header, out );
        this.informationObjectAddress.encode ( options, out );
        out.writeByte ( this.qualifierOfInterrogation );
    }

    public InterrogationCommand mirror ( final Cause cause )
    {
        return new InterrogationCommand ( this.header.clone ( cause ), this.qualifierOfInterrogation );
    }
}
