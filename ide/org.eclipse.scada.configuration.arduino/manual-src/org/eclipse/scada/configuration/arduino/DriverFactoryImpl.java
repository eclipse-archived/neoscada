/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.arduino;

import java.util.Map;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DeviceTypeValidator;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.world.Endpoint;

public class DriverFactoryImpl extends AbstractEquinoxDriverFactory<ArduinoDriver>
{

    public DriverFactoryImpl ()
    {
        addValidator ( new DeviceTypeValidator<EquinoxDriver> ( ArduinoDevice.class ) );
    }

    @Override
    protected ArduinoDriver createDriver ()
    {
        return ArduinoFactory.eINSTANCE.createArduinoDriver ();
    }

    @Override
    protected void configureDriver ( final AbstractFactoryDriver driver, final ArduinoDriver result, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof ArduinoDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }
            createDevice ( result, (ArduinoDevice)device, nodes );
        }
    }

    protected void createDevice ( final ArduinoDriver driver, final ArduinoDevice device, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final ArduinoConnection con = ArduinoFactory.eINSTANCE.createArduinoConnection ();
        con.setName ( device.getName () );
        con.setShortDescription ( device.getShortDescription () );

        final Endpoint ep = Endpoints.registerEndpoint ( nodes.get ( device.getNode () ), device.getPort (), null, "Arduino Endpoint" );
        con.setEndpoint ( ep );

        driver.getArduinoConnections ().add ( con );
    }
}
