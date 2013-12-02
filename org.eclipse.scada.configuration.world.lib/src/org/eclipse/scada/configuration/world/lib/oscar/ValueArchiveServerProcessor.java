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
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;

public class ValueArchiveServerProcessor extends EquinoxApplicationProcessor
{

    private final ValueArchiveServer app;

    public ValueArchiveServerProcessor ( final ValueArchiveServer app )
    {
        super ( app );
        this.app = app;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        // run stuff     
        new ValueArchiveProcessor ( this.app, ctx, output.getFile ( "valueArchives.cmd" ) ).process ( monitor );
    }
}
