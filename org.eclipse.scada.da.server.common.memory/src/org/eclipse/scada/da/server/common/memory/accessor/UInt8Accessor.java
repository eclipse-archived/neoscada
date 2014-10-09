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
package org.eclipse.scada.da.server.common.memory.accessor;

import org.apache.mina.core.buffer.IoBuffer;

public class UInt8Accessor implements Accessor<Short>
{
    public static final UInt8Accessor INSTANCE = new UInt8Accessor ();

    @Override
    public Short get ( final IoBuffer data, final int index )
    {
        return data.getUnsigned ( index );
    }

    @Override
    public void put ( final IoBuffer data, final Short value )
    {
        data.putUnsigned ( value );
    }

    @Override
    public int getBufferSize ( final Short value )
    {
        return 1;
    }
}