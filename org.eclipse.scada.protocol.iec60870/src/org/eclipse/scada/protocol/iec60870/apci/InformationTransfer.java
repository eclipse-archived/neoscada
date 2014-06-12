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
package org.eclipse.scada.protocol.iec60870.apci;

import io.netty.buffer.ByteBuf;

public class InformationTransfer extends APCIBase
{
    private final ByteBuf data;

    private final int sendSequenceNumber;

    private final int receiveSequenceNumber;

    public InformationTransfer ( final int sendSequenceNumber, final int receiveSequenceNumber, final ByteBuf data )
    {
        super ( APCIType.I );
        this.sendSequenceNumber = sendSequenceNumber;
        this.receiveSequenceNumber = receiveSequenceNumber;
        this.data = data;
    }

    public ByteBuf getData ()
    {
        return this.data;
    }

    public int getReceiveSequenceNumber ()
    {
        return this.receiveSequenceNumber;
    }

    public int getSendSequenceNumber ()
    {
        return this.sendSequenceNumber;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[APCI:I:%s:%s:%s]", this.sendSequenceNumber, this.receiveSequenceNumber, this.data );
    }
}
