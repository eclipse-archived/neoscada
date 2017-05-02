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
package org.eclipse.scada.ca.servlet.jaxws;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.utils.osgi.exporter.JaxWsExporter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ConfigurationAdministratorService service;

    private ServiceRegistration<RemoteConfigurationAdministrator> handle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.service = new ConfigurationAdministratorService ( context );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( JaxWsExporter.EXPORT_ENABLED, Boolean.TRUE );
        properties.put ( Constants.SERVICE_PID, context.getBundle ().getSymbolicName () );

        this.handle = context.registerService ( RemoteConfigurationAdministrator.class, this.service, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.handle.unregister ();
        this.service.dispose ();
    }

}
