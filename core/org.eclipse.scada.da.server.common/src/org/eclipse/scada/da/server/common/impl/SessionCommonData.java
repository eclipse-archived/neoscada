/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.server.common.DataItem;

public class SessionCommonData
{
    private final Set<DataItem> items = new HashSet<DataItem> ();

    private final Map<Object, Location> paths = new HashMap<Object, Location> ();

    private final Map<Location, Object> pathRev = new HashMap<Location, Object> ();

    public void addItem ( final DataItem item )
    {
        synchronized ( this.items )
        {
            this.items.add ( item );
        }
    }

    public void removeItem ( final DataItem item )
    {
        synchronized ( this.items )
        {
            this.items.remove ( item );
        }
    }

    public boolean containsItem ( final DataItem item )
    {
        synchronized ( this.items )
        {
            return this.items.contains ( item );
        }
    }

    public Set<DataItem> getItems ()
    {
        synchronized ( this.items )
        {
            return this.items;
        }
    }

    // paths
    public void addPath ( final Object tag, final Location path )
    {
        synchronized ( this.paths )
        {
            this.paths.put ( tag, path );
            this.pathRev.put ( path, tag );
        }
    }

    public void removePath ( final Location path )
    {
        synchronized ( this.paths )
        {
            final Object tag = this.pathRev.get ( path );
            if ( tag != null )
            {
                this.pathRev.remove ( path );
                this.paths.remove ( tag );
            }
        }
    }

    public Object getTag ( final Location path )
    {
        synchronized ( this.paths )
        {
            return this.pathRev.get ( path );
        }
    }

    public boolean containsPath ( final Object tag )
    {
        synchronized ( this.paths )
        {
            return this.paths.containsKey ( tag );
        }
    }

    public Map<Object, Location> getPaths ()
    {
        synchronized ( this.paths )
        {
            return this.paths;
        }
    }

    public void clearPaths ()
    {
        synchronized ( this.paths )
        {
            this.paths.clear ();
            this.pathRev.clear ();
        }
    }
}
