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

public class SyslogRequest
{
    private final long transactionId;

    private final ByteBuf data;

    public SyslogRequest ( final long transactionId, final ByteBuf data )
    {
        this.transactionId = transactionId;
        this.data = data;
    }

    public ByteBuf getData ()
    {
        return this.data;
    }

    public long getTransactionId ()
    {
        return this.transactionId;
    }

    public SyslogResponse replyOk ()
    {
        return new SyslogResponse ( this.transactionId, 200, "OK" );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[SyslogRequest - txnr: %s, data: %s]", this.transactionId, this.data );
    }
}
