/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.configuration.iec60870.lib.hive;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Driver;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverHandler;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.world.Endpoint;

public class DriverHandlerImpl extends AbstractEquinoxDriverHandler<IEC60870Driver, DriverApplication>
{
    @Override
    protected DriverApplication createDriver ( final IEC60870Driver driver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final DriverApplication result = IEC60870Factory.eINSTANCE.createDriverApplication ();

        for ( final IEC60870Device device : driver.getDevices () )
        {
            final ClientDevice clientDevice = IEC60870Factory.eINSTANCE.createClientDevice ();

            clientDevice.setDataModuleOptions ( EcoreUtil.copy ( device.getDataModuleOptions () ) );
            clientDevice.setProtocolOptions ( EcoreUtil.copy ( device.getProtocolOptions () ) );
            clientDevice.setId ( device.getName () );
            clientDevice.getItemTypes ().addAll ( EcoreUtil.copyAll ( device.getItemTypes () ) );

            final Endpoint ep = Endpoints.registerEndpoint ( nodes.get ( device.getNode () ), device.getPort (), null, "IEC 60870-5-104 Device Endpoint" );
            clientDevice.setEndpoint ( ep );

            result.getDevices ().add ( clientDevice );
        }

        return result;
    }
}
