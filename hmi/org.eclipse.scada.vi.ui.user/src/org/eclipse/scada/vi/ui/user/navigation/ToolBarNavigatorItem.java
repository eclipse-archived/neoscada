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
package org.eclipse.scada.vi.ui.user.navigation;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.scada.core.ui.styles.StateInformation;
import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StyleBlinker;
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.vi.ui.user.Activator;
import org.eclipse.scada.vi.ui.user.preferences.PreferenceConstants;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolBarNavigatorItem implements StateListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ToolBarNavigatorItem.class );

    private ToolItem button;

    private final ViewManager viewManager;

    private final ResourceManager manager;

    private final Image imageOk;

    private final Image imageInactive;

    private final StyleBlinker blinker;

    private final ViewInstanceDescriptor descriptor;

    private final ToolBar toolbar;

    private Image currentButtonImage;

    private boolean lazy = true;

    private boolean active;

    private final ToolBarNavigator toolBarNavigator;

    private final ViewInstance instance;

    private StateProvider summaryProvider;

    private Image styleImage;

    private boolean lazySummary;

    private final StateStyler styler;

    public ToolBarNavigatorItem ( final ToolBarNavigator toolBarNavigator, final ToolBar toolbar, final int index, final ViewManager viewManager, final ViewInstance viewInstance, final ResourceManager manager )
    {
        this.toolBarNavigator = toolBarNavigator;
        this.toolbar = toolbar;
        this.viewManager = viewManager;
        this.manager = manager;

        this.instance = viewInstance;
        this.descriptor = viewInstance.getDescriptor ();

        this.button = new ToolItem ( toolbar, SWT.RADIO, index );
        this.button.setText ( this.descriptor.getName () );

        this.button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
            {
                showView ( ToolBarNavigatorItem.this.descriptor.getId () );
            };
        } );

        // create resources

        this.imageOk = createImage ( PreferenceConstants.P_IMG_OK );
        this.imageInactive = createImage ( PreferenceConstants.P_IMG_INACTIVE );
        this.button.setImage ( this.imageInactive );

        // create the button

        createToolbarButton ();

        // create the blinker

        this.blinker = new StyleBlinker () {
            @Override
            public void update ( final CurrentStyle style )
            {
                handleUpdateStyle ( style );
            }
        };
        this.styler = new StateStyler ( this.blinker );

        // initialize

        this.lazy = viewInstance.isLazy ();
        this.active = viewInstance.isActive ();

        this.blinker.setStyle ( null );

        // connect summary

        if ( this.descriptor.getSummaryConnectionId () != null && this.descriptor.getSummaryItemId () != null )
        {
            logger.info ( "Creating summary provider using item: {} - {}", this.descriptor.getSummaryConnectionId (), this.descriptor.getSummaryItemId () );
            this.summaryProvider = new ItemSummaryProvider ( this, new Item ( this.descriptor.getSummaryConnectionId (), this.descriptor.getSummaryItemId (), Type.ID ) );
        }
        else if ( this.instance instanceof org.eclipse.scada.vi.data.SummaryProvider )
        {
            logger.info ( "Creating summary provider using view summary information" );
            this.summaryProvider = new DelegatingSummaryProvider ( (org.eclipse.scada.vi.data.SummaryProvider)this.instance, this );
            this.lazySummary = true;
        }
    }

    public void dispose ()
    {
        if ( this.summaryProvider != null )
        {
            this.summaryProvider.dispose ();
        }

        this.styler.dispose ();
        this.blinker.dispose ();
        this.button.dispose ();
    }

    private Image createImage ( final String key )
    {
        try
        {
            final String uri = Activator.getDefault ().getPreferenceStore ().getString ( key );
            return this.manager.createImageWithDefault ( ImageDescriptor.createFromURL ( new URL ( uri ) ) );
        }
        catch ( final MalformedURLException e )
        {
            return this.manager.createImageWithDefault ( ImageDescriptor.getMissingImageDescriptor () );
        }
    }

    private void createToolbarButton ()
    {
        if ( this.button == null )
        {
            final int index = this.toolBarNavigator.calculateToolbarIndex ( this.descriptor );

            if ( index < 0 )
            {
                return;
            }

            this.button = new ToolItem ( this.toolbar, SWT.RADIO, index );
            this.button.setText ( this.descriptor.getName () );
            this.button.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final org.eclipse.swt.events.SelectionEvent e )
                {
                    showView ( ToolBarNavigatorItem.this.descriptor.getId () );
                };
            } );
            // set current state
            this.button.setImage ( this.currentButtonImage );
        }
    }

    protected void showView ( final String id )
    {
        this.viewManager.showView ( id );
    }

    public void setLazy ( final boolean lazy )
    {
        this.lazy = lazy;

        // update button image
        setButtonImage ( this.styleImage );
    }

    public void setActive ( final boolean active )
    {
        this.button.setSelection ( active );
        this.active = active;

        // update button image
        setButtonImage ( this.styleImage );
    }

    protected void handleUpdateStyle ( final CurrentStyle style )
    {
        logger.debug ( "Update Style" );

        this.styleImage = style.image;
        setButtonImage ( this.styleImage );
    }

    private void setButtonImage ( final Image image )
    {
        logger.debug ( "Setting button image for {} - image: {}, lazy: {}, active: {}", new Object[] { this.descriptor, image, this.lazy, this.active } );

        if ( image == null )
        {
            this.currentButtonImage = this.lazy && this.lazySummary && !this.active ? this.imageInactive : this.imageOk;
        }
        else
        {
            this.currentButtonImage = image;
        }

        if ( this.button != null && !this.button.isDisposed () )
        {
            this.button.setImage ( this.currentButtonImage );
        }
    }

    @Override
    public void stateChange ( final StateInformation stateInformation )
    {
        logger.debug ( "Summary state changed: {}", stateInformation );
        this.styler.style ( stateInformation );
    }

}
