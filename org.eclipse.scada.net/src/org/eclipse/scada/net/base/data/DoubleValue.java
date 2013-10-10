/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base.data;

public class DoubleValue extends Value
{
    public final double value;

    public DoubleValue ( final double value )
    {
        super ();
        this.value = value;
    }

    public double getValue ()
    {
        return this.value;
    }

    @Override
    public String toString ()
    {
        return String.valueOf ( this.value );
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits ( this.value );
        result = PRIME * result + (int) ( temp ^ temp >>> 32 );
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
        final DoubleValue other = (DoubleValue)obj;
        if ( Double.doubleToLongBits ( this.value ) != Double.doubleToLongBits ( other.value ) )
        {
            return false;
        }
        return true;
    }

}
