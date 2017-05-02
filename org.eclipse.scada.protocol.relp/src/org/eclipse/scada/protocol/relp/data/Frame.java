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
package org.eclipse.scada.protocol.relp.data;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class Frame
{
    private final long transactionId;

    private final String command;

    private final ByteBuf data;

    public Frame ( final long transactionId, final String command, final ByteBuf data )
    {
        this.transactionId = transactionId;
        this.command = command;
        this.data = data;
    }

    public Frame ( final long transactionId, final String command, final String data )
    {
        this.transactionId = transactionId;
        this.command = command;
        this.data = data == null ? null : Unpooled.copiedBuffer ( data, StandardCharsets.UTF_8 );
    }

    public String getCommand ()
    {
        return this.command;
    }

    public ByteBuf getData ()
    {
        return this.data;
    }

    public long getTransactionId ()
    {
        return this.transactionId;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Frame - txnr: %s, command: %s, data: %s]", this.transactionId, this.command, this.data );
    }
}
