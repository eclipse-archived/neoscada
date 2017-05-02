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
package org.eclipse.scada.da.master;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.master.internal.MasterFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
    private MasterFactory masterFactory;

    private ServiceRegistration<ConfigurationFactory> masterHandle;

    private ObjectPoolTracker<DataSource> dataSourceTracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Dictionary<String, Object> properties;

        this.dataSourceTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
        this.dataSourceTracker.open ();

        // master service
        this.masterFactory = new MasterFactory ( context, this.dataSourceTracker );
        properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "master.item" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A configuration factory for master items" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.masterHandle = context.registerService ( ConfigurationFactory.class, this.masterFactory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.dataSourceTracker.close ();

        this.masterHandle.unregister ();
        this.masterFactory.dispose ();
        this.masterFactory = null;
    }

}
