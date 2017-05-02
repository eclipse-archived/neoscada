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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.dialog.WriteConfirmDialog;
import org.eclipse.scada.vi.details.swt.impl.ViewContext;
import org.eclipse.scada.vi.details.swt.widgets.control.BlockControlImage;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputComposite extends WriteableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( TextInputComposite.class );

    private final Text data;

    private final DataItemDescriptor descriptor;

    private final ControlImage controlImage;

    private final BlockControlImage blockImage;

    private final ViewContext context;

    public TextInputComposite ( final ViewContext context, final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final Double ceil, final double floor, final String decimal, final boolean isText, final String attribute, final DataItemDescriptor readDescriptor, final String hdConnectionId, final String hdItemId, int width, final String queryString )
    {
        super ( parent, style, format, decimal, isText, ceil, floor, attribute, hdConnectionId, hdItemId );

        this.context = context;

        this.descriptor = descriptor;

        if ( width == 0 )
        {
            width = 60;
        }

        final GridLayout layout = new GridLayout ( 3, false );

        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );
        this.blockImage = new BlockControlImage ( this.controlImage, SWT.NONE, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.data = new Text ( this, SWT.BORDER | SWT.SINGLE | SWT.RIGHT );
        final GridData data = new GridData ( SWT.LEFT, SWT.CENTER, false, true );
        data.widthHint = data.minimumWidth = width;
        data.heightHint = data.minimumHeight = SWT.DEFAULT;

        this.data.setLayoutData ( data );
        this.data.setEnabled ( true );

        this.data.setText ( "" ); //$NON-NLS-1$
        final DescriptorLabel label = new DescriptorLabel ( this, SWT.NONE, format, descriptor );
        final GridData labelData = new GridData ( SWT.FILL, SWT.CENTER, true, false );
        labelData.minimumWidth = 100;
        label.setLayoutData ( labelData );
        addDefaultKeyListener ( this.data );

        if ( descriptor != null )
        {
            if ( readDescriptor != null )
            {
                this.registrationManager.registerItem ( "value", readDescriptor.getItemId (), readDescriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
                this.registrationManager.registerItem ( "valueWrite", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
            }
            else
            {
                this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
            }
            this.blockImage.setBlockItem ( descriptor.asItem () );
            this.controlImage.setDetailItem ( descriptor.asItem () );
        }
    }

    @Override
    protected void triggerCommand ()
    {
        if ( !WriteConfirmDialog.create ( this.context, getShell () ) )
        {
            return;
        }

        try
        {
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_DARK_YELLOW ) );
            if ( getAttribute () == null )
            {
                if ( this.isText )
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( this.data.getText () ), this.callbackHandler );
                }
                else
                {
                    this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( parseDecimal ( this.data.getText () ) ), this.callbackHandler );
                }
            }
            else
            {
                final Map<String, Variant> attributes = new HashMap<String, Variant> ();
                final Variant variant;
                if ( this.isText )
                {
                    variant = Variant.valueOf ( this.data.getText () );
                }
                else
                {
                    variant = Variant.valueOf ( parseDecimal ( this.data.getText () ) );
                }
                attributes.put ( getAttribute (), variant );
                this.registrationManager.startWriteAttributes ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), attributes, this.callbackHandler );
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

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        setCeil ( value );
        setFloor ( value );

        if ( !this.data.isFocusControl () )
        {
            this.data.setText ( getFormattedText ( values, getAttribute () ) );
            //            this.setTextDecimal ( this.data, value );
            this.data.setForeground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_BLACK ) );
            this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_WHITE ) );
        }
        else
        {
            this.data.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_YELLOW ) );
        }

        this.data.setEnabled ( !state.isBlocked () );
    }

    protected void writeSCADA ( final Variant value, final Map<String, Variant> attributes, final String type )
    {
        if ( type.equals ( VariantType.BOOLEAN.toString () ) )
        {

        }
    }
}
