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

import java.util.HashMap;
import java.util.Map;

public class MapValue extends Value
{
    private final Map<String, Value> values;

    public MapValue ()
    {
        this.values = new HashMap<String, Value> ();
    }

    public MapValue ( final int initialCapacity )
    {
        this.values = new HashMap<String, Value> ( initialCapacity );
    }

    public MapValue ( final Map<String, Value> values )
    {
        this.values = values;
    }

    public Map<String, Value> getValues ()
    {
        return this.values;
    }

    public void put ( final String key, final Value value )
    {
        this.values.put ( key, value );
    }

    public void remove ( final String key )
    {
        this.values.remove ( key );
    }

    public Value get ( final String key )
    {
        return this.values.get ( key );
    }

    public boolean containsKey ( final String key )
    {
        return this.values.containsKey ( key );
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
        final MapValue other = (MapValue)obj;
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
}
