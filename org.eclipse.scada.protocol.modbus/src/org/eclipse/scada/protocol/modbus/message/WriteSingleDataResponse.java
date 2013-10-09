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

public class WriteSingleDataResponse extends BaseMessage
{
    private final IoBuffer data;

    public WriteSingleDataResponse ( final byte unitIdentifier, final byte functionCode, final IoBuffer data )
    {
        super ( unitIdentifier, functionCode );
        this.data = data;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

}
