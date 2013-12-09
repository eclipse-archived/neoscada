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
package org.eclipse.scada.da.server.common.memory.accessor;

import org.apache.mina.core.buffer.IoBuffer;

public class Int16Accessor implements Getter<Short>, Setter<Short>
{
    public static final Int16Accessor INSTANCE = new Int16Accessor ();

    @Override
    public Short get ( final IoBuffer data, final int index )
    {
        return data.getShort ( index );
    }

    @Override
    public void put ( final IoBuffer data, final Short value )
    {
        data.putShort ( value );
    }
}