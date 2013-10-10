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
package org.eclipse.scada.da.server.osgi.summary;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

public class Activator implements BundleActivator
{
    private ObjectPoolTracker<DataSource> tracker;

    private ExecutorService executor;

    private ObjectPoolImpl<DataSource> pool;

    private FactoryImpl factory;

    private ServiceRegistration<?> factoryHandle;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.pool = new ObjectPoolImpl<DataSource> ();
        ObjectPoolHelper.registerObjectPool ( context, this.pool, DataSource.class );

        this.tracker = new ObjectPoolTracker<DataSource> ( context, DataSource.class );
        this.tracker.open ();

        this.factory = new FactoryImpl ( this.executor, context, this.tracker, this.pool );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A data source status summarizer" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, FactoryImpl.FACTORY_ID );
        this.factoryHandle = context.registerService ( ConfigurationFactory.class.getName (), this.factory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.factoryHandle.unregister ();
        this.factory.dispose ();
        this.factory = null;

        this.tracker.close ();
        this.tracker = null;

        this.pool.dispose ();
        this.pool = null;

        this.executor.shutdown ();
        this.executor = null;
    }

}
