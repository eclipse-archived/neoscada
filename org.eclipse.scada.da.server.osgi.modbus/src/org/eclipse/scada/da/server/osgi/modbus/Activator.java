/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.modbus;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.Executors;

import org.apache.mina.transport.socket.nio.NioProcessor;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private MasterFactory masterFactory;

    private SlaveFactory slaveFactory;

    private ServiceRegistration<ConfigurationFactory> masterFactoryHandle;

    private ServiceRegistration<ConfigurationFactory> slaveFactoryHandle;

    private ScheduledExportedExecutorService executor;

    private NioProcessor processor;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = new ScheduledExportedExecutorService ( "org.eclipse.scada.da.server.osgi.modbus", 1 );

        this.processor = new NioProcessor ( Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "org.eclipse.scada.da.server.osgi.modbus.NioProcessor" ) ) );

        this.masterFactory = new MasterFactory ( context, this.executor, this.processor );
        this.slaveFactory = new SlaveFactory ( context, this.masterFactory, this.executor );

        {
            final Dictionary<String, Object> properties = new Hashtable<> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "Modbus master device factory" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.scada.da.server.osgi.modbus.masterDevice" );
            this.masterFactoryHandle = context.registerService ( ConfigurationFactory.class, this.masterFactory, properties );
        }

        {
            final Dictionary<String, Object> properties = new Hashtable<> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "Modbus slave device factory" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.scada.da.server.osgi.modbus.slaveDevice" );
            this.slaveFactoryHandle = context.registerService ( ConfigurationFactory.class, this.slaveFactory, properties );
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.masterFactoryHandle.unregister ();
        this.masterFactory.dispose ();

        this.slaveFactoryHandle.unregister ();
        this.slaveFactory.dispose ();

        this.processor.dispose ();

        this.executor.shutdown ();

    }

}
