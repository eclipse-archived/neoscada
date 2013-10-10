/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ngp;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application to export a storage using the OpenSCADA NGP protocol
 * 
 * @author Jens Reimann
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
                ci = ConnectionInformation.fromURI ( "da:ngp://0.0.0.0:" + System.getProperty ( "openscada.da.ngp.server.port", "2101" ) );
            }

            // create exporter
            final Class<?> hiveClass = Class.forName ( args[0] );
            final Hive service = (Hive)hiveClass.newInstance ();
            final Exporter exporter = new Exporter ( service, ci );
            service.start ();
            exporter.start ();

            // run the lizzard
            logger.info ( "Running exporter (hive class: " + exporter.getServiceClass ().getCanonicalName () + ")..." );
        }
        catch ( final Throwable e )
        {
            // ops
            logger.error ( "Error in openSCADA HD[NGP] Server", e );
            System.exit ( 1 );
        }
    }
}
