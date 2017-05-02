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
package org.eclipse.scada.da.ui.client.test.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.scada.da.ui.client.test.wizards.WriteOperationWizard;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWizard;

public class WriteOperationAction implements IObjectActionDelegate, IViewActionDelegate
{
    private IWorkbenchPartSite site;

    private IStructuredSelection selection;

    @Override
    public void run ( final IAction action )
    {
        if ( this.selection == null )
        {
            return;
        }

        final IWorkbenchWizard wiz = new WriteOperationWizard ();
        wiz.init ( this.site.getWorkbenchWindow ().getWorkbench (), this.selection );

        // Embed the wizard into a dialog
        final WizardDialog dialog = new WizardDialog ( this.site.getShell (), wiz );
        dialog.open ();
    }

    @Override
    public void selectionChanged ( final IAction action, final ISelection selection )
    {
        if ( selection == null )
        {
            return;
        }
        if ( ! ( selection instanceof IStructuredSelection ) )
        {
            return;
        }

        this.selection = (IStructuredSelection)selection;
    }

    @Override
    public void setActivePart ( final IAction action, final IWorkbenchPart targetPart )
    {
        this.site = targetPart.getSite ();
    }

    @Override
    public void init ( final IViewPart view )
    {
        this.site = view.getSite ();
    }

}
