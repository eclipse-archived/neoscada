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
package org.eclipse.scada.utils.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.scada.utils.concurrent.internal.FutureTaskNotifier;

public abstract class AbstractFuture<T> implements NotifyFuture<T>
{
    private final FutureTaskNotifier<T> notifier;

    private volatile Throwable error;

    private volatile T result;

    private enum State
    {
        WAITING,
        COMPLETE,
        CANCELED
    };

    private volatile State state = State.WAITING;

    private final Semaphore lock;

    private final Object setLock;

    public AbstractFuture ()
    {
        this.notifier = new FutureTaskNotifier<T> ( this );
        this.lock = new Semaphore ( -1 );
        this.setLock = new Object ();
    }

    @Override
    public void addListener ( final FutureListener<T> listener )
    {
        this.notifier.addListener ( listener );
    }

    @Override
    public void addListener ( final Runnable listener )
    {
        this.notifier.addListener ( listener );
    }

    @Override
    public void removeListener ( final FutureListener<T> listener )
    {
        this.notifier.removeListener ( listener );
    }

    @Override
    public void removeListener ( final Runnable listener )
    {
        this.notifier.removeListener ( listener );
    }

    protected void setResult ( final T result )
    {
        synchronized ( this.setLock )
        {
            if ( isDone () )
            {
                return;
            }
            this.result = result;
            this.state = State.COMPLETE;

            // release the wait lock
            this.lock.release ( 2 );
        }

        this.notifier.done ();
    }

    protected void setError ( final Throwable error )
    {
        synchronized ( this.setLock )
        {
            if ( isDone () )
            {
                return;
            }
            this.error = error;
            this.state = State.COMPLETE;

            // release the wait lock
            this.lock.release ( 2 );
        }

        this.notifier.done ();
    }

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        synchronized ( this.setLock )
        {
            if ( isDone () )
            {
                return false;
            }
            this.state = State.CANCELED;

            // release the wait lock
            this.lock.release ( 2 );
        }

        this.notifier.done ();

        return true;
    }

    @Override
    public T get () throws InterruptedException, ExecutionException
    {
        this.lock.acquire ( 0 );
        return fetchResult ();
    }

    protected T fetchResult () throws ExecutionException
    {
        if ( isCancelled () )
        {
            throw new CancellationException ();
        }
        if ( this.error != null )
        {
            throw new ExecutionException ( this.error );
        }

        return this.result;
    }

    @Override
    public T get ( final long timeout, final TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException
    {
        if ( !this.lock.tryAcquire ( 0, timeout, unit ) )
        {
            throw new TimeoutException ();
        }
        return fetchResult ();
    }

    @Override
    public boolean isCancelled ()
    {
        return this.state == State.CANCELED;
    }

    @Override
    public boolean isDone ()
    {
        final State state = this.state;
        return state == State.CANCELED || state == State.COMPLETE;
    }
}
