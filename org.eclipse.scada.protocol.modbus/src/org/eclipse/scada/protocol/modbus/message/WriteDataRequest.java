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

public class WriteDataRequest extends BaseMessage
{

    private final int startAddress;

    private final byte[] data;

    protected WriteDataRequest ( final byte unitIdentifier, final byte functionCode, final int startAddress, final byte[] data )
    {
        super ( unitIdentifier, functionCode );
        this.startAddress = startAddress;
        this.data = data;
        if ( data.length % 2 == 1 )
        {
            throw new IllegalArgumentException ( String.format ( "Only an even number of bytes can be written. bytes = %s", data.length ) );
        }
    }

    public WriteDataRequest ( final byte unitIdentifier, final int startAddress, final byte[] data )
    {
        this ( unitIdentifier, data.length == 2 ? (byte)0x06 : (byte)0x10, startAddress, data );
    }

    public int getStartAddress ()
    {
        return this.startAddress;
    }

    public byte[] getData ()
    {
        return this.data;
    }
}
