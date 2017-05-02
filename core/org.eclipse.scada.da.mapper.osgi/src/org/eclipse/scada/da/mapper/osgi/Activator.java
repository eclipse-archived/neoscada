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
package org.eclipse.scada.da.mapper.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.da.mapper.osgi.ca.ConfiguredValueMapperFactory;
import org.eclipse.scada.da.mapper.osgi.jdbc.JdbcValueMapperFactory;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ObjectPoolImpl<ValueMapper> mapperPool;

    private ServiceRegistration<?> mapperPoolRegistration;

    private ConfiguredValueMapperFactory factory1;

    private ObjectPoolImpl<DataItem> itemPool;

    private ServiceRegistration<?> itemPoolRegistration;

    private JdbcValueMapperFactory factory2;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.mapperPool = new ObjectPoolImpl<ValueMapper> ();
        this.mapperPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.mapperPool, ValueMapper.class );

        this.itemPool = new ObjectPoolImpl<DataItem> ();
        this.itemPoolRegistration = ObjectPoolHelper.registerObjectPool ( context, this.itemPool, DataItem.class );

        this.factory1 = new ConfiguredValueMapperFactory ( context, this.mapperPool );
        {
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A value mapper based on its configuration" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, ConfiguredValueMapperFactory.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class.getName (), this.factory1, properties );
        }

        this.factory2 = new JdbcValueMapperFactory ( context, this.mapperPool, this.itemPool );
        {
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A value mapper based on a jdbc sql query" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, JdbcValueMapperFactory.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class.getName (), this.factory2, properties );
        }
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.factory1.dispose ();
        this.factory2.dispose ();

        this.mapperPoolRegistration.unregister ();
        this.mapperPool.dispose ();

        this.itemPoolRegistration.unregister ();
        this.itemPool.dispose ();
    }

}
