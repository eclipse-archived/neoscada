/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.hd.hdsspy.editors;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

public class HDSEditor extends EditorPart
{

    private TableViewer viewer;

    private WritableList entries;

    private FileLoader loader;

    private ObservableListContentProvider contentProvider;

    private EntryLabelProvider labelProvider;

    @Override
    public void doSave ( final IProgressMonitor monitor )
    {
    }

    @Override
    public void doSaveAs ()
    {
    }

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        setSite ( site );
        setInput ( input );

        final IFileEditorInput fileInput = AdapterHelper.adapt ( input, IFileEditorInput.class );
        if ( fileInput != null )
        {
            this.loader = new FileLoader ( fileInput );
            setContentDescription ( fileInput.getName () );
            setPartName ( fileInput.getName () );
        }

        if ( this.loader == null )
        {
            throw new PartInitException ( "Invalid editor input. Unable to load data" );
        }
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
    public void dispose ()
    {
        super.dispose ();

        this.labelProvider.dispose ();
        this.contentProvider.dispose ();
        if ( this.entries != null )
        {
            this.entries.dispose ();
        }
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.entries = new WritableList ( SWTObservables.getRealm ( parent.getDisplay () ) );

        this.viewer = new TableViewer ( parent, SWT.FULL_SELECTION | SWT.MULTI );
        this.viewer.getTable ().setHeaderVisible ( true );

        this.contentProvider = new ObservableListContentProvider ();
        this.viewer.setContentProvider ( this.contentProvider );

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Timestamp" );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Value" );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Error" );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Manual" );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Deleted" );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Heartbeat" );
        }

        this.viewer.setLabelProvider ( this.labelProvider = new EntryLabelProvider () );

        this.viewer.setInput ( this.entries );

        final TableLayout tableLayout = new TableLayout ();
        tableLayout.addColumnData ( new ColumnWeightData ( 200 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 100 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 25 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 25 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 25 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 25 ) );
        this.viewer.getTable ().setLayout ( tableLayout );

        this.entries.setStale ( true );
        try
        {
            this.loader.performLoad ( this.entries );
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e.getStatus (), StatusManager.BLOCK );
        }
        finally
        {
            this.entries.setStale ( false );
        }
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

}
