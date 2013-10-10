/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.arduino;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.server.arduino.factory.ConfigurationFactoryImpl;
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

    private ObjectPoolImpl<DataItem> itemPool;

    private ServiceRegistration<?> itemPoolHandle;

    private ExecutorService executor;

    private ConfigurationFactoryImpl service;

    private ServiceRegistration<ConfigurationFactory> factoryHandle;

    static BundleContext getContext ()
    {
        return context;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        Activator.context = bundleContext;

        this.itemPool = new ObjectPoolImpl<DataItem> ();

        this.itemPoolHandle = ObjectPoolHelper.registerObjectPool ( context, this.itemPool, DataItem.class );

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.service = new ConfigurationFactoryImpl ( context, this.itemPool, this.executor );

        {
            final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.scada.da.server.arduino.device" );
            properties.put ( Constants.SERVICE_DESCRIPTION, "Arduino OpenSCADA Device" );
            this.factoryHandle = context.registerService ( ConfigurationFactory.class, this.service, properties );
        }

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.factoryHandle.unregister ();

        this.itemPoolHandle.unregister ();
        this.itemPool.dispose ();

        this.service.dispose ();

        this.executor.shutdown ();
        this.executor = null;

        Activator.context = null;
    }

}
