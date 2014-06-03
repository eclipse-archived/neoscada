package org.eclipse.scada.da.datasource.totalizer;

import java.io.Serializable;
import java.util.Date;

public class TotalizerState implements Serializable
{

    private static final long serialVersionUID = -6420717271346060602L;

    private final long timestamp;

    private final double total;

    public TotalizerState ( final long timestamp, final double total )
    {
        super ();
        this.timestamp = timestamp;
        this.total = total;
    }

    public long getTimestamp ()
    {
        return timestamp;
    }

    public double getTotal ()
    {
        return total;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + (int) ( timestamp ^ ( timestamp >>> 32 ) );
        long temp;
        temp = Double.doubleToLongBits ( total );
        result = ( prime * result ) + (int) ( temp ^ ( temp >>> 32 ) );
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
        final TotalizerState other = (TotalizerState)obj;
        if ( timestamp != other.timestamp )
        {
            return false;
        }
        if ( Double.doubleToLongBits ( total ) != Double.doubleToLongBits ( other.total ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "TotalizerState [timestamp=" + timestamp + "(" + new Date ( timestamp ) + ",) total=" + total + "]";
    }
}
