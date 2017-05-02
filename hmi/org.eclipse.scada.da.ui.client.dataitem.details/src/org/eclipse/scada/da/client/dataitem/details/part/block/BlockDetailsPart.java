/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part.block;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.Activator;
import org.eclipse.scada.da.client.dataitem.details.part.AbstractBaseDetailsPart;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class BlockDetailsPart extends AbstractBaseDetailsPart
{

    private static final String ATTR_ACTIVE = "org.eclipse.scada.da.master.common.block.active"; //$NON-NLS-1$

    private Label stateWidget;

    private Text userText;

    private Text timestampText;

    private Text reasonText;

    private Button blockButton;

    private Button unblockButton;

    public BlockDetailsPart ()
    {
    }

    @Override
    public void createPart ( final Composite parent )
    {
        super.createPart ( parent );

        parent.setLayout ( new GridLayout ( 2, false ) );

        Label label;

        label = new Label ( parent, SWT.NONE );
        label.setText ( Messages.BlockDetailsPart_Label_State );
        this.stateWidget = new Label ( parent, SWT.NONE );
        this.stateWidget.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, false, false ) );
        this.stateWidget.setText ( Messages.BlockDetailsPart_Label_State );
        this.stateWidget.setImage ( Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_BLOCK_DEFAULT ) );

        label = new Label ( parent, SWT.NONE );
        label.setText ( Messages.BlockDetailsPart_Label_User );
        this.userText = new Text ( parent, SWT.READ_ONLY | SWT.BORDER );
        this.userText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( parent, SWT.NONE );
        label.setText ( Messages.BlockDetailsPart_Label_Timestamp );
        this.timestampText = new Text ( parent, SWT.READ_ONLY | SWT.BORDER );
        this.timestampText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( parent, SWT.NONE );
        label.setText ( Messages.BlockDetailsPart_Label_Reason );
        label.setLayoutData ( new GridData ( SWT.BEGINNING, SWT.BEGINNING, false, false ) );
        this.reasonText = new Text ( parent, SWT.MULTI | SWT.BORDER );
        this.reasonText.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        final Composite buttonBar = new Composite ( parent, SWT.NONE );
        buttonBar.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );
        buttonBar.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false, 2, 1 ) );

        this.blockButton = new Button ( buttonBar, SWT.PUSH );
        this.blockButton.setText ( Messages.BlockDetailsPart_Text_Block );
        this.blockButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                block ();
            }
        } );
        this.unblockButton = new Button ( buttonBar, SWT.PUSH );
        this.unblockButton.setText ( Messages.BlockDetailsPart_Text_Unblock );
        this.unblockButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                unblock ();
            }
        } );
    }

    protected void unblock ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        attributes.put ( ATTR_ACTIVE, Variant.FALSE );

        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    protected void block ()
    {
        final String text = this.reasonText.getText ();

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        attributes.put ( ATTR_ACTIVE, Variant.TRUE );
        if ( !text.isEmpty () )
        {
            attributes.put ( "org.eclipse.scada.da.master.common.block.note", Variant.valueOf ( text ) ); //$NON-NLS-1$
        }

        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    private DisplayCallbackHandler makeDisplayCallback ()
    {
        return new DisplayCallbackHandler ( this.shell, "Configure Block", "Confirmation required for configuring block" );
    }

    protected boolean isAvailable ()
    {
        return isForceActive () || hasAttribute ( ATTR_ACTIVE );
    }

    protected boolean isActive ()
    {
        return getBooleanAttribute ( ATTR_ACTIVE );
    }

    @Override
    protected void update ()
    {
        final DataItemValue value = getValue ();

        final Calendar timestamp;
        final Variant reason;
        final Variant user;
        final Image image;

        if ( value != null )
        {
            timestamp = value.getAsTimestamp ( "org.eclipse.scada.da.master.common.block.timestamp" ); //$NON-NLS-1$
            reason = value.getAttributes ().get ( "org.eclipse.scada.da.master.common.block.note" ); //$NON-NLS-1$
            user = value.getAttributes ().get ( "org.eclipse.scada.da.master.common.block.user" ); //$NON-NLS-1$
            image = Activator.getDefault ().getImageRegistry ().get ( value.isBlocked () ? Activator.IMG_BLOCK_LOCKED : Activator.IMG_BLOCK_UNLOCKED );
        }
        else
        {
            timestamp = null;
            reason = null;
            user = null;
            image = Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_BLOCK_DEFAULT );
        }

        this.stateWidget.setImage ( image );

        this.userText.setText ( String.format ( Messages.BlockDetailsPart_Format_User, user != null ? user.asString ( "" ) : Messages.BlockDetailsPart_NoneString ) ); //$NON-NLS-1$
        this.timestampText.setText ( timestamp != null ? String.format ( Messages.BlockDetailsPart_Format_Date, timestamp ) : Messages.BlockDetailsPart_NoneString );

        if ( reason != null )
        {
            this.reasonText.setText ( reason.asString ( "" ) ); //$NON-NLS-1$
        }
        else
        {
            this.reasonText.setText ( "" ); //$NON-NLS-1$
        }

        // states
        this.reasonText.setEnabled ( isAvailable () && value != null && !isActive () && value.isConnected () );
        this.blockButton.setEnabled ( isAvailable () && value != null && !isActive () && value.isConnected () );
        this.unblockButton.setEnabled ( isAvailable () && value != null && isActive () && value.isConnected () );
    }
}
