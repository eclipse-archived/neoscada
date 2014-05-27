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
package org.eclipse.scada.configuration.generator.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;

public abstract class AbstractFileRunner extends AbstractSelectionHandler
{

    public AbstractFileRunner ()
    {
        super ();
    }

    protected abstract void runFile ( final IFile file, final IProgressMonitor monitor ) throws Exception;

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final List<IFile> files = SelectionHelper.list ( getSelection (), IFile.class );

        final ProgressMonitorDialog dlg = new ProgressMonitorDialog ( getShell () );

        dlg.open ();

        try
        {
            ModalContext.run ( new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {

                    try
                    {
                        monitor.beginTask ( "Running generator", files.size () );
                        for ( final IFile file : files )
                        {
                            final SubProgressMonitor sub = new SubProgressMonitor ( monitor, 1 );
                            try
                            {
                                runFile ( file, sub );
                            }
                            catch ( final Exception e )
                            {
                                throw new InvocationTargetException ( e );
                            }
                            finally
                            {
                                sub.done ();
                            }
                        }
                    }
                    finally
                    {
                        monitor.done ();
                    }
                }

            }, true, dlg.getProgressMonitor (), getShell ().getDisplay () );
        }
        catch ( final Exception e )
        {
            e.printStackTrace ();
            ErrorDialog.openError ( getShell (), null, null, StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
        finally
        {
            dlg.close ();
        }

        return null;
    }
}