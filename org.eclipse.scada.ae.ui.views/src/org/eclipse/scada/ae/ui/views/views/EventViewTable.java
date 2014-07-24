/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add details dialog
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.ui.views.Settings;
import org.eclipse.scada.ae.ui.views.config.ColumnLabelProviderInformation;
import org.eclipse.scada.ae.ui.views.dialog.EventDetailsDialog;
import org.eclipse.scada.ae.ui.views.dialog.SearchType;
import org.eclipse.scada.ae.ui.views.filter.EventViewerFilter;
import org.eclipse.scada.ae.ui.views.model.DecoratedEvent;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.utils.lang.Pair;
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

public class EventViewTable extends Composite
{
    private static final String COLUMN_KEY = "org.eclipse.scada.ae.ui.views.views.EventViewTable" + ".column.key"; //$NON-NLS-1$ //$NON-NLS-2$

    private final WritableSet events;

    private volatile boolean scrollLock = false;

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

            final EventTableColumn column = (EventTableColumn)newColumn.getData ( COLUMN_KEY );
            if ( column == EventTableColumn.reservedColumnSourceTimestamp || column == EventTableColumn.reservedColumnEntryTimestamp )
            {
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
                this.tableViewer.setSorter ( new EventTableSorter ( column, newDir ) );
            }
        }
    }

    private Pair<SearchType, String> filter;

    private final TableViewer tableViewer;

    // private final ArrayList<EventTableColumn> localColumns;

    private final LabelProviderSupport labelProviderSupport;

    private final List<ColumnLabelProviderInformation> columnInformations;

    /*
    private static final List<EventTableColumn> columns = new ArrayList<EventTableColumn> ();

    static
    {
        columns.add ( EventTableColumn.reservedColumnId );
        columns.add ( EventTableColumn.reservedColumnSourceTimestamp );
        columns.add ( new EventTableColumn ( Fields.EVENT_TYPE.getName () ) );
        columns.add ( new EventTableColumn ( Fields.VALUE.getName () ) );
        columns.add ( new EventTableColumn ( Fields.MONITOR_TYPE.getName () ) );
        columns.add ( new EventTableColumn ( Fields.ITEM.getName () ) );
        columns.add ( new EventTableColumn ( Fields.MESSAGE.getName () ) );
        columns.add ( new EventTableColumn ( Fields.ACTOR_NAME.getName () ) );
        columns.add ( new EventTableColumn ( Fields.ACTOR_TYPE.getName () ) );
        for ( final Fields field : Fields.values () )
        {
            final EventTableColumn column = new EventTableColumn ( field.getName () );
            if ( !columns.contains ( column ) )
            {
                columns.add ( column );
            }
        }
        columns.add ( EventTableColumn.reservedColumnEntryTimestamp );
    }
     */

    public EventViewTable ( final Composite parent, final IViewSite viewSite, final int style, final WritableSet events, final List<ColumnProperties> columnSettings )
    {
        this ( parent, viewSite, style, events, columnSettings, null );
    }

    public EventViewTable ( final Composite parent, final IViewSite viewSite, final int style, final WritableSet events, final List<ColumnProperties> columnSettings, final List<ColumnLabelProviderInformation> columnInformations )
    {
        super ( parent, style );
        this.events = events;

        this.columnInformations = makeColumnInformations ( columnInformations );

        this.labelProviderSupport = new LabelProviderSupport ( Settings.getTimeZone () );

        final FillLayout layout = new FillLayout ();
        setLayout ( layout );

        this.tableViewer = new TableViewer ( this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI );
        createColumns ( this.tableViewer );
        applyColumSettings ( columnSettings );
        this.tableViewer.getTable ().setHeaderVisible ( true );
        this.tableViewer.getTable ().setLinesVisible ( true );
        this.tableViewer.setUseHashlookup ( true );
        this.tableViewer.setSorter ( new EventTableSorter ( EventTableColumn.reservedColumnSourceTimestamp, SWT.DOWN ) );
        this.tableViewer.getTable ().setSortDirection ( SWT.DOWN );

        hookContextMenu ( this.tableViewer.getControl (), this.tableViewer, viewSite );
        this.tableViewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                handleDoubleClick ( event.getSelection () );
            }
        } );

        viewSite.setSelectionProvider ( this.tableViewer );

        final ObservableSetContentProvider contentProvider = new ObservableSetContentProvider ();
        this.tableViewer.setContentProvider ( contentProvider );
        this.tableViewer.setInput ( this.events );

        contentProvider.getRealizedElements ().addSetChangeListener ( new ISetChangeListener () {
            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                if ( !EventViewTable.this.scrollLock )
                {
                    EventViewTable.this.tableViewer.getTable ().setTopIndex ( 0 );
                }
            }
        } );
    }

    protected void handleDoubleClick ( final ISelection selection )
    {
        final DecoratedEvent event = SelectionHelper.first ( selection, DecoratedEvent.class );
        if ( event == null || event.getEvent () == null )
        {
            return;
        }

        new EventDetailsDialog ( getShell () ).open ( event.getEvent () );
    }

    /**
     * Create column informations if none where provided
     *
     * @param columnInformations
     *            provided informations
     * @return the created or provided informations, must never return
     *         <code>null</code>.
     */
    private static List<ColumnLabelProviderInformation> makeColumnInformations ( final List<ColumnLabelProviderInformation> columnInformations )
    {
        if ( columnInformations != null )
        {
            return columnInformations;
        }

        final List<ColumnLabelProviderInformation> result = new LinkedList<ColumnLabelProviderInformation> ();

        result.add ( new ColumnLabelProviderInformation ( "ID", ColumnLabelProviderInformation.TYPE_ID, false, 100, null ) );
        result.add ( new ColumnLabelProviderInformation ( "Source Timestamp", ColumnLabelProviderInformation.TYPE_SOURCE_TIMESTAMP, true, 100, null ) );
        result.add ( new ColumnLabelProviderInformation ( "Entry Timestamp", ColumnLabelProviderInformation.TYPE_ENTRY_TIMESTAMP, true, 100, null ) );

        for ( final Fields field : Fields.values () )
        {
            final Map<String, String> parameters = new HashMap<String, String> ( 1 );
            parameters.put ( "key", field.getName () );
            result.add ( new ColumnLabelProviderInformation ( field.getName (), ColumnLabelProviderInformation.TYPE_VARIANT, false, 100, parameters ) );
        }

        return result;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.labelProviderSupport.dispose ();
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

    public TableViewer getTableViewer ()
    {
        return this.tableViewer;
    }

    private void applyColumSettings ( final List<ColumnProperties> columnSettings )
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

    public void clear ()
    {
        this.events.clear ();
    }

    private void createColumns ( final TableViewer table )
    {
        final SortListener sortListener = new SortListener ( table );

        for ( final ColumnLabelProviderInformation columnInformation : this.columnInformations )
        {
            final TableViewerColumn fieldColumn = new TableViewerColumn ( table, SWT.NONE );
            fieldColumn.getColumn ().setText ( columnInformation.getLabel () );

            fieldColumn.getColumn ().setWidth ( columnInformation.getInitialSize () );
            fieldColumn.getColumn ().setResizable ( true );
            fieldColumn.getColumn ().setMoveable ( true );

            if ( columnInformation.isSortable () )
            {
                fieldColumn.getColumn ().addSelectionListener ( sortListener );
            }

            final CellLabelProvider labelProvider = columnInformation.createLabelProvider ( this.labelProviderSupport );
            if ( labelProvider != null )
            {
                fieldColumn.setLabelProvider ( labelProvider );
            }
            else
            {
                fieldColumn.setLabelProvider ( new StyledCellLabelProvider () {} );
            }
        }
    }

    public List<DecoratedEvent> selectedEvents ()
    {
        if ( this.tableViewer.getTable ().getSelectionCount () == 0 )
        {
            return new ArrayList<DecoratedEvent> ();
        }
        final ArrayList<DecoratedEvent> result = new ArrayList<DecoratedEvent> ();
        for ( final TableItem row : this.tableViewer.getTable ().getSelection () )
        {
            if ( row.getData () instanceof DecoratedEvent )
            {
                result.add ( (DecoratedEvent)row.getData () );
            }
        }
        return result;
    }

    public void removeFilter ()
    {
        this.filter = null;
        this.tableViewer.resetFilters ();
    }

    public void setFilter ( final Pair<SearchType, String> filter )
    {
        // filter hasn't changed
        if ( filter == null )
        {
            return;
        }
        if ( filter.equals ( this.filter ) )
        {
            return;
        }
        this.tableViewer.resetFilters ();
        this.filter = filter;
        this.tableViewer.addFilter ( new EventViewerFilter ( filter.second ) );
    }

    public Pair<SearchType, String> getFilter ()
    {
        return this.filter;
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

    public void setScrollLock ( final boolean scrollLock )
    {
        this.scrollLock = scrollLock;
    }

    public boolean isScrollLock ()
    {
        return this.scrollLock;
    }
}
