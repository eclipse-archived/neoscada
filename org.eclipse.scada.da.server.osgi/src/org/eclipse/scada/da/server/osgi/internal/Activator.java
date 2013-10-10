/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.internal;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.osgi.pool.AllObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private HiveImpl service;

    private ServiceRegistration<Hive> handle;

    private ServiceListener listener;

    private ObjectPoolTracker<DataItem> poolTracker;

    private AllObjectPoolServiceTracker<DataItem> itemTracker;

    private ExportedExecutorService executor;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = new ExportedExecutorService ( "org.openscada.da.server.osgi", 1, 1, 1, TimeUnit.MINUTES );

        this.service = new HiveImpl ( context, this.executor );
        this.service.start ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();

        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A common generic OSGi DA Hive" );

        this.handle = context.registerService ( Hive.class, this.service, properties );

        context.addServiceListener ( this.listener = new ServiceListener () {

            @Override
            public void serviceChanged ( final ServiceEvent event )
            {
                switch ( event.getType () )
                {
                    case ServiceEvent.REGISTERED:
                        Activator.this.addItem ( event.getServiceReference () );
                        break;
                    case ServiceEvent.UNREGISTERING:
                        Activator.this.removeItem ( event.getServiceReference () );
                        break;
                }
            }
        }, "(" + Constants.OBJECTCLASS + "=" + DataItem.class.getName () + ")" );

        final Collection<ServiceReference<DataItem>> refs = context.getServiceReferences ( DataItem.class, null );
        if ( refs != null )
        {
            for ( final ServiceReference<DataItem> ref : refs )
            {
                addItem ( ref );
            }
        }

        this.poolTracker = new ObjectPoolTracker<DataItem> ( context, DataItem.class );
        this.poolTracker.open ();

        this.itemTracker = new AllObjectPoolServiceTracker<DataItem> ( this.poolTracker, new ObjectPoolListener<DataItem> () {

            @Override
            public void serviceRemoved ( final DataItem service, final Dictionary<?, ?> properties )
            {
                Activator.this.service.removeItem ( service );
            }

            @Override
            public void serviceModified ( final DataItem service, final Dictionary<?, ?> properties )
            {
            }

            @Override
            public void serviceAdded ( final DataItem service, final Dictionary<?, ?> properties )
            {
                Activator.this.service.addItem ( service, properties );
            }
        } );
        this.itemTracker.open ();
    }

    protected void removeItem ( final ServiceReference<?> serviceReference )
    {
        this.service.removeItem ( serviceReference );
    }

    protected void addItem ( final ServiceReference<?> serviceReference )
    {
        this.service.addItem ( serviceReference );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        context.removeServiceListener ( this.listener );

        this.itemTracker.close ();
        this.poolTracker.close ();

        this.handle.unregister ();
        this.handle = null;

        this.service.stop ();
        this.service = null;

        this.executor.shutdown ();
    }

}
