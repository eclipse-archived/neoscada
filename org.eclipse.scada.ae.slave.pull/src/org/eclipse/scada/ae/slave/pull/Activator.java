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
package org.eclipse.scada.ae.slave.pull;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
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

    private PullManager pullManager;

    private ServiceRegistration<ConfigurationFactory> handle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.pullManager = new PullManager ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, PullManager.FACTORY_ID );
        properties.put ( Constants.SERVICE_DESCRIPTION, "An AE pull manager configuration" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = bundleContext.registerService ( ConfigurationFactory.class, this.pullManager, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.handle.unregister ();

        this.pullManager.dispose ();
        this.pullManager = null;

        Activator.context = null;
    }

}
