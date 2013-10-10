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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListValue extends Value
{
    private final List<Value> values;

    public ListValue ()
    {
        this.values = new LinkedList<Value> ();
    }

    public ListValue ( final int initialCapacity )
    {
        this.values = new ArrayList<Value> ( initialCapacity );
    }

    /**
     * Create a new list value based on a list of values
     * <p><em>Note:</em> the provided list not be modified after the
     * constructor was called</p>
     * @since 0.16.0
     * @param values
     */
    public ListValue ( final List<Value> values )
    {
        this.values = values;
    }

    public ListValue ( final Value[] values )
    {
        this.values = new ArrayList<Value> ( Arrays.asList ( values ) );
    }

    public void add ( final Value value )
    {
        this.values.add ( value );
    }

    public void remove ( final Value value )
    {
        this.values.remove ( value );
    }

    public int size ()
    {
        return this.values.size ();
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this.values == null ? 0 : this.values.hashCode () );
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
        final ListValue other = (ListValue)obj;
        if ( this.values == null )
        {
            if ( other.values != null )
            {
                return false;
            }
        }
        else if ( !this.values.equals ( other.values ) )
        {
            return false;
        }
        return true;
    }

    public List<Value> getValues ()
    {
        return this.values;
    }
}
