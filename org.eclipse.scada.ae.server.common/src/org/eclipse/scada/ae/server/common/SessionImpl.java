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
package org.eclipse.scada.ae.server.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.data.BrowserEntry;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.server.EventListener;
import org.eclipse.scada.ae.server.MonitorListener;
import org.eclipse.scada.ae.server.Session;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionImpl extends AbstractSessionImpl implements Session, BrowserListener
{

    private final static Logger logger = LoggerFactory.getLogger ( SessionImpl.class );

    private final EventListener eventListener;

    private final MonitorListener monitorListener;

    private volatile MonitorListener clientMonitorListener;

    private volatile EventListener clientEventListener;

    private volatile BrowserListener clientBrowserListener;

    private final Map<String, BrowserEntry> browserCache = new HashMap<String, BrowserEntry> ();

    private boolean disposed = false;

    private final Set<QueryImpl> queries = new HashSet<QueryImpl> ();

    public SessionImpl ( final UserInformation userInformation, final Map<String, String> properties )
    {
        super ( userInformation, properties );
        logger.info ( "Created new session" );

        this.eventListener = new EventListener () {

            @Override
            public void dataChanged ( final String poolId, final List<Event> addedEvents )
            {
                SessionImpl.this.eventDataChanged ( poolId, addedEvents );
            }

            @Override
            public void updateStatus ( final Object poolId, final SubscriptionState state )
            {
                SessionImpl.this.eventStatusChanged ( poolId.toString (), state );
            }
        };
        this.monitorListener = new MonitorListener () {

            @Override
            public void dataChanged ( final String subscriptionId, final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
            {
                SessionImpl.this.monitorDataChanged ( subscriptionId, addedOrUpdated, removed, full );
            }

            @Override
            public void updateStatus ( final Object poolId, final SubscriptionState state )
            {
                SessionImpl.this.monitorStatusChanged ( poolId.toString (), state );
            }
        };
    }

    protected void monitorStatusChanged ( final String string, final SubscriptionState state )
    {
        final MonitorListener listener = this.clientMonitorListener;
        if ( listener != null )
        {
            listener.updateStatus ( string, state );
        }
    }

    protected void monitorDataChanged ( final String subscriptionId, final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        final MonitorListener listener = this.clientMonitorListener;
        if ( listener != null )
        {
            logger.info ( String.format ( "Monitor Data Change: %s - %s - %s", subscriptionId, addedOrUpdated != null ? addedOrUpdated.size () : "none", removed != null ? removed.size () : "none" ) );
            listener.dataChanged ( subscriptionId, addedOrUpdated, removed, full );
        }
    }

    protected void eventStatusChanged ( final String string, final SubscriptionState state )
    {
        final EventListener listener = this.clientEventListener;
        if ( listener != null )
        {
            listener.updateStatus ( string, state );
        }
    }

    protected void eventDataChanged ( final String poolId, final List<Event> addedEvents )
    {
        final EventListener listener = this.clientEventListener;
        if ( listener != null )
        {
            listener.dataChanged ( poolId, translateEvents ( addedEvents ) );
        }
    }

    /**
     * Translate the events into the current session language
     * 
     * @param events
     *            the events to translate
     * @return a new array of translated events
     */
    protected List<Event> translateEvents ( final List<Event> events )
    {
        return events;
    }

    @Override
    public void setMonitorListener ( final MonitorListener listener )
    {
        this.clientMonitorListener = listener;
    }

    @Override
    public void setEventListener ( final EventListener listener )
    {
        this.clientEventListener = listener;
    }

    @Override
    public synchronized void dispose ()
    {
        logger.info ( "Disposing session" );

        // mark disposed
        this.disposed = true;

        // dispose queries : operate on copy to prevent concurrent modification
        for ( final QueryImpl query : new ArrayList<QueryImpl> ( this.queries ) )
        {
            query.dispose ( null );
        }
        this.queries.clear ();

        // clear listeners
        this.clientMonitorListener = null;
        this.clientEventListener = null;
        this.clientBrowserListener = null;
    }

    public MonitorListener getMonitorListener ()
    {
        return this.monitorListener;
    }

    public EventListener getEventListener ()
    {
        return this.eventListener;
    }

    @Override
    public void setBrowserListener ( final BrowserListener listener )
    {
        synchronized ( this.browserCache )
        {
            this.clientBrowserListener = listener;
            if ( this.clientBrowserListener != null )
            {
                this.clientBrowserListener.dataChanged ( new ArrayList<BrowserEntry> ( this.browserCache.values () ), null, true );
            }
        }
    }

    @Override
    public void dataChanged ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        synchronized ( this.browserCache )
        {
            if ( full )
            {
                this.browserCache.clear ();
            }
            if ( removed != null )
            {
                for ( final String id : removed )
                {
                    this.browserCache.remove ( id );
                }
            }
            if ( addedOrUpdated != null )
            {
                for ( final BrowserEntry entry : addedOrUpdated )
                {
                    this.browserCache.put ( entry.getId (), entry );
                }
            }

            final BrowserListener listener = this.clientBrowserListener;
            if ( listener != null )
            {
                listener.dataChanged ( addedOrUpdated, removed, full );
            }
        }
    }

    public synchronized void addQuery ( final QueryImpl query )
    {
        if ( this.disposed )
        {
            query.dispose ( null );
        }
        else
        {
            this.queries.add ( query );
        }
    }

    public synchronized void removeQuery ( final QueryImpl query )
    {
        this.queries.remove ( query );
    }
}
