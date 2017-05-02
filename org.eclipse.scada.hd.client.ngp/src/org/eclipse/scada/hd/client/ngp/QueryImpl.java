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
package org.eclipse.scada.hd.client.ngp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueEntry;
import org.eclipse.scada.hd.data.ValueInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryImpl implements Query
{
    private final static Logger logger = LoggerFactory.getLogger ( QueryImpl.class );

    private final Executor executor;

    private final String itemId;

    private QueryParameters parameters;

    private QueryListener listener;

    private final ConnectionImpl connection;

    private boolean closed = false;

    private volatile Long queryId;

    public QueryImpl ( final Executor executor, final ConnectionImpl connection, final Long queryId, final String itemId, final QueryParameters parameters, final QueryListener listener )
    {
        this.executor = executor;
        this.connection = connection;
        this.queryId = queryId;
        this.itemId = itemId;
        this.parameters = parameters;
        this.listener = listener;

        synchronized ( this )
        {
            fireStateChange ( listener, QueryState.REQUESTED );
        }
    }

    @Override
    public void close ()
    {
        Long queryId;
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }
            this.closed = true;

            logger.info ( "Closing query: {} ({})", new Object[] { this.itemId, this.parameters } );

            // disconnect
            fireStateChange ( this.listener, QueryState.DISCONNECTED );
            this.listener = null;
            queryId = this.queryId;
            this.queryId = null;
        }

        // request close
        if ( queryId != null )
        {
            this.connection.closeQuery ( queryId );
        }
    }

    private void fireStateChange ( final QueryListener listener, final QueryState state )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                listener.updateState ( state );
            }
        } );
    }

    private void fireParameterChange ( final QueryListener listener, final QueryParameters parameters, final Set<String> valueTypes )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                listener.updateParameters ( parameters, valueTypes );
            }
        } );
    }

    private void fireDataChange ( final QueryListener listener, final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                logger.debug ( "Data update: {} (v: {}, vi: {})", new Object[] { index, values.size (), valueInformation.size () } );
                QueryImpl.this.listener.updateData ( index, values, valueInformation );
            }
        } );
    }

    @Override
    public void changeParameters ( final QueryParameters parameters )
    {
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }

            if ( this.parameters == parameters )
            {
                return;
            }
            this.parameters = parameters;
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    QueryImpl.this.connection.updateQueryParameters ( QueryImpl.this, parameters );
                };
            } );
        }

    }

    public Long getId ()
    {
        return this.queryId;
    }

    public void handleUpdateStatus ( final QueryState state )
    {
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }

            fireStateChange ( this.listener, state );
        }
    }

    public void handleUpdateData ( final int index, final List<ValueEntry> values, final List<ValueInformation> valueInformation )
    {
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }

            final Map<String, List<Double>> valueMap = new HashMap<String, List<Double>> ();

            for ( final ValueEntry entry : values )
            {
                valueMap.put ( entry.getValueType (), entry.getValues () );
            }

            fireDataChange ( this.listener, index, valueMap, valueInformation );
        }
    }

    public void handleUpdateParameter ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }

            fireParameterChange ( this.listener, parameters, valueTypes );
        }
    }

}
