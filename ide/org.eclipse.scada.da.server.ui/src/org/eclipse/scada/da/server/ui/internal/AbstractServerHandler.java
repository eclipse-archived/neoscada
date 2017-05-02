/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.ServerLifecycle;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.ui.statushandlers.StatusManager;

public abstract class AbstractServerHandler extends AbstractSelectionHandler
{

    protected abstract void process ( final ServerLifecycle server ) throws CoreException;

    protected abstract String getLabel ();

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final MultiStatus ms = new MultiStatus ( HivesPlugin.PLUGIN_ID, 0, getLabel (), null );

        for ( final ServerLifecycle server : SelectionHelper.iterable ( getSelection (), ServerLifecycle.class ) )
        {
            try
            {
                process ( server );
            }
            catch ( final CoreException e )
            {
                ms.add ( e.getStatus () );
            }
        }
        if ( !ms.isOK () )
        {
            StatusManager.getManager ().handle ( ms, StatusManager.SHOW );
        }
        return null;
    }

}