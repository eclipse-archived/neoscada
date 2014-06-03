/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.component;

import java.util.Stack;

import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.browser.common.Folder;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.FolderListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentFolder implements Folder
{

    private final static Logger logger = LoggerFactory.getLogger ( ComponentFolder.class );

    private final FolderCommon folderImpl = new FolderCommon ();

    private boolean state;

    private Component component;

    private ActivationHandle handle;

    private boolean active;

    public synchronized void setComponent ( final Component component )
    {
        if ( this.component != null )
        {
            deactivate ();
        }
        this.component = component;
        if ( this.component != null && this.active )
        {
            activate ();
        }
    }

    public Component getComponent ()
    {
        return this.component;
    }

    @Override
    public Entry[] list ( final Stack<String> path ) throws NoSuchFolderException
    {
        return this.folderImpl.list ( path );
    }

    @Override
    public void subscribe ( final Stack<String> path, final FolderListener listener, final Object tag ) throws NoSuchFolderException
    {
        this.folderImpl.subscribe ( path, listener, tag );
        check ();
    }

    @Override
    public void unsubscribe ( final Stack<String> path, final Object tag ) throws NoSuchFolderException
    {
        this.folderImpl.unsubscribe ( path, tag );
        check ();
    }

    private synchronized void check ()
    {
        if ( this.folderImpl.hasSubscribers () != this.state )
        {
            this.state = this.folderImpl.hasSubscribers ();
            if ( this.state )
            {
                activate ();
            }
            else
            {
                deactivate ();
            }
        }
    }

    private void deactivate ()
    {
        logger.info ( "Deactivate" );
        if ( this.handle != null )
        {
            this.handle.dispose ();
            this.handle = null;
        }
        this.active = false;
    }

    private void activate ()
    {
        logger.info ( "Activate" );
        this.active = true;
        if ( this.handle == null )
        {
            this.handle = this.component.activate ();
        }
    }

    @Override
    public void added ()
    {
        this.folderImpl.added ();
    }

    @Override
    public void removed ()
    {
        this.folderImpl.removed ();
    }

    public FolderCommon getFolderImpl ()
    {
        return this.folderImpl;
    }

}
