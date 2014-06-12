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

@ASDU ( id = 102, name = "C_RD_NA_1" )
public class ReadCommand extends AbstractInformationObjectMessage
{
    public ReadCommand ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress )
    {
        super ( header, informationObjectAddress );
    }

    public static ReadCommand parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        return new ReadCommand ( header, InformationObjectAddress.parse ( options, data ) );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, null, this.header, out );
        this.informationObjectAddress.encode ( options, out );
    }

    public ReadCommand mirror ( final Cause cause )
    {
        return new ReadCommand ( this.header.clone ( cause ), this.informationObjectAddress );
    }
}
