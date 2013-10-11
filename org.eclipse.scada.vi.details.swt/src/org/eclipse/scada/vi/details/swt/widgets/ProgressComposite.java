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

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressComposite extends ReadableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ProgressComposite.class );

    private final ProgressBar progressBar;

    private final Text text;

    //    private final Font font;

    private double max = 100.0;

    private double min = 0.0;

    private double factor = 1.0;

    private final int textWidth = 40;

    private final int textHeight = SWT.DEFAULT;

    //intended to be the width for the whole component. it should be easy to configure the width in the xmi.
    private int width = 100;

    private int progressWidth;

    private final ControlImage controlImage;

    public ProgressComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final String decimal, final String attribute, final double max, final double min, final double factor, final int width, final String hdConnectionId, final String hdItemId, final String queryString )
    {
        super ( parent, style, format, decimal, false, attribute );

        if ( max != 0 )
        {
            this.max = max;
        }

        if ( min != 0 )
        {
            this.min = min;
        }

        if ( factor != 0 )
        {
            this.factor = factor;
        }

        if ( width > 0 )
        {
            this.width = width;
        }

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                ProgressComposite.this.handleDispose ();
            }
        } );

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 7;
        layout.pack = true;
        setLayout ( layout );

        this.progressWidth = this.width - this.textWidth - layout.spacing;
        if ( this.progressWidth < 1 )
        {
            this.progressWidth = 1;
        }

        this.controlImage = new ControlImage ( this, this.registrationManager );
        Helper.createTrendButton ( this.controlImage, hdConnectionId, hdItemId, queryString );

        this.progressBar = new ProgressBar ( this, SWT.NONE );
        //        this.progressBar.setSize ( this.progressWidth, this.textHeight );
        final RowData progressData = new RowData ( this.progressWidth, SWT.DEFAULT );
        this.progressBar.setLayoutData ( progressData );
        final int minimum = (int)Math.round ( this.min );
        final int maximum = (int)Math.round ( this.max );
        this.progressBar.setMinimum ( minimum );
        this.progressBar.setMaximum ( maximum );

        this.text = new Text ( this, SWT.MULTI | SWT.WRAP | SWT.RIGHT );
        //        final RowData rowData = new RowData ( 60, SWT.DEFAULT );
        //        this.font = new Font ( getDisplay (), new FontData ( "Arial", 10, 0 ) ); //$NON-NLS-1$
        //        this.text.setFont ( this.font );
        final RowData rowData = new RowData ( this.textWidth, this.textHeight );
        //        this.dataText.setAlignment ( SWT.RIGHT );
        this.text.setLayoutData ( rowData );
        this.text.setEnabled ( true );
        this.text.setEditable ( false );

        this.text.setText ( "" ); //$NON-NLS-1$
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

        Variant value = null;
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

        if ( value == null )
        {
            this.text.setText ( "" ); //$NON-NLS-1$
        }
        else if ( value.isDouble () )
        {
            this.text.setText ( getTextDecimal ( values.get ( "value" ).getValue (), getAttribute (), this.factor ) );

            int progress = 0;
            try
            {
                progress = (int) ( value.asDouble () * this.factor ); //do not use Math.round. We want to see the ProgressBar be active until it reaches 100.0 percent. (I.e. Do not show inactive for 99.5 %).
            }
            catch ( final NullValueException e )
            {
                logger.warn ( "progress could not be set" );
            }
            catch ( final NotConvertableException e )
            {
                logger.error ( "value is not convertable. Can't set progress" );
            }
            this.progressBar.setSelection ( progress );
        }
        else
        //the ProgreesComposite supports double only at the moment
        {
            this.text.setText ( "" ); //$NON-NLS-1$
            this.progressBar.setSelection ( 0 );
        }
    }

}
