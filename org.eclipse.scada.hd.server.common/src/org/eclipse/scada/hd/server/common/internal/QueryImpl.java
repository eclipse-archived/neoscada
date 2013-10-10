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
package org.eclipse.scada.hd.server.common.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryImpl implements Query, QueryListener
{

    private final static Logger logger = LoggerFactory.getLogger ( QueryImpl.class );

    private Query query;

    private final SessionImpl session;

    private final QueryListener listener;

    private QueryParameters queryParameters;

    private HashSet<String> valueTypes;

    public QueryImpl ( final SessionImpl session, final QueryListener listener )
    {
        this.session = session;
        this.listener = listener;
        session.addQuery ( this );
    }

    public void setQuery ( final Query query )
    {
        if ( this.query == null )
        {
            this.query = query;
        }
    }

    @Override
    public void close ()
    {
        dispose ();
    }

    public void dispose ()
    {
        this.session.removeQuery ( this );
        if ( this.query != null )
        {
            this.query.close ();
        }
    }

    @Override
    public void changeParameters ( final QueryParameters parameters )
    {
        logger.debug ( "changeParameters: parameters: {}", parameters );
        this.query.changeParameters ( parameters );
    }

    @Override
    public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        logger.debug ( "updateParameters: parameters: {}, valueTypes: {}", new Object[] { parameters, valueTypes } );
        if ( parameters == null )
        {
            throw new IllegalArgumentException ( "'parameters' must not be null" );
        }
        if ( valueTypes == null || valueTypes.isEmpty () )
        {
            throw new IllegalArgumentException ( "'valueTypes' must not be null or empty" );
        }

        synchronized ( this )
        {
            this.queryParameters = parameters;
            this.valueTypes = new HashSet<String> ( valueTypes );
        }
        this.listener.updateParameters ( parameters, valueTypes );
    }

    @Override
    public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        if ( values == null )
        {
            throw new IllegalArgumentException ( "'values' must not be null" );
        }
        if ( valueInformation == null )
        {
            throw new IllegalArgumentException ( "'valueInformation' must not be null" );
        }

        logger.debug ( "updateData: index: {}, values: @{} ({}), valueInformation: @{}", new Object[] { index, values.size (), values.keySet (), valueInformation.size () } );

        synchronized ( this )
        {
            if ( this.queryParameters == null )
            {
                throw new IllegalStateException ( "'updateData' must be called after a call to 'updateParameters'" );
            }
            if ( !this.valueTypes.equals ( values.keySet () ) )
            {
                throw new IllegalArgumentException ( "'updateData' must receive the same data series as the 'updateParameters' call" );
            }
        }
        if ( index < 0 || index >= this.queryParameters.getNumberOfEntries () )
        {
            throw new IllegalArgumentException ( "'index' must be greater or equal to zero and lower than the number of reported entries" );
        }
        for ( final Map.Entry<String, List<Double>> entry : values.entrySet () )
        {
            if ( entry.getValue () == null )
            {
                throw new IllegalArgumentException ( String.format ( "The values for '%s' are null", entry.getKey () ) );
            }
            if ( entry.getValue ().size () != valueInformation.size () )
            {
                throw new IllegalArgumentException ( String.format ( "The number of entries for '%s' is not equal to the rest of the entry count", entry.getKey () ) );
            }
        }
        if ( index + valueInformation.size () > this.queryParameters.getNumberOfEntries () )
        {
            throw new IllegalArgumentException ( "The reported data exceeds reported number of entries" );
        }

        // finally we can pass on the event
        this.listener.updateData ( index, values, valueInformation );
    }

    @Override
    public void updateState ( final QueryState state )
    {
        logger.debug ( "updateState: state: {}", new Object[] { state } );

        if ( state == null )
        {
            throw new IllegalArgumentException ( "'state' must not be null" );
        }

        try
        {
            this.listener.updateState ( state );
        }
        finally
        {
            switch ( state )
            {
                case DISCONNECTED:
                    this.session.removeQuery ( this );
                    break;
                default:
                    break;
            }
        }
    }

}
