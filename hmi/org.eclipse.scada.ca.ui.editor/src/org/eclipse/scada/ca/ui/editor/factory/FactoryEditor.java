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
package org.eclipse.scada.ca.ui.editor.factory;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.ca.ui.data.ConfigurationDescriptor;
import org.eclipse.scada.ca.ui.editor.EditorHelper;
import org.eclipse.scada.ca.ui.editor.input.FactoryEditorInput;
import org.eclipse.scada.ca.ui.jobs.LoadFactoryJob;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class FactoryEditor extends EditorPart
{
    public static final String EDITOR_ID = "org.eclipse.scada.ca.ui.connection.editors.FactoryEditor";

    private TableViewer viewer;

    private FactoryInformation factory;

    private final Action deleteAction;

    private FactoryEditorInput factoryInput;

    public FactoryEditor ()
    {
        this.deleteAction = new Action ( "Delete" ) {
            @Override
            public void run ()
            {
                handleDelete ();
            };
        };

    }

    @Override
    public void doSave ( final IProgressMonitor monitor )
    {
        // no save
    }

    @Override
    public void doSaveAs ()
    {
        // no save
    }

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        try
        {
            setPartName ( input.toString () );
            setSite ( site );
            setInput ( input );
        }
        catch ( final Exception e )
        {
            throw new PartInitException ( "Failed to initialize editor", e );
        }
    }

    @Override
    protected void setInput ( final IEditorInput input )
    {
        this.factoryInput = (FactoryEditorInput)input;

        refresh ();

        super.setInput ( input );
    }

    public void refresh ()
    {
        final LoadFactoryJob job = this.factoryInput.createLoadJob ();
        job.addJobChangeListener ( new JobChangeAdapter () {
            @Override
            public void done ( final IJobChangeEvent event )
            {
                FactoryEditor.this.handleSetResult ( job.getFactory (), FactoryEditor.this.factoryInput.getConnectionUri () );
            }
        } );
        job.schedule ();
    }

    protected void handleSetResult ( final FactoryInformation factory, final String connectionUri )
    {
        final Display display = getSite ().getShell ().getDisplay ();
        if ( !display.isDisposed () )
        {
            display.asyncExec ( new Runnable () {

                @Override
                public void run ()
                {
                    if ( !display.isDisposed () )
                    {
                        setResult ( factory, connectionUri );
                    }
                }
            } );
        }
    }

    protected void setResult ( final FactoryInformation factory, final String connectionUri )
    {
        this.factory = factory;
        if ( this.viewer != null && !this.viewer.getControl ().isDisposed () )
        {
            this.viewer.setInput ( convert ( factory.getConfigurations (), connectionUri ) );
        }
    }

    private ConfigurationDescriptor[] convert ( final List<ConfigurationInformation> configurations, final String connectionUri )
    {
        if ( configurations == null )
        {
            return null;
        }

        final ConfigurationDescriptor[] result = new ConfigurationDescriptor[configurations.size ()];
        for ( int i = 0; i < configurations.size (); i++ )
        {
            final ConfigurationDescriptor newEntry = new ConfigurationDescriptor ();
            final ConfigurationInformation entry = configurations.get ( i );

            newEntry.setConfigurationInformation ( entry );
            newEntry.setConnectionUri ( connectionUri );

            result[i] = newEntry;

        }
        return result;
    }

    @Override
    public boolean isDirty ()
    {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed ()
    {
        return false;
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );
        final GridLayout layout = new GridLayout ();
        layout.marginHeight = layout.marginWidth = 0;
        wrapper.setLayout ( layout );

        this.viewer = new TableViewer ( wrapper, SWT.FULL_SELECTION | SWT.MULTI );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        final TableLayout tableLayout = new TableLayout ();
        this.viewer.getTable ().setLayout ( tableLayout );

        TableViewerColumn col;
        col = new TableViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( "ID" );
        col.setLabelProvider ( new FactoryCellLabelProvider () );
        tableLayout.addColumnData ( new ColumnWeightData ( 100, true ) );

        col = new TableViewerColumn ( this.viewer, SWT.NONE );
        col.getColumn ().setText ( "State" );
        col.setLabelProvider ( new FactoryCellLabelProvider () );
        tableLayout.addColumnData ( new ColumnWeightData ( 100, true ) );

        this.viewer.getTable ().setHeaderVisible ( true );

        this.viewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                FactoryEditor.this.handleDoubleClick ( event );
            }
        } );

        this.viewer.setContentProvider ( new ArrayContentProvider () );
        if ( this.factory != null )
        {
            this.viewer.setInput ( this.factory.getConfigurations () );
        }

        this.viewer.setComparator ( new ViewerComparator () {
            @Override
            public int compare ( final Viewer viewer, final Object e1, final Object e2 )
            {
                final ConfigurationDescriptor d1 = (ConfigurationDescriptor)e1;
                final ConfigurationDescriptor d2 = (ConfigurationDescriptor)e2;
                return d1.getConfigurationInformation ().getId ().compareTo ( d2.getConfigurationInformation ().getId () );
            }
        } );

        ColumnViewerToolTipSupport.enableFor ( this.viewer );

        getSite ().setSelectionProvider ( this.viewer );

        hookContextMenu ( getEditorSite () );
    }

    protected void handleDoubleClick ( final DoubleClickEvent event )
    {
        EditorHelper.handleOpen ( getSite ().getPage (), event.getSelection () );
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    public void handleInsert ()
    {
        final InputDialog dlg = new InputDialog ( getSite ().getShell (), "Create new configuration", "Enter the id of the new configuration object to create", "", null );
        if ( dlg.open () == Window.OK )
        {
            insertEntry ( dlg.getValue () );
        }
    }

    private void insertEntry ( final String value )
    {
        final Job job = this.factoryInput.createCreateJob ( value );
        job.addJobChangeListener ( new JobChangeAdapter () {
            @Override
            public void done ( final IJobChangeEvent event )
            {
                refresh ();
            }
        } );
        job.schedule ();
    }

    public void handleDelete ()
    {
        final ISelection sel = this.viewer.getSelection ();
        if ( sel == null || sel.isEmpty () || ! ( sel instanceof IStructuredSelection ) )
        {
            return;
        }

        final IStructuredSelection selection = (IStructuredSelection)sel;

        final Collection<String> items = new LinkedList<String> ();

        final Iterator<?> i = selection.iterator ();
        while ( i.hasNext () )
        {
            final ConfigurationDescriptor info = (ConfigurationDescriptor)i.next ();
            items.add ( info.getConfigurationInformation ().getId () );
        }

        if ( items.isEmpty () )
        {
            return;
        }

        if ( !MessageDialog.openConfirm ( this.viewer.getControl ().getShell (), "Delete configurations", String.format ( "Delete %s configuration entries", items.size () ) ) )
        {
            return;
        }

        final org.eclipse.core.runtime.jobs.Job job = this.factoryInput.createDeleteJob ( items );
        job.addJobChangeListener ( new JobChangeAdapter () {

            @Override
            public void done ( final IJobChangeEvent event )
            {
                refresh ();
            }

        } );
        job.schedule ();
    }

    // editor actions

    private void hookContextMenu ( final IEditorSite editorSite )
    {
        final MenuManager menuMgr = new MenuManager ( "#PopupMenu" ); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown ( true );
        menuMgr.addMenuListener ( new IMenuListener () {
            @Override
            public void menuAboutToShow ( final IMenuManager manager )
            {
                fillContextMenu ( manager );
            }
        } );
        final Menu menu = menuMgr.createContextMenu ( this.viewer.getControl () );
        this.viewer.getControl ().setMenu ( menu );
        editorSite.registerContextMenu ( menuMgr, this.viewer );
    }

    private void fillContextMenu ( final IMenuManager manager )
    {
        // Other plug-ins can contribute there actions here

        manager.add ( this.deleteAction );
        manager.add ( new Separator () );
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }
}
