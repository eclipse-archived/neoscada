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
package org.eclipse.scada.ca.ui.editor.config;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.eclipse.scada.ui.databinding.observable.ObservableMapContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;

public class BasicEditor extends AbstractConfigurationEditor
{
    public static final String EDITOR_ID = "org.eclipse.scada.ca.ui.connection.editors.BasicEditor";

    private TableViewer viewer;

    private final Action deleteAction;

    public BasicEditor ()
    {
        this ( false );
    }

    public BasicEditor ( final boolean nested )
    {
        super ( nested );
        this.deleteAction = new Action ( "Delete" ) {
            @Override
            public void run ()
            {
                handleDelete ();
            };
        };
    }

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        setPartName ( input.toString () );
        setSite ( site );
        try
        {
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
        super.setInput ( input );

        createViewer ();
    }

    private void createViewer ()
    {
        if ( getEditorInput () != null && this.viewer != null )
        {
            this.viewer.setInput ( getEditorInput ().getDataMap () );
            this.viewer.setLabelProvider ( new ConfigurationCellLabelProvider () );

        }
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.viewer = new TableViewer ( parent, SWT.FULL_SELECTION | SWT.MULTI );

        final TableLayout tableLayout = new TableLayout ();
        this.viewer.getTable ().setLayout ( tableLayout );

        TableViewerColumn col;

        col = new TableViewerColumn ( this.viewer, SWT.NONE );
        col.setLabelProvider ( new ConfigurationCellLabelProvider () );
        col.getColumn ().setText ( "Key" );
        tableLayout.addColumnData ( new ColumnWeightData ( 100, true ) );

        col = new TableViewerColumn ( this.viewer, SWT.NONE );
        col.setLabelProvider ( new ConfigurationCellLabelProvider () );
        col.getColumn ().setText ( "Value" );
        tableLayout.addColumnData ( new ColumnWeightData ( 200, true ) );

        this.viewer.getTable ().setHeaderVisible ( true );

        this.viewer.setContentProvider ( new ObservableMapContentProvider () );
        createViewer ();

        this.viewer.setSorter ( new ViewerSorter () );

        this.viewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                triggerEditDialog ( event.getSelection () );
            }
        } );

        getSite ().setSelectionProvider ( this.viewer );

        hookContextMenu ( getEditorSite () );
    }

    protected void triggerEditDialog ( final ISelection selection )
    {
        if ( selection.isEmpty () || ! ( selection instanceof IStructuredSelection ) )
        {
            return;
        }

        final Object o = ( (IStructuredSelection)selection ).getFirstElement ();
        final Map.Entry<?, ?> entry = AdapterHelper.adapt ( o, Map.Entry.class );
        if ( entry == null )
        {
            return;
        }

        final EntryEditDialog dlg = new EntryEditDialog ( getSite ().getShell (), entry );
        if ( dlg.open () == Window.OK )
        {
            updateEntry ( "" + entry.getKey (), dlg.getKey (), dlg.getValue () );
        }
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    protected void handleInsert ()
    {
        final EntryEditDialog dlg = new EntryEditDialog ( getSite ().getShell (), null );
        if ( dlg.open () == Window.OK )
        {
            insertEntry ( dlg.getKey (), dlg.getValue () );
        }
    }

    protected void handleDelete ()
    {
        final ISelection sel = this.viewer.getSelection ();
        if ( sel == null || sel.isEmpty () || ! ( sel instanceof IStructuredSelection ) )
        {
            return;
        }

        final IStructuredSelection selection = (IStructuredSelection)sel;

        final Iterator<?> i = selection.iterator ();
        while ( i.hasNext () )
        {
            final Object o = i.next ();
            final Map.Entry<?, ?> entry = AdapterHelper.adapt ( o, Map.Entry.class );
            if ( entry != null )
            {
                deleteEntry ( "" + entry.getKey () );
            }
        }
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

    public void contribueTo ( final IEditorSite viewSite )
    {
        hookContextMenu ( viewSite );
    }

}
