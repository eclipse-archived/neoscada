/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.Documentable;

public abstract class AbstractFolderProcessor extends BasicProcessor implements NodeElementProcessor
{
    public AbstractFolderProcessor ( final Documentable documentable )
    {
        super ( documentable );
    }

    @Override
    public void process ( final IFolder nodeDir, final IProgressMonitor monitor ) throws Exception
    {
        final String name = makeName ();
        final IFolder folder = nodeDir.getFolder ( name );
        folder.create ( true, true, monitor );

        processLocal ( folder, monitor );
    }

    protected abstract void processLocal ( final IFolder folder, final IProgressMonitor monitor ) throws Exception;
}
