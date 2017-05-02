/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.common;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.hd.server.common.internal.ServiceImpl;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

/**
 * This activator registers the common OSGi based
 * implementation of the HD server side service
 * 
 * @author Jens Reimann
 * @since 0.14.0
 */
public class Activator implements BundleActivator
{
    private ServiceImpl service;

    private ServiceRegistration<Service> serviceRegistration;

    private ExportedExecutorService executor;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = new ExportedExecutorService ( "org.eclipse.scada.hd.server.common", 1, 1, 1, TimeUnit.MINUTES );
        this.service = new ServiceImpl ( context, this.executor );
        this.service.start ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "An Eclipse SCADA HD service implementation" );
        this.serviceRegistration = context.registerService ( Service.class, this.service, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.serviceRegistration.unregister ();

        this.service.stop ();
        this.service = null;

        this.executor.shutdown ();
    }

}
