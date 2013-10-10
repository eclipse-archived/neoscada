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
package org.eclipse.scada.da.client;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.da.core.Location;

public class FolderManager implements ConnectionStateListener
{
    protected Connection connection = null;

    private final Map<Location, FolderSyncController> folderListeners = new HashMap<Location, FolderSyncController> ();

    public FolderManager ( final Connection connection )
    {
        this.connection = connection;
        this.connection.addConnectionStateListener ( this );
    }

    public void dispose ()
    {
        this.connection.removeConnectionStateListener ( this );
        disconnectAllFolders ();
        this.connection = null;
    }

    public void addFolderListener ( final FolderListener listener, final Location location )
    {
        synchronized ( this.folderListeners )
        {
            if ( !this.folderListeners.containsKey ( location ) )
            {
                this.folderListeners.put ( location, new FolderSyncController ( this.connection, new Location ( location ) ) );
            }

            final FolderSyncController controller = this.folderListeners.get ( location );
            controller.addListener ( listener );
        }
    }

    public void addFolderWatcher ( final FolderWatcher watcher )
    {
        addFolderListener ( watcher, watcher.getLocation () );
    }

    public void removeFolderListener ( final FolderListener listener, final Location location )
    {
        synchronized ( this.folderListeners )
        {
            final FolderSyncController controller = this.folderListeners.get ( location );
            if ( controller == null )
            {
                return;
            }
            controller.removeListener ( listener );
        }
    }

    public void removeFolderWatcher ( final FolderWatcher watcher )
    {
        removeFolderListener ( watcher, watcher.getLocation () );
    }

    private void resyncAllFolders ()
    {
        synchronized ( this.folderListeners )
        {
            for ( final Map.Entry<Location, FolderSyncController> entry : this.folderListeners.entrySet () )
            {
                entry.getValue ().resync ();
            }
        }
    }

    private void disconnectAllFolders ()
    {
        synchronized ( this.folderListeners )
        {
            for ( final Map.Entry<Location, FolderSyncController> entry : this.folderListeners.entrySet () )
            {
                this.connection.getExecutor ().execute ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        entry.getValue ().disconnected ();
                    }
                } );
            }
        }
    }

    @Override
    public void stateChange ( final org.eclipse.scada.core.client.Connection connection, final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case BOUND:
                resyncAllFolders ();
                break;
            case CLOSED:
                disconnectAllFolders ();
                break;
            default:
                break;
        }
    }
}
