/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.filter.internal;

import org.eclipse.scada.utils.filter.internal.Tokenizer.TokenizeException;

public class Encoder
{

    public static final byte CHAR_NUL = 0x00;

    public static final byte CHAR_ASTERISK = '*';

    public static final byte CHAR_PAREN_LEFT = '(';

    public static final byte CHAR_PAREN_RIGHT = ')';

    public static final byte CHAR_BACKSPACE = '\\';

    public static String encode ( final String toEncode )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( int i = 0; i < toEncode.length (); i++ )
        {
            final char b = toEncode.charAt ( i );
            switch ( b )
            {
                case CHAR_NUL:
                case CHAR_ASTERISK:
                case CHAR_PAREN_LEFT:
                case CHAR_PAREN_RIGHT:
                case CHAR_BACKSPACE:
                    sb.append ( "\\" + String.format ( "%02x", new Object[] { b & 0xff } ) );
                    break;
                default:
                    if ( b < 32 || b > 127 )
                    {
                        sb.append ( "\\" + String.format ( "%02x", new Object[] { b & 0xff } ) );
                    }
                    else
                    {
                        sb.append ( Character.valueOf ( b ) );
                    }
            }
        }
        return sb.toString ();
    }

    public static String decode ( final String toDecode ) throws TokenizeException
    {
        final StringBuilder sb = new StringBuilder ();
        for ( int i = 0; i < toDecode.length (); i++ )
        {
            final char c = toDecode.charAt ( i );
            if ( c == '\\' )
            {
                if ( i + 2 >= toDecode.length () )
                {
                    throw new TokenizeException ( "valid escape sequence expected" );
                }
                final String ec = "" + toDecode.charAt ( i + 1 ) + toDecode.charAt ( i + 2 );
                try
                {
                    sb.append ( String.valueOf ( (char)Integer.parseInt ( ec, 16 ) ) );
                }
                catch ( final NumberFormatException e )
                {
                    throw new TokenizeException ( "valid escape sequence expected" );
                }
                i += 2;
            }
            else
            {
                sb.append ( c );
            }
        }
        return sb.toString ();
    }
}
