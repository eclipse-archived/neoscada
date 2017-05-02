/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.delta;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.base.AbstractDataSourceHandler;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeltaDataSource extends AbstractDataSourceHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( DeltaDataSource.class );

    private final Executor executor;

    private Double lastValue;

    public DeltaDataSource ( final Executor executor, final ObjectPoolTracker<DataSource> tracker )
    {
        super ( tracker );
        this.executor = executor;
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteAttributeResults> ( new OperationException ( "Operation not supported" ) );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteResult> ( new OperationException ( "Operation not supported" ) );
    }

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        setDataSource ( cfg.getStringChecked ( "datasource.id", "'datasource.id' must be set" ) ); //$NON-NLS-1$
    }

    @Override
    protected void stateChanged ( final DataItemValue value )
    {
        logger.trace ( "Value change - lastValue: {}, change: {}", this.lastValue, value );

        final Double newValue = value.getValue ().asDouble ( null );

        if ( this.lastValue == null )
        {
            this.lastValue = newValue;
            updateNewValue ( null );
        }
        else
        {
            if ( newValue != null )
            {
                final double delta = newValue - this.lastValue;
                updateNewValue ( delta );
            }
            else
            {
                this.lastValue = null;
                updateNewValue ( null );
            }
            this.lastValue = newValue;
        }
    }

    private void updateNewValue ( final Double delta )
    {
        final Builder builder = new DataItemValue.Builder ();
        builder.setValue ( Variant.valueOf ( delta ) );
        if ( delta == null )
        {
            builder.setAttribute ( "value.error", Variant.TRUE );
            updateData ( builder.build () );
        }
        else
        {
            updateData ( builder.build () );
            builder.setValue ( Variant.valueOf ( 0 ) );
            updateData ( builder.build () );
        }
    }
}
