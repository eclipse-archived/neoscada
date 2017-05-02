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
package org.eclipse.scada.configuration.ui.project.wizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewProjectPage extends WizardNewProjectCreationPage
{

    private final IStructuredSelection selection;

    public NewProjectPage ( final String pageName, final IStructuredSelection selection )
    {
        super ( pageName );
        this.selection = selection;
        setTitle ( "Project" );
        setDescription ( "Select the project properties" );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        super.createControl ( parent );

        final Composite control = (Composite)getControl ();

        createWorkingSetGroup ( control, this.selection, new String[] { "org.eclipse.ui.resourceWorkingSetPage" } ); //$NON-NLS-1$

        Dialog.applyDialogFont ( control );
    }

}
