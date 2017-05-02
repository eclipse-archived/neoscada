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
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.dialog.WriteConfirmDialog;
import org.eclipse.scada.vi.details.swt.impl.ViewContext;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputMultiComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( TextInputMultiComposite.class );

    private final Text data;

    private final DataItemDescriptor descriptor;

    private final String attribute;

    private final Button button;

    private final Button buttonClear;

    private final ControlImage controlImage;

    private final ViewContext context;

    public TextInputMultiComposite ( final ViewContext context, final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, null, true, null, null, attribute, hdConnectionId, hdItemId );

        this.context = context;

        this.descriptor = descriptor;
        this.attribute = attribute;

        GridLayoutFactory.fillDefaults ().numColumns ( 5 ).margins ( 5, 5 ).spacing ( 0, 0 ).equalWidth ( false ).applyTo ( this );
        GridDataFactory.fillDefaults ().grab ( true, false ).applyTo ( this );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        new DescriptorLabel ( this, SWT.NONE, format, descriptor );

        //        final Composite composite = new Composite ( this, SWT.NONE );
        //        composite.setLayout ( new FillLayout () );
        //        final ScrolledComposite scrolledComposite = new ScrolledComposite ( composite, SWT.V_SCROLL );
        this.data = new Text ( this, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.LEFT );
        this.data.addFocusListener ( new FocusAdapter () {

            @Override
            public void focusGained ( final FocusEvent event )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_MAGENTA ) );
            }
        } );
        GridDataFactory.fillDefaults ().grab ( true, false ).hint ( 160, 50 ).applyTo ( this.data );

        this.button = new Button ( this, SWT.NONE );
        this.button.setText ( Messages.TextInputMultiComposite_send );
        this.button.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
                triggerCommand ( TextInputMultiComposite.this.data.getText () );
            }
        } );

        this.buttonClear = new Button ( this, SWT.NONE );
        this.buttonClear.setText ( Messages.TextInputMultiComposite_clear );
        this.buttonClear.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                TextInputMultiComposite.this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
                triggerCommand ( "" ); //$NON-NLS-1$
            }

        } );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }
    }

    protected void triggerCommand ( final String string )
    {
        if ( !WriteConfirmDialog.create ( this.context, getShell () ) )
        {
            return;
        }

        try
        {
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
            if ( this.attribute == null || this.attribute.equals ( "" ) ) //$NON-NLS-1$
            {
                if ( string == null )
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.NULL, this.callbackHandler );
                }
                else
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( string ), this.callbackHandler );
                }
            }
            else
            {
                final Map<String, Variant> map = new HashMap<String, Variant> ();
                if ( string == null )
                {
                    map.put ( this.attribute, Variant.NULL );
                }
                else
                {
                    map.put ( this.attribute, Variant.valueOf ( string ) );
                }
                this.registrationManager.startWriteAttributes ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), map, this.callbackHandler );
            }
            getShell ().setFocus ();
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

        setText ( this.data, values, this.attribute );
        this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );

        this.data.setEnabled ( !state.isBlocked () );
    }

    @Override
    protected void triggerCommand ()
    {
        triggerCommand ( this.data.getText () );
    }

}
