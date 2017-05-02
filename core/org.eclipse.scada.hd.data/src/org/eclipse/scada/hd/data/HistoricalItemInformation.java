/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.data;

public class HistoricalItemInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public HistoricalItemInformation ( final String itemId, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes )
    {
        this.itemId = itemId;
        this.attributes = attributes;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
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

        if ( ! ( obj instanceof HistoricalItemInformation ) )
        {
            return false;
        }
        final HistoricalItemInformation other = (HistoricalItemInformation)obj;

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

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;

        result = prime * result + ( this.itemId == null ? 0 : this.itemId.hashCode () );

        return result;
    }

    @Override
    public String toString ()
    {
        return "[HistoricalItemInformation - " + "itemId: " + this.itemId + ", " + "attributes: " + this.attributes + "]";
    }
}
