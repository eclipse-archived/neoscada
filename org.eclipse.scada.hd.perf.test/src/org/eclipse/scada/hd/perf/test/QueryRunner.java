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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.client.Connection;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.utils.concurrent.AbstractFuture;

public class QueryRunner implements Runnable
{

    private final ConnectionService connection;

    private final String itemId;

    private final QueryParameters parameters;

    protected static class QueryTask extends AbstractFuture<QueryState> implements QueryListener
    {

        private boolean running = true;

        public List<Object> events = new LinkedList<Object> ();

        @Override
        public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
        {
            Tracker.marker ( "QR_DATA" );
            Tracker.marker ( Application.QUERY, this, "QR_DATA" );
        }

        @Override
        public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
        {
            Tracker.marker ( "QR_PARA" );
            Tracker.marker ( Application.QUERY, this, "QR_PARA" );
        }

        @Override
        public void updateState ( final QueryState state )
        {
            System.out.println ( "State: " + state );

            Tracker.marker ( "QR_STATE" );
            Tracker.marker ( Application.QUERY, this, "QR_STATE#" + state );

            this.events.add ( state );
            if ( this.running )
            {
                if ( state == QueryState.DISCONNECTED || state == QueryState.COMPLETE )
                {
                    this.running = false;
                    Tracker.marker ( "QR_STATE_DONE" );
                    Tracker.marker ( Application.QUERY, this, "QR_STATE_DONE" );
                    setResult ( state );
                }
            }
        }

    }

    public QueryRunner ( final ConnectionService connection, final String itemId, final QueryParameters parameters )
    {
        this.connection = connection;
        this.itemId = itemId;
        this.parameters = parameters;
    }

    @Override
    public void run ()
    {
        Tracker.marker ( "QUERY_START" );

        final QueryTask task = new QueryTask ();

        Tracker.marker ( "QUERY_NEW" );
        Tracker.marker ( Application.QUERY, task, "QUERY_GET_CON" );

        final Connection connection = this.connection.getConnection ();

        if ( connection == null )
        {
            Tracker.marker ( Application.QUERY, task, "QUERY_NO_CON" );
            return;
        }

        Tracker.marker ( Application.QUERY, task, "QUERY_NEW" );

        final Query query = connection.createQuery ( this.itemId, this.parameters, task, false );

        Tracker.marker ( "QUERY_NEW_DONE" );

        try
        {
            final QueryState state = task.get ();
            Tracker.marker ( Application.QUERY, task, "QUERY_COMPLETE" );

            System.out.println ( "Complete: " + state );

            Tracker.marker ( "QUERY_CLOSE" );
            Tracker.marker ( Application.QUERY, task, "QUERY_CLOSE" );
            query.close ();
            Tracker.marker ( "QUERY_CLOSE_DONE" );
            Tracker.marker ( Application.QUERY, task, "QUERY_CLOSE_DONE" );
        }
        catch ( final InterruptedException e )
        {
            Tracker.marker ( "QUERY_INT" );
        }
        catch ( final ExecutionException e )
        {
            Tracker.marker ( "QUERY_EX" );
        }
        finally
        {
            Tracker.marker ( "QUERY_FIN" );
        }
    }

}
