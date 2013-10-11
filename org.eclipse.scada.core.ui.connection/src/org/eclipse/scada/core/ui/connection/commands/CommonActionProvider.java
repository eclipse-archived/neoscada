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
package org.eclipse.scada.core.ui.connection.commands;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;

public class CommonActionProvider extends org.eclipse.ui.navigator.CommonActionProvider
{

    private Action openAction;

    @Override
    public void init ( final ICommonActionExtensionSite aSite )
    {
        super.init ( aSite );
        final ICommonViewerSite viewSite = aSite.getViewSite ();
        if ( viewSite instanceof ICommonViewerWorkbenchSite )
        {
            final ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite)viewSite;
            this.openAction = new Action ( "Open", IAction.AS_PUSH_BUTTON ) {
                @Override
                public void run ()
                {
                    handleOpen ( workbenchSite );
                }
            };
        }
    }

    protected void handleOpen ( final ICommonViewerWorkbenchSite workbenchSite )
    {
        for ( final ConnectionHolder holder : SelectionHelper.iterable ( workbenchSite.getSelectionProvider ().getSelection (), ConnectionHolder.class ) )
        {
            if ( holder.getConnectionState () == ConnectionState.BOUND )
            {
                holder.disconnect ();
            }
            else if ( holder.getConnectionState () == ConnectionState.CLOSED )
            {
                holder.connect ( DisplayCallbackHandler.createDefault ( workbenchSite.getShell () ) );
            }
        }
    }

    @Override
    public void fillActionBars ( final IActionBars actionBars )
    {
        if ( this.openAction.isEnabled () )
        {
            actionBars.setGlobalActionHandler ( ICommonActionConstants.OPEN, this.openAction );
        }
    }

}
