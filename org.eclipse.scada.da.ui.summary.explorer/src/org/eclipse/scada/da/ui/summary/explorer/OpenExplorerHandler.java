/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.summary.explorer;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class OpenExplorerHandler extends AbstractSelectionHandler
{

    private int counter;

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        try
        {
            // the following cast might look a bit weird. But first an adapter is requested and it only adapts to "core" connection services.
            final ConnectionService connectionService = (ConnectionService)SelectionHelper.first ( getSelection (), org.eclipse.scada.core.connection.provider.ConnectionService.class );
            final IViewPart view = getActivePage ().showView ( SummaryExplorerViewPart.VIEW_ID, "" + this.counter++, IWorkbenchPage.VIEW_ACTIVATE );

            ( (SummaryExplorerViewPart)view ).setConnectionService ( connectionService );
        }
        catch ( final PartInitException e )
        {
            throw new ExecutionException ( "Failed to open view", e );
        }
        return null;
    }

}
