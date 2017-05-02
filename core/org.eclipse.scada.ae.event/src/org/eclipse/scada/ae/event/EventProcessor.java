/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.event;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class EventProcessor
{
    private final SingleServiceTracker<EventService> tracker;

    private final Filter filter;

    private final Queue<Event> eventQueue = new LinkedList<Event> ();

    private final BundleContext context;

    private EventService service;

    public EventProcessor ( final BundleContext context ) throws InvalidSyntaxException
    {
        this ( "(" + Constants.OBJECTCLASS + "=" + EventService.class.getName () + ")", context );
    }

    public EventProcessor ( final Filter filter, final BundleContext context )
    {
        this.filter = filter;
        this.context = context;
        this.tracker = new SingleServiceTracker<EventService> ( this.context, this.filter, new SingleServiceListener<EventService> () {

            @Override
            public void serviceChange ( final ServiceReference<EventService> reference, final EventService service )
            {
                EventProcessor.this.setService ( service );
            }
        } );
    }

    protected synchronized void setService ( final EventService service )
    {
        this.service = service;
        if ( this.service != null )
        {
            publishStoredEvents ( this.service );
        }
    }

    public EventProcessor ( final String filter, final BundleContext context ) throws InvalidSyntaxException
    {
        this ( FrameworkUtil.createFilter ( filter ), context );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    public synchronized void publishEvent ( final Event event )
    {
        final EventService service = this.service;
        if ( service != null )
        {
            service.publishEvent ( event );
        }
        else
        {
            this.eventQueue.add ( event );
        }
    }

    private void publishStoredEvents ( final EventService service )
    {
        Event event = null;
        while ( ( event = this.eventQueue.poll () ) != null )
        {
            service.publishEvent ( event );
        }
    }

}
