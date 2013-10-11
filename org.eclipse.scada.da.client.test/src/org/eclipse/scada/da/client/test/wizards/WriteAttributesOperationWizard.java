/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.test.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.commands.operations.OperationStatus;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.test.Activator;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;

public class WriteAttributesOperationWizard extends Wizard implements INewWizard
{

    private WriteAttributesOperationWizardValuePage page;

    private IStructuredSelection selection;

    @Override
    public boolean performFinish ()
    {
        final Item item = this.page.getItem ();
        final Map<String, Variant> attributes = this.page.getAttributes ();

        final IRunnableWithProgress op = new IRunnableWithProgress () {
            @Override
            public void run ( final IProgressMonitor monitor ) throws InvocationTargetException
            {
                try
                {
                    doFinish ( monitor, item, attributes );
                }
                catch ( final Exception e )
                {
                    throw new InvocationTargetException ( e );
                }
                finally
                {
                    monitor.done ();
                }
            }
        };
        try
        {
            getContainer ().run ( true, true, op );
        }
        catch ( final InterruptedException e )
        {
            return false;
        }
        catch ( final InvocationTargetException e )
        {
            final Throwable realException = e.getTargetException ();
            MessageDialog.openError ( getShell (), Messages.getString ( "WriteAttributesOperationWizard.WriteError_Title" ), realException.getMessage () ); //$NON-NLS-1$
            return false;
        }
        return true;
    }

    private void doFinish ( final IProgressMonitor monitor, final Item item, final Map<String, Variant> attributes ) throws Exception
    {
        monitor.beginTask ( Messages.getString ( "WriteAttributesOperationWizard.TaskName" ), 2 ); //$NON-NLS-1$

        monitor.worked ( 1 );

        try
        {

            final DataItemHolder itemHolder = new DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), item, null );
            if ( !itemHolder.waitForConnection ( 5 * 1000 ) )
            {
                handleError ( new RuntimeException ( Messages.getString ( "WriteAttributesOperationWizard.ErrNoConnection" ) ).fillInStackTrace () ); //$NON-NLS-1$
                return;
            }

            final NotifyFuture<WriteAttributeResults> future = itemHolder.writeAtrtibutes ( attributes, null, new DisplayCallbackHandler ( getShell (), "Write Attributes", "Confirmation required to write attributes" ) );

            try
            {
                final WriteAttributeResults results = future.get ();
                if ( !results.isSuccess () )
                {
                    handleError ( attributes, results );
                }
            }
            catch ( final Throwable e )
            {
                handleError ( e );
            }

        }
        finally
        {
            monitor.done ();
        }
    }

    public void handleError ( final Throwable e )
    {
        Display.getDefault ().syncExec ( new Runnable () {

            @Override
            public void run ()
            {
                ErrorDialog.openError ( getShell (), Messages.getString ( "WriteAttributesOperationWizard.WriteError_Title" ), e.getMessage (), new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e ) ); //$NON-NLS-1$
            }
        } );

    }

    public void handleError ( final Map<String, Variant> attributes, final WriteAttributeResults results )
    {
        final MultiStatus status = new MultiStatus ( Activator.PLUGIN_ID, 0, Messages.getString ( "WriteAttributesOperationWizard.Status_Message" ), null ); //$NON-NLS-1$

        if ( attributes.size () != results.size () )
        {
            status.add ( new OperationStatus ( IStatus.WARNING, Activator.PLUGIN_ID, 0, String.format ( Messages.getString ( "WriteAttributesOperationWizard.SummaryText" ), results.size (), attributes.size () ), null ) ); //$NON-NLS-1$
        }

        for ( final Map.Entry<String, WriteAttributeResult> entry : results.entrySet () )
        {
            if ( entry.getValue ().isError () )
            {
                status.add ( new OperationStatus ( IStatus.ERROR, Activator.PLUGIN_ID, 0, String.format ( Messages.getString ( "WriteAttributesOperationWizard.EntryMessage" ), entry.getKey (), entry.getValue ().getError ().getMessage () ), null ) ); //$NON-NLS-1$
            }
        }

        for ( final String name : attributes.keySet () )
        {
            if ( !results.containsKey ( name ) )
            {
                status.add ( new OperationStatus ( IStatus.WARNING, Activator.PLUGIN_ID, 0, String.format ( Messages.getString ( "WriteAttributesOperationWizard.Message_MissingAttribute" ), name ), null ) ); //$NON-NLS-1$
            }
        }

        final ErrorDialog dialog = new ErrorDialog ( getShell (), Messages.getString ( "WriteAttributesOperationWizard.WriteError_Title" ), Messages.getString ( "WriteAttributesOperationWizard.ErrorDialog_Description" ), status, IStatus.ERROR | IStatus.WARNING ); //$NON-NLS-1$ //$NON-NLS-2$

        Display.getDefault ().syncExec ( new Runnable () {

            @Override
            public void run ()
            {
                dialog.open ();
            }
        } );
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        setNeedsProgressMonitor ( true );
        setWindowTitle ( Messages.getString ( "WriteAttributesOperationWizard.Title" ) ); //$NON-NLS-1$

        this.selection = selection;
    }

    @Override
    public void addPages ()
    {
        super.addPages ();

        addPage ( this.page = new WriteAttributesOperationWizardValuePage () );

        this.page.setSelection ( this.selection );
    }

}
