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
package org.eclipse.scada.da.server.exporter.modbus.io;

public class SourceDefinition
{
    private final String itemId;

    private final int offset;

    private final SourceType type;

    /**
     * Create a new source definition
     * 
     * @param itemId
     *            the item id
     * @param offset
     *            the offset (in bytes)
     * @param type
     *            the value type
     */
    public SourceDefinition ( final String itemId, final int offset, final SourceType type )
    {
        this.itemId = itemId;
        this.offset = offset;
        this.type = type;
    }

    public SourceType getType ()
    {
        return this.type;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public int getOffset ()
    {
        return this.offset;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.itemId == null ? 0 : this.itemId.hashCode () );
        result = prime * result + this.offset;
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
        if ( ! ( obj instanceof SourceDefinition ) )
        {
            return false;
        }
        final SourceDefinition other = (SourceDefinition)obj;
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
        if ( this.offset != other.offset )
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

    @Override
    public String toString ()
    {
        return String.format ( "[SourceDefinition - itemId: %s, offset: %s, type: %s]", this.itemId, this.offset, this.type );
    }

}
