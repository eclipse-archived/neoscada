/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.connector;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;

/**
 * This helper class aids in finding and creating a new connection or driver adapter 
 * @author Jens Reimann
 *
 */
public class ConnectorHelper
{

    public static final String ELE_DRIVER_ADAPTER = "driverAdapter";
	public static final String EXTP_CONNECTOR = "org.eclipse.scada.da.client.connector";

	public static DriverAdapter findDriverAdapter ( final ConnectionInformation connectionInformation )
    {
        final DriverAdapterInformation dai = findDriverAdapterInformation ( connectionInformation );
        if ( dai == null )
        {
            return null;
        }
        return dai.createDriverAdapter ();
    }

    public static DriverAdapterInformation findDriverAdapterInformation ( final ConnectionInformation connectionInformation )
    {
        final IConfigurationElement[] elements = Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CONNECTOR );

        for ( final IConfigurationElement element : elements )
        {
            final String name = element.getName ();
            if ( !ELE_DRIVER_ADAPTER.equals ( name ) )
            {
                continue;
            }
            final String interfaceString = element.getAttribute ( "interface" );
            final String typeString = element.getAttribute ( "type" );

            if ( connectionInformation.getInterface ().equals ( interfaceString ) )
            {
                if ( connectionInformation.getDriver ().equals ( typeString ) )
                {
                    return new DriverAdapterInformation ( element );
                }
            }

        }
        return null;
    }

    public static Connection createConnection ( final ConnectionInformation connectionInformation )
    {
        final DriverAdapter adapter = findDriverAdapter ( connectionInformation );
        if ( adapter == null )
        {
            return null;
        }
        return adapter.createConnection ( connectionInformation );
    }
}
