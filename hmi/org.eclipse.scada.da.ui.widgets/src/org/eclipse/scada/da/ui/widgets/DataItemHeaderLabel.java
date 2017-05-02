/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets;

import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StyleBlinker;
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.styles.DataItemValueStateExtractor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.BundleContext;

/**
 * @since 0.2.0
 */
public class DataItemHeaderLabel extends Composite
{

    private final Label headerIcon;

    private final Label headerLabel;

    private final Label headerValueLabel;

    private final StyleBlinker blinker;

    private final StateStyler styler;

    private final DataSourceListener listener = new DataSourceListener () {

        @Override
        public void updateData ( final DataItemValue value )
        {
            handleUpdateData ( value );
        }
    };

    private DataItemHolder holder;

    public DataItemHeaderLabel ( final Composite parent )
    {
        super ( parent, SWT.NONE );
        setLayout ( new RowLayout ( SWT.HORIZONTAL ) );

        this.headerIcon = new Label ( this, SWT.NONE );
        this.headerLabel = new Label ( this, SWT.NONE );
        this.headerLabel.setText ( Messages.DataItemHeaderLabel_EmptyDataItem );

        this.headerValueLabel = new Label ( this, SWT.NONE );

        this.blinker = new StyleBlinker () {

            @Override
            public void update ( final CurrentStyle style )
            {
                handleStyleUpdate ( style );
            }
        };

        this.styler = new StateStyler ( this.blinker );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        handleUpdateData ( null );
    }

    protected void handleDispose ()
    {
        unsubscribe ();

        this.styler.dispose ();
        this.blinker.dispose ();
    }

    public void subscribe ( final BundleContext context, final Item item )
    {
        unsubscribe ();

        if ( item != null )
        {
            this.holder = new DataItemHolder ( context, item, this.listener );
            this.headerLabel.setText ( String.format ( Messages.DataItemHeaderLabel_DataItemFormat, item.getId () ) );
            layout ();
        }
    }

    public void unsubscribe ()
    {
        if ( this.holder != null )
        {
            this.holder.dispose ();
            this.holder = null;

            this.headerLabel.setText ( Messages.DataItemHeaderLabel_EmptyDataItem );
            layout ();
        }
    }

    protected void handleStyleUpdate ( final CurrentStyle style )
    {
        if ( isDisposed () )
        {
            return;
        }

        applyWidget ( (Control)this.headerValueLabel, style );
        applyWidget ( this, style );
        applyWidget ( (Control)this.headerLabel, style );
        applyWidget ( this.headerIcon, style );
        layout ();
    }

    private static void applyWidget ( final Label label, final CurrentStyle style )
    {
        applyWidget ( (Control)label, style );
        label.setImage ( style.image );
    }

    private static void applyWidget ( final Control label, final CurrentStyle style )
    {
        label.setForeground ( style.foreground );
        label.setBackground ( style.background );
        label.setFont ( style.font );
    }

    protected void handleUpdateData ( final DataItemValue value )
    {
        getDisplay ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                performUpdate ( value );
            }
        } );
    }

    private void performUpdate ( final DataItemValue value )
    {
        if ( this.headerValueLabel.isDisposed () )
        {
            return;
        }

        this.styler.style ( new DataItemValueStateExtractor ( value ) );

        if ( value == null )
        {
            this.headerValueLabel.setText ( Messages.DataItemHeaderLabel_NoValueText );
            return;
        }

        // set the value label
        this.headerValueLabel.setText ( value.toString () );

        layout ();
    }
}
