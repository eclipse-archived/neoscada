/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.exporter.wizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.ca.connection.provider.ConnectionService;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.oscar.OscarWriter;
import org.eclipse.scada.ca.ui.exporter.Activator;
import org.eclipse.scada.ca.ui.util.ConfigurationHelper;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportWizard extends Wizard implements IExportWizard
{

    private final static Logger logger = LoggerFactory.getLogger ( ExportWizard.class );

    private ConnectionService connection;

    private FileNamePage page;

    public ExportWizard ()
    {
        setNeedsProgressMonitor ( true );
        setWindowTitle ( Messages.ExportWizard_WindowTitle );

        IDialogSettings settings = Activator.getDefault ().getDialogSettings ().getSection ( "exportWizard" ); //$NON-NLS-1$
        if ( settings == null )
        {
            settings = Activator.getDefault ().getDialogSettings ().addNewSection ( "exportWizard" ); //$NON-NLS-1$
        }

        setDialogSettings ( Activator.getDefault ().getDialogSettings ().getSection ( "exportWizard" ) ); //$NON-NLS-1$

    }

    @Override
    public void addPages ()
    {
        super.addPages ();
        addPage ( this.page = new FileNamePage () );
    }

    @Override
    public boolean performFinish ()
    {
        try
        {
            final File file = this.page.getFile ();
            getContainer ().run ( true, true, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    try
                    {
                        handleFinish ( monitor, file );
                    }
                    catch ( final Exception e )
                    {
                        throw new InvocationTargetException ( e );
                    }
                }
            } );
            return true;
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to export data", e ); //$NON-NLS-1$
            final Status status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.ExportWizard_Status_ErrorText, e );
            StatusManager.getManager ().handle ( status, StatusManager.BLOCK );
            return false;
        }
    }

    protected void handleFinish ( final IProgressMonitor monitor, final File file ) throws Exception
    {
        // load data
        final Collection<FactoryInformation> data = ConfigurationHelper.loadData ( monitor, this.connection.getConnection () );

        // write to OSCAR
        final OscarWriter writer = new OscarWriter ( ConfigurationHelper.convert ( data ), null );
        writer.write ( file );
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
