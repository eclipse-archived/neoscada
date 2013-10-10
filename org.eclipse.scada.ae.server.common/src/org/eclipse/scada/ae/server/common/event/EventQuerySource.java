/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.common.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.EventListener;
import org.eclipse.scada.core.subscription.SubscriptionInformation;
import org.eclipse.scada.core.subscription.SubscriptionSource;
import org.eclipse.scada.utils.collection.BoundedPriorityQueueSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Subscription source for events
 * 
 * @author Jens Reimann
 */
public class EventQuerySource implements SubscriptionSource, org.eclipse.scada.ae.event.EventListener
{

    private final static Logger logger = LoggerFactory.getLogger ( EventQuerySource.class );

    private final String id;

    private final EventQuery eventQuery;

    private final Set<EventListener> listeners = new HashSet<EventListener> ();

    private final Queue<Event> cachedData;

    public EventQuerySource ( final String id, final EventQuery query )
    {
        this.id = id;
        this.eventQuery = query;
        this.cachedData = new BoundedPriorityQueueSet<Event> ( query.getCapacity (), new Comparator<Event> () {
            @Override
            public int compare ( final Event o1, final Event o2 )
            {
                return Event.comparator.compare ( o2, o1 );
            }
        } );
    }

    @Override
    public synchronized void addListener ( final Collection<SubscriptionInformation> listeners )
    {
        final boolean wasEmpty = this.listeners.isEmpty ();

        for ( final SubscriptionInformation information : listeners )
        {
            final EventListener listener = (EventListener)information.getListener ();
            this.listeners.add ( listener );

            if ( !this.cachedData.isEmpty () )
            {
                listener.dataChanged ( this.id, new ArrayList<Event> ( this.cachedData ) );
            }
        }

        if ( wasEmpty && !this.listeners.isEmpty () )
        {
            this.eventQuery.addListener ( this );
        }
    }

    @Override
    public synchronized void removeListener ( final Collection<SubscriptionInformation> listeners )
    {
        for ( final SubscriptionInformation information : listeners )
        {
            final EventListener listener = (EventListener)information.getListener ();
            this.listeners.remove ( listener );
        }

        if ( this.listeners.isEmpty () )
        {
            this.eventQuery.removeListener ( this );
            this.cachedData.clear ();
        }
    }

    @Override
    public boolean supportsListener ( final SubscriptionInformation information )
    {
        return information.getListener () instanceof EventListener;
    }

    @Override
    public synchronized void handleEvent ( final List<Event> event )
    {
        this.cachedData.addAll ( event );

        for ( final EventListener listener : this.listeners )
        {
            try
            {
                listener.dataChanged ( this.id, event );
            }
            catch ( final Throwable e )
            {
                logger.warn ( "Failed to notify", e );
            }
        }
    }

}
