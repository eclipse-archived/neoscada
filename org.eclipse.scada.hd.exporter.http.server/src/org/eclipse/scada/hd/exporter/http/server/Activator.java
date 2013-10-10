/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http.server;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.hd.exporter.http.HttpExporter;
import org.eclipse.scada.hd.exporter.http.server.internal.JsonServlet;
import org.eclipse.scada.hd.exporter.http.server.internal.LocalHttpExporter;
import org.eclipse.scada.hd.exporter.http.server.internal.RemoteHttpExporter;
import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.HttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{
    private static final String SERVLET_PATH = "/org.eclipse.scada.hd";

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private final SingleServiceListener<HttpService> httpServiceListener = new SingleServiceListener<HttpService> () {
        @Override
        public void serviceChange ( final ServiceReference<HttpService> reference, final HttpService service )
        {
            if ( Activator.this.httpService != null )
            {
                Activator.this.httpService.unregister ( SERVLET_PATH );
                Activator.this.httpService.unregister ( "/media" );
                Activator.this.httpService = null;
            }
            Activator.this.httpService = service;
            try
            {
                Activator.this.httpService.registerServlet ( SERVLET_PATH, Activator.this.jsonServlet, null, null );
                Activator.this.httpService.registerResources ( SERVLET_PATH + "/ui", "/ui", null );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to handle http service change", e );
            }
        }
    };

    private final SingleServiceListener<HttpExporter> exporterServiceListener = new SingleServiceListener<HttpExporter> () {
        @Override
        public void serviceChange ( final ServiceReference<HttpExporter> reference, final HttpExporter service )
        {
            Activator.this.jsonServlet.setExporter ( service );
        }
    };

    private final SingleServiceListener<Service> localHdServerServiceListener = new SingleServiceListener<Service> () {
        @Override
        public void serviceChange ( final ServiceReference<Service> reference, final Service service )
        {
            if ( Activator.this.localHdServerServiceRegistration != null )
            {
                Activator.this.localHdServerServiceRegistration.unregister ();
            }
            if ( service != null )
            {
                final Dictionary<String, Object> props = new Hashtable<String, Object> ();
                props.put ( Constants.SERVICE_RANKING, 20 );
                try
                {
                    Activator.this.localHdServerServiceRegistration = context.registerService ( HttpExporter.class, new LocalHttpExporter ( service ), props );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to handle service change", e );
                }
            }
        }
    };

    private final JsonServlet jsonServlet = new JsonServlet ();

    private static BundleContext context;

    private HttpService httpService = null;

    private SingleServiceTracker<HttpService> httpServiceTracker;

    private SingleServiceTracker<HttpExporter> exporterServiceTracker;

    private SingleServiceTracker<Service> localHdServerServiceTracker;

    private ServiceRegistration<HttpExporter> localHdServerServiceRegistration;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Activator.context = context;

        // start servlet
        this.httpServiceTracker = new SingleServiceTracker<HttpService> ( context, HttpService.class, this.httpServiceListener );
        this.httpServiceTracker.open ();

        this.exporterServiceTracker = new SingleServiceTracker<HttpExporter> ( context, HttpExporter.class, this.exporterServiceListener );
        this.exporterServiceTracker.open ();

        this.localHdServerServiceTracker = new SingleServiceTracker<Service> ( context, Service.class, this.localHdServerServiceListener );
        this.localHdServerServiceTracker.open ();

        // try to start local exporter
        registerRemoteExporter ( context );
    }

    private void registerRemoteExporter ( final BundleContext context )
    {
        // TODO: create clientConnection
        final Dictionary<String, Object> props = new Hashtable<String, Object> ( 1 );
        props.put ( Constants.SERVICE_RANKING, 10 );
        context.registerService ( HttpExporter.class.getName (), new RemoteHttpExporter (), props );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.httpServiceTracker.close ();
        this.httpServiceTracker = null;
        this.exporterServiceTracker.close ();
        this.exporterServiceTracker = null;
        if ( this.localHdServerServiceRegistration != null )
        {
            this.localHdServerServiceRegistration.unregister ();
        }

        Activator.context = null;
    }
}
