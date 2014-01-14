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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.eclipse.scada.ui.databinding.ObservableMapStyledCellLabelProvider;
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

        if ( this.entries != null )
        {
            this.entries.dispose ();
        }
    }

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" );

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
            col.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( PojoProperties.value ( ArchiveEntry.PROP_TIMESTAMP ).observeDetail ( this.contentProvider.getKnownElements () ) ) {
                @Override
                public void update ( final ViewerCell cell )
                {
                    final Object element = cell.getElement ();
                    final Object value = this.attributeMaps[0].get ( element );
                    if ( value instanceof Date )
                    {
                        cell.setText ( DATE_FORMAT.format ( value ) );
                    }
                    else
                    {
                        super.update ( cell );
                    }
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Value" );
            col.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( PojoProperties.value ( ArchiveEntry.PROP_VALUE ).observeDetail ( this.contentProvider.getKnownElements () ) ) );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Error" );
            col.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( PojoProperties.value ( ArchiveEntry.PROP_ERROR ).observeDetail ( this.contentProvider.getKnownElements () ) ) );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Manual" );
            col.setLabelProvider ( new ObservableMapStyledCellLabelProvider ( PojoProperties.value ( ArchiveEntry.PROP_MANUAL ).observeDetail ( this.contentProvider.getKnownElements () ) ) );
        }

        this.viewer.setInput ( this.entries );

        final TableLayout tableLayout = new TableLayout ();
        tableLayout.addColumnData ( new ColumnWeightData ( 200 ) );
        tableLayout.addColumnData ( new ColumnWeightData ( 100 ) );
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
