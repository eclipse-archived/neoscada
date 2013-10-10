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
package org.eclipse.scada.da.server.common.chain;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class WriteHandlerItem extends DataItemInputOutputChained
{

    private volatile WriteHandler writeHandler;

    public WriteHandlerItem ( final DataItemInformation di, final WriteHandler writeHandler, final Executor executor )
    {
        super ( di, executor );
        this.writeHandler = writeHandler;
    }

    public WriteHandlerItem ( final String itemId, final WriteHandler writeHandler, final Executor executor )
    {
        super ( itemId, executor );
        this.writeHandler = writeHandler;
    }

    /**
     * Change the write handler
     * <p>
     * The write handler will not be called for the last written value only for
     * the next one.
     * 
     * @param writeHandler
     *            the new write handler
     */
    public void setWriteHandler ( final WriteHandler writeHandler )
    {
        this.writeHandler = writeHandler;
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        final WriteHandler writeHandler = this.writeHandler;

        // if we don't have a write handler this is not allowed
        if ( writeHandler == null )
        {
            return new InstantErrorFuture<WriteResult> ( new InvalidOperationException ().fillInStackTrace () );
        }

        final FutureTask<WriteResult> task = new FutureTask<WriteResult> ( new Callable<WriteResult> () {

            @Override
            public WriteResult call () throws Exception
            {
                writeHandler.handleWrite ( value, operationParameters );
                return new WriteResult ();
            }
        } );

        this.executor.execute ( task );

        return task;
    }
}
