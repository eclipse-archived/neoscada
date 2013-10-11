/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.connection.data.MonitorStatusBean;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorsView extends AbstractConditionQueryViewPart
{
    private final static Logger logger = LoggerFactory.getLogger ( MonitorsView.class );

    public static final String VIEW_ID = "org.eclipse.scada.ae.ui.testing.views.MonitorsView";

    private Label stateLabel;

    private final Map<String, MonitorStatusBean> monitorSet = new HashMap<String, MonitorStatusBean> ();

    private final WritableSet monitors;

    private TableViewer viewer;

    public MonitorsView ()
    {
        this.monitors = new WritableSet ( SWTObservables.getRealm ( Display.getDefault () ) );
    }

    @Override
    protected Realm getRealm ()
    {
        return this.monitors.getRealm ();
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        final GridLayout layout = new GridLayout ( 1, false );
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginHeight = layout.marginWidth = 0;

        parent.setLayout ( layout );

        this.stateLabel = new Label ( parent, SWT.NONE );
        this.stateLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

        final Composite wrapper = new Composite ( parent, SWT.NONE );
        wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        this.viewer = new TableViewer ( wrapper, SWT.FULL_SELECTION | SWT.MULTI );

        TableColumnLayout tableLayout;
        wrapper.setLayout ( tableLayout = new TableColumnLayout () );

        TableColumn col;

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "ID" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "State" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "Change Timestamp" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 100 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "Priority" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "Value" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "Ack User" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 50 ) );

        col = new TableColumn ( this.viewer.getTable (), SWT.NONE );
        col.setText ( "Ack Timestamp" );
        tableLayout.setColumnData ( col, new ColumnWeightData ( 100 ) );

        this.viewer.getTable ().setLayout ( layout );
        this.viewer.getTable ().setHeaderVisible ( true );

        this.viewer.setComparator ( new ViewerComparator () {
            @Override
            public int compare ( final Viewer viewer, final Object e1, final Object e2 )
            {
                if ( e1 instanceof MonitorStatusBean && e2 instanceof MonitorStatusBean )
                {
                    final MonitorStatusBean b1 = (MonitorStatusBean)e1;
                    final MonitorStatusBean b2 = (MonitorStatusBean)e2;
                    return b1.getId ().compareTo ( b2.getId () );
                }
                return 0;
            }
        } );
        this.viewer.setContentProvider ( new ObservableSetContentProvider () );
        this.viewer.setLabelProvider ( new MonitorsLabelProvider ( BeansObservables.observeMaps ( this.monitors, MonitorStatusBean.class, new String[] { "id", MonitorStatusBean.PROP_STATUS, MonitorStatusBean.PROP_STATUS_TIMESTAMP, MonitorStatusBean.PROP_VALUE, MonitorStatusBean.PROP_LAST_AKN_USER, MonitorStatusBean.PROP_LAST_AKN_TIMESTAMP, MonitorStatusBean.PROP_LAST_FAIL_TIMESTAMP, MonitorStatusBean.PROP_ATTRIBUTES } ) ) );
        this.viewer.setInput ( this.monitors );

        getViewSite ().setSelectionProvider ( this.viewer );

        hookContextMenu ();
        addSelectionListener ();
    }

    private void hookContextMenu ()
    {
        final MenuManager menuMgr = new MenuManager ( "#PopupMenu", VIEW_ID );
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
        getSite ().registerContextMenu ( menuMgr, this.viewer );
    }

    private void fillContextMenu ( final IMenuManager manager )
    {
        // Other plug-ins can contribute there actions here
        manager.add ( new Separator () );
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }

    @Override
    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    @Override
    protected void clear ()
    {
        super.clear ();

        scheduleJob ( new Runnable () {

            @Override
            public void run ()
            {
                MonitorsView.this.monitorSet.clear ();
                MonitorsView.this.monitors.clear ();
                MonitorsView.this.stateLabel.setText ( "<no query selected>" );
            }
        } );
    }

    @Override
    public void handleDataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        scheduleJob ( new Runnable () {

            @Override
            public void run ()
            {
                performDataChanged ( addedOrUpdated, removed, full );
            }
        } );
    }

    protected void performDataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        logger.debug ( "Got data change" );

        try
        {
            if ( full )
            {
                this.monitors.clear ();
            }

            Collection<MonitorStatusBean> infos = new LinkedList<MonitorStatusBean> ();
            if ( removed != null )
            {
                for ( final String id : removed )
                {
                    final MonitorStatusBean info = this.monitorSet.remove ( id );
                    if ( info != null )
                    {
                        infos.add ( info );
                    }
                }
            }

            this.monitors.removeAll ( infos );

            infos = new LinkedList<MonitorStatusBean> ();

            if ( addedOrUpdated != null )
            {
                for ( final MonitorStatusInformation info : addedOrUpdated )
                {
                    if ( this.monitorSet.containsKey ( info.getId () ) )
                    {
                        // update
                        final MonitorStatusBean infoBean = this.monitorSet.get ( info.getId () );
                        infoBean.update ( info );
                    }
                    else
                    {
                        // add
                        final MonitorStatusBean infoBean = new MonitorStatusBean ( this.entry.getConnection (), info );
                        this.monitorSet.put ( info.getId (), infoBean );
                        infos.add ( infoBean );
                    }
                }
            }

            this.monitors.addAll ( infos );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to handle data", e );
        }
    }

    @Override
    public void handleStatusChanged ( final SubscriptionState status )
    {
        triggerStateUpdate ( status );
    }

    private void triggerStateUpdate ( final SubscriptionState status )
    {
        if ( this.stateLabel.isDisposed () )
        {
            return;
        }

        scheduleJob ( new Runnable () {

            @Override
            public void run ()
            {
                if ( MonitorsView.this.stateLabel.isDisposed () )
                {
                    return;
                }
                MonitorsView.this.stateLabel.setText ( status.toString () );
            }
        } );
    }
}
