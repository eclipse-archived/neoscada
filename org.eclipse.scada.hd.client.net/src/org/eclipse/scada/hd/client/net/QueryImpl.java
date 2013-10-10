/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.client.net;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
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

    private Long id;

    private Long closeId;

    public QueryImpl ( final Executor executor, final ConnectionImpl connection, final String itemId, final QueryParameters parameters, final QueryListener listener )
    {
        this.executor = executor;
        this.connection = connection;
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
            this.closeId = this.id;
            this.id = null;
        }

        // request close
        this.connection.closeQuery ( this );
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
        }

        this.connection.updateQueryParameters ( this, parameters );
    }

    public void setId ( final Long id )
    {
        this.id = id;
    }

    public Long getId ()
    {
        return this.id;
    }

    /**
     * The id of the query used for closing it.
     * <p>
     * Since the ID will be set to <code>null</code> once the query gets closed,
     * this id will be used to close the query. It must be the same value as the
     * original id, but only set when the query gets closed.
     * </p>
     * 
     * @return the id of the query when closing
     */
    public Long getCloseId ()
    {
        return this.closeId;
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

    public void handleUpdateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        synchronized ( this )
        {
            if ( this.closed )
            {
                return;
            }

            fireDataChange ( this.listener, index, values, valueInformation );
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
