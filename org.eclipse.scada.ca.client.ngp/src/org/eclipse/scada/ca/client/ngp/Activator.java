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
package org.eclipse.scada.ca.client.ngp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.core.client.DriverFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private org.eclipse.scada.ca.client.ngp.DriverFactoryImpl factory;

    private ServiceRegistration<DriverFactory> handle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.factory = new DriverFactoryImpl ();

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( org.eclipse.scada.core.client.DriverFactory.INTERFACE_NAME, "ca" );
        properties.put ( org.eclipse.scada.core.client.DriverFactory.DRIVER_NAME, "ngp" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA CA NGP Adapter" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = context.registerService ( org.eclipse.scada.core.client.DriverFactory.class, this.factory, properties );

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.handle.unregister ();
        Activator.context = null;
    }

}
