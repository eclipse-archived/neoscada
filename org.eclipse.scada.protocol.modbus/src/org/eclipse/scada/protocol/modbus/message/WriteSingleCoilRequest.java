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

public class WriteSingleCoilRequest extends BaseMessage
{

    private final int address;

    private final boolean value;

    public WriteSingleCoilRequest ( final byte unitIdentifier, final int address, final boolean value )
    {
        super ( unitIdentifier, (byte)0x05 );
        this.address = address;
        this.value = value;
    }

    public int getAddress ()
    {
        return this.address;
    }

    public boolean getValue ()
    {
        return this.value;
    }

}
