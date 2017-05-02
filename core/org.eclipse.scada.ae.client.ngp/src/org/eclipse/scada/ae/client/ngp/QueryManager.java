/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.client.ngp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.data.EventInformation;
import org.eclipse.scada.ae.data.QueryState;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.data.ErrorInformation;

public class QueryManager
{

    private final ExecutorService executor;

    private final ConnectionImpl connection;

    private final Map<Long, QueryImpl> queries = new HashMap<Long, QueryImpl> ();

    private final Random r = new Random ();

    public QueryManager ( final ExecutorService executor, final ConnectionImpl connection )
    {
        this.executor = executor;
        this.connection = connection;
    }

    public void dispose ()
    {
        onClosed ();
    }

    public void onClosed ()
    {
        for ( final QueryImpl query : this.queries.values () )
        {
            query.dispose ();
        }
        this.queries.clear ();
    }

    public void onBound ()
    {
    }

    public Query createQuery ( final String queryType, final String queryData, final QueryListener listener )
    {
        final long queryId = nextId ();
        final QueryImpl query = new QueryImpl ( this.executor, this.connection, queryId, listener );
        this.queries.put ( queryId, query );

        this.connection.sendCreateQuery ( queryId, queryType, queryData );

        return query;
    }

    private long nextId ()
    {
        long id;
        do
        {
            id = this.r.nextLong ();
        } while ( this.queries.containsKey ( id ) );
        return id;
    }

    public void updateQueryState ( final long queryId, final QueryState state, final ErrorInformation error )
    {
        final QueryImpl query = this.queries.get ( queryId );
        if ( query == null )
        {
            return;
        }

        if ( state == QueryState.DISCONNECTED )
        {
            query.dispose ();
            this.queries.remove ( queryId );
        }
        else
        {
            query.handleStateChange ( query.getListener (), state, error == null ? null : new OperationException ( error.getMessage () ).fillInStackTrace () );
        }
    }

    public void updateQueryData ( final long queryId, final List<EventInformation> events )
    {
        final QueryImpl query = this.queries.get ( queryId );
        if ( query == null )
        {
            return;
        }

        query.handleData ( query.getListener (), Events.convertToEvent ( events ) );
    }

}
