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
package org.eclipse.scada.configuration.item.parser.wizard;

import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.configuration.item.parser.Activator;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

public abstract class AbstractNewFileWizard extends Wizard implements INewWizard
{

    private IWorkbench workbench;

    private IStructuredSelection selection;

    private FileCreationPage newFileCreationPage;

    private final String base;

    private final String extension;

    public AbstractNewFileWizard ( final String base, final String extension )
    {
        this.base = base;
        this.extension = extension;

    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.workbench = workbench;
        this.selection = selection;
    }

    @Override
    public boolean performFinish ()
    {
        try
        {
            // Remember the file.
            //
            final IFile file = getFile ();

            // Do the work within an operation.
            //
            final WorkspaceModifyOperation operation = new WorkspaceModifyOperation () {
                @Override
                protected void execute ( final IProgressMonitor progressMonitor )
                {
                    try
                    {
                        try (InputStream source = createInputSource ())
                        {
                            file.create ( source, IResource.KEEP_HISTORY, progressMonitor );
                        }
                    }
                    catch ( final Exception exception )
                    {
                        Activator.getDefault ().log ( exception );
                    }
                    finally
                    {
                        progressMonitor.done ();
                    }
                }
            };

            getContainer ().run ( false, false, operation );

            // Select the new file resource in the current view.
            //
            final IWorkbenchWindow workbenchWindow = this.workbench.getActiveWorkbenchWindow ();
            final IWorkbenchPage page = workbenchWindow.getActivePage ();
            final IWorkbenchPart activePart = page.getActivePart ();
            if ( activePart instanceof ISetSelectionTarget )
            {
                final ISelection targetSelection = new StructuredSelection ( file );
                getShell ().getDisplay ().asyncExec ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        ( (ISetSelectionTarget)activePart ).selectReveal ( targetSelection );
                    }
                } );
            }

            // Open an editor on the new file.
            //
            try
            {
                page.openEditor ( new FileEditorInput ( file ), this.workbench.getEditorRegistry ().getDefaultEditor ( file.getFullPath ().toString () ).getId () );
            }
            catch ( final PartInitException exception )
            {
                MessageDialog.openError ( workbenchWindow.getShell (), "Error", ExceptionHelper.getMessage ( exception ) ); //$NON-NLS-1$
                return false;
            }

            return true;
        }
        catch ( final Exception exception )
        {
            Activator.getDefault ().log ( exception );
            return false;
        }
    }

    @Override
    public void addPages ()
    {
        this.newFileCreationPage = new FileCreationPage ( "file", this.selection, this.extension ); //$NON-NLS-1$ 
        this.newFileCreationPage.setTitle ( "Select File" );
        this.newFileCreationPage.setDescription ( "Select where to store the file" );
        this.newFileCreationPage.setFileName ( this.base + "." + this.extension );
        addPage ( this.newFileCreationPage );

        tryCreateName ();
    }

    public void tryCreateName ()
    {
        // Try and get the resource selection to determine a current directory for the file dialog.
        //
        if ( this.selection != null && !this.selection.isEmpty () )
        {
            // Get the resource...
            //
            final Object selectedElement = this.selection.iterator ().next ();
            if ( selectedElement instanceof IResource )
            {
                // Get the resource parent, if its a file.
                //
                IResource selectedResource = (IResource)selectedElement;
                if ( selectedResource.getType () == IResource.FILE )
                {
                    selectedResource = selectedResource.getParent ();
                }

                // This gives us a directory...
                //
                if ( selectedResource instanceof IFolder || selectedResource instanceof IProject )
                {
                    // Set this for the container.
                    //
                    this.newFileCreationPage.setContainerFullPath ( selectedResource.getFullPath () );

                    // Make up a unique new name here.
                    //
                    String modelFilename = this.base + "." + this.extension; //$NON-NLS-1$
                    for ( int i = 1; ( (IContainer)selectedResource ).findMember ( modelFilename ) != null; ++i )
                    {
                        modelFilename = this.base + i + "." + this.extension; //$NON-NLS-1$
                    }
                    this.newFileCreationPage.setFileName ( modelFilename );
                }
            }
        }
    }

    public IFile getFile ()
    {
        return this.newFileCreationPage.getFile ();
    }

    protected abstract InputStream createInputSource () throws Exception;

}
