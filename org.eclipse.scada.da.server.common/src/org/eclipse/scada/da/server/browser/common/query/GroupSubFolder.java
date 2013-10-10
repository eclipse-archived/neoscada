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
package org.eclipse.scada.da.server.browser.common.query;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.FolderListener;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.utils.collection.MapBuilder;

public class GroupSubFolder implements Folder
{
    private GroupSubFolder parent = null;

    private NameProvider nameProvider = null;

    private final FolderCommon folder = new FolderCommon ();

    private final Map<String, GroupSubFolder> subFolders = new HashMap<String, GroupSubFolder> ();

    public GroupSubFolder ( final NameProvider nameProvider )
    {
        this ( null, nameProvider );
    }

    private GroupSubFolder ( final GroupSubFolder parent, final NameProvider nameProvider )
    {
        this.parent = parent;
        this.nameProvider = nameProvider;
    }

    public GroupSubFolder add ( final Stack<String> path, final ItemDescriptor descriptor )
    {
        if ( path.isEmpty () )
        {
            return insertItem ( descriptor ) ? this : null;
        }
        else
        {
            final String next = path.pop ();
            final GroupSubFolder subFolder = getSubFolder ( next );
            return subFolder.add ( path, descriptor );
        }
    }

    private boolean insertItem ( final ItemDescriptor descriptor )
    {
        final String name = this.nameProvider.getName ( descriptor );

        if ( name == null )
        {
            return false;
        }

        this.folder.add ( name, descriptor.getItem (), descriptor.getAttributes () );

        return true;
    }

    private GroupSubFolder getSubFolder ( final String name )
    {
        if ( !this.subFolders.containsKey ( name ) )
        {
            final GroupSubFolder folder = new GroupSubFolder ( this, this.nameProvider );
            this.subFolders.put ( name, folder );
            final MapBuilder<String, Variant> builder = new MapBuilder<String, Variant> ();
            this.folder.add ( name, folder, builder.getMap () );
        }
        return this.subFolders.get ( name );
    }

    public void remove ( final ItemDescriptor descriptor )
    {
        final DataItem item = descriptor.getItem ();

        if ( !this.folder.remove ( item ) )
        {
            return;
        }

        if ( this.folder.size () <= 0 )
        {
            if ( this.parent != null )
            {
                this.parent.removeSubFolder ( this );
            }
        }
    }

    private void removeSubFolder ( final GroupSubFolder subFolder )
    {
        final String folderName = this.folder.findEntry ( subFolder );
        if ( folderName == null )
        {
            return;
        }

        subFolder.clearSubscribers ();
        this.folder.remove ( folderName );
        this.subFolders.remove ( folderName );

        if ( this.folder.size () <= 0 )
        {
            if ( this.parent != null )
            {
                this.parent.removeSubFolder ( this );
            }
        }
    }

    @Override
    synchronized public Entry[] list ( final Stack<String> path ) throws NoSuchFolderException
    {
        return this.folder.list ( path );
    }

    @Override
    synchronized public void subscribe ( final Stack<String> path, final FolderListener listener, final Object tag ) throws NoSuchFolderException
    {
        this.folder.subscribe ( path, listener, tag );
    }

    @Override
    synchronized public void unsubscribe ( final Stack<String> path, final Object tag ) throws NoSuchFolderException
    {
        this.folder.unsubscribe ( path, tag );
    }

    public void clearSubscribers ()
    {
        this.folder.clearListeners ();
    }

    @Override
    public void added ()
    {
        this.folder.added ();
    }

    @Override
    public void removed ()
    {
        this.folder.removed ();
    }
}
