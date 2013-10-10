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
package org.eclipse.scada.da.client.ngp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

/**
 * An OSGi bundle activator which registers the DriverAdapter with OSGi
 * 
 * @author Jens Reimann
 * @since 1.0.0
 */
public class Activator implements BundleActivator
{
    private org.eclipse.scada.core.client.DriverFactory factory;

    private ServiceRegistration<org.eclipse.scada.core.client.DriverFactory> handle;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.factory = new DriverFactoryImpl ();

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( org.eclipse.scada.core.client.DriverFactory.INTERFACE_NAME, "da" );
        properties.put ( org.eclipse.scada.core.client.DriverFactory.DRIVER_NAME, "ngp" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA DA NGP Adapter" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = context.registerService ( org.eclipse.scada.core.client.DriverFactory.class, this.factory, properties );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.handle.unregister ();
        this.factory = null;
    }

}
