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
package org.eclipse.scada.hd.server.net;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;

public class QueryHandler implements QueryListener
{

    private Query query;

    private final ServerConnectionHandler connectionHandler;

    private final long id;

    public QueryHandler ( final long id, final ServerConnectionHandler connectionHandler )
    {
        this.id = id;
        this.connectionHandler = connectionHandler;
    }

    @Override
    public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        this.connectionHandler.sendQueryData ( this.id, index, values, valueInformation );
    }

    @Override
    public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        this.connectionHandler.sendQueryParameters ( this.id, parameters, valueTypes );
    }

    @Override
    public void updateState ( final QueryState state )
    {
        this.connectionHandler.sendQueryState ( this.id, state );
    }

    public void setQuery ( final Query query )
    {
        this.query = query;
    }

    public void close ()
    {
        if ( this.query != null )
        {
            this.query.close ();
        }
    }

    public void changeParameters ( final QueryParameters parameters )
    {
        this.query.changeParameters ( parameters );
    }

}
