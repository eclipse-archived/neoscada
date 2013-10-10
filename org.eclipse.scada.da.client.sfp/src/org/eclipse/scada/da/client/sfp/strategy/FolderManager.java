/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp.strategy;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.sfp.ConnectionHandler;
import org.eclipse.scada.da.core.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderManager
{

    private final static Logger logger = LoggerFactory.getLogger ( FolderManager.class );

    private final ConnectionHandler connectionHandler;

    private final Folder rootFolder;

    private final Map<Location, FolderListener> folderListeners = new HashMap<> ();

    public FolderManager ( final ConnectionHandler connectionHandler )
    {
        this.connectionHandler = connectionHandler;
        this.rootFolder = new Folder ( connectionHandler.getExecutor (), null, new Location () );
    }

    public void dispose ()
    {
        this.rootFolder.dispose ();
    }

    public void subscribeFolder ( final Location location )
    {
    }

    public void unsubscribeFolder ( final Location location )
    {
    }

    public void addEntry ( final Location location, final String name, final String itemId, final String description )
    {
        final Folder folder = this.rootFolder.findFolder ( location.getPathStack (), true );
        folder.addItemEntry ( name, itemId, description );
    }

    public void removeEntry ( final Location location, final String name )
    {
        final Folder folder = this.rootFolder.findFolder ( location.getPathStack (), false );
        if ( folder == null )
        {
            return;
        }

        folder.removeItemEntry ( name );
    }

    public void setFolderListener ( final Location location, final FolderListener listener )
    {
        logger.debug ( "Setting folder listener - location: {}, listener: {}", location, listener );

        this.folderListeners.put ( location, listener );
        final Folder folder = this.rootFolder.findFolder ( location.getPathStack (), false );
        if ( folder != null )
        {
            folder.setListener ( listener );
        }
    }

    protected void execute ( final Runnable command )
    {
        this.connectionHandler.getExecutor ().execute ( command );
    }

}
