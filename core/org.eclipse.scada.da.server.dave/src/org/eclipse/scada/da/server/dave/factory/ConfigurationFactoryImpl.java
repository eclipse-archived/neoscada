/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.dave.factory;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.server.dave.DaveDevice;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;

public class ConfigurationFactoryImpl extends AbstractServiceConfigurationFactory<DaveDevice>
{
    private final BundleContext context;

    public ConfigurationFactoryImpl ( final BundleContext context )
    {
        super ( context, true );
        this.context = context;
    }

    @Override
    protected Entry<DaveDevice> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final DaveDevice device = new DaveDevice ( this.context, configurationId, parameters );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( "daveDevice", configurationId );
        return new Entry<DaveDevice> ( configurationId, device, context.registerService ( DaveDevice.class, device, properties ) );
    }

    @Override
    protected Entry<DaveDevice> updateService ( final UserInformation userInformation, final String configurationId, final Entry<DaveDevice> entry, final Map<String, String> parameters ) throws Exception
    {
        // we never get called since are ware createOnly
        return null;
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final DaveDevice service )
    {
        service.dispose ();
    }
}
