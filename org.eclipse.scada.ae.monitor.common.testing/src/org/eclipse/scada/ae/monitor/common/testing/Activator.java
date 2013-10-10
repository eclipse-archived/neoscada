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
package org.eclipse.scada.ae.monitor.common.testing;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private EventProcessor processor;

    private TestingMonitor service;

    private ObjectPoolImpl<MonitorService> monitorServicePool;

    private ServiceRegistration<?> monitorServicePoolHandler;

    private ExecutorService executor;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = Executors.newSingleThreadExecutor ();

        this.processor = new EventProcessor ( context );
        this.processor.open ();
        this.service = new TestingMonitor ( context, this.executor, this.processor, context.getBundle ().getSymbolicName () + ".test" );

        this.monitorServicePool = new ObjectPoolImpl<MonitorService> ();
        this.monitorServicePoolHandler = ObjectPoolHelper.registerObjectPool ( context, this.monitorServicePool, MonitorService.class.getName () );

        this.monitorServicePool.addService ( this.service.getId (), this.service, new Hashtable<String, String> () );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.monitorServicePoolHandler.unregister ();

        this.monitorServicePool.dispose ();
        this.processor.close ();
        this.service.stop ();

        this.executor.shutdown ();
    }

}
