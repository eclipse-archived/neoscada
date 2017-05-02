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
package org.eclipse.scada.ca.ui.connection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.scada.ca.ui.editor.EditorHelper;

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
                    EditorHelper.handleOpen ( workbenchSite.getPage (), workbenchSite.getSelectionProvider () );
                }
            };
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

    @Override
    public void fillContextMenu ( final IMenuManager menu )
    {
        if ( this.openAction.isEnabled () )
        {
            // menu.appendToGroup ( ICommonMenuConstants.GROUP_OPEN, this.openAction );
        }
    }

}
