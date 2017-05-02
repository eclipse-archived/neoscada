/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.perf.test;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.hd.data.QueryParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionRunner implements Runnable
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionRunner.class );

    private ConnectionRequestTracker tracker;

    private final String info;

    private final String itemId;

    public ConnectionRunner ( final String info, final String itemId )
    {
        this.info = info;
        this.itemId = itemId;
    }

    @Override
    public void run ()
    {
        try
        {
            Tracker.marker ( "CONN_INIT" );
            performRun ();
        }
        catch ( final Throwable e )
        {
            logger.debug ( "Failed", e );
            Tracker.marker ( "CONN_ERR" );
        }
        finally
        {
            Tracker.marker ( "CONN_FINALLY" );
        }
    }

    public void performRun () throws InterruptedException, ExecutionException
    {
        Tracker.marker ( "CONN_START" );

        final ConnectionInformation ci = ConnectionInformation.fromURI ( this.info );
        this.tracker = new ConnectionRequestTracker ( Activator.getDefault ().getBundle ().getBundleContext (), new ConnectionRequest ( UUID.randomUUID ().toString (), ci, null, true ), null );
        this.tracker.open ();

        Tracker.marker ( "CONN_TRACKER" );

        if ( this.tracker.waitForService ( 5 * 1000 ) == null )
        {
            Tracker.marker ( "CONN_NO_SERVICE" );
            return;
        }

        Tracker.marker ( "CONN_SERVICE" );

        final ConnectionService connection = (ConnectionService)this.tracker.getService ();
        Tracker.marker ( "CONN_GET_SERVICE" );

        Tracker.marker ( "CONN_WAIT_BOUND" );
        if ( !waitForBound ( connection, 5 * 1000 ) )
        {
            Tracker.marker ( "CONN_NO_BOUND" );
            return;
        }
        Tracker.marker ( "CONN_BOUND" );

        logger.debug ( "Got connection" );

        // perform query stuff
        doQuery ( connection );

        this.tracker.close ();

        this.tracker = null;

        Tracker.marker ( "CONN_DONE" );
    }

    private void doQuery ( final ConnectionService connection ) throws InterruptedException, ExecutionException
    {
        final ExecutorService executor = Executors.newFixedThreadPool ( Runtime.getRuntime ().availableProcessors () );

        final Collection<Future<?>> tasks = new LinkedList<Future<?>> ();

        for ( int i = 0; i < 10; i++ )
        {
            final Calendar start = new GregorianCalendar ( 2005, 1, 1 );
            final Calendar end = (Calendar)start.clone ();
            end.add ( Calendar.YEAR, 4 );
            final QueryParameters params = new QueryParameters ( start.getTimeInMillis (), end.getTimeInMillis (), 1000 );
            tasks.add ( executor.submit ( new QueryRunner ( connection, this.itemId, params ) ) );
        }

        for ( final Future<?> task : tasks )
        {
            task.get ();
        }

        executor.shutdown ();
    }

    private boolean waitForBound ( final ConnectionService connection, final long timeout )
    {
        final long start = System.currentTimeMillis ();

        ConnectionState state;
        do
        {
            if ( System.currentTimeMillis () - start > timeout )
            {
                return false;
            }
            state = connection.getConnection ().getState ();
            try
            {
                Thread.sleep ( 100 );
            }
            catch ( final InterruptedException e )
            {
                return false;
            }
            if ( Thread.interrupted () )
            {
                return false;
            }
        } while ( state != ConnectionState.BOUND );
        return true;
    }

    public void stop ()
    {

    }
}
