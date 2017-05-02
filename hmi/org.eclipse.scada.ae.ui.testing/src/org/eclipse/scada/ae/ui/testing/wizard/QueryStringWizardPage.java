/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.wizard;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class QueryStringWizardPage extends WizardPage
{

    private Text filterEntry;

    private Text filterTypeEntry;

    public QueryStringWizardPage ()
    {
        super ( "Query String Entry Page" );
        setTitle ( "Query String Entry Page" );
        setDescription ( "Enter a query type and expression" );
    }

    public void createControl ( final Composite parent )
    {
        final Composite group = new Composite ( parent, SWT.NONE );
        group.setLayout ( new GridLayout ( 2, false ) );

        Label label;

        label = new Label ( group, SWT.NONE );
        label.setText ( "Filter Type:" );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.CENTER, false, false ) );

        this.filterTypeEntry = new Text ( group, SWT.SINGLE | SWT.BORDER );
        this.filterTypeEntry.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );
        this.filterTypeEntry.setText ( "ldap" );
        this.filterTypeEntry.addModifyListener ( new ModifyListener () {

            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        label = new Label ( group, SWT.NONE );
        label.setText ( "Filter String:" );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.CENTER, false, false ) );

        this.filterEntry = new Text ( group, SWT.MULTI | SWT.BORDER );
        this.filterEntry.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.filterEntry.addModifyListener ( new ModifyListener () {

            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );

        setControl ( group );
        update ();
    }

    private void update ()
    {
        final String filterType = this.filterTypeEntry.getText ();
        final String filterData = this.filterEntry.getText ();

        boolean warning = false;

        if ( "".equals ( filterType ) )
        {
            setPageComplete ( false );
            setMessage ( "Select a filter type", DialogPage.ERROR );
            return;
        }
        if ( "".equals ( filterData ) )
        {
            setMessage ( "Empty filter string might be a problem", DialogPage.WARNING );
            warning = true;
        }

        if ( !warning )
        {
            setMessage ( null );
        }
        setPageComplete ( true );
    }

    public String getFilterType ()
    {
        return this.filterTypeEntry.getText ();
    }

    public String getFilterData ()
    {
        return this.filterEntry.getText ();
    }

}
