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

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.data.QueryState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryImpl implements Query
{
    private final static Logger logger = LoggerFactory.getLogger ( QueryImpl.class );

    private final long queryId;

    private QueryListener listener;

    private final ConnectionImpl connection;

    private final ExecutorService executor;

    public QueryImpl ( final ExecutorService executor, final ConnectionImpl connection, final long queryId, final QueryListener listener )
    {
        this.executor = executor;
        this.connection = connection;
        this.queryId = queryId;
        this.listener = listener;
    }

    @Override
    public void close ()
    {
        logger.debug ( "Requesting close: {}", this.queryId );
        this.connection.sendCloseQuery ( this.queryId );
    }

    @Override
    public void loadMore ( final int count )
    {
        logger.debug ( "Request to load more: {}", count );

        if ( count <= 0 )
        {
            throw new IllegalArgumentException ( "'count' must be greater than zero" );
        }

        this.connection.sendLoadMore ( this.queryId, count );
    }

    public void handleStateChange ( final QueryListener listener, final QueryState state, final Throwable error )
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                if ( listener != null )
                {
                    listener.queryStateChanged ( state, error );
                }
            }
        } );
    }

    public void dispose ()
    {
        logger.debug ( "Disposing query: {}", this.queryId );

        if ( this.listener != null )
        {
            handleStateChange ( this.listener, QueryState.DISCONNECTED, null );
            this.listener = null;
        }
    }

    public void handleData ( final QueryListener listener, final List<Event> data )
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                if ( listener != null )
                {
                    listener.queryData ( data );
                }
            };
        } );
    }

    public QueryListener getListener ()
    {
        return this.listener;
    }
}
