/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - fix table column layout
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;

public class ChartControllerView extends AbstractChartManagePart
{

    private TableViewer viewer;

    private DataBindingContext dbc;

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.dbc = new DataBindingContext ();

        parent.setLayout ( new FillLayout () );

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayout ( new FillLayout () );

        this.viewer = new TableViewer ( wrapper, SWT.FULL_SELECTION );
        this.viewer.getTable ().setHeaderVisible ( true );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTable ().setLayout ( layout );

        final ObservableListContentProvider provider = new ObservableListContentProvider ();
        this.viewer.setContentProvider ( provider );

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Input" );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_LABEL ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( ( (ChartInput)cell.getElement () ).getLabel () );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Preview" );
            col.getColumn ().setAlignment ( SWT.CENTER );
            layout.addColumnData ( new ColumnPixelData ( 50 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_PREVIEW ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    final Rectangle rect = cell.getImageBounds ();

                    if ( rect != null && rect.width > 0 && rect.height > 0 )
                    {
                        cell.setImage ( ( (ChartInput)cell.getElement () ).getPreview ( rect.width, rect.height ) );
                    }
                    else
                    {
                        cell.setImage ( ( (ChartInput)cell.getElement () ).getPreview ( 50, 20 ) );
                    }
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "State" );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_STATE ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( ( (ChartInput)cell.getElement () ).getState () );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Selected Timestamp" );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_SELECTED_TIMESTAMP ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    final Date timestamp = ( (ChartInput)cell.getElement () ).getSelectedTimestamp ();
                    cell.setText ( timestamp == null ? null : DateFormat.getDateTimeInstance ().format ( timestamp ) );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Selected Value" );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_SELECTED_VALUE ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( ( (ChartInput)cell.getElement () ).getSelectedValue () );
                }
            } );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( "Selected Quality" );
            layout.addColumnData ( new ColumnWeightData ( 100 ) );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( BeansObservables.observeMap ( provider.getRealizedElements (), ChartInput.PROP_SELECTED_QUALITY ) ) {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( ( (ChartInput)cell.getElement () ).getSelectedQuality () );
                }
            } );
        }

        getSite ().setSelectionProvider ( this.viewer );

        contribueTo ( getViewSite () );

        attachSelectionService ();
    }

    @Override
    public void dispose ()
    {
        this.dbc.dispose ();
        super.dispose ();
    }

    @Override
    protected void setChartViewer ( final ChartViewer chartViewer )
    {
        // attach
        if ( chartViewer != null )
        {
            if ( !this.viewer.getControl ().isDisposed () )
            {
                this.viewer.setInput ( chartViewer.getItems () );
            }
        }
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    private void hookContextMenu ( final IViewSite viewSite )
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
        viewSite.registerContextMenu ( menuMgr, this.viewer );
    }

    private void fillContextMenu ( final IMenuManager manager )
    {
        // Other plug-ins can contribute there actions here
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }

    public void contribueTo ( final IViewSite viewSite )
    {
        hookContextMenu ( viewSite );
    }

}
