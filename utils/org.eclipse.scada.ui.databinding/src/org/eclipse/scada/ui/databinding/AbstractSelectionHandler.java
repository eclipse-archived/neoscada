/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractSelectionHandler extends AbstractHandler
{

    private IWorkbenchWindow activeWindow;

    protected IWorkbenchPage getActivePage ()
    {
        final IWorkbenchWindow window = getWorkbenchWindow ();
        return window.getActivePage ();
    }

    protected Shell getShell ()
    {
        if ( this.activeWindow == null )
        {
            return Display.getDefault ().getActiveShell ();
        }
        else
        {
            return this.activeWindow.getShell ();
        }
    }

    /**
     * Returns the selection of the active workbench window.
     *
     * @return the current selection in the active workbench window or <code>null</code>
     */
    protected final IStructuredSelection getSelection ()
    {
        final IWorkbenchWindow window = getWorkbenchWindow ();
        if ( window != null )
        {
            final ISelection sel = window.getSelectionService ().getSelection ();
            if ( sel instanceof IStructuredSelection )
            {
                return (IStructuredSelection)sel;
            }
        }
        return null;
    }

    /**
     * Returns the active workbench window.
     *
     * @return the active workbench window or <code>null</code> if not available
     */
    protected final IWorkbenchWindow getWorkbenchWindow ()
    {
        if ( this.activeWindow == null )
        {
            this.activeWindow = PlatformUI.getWorkbench ().getActiveWorkbenchWindow ();
        }
        return this.activeWindow;
    }

}