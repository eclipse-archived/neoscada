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
package org.eclipse.scada.da.datasource.average;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.MultiDataSourceTracker;
import org.eclipse.scada.da.datasource.MultiDataSourceTracker.ServiceListener;
import org.eclipse.scada.da.datasource.base.DataInputSource;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AverageDataSource implements ServiceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( AverageDataSource.class );

    private final ObjectPoolTracker<DataSource> poolTracker;

    private MultiDataSourceTracker tracker;

    private Set<String> sourceIds;

    private final ConcurrentMap<DataSource, DataSourceHandler> sources = new ConcurrentHashMap<DataSource, DataSourceHandler> ();

    private int noOfValidSourcesRequired = 0;

    private final String configurationId;

    private final ObjectPoolImpl<DataSource> dsObjectPool;

    private final DataInputSource sumDataSource;

    private final DataInputSource minDataSource;

    private final DataInputSource maxDataSource;

    private final DataInputSource meanDataSource;

    private final DataInputSource medianDataSource;

    private final DataInputSource deviationDataSource;

    public AverageDataSource ( final String configurationId, final ObjectPoolTracker<DataSource> poolTracker, final ExecutorService executor, final ObjectPoolImpl<DataSource> dsObjectPool )
    {
        this.poolTracker = poolTracker;
        this.configurationId = configurationId;
        this.dsObjectPool = dsObjectPool;

        this.sumDataSource = new DataInputSource ( executor );
        this.minDataSource = new DataInputSource ( executor );
        this.maxDataSource = new DataInputSource ( executor );
        this.meanDataSource = new DataInputSource ( executor );
        this.medianDataSource = new DataInputSource ( executor );
        this.deviationDataSource = new DataInputSource ( executor );

        {
            final String id = this.configurationId + ".min";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.minDataSource, null );
        }
        {
            final String id = this.configurationId + ".sum";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.sumDataSource, null );
        }
        {
            final String id = this.configurationId + ".max";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.maxDataSource, null );
        }
        {
            final String id = this.configurationId + ".mean";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.meanDataSource, null );
        }
        {
            final String id = this.configurationId + ".median";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.medianDataSource, null );
        }
        {
            final String id = this.configurationId + ".deviation";
            final Dictionary<String, String> properties = new Hashtable<String, String> ( 1 );
            properties.put ( DataSource.DATA_SOURCE_ID, id );
            this.dsObjectPool.addService ( id, this.deviationDataSource, null );
        }
    }

    public void dispose ()
    {
        this.dsObjectPool.removeService ( this.configurationId + ".sum", this.sumDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".min", this.minDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".max", this.maxDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".mean", this.meanDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".median", this.medianDataSource );
        this.dsObjectPool.removeService ( this.configurationId + ".deviation", this.deviationDataSource );

        for ( final DataSourceHandler handler : this.sources.values () )
        {
            handler.dispose ();
        }

        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }
    }

    public void update ( final Map<String, String> properties ) throws Exception
    {
        setSources ( properties.get ( "sources" ) );
        setValidSourcesRequired ( properties.get ( "validSourcesRequired" ) );
        handleChange ();
    }

    private void setSources ( final String str ) throws InvalidSyntaxException
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }

        for ( final DataSourceHandler source : this.sources.values () )
        {
            source.dispose ();
        }
        this.sources.clear ();
        this.sourceIds = convertSources ( str );

        if ( this.sourceIds.isEmpty () )
        {
            // nothing to do if we don't have any source
            return;
        }

        this.tracker = new MultiDataSourceTracker ( this.poolTracker, this.sourceIds, this );
        this.tracker.open ();
    }

    private Set<String> convertSources ( final String sources )
    {
        if ( sources == null )
        {
            throw new IllegalArgumentException ( "'sources' must be set" );
        }

        return new LinkedHashSet<String> ( Arrays.asList ( sources.split ( "[, ]+" ) ) );
    }

    private void setValidSourcesRequired ( final String validSourcesRequired )
    {
        // special case empty:
        // only if all items are invalid, the resultant value is also invalid
        if ( ( validSourcesRequired == null ) || validSourcesRequired.isEmpty () )
        {
            this.noOfValidSourcesRequired = 0;
            return;
        }
        // special case 100%:
        // all values must be valid to have a valid result
        if ( validSourcesRequired.equals ( "100%" ) )
        {
            this.noOfValidSourcesRequired = this.sourceIds.size ();
            return;
        }
        try
        {
            if ( validSourcesRequired.endsWith ( "%" ) )
            {
                // handle percentages
                final int percent = Integer.parseInt ( validSourcesRequired.replace ( "%", "" ) );
                if ( percent >= 100 )
                {
                    this.noOfValidSourcesRequired = this.sourceIds.size ();
                    return;
                }
                this.noOfValidSourcesRequired = Long.valueOf ( Math.round ( ( percent * this.sourceIds.size () ) / 100.0 ) ).intValue ();
            }
            else
            {
                // handle absolute values
                this.noOfValidSourcesRequired = Integer.parseInt ( validSourcesRequired );
                if ( this.noOfValidSourcesRequired > this.sourceIds.size () )
                {
                    logger.warn ( "'validSourcesRequired' was '{}' which should be less then the number of all elements", validSourcesRequired, this.sourceIds.size () );
                    this.noOfValidSourcesRequired = this.sourceIds.size ();
                }
            }
        }
        catch ( final NumberFormatException e )
        {
            logger.warn ( "'validSourcesRequired' was '{}' which could not be parsed", validSourcesRequired, e );
            // re-throw for the CA to get notified
            throw e;
        }
    }

    protected void handleChange ()
    {
        final ArrayList<Double> validValues = new ArrayList<Double> ( this.sources.size () );
        int numOfManualValues = 0;
        int numOfErrorValues = 0;
        int numOfDisconnected = 0;

        Double sum = null;
        Double min = null;
        Double max = null;
        Double mean = null;
        Double median = null;
        Double deviation = null;
        for ( final DataSourceHandler handler : this.sources.values () )
        {
            final DataItemValue div = handler.getValue ();
            if ( ( div != null ) && div.isConnected () && !div.isError () )
            {
                if ( ( div.getValue () != null ) && div.getValue ().isNumber () )
                {
                    final Double d = div.getValue ().asDouble ( 0.0 );
                    min = min == null ? d : d < min ? d : min;
                    max = max == null ? d : d > max ? d : max;
                    sum = sum == null ? d : sum + d;
                    validValues.add ( d );
                    numOfManualValues += ( div.isManual () ? 1 : 0 );
                }
            }
            else if ( ( div != null ) && div.isConnected () && div.isError () )
            {
                numOfErrorValues += 1;
            }
            else if ( ( div == null ) || !div.isConnected () )
            {
                numOfDisconnected += 1;
            }
        }

        if ( validValues.size () > 0 )
        {
            mean = sum / validValues.size ();
            median = validValues.get ( validValues.size () / 2 );
            Double dd = 0.0;
            for ( final Double d : validValues )
            {
                dd += Math.pow ( d - mean, 2 );
            }
            deviation = Math.sqrt ( dd / validValues.size () );
        }

        if ( validValues.size () < this.noOfValidSourcesRequired )
        {
            sum = null;
            mean = null;
            median = null;
            deviation = null;
        }

        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( sum ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.sumDataSource.setValue ( divb.build () );
        }
        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( min ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.minDataSource.setValue ( divb.build () );
        }
        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( max ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.maxDataSource.setValue ( divb.build () );
        }
        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( mean ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.meanDataSource.setValue ( divb.build () );
        }
        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( median ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.medianDataSource.setValue ( divb.build () );
        }
        {
            final DataItemValue.Builder divb = new DataItemValue.Builder ().setSubscriptionState ( SubscriptionState.CONNECTED ).setValue ( Variant.valueOf ( deviation ) );
            setAdditionalAttributes ( divb, numOfManualValues, numOfErrorValues, numOfDisconnected );
            this.deviationDataSource.setValue ( divb.build () );
        }
    }

    private void setAdditionalAttributes ( final Builder divb, final int numOfManualValues, final int numOfErrorValues, final int numOfDisconnected )
    {
        if ( numOfManualValues > 0 )
        {
            divb.setAttribute ( Activator.getContext ().getBundle ().getSymbolicName () + ".manual", Variant.valueOf ( true ) );
        }
        if ( ( this.sources.size () - numOfErrorValues ) < this.noOfValidSourcesRequired )
        {
            divb.setAttribute ( Activator.getContext ().getBundle ().getSymbolicName () + ".error", Variant.valueOf ( true ) );
        }
        if ( ( this.sources.size () - numOfDisconnected ) < this.noOfValidSourcesRequired )
        {
            divb.setSubscriptionState ( SubscriptionState.DISCONNECTED );
        }
    }

    private class DataSourceHandler implements DataSourceListener
    {
        private final DataSource dataSource;

        private DataItemValue value;

        DataSourceHandler ( final DataSource dataSource )
        {
            this.dataSource = dataSource;

            dataSource.addListener ( this );
        }

        public void dispose ()
        {
            this.dataSource.removeListener ( this );
        }

        public DataItemValue getValue ()
        {
            return this.value;
        }

        @Override
        public void stateChanged ( final DataItemValue value )
        {
            this.value = value;
            handleChange ();
        }
    }

    private synchronized void addSource ( final DataSource dataSource )
    {
        logger.info ( "Adding source: {}", new Object[] { dataSource } );

        final DataSourceHandler handler = new DataSourceHandler ( dataSource );

        final DataSourceHandler oldHandler = this.sources.put ( dataSource, handler );
        if ( oldHandler != null )
        {
            oldHandler.dispose ();
        }

        handleChange ();
    }

    private synchronized void updateSource ( final DataSource dataSource )
    {
        logger.info ( "Updating source: {} / {}", new Object[] { dataSource } );

        final DataSourceHandler handler = this.sources.get ( dataSource );
        if ( handler != null )
        {
            handleChange ();
        }
    }

    private synchronized void removeSource ( final DataSource dataSource )
    {
        logger.info ( "Removing source: {}", dataSource );

        final DataSourceHandler handler = this.sources.remove ( dataSource );
        if ( handler != null )
        {
            handler.dispose ();
            handleChange ();
        }
    }

    @Override
    public void dataSourceAdded ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        addSource ( dataSource );
    }

    @Override
    public void dataSourceRemoved ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        updateSource ( dataSource );
    }

    @Override
    public void dataSourceModified ( final String id, final Dictionary<?, ?> properties, final DataSource dataSource )
    {
        removeSource ( dataSource );
    }
}
