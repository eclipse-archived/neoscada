/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.client.Connection;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractQueryBuffer extends AbstractPropertyChange
{

    private static final Logger logger = LoggerFactory.getLogger ( AbstractQueryBuffer.class );

    public static final String PROP_STATE = "state";

    public static final String PROP_QUERY_PARAMETERS = "queryParameters";

    public static final String PROP_REQUEST_PARAMETERS = "requestParameters";

    public static final String PROP_VALUE_TYPES = "valueTypes";

    public static final String PROP_FILLED = "filled";

    public static final String PROP_PERCENT_FILLED = "percentFilled";

    protected final Set<QueryListener> listeners = new HashSet<QueryListener> ();

    protected final String itemId;

    private QueryParameters requestParameters;

    private QueryParameters queryParameters;

    protected Query query;

    private QueryState state;

    private Set<String> valueTypes;

    private List<ValueInformation> valueInformation;

    private HashMap<String, List<Double>> values;

    private int filled;

    private double percentFilled;

    private Double lastFilled;

    private static double FILLED_DELTA = 1.0;

    public AbstractQueryBuffer ( final String itemId )
    {
        this.itemId = itemId;
    }

    public QueryState getState ()
    {
        return this.state;
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    /*
    public Connection getConnection ()
    {
        return this.connection;
    }
    */

    public QueryParameters getRequestParameters ()
    {
        return this.requestParameters;
    }

    public QueryParameters getQueryParameters ()
    {
        return this.queryParameters;
    }

    public Set<String> getValueTypes ()
    {
        return this.valueTypes;
    }

    public int getFilled ()
    {
        return this.filled;
    }

    public double getPercentFilled ()
    {
        return this.percentFilled;
    }

    /**
     * Return the current value information
     * 
     * @return the current value information
     */
    public List<ValueInformation> getValueInformation ()
    {
        return this.valueInformation;
    }

    /**
     * Return the current values
     * 
     * @return the current values
     */
    public Map<String, List<Double>> getValues ()
    {
        final Map<String, List<Double>> values;
        synchronized ( this )
        {
            values = this.values;
            if ( values == null )
            {
                return null;
            }
        }
        return new HashMap<String, List<Double>> ( values );
    }

    protected synchronized void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        final int count = valueInformation.size ();

        int filled = this.filled;
        for ( int i = 0; i < count; i++ )
        {
            if ( this.valueInformation.get ( i + index ) == null )
            {
                filled++;
            }
            this.valueInformation.set ( i + index, valueInformation.get ( i ) );
        }

        for ( final String type : this.valueTypes )
        {
            final List<Double> src = values.get ( type );
            final List<Double> dst = this.values.get ( type );

            final List<Double> sub = dst.subList ( index, index + count );
            sub.clear ();
            sub.addAll ( src );
        }

        // update stats
        setFilled ( filled );

        fireDataChange ( index, values, valueInformation );
    }

    private void setFilled ( final int filled )
    {
        final int oldFilled = this.filled;
        this.filled = filled;
        firePropertyChange ( PROP_FILLED, oldFilled, filled );

        final double percentFilled = filled / (double)this.queryParameters.getNumberOfEntries ();
        setPercentFilled ( percentFilled );
    }

    private void setPercentFilled ( final double percentFilled )
    {
        final double oldPercentFilled = this.percentFilled;
        this.percentFilled = percentFilled;

        if ( this.lastFilled == null || Math.abs ( this.lastFilled - percentFilled ) > FILLED_DELTA )
        {
            this.lastFilled = percentFilled;
            firePropertyChange ( PROP_PERCENT_FILLED, oldPercentFilled, percentFilled );
        }
    }

    protected void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        logger.info ( "Update parameters - queryParameters: {}, valueTypeS: {}", parameters, valueTypes );

        final int count = parameters.getNumberOfEntries ();

        final List<ValueInformation> newValueInformation = new ArrayList<ValueInformation> ( Arrays.asList ( new ValueInformation[count] ) );
        final HashMap<String, List<Double>> newValues = new HashMap<String, List<Double>> ();

        for ( final String valueType : valueTypes )
        {
            newValues.put ( valueType, new ArrayList<Double> ( Arrays.asList ( new Double[count] ) ) );
        }

        synchronized ( this )
        {
            this.valueInformation = newValueInformation;
            this.values = newValues;

            fireParameterChange ( parameters, valueTypes );

            setQueryParameters ( parameters );
            setValueTypes ( valueTypes );
            setFilled ( 0 );
        }
    }

    private void setValueTypes ( final Set<String> valueTypes )
    {
        logger.debug ( "Set value types: {}", valueTypes ); //$NON-NLS-1$

        final Set<String> oldValueTypes = this.valueTypes;
        this.valueTypes = valueTypes;
        firePropertyChange ( PROP_VALUE_TYPES, oldValueTypes, valueTypes );
    }

    private void setQueryParameters ( final QueryParameters parameters )
    {
        final QueryParameters oldParameters = this.queryParameters;
        this.queryParameters = parameters;
        firePropertyChange ( PROP_QUERY_PARAMETERS, oldParameters, parameters );
    }

    protected void setRequestParameters ( final QueryParameters parameters )
    {
        logger.debug ( "Setting request parameters: {}", parameters ); //$NON-NLS-1$

        final QueryParameters oldParameters = this.requestParameters;
        this.requestParameters = parameters;
        firePropertyChange ( PROP_REQUEST_PARAMETERS, oldParameters, parameters );
    }

    protected synchronized void updateState ( final QueryState state )
    {
        final QueryState oldState = this.state;
        this.state = state;

        fireStateChange ( state );
        firePropertyChange ( PROP_STATE, oldState, state );
    }

    private void fireDataChange ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
    {
        for ( final QueryListener listener : this.listeners )
        {
            listener.updateData ( index, values, valueInformation );
        }
    }

    private void fireParameterChange ( final QueryParameters parameters, final Set<String> valueTypes )
    {
        for ( final QueryListener listener : this.listeners )
        {
            listener.updateParameters ( parameters, valueTypes );
        }
    }

    private void fireStateChange ( final QueryState state )
    {
        for ( final QueryListener listener : this.listeners )
        {
            listener.updateState ( state );
        }
    }

    public void close ()
    {
        closeQuery ();
    }

    protected void closeQuery ()
    {
        if ( this.query != null )
        {
            this.query.close ();
            this.query = null;
        }
    }

    public synchronized void changeProperties ( final QueryParameters parameters )
    {
        logger.info ( "Request parameter change - new: {}, old: {}", new Object[] { parameters, this.requestParameters } ); //$NON-NLS-1$

        if ( !this.requestParameters.equals ( parameters ) )
        {
            setRequestParameters ( parameters );
            if ( this.query != null )
            {
                this.query.changeParameters ( parameters );
            }
        }
        else
        {
            logger.info ( "Ignore change request since there is no change" ); //$NON-NLS-1$
        }
    }

    public synchronized void addQueryListener ( final QueryListener listener )
    {
        if ( !this.listeners.add ( listener ) )
        {
            return;
        }

        listener.updateState ( this.state );
        if ( this.queryParameters != null )
        {
            listener.updateParameters ( this.queryParameters, this.valueTypes );
            transmitKnownData ( listener );
        }
    }

    private void transmitKnownData ( final QueryListener listener )
    {
        if ( this.valueInformation == null || this.valueInformation.size () == 0 )
        {
            return;
        }

        int start = 0;
        int count = 0;
        for ( int i = 0; i < this.valueInformation.size (); i++ )
        {
            if ( this.valueInformation.get ( i ) == null )
            {
                if ( count > 0 )
                {
                    // send now
                    sendCache ( listener, start, count );
                    count = 0;
                }
            }
            else
            {
                if ( count == 0 )
                {
                    start = i;
                }
                count++;
            }
        }

        if ( count > 0 )
        {
            sendCache ( listener, start, count );
        }
    }

    private void sendCache ( final QueryListener listener, final int start, final int count )
    {
        logger.info ( "Sending cache: start: {} - count: {}", new Object[] { start, count } ); //$NON-NLS-1$
        final List<ValueInformation> info = new ArrayList<ValueInformation> ( this.valueInformation.subList ( start, start + count ) );

        final Map<String, List<Double>> values = new HashMap<String, List<Double>> ();
        for ( final String type : this.valueTypes )
        {
            final List<Double> src = this.values.get ( type );
            final List<Double> dst = new ArrayList<Double> ( src.subList ( start, start + count ) );
            values.put ( type, dst );
        }

        listener.updateData ( start, this.values, info );
    }

    public synchronized void removeQueryListener ( final QueryListener listener )
    {
        this.listeners.remove ( listener );
    }

    protected synchronized void createQuery ( final Connection connection, final String itemId )
    {
        closeQuery ();
        this.query = connection.createQuery ( itemId, this.requestParameters, new QueryListener () {

            @Override
            public void updateState ( final QueryState state )
            {
                AbstractQueryBuffer.this.updateState ( state );
            }

            @Override
            public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
            {
                AbstractQueryBuffer.this.updateParameters ( parameters, valueTypes );
            }

            @Override
            public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
            {
                AbstractQueryBuffer.this.updateData ( index, values, valueInformation );
            }
        }, true );
    }

}