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
package org.eclipse.scada.ae.ui.views.export.excel.config;

public abstract class StaticField implements Field
{
    private final String name;

    public StaticField ( final String name )
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
        final DynamicField other = (DynamicField)obj;
        if ( this.name == null )
        {
            if ( other.attributeName != null )
            {
                return false;
            }
        }
        else if ( !this.name.equals ( other.attributeName ) )
        {
            return false;
        }
        return true;
    }

    public String getHeader ()
    {
        return this.name;
    }

}