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
package org.eclipse.scada.da.ui.client.test.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.ui.client.test.Activator;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteOperationWizard extends Wizard implements INewWizard
{

    private final static Logger logger = LoggerFactory.getLogger ( WriteOperationWizard.class );

    private WriteOperationWizardValuePage page = null;

    private IStructuredSelection selection = null;

    public WriteOperationWizard ()
    {
        setWindowTitle ( "Write to data item" );
        setNeedsProgressMonitor ( true );
    }

    @Override
    public boolean performFinish ()
    {
        final Item item = this.page.getItem ();
        final Variant value = this.page.getValue ();

        final IRunnableWithProgress op = new IRunnableWithProgress () {
            @Override
            public void run ( final IProgressMonitor monitor ) throws InvocationTargetException
            {
                try
                {
                    doFinish ( monitor, item, value );
                }
                catch ( final Throwable e )
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
            logger.warn ( "Failed to perform write operation", e );
            final Throwable realException = e.getTargetException ();
            MessageDialog.openError ( getShell (), "Error writing to item", realException.getMessage () );
            return false;
        }
        return true;
    }

    private void doFinish ( final IProgressMonitor monitor, final Item item, final Variant value ) throws Exception
    {
        monitor.beginTask ( "Writing value to item", 2 );

        monitor.worked ( 1 );

        try
        {

            final DataItemHolder itemHolder = new DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), item, null );
            if ( !itemHolder.waitForConnection ( 5 * 1000 ) )
            {
                handleError ( new RuntimeException ( "No available connection" ).fillInStackTrace () );
                return;
            }

            final NotifyFuture<WriteResult> future = itemHolder.startWrite ( value, null, new DisplayCallbackHandler ( getShell (), "Write operation", "Write operation" ) );

            try
            {
                future.get ();
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
        logger.warn ( "Failed to write", e );
        Display.getDefault ().syncExec ( new Runnable () {

            @Override
            public void run ()
            {
                ErrorDialog.openError ( getShell (), "Failed to write", "Failed to write to the data item", new Status ( IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage (), e ) );
            }
        } );

    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        setNeedsProgressMonitor ( true );

        this.selection = selection;
    }

    @Override
    public void addPages ()
    {
        super.addPages ();

        addPage ( this.page = new WriteOperationWizardValuePage () );

        this.page.setSelection ( this.selection );
    }

}
