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

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class NgpExportPage extends WizardPage
{
    private DataBindingContext dbc;

    public NgpExportPage ()
    {
        super ( "ngpExportPage", "NGP Export", null );
    }

    private final Set<Control> controls = new HashSet<> ();

    private Button enable;

    private final WritableValue/*Integer*/portValue = new WritableValue ( 2199, Integer.class );

    @Override
    public void createControl ( final Composite parent )
    {
        setTitle ( "Select NGP Export parameters" );
        setDescription ( "Chose the NGP protocol parameters" );

        this.dbc = new DataBindingContext ();

        WizardPageSupport.create ( this, this.dbc );

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        setControl ( wrapper );

        wrapper.setLayout ( new GridLayout ( 1, false ) );

        this.enable = new Button ( wrapper, SWT.CHECK );
        this.enable.setText ( "Enable NGP exporter" );
        this.enable.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.BEGINNING, false, false, 2, 1 ) );
        this.enable.setSelection ( true );
        this.enable.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                updateEnablement ();
            }
        } );

        final Group group = new Group ( wrapper, SWT.SHADOW_ETCHED_IN );
        group.setText ( "TCP" );
        group.setLayout ( new GridLayout ( 2, false ) );

        Label l;

        l = new Label ( group, SWT.NONE );
        l.setText ( "TCP Port:" );

        final Spinner portSpinner = new Spinner ( group, SWT.BORDER );
        this.controls.add ( portSpinner );
        portSpinner.setIncrement ( 1 );
        portSpinner.setMinimum ( 1 );
        portSpinner.setMaximum ( Short.MAX_VALUE - 1 );
        portSpinner.setPageIncrement ( 10 );
        portSpinner.setSelection ( 2199 );
        portSpinner.setLayoutData ( withGap () );

        Binding b;

        b = this.dbc.bindValue ( SWTObservables.observeSelection ( portSpinner ), this.portValue, new UpdateValueStrategy ().setAfterConvertValidator ( new PortValidator () ), null );
        ControlDecorationSupport.create ( b, SWT.LEFT );

        Dialog.applyDialogFont ( wrapper );
    }

    protected GridData withGap ()
    {
        final GridData result = new GridData ( SWT.BEGINNING, SWT.BEGINNING, false, false );
        result.horizontalIndent = 10;
        return result;
    }

    protected void updateEnablement ()
    {
        final boolean state = this.enable.getSelection ();

        for ( final Control c : this.controls )
        {
            c.setEnabled ( state );
        }
    }

    @Override
    public void dispose ()
    {
        this.dbc.dispose ();
        super.dispose ();
    }

    public ConnectionInformation getConnectionInformation ()
    {
        if ( !this.enable.getSelection () )
        {
            return null;
        }

        final Integer port = getPort ();
        if ( port == null )
        {
            return null;
        }

        return ConnectionInformation.fromURI ( String.format ( "da:ngp://0.0.0.0:%s", port ) );
    }

    private Integer getPort ()
    {
        final Object v = this.portValue.getValue ();
        if ( v instanceof Number )
        {
            return ( (Number)v ).intValue ();
        }
        return null;
    }

}
