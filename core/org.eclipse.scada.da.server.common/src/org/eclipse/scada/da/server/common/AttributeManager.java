/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;

public class AttributeManager
{
    private final DataItemBase item;

    private final Map<String, Variant> attributes = new HashMap<String, Variant> ();

    public AttributeManager ( final DataItemBase item )
    {
        this.item = item;
    }

    public Map<String, Variant> getCopy ()
    {
        return new HashMap<String, Variant> ( this.attributes );
    }

    public Map<String, Variant> get ()
    {
        return this.attributes;
    }

    public void update ( final Variant value, final Map<String, Variant> updates, AttributeMode mode )
    {
        // defaults to "update"
        if ( mode == null )
        {
            mode = AttributeMode.UPDATE;
        }

        switch ( mode )
        {
        case SET:
            set ( value, updates );
            break;
        case UPDATE:
            update ( value, updates );
            break;
        }
    }

    public void update ( final Variant value, final Map<String, Variant> updates )
    {
        Map<String, Variant> diff = new HashMap<String, Variant> ();
        synchronized ( this.attributes )
        {
            AttributesHelper.mergeAttributes ( this.attributes, updates, diff );
            if ( value != null || !diff.isEmpty () )
            {
                if ( diff.isEmpty () )
                {
                    // don't send attribute diff if we don't have one
                    diff = null;
                }

                this.item.notifyData ( value, diff );
            }
        }
    }

    public void set ( final Variant value, final Map<String, Variant> values )
    {
        Map<String, Variant> diff = new HashMap<String, Variant> ();
        synchronized ( this.attributes )
        {
            AttributesHelper.set ( this.attributes, values, diff );
            if ( value != null || !diff.isEmpty () )
            {
                if ( diff.isEmpty () )
                {
                    // don't send attribute diff if we don't have one
                    diff = null;
                }

                this.item.notifyData ( value, diff );
            }
        }
    }

    public void update ( final String name, final Variant value )
    {
        final Map<String, Variant> updates = new HashMap<String, Variant> ();
        updates.put ( name, value );

        update ( null, updates );
    }
}
