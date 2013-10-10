/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.http;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ae.server.http.filter.EventFilter;
import org.eclipse.scada.ae.server.http.filter.EventFilterImpl;
import org.eclipse.scada.ae.server.http.internal.JsonServlet;
import org.eclipse.scada.ae.server.http.monitor.EventMonitorFactory;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
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

    private ExecutorService executor;

    private EventProcessor eventProcessor;

    private ServiceTracker<HttpService, HttpService> httpServiceTracker;

    private HttpService httpService;

    private ServiceRegistration<?> factoryServiceHandle;

    private EventMonitorFactory factory;

    private ObjectPoolImpl<MonitorService> monitorServicePool;

    private ServiceRegistration<?> monitorServicePoolHandler;

    private EventFilter eventFilter;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.eventProcessor = new EventProcessor ( context );
        this.eventFilter = new EventFilterImpl ( context, context.getBundle ().getSymbolicName () + ".eventFilter" );

        this.monitorServicePool = new ObjectPoolImpl<MonitorService> ();
        this.monitorServicePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.monitorServicePool, MonitorService.class );

        this.httpServiceTracker = new ServiceTracker<HttpService, HttpService> ( context, HttpService.class, createHttpServiceTrackerCustomizer () );

        this.eventProcessor.open ();

        // register factory
        this.factory = new EventMonitorFactory ( this.context, this.executor, this.monitorServicePool, this.eventProcessor );
        final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, EventMonitorFactory.FACTORY_ID );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Filter based http event monitor" );
        this.factoryServiceHandle = this.context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, this.factory, properties );

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

        // remove factory
        if ( this.factoryServiceHandle != null )
        {
            this.factoryServiceHandle.unregister ();
        }
        if ( this.factory != null )
        {
            this.factory.dispose ();
        }

        // shut down event processor
        this.eventProcessor.close ();

        // shut down object pool
        this.monitorServicePoolHandler.unregister ();
        this.monitorServicePool.dispose ();

        // shut down executor
        this.executor.shutdown ();

        this.eventFilter.dispose ();

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
            this.httpService.registerServlet ( SERVLET_PATH, new JsonServlet ( this.eventProcessor, this.factory, this.eventFilter ), null, null );
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
