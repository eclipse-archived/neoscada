/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.samples;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.ConnectWaitController;
import org.eclipse.scada.core.client.ConnectionFactory;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.da.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleBase
{

    private final static Logger logger = LoggerFactory.getLogger ( SampleBase.class );

    protected String uri;

    protected Connection connection;

    public SampleBase ( final String uri, final String className ) throws Exception
    {
        super ();

        this.uri = uri;

        // If we got a class name load it
        if ( className != null )
        {
            Class.forName ( className );
        }

        if ( this.uri == null )
        {
            this.uri = "da:net://localhost:1202";
        }

        final ConnectionInformation ci = ConnectionInformation.fromURI ( this.uri );

        this.connection = (Connection)ConnectionFactory.create ( ci );
        if ( this.connection == null )
        {
            throw new Exception ( "Unable to find a connection driver for specified URI" );
        }

        this.connection.addConnectionStateListener ( new ConnectionStateListener () {

            @Override
            public void stateChange ( final org.eclipse.scada.core.client.Connection connection, final ConnectionState state, final Throwable error )
            {
                logger.info ( "Connection state changed: " + state, error );
            }
        } );

    }

    public void connect () throws Exception
    {
        // trigger the connection
        try
        {
            // wait until the connection is established. If it already is the call
            // will return immediately.
            // If the connect attempt fails an exception is thrown.
            new ConnectWaitController ( this.connection ).connect ();
        }
        catch ( final Throwable e )
        {
            // we were unlucky
            throw new Exception ( "Unable to create connection", e );
        }
    }

    public void dispose ()
    {
        this.connection.dispose ();
        this.connection = null;
        System.gc ();
    }

    public static void sleep ( final long millis )
    {
        try
        {
            Thread.sleep ( millis );
        }
        catch ( final Throwable e )
        {
            e.printStackTrace ();
        }
    }

}