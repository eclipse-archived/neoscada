/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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

public class ChangeCounterDataSource extends AbstractInputDataSource implements BufferedDataSourceListener, ServiceListener<BufferedDataSource>
{
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

    public ChangeCounterDataSource ( final ScheduledExecutorService scheduler, final ObjectPoolTracker<BufferedDataSource> poolTracker )
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

    private void sendUpdate ( final DataItemValueRangeState dataItemValueRangeState )
    {
        // if no value is given, every value update is considered as change
        if ( this.values.isEmpty () )
        {
            updateData ( new DataItemValue ( Variant.valueOf ( dataItemValueRangeState.getValues ().size () ), Collections.<String, Variant> emptyMap (), SubscriptionState.CONNECTED ) );
        }
        try
        {
            int numOfChanges = 0;
            switch ( this.type )
            {
                case DELTA:
                    numOfChanges = ChangeCounterEvaluator.handleDelta ( this.values, dataItemValueRangeState, this.errorHandling );
                    break;
                case SET:
                    numOfChanges = ChangeCounterEvaluator.handleSet ( this.values, dataItemValueRangeState, this.errorHandling );
                    break;
                case DIRECTION:
                    numOfChanges = ChangeCounterEvaluator.handleDirection ( this.values, dataItemValueRangeState, this.errorHandling );
                    break;
            }
            updateData ( new DataItemValue ( Variant.valueOf ( numOfChanges ), Collections.<String, Variant> emptyMap (), SubscriptionState.CONNECTED ) );
        }
        catch ( final Exception e )
        {
            final Map<String, Variant> attr = new HashMap<String, Variant> ();
            attr.put ( "org.eclipse.scada.da.datasource.changecounter.error", Variant.valueOf ( true ) );
            updateData ( new DataItemValue ( Variant.NULL, attr, SubscriptionState.CONNECTED ) );
        }
    }

    @Override
    public void stateChanged ( final DataItemValueRange dataItemValueRange )
    {
        sendUpdate ( dataItemValueRange.getState () );
    }

    private List<Variant> toVariants ( final ConfigurationDataHelper cfg, final String name )
    {
        final List<Variant> result = new ArrayList<Variant> ();
        final Map<String, String> prefixed = cfg.getPrefixed ( name );
        for ( final String v : prefixed.values () )
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
    public void serviceChange ( final BufferedDataSource service, final Dictionary<?, ?> properties )
    {
        setBufferedDataSource ( service );
    }

    private synchronized void setBufferedDataSource ( final BufferedDataSource service )
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
