/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.dialog.WriteConfirmDialog;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueSetComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ValueSetComposite.class );

    private final Composite label;

    private final Text data;

    private final Button setButton;

    private final Button resetButton;

    private final DataItemDescriptor diDescriptorText;

    private final DataItemDescriptor diDescriptorButtonSet;

    private final DataItemDescriptor diDescriptorButtonReset;

    private final ControlImage controlImage;

    public ValueSetComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final DataItemDescriptor setDescriptor, final DataItemDescriptor resetDescriptor, final String format, final Double ceil, final Double floor, final String decimal, final boolean isText, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, isText, ceil, floor, attribute, hdConnectionId, hdItemId );

        this.diDescriptorButtonReset = resetDescriptor;
        this.diDescriptorButtonSet = setDescriptor;
        this.diDescriptorText = descriptor;

        GridLayoutFactory.fillDefaults ().numColumns ( 4 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.label = new DescriptorLabel ( this, SWT.NONE, format, descriptor );
        this.label.setToolTipText ( Messages.ValueSetComposite_valueDescriptor + descriptor + Messages.ValueSetComposite_setDescriptor + setDescriptor + Messages.ValueSetComposite_resetDescriptor + resetDescriptor );

        this.layout ();
        final int width = this.label.getBounds ().width;
        GridDataFactory.fillDefaults ().grab ( true, false ).span ( 4, 1 ).hint ( width, 20 ).applyTo ( this.label );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        this.data = new Text ( this, SWT.BORDER | SWT.SINGLE | SWT.CENTER );
        GridDataFactory.fillDefaults ().grab ( false, false ).hint ( 60, 10 ).applyTo ( this.data );
        addDefaultKeyListener ( this.data );

        this.setButton = new Button ( this, 0 );
        this.setButton.setText ( Messages.ValueSetComposite_set );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this.setButton );

        this.setButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                triggerCommand ( e );
            }
        } );

        this.resetButton = new Button ( this, 0 );
        this.resetButton.setText ( Messages.ValueSetComposite_reset );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this.resetButton );

        this.resetButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                triggerCommand ( e );
            }
        } );

        this.pack ();

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }

    }

    @Override
    protected void makeWarnDialog ()
    {
        super.makeWarnDialog ();
        this.setButton.setEnabled ( false );
        this.resetButton.setEnabled ( false );
    }

    @Override
    protected void triggerCommand ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
        this.setButton.setEnabled ( true );
        this.resetButton.setEnabled ( true );
        try
        {
            this.registrationManager.startWrite ( this.diDescriptorText.getConnectionInformation (), this.diDescriptorText.getItemId (), Variant.valueOf ( parseDecimal ( this.data.getText () ) ), this.callbackHandler );
        }
        catch ( final Exception e )
        {
            // FIXME: log error
        }
        getShell ().setFocus ();
    }

    // FIXME: implement using anonymous classes to prevent "if"
    private void triggerCommand ( final SelectionEvent evt )
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            if ( evt.getSource ().equals ( this.setButton ) )
            {
                this.registrationManager.startWrite ( this.diDescriptorButtonSet.getConnectionInformation (), this.diDescriptorButtonSet.getItemId (), Variant.TRUE, this.callbackHandler );
            }
            else if ( evt.getSource ().equals ( this.resetButton ) )
            {
                this.registrationManager.startWrite ( this.diDescriptorButtonReset.getConnectionInformation (), this.diDescriptorButtonReset.getItemId (), Variant.TRUE, this.callbackHandler );
            }
            else
            {
                logger.warn ( "Missing click item for write operation" ); //$NON-NLS-1$
            }
        }
        catch ( final Exception e )
        {
            // FIXME: log error 
        }
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        setCeil ( value );
        setFloor ( value );

        setTextDecimal ( this.data, value );

        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );
    }

}
