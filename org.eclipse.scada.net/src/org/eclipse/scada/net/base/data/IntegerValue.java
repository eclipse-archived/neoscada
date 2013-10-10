/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base.data;

public class IntegerValue extends Value
{

    private static final int VALUES = 100;

    private static final IntegerValue[] staticValues = new IntegerValue[VALUES];

    static
    {
        for ( int i = 0; i < staticValues.length; i++ )
        {
            staticValues[i] = new IntegerValue ( i );
        }
    }

    public static IntegerValue valueOf ( final int value )
    {
        if ( value >= 0 && value < VALUES )
        {
            return staticValues[value];
        }
        else
        {
            return new IntegerValue ( value );
        }
    }

    public final int value;

    public IntegerValue ( final int value )
    {
        this.value = value;
    }

    public int getValue ()
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
        result = PRIME * result + this.value;
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
        final IntegerValue other = (IntegerValue)obj;
        if ( this.value != other.value )
        {
            return false;
        }
        return true;
    }

}
