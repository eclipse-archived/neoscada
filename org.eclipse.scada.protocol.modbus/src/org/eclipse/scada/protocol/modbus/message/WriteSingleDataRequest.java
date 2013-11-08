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

public class WriteSingleDataRequest extends BaseMessage
{
    private static final int TRUE = 0xFF00;

    private static final int FALSE = 0x0000;

    private final int address;

    private final int value;

    public WriteSingleDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final int value )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.address = address;
        this.value = value;
    }

    public WriteSingleDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final boolean value )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.address = address;
        this.value = value ? TRUE : FALSE;
    }

    public int getAddress ()
    {
        return this.address;
    }

    public int getValue ()
    {
        return this.value;
    }

    public boolean isTrue ()
    {
        return this.value == TRUE;
    }

    public boolean isFalse ()
    {
        return this.value == FALSE;
    }
}
