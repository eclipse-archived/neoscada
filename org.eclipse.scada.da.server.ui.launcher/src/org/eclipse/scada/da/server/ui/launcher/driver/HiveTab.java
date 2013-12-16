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
package org.eclipse.scada.da.server.ui.launcher.driver;

import java.io.File;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.da.server.ui.launcher.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class HiveTab extends AbstractLaunchConfigurationTab
{
    private final String WORKSPACE_SELECTION_DIALOG = Activator.PLUGIN_ID + ".WORKSPACE_SELECTION_DIALOG"; //$NON-NLS-1$

    private final String VARIABLE_SELECTION_DIALOG = Activator.PLUGIN_ID + ".VARIABLE_SELECTION_DIALOG"; //$NON-NLS-1$

    private Text fileText;

    @Override
    public void createControl ( final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 2, false ) );
        setControl ( wrapper );

        Label label = null;
        label = new Label ( wrapper, SWT.NONE );
        label.setText ( "Exporter Configuration:" );

        this.fileText = new Text ( wrapper, SWT.SINGLE | SWT.BORDER );
        this.fileText.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );

        final Composite buttons = new Composite ( wrapper, SWT.NONE );
        final GridData gd = new GridData ( SWT.END, SWT.BEGINNING, true, false );
        gd.horizontalSpan = 2;
        buttons.setLayoutData ( gd );
        final FillLayout fill = new FillLayout ();
        fill.spacing = 3;
        buttons.setLayout ( fill );

        final Button fileButton = new Button ( buttons, SWT.PUSH );
        fileButton.setText ( "File…" );
        fileButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                chooseFile ();
            }
        } );

        final Button workspaceButton = new Button ( buttons, SWT.PUSH );
        workspaceButton.setText ( "Workspace…" );
        workspaceButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                chooseWorkspace ();
            }
        } );

        final Button variableButton = new Button ( buttons, SWT.PUSH );
        variableButton.setText ( "Variable…" );
        variableButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                chooseVariable ();
            }
        } );
    }

    protected void chooseVariable ()
    {
        final StringVariableSelectionDialog dlg = new StringVariableSelectionDialog ( getShell () );
        dlg.setDialogBoundsSettings ( getDialogBoundsSettings ( this.VARIABLE_SELECTION_DIALOG ), Dialog.DIALOG_PERSISTSIZE );
        if ( dlg.open () == Window.OK )
        {
            this.fileText.insert ( dlg.getVariableExpression () );
            makeDirty ();
        }
    }

    protected void chooseFile ()
    {
        final FileDialog dlg = new FileDialog ( getShell (), SWT.OPEN | SWT.MULTI );
        dlg.setFilterExtensions ( new String[] { "*.xml", "*.*" } );
        dlg.setFilterNames ( new String[] { "Eclipse SCADA Exporter Files", "All files" } );
        final String result = dlg.open ();
        if ( result != null )
        {
            final File base = new File ( dlg.getFilterPath () );

            for ( final String name : dlg.getFileNames () )
            {
                this.fileText.setText ( new File ( base, name ).getAbsolutePath () );
            }
            makeDirty ();
        }
    }

    private IDialogSettings getDialogBoundsSettings ( final String id )
    {
        final IDialogSettings settings = Activator.getDefault ().getDialogSettings ();
        IDialogSettings section = settings.getSection ( id );
        if ( section == null )
        {
            section = settings.addNewSection ( id );
        }
        return section;
    }

    protected void chooseWorkspace ()
    {
        final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog ( getShell (), new WorkbenchLabelProvider (), new WorkbenchContentProvider () );
        dialog.setTitle ( "Select driver exporter configuration file" );
        dialog.setMessage ( "Choose a driver exporter file for the configuration" );
        dialog.setInput ( ResourcesPlugin.getWorkspace ().getRoot () );
        dialog.setComparator ( new ResourceComparator ( ResourceComparator.NAME ) );
        dialog.setAllowMultiple ( true );
        dialog.setDialogBoundsSettings ( getDialogBoundsSettings ( this.WORKSPACE_SELECTION_DIALOG ), Dialog.DIALOG_PERSISTSIZE );
        if ( dialog.open () == IDialogConstants.OK_ID )
        {
            final IResource resource = (IResource)dialog.getFirstResult ();
            if ( resource != null )
            {
                final String arg = resource.getFullPath ().toString ();
                final String fileLoc = VariablesPlugin.getDefault ().getStringVariableManager ().generateVariableExpression ( "workspace_loc", arg ); //$NON-NLS-1$
                this.fileText.setText ( fileLoc );
                makeDirty ();
            }
        }
    }

    protected void makeDirty ()
    {
        setDirty ( true );
        updateLaunchConfigurationDialog ();
    }

    @Override
    public void setDefaults ( final ILaunchConfigurationWorkingCopy configuration )
    {
        configuration.setAttribute ( ConfiguratorLauncherConstants.EXPORTER_FILE, "" );
    }

    @Override
    public void initializeFrom ( final ILaunchConfiguration configuration )
    {
        try
        {
            this.fileText.setText ( configuration.getAttribute ( ConfiguratorLauncherConstants.EXPORTER_FILE, "" ) );
        }
        catch ( final CoreException e )
        {
            setErrorMessage ( e.getLocalizedMessage () );
        }

        setDirty ( false );
        updateLaunchConfigurationDialog ();
    }

    @Override
    public void performApply ( final ILaunchConfigurationWorkingCopy configuration )
    {
        configuration.setAttribute ( ConfiguratorLauncherConstants.EXPORTER_FILE, this.fileText.getText () );
    }

    @Override
    public String getName ()
    {
        return "Hive Configuration";
    }

}
