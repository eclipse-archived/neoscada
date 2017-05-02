/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow shared socket connectors
 *******************************************************************************/
package org.eclipse.scada.da.client.ngp.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.core.client.DriverFactory;
import org.eclipse.scada.da.client.ngp.DriverFactoryImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

/**
 * An OSGi bundle activator which registers the DriverAdapter with OSGi
 * 
 * @author Jens Reimann
 */
public class Activator implements BundleActivator
{
    private static Activator instance;

    private org.eclipse.scada.core.client.DriverFactory factory;

    private ServiceRegistration<org.eclipse.scada.core.client.DriverFactory> handle;

    private IoProcessor<NioSession> processor;

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
        properties.put ( org.eclipse.scada.core.client.DriverFactory.INTERFACE_NAME, "da" );
        properties.put ( org.eclipse.scada.core.client.DriverFactory.DRIVER_NAME, "ngp" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "Eclipse SCADA DA NGP Adapter" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        this.handle = context.registerService ( org.eclipse.scada.core.client.DriverFactory.class, this.factory, properties );
    }

    public static DriverFactory getDriverFactory ()
    {
        return Activator.instance.factory;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.handle.unregister ();
        if ( this.processor != null )
        {
            this.processor.dispose ();
        }
        this.factory = null;
        Activator.instance = null;
    }

}
