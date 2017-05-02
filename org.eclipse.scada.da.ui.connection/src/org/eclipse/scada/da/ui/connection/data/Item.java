/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.data;

import java.io.Serializable;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.ui.IMemento;

/**
 * A data item information object
 * 
 * @author Jens Reimann
 */
public class Item implements Serializable
{
    private static final long serialVersionUID = 7384306434115724744L;

    public static enum Type
    {
        URI,
        ID;
    }

    private Type type;

    private String connectionString;

    private String id;

    public Type getType ()
    {
        return this.type;
    }

    public void setType ( final Type type )
    {
        this.type = type;
    }

    public String getConnectionString ()
    {
        return this.connectionString;
    }

    public void setConnectionString ( final String connectionString )
    {
        this.connectionString = connectionString;
    }

    public String getId ()
    {
        return this.id;
    }

    public void setId ( final String id )
    {
        this.id = id;
    }

    public Item ()
    {
    }

    public Item ( final String connectionString, final String id, final Type type )
    {
        this.connectionString = connectionString;
        this.id = id;

        if ( type == null )
        {
            this.type = Item.Type.URI;
        }
        else
        {
            this.type = type;
        }
    }

    public Item ( final Item item )
    {
        this.connectionString = item.connectionString;
        this.id = item.id;
        this.type = item.type;
    }

    public static Item adaptTo ( final Object o )
    {
        if ( o instanceof Item )
        {
            return (Item)o;
        }
        else if ( o instanceof IAdaptable )
        {
            return (Item) ( (IAdaptable)o ).getAdapter ( Item.class );
        }
        else
        {
            return (Item)Platform.getAdapterManager ().getAdapter ( o, Item.class );
        }
    }

    public static Item loadFrom ( final IMemento memento )
    {
        if ( memento == null )
        {
            return null;
        }

        final String itemId = memento.getString ( "item.id" );
        final String connectionUri = memento.getString ( "connection.uri" );
        final String typeStr = memento.getString ( "type" );
        final Type type;

        if ( typeStr != null )
        {
            type = Type.valueOf ( typeStr );
        }
        else
        {
            type = Type.URI;
        }

        if ( itemId == null || connectionUri == null || type == null )
        {
            return null;
        }
        else
        {
            return new Item ( connectionUri, itemId, type );
        }
    }

    public void saveTo ( final IMemento memento )
    {
        if ( memento == null )
        {
            return;
        }

        memento.putString ( "item.id", this.id );
        memento.putString ( "connection.uri", this.connectionString );
        memento.putString ( "type", this.type.toString () );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.connectionString == null ? 0 : this.connectionString.hashCode () );
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
        if ( ! ( obj instanceof Item ) )
        {
            return false;
        }
        final Item other = (Item)obj;
        if ( this.connectionString == null )
        {
            if ( other.connectionString != null )
            {
                return false;
            }
        }
        else if ( !this.connectionString.equals ( other.connectionString ) )
        {
            return false;
        }
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

    @Override
    public String toString ()
    {
        return String.format ( "[%s: %s#%s]", this.type, this.connectionString, this.id );
    }

    public String toLabel ()
    {
        if ( this.type == Type.URI )
        {
            try
            {
                final ConnectionInformation info = ConnectionInformation.fromURI ( this.connectionString );
                return String.format ( "[%s: %s#%s]", this.type, info.toMaskedString (), this.id );
            }
            catch ( final Exception e )
            {
                // failed to convert to ConnectionInformation, falling back to "toString"
            }
        }

        return String.format ( "[%s: %s#%s]", this.type, this.connectionString, this.id );
    }
}
