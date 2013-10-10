/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.server.osgi;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.server.Service;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private SingleServiceTracker<ConfigurationAdministrator> tracker;

    private Service service;

    private ServiceRegistration<Service> handle;

    private ExportedExecutorService executor;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        this.executor = new ExportedExecutorService ( "org.eclipse.scada.ca.server.osgi", 1, 1, 1, TimeUnit.MINUTES );

        Activator.context = bundleContext;
        this.tracker = new SingleServiceTracker<ConfigurationAdministrator> ( bundleContext, ConfigurationAdministrator.class, new SingleServiceListener<ConfigurationAdministrator> () {

            @Override
            public void serviceChange ( final ServiceReference<ConfigurationAdministrator> reference, final ConfigurationAdministrator service )
            {
                setService ( service );
            }
        } );
        this.tracker.open ();
    }

    protected void setService ( final ConfigurationAdministrator service )
    {
        if ( this.handle != null )
        {
            this.handle.unregister ();
            this.handle = null;

        }
        if ( this.service != null )
        {
            try
            {
                this.service.stop ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to stop service", e );
            }
            this.service = null;
        }

        if ( service != null )
        {
            try
            {
                final ServiceImpl newService = new ServiceImpl ( service, context, this.executor );

                newService.start ();
                this.service = newService;

                final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
                properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
                properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA CA Server Interface" );
                this.handle = context.registerService ( Service.class, this.service, properties );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to start new service", e );
            }

        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.tracker.close ();
        Activator.context = null;

        this.executor.shutdown ();
    }

}
