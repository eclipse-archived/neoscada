/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - some bug fixes
 *******************************************************************************/
package org.eclipse.scada.da.datasource.data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;

/**
 * a light weight alternative to DataItemValue, without attributes and exception
 * info
 */
public class DataItemValueLight implements Comparable<DataItemValueLight>, Serializable
{
    private static final long serialVersionUID = -1693255411435666183L;

    public static final DataItemValueLight DISCONNECTED = new DataItemValueLight ( Variant.NULL, SubscriptionState.DISCONNECTED, Long.MIN_VALUE, false, false );

    public static final Comparator<DataItemValueLight> timestampComparator = new TimestampComparator();

    private final Variant value;

    private final SubscriptionState subscriptionState;

    private final long timestamp;

    private final boolean isManual;

    private final boolean isError;
    
    public static class TimestampComparator implements Comparator<DataItemValueLight> {
        @Override
        public int compare ( DataItemValueLight a, DataItemValueLight b )
        {
            int c = 0;
            c = Long.compare ( a.timestamp, b.timestamp );
            if ( c != 0 )
            {
                return c;
            }
            c = a.subscriptionState.compareTo ( b.subscriptionState );
            if ( c != 0 )
            {
                return c;
            }
            return a.value.compareTo ( b.value );
        }
    }
    
    public DataItemValueLight ( final Variant value, final SubscriptionState subscriptionState, final long timestamp, final boolean isManual, final boolean isError )
    {
        if ( subscriptionState == null )
        {
            throw new IllegalArgumentException ( "'subscriptionState' must not be null" );
        }
        this.value = Variant.valueOf ( value );
        this.subscriptionState = subscriptionState;
        this.timestamp = timestamp;
        this.isManual = isManual;
        this.isError = isError;
    }

    public static DataItemValueLight valueOf ( final DataItemValue dataItemValue )
    {
        if ( ( dataItemValue == null ) || dataItemValue.equals ( DataItemValue.DISCONNECTED ) )
        {
            return DISCONNECTED;
        }
        return new DataItemValueLight ( dataItemValue.getValue (), dataItemValue.getSubscriptionState (), dataItemValue.getTimestamp () == null ? Long.MIN_VALUE : dataItemValue.getTimestamp ().getTimeInMillis (), dataItemValue.isManual (), dataItemValue.isError () );
    }

    public static DataItemValueLight valueOf ( final DataItemValueLight dataItemValueLight )
    {
        if ( ( dataItemValueLight == null ) || dataItemValueLight.equals ( DISCONNECTED ) )
        {
            return DISCONNECTED;
        }
        return new DataItemValueLight ( dataItemValueLight.value, dataItemValueLight.subscriptionState, dataItemValueLight.timestamp, dataItemValueLight.isManual, dataItemValueLight.isError );
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public SubscriptionState getSubscriptionState ()
    {
        return this.subscriptionState;
    }

    public long getTimestamp ()
    {
        return this.timestamp;
    }

    public boolean hasValue ()
    {
        return this.value.isNumber ();
    }

    public boolean isManual ()
    {
        return this.isManual;
    }

    public boolean isError ()
    {
        return this.isError;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + ( this.value == null ? 0 : this.value.hashCode () );
        result = ( prime * result ) + ( this.subscriptionState == null ? 0 : this.subscriptionState.hashCode () );
        result = ( prime * result ) + (int) ( this.timestamp ^ ( this.timestamp >>> 32 ) );
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
        final DataItemValueLight other = (DataItemValueLight)obj;
        if ( this.subscriptionState != other.subscriptionState )
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

    @Override
    public int compareTo ( final DataItemValueLight o )
    {
        int c = 0;
        c = this.value.compareTo ( o.value );
        if ( c != 0 )
        {
            return c;
        }
        c = this.subscriptionState.compareTo ( o.subscriptionState );
        if ( c != 0 )
        {
            return c;
        }
        return Long.compare ( this.timestamp, o.timestamp );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();
        sb.append ( this.value );
        sb.append ( "[" );
        sb.append ( this.subscriptionState );
        sb.append ( "]" );
        sb.append ( String.format ( "[%1$tF %1$tT,%1$tL]", new Date ( this.timestamp ) ) );
        return sb.toString ();
    }
}
