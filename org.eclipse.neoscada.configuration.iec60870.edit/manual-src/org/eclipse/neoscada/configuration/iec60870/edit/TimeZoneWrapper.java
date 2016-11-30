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
package org.eclipse.neoscada.configuration.iec60870.edit;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class TimeZoneWrapper
{
    private final TimeZone timeZone;

    private final String timeZoneId;

    public TimeZoneWrapper ( final TimeZone timeZone )
    {
        this.timeZone = timeZone;
        this.timeZoneId = timeZone.getID ();
    }

    @Override
    public String toString ()
    {
        return this.timeZoneId;
    }

    public TimeZone getTimeZone ()
    {
        return this.timeZone;
    }

    public static List<TimeZoneWrapper> getAvailable ()
    {
        final String[] tz = TimeZone.getAvailableIDs ();
        final List<TimeZoneWrapper> result = new ArrayList<> ( tz.length );

        for ( int i = 0; i < tz.length; i++ )
        {
            result.add ( new TimeZoneWrapper ( TimeZone.getTimeZone ( tz[i] ) ) );
        }

        return result;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.timeZoneId == null ? 0 : this.timeZoneId.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final TimeZoneWrapper other = (TimeZoneWrapper)obj;
        if ( this.timeZoneId == null )
        {
            if ( other.timeZoneId != null )
            {
                return false;
            }
        }
        else if ( !this.timeZoneId.equals ( other.timeZoneId ) )
        {
            return false;
        }
        return true;
    }

}
