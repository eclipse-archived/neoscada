/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - improve error reporting
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.wizard;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ca.connection.provider.ConnectionService;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.oscar.OscarLoader;
import org.eclipse.scada.ca.ui.importer.Activator;
import org.eclipse.scada.ca.ui.util.ConfigurationHelper;
import org.eclipse.scada.ca.utils.DiffController;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.statushandlers.StatusManager;

public class RemoteDataPage extends WizardPage
{

    private final ConnectionService service;

    private Label resultText;

    private final DiffController mergeController;

    private long count;

    public RemoteDataPage ( final ConnectionService service, final DiffController mergeController )
    {
        super ( "loadPage" ); //$NON-NLS-1$
        setTitle ( Messages.RemoteDataPage_Title );
        this.service = service;
        this.mergeController = mergeController;
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        wrapper.setLayout ( new GridLayout ( 1, false ) );

        // remote load

        final Button loadButton = new Button ( wrapper, SWT.PUSH );
        loadButton.setText ( Messages.RemoteDataPage_LoadButtonText );
        loadButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                performLoad ();
            }
        } );

        // local load

        final Button loadLocalButton = new Button ( wrapper, SWT.PUSH );
        loadLocalButton.setText ( Messages.RemoteDataPage_ButtonLocalFile );
        loadLocalButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleLoadLocal ();
            }
        } );

        // Empty set

        final Button emptyButton = new Button ( wrapper, SWT.PUSH );
        emptyButton.setText ( Messages.RemoteDataPage_ButtonEmptySet );
        emptyButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleEmpty ();
            }
        } );

        this.resultText = new Label ( wrapper, SWT.NONE );
        this.resultText.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );

        setControl ( wrapper );

        update ();
    }

    protected void handleEmpty ()
    {
        this.mergeController.setRemoteData ( Collections.<FactoryInformation> emptyList () );
        update ();
    }

    protected void handleLoadLocal ()
    {
        final FileDialog dlg = new FileDialog ( getShell (), SWT.OPEN );
        dlg.setFilterExtensions ( new String[] { "*.oscar", "*.json", "*.*" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        dlg.setFilterNames ( new String[] { Messages.LocalDataPage_OSCARFilterDescription, Messages.LocalDataPage_JSONFilterDescription, Messages.LocalDataPage_AllFilterDescription } );

        final String selectedFileName = getWizard ().getDialogSettings ().get ( "localDataPage.file" ); //$NON-NLS-1$

        if ( selectedFileName != null && selectedFileName.length () > 0 )
        {
            dlg.setFileName ( selectedFileName );
        }
        dlg.setFilterIndex ( 0 );

        final String file = dlg.open ();
        if ( file != null )
        {
            getWizard ().getDialogSettings ().put ( "localDataPage.file", file ); //$NON-NLS-1$
            loadFromLocalFile ( file );
        }
    }

    private void loadFromLocalFile ( final String file )
    {
        try
        {
            getContainer ().run ( true, false, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    final File localFile = new File ( file );
                    final Map<String, Map<String, Map<String, String>>> data;
                    try
                    {
                        monitor.beginTask ( Messages.RemoteDataPage_TaskName, IProgressMonitor.UNKNOWN );
                        if ( OscarLoader.isOscar ( localFile ) )
                        {
                            data = new OscarLoader ( localFile ).getData ();
                        }
                        else
                        {
                            data = OscarLoader.loadJsonData ( new FileInputStream ( file ) );
                        }
                    }
                    catch ( final Exception e )
                    {
                        throw new InvocationTargetException ( e );
                    }
                    finally
                    {
                        monitor.done ();
                    }
                    RemoteDataPage.this.mergeController.setRemoteData ( data );
                    RemoteDataPage.this.count = count ( data );
                }
            } );

        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.RemoteDataPage_StatusText, e ) );
        }
        update ();
    }

    protected static long count ( final Map<String, Map<String, Map<String, String>>> data )
    {
        long count = 0;
        for ( final Map.Entry<String, Map<String, Map<String, String>>> entry : data.entrySet () )
        {
            count += entry.getValue ().size ();
        }
        return count;
    }

    protected void performLoad ()
    {
        final AtomicReference<Collection<FactoryInformation>> result = new AtomicReference<Collection<FactoryInformation>> ();

        try
        {
            getContainer ().run ( true, true, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    try
                    {
                        result.set ( loadData ( monitor ) );
                    }
                    catch ( final InterruptedException e )
                    {
                        throw e;
                    }
                    catch ( final Exception e )
                    {
                        throw new InvocationTargetException ( e );
                    }
                }

            } );
            setResult ( result.get () );
        }
        catch ( final InterruptedException | InvocationTargetException e )
        {
            setError ( Messages.RemoteDataPage_FailedToLoadMessage + ExceptionHelper.getMessage ( e ) );
        }
    }

    private void setResult ( final Collection<FactoryInformation> result )
    {
        this.count = this.mergeController.setRemoteData ( result );
        update ();
    }

    private Collection<FactoryInformation> loadData ( final IProgressMonitor monitor ) throws Exception
    {
        return ConfigurationHelper.loadData ( monitor, this.service.getConnection () );
    }

    private void update ()
    {
        if ( this.service == null )
        {
            setError ( Messages.RemoteDataPage_ErrorNoService );
        }
        else if ( this.service.getConnection () == null )
        {
            setError ( Messages.RemoteDataPage_ErrorNoConnection );
        }
        else if ( this.mergeController.getRemoteData () == null )
        {
            setError ( Messages.RemoteDataPage_ErrorNoData );
        }
        else
        {
            setErrorMessage ( null );
            setDescription ( Messages.RemoteDataPage_MessageDataLoaded );
            setPageComplete ( true );
        }

        if ( this.mergeController.getRemoteData () != null )
        {
            this.resultText.setText ( String.format ( Messages.RemoteDataPage_StatusLabelFormat, this.mergeController.getRemoteData ().size (), this.count ) );
        }
        else
        {
            this.resultText.setText ( Messages.RemoteDataPage_StatusLabelNoData );
        }
    }

    private void setError ( final String string )
    {
        setPageComplete ( string == null );
        if ( string == null )
        {
            setDescription ( Messages.RemoteDataPage_DescriptionText );
        }
        else
        {
            setErrorMessage ( string );
        }
    }

}
