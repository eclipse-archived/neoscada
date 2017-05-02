/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jaxws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.eclipse.scada.utils.osgi.exporter.AbstractExporter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndpointExporter extends AbstractExporter
{

    private final static Logger logger = LoggerFactory.getLogger ( EndpointExporter.class );

    private final String baseAddress;

    private final Map<ServiceReference<?>, Endpoint> endpoints = new HashMap<ServiceReference<?>, Endpoint> ();

    public EndpointExporter ( final BundleContext context, final String baseAddress ) throws InvalidSyntaxException
    {
        super ( context );
        this.baseAddress = baseAddress;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        List<Endpoint> endpoints;
        synchronized ( this )
        {
            endpoints = new ArrayList<Endpoint> ( this.endpoints.values () );
            this.endpoints.clear ();
        }

        for ( final Endpoint e : endpoints )
        {
            e.stop ();
        }
    }

    @Override
    protected void unexportService ( final ServiceReference<?> serviceReference )
    {
        final Endpoint e;
        synchronized ( this )
        {
            e = this.endpoints.remove ( serviceReference );
        }

        if ( e != null )
        {
            if ( e.isPublished () )
            {
                try
                {
                    e.stop ();
                }
                catch ( final Exception ex )
                {
                    logger.warn ( "Failed to stop export", ex );
                }
            }
        }
    }

    @Override
    protected void exportService ( final ServiceReference<?> reference, final Object service )
    {
        logger.info ( "Exporting service: {} -> {}", new Object[] { reference } );

        Endpoint e = null;
        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();

        try
        {
            Thread.currentThread ().setContextClassLoader ( service.getClass ().getClassLoader () );

            final String[] clazzes = (String[])reference.getProperty ( Constants.OBJECTCLASS );

            for ( final String clazzName : clazzes )
            {
                final Class<?> clazz = reference.getBundle ().loadClass ( clazzName );

                final WebService webService = clazz.getAnnotation ( WebService.class );

                if ( webService != null )
                {
                    e = Endpoint.create ( service );

                    final String address = makeAddress ( reference, service, webService );
                    e.publish ( address );
                    e = this.endpoints.put ( reference, e );

                    if ( e != null )
                    {
                        // we found a previous export ... stop the old one
                        try
                        {
                            e.stop ();
                        }
                        catch ( final Throwable e2 )
                        {
                            logger.warn ( "Failed to stop previous export", e2 );
                        }
                        e = null;
                    }

                }
                else
                {
                    logger.warn ( "No webservice annotation found on {}", clazz );
                }

            }

        }
        catch ( final Exception ex )
        {
            logger.warn ( "Failed to export", ex );
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
            if ( e != null )
            {
                e.stop ();
            }
        }
    }

    private String makeAddress ( final ServiceReference<?> reference, final Object service, final WebService webService )
    {
        String serviceName = webService.serviceName ();
        if ( serviceName == null )
        {
            if ( reference.getProperty ( Constants.SERVICE_PID ) != null )
            {
                serviceName = reference.getProperty ( Constants.SERVICE_PID ).toString ();
            }
        }

        return this.baseAddress + "/" + serviceName;
    }
}
