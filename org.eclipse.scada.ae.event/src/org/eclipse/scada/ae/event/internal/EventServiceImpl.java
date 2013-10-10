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
package org.eclipse.scada.ae.event.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventListener;
import org.eclipse.scada.ae.event.EventManager;
import org.eclipse.scada.ae.event.EventService;
import org.eclipse.scada.ae.server.storage.Storage;
import org.eclipse.scada.ae.server.storage.StoreListener;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventServiceImpl implements EventService, EventManager
{

    private final static Logger logger = LoggerFactory.getLogger ( EventServiceImpl.class );

    private final BundleContext context;

    private final SingleServiceTracker<Storage> storageTracker;

    private final List<Event> writeQueue = new LinkedList<Event> ();

    private final List<Event> eventBuffer = new LinkedList<Event> ();

    private final Set<EventListener> listeners = new HashSet<EventListener> ();

    private Storage storage;

    private final StoreListener storeListener;

    public EventServiceImpl ( final BundleContext context ) throws InvalidSyntaxException
    {
        this.context = context;

        this.storeListener = new StoreListener () {

            @Override
            public void notify ( final Event event )
            {
                EventServiceImpl.this.eventStored ( event );
            }
        };

        final Filter filter = FilterUtil.createClassFilter ( Storage.class.getName () );
        this.storageTracker = new SingleServiceTracker<Storage> ( this.context, filter, new SingleServiceListener<Storage> () {

            @Override
            public void serviceChange ( final ServiceReference<Storage> reference, final Storage service )
            {
                setStorage ( service );
            }
        } );
        this.storageTracker.open ();
    }

    protected synchronized void eventStored ( final Event event )
    {
        this.writeQueue.remove ( event );
        logger.debug ( "Write queue size - after event: {}", this.writeQueue.size () );
    }

    public void dispose ()
    {
        this.storageTracker.close ();
    }

    protected synchronized void setStorage ( final Storage service )
    {
        this.storage = service;
        this.writeQueue.clear ();

        publishBufferedEvents ();
    }

    private void publishBufferedEvents ()
    {
        logger.info ( "Storing {} recorded events", this.eventBuffer.size () );

        for ( final Event event : this.eventBuffer )
        {
            performStore ( event );
        }
        this.eventBuffer.clear ();
    }

    @Override
    public synchronized void publishEvent ( final Event event )
    {
        if ( this.storage != null )
        {
            performStore ( event );
        }
        else
        {
            this.eventBuffer.add ( event );
        }
    }

    private void performStore ( final Event event )
    {
        final Event storedEvent;
        synchronized ( this )
        {
            storedEvent = this.storage.store ( event, this.storeListener );
            // add to the write queue
            this.writeQueue.add ( storedEvent );
        }

        logger.debug ( "Write queue size - after store: {}", this.writeQueue.size () );

        // feed the event pools
        for ( final EventListener listener : this.listeners )
        {
            try
            {
                listener.handleEvent ( Arrays.asList ( storedEvent ) );
            }
            catch ( final Exception e )
            {
                logger.info ( "Failed to handle listener", e );
            }
        }
    }

    @Override
    public synchronized void addEventListener ( final EventListener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            listener.handleEvent ( Collections.unmodifiableList ( this.writeQueue ) );
        }
    }

    @Override
    public synchronized void removeEventListener ( final EventListener listener )
    {
        this.listeners.remove ( listener );
    }

}
