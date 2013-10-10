/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.datasource.ds;

import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.base.AbstractDataSource;
import org.eclipse.scada.ds.DataListener;
import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.DataNodeTracker;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.osgi.framework.BundleContext;

public class DataStoreDataSource extends AbstractDataSource implements DataListener
{
    private final Executor executor;

    private boolean disposed;

    private final DataNodeTracker dataNodeTracker;

    private final String id;

    private String nodeId;

    private final BundleContext context;

    public DataStoreDataSource ( final BundleContext context, final String id, final Executor executor, final DataNodeTracker dataNodeTracker )
    {
        this.context = context;
        this.id = id;
        this.executor = executor;
        this.dataNodeTracker = dataNodeTracker;

        setError ( null );
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        return new InstantErrorFuture<WriteAttributeResults> ( new InvalidOperationException ().fillInStackTrace () );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        if ( this.dataNodeTracker.write ( new DataNode ( getNodeId (), value ) ) )
        {
            return new InstantFuture<WriteResult> ( WriteResult.OK );
        }
        else
        {
            return new InstantErrorFuture<WriteResult> ( new OperationException ( "Unable to write to data store! Data store missing!" ).fillInStackTrace () );
        }
    }

    private String getNodeId ()
    {
        return this.nodeId;
    }

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        if ( this.disposed )
        {
            return;
        }

        if ( this.nodeId != null )
        {
            this.dataNodeTracker.removeListener ( this.nodeId, this );
        }

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.nodeId = cfg.getString ( "node.id", "org.eclipse.scada.da.datasource.ds/" + this.id );

        this.dataNodeTracker.addListener ( this.nodeId, this );
    }

    public synchronized void dispose ()
    {
        this.disposed = true;
        if ( this.nodeId != null )
        {
            this.dataNodeTracker.removeListener ( this.nodeId, this );
            this.nodeId = null;
        }
    }

    @Override
    public void nodeChanged ( final DataNode node )
    {
        logger.debug ( "Node data changed: {}", node );
        try
        {
            if ( node != null )
            {
                final Variant variant = (Variant)node.getDataAsObject ( this.context.getBundle () );
                final Builder builder = new Builder ();
                builder.setSubscriptionState ( SubscriptionState.CONNECTED );
                builder.setValue ( variant );
                updateData ( builder.build () );
            }
            else
            {
                final Builder builder = new Builder ();
                builder.setSubscriptionState ( SubscriptionState.CONNECTED );
                builder.setValue ( Variant.NULL );
                updateData ( builder.build () );
            }
        }
        catch ( final Throwable e )
        {
            setError ( e );
        }
    }

    private void setError ( final Throwable e )
    {
        logger.warn ( "Failed to read data", e );

        final Builder builder = new Builder ();
        builder.setSubscriptionState ( SubscriptionState.CONNECTED );
        builder.setValue ( Variant.NULL );
        builder.setAttribute ( "node.error", Variant.TRUE );

        if ( e != null )
        {
            builder.setAttribute ( "node.error.message", Variant.valueOf ( e.getMessage () ) );
        }

        updateData ( builder.build () );
    }
}
