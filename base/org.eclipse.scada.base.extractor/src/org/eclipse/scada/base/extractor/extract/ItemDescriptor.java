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
package org.eclipse.scada.base.extractor.extract;

import java.util.Map;

import org.eclipse.scada.core.Variant;

/**
 * An item descriptor
 * <p>
 * Item descriptors are unique by their local id.
 * </p>
 */
public class ItemDescriptor
{
    private final String localId;

    private final Map<String, Variant> attributes;

    public ItemDescriptor ( final String localId, final Map<String, Variant> attributes )
    {
        this.localId = localId;
        this.attributes = attributes;
    }

    public String getLocalId ()
    {
        return this.localId;
    }

    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }

    @Override
    public String toString ()
    {
        return this.localId;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.localId == null ? 0 : this.localId.hashCode () );
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
        final ItemDescriptor other = (ItemDescriptor)obj;
        if ( this.localId == null )
        {
            if ( other.localId != null )
            {
                return false;
            }
        }
        else if ( !this.localId.equals ( other.localId ) )
        {
            return false;
        }
        return true;
    }

}
