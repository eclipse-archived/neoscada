/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.client.ngp.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.ae.client.ngp.DriverFactoryImpl;
import org.eclipse.scada.core.client.DriverFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
    private static Activator instance;

    private org.eclipse.scada.ae.client.ngp.DriverFactoryImpl factory;

    private ServiceRegistration<DriverFactory> handle;

    private IoProcessor<NioSession> processor;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Activator.instance = this;

        if ( !Boolean.getBoolean ( "org.eclipse.scada.core.client.ngp.disableSharedProcessor" ) )
        {
            this.processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
        }
        this.factory = new DriverFactoryImpl ( this.processor );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( org.eclipse.scada.core.client.DriverFactory.INTERFACE_NAME, "ae" );
        properties.put ( org.eclipse.scada.core.client.DriverFactory.DRIVER_NAME, "ngp" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA AE NGP Adapter" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = context.registerService ( org.eclipse.scada.core.client.DriverFactory.class, this.factory, properties );
    }

    public static DriverFactory getDriverFactory ()
    {
        return Activator.instance.factory;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.handle.unregister ();
        if ( this.processor != null )
        {
            this.processor.dispose ();
        }
        Activator.instance = null;
    }

}
