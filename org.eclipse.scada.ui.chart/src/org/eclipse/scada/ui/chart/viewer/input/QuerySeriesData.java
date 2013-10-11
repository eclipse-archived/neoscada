/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - additional work
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
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.chart.AbstractSeriesData;
import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.SeriesViewData;
import org.eclipse.scada.chart.WritableSeriesData;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.scada.hd.ui.data.ServiceQueryBuffer;
import org.eclipse.scada.ui.chart.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuerySeriesData extends AbstractSeriesData
{

    private final static Logger logger = LoggerFactory.getLogger ( QuerySeriesData.class );

    private final ServiceQueryBuffer query;

    private QueryParameters parameters;

    private QueryParameters nextParameters;

    private final Item item;

    public QuerySeriesData ( final Item item, final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        super ( realm, xAxis, yAxis );
        this.item = item;

        this.parameters = makeInitialParameters ();

        switch ( item.getType () )
        {
            case ID:
                this.query = new ServiceQueryBuffer ( Activator.getDefault ().getBundle ().getBundleContext (), item.getConnectionString (), item.getId (), this.parameters = makeInitialParameters () );
                break;
            default:
                this.query = new ServiceQueryBuffer ( Activator.getDefault ().getBundle ().getBundleContext (), createRequest (), item.getId (), this.parameters = makeInitialParameters () );
                break;
        }

        this.query.addQueryListener ( new QueryListener () {

            @Override
            public void updateState ( final QueryState state )
            {
                logger.debug ( "Query state changed: {}", state );
                handleUpdate ();
            }

            @Override
            public void updateParameters ( final QueryParameters parameters, final Set<String> valueTypes )
            {
                handleUpdate ();
            }

            @Override
            public void updateData ( final int index, final Map<String, List<Double>> values, final List<ValueInformation> valueInformation )
            {
                handleUpdate ();
            }
        } );
    }

    public ServiceQueryBuffer getQuery ()
    {
        return this.query;
    }

    protected void handleUpdate ()
    {
        checkRequest ();
        if ( this.query.getQueryParameters () == null )
        {
            logger.debug ( "No query parameters. No update call" );
            return;
        }
        fireUpdateListener ( this.query.getQueryParameters ().getStartTimestamp (), this.query.getQueryParameters ().getEndTimestamp () );
    }

    private QueryParameters makeInitialParameters ()
    {
        return new QueryParameters ( getXAxis ().getMin (), getXAxis ().getMax (), 25 );
    }

    private ConnectionRequest createRequest ()
    {
        return new ConnectionRequest ( null, ConnectionInformation.fromURI ( this.item.getConnectionString () ), null, false );
    }

    @Override
    public void setRequestWindow ( final long startTimestamp, final long endTimestamp )
    {
        logger.info ( "Setting request window - start: {}, end: {}", startTimestamp, endTimestamp ); //$NON-NLS-1$

        changeParameters ( new QueryParameters ( startTimestamp, endTimestamp, this.parameters.getNumberOfEntries () ) );
    }

    private void checkRequest ()
    {
        if ( this.nextParameters != null )
        {
            changeParameters ( this.nextParameters );
        }
    }

    private void changeParameters ( final QueryParameters parameters )
    {
        if ( parameters == null )
        {
            return;
        }

        this.parameters = parameters;
        if ( this.query.getState () == QueryState.COMPLETE )
        {
            this.nextParameters = null;
            logger.info ( "Change request parameters - parameters: {}, item: {}", parameters, this.item ); //$NON-NLS-1$
            this.query.changeProperties ( this.parameters );
        }
        else
        {
            this.nextParameters = parameters;
        }
    }

    @Override
    public void setRequestWidth ( final int width )
    {
        changeParameters ( new QueryParameters ( this.parameters.getStartTimestamp (), this.parameters.getEndTimestamp (), Math.max ( 0, width ) ) );
    }

    public SeriesViewData getViewData ( final String type )
    {
        final WritableSeriesData data = new WritableSeriesData ();

        if ( this.query.getState () == QueryState.DISCONNECTED )
        {
            return data;
        }

        final Map<String, List<Double>> values = this.query.getValues ();
        if ( values == null )
        {
            return data;
        }

        final List<Double> rawData = this.query.getValues ().get ( type );
        if ( rawData == null )
        {
            return data;
        }

        final List<ValueInformation> info = this.query.getValueInformation ();
        if ( info == null || info.size () != rawData.size () )
        {
            return data;
        }

        for ( int i = 0; i < info.size (); i++ )
        {
            if ( info.get ( i ) == null )
            {
                continue;
            }

            final long timestamp = info.get ( i ).getStartTimestamp ();

            if ( rawData.get ( i ) != null )
            {
                final Double value = rawData.get ( i );
                data.add ( new DataEntry ( timestamp, value ) );
            }
            else
            {
                data.add ( new DataEntry ( timestamp, null ) );
            }
        }

        return data;
    }

    public SeriesViewData getQualityData ()
    {
        final WritableSeriesData data = new WritableSeriesData ();

        if ( this.query.getState () == QueryState.DISCONNECTED )
        {
            return data;
        }

        final Map<String, List<Double>> values = this.query.getValues ();
        if ( values == null )
        {
            return data;
        }

        final List<ValueInformation> rawData = this.query.getValueInformation ();
        if ( rawData == null )
        {
            return data;
        }

        final List<ValueInformation> info = this.query.getValueInformation ();
        if ( info == null || info.size () != rawData.size () )
        {
            return data;
        }

        for ( int i = 0; i < info.size (); i++ )
        {
            if ( info.get ( i ) == null )
            {
                continue;
            }

            final long timestamp = info.get ( i ).getStartTimestamp ();

            if ( rawData.get ( i ) != null )
            {
                final Double value = rawData.get ( i ).getQuality ();
                data.add ( new DataEntry ( timestamp, value ) );
            }
            else
            {
                data.add ( new DataEntry ( timestamp, null ) );
            }
        }

        return data;
    }

    @Override
    public SeriesViewData getViewData ()
    {
        return getViewData ( "AVG" ); //$NON-NLS-1$
    }

    @Override
    public void dispose ()
    {
        this.query.close ();
        super.dispose ();
    }

    public void open ()
    {
        this.query.open ();
    }

    public void close ()
    {
        this.query.close ();
    }

}
