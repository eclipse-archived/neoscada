/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.exec;

import java.util.concurrent.TimeUnit;

/**
 * A class that can be used to track the progress of an asynchronous execution
 * 
 * @author jens
 * @param <R>
 */
public class OperationResult<R>
{
    private OperationResultHandler<R> handler = null;

    private R result = null;

    private Exception exception = null;

    private boolean complete = false;

    public OperationResult ()
    {
        this ( null );
    }

    public OperationResult ( final OperationResultHandler<R> handler )
    {
        this.handler = handler;
    }

    public synchronized boolean isComplete ()
    {
        return this.complete;
    }

    public synchronized boolean isSuccess ()
    {
        return this.exception == null;
    }

    public synchronized Exception getException ()
    {
        return this.exception;
    }

    public synchronized R getResult ()
    {
        return this.result;
    }

    public synchronized R get ()
    {
        return getResult ();
    }

    public synchronized void notifySuccess ( final R result )
    {
        if ( this.complete )
        {
            return;
        }

        this.complete = true;
        this.result = result;
        this.exception = null;

        notifyAll ();

        if ( this.handler != null )
        {
            this.handler.success ( result );
        }
    }

    public synchronized void notifyFailure ( final Exception e )
    {
        if ( this.complete )
        {
            return;
        }

        this.complete = true;
        this.result = null;
        this.exception = e;

        notifyAll ();

        if ( this.handler != null )
        {
            this.handler.failure ( e );
        }
    }

    public synchronized void complete () throws InterruptedException
    {
        if ( this.complete )
        {
            return;
        }

        wait ();
    }

    public synchronized boolean complete ( final long timeout, final TimeUnit t ) throws InterruptedException
    {
        if ( this.complete )
        {
            return true;
        }

        wait ( t.toMillis ( timeout ) );

        return this.complete;
    }
}
