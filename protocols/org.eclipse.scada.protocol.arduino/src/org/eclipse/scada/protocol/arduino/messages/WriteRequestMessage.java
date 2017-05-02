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
package org.eclipse.scada.protocol.arduino.messages;

import org.eclipse.scada.protocol.arduino.CommandCode;

public class WriteRequestMessage extends CommonMessage
{
    private final short index;

    private final Object data;

    public WriteRequestMessage ( final int sequence, final short index, final Object data )
    {
        super ( sequence, CommandCode.REQUEST_WRITE );
        this.index = index;
        this.data = data;
    }

    public Object getData ()
    {
        return this.data;
    }

    public short getIndex ()
    {
        return this.index;
    }

}
