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
package org.eclipse.scada.da.server.osgi.testing;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    private DataItemTest1 service;

    private ScheduledThreadPoolExecutor executor;

    private ServiceRegistration<DataItem> handle;

    private TimeItemFactory factory1;

    private ServiceRegistration<?> factory1Handle;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = new ScheduledThreadPoolExecutor ( 1 );
        this.service = new DataItemTest1 ( "test", this.executor );

        {
            final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
            this.handle = context.registerService ( DataItem.class, this.service, properties );
        }

        {
            this.factory1 = new TimeItemFactory ( this.executor, context );
            final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
            properties.put ( ConfigurationAdministrator.FACTORY_ID, TimeItemFactory.class.getName () );
            this.factory1Handle = context.registerService ( ConfigurationFactory.class, this.factory1, properties );
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        logger.info ( "Stopping test server" );

        this.factory1Handle.unregister ();
        this.factory1Handle = null;

        this.factory1.dispose ();
        this.factory1 = null;

        this.handle.unregister ();
        this.handle = null;

        this.service.dispose ();
        this.service = null;

        this.executor.shutdown ();
        this.executor = null;
    }

}
