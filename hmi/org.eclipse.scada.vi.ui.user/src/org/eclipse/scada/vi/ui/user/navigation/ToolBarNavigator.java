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
package org.eclipse.scada.vi.ui.user.navigation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolBarNavigator implements ViewManagerListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ToolBarNavigator.class );

    private final ToolBar toolbar;

    private final ViewManager viewManager;

    private final Map<ViewInstanceDescriptor, ToolBarNavigatorItem> itemMap = new HashMap<ViewInstanceDescriptor, ToolBarNavigatorItem> ();

    private final LocalResourceManager resourceManager;

    private final Set<ViewInstanceDescriptor> visibleDescriptors = new HashSet<ViewInstanceDescriptor> ();

    public ToolBarNavigator ( final Composite parent, final int style, final ViewManager viewManager )
    {
        this.viewManager = viewManager;
        this.toolbar = new ToolBar ( parent, style );
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( parent.getDisplay () ) );

        this.toolbar.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        viewManager.addViewManagerListener ( this );
    }

    public void dispose ()
    {
        this.toolbar.dispose ();
    }

    protected void handleDispose ()
    {
        this.resourceManager.dispose ();
    }

    public void setLayoutData ( final Object layoutData )
    {
        this.toolbar.setLayoutData ( layoutData );
    }

    public Control getControl ()
    {
        return this.toolbar;
    }

    protected boolean hasButton ( final ViewInstanceDescriptor descriptor )
    {
        return descriptor.getParentId () == null || descriptor.getParentId ().isEmpty ();
    }

    @Override
    public void viewVisibilityChanged ( final ViewInstance viewInstance, final boolean visible )
    {
        logger.debug ( "Visibility changed: {} - {}", viewInstance.getDescriptor (), visible );

        if ( this.toolbar.isDisposed () )
        {
            return;
        }

        final ViewInstanceDescriptor descriptor = viewInstance.getDescriptor ();

        if ( !isMain ( descriptor ) )
        {
            return;
        }

        if ( visible )
        {
            this.visibleDescriptors.add ( descriptor );
            ToolBarNavigatorItem item = this.itemMap.get ( descriptor );
            if ( item == null )
            {
                final int index = calculateToolbarIndex ( descriptor );
                logger.info ( "Adding view at index {}", index );
                item = new ToolBarNavigatorItem ( this, this.toolbar, index, this.viewManager, viewInstance, this.resourceManager );
                this.itemMap.put ( descriptor, item );
                this.toolbar.getParent ().getParent ().layout ();
            }
        }
        else
        {
            this.visibleDescriptors.remove ( descriptor );
            final ToolBarNavigatorItem item = this.itemMap.remove ( descriptor );
            if ( item != null )
            {
                item.dispose ();
            }
            this.toolbar.getParent ().getParent ().layout ();
        }

    }

    @Override
    public void viewLazynessChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Lazyness changed: {} - {}", viewInstance.getDescriptor (), state );

        final ToolBarNavigatorItem item = this.itemMap.get ( viewInstance.getDescriptor () );
        if ( item != null )
        {
            item.setLazy ( state );
        }
    }

    @Override
    public void viewDefaultChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Default changed: {} - {}", viewInstance.getDescriptor (), state );
    }

    @Override
    public void viewActiveChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "Active changed: {} - {}", viewInstance.getDescriptor (), state );

        final ToolBarNavigatorItem item = this.itemMap.get ( viewInstance.getDescriptor () );
        if ( item != null )
        {
            item.setActive ( state );
        }
    }

    @Override
    public void viewControlChanged ( final ViewInstance viewInstance )
    {
    }

    public int calculateToolbarIndex ( final ViewInstanceDescriptor descriptor )
    {
        if ( !isMain ( descriptor ) )
        {
            logger.debug ( "Has parent: {}", descriptor );
            return -1;
        }

        final List<ViewInstanceDescriptor> data = new ArrayList<ViewInstanceDescriptor> ( this.visibleDescriptors );

        // remove all views with a parent
        final Iterator<ViewInstanceDescriptor> i = data.iterator ();
        while ( i.hasNext () )
        {
            if ( !isMain ( i.next () ) )
            {
                logger.debug ( "{} has parent, remove: ", descriptor );
                i.remove ();
            }
        }

        data.add ( descriptor );
        Collections.sort ( data, ViewInstanceDescriptor.DESCRIPTOR_ORDER_COMPARATOR );

        logger.debug ( "Sort order: {}", data );

        final int result = data.indexOf ( descriptor );
        logger.debug ( "Index is: {}", result );
        return result;
    }

    protected boolean isMain ( final ViewInstanceDescriptor descriptor )
    {
        return descriptor.isMainView ();
    }

}
