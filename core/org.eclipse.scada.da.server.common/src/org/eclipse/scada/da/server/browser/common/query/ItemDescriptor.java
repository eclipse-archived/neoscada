/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItem;

public class ItemDescriptor
{
    private final Map<String, Variant> attributes;

    private final DataItem item;

    private final String itemId;

    /**
     * Create new item descriptor
     * 
     * @param item
     *            the data item, must not be <code>null</code>
     * @param attributes
     *            the optional describing attributes, may be <code>null</code>
     */
    public ItemDescriptor ( final DataItem item, final Map<String, Variant> attributes )
    {
        this.item = item;
        this.itemId = item.getInformation ().getName ();

        if ( attributes != null )
        {
            this.attributes = new HashMap<String, Variant> ( attributes );
        }
        else
        {
            this.attributes = Collections.emptyMap ();
        }
    }

    public Map<String, Variant> getAttributes ()
    {
        return Collections.unmodifiableMap ( this.attributes );
    }

    public DataItem getItem ()
    {
        return this.item;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.itemId == null ? 0 : this.itemId.hashCode () );
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
        if ( ! ( obj instanceof ItemDescriptor ) )
        {
            return false;
        }
        final ItemDescriptor other = (ItemDescriptor)obj;
        if ( this.itemId == null )
        {
            if ( other.itemId != null )
            {
                return false;
            }
        }
        else if ( !this.itemId.equals ( other.itemId ) )
        {
            return false;
        }
        return true;
    }

}
