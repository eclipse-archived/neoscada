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
package org.eclipse.scada.ae.monitor.datasource;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator
{
    private static Activator instance;

    private ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> configAdminTracker;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        instance = this;

        this.configAdminTracker = new ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> ( context, ConfigurationAdministrator.class, null );
        this.configAdminTracker.open ();
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.configAdminTracker.close ();

        instance = null;
    }

    public static ConfigurationAdministrator getConfigAdmin ()
    {
        return Activator.instance.configAdminTracker.getService ();
    }
}
