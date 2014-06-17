/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.ca.connection.provider.ConnectionService;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.ui.importer.Activator;
import org.eclipse.scada.ca.ui.importer.preferences.PreferenceConstants;
import org.eclipse.scada.ca.ui.util.DiffController;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;

public class ImportWizard extends Wizard implements IImportWizard
{

    private final static Logger logger = LoggerFactory.getLogger ( ImportWizard.class );

    private ConnectionService connection;

    private final DiffController mergeController;

    public ImportWizard ()
    {
        setNeedsProgressMonitor ( true );
        setWindowTitle ( Messages.ImportWizard_Title );

        IDialogSettings settings = Activator.getDefault ().getDialogSettings ().getSection ( "importWizard" ); //$NON-NLS-1$
        if ( settings == null )
        {
            settings = Activator.getDefault ().getDialogSettings ().addNewSection ( "importWizard" ); //$NON-NLS-1$
        }

        setDialogSettings ( Activator.getDefault ().getDialogSettings ().getSection ( "importWizard" ) ); //$NON-NLS-1$

        this.mergeController = new DiffController ();
    }

    @Override
    public boolean performFinish ()
    {
        try
        {
            getContainer ().run ( true, false, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    try
                    {
                        applyDiff ( monitor );
                    }
                    catch ( final ExecutionException e )
                    {
                        throw new InvocationTargetException ( e );
                    }
                }
            } );

            return true;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to import", e );
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, Messages.ImportWizard_StatusErrorFailedToApply, e ), StatusManager.BLOCK );
            return false;
        }
    }

    protected void applyDiff ( final IProgressMonitor parentMonitor ) throws InterruptedException, ExecutionException
    {
        final SubMonitor monitor = SubMonitor.convert ( parentMonitor, 100 );
        monitor.setTaskName ( Messages.ImportWizard_TaskName );

        final Collection<DiffEntry> result = this.mergeController.merge ( monitor.newChild ( 10 ) );
        if ( result.isEmpty () )
        {
            monitor.done ();
            return;
        }

        final Iterable<List<DiffEntry>> splitted = Iterables.partition ( result, Activator.getDefault ().getPreferenceStore ().getInt ( PreferenceConstants.P_DEFAULT_CHUNK_SIZE ) );

        final SubMonitor sub = monitor.newChild ( 90 );

        try
        {
            final int size = Iterables.size ( splitted );
            sub.beginTask ( Messages.ImportWizard_TaskName, size );

            int pos = 0;
            for ( final Iterable<DiffEntry> i : splitted )
            {
                sub.subTask ( String.format ( Messages.ImportWizard_SubTaskName, pos, size ) );
                final List<DiffEntry> entries = new LinkedList<DiffEntry> ();
                Iterables.addAll ( entries, i );
                final NotifyFuture<Void> future = this.connection.getConnection ().applyDiff ( entries, null, new DisplayCallbackHandler ( getShell (), "Apply diff", "Confirmation for applying diff is required" ) );
                future.get ();

                pos++;
                sub.worked ( 1 );
            }
        }
        finally
        {
            sub.done ();
        }

    }

    @Override
    public void addPages ()
    {
        addPage ( new LocalDataPage ( this.connection, this.mergeController ) );
        addPage ( new RemoteDataPage ( this.connection, this.mergeController ) );
        addPage ( new IgnorePage ( this.mergeController ) );
        addPage ( new PreviewPage ( this.mergeController ) );
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.connection = getConnection ( selection );
    }

    private ConnectionService getConnection ( final IStructuredSelection selection )
    {
        if ( selection == null )
        {
            return null;
        }

        final Object o = AdapterHelper.adapt ( selection.getFirstElement (), org.eclipse.scada.core.connection.provider.ConnectionService.class );
        if ( o instanceof ConnectionService )
        {
            return (ConnectionService)o;
        }
        else
        {
            return null;
        }
    }

}
