/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

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
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
    private static Activator INSTANCE;

    private VariableManagerImpl variableManager;

    private ExecutorService executor;

    private ObjectPoolImpl<DataItem> itemPool;

    private ServiceRegistration<?> itemPoolHandle;

    public static VariableManager getVariableManager ()
    {
        return INSTANCE.variableManager;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Activator.INSTANCE = this;

        this.itemPool = new ObjectPoolImpl<DataItem> ();

        this.itemPoolHandle = ObjectPoolHelper.registerObjectPool ( context, this.itemPool, DataItem.class );

        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        {
            this.variableManager = new VariableManagerImpl ( this.executor, this.itemPool );
            final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, VariableManager.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class.getName (), this.variableManager, properties );
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.variableManager != null )
        {
            this.variableManager.dispose ();
            this.variableManager = null;
        }

        if ( this.itemPool != null )
        {
            this.itemPoolHandle.unregister ();
            this.itemPool.dispose ();
            this.itemPool = null;
        }

        this.executor.shutdown ();
        this.executor = null;

        Activator.INSTANCE = null;
    }
}
