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

import java.util.concurrent.Callable;

import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;
import org.eclipse.scada.da.server.browser.common.Folder;

public class BrowseCallable implements Callable<Entry[]>
{
    private final Folder folder;

    private final Location location;

    public BrowseCallable ( final Folder folder, final Location location )
    {
        super ();
        this.folder = folder;
        this.location = location;
    }

    public Entry[] call () throws Exception
    {
        if ( this.folder == null )
        {
            throw new NoSuchFolderException ( this.location.asArray () );
        }
        return this.folder.list ( this.location.getPathStack () );
    }

}
