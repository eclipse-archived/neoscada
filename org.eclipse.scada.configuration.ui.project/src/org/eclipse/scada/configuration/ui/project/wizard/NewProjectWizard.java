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

import java.util.Arrays;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.configuration.ui.project.Activator;
import org.eclipse.scada.configuration.ui.project.create.CreateProjectOperation;
import org.eclipse.scada.configuration.ui.project.create.ProjectInformation;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;

public class NewProjectWizard extends Wizard implements INewWizard
{

    @SuppressWarnings ( "unused" )
    private IWorkbench workbench;

    private IStructuredSelection selection;

    private NewProjectPage newProjectPage;

    public NewProjectWizard ()
    {
        setWindowTitle ( "New configuration project" );
        setNeedsProgressMonitor ( true );
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.workbench = workbench;
        this.selection = selection;
    }

    @Override
    public void addPages ()
    {
        super.addPages ();
        addPage ( this.newProjectPage = new NewProjectPage ( "newProjectPage", this.selection ) );
    }

    @Override
    public boolean performFinish ()
    {
        final ProjectInformation info = new ProjectInformation ();

        if ( !this.newProjectPage.useDefaults () )
        {
            info.setProjectLocation ( this.newProjectPage.getLocationPath () );
        }

        info.setProject ( this.newProjectPage.getProjectHandle () );
        info.addNode ( "node1", Arrays.asList ( "REGION1", "SITE1" ) );
        info.addNode ( "node2", Arrays.asList ( "REGION1", "SITE2" ) );
        info.setGlobalize ( true );

        final CreateProjectOperation operation = new CreateProjectOperation ( info );

        try
        {
            getContainer ().run ( false, true, operation );
        }
        catch ( final InterruptedException e )
        {
            // nothing to do
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }

        return true;
    }
}
