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
package org.eclipse.scada.ae.server.injector.internal;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.ae.server.injector.monitor.EventMonitorFactory;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
    private EventInjectorManager manager;

    private ExecutorService executor;

    private EventMonitorFactory factory;

    private ServiceRegistration<?> factoryServiceHandle;

    private ObjectPoolImpl<MonitorService> monitorServicePool;

    private ServiceRegistration<?> monitorServicePoolHandler;

    private EventProcessor eventProcessor;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.eventProcessor = new EventProcessor ( context );
        this.eventProcessor.open ();

        this.monitorServicePool = new ObjectPoolImpl<MonitorService> ();
        this.monitorServicePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.monitorServicePool, MonitorService.class );

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        // register factory
        this.factory = new EventMonitorFactory ( context, this.executor, this.monitorServicePool, this.eventProcessor );
        final Hashtable<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, EventMonitorFactory.FACTORY_ID );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Filter based event monitor" );
        this.factoryServiceHandle = context.registerService ( new String[] { ConfigurationFactory.class.getName (), AknHandler.class.getName () }, this.factory, properties );

        if ( this.manager == null )
        {
            this.manager = new EventInjectorManager ( this.factory );
            this.manager.start ();
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.manager != null )
        {
            this.manager.stop ();
            this.manager = null;
        }

        // remove factory
        if ( this.factoryServiceHandle != null )
        {
            this.factoryServiceHandle.unregister ();
            this.factoryServiceHandle = null;
        }
        if ( this.factory != null )
        {
            this.factory.dispose ();
            this.factory = null;
        }

        // shut down object pool
        this.monitorServicePoolHandler.unregister ();
        this.monitorServicePool.dispose ();

        // shut down event processor
        this.eventProcessor.close ();

        this.executor.shutdown ();
        this.executor = null;
    }

}
