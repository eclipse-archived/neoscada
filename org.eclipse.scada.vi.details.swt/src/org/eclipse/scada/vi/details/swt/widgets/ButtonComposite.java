/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work, fix bugs
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.model.Registration;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.dialog.WriteConfirmDialog;
import org.eclipse.scada.vi.details.swt.source.ValueSourceController;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ButtonComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ButtonComposite.class );

    private final Button button;

    private final String format;

    private final Variant value;

    private final DataItemDescriptor writeDescriptor;

    private final ValueSourceController active;

    private final String attribute;

    private Font myFont;

    private final ControlImage controlImage;

    public ButtonComposite ( final Composite parent, final int style, final DataItemDescriptor readDescriptor, final DataItemDescriptor writeDescriptor, final String format, final String value, final ValueSourceController active, final Collection<Registration> registrations, final Map<String, String> properties, final String attribute, final int textHeight )
    {
        super ( parent, style, registrations, properties );

        this.attribute = attribute;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 2;
        layout.pack = true;
        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        if ( textHeight != 0 )
        {
            this.button = new Button ( this, SWT.PUSH | SWT.FLAT );
            this.myFont = new Font ( getDisplay (), new FontData ( "Arial", textHeight, 0 ) ); //$NON-NLS-1$
            this.button.setFont ( this.myFont );
        }
        else
        {
            this.button = new Button ( this, SWT.PUSH );
        }

        //        setLayout ( new FillLayout () );

        this.active = active;

        this.format = format;

        if ( value != null )
        {
            final VariantEditor ve = new VariantEditor ();
            ve.setAsText ( value );
            this.value = (Variant)ve.getValue ();
        }
        else
        {
            this.value = null;
        }

        if ( readDescriptor != null )
        {
            this.controlImage.setDetailItem ( readDescriptor.asItem () );
            this.registrationManager.registerItem ( "value", readDescriptor.getItemId (), readDescriptor.getConnectionInformation (), false, false );
        }
        else if ( writeDescriptor != null )
        {
            this.controlImage.setDetailItem ( writeDescriptor.asItem () );
            this.registrationManager.registerItem ( "value", writeDescriptor.getItemId (), writeDescriptor.getConnectionInformation (), false, false );
            this.button.setText ( format );
        }
        this.writeDescriptor = writeDescriptor;
        this.button.setToolTipText ( "Read descriptor: " + readDescriptor + "\nWrite descriptor: " + writeDescriptor ); //$NON-NLS-1$ //$NON-NLS-2$

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                ButtonComposite.this.handleDispose ();
            }
        } );

        this.button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                ButtonComposite.this.handleButton ();
            }
        } );
    }

    protected void handleButton ()
    {
        if ( !WriteConfirmDialog.create ( getShell () ) )
        {
            return;
        }

        try
        {
            if ( this.attribute == null || this.attribute.isEmpty () )
            {
                this.registrationManager.startWrite ( this.writeDescriptor.getConnectionInformation (), this.writeDescriptor.getItemId (), this.value, this.callbackHandler );
            }
            else
            {
                final Map<String, Variant> attributes = new HashMap<String, Variant> ();
                attributes.put ( this.attribute, this.value );
                this.registrationManager.startWriteAttributes ( this.writeDescriptor.getConnectionInformation (), this.writeDescriptor.getItemId (), attributes, this.callbackHandler );
            }
        }
        catch ( final Exception e )
        {
            // FIXME: log error
        }
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation summaryInformation )
    {
        if ( this.button.isDisposed () )
        {
            return;
        }

        if ( this.active != null )
        {
            this.active.updateData ( values, summaryInformation );
            this.button.setEnabled ( this.active.value ().getValue ().asBoolean () && !summaryInformation.isBlocked () );
        }
        else
        {
            this.button.setEnabled ( !summaryInformation.isBlocked () );
        }

        final DataItemValue value = values.get ( "value" ).getValue (); //$NON-NLS-1$

        if ( value == null )
        {
            return;
        }

        this.button.setText ( String.format ( this.format, value.getValue ().toLabel () ) );
        logger.info ( "update View for ButtonComposite: {}", this.writeDescriptor ); //$NON-NLS-1$
    }

}
