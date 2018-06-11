/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.configuration.iec62541.lib;

import java.util.Map;

import org.eclipse.neoscada.configuration.iec62541.DriverApplication;
import org.eclipse.neoscada.configuration.iec62541.HiveDevice;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Device;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Driver;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Factory;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverHandler;
import org.eclipse.scada.configuration.lib.Nodes;

public class DriverHandlerImpl extends AbstractEquinoxDriverHandler<IEC62541Driver, DriverApplication>
{
    @Override
    protected DriverApplication createDriver ( final IEC62541Driver driver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final DriverApplication result = IEC62541Factory.eINSTANCE.createDriverApplication ();

        for ( final IEC62541Device device : driver.getDevices () )
        {
            final HiveDevice hiveDevice = IEC62541Factory.eINSTANCE.createHiveDevice ();

            hiveDevice.setId ( device.getName () );

            final String host = Nodes.makeHostname ( result, nodes.get ( device.getNode () ) );

            hiveDevice.setServerUrl ( device.getServerUrl () );

            result.getDevices ().add ( hiveDevice );
        }

        return result;
    }
}
