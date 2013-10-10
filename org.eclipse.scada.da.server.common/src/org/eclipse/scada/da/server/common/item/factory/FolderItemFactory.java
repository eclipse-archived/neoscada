/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.item.factory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.common.impl.HiveCommon;

public class FolderItemFactory extends HiveItemFactory
{
    private final String folderName;

    protected FolderCommon folder;

    private final FolderCommon parentFolder;

    public FolderItemFactory ( final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName )
    {
        this ( null, hive, parentFolder, baseId, folderName, null );
    }

    public FolderItemFactory ( final CommonItemFactory parentFactory, final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName )
    {
        this ( parentFactory, hive, parentFolder, baseId, folderName, null );
    }

    public FolderItemFactory ( final CommonItemFactory parentFactory, final HiveCommon hive, final FolderCommon parentFolder, final String baseId, final String folderName, final String idDelimiter )
    {
        super ( parentFactory, hive, baseId, idDelimiter );
        this.parentFolder = parentFolder;
        this.folderName = folderName;

        if ( this.parentFolder != null && this.folderName != null )
        {
            this.folder = new FolderCommon ();
            parentFolder.add ( this.folderName, this.folder, new HashMap<String, Variant> () );
        }
    }

    @Override
    public void dispose ()
    {
        if ( isDisposed () )
        {
            return;
        }

        if ( this.parentFolder != null && this.folder != null && this.folderName != null )
        {
            this.parentFolder.remove ( this.folderName );
        }
        super.dispose ();
    }

    @Override
    public void disposeItem ( final DataItem item )
    {
        super.disposeItem ( item );
        if ( this.folder != null )
        {
            this.folder.remove ( item );
        }
    }

    @Override
    protected DataItemCommand constructCommand ( final String localId )
    {
        final DataItemCommand item = super.constructCommand ( localId );
        addToFolder ( item, localId, new HashMap<String, Variant> () );
        return item;
    }

    @Override
    protected DataItemInputChained constructInput ( final String localId )
    {
        final DataItemInputChained item = super.constructInput ( localId );
        addToFolder ( item, localId, new HashMap<String, Variant> () );
        return item;
    }

    @Override
    protected WriteHandlerItem constructWriteHandler ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructWriteHandler ( localId, writeHandler );
        addToFolder ( item, localId, new HashMap<String, Variant> () );
        return item;
    }

    @Override
    protected WriteHandlerItem constructInputOutput ( final String localId, final WriteHandler writeHandler )
    {
        final WriteHandlerItem item = super.constructInputOutput ( localId, writeHandler );
        addToFolder ( item, localId, new HashMap<String, Variant> () );
        return item;
    }

    protected void addToFolder ( final DataItem item, final String name, final Map<String, Variant> attributes )
    {
        if ( this.folder == null )
        {
            return;
        }
        this.folder.add ( name, item.getInformation (), attributes );
    }

    public FolderCommon getFolder ()
    {
        return this.folder;
    }

    public FolderItemFactory createSubFolderFactory ( final String name )
    {
        final FolderItemFactory factory = new FolderItemFactory ( this, this.hive, this.folder, name, name );
        addSubFactory ( factory );
        return factory;
    }

    @Override
    public void disposeAllItems ()
    {
        this.folder.clear ();
        super.disposeAllItems ();
    }

}
