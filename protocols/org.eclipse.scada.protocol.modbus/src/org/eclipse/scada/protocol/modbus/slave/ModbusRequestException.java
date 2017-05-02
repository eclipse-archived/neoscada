/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.modbus.slave;

public class ModbusRequestException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    private final int exceptionCode;

    public ModbusRequestException ( final int exceptionCode, final Throwable cause )
    {
        super ( cause );
        this.exceptionCode = exceptionCode;
    }

    public ModbusRequestException ( final int exceptionCode )
    {
        super ( "" + exceptionCode );
        this.exceptionCode = exceptionCode;
    }

    public byte getExceptionCode ()
    {
        return (byte) ( this.exceptionCode & 0xFF );
    }
}
