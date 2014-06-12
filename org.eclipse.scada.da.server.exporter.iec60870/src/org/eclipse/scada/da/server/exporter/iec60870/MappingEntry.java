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
package org.eclipse.scada.da.server.exporter.iec60870;

public class MappingEntry
{
    public static enum ValueType
    {
        FLOAT,
        BOOLEAN;
    }

    private final String itemId;

    private final int asduAddress;

    private final int address;

    private final ValueType valueType;

    public MappingEntry ( final String itemId, final int asduAddress, final int address, final ValueType valueType )
    {
        this.itemId = itemId;
        this.asduAddress = asduAddress;
        this.address = address;
        this.valueType = valueType;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public int getAddress ()
    {
        return this.address;
    }

    public int getAsduAddress ()
    {
        return this.asduAddress;
    }

    public ValueType getValueType ()
    {
        return this.valueType;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s/%s -> %s : %s]", this.asduAddress, this.address, this.itemId, this.valueType );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.address;
        result = prime * result + this.asduAddress;
        result = prime * result + ( this.itemId == null ? 0 : this.itemId.hashCode () );
        result = prime * result + ( this.valueType == null ? 0 : this.valueType.hashCode () );
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
        final MappingEntry other = (MappingEntry)obj;
        if ( this.address != other.address )
        {
            return false;
        }
        if ( this.asduAddress != other.asduAddress )
        {
            return false;
        }
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
        if ( this.valueType != other.valueType )
        {
            return false;
        }
        return true;
    }

}
