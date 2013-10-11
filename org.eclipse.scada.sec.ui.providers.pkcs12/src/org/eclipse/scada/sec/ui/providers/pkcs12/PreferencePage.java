/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers.pkcs12;

import java.util.List;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.sec.ui.providers.KeyProvider;
import org.eclipse.scada.sec.ui.providers.KeyTreeViewer;
import org.eclipse.scada.sec.ui.providers.Locked;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends org.eclipse.jface.preference.PreferencePage implements IWorkbenchPreferencePage
{

    private FactoryImpl factory;

    private KeyTreeViewer viewer;

    private Button addButton;

    private Button removeButton;

    private List<KeyProvider> selectedProviders;

    private Button unlockButton;

    private List<Locked> locked;

    @Override
    public void init ( final IWorkbench workbench )
    {
    }

    @Override
    protected Control createContents ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        wrapper.setLayout ( new GridLayout ( 1, false ) );

        this.factory = new FactoryImpl ();
        this.factory.init ( SWTObservables.getRealm ( parent.getDisplay () ) );

        this.viewer = new KeyTreeViewer ( wrapper );
        this.viewer.setInput ( this.factory );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        final Composite buttons = new Composite ( wrapper, SWT.NONE );
        buttons.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        buttons.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );

        this.addButton = new Button ( buttons, SWT.PUSH );
        this.addButton.setText ( "Add…" );
        this.addButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleAdd ();
            }
        } );

        this.removeButton = new Button ( buttons, SWT.PUSH );
        this.removeButton.setText ( "Remove" );
        this.removeButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleRemove ();
            }
        } );

        this.unlockButton = new Button ( buttons, SWT.PUSH );
        this.unlockButton.setText ( "Unlock" );
        this.unlockButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                handleUnlock ();
            }
        } );

        this.viewer.getTreeViewer ().addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                setSelection ( event.getSelection () );
            }
        } );

        setSelection ( StructuredSelection.EMPTY );

        return wrapper;
    }

    protected void handleUnlock ()
    {
        try
        {
            for ( final Locked l : this.locked )
            {
                l.unlock ( new DisplayCallbackHandler ( getShell (), "Unlock", "Unlock key element" ) );
            }
        }
        catch ( final Exception e )
        {
            ErrorDialog.openError ( getShell (), "Error", null, StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    protected void setSelection ( final ISelection selection )
    {
        this.selectedProviders = SelectionHelper.list ( selection, KeyProvider.class );
        this.locked = SelectionHelper.list ( selection, Locked.class );

        this.unlockButton.setEnabled ( !this.locked.isEmpty () );
        this.removeButton.setEnabled ( !this.selectedProviders.isEmpty () );
    }

    protected void handleRemove ()
    {
        final MultiStatus ms = new MultiStatus ( Activator.PLUGIN_ID, 0, "Removing key providers", null );

        for ( final KeyProvider provider : this.selectedProviders )
        {
            try
            {
                this.factory.remove ( provider );
            }
            catch ( final Exception e )
            {
                ms.add ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
            }
        }
        if ( !ms.isOK () )
        {
            ErrorDialog.openError ( getShell (), "Error", null, ms );
        }
    }

    protected void handleAdd ()
    {
        final FileDialog dlg = new FileDialog ( getShell (), SWT.OPEN );
        final String result = dlg.open ();
        if ( result != null )
        {
            try
            {
                this.factory.addFile ( result );
            }
            catch ( final Exception e )
            {
                ErrorDialog.openError ( getShell (), "Error", "Failed to add file", StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
            }
        }
    }
}
