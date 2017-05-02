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

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;

public class FixedLengthStringAccessor implements Accessor<String>
{
    private final int length;

    private final Charset charset;

    public FixedLengthStringAccessor ( final int length, final Charset charset )
    {
        this.length = length;
        this.charset = charset;
    }

    @Override
    public int getBufferSize ( final String value )
    {
        return this.length;
    }

    @Override
    public String get ( final IoBuffer data, final int index )
    {
        try
        {
            return data.getString ( this.length, this.charset.newDecoder () );
        }
        catch ( final CharacterCodingException e )
        {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public void put ( final IoBuffer data, final String value )
    {
        if ( value == null )
        {
            data.put ( (byte)0x00 );
        }

        try
        {
            data.putString ( value, this.length, this.charset.newEncoder () );
        }
        catch ( final CharacterCodingException e )
        {
            throw new RuntimeException ( e );
        }
    }

}
