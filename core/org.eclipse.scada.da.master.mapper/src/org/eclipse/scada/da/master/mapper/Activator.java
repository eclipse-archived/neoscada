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
package org.eclipse.scada.da.master.mapper;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator
{

    private ObjectPoolTracker<MasterItem> poolTracker;

    private MapperHandlerFactoryImpl factory;

    private ObjectPoolTracker<ValueMapper> mapperPoolTracker;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.poolTracker = new ObjectPoolTracker<MasterItem> ( context, MasterItem.class );
        this.poolTracker.open ();

        this.mapperPoolTracker = new ObjectPoolTracker<ValueMapper> ( context, ValueMapper.class );
        this.mapperPoolTracker.open ();

        this.factory = new MapperHandlerFactoryImpl ( context, this.poolTracker, this.mapperPoolTracker, 1001 /* after manual */);
        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A value mapper master handler" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, MapperHandlerFactoryImpl.FACTORY_ID );
        context.registerService ( ConfigurationFactory.class.getName (), this.factory, properties );

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {

        this.factory.dispose ();
        this.factory = null;

        this.poolTracker.close ();
        this.poolTracker = null;
    }
}
