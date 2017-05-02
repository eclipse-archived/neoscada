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
package org.eclipse.scada.vi.details.swt.widgets.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.scada.core.ui.connection.login.SessionManager;
import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StyleBlinker;
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.client.dataitem.details.dialog.DataItemDetailsDialog;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.widgets.DragHelper;

public class ControlImage extends Composite implements RegistrationManager.Listener
{

    private static final String detailsDialogRole = System.getProperty ( "org.eclipse.scada.vi.details.swt.widgets.roles.detailsDialog", "admin" );

    private final Label state;

    private Composite clientSpace;

    private final StyleBlinker blinker;

    private Item detailItem;

    private final RegistrationManager registrationManager;

    private final StateStyler styler;

    public ControlImage ( final Composite parent, final RegistrationManager registrationManager )
    {
        this ( parent, SWT.NONE, registrationManager );
    }

    public ControlImage ( final Composite parent, final int style, final RegistrationManager registrationManager )
    {
        super ( parent, style );

        this.registrationManager = registrationManager;
        registrationManager.addListener ( this );

        final RowLayout layout = new RowLayout ( SWT.HORIZONTAL );
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        layout.pack = true;
        setLayout ( layout );

        this.state = new Label ( this, SWT.NONE );
        DragHelper.addDragSupport ( this.state, registrationManager );

        this.state.addMouseListener ( new MouseAdapter () {
            @Override
            public void mouseDoubleClick ( final org.eclipse.swt.events.MouseEvent e )
            {
                openDetails ();
            };
        } );

        // initialize in order to have the correct size
        this.state.setImage ( org.eclipse.scada.vi.details.swt.Activator.getDefault ().getImageRegistry ().get ( org.eclipse.scada.vi.details.swt.Activator.IMG_ATTR_OK ) );

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
    }

    public void setDetailItem ( final Item detailItem )
    {
        this.detailItem = detailItem;
    }

    public Item getDetailItem ()
    {
        return this.detailItem;
    }

    protected void openDetails ()
    {
        if ( this.detailItem == null )
        {
            return;
        }

        if ( SessionManager.getDefault ().hasRole ( detailsDialogRole ) )
        {
            final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( getShell (), this.detailItem );
            dlg.open ();
        }
    }

    protected void handleStyleUpdate ( final CurrentStyle style )
    {
        if ( this.state.isDisposed () )
        {
            return;
        }

        final Image image = style.image;

        if ( image == null )
        {
            this.state.setImage ( org.eclipse.scada.vi.details.swt.Activator.getDefault ().getImageRegistry ().get ( org.eclipse.scada.vi.details.swt.Activator.IMG_ATTR_OK ) );
        }
        else
        {
            this.state.setImage ( image );
        }
    }

    protected void handleDispose ()
    {
        this.registrationManager.removeListener ( this );
        this.styler.dispose ();
        this.blinker.dispose ();
    }

    /**
     * Get the client space and create if it does not yet exists.
     * <p>
     * Note that if the client space is not filled, the default size of the
     * empty composite will be 64x64 due to some strange SWT philosophy.
     * </p>
     * 
     * @return The client space composite
     */
    public Composite getClientSpace ()
    {
        if ( this.clientSpace == null )
        {
            this.clientSpace = new Composite ( this, SWT.NONE );
            this.clientSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );
        }
        return this.clientSpace;
    }

    @Override
    public void triggerDataUpdate ()
    {
        final SummaryInformation summaryInformation = new SummaryInformation ( this.registrationManager.getData () );
        this.styler.style ( summaryInformation.getStateInformation () );
    }
}
