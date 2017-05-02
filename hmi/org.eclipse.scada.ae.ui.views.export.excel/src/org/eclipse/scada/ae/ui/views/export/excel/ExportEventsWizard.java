/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.export.excel;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.ae.ui.views.export.excel.impl.ExportEventsImpl;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;

public class ExportEventsWizard extends Wizard implements IExportWizard
{

    private final ExportEventsImpl exporter;

    public ExportEventsWizard ()
    {
        setNeedsProgressMonitor ( true );
        setWindowTitle ( Messages.ExportWizard_WindowTitle );
        this.exporter = new ExportEventsImpl ();
    }

    @Override
    public boolean performFinish ()
    {
        try
        {
            getContainer ().run ( true, true, new IRunnableWithProgress () {

                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    doExport ( monitor );
                }
            } );
            return true;
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.ExportWizard_ErrorMessage, e ) );
            return false;
        }
    }

    protected IStatus doExport ( final IProgressMonitor monitor )
    {
        try
        {
            return this.exporter.write ( monitor );
        }
        catch ( final Exception e )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.ExportWizard_ErrorMessage, e );
        }
    }

    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.exporter.setSelection ( selection );

        addPage ( new FileSelectionPage ( this.exporter ) );
    }
}
