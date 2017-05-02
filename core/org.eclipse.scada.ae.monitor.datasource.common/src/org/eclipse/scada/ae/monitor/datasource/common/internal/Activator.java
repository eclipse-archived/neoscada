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
package org.eclipse.scada.ae.monitor.datasource.common.internal;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.monitor.datasource.AbstractMonitorFactory;
import org.eclipse.scada.ae.monitor.datasource.common.bit.BitMonitorFactory;
import org.eclipse.scada.ae.monitor.datasource.common.level.LevelMonitorFactory;
import org.eclipse.scada.ae.monitor.datasource.common.list.ListMonitorFactory;
import org.eclipse.scada.ae.monitor.datasource.common.remote.RemoteAttributeMonitorFactoryImpl;
import org.eclipse.scada.ae.monitor.datasource.common.remote.RemoteBooleanAttributeAlarmMonitor;
import org.eclipse.scada.ae.monitor.datasource.common.remote.RemoteBooleanValueAlarmMonitor;
import org.eclipse.scada.ae.monitor.datasource.common.remote.RemoteValueMonitorFactoryImpl;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
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

import com.google.common.collect.Interner;

public class Activator implements BundleActivator
{

    private static BundleContext context;

    static BundleContext getContext ()
    {
        return context;
    }

    private Interner<String> stringInterner;

    private EventProcessor eventProcessor;

    private ExportedExecutorService executor;

    private ObjectPoolTracker<MasterItem> poolTracker;

    private ObjectPoolImpl<MonitorService> monitorServicePool;

    private ServiceRegistration<?> monitorServicePoolHandler;

    private final List<AbstractMonitorFactory> factories = new LinkedList<AbstractMonitorFactory> ();

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.stringInterner = InternerHelper.makeInterner ( "org.eclipse.scada.ae.monitor.datasource.common.stringInternerType", "strong" );

        this.eventProcessor = new EventProcessor ( context );
        this.eventProcessor.open ();

        this.executor = new ExportedExecutorService ( bundleContext.getBundle ().getSymbolicName (), 1, 1, 1, TimeUnit.MINUTES );

        this.poolTracker = new ObjectPoolTracker<MasterItem> ( context, MasterItem.class );
        this.poolTracker.open ();

        this.monitorServicePool = new ObjectPoolImpl<MonitorService> ();
        this.monitorServicePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.monitorServicePool, MonitorService.class );

        {
            final LevelMonitorFactory factory = new LevelMonitorFactory ( bundleContext, this.monitorServicePool, this.eventProcessor, this.executor, this.stringInterner, this.poolTracker );
            final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, LevelMonitorFactory.FACTORY_ID );
            properties.put ( Constants.SERVICE_DESCRIPTION, "Level monitor" );
            context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, factory, properties );
            this.factories.add ( factory );
        }

        {
            final BitMonitorFactory factory = new BitMonitorFactory ( bundleContext, this.monitorServicePool, this.eventProcessor, this.executor, this.stringInterner, this.poolTracker );
            final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, BitMonitorFactory.FACTORY_ID );
            properties.put ( Constants.SERVICE_DESCRIPTION, "Boolean monitor" );
            context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, factory, properties );
            this.factories.add ( factory );
        }

        {
            final ListMonitorFactory factory = new ListMonitorFactory ( bundleContext, this.monitorServicePool, this.eventProcessor, this.executor, this.stringInterner, this.poolTracker );
            final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, ListMonitorFactory.FACTORY_ID );
            properties.put ( Constants.SERVICE_DESCRIPTION, "List monitor" );
            context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, factory, properties );
            this.factories.add ( factory );
        }

        // remote attribute monitor service
        {
            final RemoteAttributeMonitorFactoryImpl factory = new RemoteAttributeMonitorFactoryImpl ( context, this.monitorServicePool, this.executor, this.poolTracker, this.eventProcessor );
            final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, RemoteBooleanAttributeAlarmMonitor.FACTORY_ID );
            properties.put ( Constants.SERVICE_DESCRIPTION, "Remote Boolean attribute alarms" );
            context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, factory, properties );
            this.factories.add ( factory );
        }

        // remote value monitor service
        {
            final RemoteValueMonitorFactoryImpl factory = new RemoteValueMonitorFactoryImpl ( context, this.monitorServicePool, this.executor, this.poolTracker, this.eventProcessor );
            final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, RemoteBooleanValueAlarmMonitor.FACTORY_ID );
            properties.put ( Constants.SERVICE_DESCRIPTION, "Remote Boolean value alarms" );
            context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, factory, properties );
            this.factories.add ( factory );
        }

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        for ( final AbstractMonitorFactory factory : this.factories )
        {
            factory.dispose ();
        }
        this.factories.clear ();

        this.monitorServicePoolHandler.unregister ();
        this.monitorServicePool.dispose ();

        this.poolTracker.close ();

        this.eventProcessor.close ();

        this.executor.shutdown ();

        Activator.context = null;
    }

}
