/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.injector;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventInjectorQueue
{
    private final static Logger logger = LoggerFactory.getLogger ( EventInjectorQueue.class );

    private final SingleServiceTracker<EventInjector> tracker;

    private EventInjector service;

    private final Queue<Entry> queue = new LinkedList<> ();

    private final static class Entry
    {
        Event event;

        InjectionContext context;

        public Entry ( final Event event, final InjectionContext context )
        {
            this.event = event;
            this.context = context;
        }
    }

    public EventInjectorQueue ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<> ( context, EventInjector.class, new SingleServiceListener<EventInjector> () {

            @Override
            public void serviceChange ( final ServiceReference<EventInjector> reference, final EventInjector service )
            {
                handleServiceChange ( service );
            }
        } );
        logger.info ( "Opening tracker" );
        this.tracker.open ();
    }

    protected synchronized void handleServiceChange ( final EventInjector service )
    {
        this.service = service;
        if ( service != null )
        {
            flushStoredEvents ();
        }
    }

    private void flushStoredEvents ()
    {
        logger.debug ( "Flushing stored events: {}", this.queue.size () );

        Entry e;
        while ( ( e = this.queue.poll () ) != null )
        {
            this.service.injectEvent ( e.event, e.context );
        }
    }

    public synchronized void injectEvent ( final Event event, final InjectionContext context )
    {
        logger.trace ( "Inject event: {}", event );

        if ( this.service != null )
        {
            logger.trace ( "To service" );
            this.service.injectEvent ( event, context );
        }
        else
        {
            logger.trace ( "To queue" );
            this.queue.offer ( new Entry ( event, context ) );
        }
    }

    public synchronized void dispose ()
    {
        logger.info ( "Closing tracker" );
        if ( !this.queue.isEmpty () )
        {
            logger.warn ( "Discarding {} events", this.queue.size () );
        }
        this.tracker.close ();
    }
}
