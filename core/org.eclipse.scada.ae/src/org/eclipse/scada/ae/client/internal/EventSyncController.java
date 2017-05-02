/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.client.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.client.Connection;
import org.eclipse.scada.ae.client.EventListener;
import org.eclipse.scada.core.data.SubscriptionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventSyncController implements EventListener
{

    private final static Logger logger = LoggerFactory.getLogger ( EventSyncController.class );

    private final List<EventListener> listeners = new CopyOnWriteArrayList<EventListener> ();

    private final Connection connection;

    private final String id;

    private final Set<Event> cachedEvents = CollectionsBackPort.<Event> newSetFromMap ( new ConcurrentHashMap<Event, Boolean> () );

    public EventSyncController ( final Connection connection, final String id )
    {
        if ( connection == null )
        {
            throw new IllegalArgumentException ( "connection is null" );
        }
        this.connection = connection;
        this.id = id;
        this.connection.setEventListener ( this.id, this );
    }

    public synchronized void addListener ( final EventListener listener )
    {
        this.listeners.add ( listener );
        listener.dataChanged ( new ArrayList<Event> ( this.cachedEvents ) );
    }

    /**
     * returns true if no listeners left
     * 
     * @param listener
     * @return
     */
    public synchronized boolean removeListener ( final EventListener listener )
    {
        this.listeners.remove ( listener );
        return this.listeners.size () == 0;
    }

    @Override
    public void dataChanged ( final List<Event> addedEvents )
    {
        this.cachedEvents.removeAll ( addedEvents );
        this.cachedEvents.addAll ( addedEvents );
        for ( final EventListener listener : this.listeners )
        {
            listener.dataChanged ( addedEvents );
        }
    }

    @Override
    public void statusChanged ( final SubscriptionState state )
    {
        fireStateChange ( state );

        switch ( state )
        {
            case CONNECTED:
                for ( final EventListener listener : this.listeners )
                {
                    listener.dataChanged ( new ArrayList<Event> ( this.cachedEvents ) );
                }
                break;
            default:
                break;
        }
    }

    private void fireStateChange ( final SubscriptionState state )
    {
        for ( final EventListener listener : this.listeners )
        {
            try
            {
                listener.statusChanged ( state );
            }
            catch ( final Exception e )
            {
                logger.debug ( "Failed to notify subscription change", e );
            }
        }
    }

    public void dispose ()
    {
        this.connection.setEventListener ( this.id, null );
    }
}
