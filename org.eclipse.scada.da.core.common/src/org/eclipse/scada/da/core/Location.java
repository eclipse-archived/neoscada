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
package org.eclipse.scada.da.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.str.StringHelper;

@Immutable
public class Location
{
    private final String[] location;

    public Location ( final String... location )
    {
        this.location = location.clone ();
    }

    public Location ( final Location location )
    {
        this.location = location.location.clone ();
    }

    public Location ( final Location parent, final String child )
    {
        final ArrayList<String> result = new ArrayList<String> ( parent.asList () );
        if ( child != null )
        {
            result.add ( child );
        }
        this.location = result.toArray ( new String[result.size ()] );
    }

    public Location ()
    {
        this.location = new String[0];
    }

    public Location ( final List<String> location )
    {
        this.location = location.toArray ( new String[location.size ()] );
    }

    public String[] asArray ()
    {
        return this.location.clone ();
    }

    /**
     * Returns the path elements in an unmodifiable list
     * @return the path elements as list
     */
    public List<String> asList ()
    {
        return Collections.unmodifiableList ( Arrays.asList ( this.location ) );
    }

    @Override
    public String toString ()
    {
        return toString ( "/" );
    }

    public String toString ( final String separator )
    {
        return separator + StringHelper.join ( this.location, separator );
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + Arrays.hashCode ( this.location );
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
        final Location other = (Location)obj;
        if ( !Arrays.equals ( this.location, other.location ) )
        {
            return false;
        }
        return true;
    }

    public Stack<String> getPathStack ()
    {
        final Stack<String> stack = new Stack<String> ();

        for ( int i = this.location.length; i > 0; i-- )
        {
            stack.push ( this.location[i - 1] );
        }

        return stack;
    }
}
