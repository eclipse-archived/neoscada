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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractEventQueryListener
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractEventQueryListener.class );

    protected final Lock lock;

    private final ProxyEventQuery proxyEventQuery;

    protected final String info;

    private boolean disposed;

    public AbstractEventQueryListener ( final ProxyEventQuery proxyEventQuery, final Lock lock, final String info )
    {
        this.lock = lock;
        this.proxyEventQuery = proxyEventQuery;
        this.info = info;
    }

    protected void addEvents ( final List<Event> events )
    {
        if ( events == null )
        {
            return;
        }

        logger.debug ( "adding events: {}", events.size () );

        this.lock.lock ();
        try
        {
            if ( this.disposed )
            {
                logger.info ( "We are disposed. Discard event" );
                return;
            }

            this.proxyEventQuery.addEvents ( events );
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    public void dispose ()
    {
        this.lock.lock ();
        try
        {
            this.disposed = true;
        }
        finally
        {
            this.lock.unlock ();
        }
    }
}
