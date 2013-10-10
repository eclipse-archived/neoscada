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
package org.eclipse.scada.ae.server.event.proxy;

import java.util.List;
import java.util.concurrent.locks.Lock;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.event.EventListener;
import org.eclipse.scada.ae.server.common.event.EventQuery;
import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LocalEventQueryListener extends AbstractEventQueryListener
{

    private final static Logger logger = LoggerFactory.getLogger ( LocalEventQueryListener.class );

    private final SingleServiceTracker<EventQuery> tracker;

    private EventQuery service;

    private final SingleServiceListener<EventQuery> queryListener = new SingleServiceListener<EventQuery> () {

        @Override
        public void serviceChange ( final ServiceReference<EventQuery> reference, final EventQuery service )
        {
            setQueryService ( service );
        }
    };

    private final EventListener eventQueryListener = new EventListener () {

        @Override
        public void handleEvent ( final List<Event> event )
        {
            LocalEventQueryListener.this.addEvents ( event );
        }
    };

    public LocalEventQueryListener ( final BundleContext context, final String eventQueryId, final ProxyEventQuery proxyEventQuery, final Lock lock ) throws InvalidSyntaxException
    {
        super ( proxyEventQuery, lock, eventQueryId );
        logger.info ( "Creating new listener - query: {}", eventQueryId );

        this.tracker = new SingleServiceTracker<EventQuery> ( context, FilterUtil.createClassAndPidFilter ( EventQuery.class, eventQueryId ), this.queryListener );
        this.tracker.open ();
    }

    @Override
    public void dispose ()
    {
        this.tracker.close ();

        super.dispose ();
    }

    protected void setQueryService ( final EventQuery service )
    {
        this.lock.lock ();
        try
        {
            if ( service == this.service )
            {
                return;
            }

            if ( this.service != null )
            {
                this.service.removeListener ( this.eventQueryListener );
            }

            this.service = service;

            if ( this.service != null )
            {
                service.addListener ( this.eventQueryListener );
            }
        }
        finally
        {
            this.lock.unlock ();
        }
    }

}