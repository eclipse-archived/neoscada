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
package org.eclipse.scada.utils.ui.server.internal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.scada.utils.ui.server.Page;
import org.eclipse.scada.utils.ui.server.PageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageManager
{
    private final static Logger logger = LoggerFactory.getLogger ( PageManager.class );

    private final Realm realm;

    private final TreeNode rootNode;

    private final ServiceTrackerCustomizer<PageProvider, PageProvider> customizer = new ServiceTrackerCustomizer<PageProvider, PageProvider> () {

        @Override
        public void removedService ( final ServiceReference<PageProvider> reference, final PageProvider service )
        {
            handleRemovedService ( reference, service );
        }

        @Override
        public void modifiedService ( final ServiceReference<PageProvider> reference, final PageProvider service )
        {
            handleModifiedService ( reference, service );
        }

        @Override
        public PageProvider addingService ( final ServiceReference<PageProvider> reference )
        {
            return handleAddingService ( reference );
        }
    };

    private final ServiceTracker<PageProvider, PageProvider> tracker;

    private final BundleContext context;

    private TreeNode currentNode;

    private Page currentPage;

    private Composite mainArea;

    private final WritableValue pageName;

    public PageManager ( final Realm realm, final BundleContext context )
    {
        this.realm = realm;
        this.context = context;
        this.rootNode = new TreeNode ( realm, "" ); //$NON-NLS-1$

        this.pageName = new WritableValue ( realm );

        this.tracker = new ServiceTracker<PageProvider, PageProvider> ( context, PageProvider.class, this.customizer );
        this.tracker.open ();
    }

    public IObservableValue getPageName ()
    {
        return this.pageName;
    }

    protected PageProvider handleAddingService ( final ServiceReference<PageProvider> reference )
    {
        final PageProvider provider = this.context.getService ( reference );

        addProvider ( provider );

        return provider;
    }

    protected void handleModifiedService ( final ServiceReference<PageProvider> reference, final PageProvider service )
    {
        removeProvider ( service );
        addProvider ( service );
    }

    protected void handleRemovedService ( final ServiceReference<PageProvider> reference, final PageProvider service )
    {
        removeProvider ( service );
    }

    private void removeProvider ( final PageProvider provider )
    {
        this.realm.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                PageManager.this.rootNode.removeEntry ( getPath ( provider ), provider );
            }
        } );
    }

    private void addProvider ( final PageProvider provider )
    {
        this.realm.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                performAddProvider ( provider );
            }
        } );
    }

    private Queue<String> getPath ( final PageProvider provider )
    {
        final String[] path = provider.getPath ();
        if ( path == null )
        {
            return new LinkedList<> ();
        }
        else
        {
            return new LinkedList<> ( Arrays.asList ( provider.getPath () ) );
        }
    }

    public TreeNode getRootNode ()
    {
        return this.rootNode;
    }

    public void dispose ()
    {
        this.tracker.close ();
        this.rootNode.dispose ();
    }

    public TreeNode showPage ( final TreeNode node )
    {
        final PageProvider provider = node.getProvider ();
        if ( provider == null )
        {
            return this.currentNode;
        }

        if ( this.currentNode == node )
        {
            // same node, no change
            return this.currentNode;
        }

        if ( this.currentNode == null )
        {
            activateNode ( node );
        }
        else
        {
            if ( this.currentPage != null )
            {
                if ( this.currentPage.requestClose () )
                {
                    deactivateNode ();
                    activateNode ( node );
                }
            }
        }
        return this.currentNode;
    }

    private void deactivateNode ()
    {
        for ( final Control control : this.mainArea.getChildren () )
        {
            control.dispose ();
        }
        this.currentNode = null;
        this.currentPage = null;
    }

    private void activateNode ( final TreeNode node )
    {
        final PageProvider provider = node.getProvider ();

        this.currentNode = node;
        this.currentPage = provider.createPage ();

        final Composite wrapper = new Composite ( this.mainArea, SWT.NONE );
        wrapper.setLayout ( new FillLayout () );

        this.currentPage.createContent ( wrapper );
        this.mainArea.layout ();

        this.pageName.setValue ( provider.getName () );
    }

    public void setMainArea ( final Composite mainArea )
    {
        this.mainArea = mainArea;
        this.mainArea.setLayout ( new FillLayout () );
    }

    private void performAddProvider ( final PageProvider provider )
    {
        logger.debug ( "Adding provider: {}", provider ); //$NON-NLS-1$

        final TreeNode node = this.rootNode.addEntry ( provider.getName (), getPath ( provider ), provider );
        if ( this.currentNode == null && node != null )
        {
            activateNode ( node );
        }
    }
}
