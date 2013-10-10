/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.net;

import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.core.ConnectionInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application to export a storage using the Eclipse SCADA NET protocol
 * @author Jens Reimann
 *
 */
public class Application
{

    private final static Logger logger = LoggerFactory.getLogger ( Application.class );

    public static void main ( final String[] args )
    {
        try
        {
            // check if we have a class name
            if ( args.length < 1 )
            {
                System.err.println ( "syntax: Application <hiveClassName>" );
                return;
            }
            ConnectionInformation ci = null;
            if ( args.length >= 2 )
            {
                ci = ConnectionInformation.fromURI ( args[1] );
            }
            if ( ci == null )
            {
                ci = ConnectionInformation.fromURI ( "ae:net://0.0.0.0:" + System.getProperty ( "org.eclipse.scada.ae.server.net.serverPort", "1302" ) );
            }

            // create exporter
            final Class<?> hiveClass = Class.forName ( args[0] );
            final Service service = (Service)hiveClass.newInstance ();
            final Exporter exporter = new Exporter ( service, ci );
            service.start ();
            exporter.start ();

            // run the lizzard
            logger.info ( "Running exporter (hive class: " + exporter.getServiceClass ().getCanonicalName () + ")..." );
        }
        catch ( final Throwable e )
        {
            // ops
            logger.error ( "Error in Eclipse SCADA AE[NET] Server", e );
            System.exit ( 1 );
        }
    }
}
