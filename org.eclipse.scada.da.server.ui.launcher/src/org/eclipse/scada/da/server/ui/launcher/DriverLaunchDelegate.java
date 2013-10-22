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
package org.eclipse.scada.da.server.ui.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

public class DriverLaunchDelegate implements ILaunchConfigurationDelegate
{

    @Override
    public void launch ( final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor ) throws CoreException
    {
        final IStringVariableManager svm = VariablesPlugin.getDefault ().getStringVariableManager ();

        final String fileString = configuration.getAttribute ( ConfiguratorLauncherConstants.EXPORTER_FILE, "" ); //$NON-NLS-1$
        final String file = svm.performStringSubstitution ( fileString, true );
        HivesPlugin.getDefault ().getServerHost ().startServer ( URI.createFileURI ( file ) );

        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                try
                {
                    PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getActivePage ().showView ( "org.eclipse.scada.da.server.ui.ServersView" ); //$NON-NLS-1$
                }
                catch ( final PartInitException e )
                {
                    StatusManager.getManager ().handle ( e.getStatus () );
                }
            }
        } );
    }

}
