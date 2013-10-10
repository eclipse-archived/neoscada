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

public class StringValue extends Value
{
    public final String value;

    public StringValue ( final String value )
    {
        this.value = value;
    }

    public String getValue ()
    {
        if ( this.value == null )
        {
            return "";
        }

        return this.value;
    }

    @Override
    public String toString ()
    {
        if ( this.value == null )
        {
            return "";
        }
        else
        {
            return this.value;
        }
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this.value == null ? 0 : this.value.hashCode () );
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
        final StringValue other = (StringValue)obj;
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
