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
package org.eclipse.scada.chart;

/**
 * @author Jens Reimann
 * @immutable
 */
public class DataEntry implements Comparable<DataEntry>
{
    private final long timestamp;

    private final Double value;

    public DataEntry ( final long timestamp, final Double value )
    {
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getTimestamp ()
    {
        return this.timestamp;
    }

    public Double getValue ()
    {
        return this.value;
    }

    @Override
    public int compareTo ( final DataEntry o )
    {
        return this.timestamp < o.timestamp ? -1 : this.timestamp == o.timestamp ? 0 : 1;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( this.timestamp ^ this.timestamp >>> 32 );
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
        final DataEntry other = (DataEntry)obj;
        if ( this.timestamp != other.timestamp )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%1$tF %1$tT.%1$tL]=%2$s", this.timestamp, this.value );
    }
}
