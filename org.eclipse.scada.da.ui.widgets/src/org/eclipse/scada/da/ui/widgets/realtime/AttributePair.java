/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.ui.connection.data.Item;

public class AttributePair implements IAdaptable
{
    public String key;

    public Variant value;

    public Item item;

    public AttributePair ( final Item item, final String key, final Variant value )
    {
        super ();
        this.item = item;
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this.key == null ? 0 : this.key.hashCode () );
        result = PRIME * result + ( this.value == null ? 0 : this.value.hashCode () );
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
        final AttributePair other = (AttributePair)obj;
        if ( this.key == null )
        {
            if ( other.key != null )
            {
                return false;
            }
        }
        else if ( !this.key.equals ( other.key ) )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }

    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter == Item.class )
        {
            return this.item;
        }
        return null;
    }
}