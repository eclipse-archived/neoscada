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
package org.eclipse.scada.ae.client.net;

import java.util.List;

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

    public QueryImpl ( final ConnectionImpl connection, final long queryId, final QueryListener listener )
    {
        this.connection = connection;
        this.queryId = queryId;
        this.listener = listener;
    }

    @Override
    public void close ()
    {
        this.connection.closeQuery ( this.queryId );
    }

    @Override
    public void loadMore ( final int count )
    {
        if ( count <= 0 )
        {
            throw new IllegalArgumentException ( "'count' must be greater than zero" );
        }

        this.connection.loadMore ( this.queryId, count );
    }

    public void handleStateChange ( final QueryState state, final Throwable error )
    {
        try
        {
            this.listener.queryStateChanged ( state, error );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to handle state change", e );
        }
    }

    public synchronized void dispose ()
    {
        if ( this.listener != null )
        {
            handleStateChange ( QueryState.DISCONNECTED, null );
            this.listener = null;
        }
    }

    public void handleData ( final List<Event> data )
    {
        try
        {
            this.listener.queryData ( data );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to handle data change", e );
        }
    }
}
