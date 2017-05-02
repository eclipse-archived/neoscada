/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.connection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.scada.da.client.FolderManager;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.FolderListener;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 *
 */
public class ProxyFolder implements Folder, org.eclipse.scada.da.client.FolderListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyFolder.class );

    private final FolderCommon folder = new FolderCommon ();

    private final Location location;

    private boolean initialized = false;

    private final FolderManager folderManager;

    private final ProxyGroup proxyGroup;

    /**
     * @param folderManager
     * @param proxyGroup
     * @param location
     */
    public ProxyFolder ( final FolderManager folderManager, final ProxyGroup proxyGroup, final Location location )
    {
        this.folderManager = folderManager;
        this.location = location;
        this.proxyGroup = proxyGroup;
    }

    @Override
    public void added ()
    {
        this.folder.added ();
    }

    @Override
    public Entry[] list ( final Stack<String> path ) throws NoSuchFolderException
    {
        return this.folder.list ( path );
    }

    @Override
    public void removed ()
    {
        checkDisconnect ( true );
        this.folder.removed ();
    }

    private void checkDisconnect ( final boolean force )
    {
        synchronized ( this )
        {
            if ( !this.initialized )
            {
                return;
            }
            if ( !force && this.folder.hasSubscribers () )
            {
                return;
            }

            this.initialized = false;
            logger.info ( "Disconnect folder for location: {}", this.location );
        }
        this.folderManager.removeFolderListener ( this, this.location );
        this.folder.clear ();
    }

    @Override
    public void subscribe ( final Stack<String> path, final FolderListener listener, final Object tag ) throws NoSuchFolderException
    {
        connect ();
        this.folder.subscribe ( path, listener, tag );
    }

    private void connect ()
    {
        synchronized ( this )
        {
            if ( this.initialized )
            {
                return;
            }
            this.initialized = true;
        }
        this.folderManager.addFolderListener ( this, this.location );
    }

    @Override
    public void unsubscribe ( final Stack<String> path, final Object tag ) throws NoSuchFolderException
    {
        this.folder.unsubscribe ( path, tag );

        // check if we can disconnect
        checkDisconnect ( false );
    }

    @Override
    public void folderChanged ( final Collection<Entry> added, final Collection<String> removed, final boolean full )
    {
        try
        {
            handleFolderChanged ( added, removed, full );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to handle folder change", e );
        }
    }

    private void handleFolderChanged ( final Collection<Entry> added, final Collection<String> removed, final boolean full )
    {
        if ( full )
        {
            this.folder.clear ();
        }

        // remove items
        for ( final String entry : removed )
        {
            this.folder.remove ( entry );
        }

        final Map<String, DataItemInformation> items = new HashMap<String, DataItemInformation> ();
        final Map<String, Folder> folders = new HashMap<String, Folder> ();

        // add items
        for ( final Entry entry : added )
        {
            if ( entry instanceof DataItemEntry )
            {
                final DataItemEntry dataItemEntry = (DataItemEntry)entry;
                final String itemId = this.proxyGroup.convertToProxyId ( dataItemEntry.getId () );
                if ( itemId != null )
                {
                    final DataItemInformation itemInformation = new DataItemInformationBase ( itemId, dataItemEntry.getIODirections () );
                    items.put ( entry.getName (), itemInformation );
                }
            }
            else if ( entry instanceof FolderEntry )
            {
                final List<String> location = new ArrayList<String> ( this.location.asList () );
                location.add ( entry.getName () );
                folders.put ( entry.getName (), new ProxyFolder ( this.folderManager, this.proxyGroup, new Location ( location ) ) );
            }
        }
        this.folder.add ( folders, items );
    }
}
