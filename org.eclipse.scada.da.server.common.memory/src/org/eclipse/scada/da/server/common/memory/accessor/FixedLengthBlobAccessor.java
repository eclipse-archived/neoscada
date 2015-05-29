/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
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

import com.google.common.io.BaseEncoding;

public class FixedLengthBlobAccessor implements Accessor<String>
{
    private final int length;

    public FixedLengthBlobAccessor ( final int length )
    {
        this.length = length;
    }

    @Override
    public int getBufferSize ( final String value )
    {
        return this.length;
    }

    @Override
    public String get ( final IoBuffer data, final int index )
    {
        return data.getSlice ( index, this.length ).getHexDump ().toUpperCase ();
    }

    @Override
    public void put ( final IoBuffer data, final String value )
    {
        data.put ( BaseEncoding.base16 ().decode ( value.toUpperCase () ) );
    }

}
