/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.changecounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.buffer.BufferedDataSource;
import org.eclipse.scada.da.buffer.BufferedDataSourceListener;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.datasource.base.AbstractInputDataSource;
import org.eclipse.scada.da.datasource.data.DataItemValueRange;
import org.eclipse.scada.da.datasource.data.DataItemValueRange.DataItemValueRangeState;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.SingleObjectPoolServiceTracker.ServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeCounterDataSource extends AbstractInputDataSource implements BufferedDataSourceListener, ServiceListener<BufferedDataSource>
{

    private final static Logger logger = LoggerFactory.getLogger ( ChangeCounterDataSource.class );

    // initialized by constructor

    private final ScheduledExecutorService scheduler;

    private final ObjectPoolTracker<BufferedDataSource> poolTracker;

    // initialized by update
    private String bufferedDataSourceId;

    private ChangeType type;

    private List<Variant> values;

    private ErrorHandling errorHandling;

    private SingleObjectPoolServiceTracker<BufferedDataSource> objectPoolTracker;

    private BufferedDataSource bufferedDataSource;

    public ChangeCounterDataSource ( final ScheduledExecutorService scheduler, ObjectPoolTracker<BufferedDataSource> poolTracker )
    {
        super ();
        this.scheduler = scheduler;
        this.poolTracker = poolTracker;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.scheduler;
    }

    public void update ( final Map<String, String> parameters )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.bufferedDataSourceId = cfg.getStringChecked ( BufferedDataSource.BUFFERED_DATA_SOURCE_ID, String.format ( "'%s' must be set", BufferedDataSource.BUFFERED_DATA_SOURCE_ID ) ); //$NON-NLS-1$
        this.type = cfg.getEnumChecked ( "type", ChangeType.class, "'type' must be set" );
        this.errorHandling = cfg.getEnum ( "onError", ErrorHandling.class, ErrorHandling.ERROR );
        this.values = toVariants ( cfg, "value" );

        this.objectPoolTracker = new SingleObjectPoolServiceTracker<BufferedDataSource> ( this.poolTracker, this.bufferedDataSourceId, this );
        this.objectPoolTracker.open ();
    }

    private void sendUpdate ( DataItemValueRangeState dataItemValueRangeState )
    {
        // if no value is given, every value update is considered as change
        if ( values.isEmpty () )
        {
            this.updateData ( new DataItemValue ( Variant.valueOf ( dataItemValueRangeState.getValues ().size () ), Collections.<String, Variant> emptyMap (), SubscriptionState.CONNECTED ) );
        }
        try
        {
            int numOfChanges = 0;
            switch ( type )
            {
                case DELTA:
                    numOfChanges = ChangeCounterEvaluator.handleDelta ( values, dataItemValueRangeState, errorHandling );
                    break;
                case SET:
                    numOfChanges = ChangeCounterEvaluator.handleSet ( values, dataItemValueRangeState, errorHandling );
                    break;
                case DIRECTION:
                    numOfChanges = ChangeCounterEvaluator.handleDirection ( values, dataItemValueRangeState, errorHandling );
                    break;
            }
            this.updateData ( new DataItemValue ( Variant.valueOf ( numOfChanges ), Collections.<String, Variant> emptyMap (), SubscriptionState.CONNECTED ) );
        }
        catch ( Exception e )
        {
            final Map<String, Variant> attr = new HashMap<String, Variant> ();
            attr.put ( "org.eclipse.scada.da.datasource.changecounter.error", Variant.valueOf ( true ) );
            this.updateData ( new DataItemValue ( Variant.NULL, attr, SubscriptionState.CONNECTED ) );
        }
    }

    @Override
    public void stateChanged ( final DataItemValueRange dataItemValueRange )
    {
        sendUpdate ( dataItemValueRange.getState () );
    }

    private List<Variant> toVariants ( ConfigurationDataHelper cfg, String name )
    {
        List<Variant> result = new ArrayList<Variant> ();
        Map<String, String> prefixed = cfg.getPrefixed ( name );
        for ( String v : prefixed.values () )
        {
            result.add ( VariantEditor.toVariant ( v ) );
        }
        return result;
    }

    public void dispose ()
    {
        if ( this.objectPoolTracker != null )
        {
            this.objectPoolTracker.close ();
            this.objectPoolTracker = null;
        }
        setBufferedDataSource ( null );
    }

    @Override
    public void serviceChange ( BufferedDataSource service, Dictionary<?, ?> properties )
    {
        setBufferedDataSource ( service );
    }

    private synchronized void setBufferedDataSource ( BufferedDataSource service )
    {
        if ( service == null && this.bufferedDataSource != null )
        {
            this.bufferedDataSource.removeListener ( this );
        }
        else
        {
            this.bufferedDataSource = service;
            this.bufferedDataSource.addListener ( this );
        }
    }
}
