/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;

public class AddConnectionWizardPage1 extends WizardPage
{

    private Text uriText;

    private ConnectionDescriptor connectionInformation;

    private Text idText;

    protected AddConnectionWizardPage1 ( final ConnectionDescriptor preset )
    {
        super ( Messages.AddConnectionWizardPage1_PageTitle );
        setTitle ( Messages.AddConnectionWizardPage1_PageTitle );
        setDescription ( Messages.AddConnectionWizardPage1_PageDescription );
        this.connectionInformation = preset;
    }

    public ConnectionDescriptor getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite comp = new Composite ( parent, SWT.NONE );
        comp.setLayout ( new GridLayout ( 2, false ) );

        Label label;

        // URI

        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.AddConnectionWizardPage1_ConnectionUriLabel );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.CENTER, false, false ) );

        this.uriText = new Text ( comp, SWT.BORDER );
        this.uriText.setMessage ( Messages.AddConnectionWizardPage1_ConnectionUriMessage );
        this.uriText.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
        this.uriText.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        // ID

        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.AddConnectionWizardPage1_ConnectionIdLabel );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.CENTER, false, false ) );

        this.idText = new Text ( comp, SWT.BORDER );
        this.idText.setMessage ( Messages.AddConnectionWizardPage1_ConnectionIdMessage );
        this.idText.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
        this.idText.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        if ( this.connectionInformation != null && this.connectionInformation.getConnectionInformation () != null )
        {
            this.uriText.setText ( this.connectionInformation.getConnectionInformation ().toMaskedString () );
            if ( this.connectionInformation.getServiceId () != null )
            {
                this.idText.setText ( this.connectionInformation.getServiceId () );
            }
        }
        else
        {
            this.uriText.setText ( "da:ngp://localhost:2101" ); //$NON-NLS-1$
        }

        setControl ( comp );
        update ();
    }

    public void update ()
    {
        String errorMessage = null;

        try
        {
            String id = this.idText.getText ();
            if ( "".equals ( id ) ) //$NON-NLS-1$
            {
                id = null;
            }

            this.connectionInformation = new ConnectionDescriptor ( ConnectionInformation.fromURI ( this.uriText.getText () ), id, null );
        }
        catch ( final Throwable e )
        {
            errorMessage = e.getLocalizedMessage ();
        }
        setState ( errorMessage );
    }

    private void setState ( final String errorMessage )
    {
        if ( errorMessage == null )
        {
            setPageComplete ( true );
            setMessage ( Messages.AddConnectionWizardPage1_InformationMessage, INFORMATION );
        }
        else
        {
            setPageComplete ( false );
            setMessage ( errorMessage, ERROR );
        }
    }

}
