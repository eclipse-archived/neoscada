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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.scada.vi.data.RegistrationManager.Listener;
import org.eclipse.scada.vi.details.swt.Activator;
import org.eclipse.scada.vi.details.swt.dialog.LockMessageDialog;
import org.eclipse.scada.vi.details.swt.widgets.DataItemToolTip;
import org.eclipse.scada.vi.details.swt.widgets.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockControlImage extends Composite implements Listener
{

    private final static Logger logger = LoggerFactory.getLogger ( BlockControlImage.class );

    private static final String ATTR_BLOCK_ACTIVE = "org.eclipse.scada.da.master.common.block.active";

    private static final String ATTR_BLOCK_NOTE = "org.eclipse.scada.da.master.common.block.note";

    private static final String ATTR_BLOCK_USER = "org.eclipse.scada.da.master.common.block.user";

    private static final String ATTR_BLOCK_TIMESTAMP = "org.eclipse.scada.da.master.common.block.timestamp";

    private final Label icon;

    private final RegistrationManager registrationManager;

    private Item item;

    private final ControlImage controlImage;

    private final Styler boldStyler;

    private DataItemToolTip tooltip;

    private final Font boldFont;

    public BlockControlImage ( final ControlImage controlImage, final int style, final RegistrationManager registrationManager )
    {
        super ( controlImage.getClientSpace (), style );

        this.controlImage = controlImage;

        this.registrationManager = registrationManager;

        setLayout ( new FillLayout () );

        this.icon = new Label ( this, SWT.NONE );
        this.icon.setImage ( getEmptyImage () );
        this.icon.addMouseListener ( new MouseAdapter () {
            @Override
            public void mouseUp ( final MouseEvent e )
            {
                toggleBlock ();
            }
        } );

        this.registrationManager.addListener ( this );

        final LocalResourceManager resources = new LocalResourceManager ( JFaceResources.getResources (), this.icon );

        this.boldFont = resources.createFont ( JFaceResources.getDefaultFontDescriptor ().withStyle ( SWT.BOLD ) );
        this.boldStyler = new Styler () {

            @Override
            public void applyStyles ( final TextStyle textStyle )
            {
                textStyle.font = BlockControlImage.this.boldFont;
            }
        };
    }

    public void setBlockItem ( final Item item )
    {
        this.item = item;

        this.tooltip = new DataItemToolTip ( this.icon, item );
        this.tooltip.setShift ( new Point ( 5, 5 ) );
        this.tooltip.activate ();

        updateState ();
    }

    private Image getEmptyImage ()
    {
        return Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_EMPTY );
    }

    protected void handleDispose ()
    {
        this.registrationManager.removeListener ( this );
    }

    @Override
    public void triggerDataUpdate ()
    {
        final Display display = getDisplay ();
        if ( display.isDisposed () )
        {
            return;
        }

        getDisplay ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                if ( display.isDisposed () )
                {
                    return;
                }

                updateState ();
            }
        } );

    }

    private void updateState ()
    {
        if ( this.icon.isDisposed () )
        {
            return;
        }

        final DataItemValue value = getBlockItemValue ();
        if ( value == null )
        {
            this.icon.setImage ( getEmptyImage () );
            this.tooltip.deactivate ();
            return;
        }

        if ( isActive ( value ) )
        {
            this.icon.setImage ( Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_CONTROLLER_BLOCKED ) );
            this.tooltip.setText ( getStyledString ( getActiveBlockAttribute ( value, ATTR_BLOCK_NOTE ), getActiveBlockAttribute ( value, ATTR_BLOCK_USER ), value.getAsTimestamp ( ATTR_BLOCK_TIMESTAMP ) ) );
            this.tooltip.activate ();
        }
        else
        {
            this.icon.setImage ( Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_EMPTY ) );
            this.tooltip.deactivate ();
        }

        this.controlImage.layout ();
    }

    private DataItemValue getBlockItemValue ()
    {
        return findValue ( this.registrationManager.getData (), this.item );
    }

    private boolean isActive ( final DataItemValue value )
    {
        return value.isAttribute ( ATTR_BLOCK_ACTIVE, false );
    }

    private DataItemValue findValue ( final Map<String, DataValue> data, final Item item )
    {
        for ( final DataValue value : data.values () )
        {
            if ( value.getItem ().equals ( item ) )
            {
                return value.getValue ();
            }
        }
        return null;
    }

    protected void toggleBlock ()
    {
        final DataItemValue value = getBlockItemValue ();

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        if ( !isActive ( value ) )
        {
            final String reason = getBlockReason ( value );
            if ( reason == null )
            {
                // user did not press "OK"
                return;
            }
            if ( reason.isEmpty () )
            {
                attributes.put ( "org.eclipse.scada.da.master.common.block.note", Variant.valueOf ( Messages.BlockControllerImage_String_BlockNote_None ) );//$NON-NLS-1$
            }
            else
            {
                attributes.put ( "org.eclipse.scada.da.master.common.block.note", Variant.valueOf ( reason ) );//$NON-NLS-1$                
            }
        }
        else
        {
            String blockNote = getActiveBlockAttribute ( value, ATTR_BLOCK_NOTE );
            if ( blockNote == null || blockNote.isEmpty () )
            {
                blockNote = Messages.BlockControllerImage_String_BlockNote_None;
            }

            if ( !MessageDialog.openConfirm ( getShell (), Messages.BlockControllerImage_ConfirmDialog_Title, String.format ( Messages.BlockControllerImage_ConfirmDialog_Message_Format, blockNote ) ) )
            {
                return;
            }

        }

        attributes.put ( "org.eclipse.scada.da.master.common.block.active", Variant.valueOf ( !isActive ( value ) ) );//$NON-NLS-1$

        try
        {
            final CallbackHandler handler = new DisplayCallbackHandler ( getShell (), "Confirmation", "Confirm block operation" );
            this.registrationManager.startWriteAttributes ( this.item.getConnectionString (), this.item.getId (), attributes, handler );
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( "Failed to write", e );
        }
    }

    private String getActiveBlockAttribute ( final DataItemValue value, final String attribute )
    {
        if ( value == null || value.getAttributes () == null )
        {
            return null;
        }

        final Variant v = value.getAttributes ().get ( attribute );
        if ( v == null )
        {
            return null;
        }

        return v.asString ( null );
    }

    private String getBlockReason ( final DataItemValue value )
    {
        return new LockMessageDialog ( getShell (), getActiveBlockAttribute ( value, ATTR_BLOCK_NOTE ) ).openDialog ();
    }

    protected StyledString getStyledString ( final String note, final String user, final Calendar timestamp )
    {
        final StyledString string = new StyledString ();

        if ( timestamp != null )
        {
            string.append ( Messages.BlockControllerImage_String_Timestamp, this.boldStyler );
            string.append ( timestamp.getTime ().toString () + "\n\n" );
        }

        if ( user != null )
        {
            string.append ( Messages.BlockControllerImage_String_BlockedBy, this.boldStyler );
            if ( user.equals ( "" ) )
            {
                string.append ( Messages.BlockControllerImage_String_Unknown );
            }
            else
            {
                string.append ( user );
            }
        }

        if ( note != null )
        {
            // show tooltip
            if ( string.length () > 0 )
            {
                string.append ( "\n" ); //$NON-NLS-1$
            }
            string.append ( Messages.BlockControllerImage_String_Reason, this.boldStyler );
            if ( note.equals ( "" ) )
            {
                string.append ( Messages.BlockControllerImage_String_None );
            }
            else
            {
                string.append ( note );
            }
        }
        return string;
    }
}
