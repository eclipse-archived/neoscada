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

public class InformationEntry<T>
{
    private final InformationObjectAddress address;

    private final Value<T> value;

    public InformationEntry ( final InformationObjectAddress address, final Value<T> value )
    {
        this.address = address;
        this.value = value;
    }

    public InformationObjectAddress getAddress ()
    {
        return this.address;
    }

    public Value<T> getValue ()
    {
        return this.value;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s = %s]", this.address, this.value );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.address == null ? 0 : this.address.hashCode () );
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
        final InformationEntry<?> other = (InformationEntry<?>)obj;
        if ( this.address == null )
        {
            if ( other.address != null )
            {
                return false;
            }
        }
        else if ( !this.address.equals ( other.address ) )
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
