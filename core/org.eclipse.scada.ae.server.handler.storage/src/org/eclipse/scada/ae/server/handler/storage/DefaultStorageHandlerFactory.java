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
package org.eclipse.scada.ae.server.handler.storage;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventService;
import org.eclipse.scada.ae.server.handler.AbstractEventHandler;
import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultStorageHandlerFactory implements EventHandlerFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( DefaultStorageHandlerFactory.class );

    private final SingleServiceTracker<EventService> tracker;

    private EventService service;

    private final BundleContext context;

    private final Dictionary<String, Object> serviceProperties = new Hashtable<> ();

    private ServiceRegistration<EventHandlerFactory> handle;

    public DefaultStorageHandlerFactory ()
    {
        this ( FrameworkUtil.getBundle ( DefaultStorageHandlerFactory.class ).getBundleContext () );
    }

    public DefaultStorageHandlerFactory ( final BundleContext context )
    {
        this.serviceProperties.put ( Constants.SERVICE_DESCRIPTION, "Default storage handler" );
        this.serviceProperties.put ( EventHandlerFactory.FACTORY_ID, "defaultStorage" );

        this.context = context;
        this.tracker = new SingleServiceTracker<EventService> ( context, EventService.class, new SingleServiceListener<EventService> () {

            @Override
            public void serviceChange ( final ServiceReference<EventService> reference, final EventService service )
            {
                handleServiceChange ( service );
            }
        } );
        this.tracker.open ();
    }

    protected synchronized void handleServiceChange ( final EventService service )
    {
        if ( this.handle != null && service == null )
        {
            this.handle.unregister ();
            this.handle = null;
        }

        this.service = service;

        if ( this.handle == null && this.service != null )
        {
            this.handle = this.context.registerService ( EventHandlerFactory.class, this, this.serviceProperties );
        }
    }

    public void dispose ()
    {
        this.tracker.close ();
    }

    @Override
    public EventHandler createHandler ( final Map<String, String> properties )
    {
        return new AbstractEventHandler () {

            @Override
            public Event handleEvent ( final Event event, final InjectionContext context )
            {
                processEvent ( event );
                return event;
            }
        };
    }

    protected synchronized void processEvent ( final Event event )
    {
        if ( this.service != null )
        {
            this.service.publishEvent ( event );
        }
        else
        {
            logger.warn ( "Lost event - event: {}", event );
        }
    }

}
