/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ngp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.data.Request;
import org.eclipse.scada.core.data.RequestMessage;
import org.eclipse.scada.core.data.ResponseMessage;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.utils.concurrent.ExecutorFuture;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class ResponseManager
{

    private static final Object STATS_OPEN_REQUESTS = new Object ();

    private final Map<Long, ExecutorFuture<ResponseMessage>> requestMap = new HashMap<Long, ExecutorFuture<ResponseMessage>> ();

    private final StatisticsImpl statistics;

    private boolean connected;

    private final MessageSender messageSender;

    private final Executor executor;

    private final AtomicLong sequenceNumber = new AtomicLong ();

    public ResponseManager ( final StatisticsImpl statistics, final MessageSender messageSender, final Executor executor )
    {
        this.statistics = statistics;
        this.messageSender = messageSender;
        this.executor = executor;

        this.statistics.setLabel ( STATS_OPEN_REQUESTS, "Open requests" ); //$NON-NLS-1$
    }

    public void handleResponse ( final ResponseMessage message )
    {
        final ExecutorFuture<ResponseMessage> request = this.requestMap.remove ( message.getResponse ().getRequest ().getRequestId () );

        if ( request != null )
        {
            this.statistics.setCurrentValue ( STATS_OPEN_REQUESTS, this.requestMap.size () ); // update info
            request.asyncSetResult ( message );
        }
    }

    public void connected ()
    {
        this.connected = true;
    }

    public void disconnected ()
    {
        this.connected = false;
        // all operations got cancelled
        for ( final ExecutorFuture<ResponseMessage> request : this.requestMap.values () )
        {
            request.asyncSetError ( new OperationException ( "Operation was cancelled" ) );
        }
        this.requestMap.clear ();
    }

    public NotifyFuture<ResponseMessage> sendRequestMessage ( final RequestMessage requestMessage )
    {
        final Request request = requestMessage.getRequest ();
        if ( request == null )
        {
            return null;
        }

        if ( !this.connected )
        {
            return new InstantErrorFuture<ResponseMessage> ( new IllegalStateException ( "Connection is not conected" ) );
        }

        this.messageSender.sendMessage ( requestMessage );

        final long requestId = request.getRequestId ();
        final ExecutorFuture<ResponseMessage> result = new ExecutorFuture<ResponseMessage> ( this.executor );
        this.requestMap.put ( requestId, result );
        this.statistics.setCurrentValue ( STATS_OPEN_REQUESTS, this.requestMap.size () ); // update info

        return result;
    }

    public Request nextRequest ()
    {
        return new Request ( this.sequenceNumber.incrementAndGet () );
    }
}
