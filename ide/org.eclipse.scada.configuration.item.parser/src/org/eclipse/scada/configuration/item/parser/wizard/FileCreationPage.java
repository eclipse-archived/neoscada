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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class FileCreationPage extends WizardNewFileCreationPage
{

    private final String requiredExtension;

    public FileCreationPage ( final String pageName, final IStructuredSelection selection, final String requiredExtension )
    {
        super ( pageName, selection );
        this.requiredExtension = requiredExtension;
    }

    @Override
    protected boolean validatePage ()
    {
        if ( super.validatePage () )
        {
            final String extension = new Path ( getFileName () ).getFileExtension ();
            if ( extension == null || !this.requiredExtension.equals ( extension ) )
            {
                setErrorMessage ( String.format ( "File must have the requiredExtension '.%s'", this.requiredExtension ) );
                return false;
            }
            return true;
        }
        return false;
    }

    public IFile getFile ()
    {
        return ResourcesPlugin.getWorkspace ().getRoot ().getFile ( getContainerFullPath ().append ( getFileName () ) );
    }
}
