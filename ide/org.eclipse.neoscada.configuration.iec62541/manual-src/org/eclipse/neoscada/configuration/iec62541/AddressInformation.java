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
package org.eclipse.neoscada.configuration.iec62541;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressInformation implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final int[] addr = new int[5];

    public AddressInformation ( final int a1, final int a2, final int a3, final int a4, final int a5 )
    {
        this.addr[0] = validate ( 1, a1 );
        this.addr[1] = validate ( 2, a2 );
        this.addr[2] = validate ( 3, a3 );
        this.addr[3] = validate ( 4, a4 );
        this.addr[4] = validate ( 5, a5 );
    }

    public int[] getAddress ()
    {
        return this.addr;
    }

    private static int validate ( final int nr, final int value )
    {
        if ( value < 0 || value > 0xFF )
        {
            throw new IllegalArgumentException ( String.format ( "Address #%s segment must be between 0 and 255 (%s)", nr, value ) );
        }
        return value;
    }

    @Override
    public String toString ()
    {
        return String.format ( "%d-%d/%d-%d-%d", this.addr[0], this.addr[1], this.addr[2], this.addr[3], this.addr[4] );
    }

    private static Pattern P1 = Pattern.compile ( "(\\d+)\\.(\\d+)" );

    private static Pattern P2 = Pattern.compile ( "(\\d+)-(\\d+)[-\\./](\\d+)-(\\d+)-(\\d+)" );

    public static AddressInformation valueOf ( final String value )
    {
        {
            final Matcher m = P1.matcher ( value );
            if ( m.matches () )
            {
                final Integer i1 = Integer.parseInt ( m.group ( 1 ) );
                final Integer i2 = Integer.parseInt ( m.group ( 2 ) );
                final int a1 = i1 >> 8 & 0xFF;
                final int a2 = i1 & 0xFF;

                final int a3 = i2 >> 16 & 0xFF;
                final int a4 = i2 >> 8 & 0xFF;
                final int a5 = i2 & 0xFF;

                return new AddressInformation ( a1, a2, a3, a4, a5 );
            }
        }
        {
            final Matcher m = P2.matcher ( value );
            if ( m.matches () )
            {
                return new AddressInformation (
                        Integer.parseInt ( m.group ( 1 ) ),
                        Integer.parseInt ( m.group ( 2 ) ),
                        Integer.parseInt ( m.group ( 3 ) ),
                        Integer.parseInt ( m.group ( 4 ) ),
                        Integer.parseInt ( m.group ( 5 ) ) );
            }
        }
        throw new IllegalArgumentException ( String.format ( "Unable to parse address: %s", value ) );
    }
}
