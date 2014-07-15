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

import java.util.Date;

public class Value<T>
{
    private final T value;

    private final QualityInformation qualityInformation;

    private boolean overflow;

    private long timestamp;

    public Value ( final T value, final long timestamp, final QualityInformation qualityInformation )
    {
        this ( value, timestamp, qualityInformation, false );
    }

    public Value ( final T value, final long timestamp, final QualityInformation qualityInformation, final boolean overflow )
    {
        this.value = value;
        this.timestamp = timestamp;
        this.qualityInformation = qualityInformation;
        this.overflow = overflow;
    }

    public boolean isOverflow ()
    {
        return this.overflow;
    }

    public QualityInformation getQualityInformation ()
    {
        return this.qualityInformation;
    }

    public long getTimestamp ()
    {
        return this.timestamp;
    }

    public T getValue ()
    {
        return this.value;
    }

    public static <T> Value<T> ok ( final T value )
    {
        return new Value<T> ( value, System.currentTimeMillis (), QualityInformation.OK );
    }

    public static Value<Boolean> TRUE ()
    {
        return ok ( Boolean.TRUE );
    }

    public static Value<Boolean> FALSE ()
    {
        return ok ( Boolean.FALSE );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s: %s - %s - %4$tF %4$tH:%4$tM:%4$tS.%4$tL %4$tZ %4$tz", this.value.getClass ().getSimpleName (), this.value, this.qualityInformation, new Date ( this.timestamp ) );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.overflow ? 1231 : 1237 );
        result = prime * result + ( this.qualityInformation == null ? 0 : this.qualityInformation.hashCode () );
        result = prime * result + (int) ( this.timestamp ^ this.timestamp >>> 32 );
        result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
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
        final Value<?> other = (Value<?>)obj;
        if ( this.overflow != other.overflow )
        {
            return false;
        }
        if ( this.qualityInformation == null )
        {
            if ( other.qualityInformation != null )
            {
                return false;
            }
        }
        else if ( !this.qualityInformation.equals ( other.qualityInformation ) )
        {
            return false;
        }
        if ( this.timestamp != other.timestamp )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }

}
