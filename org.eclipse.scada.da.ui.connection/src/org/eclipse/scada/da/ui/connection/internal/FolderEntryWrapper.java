/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new root location
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.internal;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.da.client.FolderManager;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderEntryWrapper implements IAdaptable
{
    private final static Logger logger = LoggerFactory.getLogger ( FolderEntryWrapper.class );

    private final FolderManager folderManager;

    private final FolderEntryWrapper parent;

    private final Entry entry;

    private final Location location;

    private final ConnectionHolder holder;

    public FolderEntryWrapper ( final ConnectionHolder holder, final FolderManager folderManager )
    {
        this.holder = holder;
        this.folderManager = folderManager;
        this.parent = null;
        this.entry = null;
        this.location = Location.ROOT;
    }

    public FolderEntryWrapper ( final FolderEntryWrapper parent, final Entry entry, final Location location )
    {
        this.holder = parent.getHolder ();
        this.folderManager = parent.getFolderManager ();
        this.parent = parent;
        this.entry = entry;
        this.location = location;

        logger.info ( "Create new folder entry wrapper {} ", this );
    }

    protected ConnectionHolder getHolder ()
    {
        return this.holder;
    }

    public Location getLocation ()
    {
        return this.location;
    }

    public FolderManager getFolderManager ()
    {
        return this.folderManager;
    }

    public Entry getEntry ()
    {
        return this.entry;
    }

    public FolderEntryWrapper getParent ()
    {
        return this.parent;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        logger.debug ( "Adapt to: {}", adapter );

        if ( adapter == FolderEntry.class && this.entry instanceof FolderEntry )
        {
            return this.entry;
        }
        if ( adapter == DataItemEntry.class && this.entry instanceof DataItemEntry )
        {
            return this.entry;
        }
        if ( adapter == Item.class && this.entry instanceof DataItemEntry )
        {
            final DataItemEntry entry = (DataItemEntry)this.entry;
            return new Item ( getHolder ().getConnectionInformation ().getConnectionInformation ().toString (), entry.getId (), Type.URI );
        }

        return null;
    }

    @Override
    public String toString ()
    {
        return String.format ( "%s -> %s", this.holder.getConnectionInformation (), this.location );
    }

}
