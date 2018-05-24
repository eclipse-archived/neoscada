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
package org.eclipse.scada.da.ui.client.test.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.common.ValueType;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WriteOperationWizardValuePage extends WizardPage implements IWizardPage
{

    private final static Logger logger = LoggerFactory.getLogger ( WriteOperationWizardValuePage.class );

    private Text itemIdText;

    private Text valueText;

    private Combo valueTypeSelect;

    private Text convertedValue;

    private Color defaultValueColor;

    private Variant value;

    private Item item;

    private ValueType preselectedType = ValueType.STRING;

    protected WriteOperationWizardValuePage ()
    {
        super ( "wizardPage" );
        setTitle ( "Write Data Item" );
        setDescription ( "Enter the information to write" );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite container = new Composite ( parent, SWT.NONE );

        final GridLayout layout = new GridLayout ();
        container.setLayout ( layout );
        layout.numColumns = 3;
        layout.verticalSpacing = 9;

        Label label = new Label ( container, SWT.NONE );
        label.setText ( "&Item:" );

        this.itemIdText = new Text ( container, SWT.BORDER | SWT.SINGLE );
        GridData gd = new GridData ( GridData.FILL_HORIZONTAL );
        this.itemIdText.setLayoutData ( gd );
        this.itemIdText.addModifyListener ( new ModifyListener () {
            @Override
            public void modifyText ( final ModifyEvent e )
            {
                dialogChanged ();
            }
        } );

        label = new Label ( container, SWT.NONE );

        // row 2
        label = new Label ( container, SWT.NONE );
        label.setText ( "&Value:" );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.BEGINNING, false, false ) );

        this.valueText = new Text ( container, SWT.BORDER | SWT.MULTI );
        if ( value != null )
        {
            this.valueText.setText ( value.asString ( "" ) );
        }
        gd = new GridData ( SWT.FILL, SWT.FILL, true, true );
        this.valueText.setLayoutData ( gd );
        this.valueText.addModifyListener ( new ModifyListener () {
            @Override
            public void modifyText ( final ModifyEvent e )
            {
                dialogChanged ();
            }
        } );

        this.valueTypeSelect = new Combo ( container, SWT.DROP_DOWN | SWT.READ_ONLY );
        for ( final ValueType vt : ValueType.values () )
        {
            this.valueTypeSelect.add ( vt.label (), vt.ordinal () );
        }
        this.valueTypeSelect.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                dialogChanged ();
            }
        } );
        this.valueTypeSelect.select ( preselectedType.ordinal () );
        this.valueTypeSelect.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.BEGINNING, false, false ) );

        // row 3

        label = new Label ( container, SWT.NONE );
        label.setText ( "Converted Value: " );

        this.convertedValue = new Text ( container, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER );
        gd = new GridData ( GridData.FILL_HORIZONTAL );
        this.convertedValue.setLayoutData ( gd );
        this.defaultValueColor = this.convertedValue.getForeground ();

        this.valueText.forceFocus ();
        this.valueText.selectAll ();
        
        setControl ( container );
        updateSelection ();
        dialogChanged ();
    }

    private void updateSelection ()
    {
        if ( this.item != null )
        {
            this.itemIdText.setText ( this.item.getId () );
        }
        else
        {
            this.itemIdText.setText ( "" );
        }
    }

    private void setValueText ( final String value, final boolean systemText )
    {
        this.convertedValue.setText ( value );

        if ( systemText )
        {
            final Color color = this.convertedValue.getDisplay ().getSystemColor ( SWT.COLOR_RED );
            this.convertedValue.setForeground ( color );
        }
        else
        {
            this.convertedValue.setForeground ( this.defaultValueColor );
        }
    }

    private void dialogChanged ()
    {
        // connection
        if ( this.item == null )
        {
            updateStatus ( "No item selection" );
            return;
        }

        // item
        if ( this.itemIdText.getText ().length () <= 0 )
        {
            updateStatus ( "Item name must not be empty" );
            return;
        }

        // value stuff
        setValueText ( "<not set>", true );
        this.value = null;

        final int idx = this.valueTypeSelect.getSelectionIndex ();
        try
        {
            for ( final ValueType vt : ValueType.values () )
            {
                if ( vt.ordinal () == idx )
                {
                    this.value = vt.convertTo ( this.valueText.getText () );
                }
            }
        }
        catch ( final NotConvertableException e )
        {
            updateStatus ( "Unable to convert value to target type: " + e.getMessage () );
            return;
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to convert", e );
        }
        if ( this.value != null )
        {
            try
            {
                setValueText ( this.value.asString (), false );
            }
            catch ( final NullValueException e )
            {
                setValueText ( "<null>", true );
            }
        }
        else
        {
            setValueText ( "no converter found for: " + idx, true );
        }

        updateStatus ( null );
    }

    private void updateStatus ( final String message )
    {
        setErrorMessage ( message );
        setPageComplete ( message == null );
    }

    public Item getItem ()
    {
        return new Item ( this.item.getConnectionString (), this.itemIdText.getText (), this.item.getType () );
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public void setSelection ( final IStructuredSelection selection )
    {
        this.item = SelectionHelper.first ( selection, Item.class );
        final DataItemValue value = SelectionHelper.first ( selection, DataItemValue.class );
        if ( value != null && !Variant.valueOf ( value.getValue () ).equals ( Variant.NULL ) )
        {
            this.preselectedType = ValueType.fromVariantType ( value.getValue ().getType () );
            this.value = value.getValue ();
        }
    }
}
