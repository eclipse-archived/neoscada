/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.navigation.breadcrumb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.vi.ui.user.Activator;
import org.eclipse.scada.vi.ui.user.navigation.breadcrumb.BreadcrumbBar.BreadcrumbSelectionListener;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerAdapter;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// FIXME: add summary item
public class BreadcrumbNavigator
{
    private final static Logger logger = LoggerFactory.getLogger ( BreadcrumbNavigator.class );

    private final ViewManagerListener viewManagerListener = new ViewManagerAdapter () {

        @Override
        public void viewActiveChanged ( final ViewInstance viewInstance, final boolean state )
        {
            handleViewActiveChanged ( viewInstance, state );
        };
    };

    private final ViewManager viewManager;

    private final BreadcrumbBar breadcrumbs;

    private List<ViewInstanceDescriptor> currentChain;

    public BreadcrumbNavigator ( final Composite parent, final ViewManager viewManager, final int style )
    {
        this.viewManager = viewManager;

        this.breadcrumbs = new BreadcrumbBar ( parent, style );
        this.breadcrumbs.addSelectionListener ( new BreadcrumbSelectionListener () {

            @Override
            public void selectionChanged ( final BreadcrumbItem item )
            {
                handleSelectionChanged ( item );
            }
        } );

        this.viewManager.addViewManagerListener ( this.viewManagerListener );
    }

    protected void handleViewActiveChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "View active changed: {} - {}", viewInstance.getDescriptor (), state ); //$NON-NLS-1$

        if ( !state )
        {
            return;
        }

        try
        {
            final List<ViewInstanceDescriptor> chain = buildChain ( viewInstance.getDescriptor () );
            setDescriptorChain ( chain );

            this.breadcrumbs.layout ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to activate view", e );
        }
    }

    private boolean isSubChain ( final List<ViewInstanceDescriptor> descriptors )
    {
        if ( this.currentChain == null || this.currentChain.isEmpty () )
        {
            return false;
        }

        final int idx = Collections.indexOfSubList ( this.currentChain, descriptors );
        return idx >= 0;
    }

    private void setDescriptorChain ( final List<ViewInstanceDescriptor> descriptors )
    {
        if ( isSubChain ( descriptors ) )
        {
            this.breadcrumbs.setSelectionIndex ( descriptors.size () - 1 );
            return;
        }

        this.currentChain = descriptors;

        for ( final BreadcrumbItem item : this.breadcrumbs.getItems () )
        {
            item.dispose ();
        }

        if ( descriptors.isEmpty () )
        {
            return;
        }

        int i = 0;
        final int size = descriptors.size ();

        for ( final ViewInstanceDescriptor descriptor : descriptors )
        {
            final BreadcrumbItem item = new BreadcrumbItem ( this.breadcrumbs, i + 1 >= size );
            item.setText ( descriptor.getName () );
            item.setData ( "DESC", descriptor );
            i++;
        }

        this.breadcrumbs.setSelectionIndex ( descriptors.size () - 1 );
    }

    private List<ViewInstanceDescriptor> buildChain ( final ViewInstanceDescriptor descriptor )
    {
        final List<ViewInstanceDescriptor> result = new LinkedList<ViewInstanceDescriptor> ();

        ViewInstanceDescriptor currentDescriptor = descriptor;
        while ( currentDescriptor != null )
        {
            result.add ( 0, currentDescriptor );
            currentDescriptor = Activator.findParent ( currentDescriptor );
        }

        return result;
    }

    protected void handleSelectionChanged ( final BreadcrumbItem item )
    {
        final Object o = item.getData ( "DESC" );
        if ( o instanceof ViewInstanceDescriptor )
        {
            this.viewManager.showView ( ( (ViewInstanceDescriptor)o ).getId () );
        }
    }

    protected void handleDispose ()
    {
        this.viewManager.removeViewManagerListener ( this.viewManagerListener );
    }

    public void dispose ()
    {
        this.breadcrumbs.dispose ();
    }

    public Control getControl ()
    {
        return this.breadcrumbs.getControl ();
    }

}
