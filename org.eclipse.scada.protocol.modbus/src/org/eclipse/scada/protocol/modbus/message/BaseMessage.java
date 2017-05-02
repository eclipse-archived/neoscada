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

public class BaseMessage
{
    protected final byte unitIdentifier;

    protected final byte functionCode;

    protected final int transactionId;

    public BaseMessage ( final int transactionId, final byte unitIdentifier, final byte functionCode )
    {
        this.unitIdentifier = unitIdentifier;
        this.functionCode = functionCode;
        this.transactionId = transactionId;
    }

    public int getTransactionId ()
    {
        return transactionId;
    }
    
    public byte getUnitIdentifier ()
    {
        return this.unitIdentifier;
    }

    public byte getFunctionCode ()
    {
        return this.functionCode;
    }
}
