/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information.details;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesTab extends AbstractConnectionTab
{

    private final static Logger logger = LoggerFactory.getLogger ( PropertiesTab.class );

    private static class Entry
    {
        private final String key;

        private final String value;

        private Entry ( final String key, final String value )
        {
            this.key = key;
            this.value = value;
        }

        @SuppressWarnings ( "unused" )
        public String getKey ()
        {
            return this.key;
        }

        @SuppressWarnings ( "unused" )
        public String getValue ()
        {
            return this.value;
        }
    }

    private TabItem item;

    private TableViewer viewer;

    private ObservableListContentProvider contentProvider;

    private WritableList list;

    private Connection connection;

    @Override
    protected void setConnection ( final Connection connection )
    {
        if ( this.list.isDisposed () )
        {
            return;
        }

        this.connection = connection;

        if ( connection != null )
        {
            performUpdate ( connection.getSessionProperties () );
        }
        else
        {
            performUpdate ( Collections.<String, String> emptyMap () );
        }
    }

    private void performUpdate ( final Map<String, String> properties )
    {
        this.list.getRealm ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                handleUpdate ( properties );
            };
        } );
    }

    protected void handleUpdate ( final Map<String, String> sessionProperties )
    {
        logger.trace ( "Handle session properties update: {}", sessionProperties );
        this.list.setStale ( true );
        try
        {
            this.list.clear ();
            if ( sessionProperties != null )
            {
                for ( final Map.Entry<String, String> entry : sessionProperties.entrySet () )
                {
                    this.list.add ( new Entry ( entry.getKey (), entry.getValue () ) );
                }
            }
        }
        finally
        {
            this.list.setStale ( false );
        }
    }

    @Override
    public void createTab ( final TabFolder tabFolder )
    {
        this.item = new TabItem ( tabFolder, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL );
        this.item.setText ( "Properties" );
        this.item.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        this.viewer = new TableViewer ( tabFolder );
        this.viewer.getTable ().setHeaderVisible ( true );

        final TableLayout layout = new TableLayout ();
        this.viewer.getTable ().setLayout ( layout );

        this.contentProvider = new ObservableListContentProvider ();
        this.viewer.setContentProvider ( this.contentProvider );

        this.list = new WritableList ( SWTObservables.getRealm ( tabFolder.getDisplay () ) );

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( PojoObservables.observeMap ( this.contentProvider.getKnownElements (), Entry.class, "key" ) ) ); //$NON-NLS-1$
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( "Key" );
        }

        {
            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.setLabelProvider ( new ObservableMapCellLabelProvider ( PojoObservables.observeMap ( this.contentProvider.getKnownElements (), Entry.class, "value" ) ) ); //$NON-NLS-1$
            layout.addColumnData ( new ColumnWeightData ( 50 ) );
            col.getColumn ().setText ( "Value" );
        }

        this.item.setControl ( this.viewer.getControl () );

        this.viewer.setInput ( this.list );

        triggerTimer ();
    }

    private void triggerTimer ()
    {
        if ( this.list.isDisposed () )
        {
            return;
        }

        this.list.getRealm ().timerExec ( 1000, new Runnable () {
            @Override
            public void run ()
            {
                performUpdate ();
                triggerTimer ();
            }
        } );
    }

    protected void performUpdate ()
    {
        final Connection connection = this.connection;
        if ( connection == null )
        {
            handleUpdate ( Collections.<String, String> emptyMap () );
            return;
        }

        handleUpdate ( connection.getSessionProperties () );
    }

    protected void handleDispose ()
    {
        setConnection ( null );
    }

}
