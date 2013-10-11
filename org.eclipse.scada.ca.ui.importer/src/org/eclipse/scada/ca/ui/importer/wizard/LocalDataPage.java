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
package org.eclipse.scada.ca.ui.importer.wizard;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ca.oscar.OscarLoader;
import org.eclipse.scada.ca.ui.importer.Activator;
import org.eclipse.scada.ca.ui.util.DiffController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.scada.ca.connection.provider.ConnectionService;

public class LocalDataPage extends WizardPage
{
    private Text fileName;

    private final DiffController mergeController;

    private Label dataLabel;

    private final ConnectionService service;

    protected LocalDataPage ( final ConnectionService service, final DiffController mergeController )
    {
        super ( "welcomePage" ); //$NON-NLS-1$
        this.service = service;
        setTitle ( Messages.LocalDataPage_Title );

        this.mergeController = mergeController;
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 4, false ) );

        final Label label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.LocalDataPage_FileLabel );

        this.fileName = new Text ( wrapper, SWT.BORDER );
        final String file = loadFileFromPreferences ();
        if ( file != null )
        {
            this.fileName.setText ( file );
        }
        this.fileName.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
        this.fileName.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        final Button selectButton = new Button ( wrapper, SWT.PUSH );
        selectButton.setText ( Messages.LocalDataPage_BrowseButtonText );
        selectButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                selectFile ();
            }
        } );

        final Button loadButton = new Button ( wrapper, SWT.PUSH );
        loadButton.setText ( Messages.LocalDataPage_LoadButtonText );
        loadButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                loadFile ();
            };
        } );

        setControl ( wrapper );

        this.dataLabel = new Label ( wrapper, SWT.NONE );
        this.dataLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false, 4, 1 ) );

        update ();
    }

    protected void selectFile ()
    {
        final FileDialog dlg = new FileDialog ( getShell (), SWT.OPEN );
        dlg.setFilterExtensions ( new String[] { "*.oscar", "*.json", "*.*" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        dlg.setFilterNames ( new String[] { Messages.LocalDataPage_OSCARFilterDescription, Messages.LocalDataPage_JSONFilterDescription, Messages.LocalDataPage_AllFilterDescription } );

        if ( this.fileName.getText ().length () > 0 )
        {
            dlg.setFileName ( this.fileName.getText () );
        }
        dlg.setFilterIndex ( 0 );

        final String file = dlg.open ();
        if ( file != null )
        {
            this.fileName.setText ( file );
            storeFileToPreferences ( file );
            loadFile ();
        }
    }

    private String loadFileFromPreferences ()
    {
        return getWizard ().getDialogSettings ().get ( makeKey () );
    }

    private String makeKey ()
    {
        try
        {
            return "welcomePage.file." + this.service.getConnection ().getConnectionInformation ().toMaskedString (); //$NON-NLS-1$
        }
        catch ( final Exception e )
        {
            return "welcomePage.file"; //$NON-NLS-1$
        }
    }

    private void storeFileToPreferences ( final String file )
    {
        getWizard ().getDialogSettings ().put ( makeKey (), file );
    }

    protected void update ()
    {
        try
        {
            validate ();
            setMessage ( null, IMessageProvider.NONE );
            setPageComplete ( this.mergeController.getLocalData () != null );
        }
        catch ( final Exception e )
        {
            setMessage ( e.getLocalizedMessage (), IMessageProvider.ERROR );
            setPageComplete ( false );
        }

        final Map<String, Map<String, Map<String, String>>> localData = this.mergeController.getLocalData ();
        if ( localData != null )
        {
            this.dataLabel.setText ( String.format ( Messages.LocalDataPage_StatusLabelFormat, localData.size () ) );
        }
        else
        {
            this.dataLabel.setText ( Messages.LocalDataPage_EmptyStatusLabelText );
        }
    }

    protected File getFile ()
    {
        return new File ( this.fileName.getText () );
    }

    private void validate () throws Exception
    {
        final String fileName = this.fileName.getText ();

        if ( fileName.length () == 0 )
        {
            throw new IllegalStateException ( Messages.LocalDataPage_ErrorMissingFile );
        }

        final File file = new File ( fileName );

        if ( !file.exists () )
        {
            throw new IllegalArgumentException ( String.format ( Messages.LocalDataPage_ErrorNonExistingFile, fileName ) );
        }
        if ( !file.isFile () )
        {
            throw new IllegalArgumentException ( String.format ( Messages.LocalDataPage_ErrorNormalFile, fileName ) );
        }
        if ( !file.canRead () )
        {
            throw new IllegalArgumentException ( String.format ( Messages.LocalDataPage_ErrorCannotReadFile, fileName ) );
        }

        if ( this.mergeController.getLocalData () == null )
        {
            throw new IllegalStateException ( Messages.LocalDataPage_ErrorNoData );
        }
    }

    protected void loadFile ()
    {
        try
        {
            this.mergeController.setLocalData ( null );

            final File file = getFile ();
            getContainer ().run ( true, false, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    try
                    {
                        monitor.beginTask ( Messages.LocalDataPage_TaskName, IProgressMonitor.UNKNOWN );
                        loadData ( file );
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
            } );

        }
        catch ( final Exception e )
        {
            final Status status = new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.LocalDataPage_StatusErrorFailedToLoad, e );
            StatusManager.getManager ().handle ( status, StatusManager.BLOCK );
        }
        update ();
    }

    protected void loadData ( final File file ) throws Exception
    {
        if ( OscarLoader.isOscar ( file ) )
        {
            final OscarLoader loader = new OscarLoader ( file );
            this.mergeController.setLocalData ( loader.getData () );
            this.mergeController.setIgnoreFields ( loader.getIgnoreFields () );
        }
        else
        {
            final InputStream stream = new FileInputStream ( file );
            try
            {
                this.mergeController.setLocalData ( OscarLoader.loadJsonData ( stream ) );
            }
            finally
            {
                stream.close ();
            }
        }
    }

}
