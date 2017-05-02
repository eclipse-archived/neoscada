/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino.testing;

import java.net.InetSocketAddress;
import java.util.Map;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.protocol.arduino.ArduinoDevice;
import org.eclipse.scada.protocol.arduino.ArduinoDeviceListener;
import org.eclipse.scada.protocol.arduino.DeviceState;

public class Application implements IApplication
{

    private volatile boolean running = true;

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {

        final ArduinoDevice device = new ArduinoDevice ( new InetSocketAddress ( "172.20.11.105", 8888 ), new ArduinoDeviceListener () {

            @Override
            public void deviceConnected ( final Map<Integer, Object>[] parameters )
            {
                System.out.println ( "Device connected" );
                for ( int i = 0; i < parameters.length; i++ )
                {
                    for ( final Map.Entry<Integer, Object> entry : parameters[i].entrySet () )
                    {
                        System.out.println ( String.format ( "%02d - %02d - %s", i, entry.getKey (), entry.getValue () ) );
                    }
                }
            }

            @Override
            public void deviceDisconnected ()
            {
                System.out.println ( "Device disconnected" );
            }

            @Override
            public void stateChange ( final DeviceState deviceState )
            {
                System.out.println ( "State change: " + deviceState );
            }

            @Override
            public void dataChange ( final Object[] data )
            {
                System.out.println ( "Data change" );
                for ( int i = 0; i < data.length; i++ )
                {
                    System.out.println ( String.format ( "  #%02d - %s", i, data[i] ) );
                }
            };
        }, true );

        device.start ();

        while ( this.running )
        {
            Thread.sleep ( 1000 );
        }

        return null;
    }

    @Override
    public void stop ()
    {
        this.running = false;
    }

}
