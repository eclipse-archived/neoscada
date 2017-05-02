/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.core.ConnectionInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionFactory.class );

    protected static List<DriverFactory> registeredDrivers = new LinkedList<DriverFactory> ();

    public static void registerDriverFactory ( final DriverFactory driverFactory )
    {
        synchronized ( registeredDrivers )
        {
            registeredDrivers.add ( driverFactory );
        }
    }

    public static DriverInformation findDriver ( final ConnectionInformation connectionInformation )
    {
        if ( !connectionInformation.isValid () )
        {
            throw new IllegalArgumentException ( "Connection information is not valid" );
        }

        synchronized ( registeredDrivers )
        {
            for ( final DriverFactory factory : registeredDrivers )
            {
                final DriverInformation di = factory.getDriverInformation ( connectionInformation );
                if ( di != null )
                {
                    return di;
                }
            }
        }

        return null;
    }

    /**
     * Find a driver and create a new connection
     * @param connectionInformation The connection information
     * @return The new connection or <code>null</code> if no driver can be found 
     */
    public static Connection create ( final ConnectionInformation connectionInformation )
    {
        final DriverInformation di = findDriver ( connectionInformation );

        if ( di == null )
        {
            return null;
        }

        return di.create ( connectionInformation );
    }

    /**
     * Find a driver and create a new connection
     * @param className the connection class name to pre-load
     * @param connectionInformation The connection information
     * @return The new connection or <code>null</code> if no driver can be found 
     * @throws ClassNotFoundException the provided connection class cannot be found
     */
    public static Connection create ( final String className, final ConnectionInformation connectionInformation ) throws ClassNotFoundException
    {
        if ( className != null )
        {
            logger.info ( "Pre-loading connection class: " + className );
            Class.forName ( className, true, Thread.currentThread ().getContextClassLoader () );
        }

        final DriverInformation di = findDriver ( connectionInformation );

        if ( di == null )
        {
            logger.info ( "Driver not found: " + connectionInformation.getDriver () );
            return null;
        }

        return di.create ( connectionInformation );
    }
}
