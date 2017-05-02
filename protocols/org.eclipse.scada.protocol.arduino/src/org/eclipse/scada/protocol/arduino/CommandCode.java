/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino;

public enum CommandCode
{
    DEVICE_DISCOVERY ( (byte)0x00 ),
    DISCOVER_ME ( (byte)0x01 ),

    REQUEST_CONFIGURATION ( (byte)0x02 ),
    RESPOND_CONFIGURATION ( (byte)0x03 ),

    REQUEST_DATA ( (byte)0x04 ),
    RESPOND_DATA ( (byte)0x05 ),

    REQUEST_WRITE ( (byte)0x06 ),
    RESPOND_WRITE ( (byte)0x07 );

    private byte commandCode;

    private CommandCode ( final byte commandCode )
    {
        this.commandCode = commandCode;
    }

    public byte getCommandCode ()
    {
        return this.commandCode;
    }
}
