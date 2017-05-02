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
package org.eclipse.scada.ide.server.test;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.server.exporter.Export;
import org.eclipse.scada.da.server.exporter.NgpExport;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.util.ServerDescriptorImpl;
import org.eclipse.scada.ide.server.test.hive.TestHive;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewTestWizard extends Wizard implements INewWizard
{

    private final static Logger logger = LoggerFactory.getLogger ( NewTestWizard.class );

    private NgpExportPage ngpPage;

    public NewTestWizard ()
    {
        setWindowTitle ( "Create new test server instance" );
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
    }

    @Override
    public boolean performFinish ()
    {
        try
        {
            handleFinish ();
            return true;
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to start server", e );
            ErrorDialog.openError ( getShell (), null, null, StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
            return false;
        }
    }

    protected void handleFinish () throws Exception
    {
        final Set<Export> exporters = new HashSet<> ();

        final TestHive hive = new TestHive ();

        final NgpExport ngpExport = createNgpExport ( hive );
        if ( ngpExport != null )
        {
            exporters.add ( ngpExport );
        }

        final ServerDescriptorImpl desc = new TestServerDescriptorImpl ( SWTObservables.getRealm ( Display.getDefault () ), hive, exporters, "Foo Bar" );
        HivesPlugin.registerServer ( desc );
    }

    private NgpExport createNgpExport ( final Hive hive ) throws Exception
    {
        final ConnectionInformation ci = this.ngpPage.getConnectionInformation ();
        if ( ci == null )
        {
            return null;
        }
        else
        {
            return new NgpExport ( hive, ci );
        }
    }

    @Override
    public void addPages ()
    {
        addPage ( this.ngpPage = new NgpExportPage () );
    }

}
