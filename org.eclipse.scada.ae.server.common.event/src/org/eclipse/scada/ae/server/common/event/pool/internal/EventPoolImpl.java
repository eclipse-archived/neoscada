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
package org.eclipse.scada.ae.server.common.event.pool.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventListener;
import org.eclipse.scada.ae.event.EventManager;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.ae.server.common.event.AbstractEventQueryImpl;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.ae.server.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

public class EventPoolImpl extends AbstractEventQueryImpl implements EventListener
{
    private final static Logger logger = LoggerFactory.getLogger ( EventPoolImpl.class );

    private final static int daysToRetrieve = Integer.getInteger ( "org.eclipse.scada.ae.common.event.pool.daysToRetrieve", 90 );

    private static final String isoDatePattern = "yyyy-MM-dd HH:mm:ss.SSS";

    private static final DateFormat isoDateFormat = new SimpleDateFormat ( isoDatePattern );

    private final Storage storage;

    private final EventManager eventManager;

    private final String filter;

    private final EventMatcher matcher;

    public EventPoolImpl ( final Executor executor, final Storage storage, final EventManager eventManager, final String filter, final int poolSize )
    {
        super ( executor, poolSize );

        this.storage = storage;
        this.eventManager = eventManager;
        this.filter = filter;
        this.matcher = new EventMatcherImpl ( filter );
    }

    public synchronized void start () throws Exception
    {
        // add to event manager
        this.eventManager.addEventListener ( this );

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                loadFromStorage ();
            }
        } );
    }

    public synchronized void stop ()
    {
        this.eventManager.removeEventListener ( this );
    }

    private void loadFromStorage ()
    {
        // load initial set from storage, but restrict it to *daysToRetrieve* days
        try
        {
            final long t = System.currentTimeMillis ();
            // retrieve data per day, to restrict database load
            for ( int daysBack = 1; daysBack <= daysToRetrieve; daysBack++ )
            {
                final Calendar calStart = new GregorianCalendar ();
                final Calendar calEnd = new GregorianCalendar ();
                calStart.setTimeInMillis ( t );
                calStart.add ( Calendar.DAY_OF_YEAR, -daysBack );
                calEnd.setTimeInMillis ( t );
                calEnd.add ( Calendar.DAY_OF_YEAR, -daysBack + 1 );
                final StringBuilder filter = new StringBuilder ();
                filter.append ( "(&" );
                filter.append ( this.filter );
                filter.append ( "(sourceTimestamp>=" + isoDateFormat.format ( calStart.getTime () ) + ")" );
                if ( daysBack > 1 )
                {
                    filter.append ( "(sourceTimestamp<" + isoDateFormat.format ( calEnd.getTime () ) + ")" );
                }
                filter.append ( ")" );
                logger.debug ( "load events from filter: " + filter );
                final Query query = this.storage.query ( filter.toString () );
                try
                {
                    int count;
                    synchronized ( this )
                    {
                        count = this.events.getCapacity ();
                    }

                    final Collection<Event> result = query.getNext ( count );

                    logger.debug ( "Loaded {} entries from storage", result.size () );
                    synchronized ( this )
                    {
                        this.events.addAll ( result );

                        final UnmodifiableIterator<List<Event>> it = Iterators.partition ( this.events.iterator (), chunkSize );
                        while ( it.hasNext () )
                        {
                            final List<org.eclipse.scada.ae.Event> chunk = it.next ();
                            notifyEvent ( chunk );
                        }
                    }
                }
                finally
                {
                    query.dispose ();
                }
                if ( this.events.size () >= this.events.getCapacity () )
                {
                    return;
                }
            }
            logger.debug ( "load of events complete" );
        }
        catch ( final Exception e )
        {
            logger.error ( "loadFromStorage failed", e );
        }
    }

    @Override
    public synchronized void handleEvent ( final List<Event> events )
    {
        addEvents ( events, this.matcher );
    }

}
