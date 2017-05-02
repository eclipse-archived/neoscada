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
package org.eclipse.scada.da.datasource.memory;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.datasource.base.AbstractDataSource;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.da.server.common.WriteAttributesHelper;

public class MemoryDataSource extends AbstractDataSource
{
    private final Executor executor;

    private final DataItemValue.Builder builder = new Builder ();

    private boolean disposed;

    public MemoryDataSource ( final Executor executor )
    {
        this.executor = executor;

        this.builder.setSubscriptionState ( SubscriptionState.CONNECTED );
        update ();
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executor;
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final FutureTask<WriteAttributeResults> task = new FutureTask<WriteAttributeResults> ( new Callable<WriteAttributeResults> () {

            @Override
            public WriteAttributeResults call () throws Exception
            {
                return MemoryDataSource.this.setAttributes ( attributes );
            }
        } );

        this.executor.execute ( task );
        return task;
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final FutureTask<WriteResult> task = new FutureTask<WriteResult> ( new Callable<WriteResult> () {

            @Override
            public WriteResult call () throws Exception
            {
                return MemoryDataSource.this.setValue ( value );
            }
        } );

        this.executor.execute ( task );
        return task;
    }

    protected synchronized WriteResult setValue ( final Variant value )
    {
        if ( this.disposed )
        {
            return new WriteResult ( new OperationException ( "Disposed" ).fillInStackTrace () );
        }

        this.builder.setValue ( value );

        this.builder.setTimestamp ( Calendar.getInstance () );
        update ();

        return new WriteResult ();
    }

    protected synchronized WriteAttributeResults setAttributes ( final Map<String, Variant> attributes )
    {
        if ( this.disposed )
        {
            return WriteAttributesHelper.errorUnhandled ( null, attributes );
        }

        final WriteAttributeResults results = new WriteAttributeResults ();

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            results.put ( entry.getKey (), WriteAttributeResult.OK );

            if ( entry.getValue () == null )
            {
                this.builder.getAttributes ().remove ( entry.getKey () );
            }
            else
            {
                this.builder.getAttributes ().put ( entry.getKey (), entry.getValue () );
            }
        }

        this.builder.setTimestamp ( Calendar.getInstance () );
        update ();

        return results;
    }

    protected void update ()
    {
        updateData ( this.builder.build () );
    }

    public void update ( final Map<String, String> parameters ) throws Exception
    {
    }

    public synchronized void dispose ()
    {
        this.disposed = true;
    }
}
