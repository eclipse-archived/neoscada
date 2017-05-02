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
package org.eclipse.scada.base.extractor.transform;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.eclipse.scada.base.extractor.input.Data;

public class StringTransformer implements Transformer
{
    private final Charset charset;

    public StringTransformer ( final Charset charset )
    {
        this.charset = charset;
    }

    @Override
    public Data transform ( final Data data ) throws Exception
    {
        final Object value = data.getData ();
        if ( value == null || value instanceof String )
        {
            return data;
        }

        try
        {
            return new Data ( convert ( value ), data.getError () );
        }
        catch ( final Exception e )
        {
            return new Data ( null, e );
        }
    }

    protected Object convert ( final Object value ) throws CharacterCodingException
    {
        if ( ! ( value instanceof byte[] ) )
        {
            throw new IllegalArgumentException ( String.format ( "Unable to process data of type: %s. This transformer can only handle byte[]", value.getClass () ) );
        }

        final byte[] data = (byte[])value;
        final CharsetDecoder decoder = this.charset.newDecoder ();
        final CharBuffer result = decoder.decode ( ByteBuffer.wrap ( data ) );
        return result.toString ();
    }
}
