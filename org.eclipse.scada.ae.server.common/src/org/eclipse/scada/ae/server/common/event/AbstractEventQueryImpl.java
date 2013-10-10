/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
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
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventListener;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.utils.collection.BoundedPriorityQueueSet;
import org.eclipse.scada.utils.collection.BoundedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

public abstract class AbstractEventQueryImpl implements EventQuery
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractEventQueryImpl.class );

    protected final static int chunkSize = Integer.getInteger ( "org.eclipse.scada.ae.common.event.pool.chunkSize", 100 );

    private final Set<EventListener> listeners = new HashSet<EventListener> ();

    protected final Executor executor;

    protected final BoundedQueue<Event> events;

    public AbstractEventQueryImpl ( final Executor executor, final int poolSize )
    {
        this.executor = executor;

        this.events = new BoundedPriorityQueueSet<Event> ( poolSize, new Comparator<Event> () {
            @Override
            public int compare ( final Event o1, final Event o2 )
            {
                return Event.comparator.compare ( o2, o1 );
            }
        } );
    }

    protected void notifyEvent ( final List<Event> event )
    {
        final EventListener[] listeners = this.listeners.toArray ( new EventListener[this.listeners.size ()] );
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final EventListener listener : listeners )
                {
                    listener.handleEvent ( event );
                }
            }
        } );
    }

    @Override
    public synchronized void addListener ( final EventListener eventListener )
    {
        this.listeners.add ( eventListener );

        final UnmodifiableIterator<List<Event>> it = Iterators.partition ( AbstractEventQueryImpl.this.events.iterator (), chunkSize );
        while ( it.hasNext () )
        {
            final List<org.eclipse.scada.ae.Event> chunk = it.next ();
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    eventListener.handleEvent ( chunk );
                }
            } );
        }

    }

    protected synchronized void addEvents ( final List<Event> events, final EventMatcher matcher )
    {
        final List<Event> toNotify = new ArrayList<Event> ( events.size () );
        for ( final Event event : events )
        {
            if ( matcher == null || matcher.matches ( event ) )
            {
                if ( this.events.add ( event ) )
                {
                    toNotify.add ( event );
                }
            }
        }
        logger.debug ( "new event pool size: {}", this.events.size () );
        notifyEvent ( toNotify );
    }

    @Override
    public synchronized void removeListener ( final EventListener eventListener )
    {
        this.listeners.remove ( eventListener );
    }

    @Override
    public int getCapacity ()
    {
        return this.events.getCapacity ();
    }
}
