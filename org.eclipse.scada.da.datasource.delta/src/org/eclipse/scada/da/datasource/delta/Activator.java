/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.delta;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ExecutorService executor;

    private DeltaDataSourceFactory factory;

    private ServiceRegistration<ConfigurationFactory> registration;

    private ObjectPoolTracker<DataSource> dataSourceTracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = ExportedExecutorService.newSingleThreadExportedExecutor ( context.getBundle ().getSymbolicName () );

        this.dataSourceTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
        this.dataSourceTracker.open ();

        this.factory = new DeltaDataSourceFactory ( context, this.executor, this.dataSourceTracker );

        final Dictionary<String, String> properties = new Hashtable<String, String> ( 3 );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A delta DA data source" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, context.getBundle ().getSymbolicName () );

        this.registration = context.registerService ( ConfigurationFactory.class, this.factory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.registration.unregister ();
        this.factory.dispose ();
        this.executor.shutdown ();
    }

}
