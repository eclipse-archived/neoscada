/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - generalize event injection
 *******************************************************************************/
package org.eclipse.scada.ae.server.http;

import org.eclipse.scada.ae.server.http.internal.JsonServlet;
import org.eclipse.scada.ae.server.injector.EventInjectorQueue;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static final String SERVLET_PATH = "/org.eclipse.scada.ae";

    private BundleContext context;

    private ServiceTracker<HttpService, HttpService> httpServiceTracker;

    private HttpService httpService;

    private EventInjectorQueue injector;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;

        this.injector = new EventInjectorQueue ( context );

        this.httpServiceTracker = new ServiceTracker<HttpService, HttpService> ( context, HttpService.class, createHttpServiceTrackerCustomizer () );
        this.httpServiceTracker.open ();
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        // do not process any events anymore
        this.httpServiceTracker.close ();

        this.injector.dispose ();

        this.context = null;
    }

    private void bind ()
    {
        if ( this.httpService == null )
        {
            return;
        }
        try
        {
            // register servlet
            this.httpService.registerServlet ( SERVLET_PATH, new JsonServlet ( this.injector ), null, null );
            this.httpService.registerResources ( SERVLET_PATH + "/ui", "/ui", null );
        }
        catch ( final Exception e )
        {
            logger.error ( "Failed to bind", e );
        }
    }

    private void unbind ()
    {
        if ( this.httpService != null )
        {
            this.httpService.unregister ( SERVLET_PATH + "/ui" );
            this.httpService.unregister ( SERVLET_PATH );
        }
    }

    private ServiceTrackerCustomizer<HttpService, HttpService> createHttpServiceTrackerCustomizer ()
    {
        return new ServiceTrackerCustomizer<HttpService, HttpService> () {
            @Override
            public HttpService addingService ( final ServiceReference<HttpService> reference )
            {
                final HttpService service = Activator.this.context.getService ( reference );
                synchronized ( Activator.this )
                {
                    if ( Activator.this.httpService == null )
                    {
                        Activator.this.httpService = service;
                        Activator.this.bind ();
                    }
                }
                return service;
            }

            @Override
            public void modifiedService ( final ServiceReference<HttpService> reference, final HttpService service )
            {
                // pass
            }

            @Override
            public void removedService ( final ServiceReference<HttpService> reference, final HttpService service )
            {
                synchronized ( Activator.this )
                {
                    if ( service != Activator.this.httpService )
                    {
                        return;
                    }
                    Activator.this.unbind ();
                    Activator.this.httpService = null;
                    Activator.this.context.ungetService ( reference );
                }
            }
        };
    }
}
