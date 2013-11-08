/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.message;

import org.apache.mina.core.buffer.IoBuffer;

public class Pdu
{
    private final int transactionId;
    
    private final byte unitIdentifier;

    private final IoBuffer data;

    public Pdu (final int transactionId, final byte unitIdentifier, final IoBuffer data )
    {
        super ();
        this.transactionId = transactionId;
        this.unitIdentifier = unitIdentifier;
        this.data = data;
    }

    public int getTransactionId ()
    {
        return transactionId;
    }
    
    public byte getUnitIdentifier ()
    {
        return this.unitIdentifier;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

    @Override
    public String toString ()
    {
        return "Pdu [transactionId=" + transactionId + ", unitIdentifier=" + unitIdentifier + ", data=" + data + "]";
    }
}
