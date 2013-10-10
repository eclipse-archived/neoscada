/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base.data;

public class BooleanValue extends Value
{
    public final boolean value;

    public final static BooleanValue TRUE = new BooleanValue ( true );

    public final static BooleanValue FALSE = new BooleanValue ( false );

    public static BooleanValue valueOf ( final boolean value )
    {
        return value ? TRUE : FALSE;
    }

    protected BooleanValue ( final boolean value )
    {
        super ();
        this.value = value;
    }

    public boolean getValue ()
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
        result = PRIME * result + ( this.value ? 1231 : 1237 );
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
        final BooleanValue other = (BooleanValue)obj;
        if ( this.value != other.value )
        {
            return false;
        }
        return true;
    }

}
