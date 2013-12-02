/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.configuration.generator.world.validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DataSourceNode
{
    private final String id;

    private final String type;

    private final Set<DataSourceNode> references = new HashSet<DataSourceNode> ();

    public DataSourceNode ( final String type, final String id )
    {
        this.type = type;
        this.id = id;
    }

    public boolean addReference ( final DataSourceNode node )
    {
        return this.references.add ( node );
    }

    public Set<DataSourceNode> getReferences ()
    {
        return Collections.unmodifiableSet ( this.references );
    }

    public String getId ()
    {
        return this.id;
    }

    public String getType ()
    {
        return this.type;
    }

    @Override
    public String toString ()
    {
        return this.type + "@" + this.id;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
        result = prime * result + ( this.type == null ? 0 : this.type.hashCode () );
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
        if ( ! ( obj instanceof DataSourceNode ) )
        {
            return false;
        }
        final DataSourceNode other = (DataSourceNode)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        if ( this.type == null )
        {
            if ( other.type != null )
            {
                return false;
            }
        }
        else if ( !this.type.equals ( other.type ) )
        {
            return false;
        }
        return true;
    }

}