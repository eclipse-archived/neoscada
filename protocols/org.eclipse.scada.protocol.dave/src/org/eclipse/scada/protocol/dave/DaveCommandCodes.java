/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactoring for a generic memory driver system
 *******************************************************************************/
package org.eclipse.scada.protocol.dave;

public enum DaveCommandCodes
{
    DAVE_READ ( (byte)0x04 ),
    DAVE_WRITE ( (byte)0x05 );

    private byte commandCode;

    private DaveCommandCodes ( final byte commandCode )
    {
        this.commandCode = commandCode;
    }

    public byte getCommandCode ()
    {
        return this.commandCode;
    }
}
