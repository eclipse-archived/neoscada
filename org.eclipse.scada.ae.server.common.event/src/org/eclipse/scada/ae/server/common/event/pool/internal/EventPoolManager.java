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

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.event.EventManager;
import org.eclipse.scada.ae.server.common.event.EventQuery;
import org.eclipse.scada.ae.server.storage.Storage;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventPoolManager
{

    private final static Logger logger = LoggerFactory.getLogger ( EventPoolManager.class );

    private final BundleContext context;

    private final SingleServiceTracker<?> eventManagerTracker;

    private final SingleServiceTracker<?> storageTracker;

    private Storage storage;

    private EventManager eventManager;

    private EventPoolImpl pool;

    private ServiceRegistration<?> poolHandle;

    private final String id;

    private final ExecutorService executor;

    private String filter;

    private int size;

    public EventPoolManager ( final BundleContext context, final String id, final String filter, final int size ) throws InvalidSyntaxException
    {
        this.context = context;
        this.id = id;
        this.filter = filter;
        this.size = size;

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "EventPoolManager/" + id ) );

        this.eventManagerTracker = new SingleServiceTracker<Object> ( this.context, FilterUtil.createClassFilter ( EventManager.class.getName () ), new SingleServiceListener<Object> () {

            @Override
            public void serviceChange ( final ServiceReference<Object> reference, final Object service )
            {
                EventPoolManager.this.setEventManager ( (EventManager)service );
            }
        } );
        this.eventManagerTracker.open ();

        this.storageTracker = new SingleServiceTracker<Object> ( this.context, FilterUtil.createClassFilter ( Storage.class.getName () ), new SingleServiceListener<Object> () {

            @Override
            public void serviceChange ( final ServiceReference<Object> reference, final Object service )
            {
                EventPoolManager.this.setStorageService ( (Storage)service );
            }
        } );
        this.storageTracker.open ();
    }

    protected synchronized void setStorageService ( final Storage service )
    {
        logger.debug ( "Setting storage service: {}", service );

        this.storage = service;
        checkInit ();
    }

    protected synchronized void setEventManager ( final EventManager service )
    {
        logger.debug ( "Setting event manager: {}", service );

        this.eventManager = service;
        checkInit ();
    }

    private void checkInit ()
    {
        logger.info ( "Checking init state" );
        // FIXME: async exec

        if ( this.storage != null && this.eventManager != null )
        {
            disposePool ();
            createPool ( this.storage, this.eventManager );
        }
        else
        {
            disposePool ();
        }
    }

    private void createPool ( final Storage storage, final EventManager eventManager )
    {
        logger.info ( "Create pool: {}", this.id );
        try
        {
            this.pool = new EventPoolImpl ( this.executor, storage, eventManager, this.filter, this.size );

            this.pool.start ();

            logger.info ( "pool {} created", this.id );

            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_PID, this.id );
            this.poolHandle = this.context.registerService ( EventQuery.class.getName (), this.pool, properties );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create event pool: " + this.id, e );
        }
    }

    public void dispose ()
    {
        disposePool ();
        this.executor.shutdown ();
    }

    private synchronized void disposePool ()
    {
        logger.info ( "Dispose pool: {}", this.id );

        if ( this.poolHandle != null )
        {
            logger.debug ( "Unregister pool" );
            this.poolHandle.unregister ();
            this.poolHandle = null;
        }
        if ( this.pool != null )
        {
            this.pool.stop ();
            this.pool = null;
        }
    }

    public void update ( final String filter, final int size )
    {
        this.filter = filter;
        this.size = size;
        checkInit ();
    }
}
