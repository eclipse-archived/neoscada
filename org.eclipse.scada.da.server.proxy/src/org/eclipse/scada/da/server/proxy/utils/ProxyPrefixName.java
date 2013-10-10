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
package org.eclipse.scada.da.server.proxy.utils;

/**
 * typesafe indicator of proxy prefix name
 * 
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class ProxyPrefixName
{
    private final String name;

    /**
     * @param name
     */
    public ProxyPrefixName ( final String name )
    {
        this.name = name;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.name == null ? 0 : this.name.hashCode () );
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
        final ProxyPrefixName other = (ProxyPrefixName)obj;
        if ( this.name == null )
        {
            if ( other.name != null )
            {
                return false;
            }
        }
        else if ( !this.name.equals ( other.name ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return this.name;
    }

    /**
     * @return name (the same as toString())
     */
    public String getName ()
    {
        return this.name;
    }
}
