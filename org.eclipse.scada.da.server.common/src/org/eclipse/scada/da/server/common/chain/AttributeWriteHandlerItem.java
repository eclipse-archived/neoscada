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

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.utils.concurrent.FutureTask;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class AttributeWriteHandlerItem extends DataItemInputChained
{

    private volatile AttributeWriteHandler writeHandler;

    public AttributeWriteHandlerItem ( final DataItemInformation di, final AttributeWriteHandler writeHandler, final Executor executor )
    {
        super ( di, executor );
        this.writeHandler = writeHandler;
    }

    public AttributeWriteHandlerItem ( final String itemId, final AttributeWriteHandler writeHandler, final Executor executor )
    {
        super ( new DataItemInformationBase ( itemId ), executor );
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
    public void setWriteHandler ( final AttributeWriteHandler writeHandler )
    {
        this.writeHandler = writeHandler;
    }

    @Override
    protected WriteAttributeResults handleUnhandledAttributes ( final WriteAttributeResults writeAttributeResults, final Map<String, Variant> attributes )
    {
        final AttributeWriteHandler handler = this.writeHandler;

        WriteAttributeResults result = null;
        try
        {
            result = handler.handleWrite ( attributes );
            // remove handled attributes
            for ( final String attr : result.keySet () )
            {
                attributes.remove ( attr );
            }
            return super.handleUnhandledAttributes ( result, attributes );
        }
        catch ( final Exception e )
        {
            if ( result == null )
            {
                result = new WriteAttributeResults ();
            }

            for ( final String attr : attributes.keySet () )
            {
                result.put ( attr, new WriteAttributeResult ( e ) );
            }
            return result;
        }
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final FutureTask<WriteResult> task = new FutureTask<WriteResult> ( new Callable<WriteResult> () {

            @Override
            public WriteResult call () throws Exception
            {
                return processWriteValue ( value, operationParameters );
            }
        } );

        this.executor.execute ( task );

        return task;
    }

    protected WriteResult processWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        final AttributeWriteHandler handler = this.writeHandler;
        if ( handler == null )
        {
            return new WriteResult ( new IllegalStateException ( "No write handler set" ).fillInStackTrace () );
        }

        try
        {
            handler.handleWrite ( value );
        }
        catch ( final Exception e )
        {
            return new WriteResult ( e );
        }

        return new WriteResult ();
    }

}
