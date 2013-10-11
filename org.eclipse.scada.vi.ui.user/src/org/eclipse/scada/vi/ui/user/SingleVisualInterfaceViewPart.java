/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.scada.ui.utils.AbstractSelectionProvider;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerContext;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerListener;
import org.eclipse.scada.vi.ui.user.viewer.ext.ExtensionDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ext.ViewerExtension;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A view part which holds a set of views and navigation controls
 * 
 * @author Jens Reimann
 */
public class SingleVisualInterfaceViewPart extends ViewPart implements ViewManager, ViewManagerContext
{

    private final static Logger logger = LoggerFactory.getLogger ( SingleVisualInterfaceViewPart.class );

    private Composite viewHolder;

    private final Map<String, ViewInstance> instances = new LinkedHashMap<String, ViewInstance> ( 1 );

    private ViewInstance currentInstance;

    private StackLayout stackLayout;

    private ResourceManager manager;

    private final List<ViewInstanceDescriptor> descriptors;

    private final Set<ViewInstanceDescriptor> visibleDescriptors = new HashSet<ViewInstanceDescriptor> ();

    private boolean switchingView;

    private ISelectionProvider selectionProvider;

    private final Set<ViewManagerListener> viewManagerListeners = new LinkedHashSet<ViewManagerListener> ();

    public SingleVisualInterfaceViewPart ()
    {
        this.descriptors = new ArrayList<ViewInstanceDescriptor> ( Activator.getDescriptors () );
        Collections.sort ( this.descriptors, ViewInstanceDescriptor.DESCRIPTOR_ORDER_COMPARATOR );
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.manager = new LocalResourceManager ( JFaceResources.getResources () );

        parent.setLayout ( new FillLayout () );

        // selection
        this.selectionProvider = new AbstractSelectionProvider ();
        getSite ().setSelectionProvider ( this.selectionProvider );

        final List<ExtensionDescriptor> extensions = Activator.getExtensionDescriptors ();

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout gridLayout = new GridLayout ( 3, false );
        gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
        gridLayout.marginHeight = gridLayout.marginWidth = 0;
        wrapper.setLayout ( gridLayout );

        final Composite topComposite = new Composite ( wrapper, SWT.NONE );
        topComposite.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false, 3, 1 ) );
        topComposite.setLayout ( createExtensionGridLayout () );

        final Composite leftComposite = new Composite ( wrapper, SWT.NONE );
        leftComposite.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, false, true ) );
        leftComposite.setLayout ( createExtensionGridLayout () );

        // create main

        this.viewHolder = new Composite ( wrapper, SWT.NONE );
        this.viewHolder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.viewHolder.setLayout ( this.stackLayout = new StackLayout () );

        final Composite rightComposite = new Composite ( wrapper, SWT.NONE );
        rightComposite.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, false, true ) );
        rightComposite.setLayout ( createExtensionGridLayout () );

        final Composite bottomComposite = new Composite ( wrapper, SWT.NONE );
        bottomComposite.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false, 3, 1 ) );
        bottomComposite.setLayout ( createExtensionGridLayout () );

        try
        {
            createExtensions ( extensions, topComposite, "TOP", true );
            createExtensions ( extensions, bottomComposite, "BOTTOM", true );
            createExtensions ( extensions, leftComposite, "LEFT", false );
            createExtensions ( extensions, rightComposite, "RIGHT", false );
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e, Activator.PLUGIN_ID );
        }

        for ( final ViewInstanceDescriptor descriptor : this.descriptors )
        {
            createAndAddView ( descriptor );
        }
        activateNextMain ();
    }

    private Layout createExtensionGridLayout ()
    {
        final GridLayout gridLayout = new GridLayout ( 1, false );

        gridLayout.horizontalSpacing = gridLayout.verticalSpacing = 0;
        gridLayout.marginHeight = gridLayout.marginWidth = 0;

        return gridLayout;
    }

    private void createExtensions ( final List<ExtensionDescriptor> extensions, final Composite composite, final String location, final boolean horizontal ) throws CoreException
    {
        int count = 0;
        for ( final ExtensionDescriptor extension : extensions )
        {
            if ( !location.equals ( extension.getLocation () ) )
            {
                continue;
            }

            final ViewerExtension viewerExtension = extension.createExtension ();
            if ( viewerExtension != null )
            {
                final Control result = viewerExtension.create ( composite, this, horizontal );
                if ( result != null )
                {
                    count++;
                    final String align = extension.getAlign ();
                    if ( "END".equalsIgnoreCase ( align ) )
                    {
                        result.setLayoutData ( new GridData ( horizontal ? SWT.FILL : SWT.END, SWT.FILL, !horizontal, horizontal ) );
                    }
                    else if ( "FILL".equalsIgnoreCase ( align ) )
                    {
                        result.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
                    }
                    else
                    {
                        result.setLayoutData ( new GridData ( horizontal ? SWT.FILL : SWT.BEGINNING, SWT.FILL, !horizontal, horizontal ) );
                    }
                }
            }
        }
        if ( composite.getLayout () instanceof GridLayout )
        {
            ( (GridLayout)composite.getLayout () ).numColumns = count;
        }
    }

    private void updateSelection ()
    {
        final StructuredSelection sel;
        if ( this.currentInstance == null )
        {
            sel = StructuredSelection.EMPTY;
        }
        else
        {
            sel = new StructuredSelection ( this.currentInstance );
        }
        logger.debug ( "Setting selection: {}", sel );
        this.selectionProvider.setSelection ( sel );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.manager.dispose ();
    }

    private ViewInstance createAndAddView ( final ViewInstanceDescriptor descriptor )
    {
        final ViewInstance instance = descriptor.getFactory ().createViewInstance ( this, this, descriptor, this.viewHolder, this.manager, getSite () );
        this.instances.put ( descriptor.getId (), instance );
        return instance;
    }

    @Override
    public void showView ( final String id )
    {
        showView ( id, false );
    }

    @Override
    public void showView ( final String id, final boolean force )
    {
        final ViewInstance instance = this.instances.get ( id );
        if ( instance == null )
        {
            return;
        }
        showView ( instance, force );
    }

    protected void showView ( final ViewInstance instance, final boolean force )
    {
        if ( this.currentInstance == instance && !force )
        {
            return;
        }

        this.switchingView = true;

        try
        {
            if ( this.currentInstance != null )
            {
                this.currentInstance.deactivate ();
            }

            this.currentInstance = instance;
            this.currentInstance.activate ();

            updateTopControl ();
        }
        finally
        {
            this.switchingView = false;
        }
        updateSelection ();
    }

    private void updateTopControl ()
    {
        this.stackLayout.topControl = this.currentInstance.getControl ();
        this.viewHolder.layout ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.currentInstance != null )
        {
            this.currentInstance.setFocus ();
        }
    }

    protected static boolean hasParent ( final ViewInstanceDescriptor descriptor )
    {
        return descriptor.getParentId () != null && !descriptor.getParentId ().isEmpty ();
    }

    @Override
    public void viewVisibilityChanged ( final ViewInstance viewInstance, final boolean visible )
    {
        fireViewVisibilityChanged ( viewInstance, visible );

        if ( visible )
        {
            this.visibleDescriptors.add ( viewInstance.getDescriptor () );
        }
        else
        {
            this.visibleDescriptors.remove ( viewInstance.getDescriptor () );
        }

        if ( this.currentInstance == viewInstance && !visible )
        {
            // hide current view
            this.currentInstance.deactivate ();
            this.currentInstance = null;
            this.stackLayout.topControl = null;
            this.viewHolder.layout ();
        }
        if ( this.currentInstance == null )
        {
            // find new visible main
            activateNextMain ();
        }
    }

    private void fireViewVisibilityChanged ( final ViewInstance viewInstance, final boolean visible )
    {
        for ( final ViewManagerListener listener : this.viewManagerListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.viewVisibilityChanged ( viewInstance, visible );
                }
            } );
        }
    }

    protected void activateNextMain ()
    {
        final List<ViewInstanceDescriptor> descriptors = findVisibleMains ();
        if ( !descriptors.isEmpty () )
        {
            showView ( descriptors.get ( 0 ).getId (), true );
        }
    }

    protected List<ViewInstanceDescriptor> findVisibleMains ()
    {
        final List<ViewInstanceDescriptor> result = new LinkedList<ViewInstanceDescriptor> ();

        for ( final ViewInstanceDescriptor desc : this.visibleDescriptors )
        {
            final ViewInstance instance = this.instances.get ( desc.getId () );
            if ( instance == null )
            {
                continue;
            }
            if ( instance.isDefaultInstance () )
            {
                result.add ( desc );
            }
        }
        Collections.sort ( result, ViewInstanceDescriptor.DESCRIPTOR_ORDER_COMPARATOR );

        return result;
    }

    @Override
    public void viewDefaultChanged ( final ViewInstance viewInstance, final boolean state )
    {
        if ( this.currentInstance == null )
        {
            activateNextMain ();
        }
    }

    @Override
    public void viewActiveChanged ( final ViewInstance viewInstance, final boolean state )
    {
        if ( !state && !this.switchingView )
        {
            /*
             * The current view got deactivated. But we only assign a new view
             * if we are not in the middle of switching views. 
             */
            if ( this.currentInstance == viewInstance )
            {
                this.currentInstance = null;
                activateNextMain ();
            }
        }
        fireActiveChanged ( viewInstance, state );
    }

    private void fireActiveChanged ( final ViewInstance viewInstance, final boolean state )
    {
        for ( final ViewManagerListener listener : this.viewManagerListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.viewActiveChanged ( viewInstance, state );
                }
            } );
        }
    }

    @Override
    public void viewLazynessChanged ( final ViewInstance viewInstance, final boolean state )
    {
        logger.debug ( "viewLazynessChanged : {} - {}", viewInstance.getDescriptor (), state );

        fireLazyStateChanged ( viewInstance, state );
    }

    private void fireLazyStateChanged ( final ViewInstance viewInstance, final boolean state )
    {
        for ( final ViewManagerListener listener : this.viewManagerListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.viewLazynessChanged ( viewInstance, state );
                }
            } );
        }
    }

    @Override
    public void viewControlChanged ( final ViewInstance viewInstance )
    {
        if ( this.currentInstance == viewInstance )
        {
            // The control of the active view changes .. so we need to update it
            updateTopControl ();
        }
    }

    @Override
    public void setSelectionProvider ( final ISelectionProvider selectionProvider )
    {
        getSite ().setSelectionProvider ( selectionProvider );
    }

    @Override
    public void addViewManagerListener ( final ViewManagerListener listener )
    {
        this.viewManagerListeners.add ( listener );
    }

    @Override
    public void removeViewManagerListener ( final ViewManagerListener listener )
    {
        this.viewManagerListeners.remove ( listener );
    }

    @Override
    public void reloadCurrentView ()
    {
        if ( this.currentInstance != null )
        {
            this.currentInstance.reload ();
        }
    }

    @Override
    public void registerMenuManager ( final MenuManager menuManager )
    {
        updateSelection ();
        getSite ().registerContextMenu ( menuManager, this.selectionProvider );
    }
}
