/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - clear warnings
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.map.WritableMap;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.scada.ae.client.MonitorListener;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.views.model.DecoratedMonitor;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.swt.widgets.Composite;

public abstract class MonitorSubscriptionAlarmsEventsView extends AbstractAlarmsEventsView
{
    protected String monitorsId;

    protected WritableSet monitors;

    protected WritableMap monitorsMap;

    private MonitorListener monitorListener;

    protected SubscriptionState monitorSubscriptionState;

    @Override
    protected Realm getRealm ()
    {
        if ( this.monitors != null )
        {
            return this.monitors.getRealm ();
        }
        return DisplayRealm.getRealm ( getSite ().getShell ().getDisplay () );
    }

    public void setMonitorsId ( final String monitorsId )
    {
        if ( monitorsId == null )
        {
            unSubscribe ();
            this.monitorsId = null;
            return;
        }
        if ( !String.valueOf ( monitorsId ).equals ( String.valueOf ( this.monitorsId ) ) )
        {
            unSubscribe ();
            this.monitorsId = monitorsId;
            subscribe ();
        }
    }

    public String getMonitorsId ()
    {
        return this.monitorsId;
    }

    protected void subscribe ()
    {
        if ( getConnection () != null && this.monitorsId != null )
        {
            this.monitorListener = new MonitorListener () {

                @Override
                public void statusChanged ( final SubscriptionState state )
                {
                    statusChangedMonitorSubscription ( state );
                }

                @Override
                public void dataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
                {
                    MonitorSubscriptionAlarmsEventsView.this.dataChanged ( addedOrUpdated, removed, full );
                }
            };
            getConnectionService ().getMonitorManager ().addMonitorListener ( this.monitorsId, this.monitorListener );
        }
    }

    protected void unSubscribe ()
    {
        if ( getConnection () != null && this.monitorsId != null )
        {
            if ( this.monitorListener != null )
            {
                getConnectionService ().getMonitorManager ().removeMonitorListener ( this.monitorsId, this.monitorListener );
            }
        }
        clear ();
    }

    private void clear ()
    {
        this.monitors.getRealm ().asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                if ( MonitorSubscriptionAlarmsEventsView.this.monitors != null )
                {
                    MonitorSubscriptionAlarmsEventsView.this.monitors.clear ();
                }
                if ( MonitorSubscriptionAlarmsEventsView.this.monitorsMap != null )
                {
                    MonitorSubscriptionAlarmsEventsView.this.monitorsMap.clear ();
                }
            }
        } );
    }

    @Override
    protected void onConnect ()
    {
        super.onConnect ();
        subscribe ();
    }

    @Override
    protected void onDisconnect ()
    {
        unSubscribe ();
        super.onDisconnect ();
    };

    public void statusChangedMonitorSubscription ( final SubscriptionState state )
    {
        this.monitorSubscriptionState = state;
        updateStatusBar ();
    }

    protected void dataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        scheduleJob ( new Runnable () {
            @Override
            public void run ()
            {
                performDataChanged ( addedOrUpdated, removed, full );
            }
        } );
    }

    private void performDataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        try
        {
            this.monitorsMap.setStale ( true );

            if ( full )
            {
                this.monitorsMap.clear ();
            }

            if ( removed != null )
            {
                for ( final String id : removed )
                {
                    this.monitorsMap.remove ( id );
                }
            }
            if ( addedOrUpdated != null )
            {
                // do it in 2 steps
                // 1. add all missing
                final Map<String, DecoratedMonitor> missing = new HashMap<String, DecoratedMonitor> ();
                for ( final MonitorStatusInformation monitorStatusInformation : addedOrUpdated )
                {
                    if ( !this.monitorsMap.containsKey ( monitorStatusInformation.getId () ) )
                    {
                        missing.put ( monitorStatusInformation.getId (), new DecoratedMonitor ( monitorStatusInformation ) );
                    }
                }
                this.monitorsMap.putAll ( missing );
                // 2. update data
                for ( final MonitorStatusInformation monitorStatusInformation : addedOrUpdated )
                {
                    if ( !missing.keySet ().contains ( monitorStatusInformation.getId () ) )
                    {
                        final DecoratedMonitor dm = (DecoratedMonitor)this.monitorsMap.get ( monitorStatusInformation.getId () );
                        if ( dm == null )
                        {
                            this.monitorsMap.put ( monitorStatusInformation.getId (), new DecoratedMonitor ( monitorStatusInformation ) );
                        }
                        else
                        {
                            dm.setMonitor ( monitorStatusInformation );
                        }
                    }
                }
            }
        }
        finally
        {
            this.monitorsMap.setStale ( false );
        }
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        super.createPartControl ( parent );

        this.monitorsMap = new WritableMap ( DisplayRealm.getRealm ( parent.getDisplay () ) );
        this.monitors = new WritableSet ( DisplayRealm.getRealm ( parent.getDisplay () ) );
        this.monitorsMap.addMapChangeListener ( new IMapChangeListener () {
            @Override
            public void handleMapChange ( final MapChangeEvent event )
            {
                final Set<DecoratedMonitor> toRemove = new HashSet<DecoratedMonitor> ();
                for ( final Object key : event.diff.getRemovedKeys () )
                {
                    toRemove.add ( (DecoratedMonitor)event.diff.getOldValue ( key ) );
                }
                MonitorSubscriptionAlarmsEventsView.this.monitors.removeAll ( toRemove );

                final Set<DecoratedMonitor> toAdd = new HashSet<DecoratedMonitor> ();
                for ( final Object key : event.diff.getAddedKeys () )
                {
                    toAdd.add ( (DecoratedMonitor)event.diff.getNewValue ( key ) );
                }
                MonitorSubscriptionAlarmsEventsView.this.monitors.addAll ( toAdd );

                for ( final Object key : event.diff.getChangedKeys () )
                {
                    MonitorSubscriptionAlarmsEventsView.this.monitors.remove ( event.diff.getOldValue ( key ) );
                    MonitorSubscriptionAlarmsEventsView.this.monitors.add ( event.diff.getNewValue ( key ) );
                }
            }
        } );
        this.monitors.addChangeListener ( new IChangeListener () {
            @Override
            public void handleChange ( final ChangeEvent event )
            {
                updateStatusBar ();
            }
        } );
    }

    public void acknowledgeMonitor ( final String monitorId, final Date timestamp, final CallbackHandler callbackHandler )
    {
        if ( getConnection () != null && getConnection ().getState () == ConnectionState.BOUND )
        {
            getConnection ().acknowledge ( monitorId, timestamp, null, callbackHandler );
        }
    }

}
