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
package org.eclipse.scada.core.connection.provider;

import java.util.Map;

import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ConnectionTracker
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionTracker.class );

    private SingleServiceTracker<ConnectionService> tracker;

    private Filter filter;

    private final Listener listener;

    private ConnectionService service;

    private final BundleContext context;

    private final Class<? extends ConnectionService> clazz;

    public interface Listener
    {
        public void setConnection ( final ConnectionService connectionService );
    }

    public ConnectionTracker ( final BundleContext context, final Listener listener, final Class<? extends ConnectionService> clazz )
    {
        this.context = context;
        this.listener = listener;
        this.clazz = clazz;
    }

    protected SingleServiceTracker<ConnectionService> createTracker ()
    {
        synchronized ( this )
        {
            if ( this.filter == null )
            {
                this.filter = createFilter ();
            }

            logger.debug ( "Creating tracker for: {}", this.filter );

            if ( this.filter != null )
            {
                return new SingleServiceTracker<ConnectionService> ( this.context, this.filter, new SingleServiceListener<ConnectionService> () {

                    @Override
                    public void serviceChange ( final ServiceReference<ConnectionService> reference, final ConnectionService service )
                    {
                        ConnectionTracker.this.setService ( reference, service );
                    }
                } );
            }
            return null;
        }
    }

    protected Filter createFilter ()
    {
        try
        {
            Class<?> filterClazz;
            if ( this.clazz != null )
            {
                filterClazz = this.clazz;
            }
            else
            {
                filterClazz = ConnectionService.class;
            }

            return FilterUtil.createAndFilter ( filterClazz.getName (), createFilterParameters () );
        }
        catch ( final InvalidSyntaxException e )
        {
            logger.warn ( "Failed to create filter", e );
            return null;
        }
    }

    protected abstract Map<String, String> createFilterParameters ();

    public synchronized void listen ()
    {
        if ( this.tracker == null )
        {
            this.tracker = createTracker ();
        }

        if ( this.tracker != null )
        {
            logger.debug ( "Opening tracker" );
            this.tracker.open ();
        }
    }

    public synchronized void open ()
    {
        listen ();
    }

    public synchronized void close ()
    {
        unlisten ();
    }

    public synchronized void unlisten ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
        }
    }

    protected synchronized void setService ( final ServiceReference<ConnectionService> reference, final ConnectionService service )
    {
        logger.debug ( "Set service: {} -> {}", new Object[] { reference, service } );
        this.service = service;

        if ( this.listener != null )
        {
            this.listener.setConnection ( service );
        }
    }

    public synchronized ConnectionService getService ()
    {
        return this.service;
    }

    public ConnectionService waitForService ( final long timeout ) throws InterruptedException
    {
        if ( this.tracker == null )
        {
            return null;
        }
        return this.tracker.waitForService ( timeout );
    }
}
