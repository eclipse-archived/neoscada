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

import org.apache.mina.core.buffer.IoBuffer;

public class Pdu
{
    private final byte unitIdentifier;

    private final IoBuffer data;

    public Pdu ( final byte unitIdentifier, final IoBuffer data )
    {
        super ();
        this.unitIdentifier = unitIdentifier;
        this.data = data;
    }

    public byte getUnitIdentifier ()
    {
        return this.unitIdentifier;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[unitIdentifier: %02x - %s]", this.unitIdentifier, this.data );
    }

}
