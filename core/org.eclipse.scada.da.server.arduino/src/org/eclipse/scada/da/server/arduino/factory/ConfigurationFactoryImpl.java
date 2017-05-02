/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.arduino.factory;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.server.arduino.ArduinoDevice;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleContext;

public class ConfigurationFactoryImpl extends AbstractServiceConfigurationFactory<ArduinoDevice>
{
    private final BundleContext context;

    private final ObjectPoolImpl<DataItem> itemPool;

    private final Executor executor;

    public ConfigurationFactoryImpl ( final BundleContext context, final ObjectPoolImpl<DataItem> itemPool, final Executor executor )
    {
        super ( context );
        this.context = context;
        this.itemPool = itemPool;
        this.executor = executor;
    }

    @Override
    protected Entry<ArduinoDevice> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ArduinoDevice device = new ArduinoDevice ( this.context, configurationId, parameters, this.itemPool, this.executor );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( "adrduinoDevice", configurationId );
        return new Entry<ArduinoDevice> ( configurationId, device, context.registerService ( ArduinoDevice.class, device, properties ) );
    }

    @Override
    protected Entry<ArduinoDevice> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ArduinoDevice> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().dispose ();
        entry.getHandle ().unregister ();

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( "adrduinoDevice", configurationId );
        final ArduinoDevice device = new ArduinoDevice ( this.context, configurationId, parameters, this.itemPool, this.executor );

        return new Entry<ArduinoDevice> ( configurationId, device, this.context.registerService ( ArduinoDevice.class, device, properties ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final ArduinoDevice service )
    {
        service.dispose ();
    }
}
