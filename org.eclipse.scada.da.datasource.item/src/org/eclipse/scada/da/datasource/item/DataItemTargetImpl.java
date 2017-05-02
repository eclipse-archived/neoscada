/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - implement "write-only" mode
 *******************************************************************************/
package org.eclipse.scada.da.datasource.item;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.datasource.DataSourceListener;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker;
import org.eclipse.scada.da.datasource.SingleDataSourceTracker.ServiceListener;
import org.eclipse.scada.da.server.common.DataItemBase;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataItemTargetImpl extends DataItemBase implements DataSourceListener
{
    private final static Logger logger = LoggerFactory.getLogger ( DataItemTargetImpl.class );

    private DataItemValue currentValue = DataItemValue.DISCONNECTED;

    private final SingleDataSourceTracker tracker;

    private DataSource dataSource;

    /*
     * Information if this is a <q>write-only</q> item
     */
    private final boolean writeOnly;

    public DataItemTargetImpl ( final ObjectPoolTracker<DataSource> poolTracker, final DataItemInformation information, final String dataSourceId ) throws InvalidSyntaxException
    {
        super ( information );

        this.writeOnly = information.getIODirection ().size () == 1 && information.getIODirection ().contains ( IODirection.OUTPUT );

        this.tracker = new SingleDataSourceTracker ( poolTracker, dataSourceId, new ServiceListener () {

            @Override
            public void dataSourceChanged ( final DataSource dataSource )
            {
                DataItemTargetImpl.this.setDataSource ( dataSource );
            }
        } );
        this.tracker.open ();
    }

    @Override
    protected synchronized Map<String, Variant> getCacheAttributes ()
    {
        if ( this.writeOnly )
        {
            return Collections.emptyMap ();
        }

        final DataItemValue value = this.currentValue;

        if ( value != null )
        {
            return value.getAttributes ();
        }
        else
        {
            return null;
        }
    }

    @Override
    protected synchronized Variant getCacheValue ()
    {
        if ( this.writeOnly )
        {
            return Variant.NULL;
        }

        final DataItemValue value = this.currentValue;

        if ( value != null )
        {
            return value.getValue ();
        }
        else
        {
            return null;
        }
    }

    protected synchronized void setDataSource ( final DataSource dataSource )
    {
        logger.info ( "Setting datasource: {}", dataSource );
        disconnectDatasource ();
        connectDataSource ( dataSource );
    }

    private synchronized void connectDataSource ( final DataSource dataSource )
    {
        this.dataSource = dataSource;
        if ( this.dataSource != null )
        {
            if ( !this.writeOnly )
            {
                this.dataSource.addListener ( this );
            }
            else
            {
                stateChanged ( null );
            }
        }

    }

    private synchronized void disconnectDatasource ()
    {
        if ( this.dataSource != null && !this.writeOnly )
        {
            this.dataSource.removeListener ( this );
            this.dataSource = null;

            stateChanged ( null );
        }
    }

    @Override
    public synchronized Map<String, Variant> getAttributes ()
    {
        if ( !this.writeOnly )
        {
            return Collections.unmodifiableMap ( this.currentValue.getAttributes () );
        }
        else
        {
            return Collections.emptyMap ();
        }
    }

    @Override
    public synchronized NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        if ( !this.writeOnly )
        {
            return new InstantFuture<> ( this.currentValue.getValue () );
        }
        else
        {
            return new InstantFuture<Variant> ( Variant.NULL );
        }
    }

    @Override
    public synchronized NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        if ( this.dataSource != null )
        {
            return this.dataSource.startWriteAttributes ( attributes, operationParameters );
        }
        else
        {
            return new InstantErrorFuture<> ( new OperationException ( "Disconnected data source" ) );
        }
    }

    @Override
    public synchronized NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        if ( this.dataSource != null )
        {
            return this.dataSource.startWriteValue ( value, operationParameters );
        }
        else
        {
            return new InstantErrorFuture<> ( new OperationException ( "Disconnected data source" ) );
        }
    }

    public synchronized void dispose ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
        }
    }

    @Override
    public synchronized void stateChanged ( final DataItemValue value )
    {
        logger.debug ( "State changed: {}", value );

        if ( value == null )
        {
            this.currentValue = value;
            notifyData ( Variant.NULL, Collections.<String, Variant> emptyMap (), true );
        }
        else
        {
            if ( this.currentValue == null )
            {
                this.currentValue = DataItemValue.DISCONNECTED;
            }

            final Map<String, Variant> target = new HashMap<> ( this.currentValue.getAttributes () );
            final Map<String, Variant> diff = new HashMap<> ();

            AttributesHelper.set ( target, value.getAttributes (), diff );

            final Variant oldValue = Variant.valueOf ( this.currentValue.getValue () );
            final Variant newValue = Variant.valueOf ( value.getValue () );

            this.currentValue = value;

            if ( !diff.isEmpty () || !oldValue.equals ( newValue ) )
            {
                notifyData ( value.getValue (), diff );
            }

        }
    }
}
