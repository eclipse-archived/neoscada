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
package org.eclipse.scada.configuration.recipe.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.lib.Builder;
import org.eclipse.scada.configuration.recipe.lib.Recipe;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;

public class RunRecipeHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final IStructuredSelection sel = getSelection ();
        final WorkspaceJob job = new WorkspaceJob ( "Run recipes" ) {

            @Override
            public IStatus runInWorkspace ( final IProgressMonitor monitor ) throws CoreException
            {
                return processFiles ( sel, monitor );
            }
        };
        job.setUser ( true );
        job.setSystem ( false );
        job.schedule ();

        return null;
    }

    private final int MONITOR_FILE_AMOUNT = 100_000;

    private IStatus processFiles ( final IStructuredSelection selection, final IProgressMonitor monitor )
    {
        final List<IFile> files = SelectionHelper.list ( selection, IFile.class );

        final MultiStatus ms = new MultiStatus ( Activator.PLUGIN_ID, 0, null, null );

        monitor.beginTask ( "Running recipes...", files.size () * this.MONITOR_FILE_AMOUNT );

        try
        {
            for ( final IFile file : files )
            {
                try
                {
                    monitor.setTaskName ( String.format ( "Recipe: %s", file.getName () ) );
                    processFile ( file, monitor );
                    ms.add ( new Status ( IStatus.OK, Activator.PLUGIN_ID, String.format ( "Run recipe: %s", file.getName () ) ) );
                    // don't need to "work" on the monitor, since we have a sub monitor
                }
                catch ( final CoreException e )
                {
                    ms.add ( e.getStatus () );
                }
                catch ( final Exception e )
                {
                    ms.add ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
                }
            }
        }
        finally
        {
            monitor.done ();
        }

        if ( ms.getChildren ().length == 1 )
        {
            return ms.getChildren ()[0];
        }
        else
        {
            return ms;
        }
    }

    private void processFile ( final IFile file, final IProgressMonitor monitor ) throws Exception
    {
        final IFolder output = file.getParent ().getFolder ( new Path ( "output" ) );
        if ( output.exists () )
        {
            output.delete ( true, monitor );
        }
        output.create ( true, true, monitor );

        final ModelLoader<Definition> loader = new ModelLoader<Definition> ( Definition.class );

        final Definition def = loader.load ( URI.createURI ( file.getLocationURI ().toString () ) );

        final Builder builder = new Builder ( def );
        final Recipe recipe = builder.build ();

        final SubProgressMonitor pm = new SubProgressMonitor ( monitor, this.MONITOR_FILE_AMOUNT );

        try
        {
            final Map<String, Object> initialContent = new HashMap<String, Object> ();
            initialContent.put ( "progressMonitor", pm ); //$NON-NLS-1$
            initialContent.put ( "output", output );

            recipe.execute ( initialContent, monitor );
        }
        finally
        {
            pm.done ();
        }

    }
}
