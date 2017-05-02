/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.message;

public class WriteSingleDataResponse extends BaseMessage
{
    private final int address;

    private final byte[] data;

    public WriteSingleDataResponse ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final byte[] data )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.address = address;
        this.data = data;
    }

    public int getAddress ()
    {
        return this.address;
    }

    public byte[] getData ()
    {
        return this.data;
    }
}
