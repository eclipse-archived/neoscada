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
package org.eclipse.scada.da.component.script;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
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

    private ScriptComponentFactory factory;

    private ServiceRegistration<ConfigurationFactory> handle;

    private ExecutorService executor;

    private ObjectPoolImpl<DataItem> objectPool;

    private ServiceRegistration<?> poolHandle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( bundleContext.getBundle ().getSymbolicName () ) );

        this.objectPool = new ObjectPoolImpl<DataItem> ();

        this.factory = new ScriptComponentFactory ( this.executor, this.objectPool, bundleContext );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ( 2 );

        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, bundleContext.getBundle ().getSymbolicName () );

        this.handle = bundleContext.registerService ( ConfigurationFactory.class, this.factory, properties );

        // register late in order to reduce events
        this.poolHandle = ObjectPoolHelper.registerObjectPool ( bundleContext, this.objectPool, DataItem.class );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.executor.shutdown ();
        this.handle.unregister ();
        this.factory.dispose ();

        this.poolHandle.unregister ();
        this.objectPool.dispose ();

        Activator.context = null;
    }

}
