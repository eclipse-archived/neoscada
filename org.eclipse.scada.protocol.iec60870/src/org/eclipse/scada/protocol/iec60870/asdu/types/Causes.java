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
package org.eclipse.scada.protocol.iec60870.asdu.types;

public final class Causes
{
    private static Cause[] causes = new Cause[64];

    static
    {
        for ( final Cause cause : StandardCause.values () )
        {
            causes[cause.getValue ()] = cause;
        }
        for ( int i = 14; i < 20; i++ )
        {
            causes[i] = new CustomCause ( i );
        }
        for ( int i = 42; i < 44; i++ )
        {
            causes[i] = new CustomCause ( i );
        }
        for ( int i = 49; i < 64; i++ )
        {
            causes[i] = new CustomCause ( i );
        }
    }

    private Causes ()
    {
    }

    public static Cause valueOf ( final int value )
    {
        return causes[value];
    }

    public static boolean isInterrogation ( final Cause cause )
    {
        final short value = cause.getValue ();
        return value >= StandardCause.STATION_REQUEST.getValue () && value <= StandardCause.GROUP_REQUEST_9.getValue ();
    }

}
