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
package org.eclipse.scada.ui.chart.view;

import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.provider.ChartItemProviderAdapterFactory;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

public class ChartConfiguratorView extends AbstractChartManagePart implements IViewerProvider, IEditingDomainProvider, IMenuListener
{

    private TreeViewer viewer;

    private ComposedAdapterFactory factory;

    private ExtendedPropertySheetPage propertySheetPage;

    private AdapterFactoryEditingDomain editingDomain;

    private Composite container;

    private ChartActionBarContributor actionBarContributor;

    private void createEditingDomain ()
    {
        final BasicCommandStack commandStack = new BasicCommandStack ();

        this.factory = new ComposedAdapterFactory ( ComposedAdapterFactory.Descriptor.Registry.INSTANCE );

        this.factory.addAdapterFactory ( new ResourceItemProviderAdapterFactory () );
        this.factory.addAdapterFactory ( new ChartItemProviderAdapterFactory () );
        this.factory.addAdapterFactory ( new ReflectiveItemProviderAdapterFactory () );

        // Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
        //
        commandStack.addCommandStackListener ( new CommandStackListener () {
            @Override
            public void commandStackChanged ( final EventObject event )
            {
                getContainer ().getDisplay ().asyncExec ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        firePropertyChange ( IEditorPart.PROP_DIRTY );

                        // Try to select the affected objects.
                        //
                        final Command mostRecentCommand = ( (CommandStack)event.getSource () ).getMostRecentCommand ();
                        if ( mostRecentCommand != null )
                        {
                            setSelectionToViewer ( mostRecentCommand.getAffectedObjects () );
                        }
                        if ( ChartConfiguratorView.this.propertySheetPage != null && !ChartConfiguratorView.this.propertySheetPage.getControl ().isDisposed () )
                        {
                            ChartConfiguratorView.this.propertySheetPage.refresh ();
                        }
                    }
                } );
            }
        } );

        this.editingDomain = new AdapterFactoryEditingDomain ( this.factory, commandStack, new HashMap<Resource, Boolean> () );

        this.actionBarContributor = new ChartActionBarContributor ();
    }

    @Override
    public void dispose ()
    {
        this.actionBarContributor.dispose ();
        this.factory.dispose ();

        if ( this.propertySheetPage != null )
        {
            this.propertySheetPage.dispose ();
        }

        super.dispose ();
    }

    @Override
    protected void setChartViewer ( final ChartViewer chartViewer )
    {
        if ( chartViewer == null )
        {
            this.viewer.setInput ( null );
        }
        else
        {
            final Chart element = chartViewer.getChartConfiguration ();

            if ( element.eResource () == null || element.eResource ().getURI () == null )
            {
                element.eResource ().setURI ( URI.createURI ( "urn:dummy" ) );
            }

            this.viewer.setInput ( element.eResource () );
        }
    }

    protected Composite getContainer ()
    {
        return this.container;
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.container = parent;
        createEditingDomain ();

        parent.setLayout ( new FillLayout () );
        this.viewer = new TreeViewer ( parent );
        this.viewer.setAutoExpandLevel ( 2 );

        this.viewer.setContentProvider ( new AdapterFactoryContentProvider ( this.factory ) );
        this.viewer.setLabelProvider ( new AdapterFactoryLabelProvider ( this.factory ) );

        createContextMenuFor ( this.viewer );

        new AdapterFactoryTreeEditor ( this.viewer.getTree (), this.factory );
        getViewSite ().setSelectionProvider ( this.viewer );

        attachSelectionService ();

        getViewSite ().getActionBars ().getMenuManager ().add ( new Separator ( "additions" ) );

        this.actionBarContributor.init ( getViewSite ().getActionBars () );
        this.actionBarContributor.setViewPart ( this );
    }

    /**
     * This creates a context menu for the viewer and adds a listener as well
     * registering the menu for extension. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     */
    protected void createContextMenuFor ( final StructuredViewer viewer )
    {
        final MenuManager contextMenu = new MenuManager ( "#PopUp" );
        contextMenu.add ( new Separator ( "additions" ) );
        contextMenu.setRemoveAllWhenShown ( true );
        contextMenu.addMenuListener ( this );
        final Menu menu = contextMenu.createContextMenu ( viewer.getControl () );
        viewer.getControl ().setMenu ( menu );
        getSite ().registerContextMenu ( contextMenu, new UnwrappingSelectionProvider ( viewer ) );

        final int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
        final Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance () };
        viewer.addDragSupport ( dndOperations, transfers, new ViewerDragAdapter ( viewer ) );
        viewer.addDropSupport ( dndOperations, transfers, new EditingDomainViewerDropAdapter ( this.editingDomain, viewer ) );
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter.equals ( IPropertySheetPage.class ) )
        {
            return getPropertySheetPage ();
        }
        return super.getAdapter ( adapter );
    }

    /**
     * This sets the selection into whichever viewer is active. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void setSelectionToViewer ( final Collection<?> collection )
    {
        final Collection<?> theSelection = collection;
        // Make sure it's okay.
        //
        if ( theSelection != null && !theSelection.isEmpty () )
        {
            final Runnable runnable = new Runnable () {
                @Override
                public void run ()
                {
                    // Try to select the items in the current content viewer of the editor.
                    //
                    if ( ChartConfiguratorView.this.viewer != null )
                    {
                        ChartConfiguratorView.this.viewer.setSelection ( new StructuredSelection ( theSelection.toArray () ), true );
                    }
                }
            };
            getSite ().getShell ().getDisplay ().asyncExec ( runnable );
        }
    }

    /**
     * This accesses a cached version of the property sheet. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    public IPropertySheetPage getPropertySheetPage ()
    {
        if ( this.propertySheetPage == null )
        {
            this.propertySheetPage = new ExtendedPropertySheetPage ( this.editingDomain ) {
                @Override
                public void setSelectionToViewer ( final List<?> selection )
                {
                    ChartConfiguratorView.this.setSelectionToViewer ( selection );
                    ChartConfiguratorView.this.setFocus ();
                }

                @Override
                public void setActionBars ( final IActionBars actionBars )
                {
                    super.setActionBars ( actionBars );
                    // getActionBarContributor ().shareGlobalActions ( this, actionBars );
                }
            };
            this.propertySheetPage.setPropertySourceProvider ( new AdapterFactoryContentProvider ( this.factory ) );
        }

        return this.propertySheetPage;
    }

    @Override
    public EditingDomain getEditingDomain ()
    {
        return this.editingDomain;
    }

    @Override
    public Viewer getViewer ()
    {
        return this.viewer;
    }

    @Override
    public void menuAboutToShow ( final IMenuManager manager )
    {
        this.actionBarContributor.menuAboutToShow ( manager );
    }

}
