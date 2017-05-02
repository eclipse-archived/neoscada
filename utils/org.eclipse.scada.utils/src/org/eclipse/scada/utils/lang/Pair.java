/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.lang;

public class Pair<T1, T2>
{
    public T1 first = null;

    public T2 second = null;

    public Pair ( final T1 first, final T2 second )
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.first == null ? 0 : this.first.hashCode () );
        result = prime * result + ( this.second == null ? 0 : this.second.hashCode () );
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
        @SuppressWarnings ( "rawtypes" )
        final Pair other = (Pair)obj;
        if ( this.first == null )
        {
            if ( other.first != null )
            {
                return false;
            }
        }
        else if ( !this.first.equals ( other.first ) )
        {
            return false;
        }
        if ( this.second == null )
        {
            if ( other.second != null )
            {
                return false;
            }
        }
        else if ( !this.second.equals ( other.second ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "Pair(" + this.first + ", " + this.second + ")";
    }
}
