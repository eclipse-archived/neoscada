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
package org.eclipse.scada.ui.chart.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.scada.ui.chart.model.Chart;

public class ChartActionBarContributor extends EditingDomainActionBarContributor implements ISelectionChangedListener
{

    public static class SaveAsAction extends BaseSelectionListenerAction
    {
        private Chart chart;

        public SaveAsAction ()
        {
            super ( "Save as…" );
        }

        @Override
        public void run ()
        {
            if ( this.chart == null )
            {
                return;
            }

            final Shell shell = PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell ();

            final FileDialog dlg = new FileDialog ( shell, SWT.SAVE );
            dlg.setFilterExtensions ( new String[] { "*.chart" } );
            dlg.setFilterNames ( new String[] { "Eclipse SCADA Chart Configuration" } );
            dlg.setOverwrite ( true );
            dlg.setText ( "Select the file to store the chart configurationt to" );

            final String file = dlg.open ();

            if ( file != null )
            {
                new Job ( "Perform save" ) {
                    @Override
                    protected org.eclipse.core.runtime.IStatus run ( final org.eclipse.core.runtime.IProgressMonitor monitor )
                    {
                        try
                        {
                            doSave ( file );
                        }
                        catch ( final IOException e )
                        {
                            return StatusHelper.convertStatus ( Activator.PLUGIN_ID, e );
                        }
                        finally
                        {
                            monitor.done ();
                        }
                        return Status.OK_STATUS;
                    };
                }.schedule ();
            }
        }

        private void doSave ( final String file ) throws IOException
        {
            final ResourceSet rs = new ResourceSetImpl ();

            rs.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new XMLResourceFactoryImpl () ); //$NON-NLS-1$
            final URI fileUri = URI.createFileURI ( file );
            final Resource resource = rs.createResource ( fileUri );
            resource.getContents ().add ( this.chart );

            final Map<Object, Object> options = new HashMap<Object, Object> ();
            //             options.put ( XMIResource., value )
            resource.save ( options );
        }

        @Override
        protected boolean updateSelection ( final IStructuredSelection selection )
        {
            this.chart = null;

            if ( selection.isEmpty () )
            {
                return false;
            }
            final Object o = selection.getFirstElement ();
            if ( ! ( o instanceof Chart ) )
            {
                return false;
            }

            this.chart = (Chart)o;

            return true;
        }
    }

    /**
     * This keeps track of the active editor. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IViewPart activeEditorPart;

    /**
     * This keeps track of the current selection provider. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ISelectionProvider selectionProvider;

    /**
     * This action opens the Properties view. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IAction showPropertiesViewAction = new Action ( "Show &Properties View" ) {
        @Override
        public void run ()
        {
            try
            {
                getPage ().showView ( "org.eclipse.ui.views.PropertySheet" ); //$NON-NLS-1$
            }
            catch ( final PartInitException exception )
            {
                StatusManager.getManager ().handle ( exception.getStatus (), StatusManager.LOG );
            }
        }
    };

    protected SaveAsAction saveAsAction = new SaveAsAction ();

    /**
     * This action refreshes the viewer of the current editor if the editor implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IAction refreshViewerAction = new Action ( "&Refresh" ) {
        @Override
        public boolean isEnabled ()
        {
            return ChartActionBarContributor.this.activeEditorPart instanceof IViewerProvider;
        }

        @Override
        public void run ()
        {
            if ( ChartActionBarContributor.this.activeEditorPart instanceof IViewerProvider )
            {
                final Viewer viewer = ( (IViewerProvider)ChartActionBarContributor.this.activeEditorPart ).getViewer ();
                if ( viewer != null )
                {
                    viewer.refresh ();
                }
            }
        }
    };

    /**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor generated for the current selection by the item provider. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> createChildActions;

    /**
     * This is the menu manager into which menu contribution items should be added for CreateChild actions. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IMenuManager createChildMenuManager;

    /**
     * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor generated for the current selection by the item provider. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> createSiblingActions;

    /**
     * This is the menu manager into which menu contribution items should be added for CreateSibling actions. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IMenuManager createSiblingMenuManager;

    /**
     * This creates an instance of the contributor. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ChartActionBarContributor ()
    {
        super ( ADDITIONS_LAST_STYLE );
        this.loadResourceAction = new LoadResourceAction ();
        this.validateAction = new ValidateAction ();
        this.controlAction = new ControlAction ();
    }

    /**
     * This adds Separators for editor additions to the tool bar. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void contributeToToolBar ( final IToolBarManager toolBarManager )
    {
        toolBarManager.add ( new Separator ( "chart-settings" ) );
        toolBarManager.add ( new Separator ( "chart-additions" ) );
    }

    /**
     * This adds to the menu bar a menu and some separators for editor additions, as well as the sub-menus for object creation items. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void contributeToMenu ( final IMenuManager menuManager )
    {
        super.contributeToMenu ( menuManager );

        final IMenuManager submenuManager = new MenuManager ( "&Chart Editor", "org.eclipse.scada.ui.chart.model.model.ChartModelMenuID" );
        menuManager.insertAfter ( "additions", submenuManager );
        submenuManager.add ( new Separator ( "settings" ) );
        submenuManager.add ( new Separator ( "actions" ) );
        submenuManager.add ( new Separator ( "additions" ) );
        submenuManager.add ( new Separator ( "additions-end" ) );

        // Prepare for CreateChild item addition or removal.
        //
        this.createChildMenuManager = new MenuManager ( "&New Child" );
        submenuManager.insertBefore ( "additions", this.createChildMenuManager );

        // Prepare for CreateSibling item addition or removal.
        //
        this.createSiblingMenuManager = new MenuManager ( "N&ew Sibling" );
        submenuManager.insertBefore ( "additions", this.createSiblingMenuManager );

        // Force an update because Eclipse hides empty menus now.
        //
        submenuManager.addMenuListener ( new IMenuListener () {
            @Override
            public void menuAboutToShow ( final IMenuManager menuManager )
            {
                menuManager.updateAll ( true );
            }
        } );

        addGlobalActions ( submenuManager );
    }

    public void setViewPart ( final IViewPart part )
    {

        if ( part != this.activeEditorPart )
        {
            if ( this.activeEditorPart != null )
            {
                deactivate ();
            }

            if ( part instanceof IEditingDomainProvider )
            {
                this.activeEditorPart = part;
                activate ();
            }
        }

        // Switch to the new selection provider.
        //
        if ( this.selectionProvider != null )
        {
            this.selectionProvider.removeSelectionChangedListener ( this );
        }
        if ( part == null )
        {
            this.selectionProvider = null;
        }
        else
        {
            this.selectionProvider = part.getSite ().getSelectionProvider ();
            this.selectionProvider.addSelectionChangedListener ( this );

            this.deleteAction.setActiveWorkbenchPart ( part );

            // Fake a selection changed event to update the menus.
            //
            if ( this.selectionProvider.getSelection () != null )
            {
                selectionChanged ( new SelectionChangedEvent ( this.selectionProvider, this.selectionProvider.getSelection () ) );
            }
        }
    }

    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener}, handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings that can
     * be added to the selected object and updating the menus accordingly. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void selectionChanged ( final SelectionChangedEvent event )
    {
        // Remove any menu items for old selection.
        //
        if ( this.createChildMenuManager != null )
        {
            depopulateManager ( this.createChildMenuManager, this.createChildActions );
        }
        if ( this.createSiblingMenuManager != null )
        {
            depopulateManager ( this.createSiblingMenuManager, this.createSiblingActions );
        }

        // Query the new selection for appropriate new child/sibling descriptors
        //
        Collection<?> newChildDescriptors = null;
        Collection<?> newSiblingDescriptors = null;

        final ISelection selection = event.getSelection ();
        if ( selection instanceof IStructuredSelection && ( (IStructuredSelection)selection ).size () == 1 )
        {
            final Object object = ( (IStructuredSelection)selection ).getFirstElement ();

            final EditingDomain domain = ( (IEditingDomainProvider)this.activeEditorPart ).getEditingDomain ();

            newChildDescriptors = domain.getNewChildDescriptors ( object, null );
            newSiblingDescriptors = domain.getNewChildDescriptors ( null, object );
        }

        // Generate actions for selection; populate and redraw the menus.
        //
        this.createChildActions = generateCreateChildActions ( newChildDescriptors, selection );
        this.createSiblingActions = generateCreateSiblingActions ( newSiblingDescriptors, selection );

        if ( this.createChildMenuManager != null )
        {
            populateManager ( this.createChildMenuManager, this.createChildActions, null );
            this.createChildMenuManager.update ( true );
        }
        if ( this.createSiblingMenuManager != null )
        {
            populateManager ( this.createSiblingMenuManager, this.createSiblingActions, null );
            this.createSiblingMenuManager.update ( true );
        }
    }

    /**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>, and returns the collection of these actions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> generateCreateChildActions ( final Collection<?> descriptors, final ISelection selection )
    {
        final Collection<IAction> actions = new ArrayList<IAction> ();
        if ( descriptors != null )
        {
            for ( final Object descriptor : descriptors )
            {
                actions.add ( new CreateChildAction ( this.activeEditorPart, selection, descriptor ) );
            }
        }
        return actions;
    }

    /**
     * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>, and returns the collection of these actions. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<IAction> generateCreateSiblingActions ( final Collection<?> descriptors, final ISelection selection )
    {
        final Collection<IAction> actions = new ArrayList<IAction> ();
        if ( descriptors != null )
        {
            for ( final Object descriptor : descriptors )
            {
                actions.add ( new CreateSiblingAction ( this.activeEditorPart, selection, descriptor ) );
            }
        }
        return actions;
    }

    /**
     * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s based on the {@link org.eclipse.jface.action.IAction}s contained in the
     * <code>actions</code> collection, by inserting them before the specified contribution item <code>contributionID</code>. If <code>contributionID</code> is <code>null</code>, they are simply
     * added. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void populateManager ( final IContributionManager manager, final Collection<? extends IAction> actions, final String contributionID )
    {
        if ( actions != null )
        {
            for ( final IAction action : actions )
            {
                if ( contributionID != null )
                {
                    manager.insertBefore ( contributionID, action );
                }
                else
                {
                    manager.add ( action );
                }
            }
        }
    }

    /**
     * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s based on the {@link org.eclipse.jface.action.IAction}s contained in the
     * <code>actions</code> collection. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void depopulateManager ( final IContributionManager manager, final Collection<? extends IAction> actions )
    {
        if ( actions != null )
        {
            final IContributionItem[] items = manager.getItems ();
            for ( int i = 0; i < items.length; i++ )
            {
                // Look into SubContributionItems
                //
                IContributionItem contributionItem = items[i];
                while ( contributionItem instanceof SubContributionItem )
                {
                    contributionItem = ( (SubContributionItem)contributionItem ).getInnerItem ();
                }

                // Delete the ActionContributionItems with matching action.
                //
                if ( contributionItem instanceof ActionContributionItem )
                {
                    final IAction action = ( (ActionContributionItem)contributionItem ).getAction ();
                    if ( actions.contains ( action ) )
                    {
                        manager.remove ( contributionItem );
                    }
                }
            }
        }
    }

    /**
     * This populates the pop-up menu before it appears. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void menuAboutToShow ( final IMenuManager menuManager )
    {
        super.menuAboutToShow ( menuManager );
        MenuManager submenuManager = null;

        submenuManager = new MenuManager ( "&New Child" );
        populateManager ( submenuManager, this.createChildActions, null );
        menuManager.insertBefore ( "edit", submenuManager );

        submenuManager = new MenuManager ( "N&ew Sibling" );
        populateManager ( submenuManager, this.createSiblingActions, null );
        menuManager.insertBefore ( "edit", submenuManager );
    }

    /**
     * This inserts global actions before the "additions-end" separator. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void addGlobalActions ( final IMenuManager menuManager )
    {
        menuManager.insertAfter ( "additions-end", new Separator ( "ui-actions" ) );
        menuManager.insertAfter ( "ui-actions", this.showPropertiesViewAction );

        this.refreshViewerAction.setEnabled ( this.refreshViewerAction.isEnabled () );
        menuManager.insertAfter ( "ui-actions", this.refreshViewerAction );
        menuManager.insertAfter ( "ui-actions", this.saveAsAction );

        super.addGlobalActions ( menuManager );
    }

    /**
     * This ensures that a delete action will clean up all references to deleted objects. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected boolean removeAllReferencesOnDelete ()
    {
        return true;
    }

    // override using view part

    @Override
    public void deactivate ()
    {
        this.activeEditor.removePropertyListener ( this );

        this.deleteAction.setActiveWorkbenchPart ( null );
        this.cutAction.setActiveWorkbenchPart ( null );
        this.copyAction.setActiveWorkbenchPart ( null );
        this.pasteAction.setActiveWorkbenchPart ( null );
        this.undoAction.setActiveWorkbenchPart ( null );
        this.redoAction.setActiveWorkbenchPart ( null );

        if ( this.loadResourceAction != null )
        {
            this.loadResourceAction.setActiveWorkbenchPart ( null );
        }

        if ( this.controlAction != null )
        {
            this.controlAction.setActiveWorkbenchPart ( null );
        }

        if ( this.validateAction != null )
        {
            this.validateAction.setActiveWorkbenchPart ( null );
        }

        final ISelectionProvider selectionProvider = this.activeEditorPart instanceof ISelectionProvider ? (ISelectionProvider)this.activeEditorPart : this.activeEditorPart.getSite ().getSelectionProvider ();

        if ( selectionProvider != null )
        {
            selectionProvider.removeSelectionChangedListener ( this.deleteAction );
            selectionProvider.removeSelectionChangedListener ( this.cutAction );
            selectionProvider.removeSelectionChangedListener ( this.copyAction );
            selectionProvider.removeSelectionChangedListener ( this.pasteAction );

            if ( this.validateAction != null )
            {
                selectionProvider.removeSelectionChangedListener ( this.validateAction );
            }

            if ( this.controlAction != null )
            {
                selectionProvider.removeSelectionChangedListener ( this.controlAction );
            }

            if ( this.saveAsAction != null )
            {
                selectionProvider.removeSelectionChangedListener ( this.saveAsAction );
            }
        }
    }

    @Override
    public void activate ()
    {
        this.activeEditorPart.addPropertyListener ( this );

        this.deleteAction.setActiveWorkbenchPart ( this.activeEditorPart );
        this.cutAction.setActiveWorkbenchPart ( this.activeEditorPart );
        this.copyAction.setActiveWorkbenchPart ( this.activeEditorPart );
        this.pasteAction.setActiveWorkbenchPart ( this.activeEditorPart );
        this.undoAction.setActiveWorkbenchPart ( this.activeEditorPart );
        this.redoAction.setActiveWorkbenchPart ( this.activeEditorPart );

        if ( this.loadResourceAction != null )
        {
            this.loadResourceAction.setActiveWorkbenchPart ( this.activeEditorPart );
        }

        if ( this.controlAction != null )
        {
            this.controlAction.setActiveWorkbenchPart ( this.activeEditorPart );
        }

        if ( this.validateAction != null )
        {
            this.validateAction.setActiveWorkbenchPart ( this.activeEditorPart );
        }

        final ISelectionProvider selectionProvider = this.activeEditorPart instanceof ISelectionProvider ? (ISelectionProvider)this.activeEditorPart : this.activeEditorPart.getSite ().getSelectionProvider ();

        if ( selectionProvider != null )
        {
            selectionProvider.addSelectionChangedListener ( this.deleteAction );
            selectionProvider.addSelectionChangedListener ( this.cutAction );
            selectionProvider.addSelectionChangedListener ( this.copyAction );
            selectionProvider.addSelectionChangedListener ( this.pasteAction );

            if ( this.validateAction != null )
            {
                selectionProvider.addSelectionChangedListener ( this.validateAction );
            }

            if ( this.controlAction != null )
            {
                selectionProvider.addSelectionChangedListener ( this.controlAction );
            }

            if ( this.saveAsAction != null )
            {
                selectionProvider.addSelectionChangedListener ( this.saveAsAction );
            }
        }

        update ();
    }

    @Override
    public void update ()
    {
        final ISelectionProvider selectionProvider = this.activeEditorPart instanceof ISelectionProvider ? (ISelectionProvider)this.activeEditorPart : this.activeEditorPart.getSite ().getSelectionProvider ();

        if ( selectionProvider != null )
        {
            final ISelection selection = selectionProvider.getSelection ();
            final IStructuredSelection structuredSelection = selection instanceof IStructuredSelection ? (IStructuredSelection)selection : StructuredSelection.EMPTY;

            this.deleteAction.updateSelection ( structuredSelection );
            this.cutAction.updateSelection ( structuredSelection );
            this.copyAction.updateSelection ( structuredSelection );
            this.pasteAction.updateSelection ( structuredSelection );

            if ( this.validateAction != null )
            {
                this.validateAction.updateSelection ( structuredSelection );
            }

            if ( this.controlAction != null )
            {
                this.controlAction.updateSelection ( structuredSelection );
            }

            if ( this.saveAsAction != null )
            {
                this.saveAsAction.selectionChanged ( structuredSelection );
            }
        }

        this.undoAction.update ();
        this.redoAction.update ();

        if ( this.loadResourceAction != null )
        {
            this.loadResourceAction.update ();
        }
    }
}