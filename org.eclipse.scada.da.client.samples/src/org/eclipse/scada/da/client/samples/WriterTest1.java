/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.samples;

import java.util.Calendar;
import java.util.Random;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.ConnectionFactory;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.WriteOperationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriterTest1
{
    private final static Logger logger = LoggerFactory.getLogger ( WriterTest1.class );

    public static void main ( final String[] args ) throws ClassNotFoundException
    {
        final String className = "org.eclipse.scada.da.client.net.Connection";
        final String uri = "da:net://127.0.0.1:1202";
        final String itemName = "172.16.148.128:F8582CF2-88FB-11D0-B850-00C0F0104305.Bucket Brigade.Int4";
        // final String itemName = "memory";

        if ( className != null )
        {
            Class.forName ( className );
        }

        final ConnectionInformation ci = ConnectionInformation.fromURI ( uri );

        final Connection connection = (Connection)ConnectionFactory.create ( ci );
        if ( connection == null )
        {
            throw new RuntimeException ( "Unable to find a connection driver for specified URI" );
        }

        connection.connect ();

        new Thread ( new Runnable () {

            @Override
            public void run ()
            {
                while ( true )
                {
                    try
                    {
                        Thread.sleep ( 1000 );
                    }
                    catch ( final InterruptedException e )
                    {
                        return;
                    }
                    doWrite ( connection, itemName );
                }
            }
        } ).start ();
    }

    private static Random random = new Random ();

    public static void doWrite ( final Connection connection, final String itemName )
    {
        final Variant value = Variant.valueOf ( random.nextInt () );
        logger.info ( "Start write: " + value );
        final Calendar c = Calendar.getInstance ();
        final Object lock = new Object ();
        synchronized ( lock )
        {
            connection.write ( itemName, value, null, new WriteOperationCallback () {

                @Override
                public void complete ()
                {
                    logger.info ( String.format ( "Wrote: %s, Started: %tc", value, c ) );
                    synchronized ( lock )
                    {
                        lock.notify ();
                    }
                }

                @Override
                public void error ( final Throwable e )
                {
                    logger.info ( "Error", e );
                    synchronized ( lock )
                    {
                        lock.notify ();
                    }
                }

                @Override
                public void failed ( final String error )
                {
                    logger.info ( "Failed: " + error );
                    // async call since it might called inline
                    new Thread ( new Runnable () {

                        @Override
                        public void run ()
                        {
                            synchronized ( lock )
                            {
                                lock.notify ();
                            }
                        }
                    } ).start ();

                }
            } );

            /*
            try
            {
                lock.wait ();
            }
            catch ( InterruptedException e1 )
            {
            }
            */
        }
    }
}
