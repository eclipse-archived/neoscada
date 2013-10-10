/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

public enum RequestType
{
    DISCRETE ( (byte)0x02, (byte)0x00 ),
    COIL ( (byte)0x01, (byte)0x05 ),
    INPUT ( (byte)0x04, (byte)0x00 ),
    HOLDING ( (byte)0x03, (byte)0x06 );

    private final byte readFunctionCode;

    private final byte writeFunctionCode;

    RequestType ( final byte readFunctionCode, final byte writeFunctionCode )
    {
        this.readFunctionCode = readFunctionCode;
        this.writeFunctionCode = writeFunctionCode;
    }

    public byte getReadFunctionCode ()
    {
        return this.readFunctionCode;
    }

    public byte getWriteFunctionCode ()
    {
        return this.writeFunctionCode;
    }
}
