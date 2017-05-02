/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueComposite extends ReadableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ValueComposite.class );

    private final Label dataLabel;

    private final Boolean isDate;

    private final ControlImage controlImage;

    public ValueComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final boolean isText, final String attribute, final Boolean isDate, final String hdConnectionId, final String hdItemId, final String queryString )
    {
        super ( parent, style, format, decimal, isText, attribute );

        this.isDate = isDate;

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 7;
        layout.pack = true;
        setLayout ( layout );

        this.controlImage = new ControlImage ( this, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.dataLabel = new Label ( this, SWT.NONE );
        final RowData rowData = new RowData ( 80, SWT.DEFAULT );
        this.dataLabel.setAlignment ( SWT.RIGHT );
        this.dataLabel.setLayoutData ( rowData );
        this.dataLabel.setText ( "" ); //$NON-NLS-1$
        new DescriptorLabel ( this, SWT.NONE, format, descriptor );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
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

        if ( getAttribute () == null )
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
                value = values.get ( "value" ).getValue ().getAttributes ().get ( getAttribute () ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        if ( value.isDouble () )
        {
            this.dataLabel.setText ( getTextDecimal ( values, getAttribute () ) );
        }
        else if ( value.isString () )
        {
            this.dataLabel.setText ( getText ( values, getAttribute () ) );
        }
        else if ( value.isLong () )
        {
            if ( this.isDate == null )
            {
                this.dataLabel.setText ( getText ( values, getAttribute () ) );
            }
            else if ( this.isDate )
            {
                this.dataLabel.setText ( getDateAsString ( values, getAttribute () ) );
            }
            else
            {
                this.dataLabel.setText ( getText ( values, getAttribute () ) );
            }
        }
        else if ( value.isNull () )
        {
            this.dataLabel.setText ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ); //$NON-NLS-1$
        }
        else
        {
            this.dataLabel.setText ( getText ( values, getAttribute () ) );
        }
    }

}
