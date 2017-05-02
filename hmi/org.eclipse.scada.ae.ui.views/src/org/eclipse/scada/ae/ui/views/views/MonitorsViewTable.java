/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.views.Messages;
import org.eclipse.scada.ae.ui.views.Settings;
import org.eclipse.scada.ae.ui.views.model.DecoratedMonitor;
import org.eclipse.scada.core.Variant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;

public class MonitorsViewTable extends Composite
{
    private static final String COLUMN_KEY = "org.eclipse.scada.ae.ui.views.views.MonitorsViewTable" + ".column.key"; //$NON-NLS-1$ //$NON-NLS-2$

    private static final Date DEFAULT_DATE = new Date ( 0 );

    private enum Columns
    {
        ID,
        STATE,
        LAST_FAIL_TIMESTAMP,
        LAST_FAIL_VALUE,
        VALUE,
        ACK_USER,
        ACK_TIMESTAMP,
        ITEM,
        ITEM_DESCRIPTION,
        MESSAGE,
        STATUS_TIMESTAMP,
        SEVERITY;
    }

    private static class Sorter extends ViewerSorter
    {
        private final Columns column;

        private final int dir;

        public Sorter ( final Columns column, final int dir )
        {
            this.column = column;
            this.dir = dir;
        }

        @SuppressWarnings ( { "unchecked", "rawtypes" } )
        @Override
        public int compare ( final Viewer viewer, final Object e1, final Object e2 )
        {
            final MonitorStatusInformation m1 = ( (DecoratedMonitor)e1 ).getMonitor ();
            final MonitorStatusInformation m2 = ( (DecoratedMonitor)e2 ).getMonitor ();
            Comparable v1 = 0;
            Comparable v2 = 0;
            switch ( this.column )
            {
                case ID:
                    v1 = m1.getId ();
                    v2 = m2.getId ();
                    break;
                case STATE:
                    v1 = m1.getStatus ();
                    v2 = m2.getStatus ();
                    break;
                case VALUE:
                    v1 = m1.getValue () == null ? Variant.NULL : m1.getValue ();
                    v2 = m2.getValue () == null ? Variant.NULL : m2.getValue ();
                    break;
                case LAST_FAIL_TIMESTAMP:
                    v1 = m1.getLastFailTimestamp ();
                    v2 = m2.getLastFailTimestamp ();
                    break;
                case LAST_FAIL_VALUE:
                    v1 = m1.getLastFailValue () == null ? Variant.NULL : m1.getLastFailValue ();
                    v2 = m2.getLastFailValue () == null ? Variant.NULL : m2.getLastFailValue ();
                    break;
                case ACK_USER:
                    v1 = m1.getLastAknUser () == null ? "" : m1.getLastAknUser (); //$NON-NLS-1$
                    v2 = m2.getLastAknUser () == null ? "" : m2.getLastAknUser (); //$NON-NLS-1$
                    break;
                case ACK_TIMESTAMP:
                    v1 = m1.getLastAknTimestamp () == null ? DEFAULT_DATE : m1.getLastAknTimestamp ();
                    v2 = m2.getLastAknTimestamp () == null ? DEFAULT_DATE : m2.getLastAknTimestamp ();
                    break;
                case ITEM:
                    v1 = m1.getAttributes ().get ( "item" ) == null ? Variant.NULL : m1.getAttributes ().get ( "item" ); //$NON-NLS-1$ //$NON-NLS-2$
                    v2 = m2.getAttributes ().get ( "item" ) == null ? Variant.NULL : m2.getAttributes ().get ( "item" ); //$NON-NLS-1$ //$NON-NLS-2$
                    break;
                case ITEM_DESCRIPTION:
                    v1 = m1.getAttributes ().get ( "itemDescription" ) == null ? Variant.NULL : m1.getAttributes ().get ( "itemDescription" ); //$NON-NLS-1$ //$NON-NLS-2$
                    v2 = m2.getAttributes ().get ( "itemDescription" ) == null ? Variant.NULL : m2.getAttributes ().get ( "itemDescription" ); //$NON-NLS-1$ //$NON-NLS-2$
                    break;
                case MESSAGE:
                    v1 = m1.getAttributes ().get ( "message" ) == null ? Variant.NULL : m1.getAttributes ().get ( "message" ); //$NON-NLS-1$ //$NON-NLS-2$
                    v2 = m2.getAttributes ().get ( "message" ) == null ? Variant.NULL : m2.getAttributes ().get ( "message" ); //$NON-NLS-1$ //$NON-NLS-2$
                    break;
                case STATUS_TIMESTAMP:
                    v1 = m1.getStatusTimestamp ();
                    v2 = m2.getStatusTimestamp ();
                    break;
                case SEVERITY:
                    v1 = m1.getSeverity ();
                    v2 = m2.getSeverity ();
                    break;
            }
            if ( v1 == v2 )
            {
                return 0;
            }
            if ( v1 == null )
            {
                return -1;
            }
            if ( v2 == null )
            {
                return 1;
            }
            // first compare the given column
            int result = v1.compareTo ( v2 );
            // use given order for sorting
            result = this.dir == SWT.DOWN ? -result : result;
            // if values are the same, order by timestamp in descending order
            if ( this.column != Columns.LAST_FAIL_TIMESTAMP && result == 0 )
            {
                result = Long.valueOf ( m2.getStatusTimestamp () ).compareTo ( m1.getStatusTimestamp () );
            }
            // if values are still the same, order by id in ascending order
            if ( this.column != Columns.ID && result == 0 )
            {
                result = m1.getId ().compareTo ( m2.getId () );
            }
            return result;
        }
    }

    private static class SortListener extends SelectionAdapter
    {
        private final TableViewer tableViewer;

        public SortListener ( final TableViewer tableViewer )
        {
            this.tableViewer = tableViewer;
        }

        @Override
        public void widgetSelected ( final SelectionEvent e )
        {
            final Table table = this.tableViewer.getTable ();
            final TableColumn newColumn = (TableColumn)e.widget;
            final TableColumn currentColumn = table.getSortColumn ();

            final int currentDir = table.getSortDirection ();
            int newDir = SWT.UP;
            if ( newColumn == currentColumn )
            {
                newDir = currentDir == SWT.UP ? SWT.DOWN : SWT.UP;
            }
            else
            {
                table.setSortColumn ( newColumn );
            }
            table.setSortDirection ( newDir );
            this.tableViewer.setSorter ( new Sorter ( (Columns)newColumn.getData ( COLUMN_KEY ), newDir ) );
        }
    }

    private final AtomicReference<TableViewer> tableRef = new AtomicReference<TableViewer> ( null );

    private final WritableSet monitors;

    private final TableViewer tableViewer;

    private volatile boolean scrollLock = false;

    public MonitorsViewTable ( final Composite parent, final IViewSite viewSite, final int style, final WritableSet monitors, final List<ColumnProperties> columnSettings )
    {
        super ( parent, style );

        this.monitors = monitors;

        final FillLayout layout = new FillLayout ();
        setLayout ( layout );

        this.tableViewer = new TableViewer ( this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI );
        this.tableRef.set ( this.tableViewer );
        createColumns ( this.tableViewer );
        applyColumSettings ( columnSettings );
        this.tableViewer.getTable ().setHeaderVisible ( true );
        this.tableViewer.getTable ().setLinesVisible ( true );
        this.tableViewer.setUseHashlookup ( true );
        this.tableViewer.setSorter ( new Sorter ( Columns.LAST_FAIL_TIMESTAMP, SWT.DOWN ) );
        this.tableViewer.getTable ().setSortDirection ( SWT.DOWN );

        hookContextMenu ( this.tableViewer.getControl (), this.tableViewer, viewSite );

        viewSite.setSelectionProvider ( this.tableViewer );

        final ObservableSetContentProvider contentProvider = new ObservableSetContentProvider ();
        this.tableViewer.setContentProvider ( contentProvider );
        this.tableViewer.setLabelProvider ( new MonitorTableLabelProvider ( Properties.observeEach ( contentProvider.getKnownElements (), BeanProperties.values ( new String[] { "id", "monitor" } ) ), Settings.getTimeZone () ) ); //$NON-NLS-1$ //$NON-NLS-2$
        this.tableViewer.setInput ( this.monitors );

        contentProvider.getRealizedElements ().addSetChangeListener ( new ISetChangeListener () {
            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                if ( !MonitorsViewTable.this.scrollLock )
                {
                    MonitorsViewTable.this.tableViewer.getTable ().setTopIndex ( 0 );
                }
            }
        } );
    }

    protected void hookContextMenu ( final Control control, final ISelectionProvider selectionProvider, final IViewSite viewSite )
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
        final Menu menu = menuMgr.createContextMenu ( control );
        control.setMenu ( menu );
        viewSite.registerContextMenu ( menuMgr, selectionProvider );
    }

    protected void fillContextMenu ( final IMenuManager manager )
    {
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }

    private void createColumns ( final TableViewer table )
    {
        final SortListener sortListener = new SortListener ( table );

        // id
        final TableViewerColumn idColumn = new TableViewerColumn ( table, SWT.NONE );
        idColumn.getColumn ().setText ( Messages.ID );
        idColumn.getColumn ().setData ( COLUMN_KEY, Columns.ID );
        idColumn.getColumn ().setWidth ( 450 );
        idColumn.getColumn ().setResizable ( true );
        idColumn.getColumn ().setMoveable ( true );
        idColumn.getColumn ().addSelectionListener ( sortListener );
        // state
        final TableViewerColumn stateColumn = new TableViewerColumn ( table, SWT.NONE );
        stateColumn.getColumn ().setText ( Messages.State );
        stateColumn.getColumn ().setData ( COLUMN_KEY, Columns.STATE );
        stateColumn.getColumn ().setWidth ( 150 );
        stateColumn.getColumn ().setResizable ( true );
        stateColumn.getColumn ().setMoveable ( true );
        stateColumn.getColumn ().addSelectionListener ( sortListener );
        // last fail timestamp
        final TableViewerColumn timestampColumn = new TableViewerColumn ( table, SWT.NONE );
        timestampColumn.getColumn ().setText ( Messages.Timestamp );
        timestampColumn.getColumn ().setData ( COLUMN_KEY, Columns.LAST_FAIL_TIMESTAMP );
        timestampColumn.getColumn ().setWidth ( 180 );
        timestampColumn.getColumn ().setResizable ( true );
        timestampColumn.getColumn ().setMoveable ( true );
        timestampColumn.getColumn ().addSelectionListener ( sortListener );
        // last fail value
        final TableViewerColumn lastFailValueColumn = new TableViewerColumn ( table, SWT.NONE );
        lastFailValueColumn.getColumn ().setText ( Messages.MonitorsViewTable_LastFailValue );
        lastFailValueColumn.getColumn ().setData ( COLUMN_KEY, Columns.LAST_FAIL_VALUE );
        lastFailValueColumn.getColumn ().setWidth ( 100 );
        lastFailValueColumn.getColumn ().setResizable ( true );
        lastFailValueColumn.getColumn ().setMoveable ( true );
        lastFailValueColumn.getColumn ().addSelectionListener ( sortListener );
        // value
        final TableViewerColumn valueColumn = new TableViewerColumn ( table, SWT.NONE );
        valueColumn.getColumn ().setText ( Messages.Value );
        valueColumn.getColumn ().setData ( COLUMN_KEY, Columns.VALUE );
        valueColumn.getColumn ().setWidth ( 100 );
        valueColumn.getColumn ().setResizable ( true );
        valueColumn.getColumn ().setMoveable ( true );
        valueColumn.getColumn ().addSelectionListener ( sortListener );
        // akn user
        final TableViewerColumn aknUserColumn = new TableViewerColumn ( table, SWT.NONE );
        aknUserColumn.getColumn ().setText ( Messages.AckUser );
        aknUserColumn.getColumn ().setData ( COLUMN_KEY, Columns.ACK_USER );
        aknUserColumn.getColumn ().setWidth ( 150 );
        aknUserColumn.getColumn ().setResizable ( true );
        aknUserColumn.getColumn ().setMoveable ( false );
        aknUserColumn.getColumn ().addSelectionListener ( sortListener );
        // akn timestamp
        final TableViewerColumn aknTimestampColumn = new TableViewerColumn ( table, SWT.NONE );
        aknTimestampColumn.getColumn ().setText ( Messages.AckTimestamp );
        aknTimestampColumn.getColumn ().setData ( COLUMN_KEY, Columns.ACK_TIMESTAMP );
        aknTimestampColumn.getColumn ().setWidth ( 180 );
        aknTimestampColumn.getColumn ().setResizable ( true );
        aknTimestampColumn.getColumn ().setMoveable ( true );
        aknTimestampColumn.getColumn ().addSelectionListener ( sortListener );
        // item
        final TableViewerColumn itemColumn = new TableViewerColumn ( table, SWT.NONE );
        itemColumn.getColumn ().setText ( Messages.Item );
        itemColumn.getColumn ().setData ( COLUMN_KEY, Columns.ITEM );
        itemColumn.getColumn ().setWidth ( 180 );
        itemColumn.getColumn ().setResizable ( true );
        itemColumn.getColumn ().setMoveable ( true );
        itemColumn.getColumn ().addSelectionListener ( sortListener );
        // item description
        final TableViewerColumn itemDescriptionolumn = new TableViewerColumn ( table, SWT.NONE );
        itemDescriptionolumn.getColumn ().setText ( Messages.ItemDescription );
        itemDescriptionolumn.getColumn ().setData ( COLUMN_KEY, Columns.ITEM_DESCRIPTION );
        itemDescriptionolumn.getColumn ().setWidth ( 180 );
        itemDescriptionolumn.getColumn ().setResizable ( true );
        itemDescriptionolumn.getColumn ().setMoveable ( true );
        itemDescriptionolumn.getColumn ().addSelectionListener ( sortListener );
        // message
        final TableViewerColumn messageColumn = new TableViewerColumn ( table, SWT.NONE );
        messageColumn.getColumn ().setText ( Messages.Message );
        messageColumn.getColumn ().setData ( COLUMN_KEY, Columns.MESSAGE );
        messageColumn.getColumn ().setWidth ( 180 );
        messageColumn.getColumn ().setResizable ( true );
        messageColumn.getColumn ().setMoveable ( true );
        messageColumn.getColumn ().addSelectionListener ( sortListener );
        // status timestamp
        final TableViewerColumn statusTimestampColumn = new TableViewerColumn ( table, SWT.NONE );
        statusTimestampColumn.getColumn ().setText ( Messages.MonitorsViewTable_StatusTimestamp );
        statusTimestampColumn.getColumn ().setData ( COLUMN_KEY, Columns.STATUS_TIMESTAMP );
        statusTimestampColumn.getColumn ().setWidth ( 180 );
        statusTimestampColumn.getColumn ().setResizable ( true );
        statusTimestampColumn.getColumn ().setMoveable ( true );
        statusTimestampColumn.getColumn ().addSelectionListener ( sortListener );
        // serverity
        final TableViewerColumn severityColumn = new TableViewerColumn ( table, SWT.NONE );
        severityColumn.getColumn ().setText ( Messages.MonitorsViewTable_Severity );
        severityColumn.getColumn ().setData ( COLUMN_KEY, Columns.SEVERITY );
        severityColumn.getColumn ().setWidth ( 180 );
        severityColumn.getColumn ().setResizable ( true );
        severityColumn.getColumn ().setMoveable ( true );
        severityColumn.getColumn ().addSelectionListener ( sortListener );
    }

    public void clear ()
    {
        this.monitors.clear ();
    }

    public List<DecoratedMonitor> selectedMonitors ()
    {
        if ( this.tableRef.get ().getTable ().getSelectionCount () == 0 )
        {
            return new ArrayList<DecoratedMonitor> ();
        }
        final List<DecoratedMonitor> result = new ArrayList<DecoratedMonitor> ();
        for ( final TableItem row : this.tableRef.get ().getTable ().getSelection () )
        {
            if ( row.getData () instanceof DecoratedMonitor )
            {
                result.add ( (DecoratedMonitor)row.getData () );
            }
        }
        return result;
    }

    /**
     * may only be called from GUI thread
     * 
     * @return
     */
    public int numOfEntries ()
    {
        return this.monitors.size ();
    }

    public void applyColumSettings ( final List<ColumnProperties> columnSettings )
    {
        if ( columnSettings == null )
        {
            return;
        }
        final int[] colOrder = this.tableViewer.getTable ().getColumnOrder ();
        int i = 0;
        for ( final ColumnProperties p : columnSettings )
        {
            if ( i >= colOrder.length )
            {
                break;
            }
            colOrder[i] = p.getNo ();
            i += 1;
        }
        this.tableViewer.getTable ().setColumnOrder ( colOrder );
        i = 0;
        for ( final ColumnProperties p : columnSettings )
        {
            if ( i >= this.tableViewer.getTable ().getColumnCount () )
            {
                break;
            }
            final TableColumn col = this.tableViewer.getTable ().getColumn ( i );
            col.setWidth ( p.getWidth () );
            i += 1;
        }
    }

    public List<ColumnProperties> getColumnSettings ()
    {
        final List<ColumnProperties> result = new ArrayList<ColumnProperties> ();
        int i = 0;
        final int[] order = this.tableViewer.getTable ().getColumnOrder ();
        for ( final TableColumn col : this.tableViewer.getTable ().getColumns () )
        {
            result.add ( new ColumnProperties ( order[i], col.getWidth () ) );
            i += 1;
        }
        return result;
    }
}
