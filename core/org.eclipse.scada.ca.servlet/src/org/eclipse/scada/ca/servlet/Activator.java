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
package org.eclipse.scada.ca.servlet;

import javax.servlet.ServletException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator, ServiceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private BundleContext context;

    private HttpService service;

    private HttpContext httpContext;

    private ServiceReference<?> serviceReference;

    private ListServlet servlet;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.context = context;
        addService ( context.getServiceReference ( HttpService.class ) );
        context.addServiceListener ( this, String.format ( "(%s=%s)", Constants.OBJECTCLASS, HttpService.class.getName () ) );
    }

    private void addService ( final ServiceReference<?> serviceReference )
    {
        if ( serviceReference == null )
        {
            return;
        }
        this.service = (HttpService)this.context.getService ( serviceReference );
        this.serviceReference = serviceReference;
        if ( this.service != null )
        {
            configureService ();
        }
    }

    private void removeService ( final ServiceReference<?> serviceReference )
    {
        if ( serviceReference != this.serviceReference )
        {
            return;
        }
        unconfigureService ();
        this.serviceReference = null;
        this.service = null;
    }

    private void unconfigureService ()
    {
        this.service.unregister ( "/ca" );
        this.service.unregister ( "/ca/resources" );

        this.servlet.destroy ();
        this.servlet = null;

        this.httpContext = null;
    }

    private void configureService ()
    {
        logger.info ( "Configuring http service" );

        this.httpContext = this.service.createDefaultHttpContext ();
        try
        {
            this.service.registerResources ( "/ca/resources", "/resources", this.httpContext );
            this.service.registerServlet ( "/ca", this.servlet = new ListServlet ( this.context ), null, this.httpContext );
        }
        catch ( final NamespaceException e )
        {
            logger.warn ( "Failed to configure service", e );
        }
        catch ( final ServletException e )
        {
            logger.warn ( "Failed to configure service", e );
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.context.removeServiceListener ( this );
    }

    @Override
    public void serviceChanged ( final ServiceEvent event )
    {
        switch ( event.getType () )
        {
        case ServiceEvent.REGISTERED:
            addService ( event.getServiceReference () );
            break;
        case ServiceEvent.UNREGISTERING:
            removeService ( event.getServiceReference () );
            break;
        }
    }

}
