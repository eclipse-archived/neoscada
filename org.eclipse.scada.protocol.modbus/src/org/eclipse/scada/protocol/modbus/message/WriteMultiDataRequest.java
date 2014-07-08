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

public class WriteMultiDataRequest extends BaseMessage
{
    private final int startAddress;

    private final byte[] data;

    public WriteMultiDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int startAddress, final byte[] data )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.startAddress = startAddress;
        this.data = data;
        if ( data.length % 2 == 1 )
        {
            throw new IllegalArgumentException ( String.format ( "Only an even number of bytes can be written. bytes = %s", data.length ) );
        }
    }

    public int getStartAddress ()
    {
        return this.startAddress;
    }

    public byte[] getData ()
    {
        return this.data;
    }

    public int getNumRegisters ()
    {
        return this.data.length / 2;
    }
}
