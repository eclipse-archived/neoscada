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

public class Int64Accessor implements Accessor<Long>
{
    public static final Int64Accessor INSTANCE = new Int64Accessor ();

    @Override
    public Long get ( final IoBuffer data, final int index )
    {
        return data.getLong ( index );
    }

    @Override
    public void put ( final IoBuffer data, final Long value )
    {
        data.putLong ( value );
    }

    @Override
    public int getBufferSize ( final Long value )
    {
        return 8;
    }
}