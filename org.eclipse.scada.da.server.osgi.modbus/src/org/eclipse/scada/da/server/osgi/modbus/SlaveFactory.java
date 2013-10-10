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

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;

public class SlaveFactory extends AbstractServiceConfigurationFactory<ModbusSlave>
{
    private final MasterFactory masterFactory;

    private final Executor executor;

    public SlaveFactory ( final BundleContext context, final MasterFactory masterFactory, final Executor executor )
    {
        super ( context, true );
        this.masterFactory = masterFactory;
        this.executor = executor;
    }

    @Override
    protected Entry<ModbusSlave> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        return new Entry<ModbusSlave> ( configurationId, ModbusSlave.create ( context, this.executor, configurationId, parameters, this.masterFactory ) );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ModbusSlave service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ModbusSlave> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ModbusSlave> entry, final Map<String, String> parameters ) throws Exception
    {
        // will never get called since we are "createOnly"
        return null;
    }

}
