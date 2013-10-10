/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.mqtt;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.da.server.common.DataItem;
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

    private static BundleContext context;

    private ExecutorService executor;

    private ObjectPoolImpl<DataItem> itemPool;

    private ServiceRegistration<?> itemPoolHandle;

    private MqttDataItemFactory factory;

    private ServiceRegistration<?> factoryHandle;

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

        this.factory = new MqttDataItemFactory ( this.executor, context, this.itemPool );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A data source status summarizer" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, MqttDataItemFactory.FACTORY_ID );

        this.factoryHandle = context.registerService ( ConfigurationFactory.class.getName (), this.factory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        if ( this.factoryHandle != null )
        {
            this.factoryHandle.unregister ();
        }
        if ( this.factory != null )
        {
            this.factory.dispose ();
        }
        this.factory = null;
        if ( this.itemPoolHandle != null )
        {
            this.itemPoolHandle.unregister ();
        }
        if ( this.itemPool != null )
        {
            this.itemPool.dispose ();
        }
        this.itemPool = null;
        if ( this.executor != null )
        {
            this.executor.shutdown ();
        }
        this.executor = null;

        Activator.context = null;
    }
}
