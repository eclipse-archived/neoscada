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
package org.eclipse.scada.da.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.Entry;

public class FolderWatcher extends Observable implements FolderListener
{
    protected Location location = null;

    protected Map<String, Entry> cache = new HashMap<String, Entry> ();

    public FolderWatcher ( final String... path )
    {
        this.location = new Location ( path );
    }

    public FolderWatcher ( final Location location )
    {
        this.location = location;
    }

    public void folderChanged ( final Collection<Entry> added, final Collection<String> removed, final boolean full )
    {
        int changed = 0;

        synchronized ( this )
        {

            if ( full )
            {
                this.cache.clear ();
            }

            for ( final Entry entry : added )
            {
                this.cache.put ( entry.getName (), entry );
                changed++;
            }

            for ( final String name : removed )
            {
                if ( this.cache.remove ( name ) != null )
                {
                    changed++;
                }
            }

            if ( changed > 0 || full )
            {
                setChanged ();

            }
        }

        notifyObservers ();
    }

    public Location getLocation ()
    {
        return this.location;
    }

    public Map<String, Entry> getCache ()
    {
        return this.cache;
    }

    public Collection<Entry> getList ()
    {
        return this.cache.values ();
    }
}
