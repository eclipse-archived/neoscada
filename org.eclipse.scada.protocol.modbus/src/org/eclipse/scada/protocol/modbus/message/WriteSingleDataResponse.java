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

public class WriteSingleDataResponse extends BaseMessage
{
    private int address;

    private int value;

    public WriteSingleDataResponse ( final byte unitIdentifier, final byte functionCode, final int address, final int value )
    {
        super ( unitIdentifier, functionCode );
        this.address = address;
        this.value = value;
    }

    public int getAddress ()
    {
        return address;
    }

    public int getValue ()
    {
        return value;
    }
}
