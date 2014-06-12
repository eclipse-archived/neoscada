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
package org.eclipse.scada.protocol.iec60870.apci;

public class Supervisory extends APCIBase
{
    private final int receiveSequenceNumber;

    public Supervisory ( final int receiveSequenceNumber )
    {
        super ( APCIType.S );
        this.receiveSequenceNumber = receiveSequenceNumber;
    }

    public int getReceiveSequenceNumber ()
    {
        return this.receiveSequenceNumber;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[APCI:S:%s]", this.receiveSequenceNumber );
    }
}
