/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.utils.password;

import java.nio.CharBuffer;

public class HexCodec implements PasswordDigestCodec
{

    private final boolean uppercase;

    public HexCodec ()
    {
        this ( true );
    }

    public HexCodec ( final boolean uppercase )
    {
        this.uppercase = uppercase;
    }

    @Override
    public byte[] decode ( final String data )
    {
        final int len = data.length ();
        final byte[] result = new byte[len / 2 + len % 2];

        final CharBuffer cb = CharBuffer.wrap ( data );

        int i = 0;

        while ( cb.hasRemaining () )
        {
            if ( cb.remaining () > 1 )
            {
                result[i] = (byte) ( 0xFF & Integer.parseInt ( new String ( new char[] { cb.get (), cb.get () } ), 16 ) );
                i++;
            }
            else
            {
                result[i] = (byte) ( 0xFF & Integer.parseInt ( new String ( new char[] { cb.get () } ), 16 ) );
            }
        }

        return result;
    }

    @Override
    public String encode ( final byte[] data )
    {
        final StringBuffer sb = new StringBuffer ();

        for ( final byte b : data )
        {
            sb.append ( String.format ( "%02x", b ) );
        }

        if ( this.uppercase )
        {
            return sb.toString ().toUpperCase ();
        }
        else
        {
            return sb.toString ();
        }
    }

}
