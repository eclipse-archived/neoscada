/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.core.client.DriverFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private org.eclipse.scada.da.client.sfp.DriverFactoryImpl factory;

    private ServiceRegistration<DriverFactory> handle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.factory = new DriverFactoryImpl ();

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( org.eclipse.scada.core.client.DriverFactory.INTERFACE_NAME, "da" );
        properties.put ( org.eclipse.scada.core.client.DriverFactory.DRIVER_NAME, "sfp" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA DA SFP Adapter" );
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
        this.factory = null;
    }

}
