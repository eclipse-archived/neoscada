/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.info;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.info.internal.InfoServiceFactory;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator implements BundleActivator
{
    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.ae.server.info";

    // The shared instance
    private static Activator plugin;

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private ExecutorService executor;

    private ObjectPoolImpl<DataSource> dataSourcePool;

    private InfoServiceFactory factory;

    private ServiceRegistration<ConfigurationFactory> factoryHandle;

    private ServiceRegistration<?> dataSourcePoolHandler;

    private ObjectPoolTracker<MonitorService> monitorPoolTracker;

    /**
     * The constructor
     */
    public Activator ()
    {
    }

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        plugin = this;

        logger.info ( "Starting up..." );

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.monitorPoolTracker = new ObjectPoolTracker<MonitorService> ( context, MonitorService.class );
        this.monitorPoolTracker.open ();

        this.dataSourcePool = new ObjectPoolImpl<DataSource> ();
        this.dataSourcePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.dataSourcePool, DataSource.class );

        this.factory = new InfoServiceFactory ( context, this.executor, this.monitorPoolTracker, this.dataSourcePool );
        final Dictionary<String, String> properties = new Hashtable<String, String> ( 2 );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "An aggregator for all monitor states" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, InfoServiceFactory.FACTORY_ID );

        this.factoryHandle = context.registerService ( ConfigurationFactory.class, this.factory, properties );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.factoryHandle.unregister ();
        this.factory.dispose ();
        this.factory = null;

        this.dataSourcePoolHandler.unregister ();

        // shut down executor
        this.executor.shutdown ();

        plugin = null;
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }
}
