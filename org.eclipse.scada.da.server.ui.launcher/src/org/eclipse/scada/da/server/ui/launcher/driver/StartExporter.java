/*******************************************************************************
 * Copyright (c) 2013, 2014 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - relocate selection and adapter helper
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.launcher.driver;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.launcher.Activator;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartExporter extends AbstractSelectionHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( StartExporter.class );

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final IFile file : SelectionHelper.iterable ( getSelection (), IFile.class ) )
        {
            try
            {
                HivesPlugin.getDefault ().getServerHost ().startServer ( file );
                getActivePage ().showView ( "org.eclipse.scada.da.server.ui.ServersView" ); //$NON-NLS-1$
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to start file: " + file, e ); //$NON-NLS-1$
                StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
            }
        }
        return null;
    }
}
