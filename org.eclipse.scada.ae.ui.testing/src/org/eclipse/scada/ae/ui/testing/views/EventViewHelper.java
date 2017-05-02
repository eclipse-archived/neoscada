/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IViewSite;

public class EventViewHelper
{
    public static TableViewer createTableViewer ( final Composite wrapper, final IViewSite viewSite, final IObservableSet events )
    {
        final TableViewer viewer = new TableViewer ( wrapper );

        TableColumnLayout tableLayout;
        wrapper.setLayout ( tableLayout = new TableColumnLayout () );

        TableColumn col;

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Source Timestamp" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 100 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Entry Timestamp" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 100 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Source" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 25 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Monitor Type" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 25 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Event Type" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 25 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "User" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 25 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Value" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( viewer.getTable (), SWT.NONE );
        col.setText ( "Message" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 200 ) );

        viewer.getTable ().setLayout ( new GridLayout ( 1, false ) );
        viewer.getTable ().setHeaderVisible ( true );

        viewer.setUseHashlookup ( true );
        viewer.setContentProvider ( new ObservableSetContentProvider () );
        viewer.setLabelProvider ( new EventsLabelProvider () );
        viewer.setComparator ( new EntryTimestampViewerComparator () );
        viewer.setInput ( events );

        viewSite.setSelectionProvider ( viewer );

        return viewer;
    }
}
