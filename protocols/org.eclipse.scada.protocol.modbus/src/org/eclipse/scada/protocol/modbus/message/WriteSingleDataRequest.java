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

import java.nio.ByteOrder;
import java.util.Arrays;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.modbus.Constants;

public class WriteSingleDataRequest extends BaseMessage
{
    private static final byte[] TRUE = { (byte)0xFF, 0x00 };

    private static final byte[] FALSE = { 0x00, 0x00 };

    private final int address;

    private final byte[] value;

    public WriteSingleDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final int value )
    {
        this ( transactionId, unitIdentifier, functionCode, address, value, Constants.DEFAULT_BYTE_ORDER );
    }

    public WriteSingleDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final byte[] data )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.address = address;

        this.value = data;
    }

    public WriteSingleDataRequest ( final int transactionId, final byte unitIdentifier, final byte functionCode, final int address, final int value, final ByteOrder byteOrder )
    {
        super ( transactionId, unitIdentifier, functionCode );
        this.address = address;

        this.value = new byte[2];
        final IoBuffer bb = IoBuffer.wrap ( this.value );
        bb.order ( byteOrder ).putUnsignedShort ( value );
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

    public byte[] getData ()
    {
        return this.value;
    }

    public boolean isTrue ()
    {
        return Arrays.equals ( this.value, TRUE );
    }

    public boolean isFalse ()
    {
        return Arrays.equals ( this.value, FALSE );
    }
}
