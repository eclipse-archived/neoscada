/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.testing;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.datasource.testing.test1.QualityDataSourceFactory;
import org.eclipse.scada.da.datasource.testing.test1.RandomLongDataSourceFactory;
import org.eclipse.scada.da.datasource.testing.test1.SawtoothDataSourceFactory;
import org.eclipse.scada.da.datasource.testing.test1.SineDataSourceFactory;
import org.eclipse.scada.da.datasource.testing.test1.ToggleDataSourceFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator
{

    private final class ThreadFactoryImplementation implements ThreadFactory
    {
        private final String baseName;

        private final AtomicLong counter = new AtomicLong ();

        public ThreadFactoryImplementation ( final String baseName )
        {
            this.baseName = baseName;
        }

        public Thread newThread ( final Runnable r )
        {
            final Thread t = new Thread ( r );
            t.setName ( String.format ( "%s/%s", this.baseName, this.counter.incrementAndGet () ) );
            return t;
        }
    }

    private ScheduledExecutorService executor;

    private SineDataSourceFactory factory1;

    private ToggleDataSourceFactory factory2;

    private SawtoothDataSourceFactory factory3;

    private RandomLongDataSourceFactory factory4;

    private QualityDataSourceFactory factory5;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ( new ThreadFactoryImplementation ( Activator.class.getName () ) );

        Dictionary<String, String> properties;

        // register sine factory
        this.factory1 = new SineDataSourceFactory ( context, this.executor );
        properties = new Hashtable<String, String> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "datasource.test.sine" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory - Sine" );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory1, properties );

        // register toggle factory
        this.factory2 = new ToggleDataSourceFactory ( context, this.executor );
        properties = new Hashtable<String, String> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "datasource.test.toggle" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory - Toggle" );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory2, properties );

        // register sawtooth factory
        this.factory3 = new SawtoothDataSourceFactory ( context, this.executor );
        properties = new Hashtable<String, String> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "datasource.test.sawtooth" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory - Sawtooth" );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory3, properties );

        // register random long factory
        this.factory4 = new RandomLongDataSourceFactory ( context, this.executor );
        properties = new Hashtable<String, String> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "datasource.test.randomlong" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory - Random Long" );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory4, properties );

        // register quality factory
        this.factory5 = new QualityDataSourceFactory ( context, this.executor );
        properties = new Hashtable<String, String> ();
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "datasource.test.quality" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Testing Factory - Quality" );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory5, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop ( final BundleContext context ) throws Exception
    {
        this.factory1.dispose ();
        this.factory2.dispose ();
        this.factory3.dispose ();
        this.factory4.dispose ();
        this.factory5.dispose ();
        this.executor.shutdown ();
    }

}
