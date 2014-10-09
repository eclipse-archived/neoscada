/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.vi.preview.editor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.statushandlers.StatusManager;

public class PreviewHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final MultiStatus ms = new MultiStatus ( Activator.PLUGIN_ID, 0, "Opening preview", null );

        for ( final IFile file : SelectionHelper.iterable ( getSelection (), IFile.class ) )
        {
            final IEditorInput input = new FileEditorInput ( file );
            try
            {
                getActivePage ().openEditor ( input, PreviewEditorImpl.EDITOR_ID, true, IWorkbenchPage.MATCH_ID );
            }
            catch ( final PartInitException e )
            {
                ms.add ( e.getStatus () );
            }
        }

        if ( !ms.isOK () )
        {
            final IStatus[] childs = ms.getChildren ();
            if ( childs.length < 2 )
            {
                StatusManager.getManager ().handle ( childs[0], StatusManager.SHOW );
            }
            else
            {
                StatusManager.getManager ().handle ( ms, StatusManager.SHOW );
            }
        }

        return null;
    }

}
