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
package org.eclipse.scada.hd.server.test;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.hd.server.common.HistoricalItem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ServiceRegistration<HistoricalItem> handle;

    private TestItemImpl service;

    private Test2ItemImpl service2;

    private ServiceRegistration<HistoricalItem> handle2;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( "itemId", "test1" );
        this.service = new TestItemImpl ();
        this.handle = context.registerService ( HistoricalItem.class, this.service, properties );

        properties = new Hashtable<String, Object> ();
        properties.put ( "itemId", "test2" );
        this.service2 = new Test2ItemImpl ();
        this.handle2 = context.registerService ( HistoricalItem.class, this.service2, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.service.dispose ();
        this.handle.unregister ();

        this.service2.dispose ();
        this.handle2.unregister ();
    }

}
