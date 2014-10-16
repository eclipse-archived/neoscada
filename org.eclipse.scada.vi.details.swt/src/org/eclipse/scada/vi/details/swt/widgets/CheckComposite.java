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
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.dialog.WriteConfirmDialog;
import org.eclipse.scada.vi.details.swt.impl.ViewContext;
import org.eclipse.scada.vi.details.swt.widgets.control.BlockControlImage;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( CheckComposite.class );

    private final Button button;

    private final String attribute;

    private final DataItemDescriptor descriptor;

    private final ControlImage controlImage;

    private final BlockControlImage blockImage;

    private final ViewContext context;

    public CheckComposite ( final ViewContext context, final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String attribute, final DataItemDescriptor readDescriptor )
    {
        super ( parent, style, null, null );

        this.context = context;

        this.attribute = attribute;
        this.descriptor = descriptor;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );
        this.blockImage = new BlockControlImage ( this.controlImage, SWT.NONE, this.registrationManager );

        this.button = new Button ( this, SWT.CHECK );
        this.button.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                CheckComposite.this.write ();
            }

        } );

        this.button.setText ( format );
        this.button.setEnabled ( false );

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

    protected void write ()
    {
        if ( !WriteConfirmDialog.create ( this.context, getShell () ) )
        {
            return;
        }

        try
        {
            this.button.setEnabled ( false );
            if ( this.attribute == null || this.attribute.equals ( "" ) ) //$NON-NLS-1$
            {
                this.registrationManager.startWrite ( this.descriptor.getConnectionInformation (), this.descriptor.getItemId (), Variant.valueOf ( this.button.getSelection () ), this.callbackHandler );
            }
            else
            {
                final Map<String, Variant> map = new HashMap<String, Variant> ();
                map.put ( this.attribute, Variant.valueOf ( this.button.getSelection () ) );
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

        Variant value;
        if ( this.attribute == null )
        {
            try
            {
                value = values.get ( "value" ).getValue ().getValue (); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }
        else
        {
            try
            {
                value = values.get ( "value" ).getValue ().getAttributes ().get ( this.attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        if ( value == null )
        {
            return;
        }

        this.button.setSelection ( value.asBoolean () );
        this.button.setEnabled ( !state.isBlocked () );
    }

}
