/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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

public class Int32Accessor implements Accessor<Integer>
{
    public static final Int32Accessor INSTANCE = new Int32Accessor ();

    @Override
    public Integer get ( final IoBuffer data, final int index )
    {
        return data.getInt ( index );
    }

    @Override
    public void put ( final IoBuffer data, final Integer value )
    {
        data.putInt ( value );
    }

    @Override
    public int getBufferSize ( final Integer value )
    {
        return 4;
    }
}