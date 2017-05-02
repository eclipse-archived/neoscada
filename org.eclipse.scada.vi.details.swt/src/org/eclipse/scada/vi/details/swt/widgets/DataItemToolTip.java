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

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.vi.details.swt.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;

public class DataItemToolTip extends ToolTip
{
    private final Item item;

    private Label headerLabel;

    private StyledText text;

    private StyledString currentText;

    private final LocalResourceManager resourceManager;

    public DataItemToolTip ( final Control control, final int style, final boolean manualActivation, final Item item )
    {
        super ( control, style, manualActivation );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.item = item;
    }

    public DataItemToolTip ( final Control control, final Item item )
    {
        super ( control );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.item = item;
    }

    @Override
    protected Composite createToolTipContentArea ( final Event event, final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        wrapper.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                DataItemToolTip.this.resourceManager.dispose ();
            }
        } );

        final GridLayout layout = new GridLayout ( 2, false );
        layout.marginHeight = 10;
        layout.marginWidth = 10;
        layout.horizontalSpacing = 20;
        layout.verticalSpacing = 20;

        wrapper.setLayout ( layout );
        wrapper.setBackground ( wrapper.getDisplay ().getSystemColor ( SWT.COLOR_WHITE ) );
        wrapper.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        this.headerLabel = new Label ( wrapper, SWT.NONE );
        this.headerLabel.setText ( this.item.getId () );
        this.headerLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false, 2, 1 ) );
        this.headerLabel.setFont ( JFaceResources.getHeaderFont () );

        final Label warnIcon = new Label ( wrapper, SWT.NONE );
        warnIcon.setLayoutData ( new GridData ( SWT.CENTER, SWT.CENTER, false, false ) );
        warnIcon.setImage ( Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_WARN_BIG ) );

        this.text = new StyledText ( wrapper, SWT.MULTI );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        if ( this.currentText != null )
        {
            this.text.setText ( this.currentText.getString () );
            this.text.setStyleRanges ( this.currentText.getStyleRanges () );
        }

        return wrapper;
    }

    public void setText ( final StyledString text )
    {
        this.currentText = new StyledString ();
        this.currentText.append ( text );
    }

}
