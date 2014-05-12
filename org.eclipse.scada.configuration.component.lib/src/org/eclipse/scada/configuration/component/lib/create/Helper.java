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
package org.eclipse.scada.configuration.component.lib.create;

import java.util.Collection;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.utils.str.StringHelper;

public final class Helper
{
    private Helper ()
    {
    }

    public static void setSourceConnectionFromEndpoints ( final SourceItem item, final MasterServer master, final Collection<Endpoint> endpoints )
    {
        final Connection connection = Locator.findConnection ( master, endpoints );
        if ( connection == null )
        {
            final String nodeName = Nodes.makeName ( Nodes.fromApp ( master ) );

            throw new IllegalStateException ( String.format ( "Master %s on node %s does not have a connection to endpoints %s", master.getName (), nodeName, StringHelper.join ( endpoints, ", " ) ) );
        }

        if ( ! ( connection instanceof DataAccessConnection ) )
        {
            throw new IllegalStateException ( String.format ( "Connection is of type %s but must be of type %s (Endpoints: %s)", connection.getClass ().getName (), DataAccessConnection.class.getName (), StringHelper.join ( endpoints, ", " ) ) );
        }

        item.setConnection ( (DataAccessConnection)connection );
    }

    public static AbstractFactoryDriver findDriverForDevice ( final org.eclipse.scada.configuration.infrastructure.MasterServer master, final Device device )
    {
        for ( final Driver driver : master.getDriver () )
        {
            if ( ! ( driver instanceof AbstractFactoryDriver ) )
            {
                continue;
            }
            if ( ( (AbstractFactoryDriver)driver ).getDevices ().contains ( device ) )
            {
                return (AbstractFactoryDriver)driver;
            }
        }
        return null;
    }

}
