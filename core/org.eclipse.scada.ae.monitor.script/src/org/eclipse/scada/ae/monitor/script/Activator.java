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
package org.eclipse.scada.ae.monitor.script;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import com.google.common.collect.Interner;

public class Activator implements BundleActivator
{

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private Interner<String> stringInterner;

    private ScriptMonitorFactory factory;

    private ExecutorService executor;

    private EventProcessor eventProcessor;

    private ObjectPoolTracker<DataSource> dataSourcePoolTracker;

    private ObjectPoolTracker<MasterItem> masterItemPoolTracker;

    private ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> configAdminTracker;

    private ObjectPoolImpl<MonitorService> monitorServicePool;

    private ServiceRegistration<?> monitorServicePoolHandler;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.stringInterner = InternerHelper.makeInterner ( "org.eclipse.scada.ae.monitor.datasource.common.stringInternerType", "strong" );

        this.executor = new ExportedExecutorService ( bundleContext.getBundle ().getSymbolicName (), 1, 1, 1, TimeUnit.MINUTES );

        this.eventProcessor = new EventProcessor ( context );
        this.eventProcessor.open ();

        this.dataSourcePoolTracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
        this.dataSourcePoolTracker.open ();

        this.masterItemPoolTracker = new ObjectPoolTracker<MasterItem> ( context, MasterItem.class );
        this.masterItemPoolTracker.open ();

        this.configAdminTracker = new ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> ( context, ConfigurationAdministrator.class, null );
        this.configAdminTracker.open ();

        this.monitorServicePool = new ObjectPoolImpl<MonitorService> ();
        this.monitorServicePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.monitorServicePool, MonitorService.class );

        this.factory = new ScriptMonitorFactory ( bundleContext, this.executor, this.stringInterner, this.eventProcessor, this.dataSourcePoolTracker, this.masterItemPoolTracker, this.configAdminTracker, this.monitorServicePool );

        final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, ScriptMonitorFactory.FACTORY_ID );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Script monitor" );
        context.registerService ( new String[] { ConfigurationFactory.class.getName () }, this.factory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.factory.dispose ();

        this.monitorServicePoolHandler.unregister ();
        this.monitorServicePool.dispose ();

        this.dataSourcePoolTracker.close ();
        this.masterItemPoolTracker.close ();

        this.configAdminTracker.close ();

        this.eventProcessor.close ();
        this.executor.shutdown ();

        Activator.context = null;
    }

}
