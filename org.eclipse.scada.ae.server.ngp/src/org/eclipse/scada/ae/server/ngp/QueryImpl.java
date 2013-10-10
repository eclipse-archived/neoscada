/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.ngp;

import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.data.QueryState;

public class QueryImpl implements Query, QueryListener
{

    private Query query;

    private final ServerConnectionImpl server;

    private final long queryId;

    public QueryImpl ( final long queryId, final ServerConnectionImpl serverConnectionHandler )
    {
        this.queryId = queryId;
        this.server = serverConnectionHandler;
    }

    @Override
    public void close ()
    {
        this.query.close ();
    }

    @Override
    public void loadMore ( final int count )
    {
        this.query.loadMore ( count );
    }

    public void setQuery ( final Query queryHandle )
    {
        this.query = queryHandle;
    }

    public long getQueryId ()
    {
        return this.queryId;
    }

    @Override
    public void queryData ( final List<Event> events )
    {
        this.server.sendQueryData ( this, events );
    }

    @Override
    public void queryStateChanged ( final QueryState state, final Throwable error )
    {
        this.server.sendQueryState ( this, state, error );
    }

}
