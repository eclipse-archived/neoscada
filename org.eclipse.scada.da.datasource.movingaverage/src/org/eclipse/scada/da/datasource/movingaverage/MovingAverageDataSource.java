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
package org.eclipse.scada.da.datasource.movingaverage;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker.ServiceListener;
import org.eclipse.scada.da.datasource.base.DataInputSource;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovingAverageDataSource implements DataSourceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( MovingAverageDataSource.class );

    private DataItemValueRange valueRange;

    private final ExecutorService executor;

    private final ScheduledExecutorService scheduler;

    private SingleDataSourceTracker dataSourceTracker;

    private String dataSourceId;

    private DataSource dataSource;

    private final String configurationId;

    private final ObjectPoolTracker<DataSource> poolTracker;

    private final ObjectPoolImpl<DataSource> dsObjectPool;

    private ScheduledFuture<?> triggerFuture;

    private long trigger;

    private long range;

    private long nullrange;

    private boolean triggerOnly = false;

    private final DataInputSource minDataSource;

    private final DataInputSource maxDataSource;

    private final DataInputSource arithmeticDataSource;

    private final DataInputSource medianDataSource;

    private final DataInputSource weightedDataSource;

    private final DataInputSource deviationArithmeticDataSource;

    private final DataInputSource deviationWeightedDataSource;

    public MovingAverageDataSource ( final String configurationId, final ExecutorService executor, final ScheduledExecutorService scheduler, final ObjectPoolTracker<DataSource> poolTracker, final ObjectPoolImpl<DataSource> dsObjectPool ) throws InvalidSyntaxException
    {
        this.executor = executor;
        this.scheduler = scheduler;
        this.valueRange = new DataItemValueRange ( executor, 0 );
        this.configurationId = configurationId;
        this.poolTracker = poolTracker;
        this.dsObjectPool = dsObjectPool;
        this.minDataSource = new DataInputSource ( scheduler );
        this.maxDataSource = new DataInputSource ( scheduler );
        this.arithmeticDataSource = new DataInputSource ( scheduler );
        this.medianDataSource = new DataInputSource ( scheduler );
        this.weightedDataSource = new DataInputSource ( scheduler );
        this.deviationArithmeticDataSource = new DataInputSource ( scheduler );
        this.deviationWeightedDataSource = new DataInputSource ( scheduler );

        {
            final String id = this.configurationId + ".min";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.minDataSource, null );
        }
        {
            final String id = this.configurationId + ".max";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.maxDataSource, null );
        }
        {
            final String id = this.configurationId + ".arithmetic";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.arithmeticDataSource, null );
        }
        {
            final String id = this.configurationId + ".median";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.medianDataSource, null );
        }
        {
            final String id = this.configurationId + ".weighted";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.weightedDataSource, null );
        }
        {
            final String id = this.configurationId + ".deviationArithmetic";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.deviationArithmeticDataSource, null );
        }
        {
            final String id = this.configurationId + ".deviationWeighted";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.deviationWeightedDataSource, null );
        }
    }

    public void dispose ()
    {
        this.dsObjectPool.removeService ( this.configurationId + ".min", this.minDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".max", this.maxDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".arithmetic", this.arithmeticDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".median", this.medianDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".weighted", this.weightedDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".deviationArithmetic", this.deviationArithmeticDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".deviationWeighted", this.deviationWeightedDataSource );
    }

    public void update ( final Map<String, String> parameters ) throws InvalidSyntaxException
    {
        if ( this.triggerFuture != null )
        {
            this.triggerFuture.cancel ( false );
            this.triggerFuture = null;
        }

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        try
        {
            this.dataSourceId = cfg.getStringChecked ( "datasource.id", "'datasource.id' must be set" ); //$NON-NLS-1$
            this.trigger = cfg.getLongChecked ( "trigger", "'trigger' must be set" ); //$NON-NLS-1$
            this.range = cfg.getLongChecked ( "range", "'range' must be set" ); //$NON-NLS-1$
            this.nullrange = cfg.getLongChecked ( "nullRange", "'nullRange' must be set" ); //$NON-NLS-1$
            this.triggerOnly = cfg.getBoolean ( "triggerOnly", false ); //$NON-NLS-1$
        }
        catch ( final IllegalArgumentException e )
        {
            updateAverage ( new AverageValues () );
            throw e;
        }

        handleChange ();
    }

    private void handleChange () throws InvalidSyntaxException
    {
        this.valueRange = new DataItemValueRange ( this.executor, this.range * 1000 );
        updateDataSource ();
        this.triggerFuture = this.scheduler.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                try
                {
                    MovingAverageDataSource.this.valueRange.checkRange ();
                    updateValues ();
                }
                catch ( final Exception e )
                {
                    logger.error ( "failed to run checkRange () or call updateValues ()", e );
                }
            }
        }, this.trigger, this.trigger, TimeUnit.SECONDS );
        try
        {
            updateValues ();
        }
        catch ( final Exception e )
        {
            logger.error ( "failed to update values", e );
        }
    }

    @Override
    public void stateChanged ( final DataItemValue value )
    {
        try
        {
            this.valueRange.add ( DataItemValueLight.valueOf ( value ) );
            if ( !this.triggerOnly )
            {
                updateValues ();
            }
        }
        catch ( final Exception e )
        {
            logger.error ( "failed to add DataItemValue or to call updateValues ()", e );
        }
    }

    private void updateValues ()
    {
        final DataItemValueRange.DataItemValueRangeState state = this.valueRange.getState ();
        final AverageValues average = new AverageValues ();
        if ( state.getSize () == 0 )
        {
            // we don't have values fitting within time frame, just use last available
            if ( state.getFirstValue ().hasValue () )
            {
                average.min = state.getFirstValue ().getValue ().asDouble ( 0.0 );
                average.max = state.getFirstValue ().getValue ().asDouble ( 0.0 );
                average.arithmetic = state.getFirstValue ().getValue ().asDouble ( 0.0 );
                average.median = state.getFirstValue ().getValue ().asDouble ( 0.0 );
                average.weighted = state.getFirstValue ().getValue ().asDouble ( 0.0 );
                average.deviationArithmetic = 0.0;
                average.deviationWeighted = 0.0;
            }
        }
        else
        {
            // ok, so we have at least one value in our list (could still be null)
            DataItemValueLight lastValue = new DataItemValueLight ( state.getFirstValue ().getValue (), state.getFirstValue ().getSubscriptionState (), state.getOldestPossibleTimestamp (), state.getFirstValue ().isManual (), state.getFirstValue ().isError () );
            final Iterator<DataItemValueLight> it = state.getValues ().iterator (); // it is a set, so we have to use an iterator
            for ( int i = 0; i < ( state.getSize () + 1 ); i++ )
            {
                if ( i < state.getSize () )
                {
                    final DataItemValueLight divl = it.next ();
                    final long currentRange = divl.getTimestamp () - lastValue.getTimestamp ();
                    calculateForRange ( average, currentRange, lastValue.getValue (), lastValue.isManual (), lastValue.isError (), lastValue.getSubscriptionState () != SubscriptionState.DISCONNECTED );
                    lastValue = divl;
                }
                else
                {
                    final long currentRange = ( state.getOldestPossibleTimestamp () + this.valueRange.getRange () ) - lastValue.getTimestamp ();
                    calculateForRange ( average, currentRange, lastValue.getValue (), lastValue.isManual (), lastValue.isError (), lastValue.getSubscriptionState () != SubscriptionState.DISCONNECTED );
                }
            }

            // now calculate actual arithmetic average
            if ( average.values.size () > 0 )
            {
                average.arithmetic = average.arithmetic / average.values.size ();
            }

            // now get median
            if ( average.values.size () > 0 )
            {
                average.median = average.values.get ( average.values.size () / 2 );
            }
            // calculate actual weighted value
            if ( average.weighted != null )
            {
                average.weighted = average.weighted / this.valueRange.getRange ();
            }

            // calculate deviation
            if ( !average.values.isEmpty () )
            {
                double da = 0.0;
                double dw = 0.0;
                for ( final double v : average.values )
                {
                    da += Math.pow ( v - average.arithmetic, 2.0 );
                    dw += Math.pow ( v - average.weighted, 2.0 );
                }
                average.deviationArithmetic = Math.sqrt ( da / average.values.size () );
                average.deviationWeighted = Math.sqrt ( dw / average.values.size () );
            }

            // handle null range
            if ( average.nullRange >= ( this.nullrange * 1000 ) )
            {
                average.arithmetic = null;
                average.median = null;
                average.weighted = null;
                average.deviationArithmetic = null;
                average.deviationWeighted = null;
            }
        }

        updateAverage ( average );
    }

    private void updateAverage ( final AverageValues average )
    {
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.min ) );
            setAdditionalAttributes ( divb, average );
            this.minDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.max ) );
            setAdditionalAttributes ( divb, average );
            this.maxDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.arithmetic ) );
            setAdditionalAttributes ( divb, average );
            this.arithmeticDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.median ) );
            setAdditionalAttributes ( divb, average );
            this.medianDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.weighted ) );
            setAdditionalAttributes ( divb, average );
            this.weightedDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.deviationArithmetic ) );
            setAdditionalAttributes ( divb, average );
            this.deviationArithmeticDataSource.setValue ( divb.build () );
        }
        {
            final Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( average.deviationWeighted ) );
            setAdditionalAttributes ( divb, average );
            this.deviationWeightedDataSource.setValue ( divb.build () );
        }
    }

    private void setAdditionalAttributes ( final Builder divb, final AverageValues average )
    {
        if ( average.manualRange > 0 )
        {
            divb.setAttribute ( Activator.getContext ().getBundle ().getSymbolicName () + ".manual", Variant.valueOf ( true ) );
        }
        if ( average.errorRange > this.nullrange * 1000 )
        {
            divb.setAttribute ( Activator.getContext ().getBundle ().getSymbolicName () + ".error", Variant.valueOf ( true ) );
        }
        if ( average.disconnectedRange > this.nullrange * 1000 )
        {
            divb.setSubscriptionState ( SubscriptionState.DISCONNECTED );
        }
    }

    private void calculateForRange ( final AverageValues average, final long currentRange, final Variant value, final boolean isManual, final boolean isError, final boolean isDisconnected )
    {
        if ( !value.isNumber () )
        {
            average.nullRange += currentRange;
        }
        else
        {
            final double d = value.asDouble ( 0.0 );

            average.min = average.min == null ? d : average.min;
            average.max = average.max == null ? d : average.max;
            average.arithmetic = average.arithmetic == null ? 0.0 : average.arithmetic;
            average.weighted = average.weighted == null ? 0.0 : average.weighted;

            average.min = d < average.min ? d : average.min;
            average.max = d > average.max ? d : average.max;
            average.arithmetic += d;
            average.values.add ( d );
            average.weighted += d * currentRange;
        }
        if ( isManual )
        {
            average.manualRange += currentRange;
        }
        if ( isError )
        {
            average.errorRange += currentRange;
        }
        if ( isDisconnected )
        {
            average.disconnectedRange += currentRange;
        }
    }

    private void updateDataSource () throws InvalidSyntaxException
    {
        logger.debug ( "updateDataSource ()" );
        if ( this.dataSourceTracker != null )
        {
            this.dataSourceTracker.close ();
            this.dataSourceTracker = null;
        }
        if ( this.dataSourceId != null )
        {
            logger.debug ( "track datasource {}", this.dataSourceId );
            this.dataSourceTracker = new SingleDataSourceTracker ( this.poolTracker, this.dataSourceId, new ServiceListener () {
                @Override
                public void dataSourceChanged ( final DataSource dataSource )
                {
                    setDataSource ( dataSource );
                }
            } );
            this.dataSourceTracker.open ();
        }
    }

    private void setDataSource ( final DataSource dataSource )
    {
        logger.info ( "Set data source item: {}", dataSource );

        if ( this.dataSource != null )
        {
            this.dataSource.removeListener ( this );
        }
        this.dataSource = dataSource;
        if ( this.dataSource != null )
        {
            this.dataSource.addListener ( this );
        }
    }

    private class AverageValues
    {
        public Double min;

        public Double max;

        public Double arithmetic;

        public Double median;

        public Double weighted;

        public Double deviationArithmetic;

        public Double deviationWeighted;

        public long nullRange = 0;

        public long manualRange = 0;

        public long errorRange = 0;

        public long disconnectedRange = 0;

        public LinkedList<Double> values = new LinkedList<Double> ();
    }
}
