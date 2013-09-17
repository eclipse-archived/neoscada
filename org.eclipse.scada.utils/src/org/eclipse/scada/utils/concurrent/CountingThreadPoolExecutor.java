/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountingThreadPoolExecutor extends ThreadPoolExecutor
{

    private final static Logger logger = LoggerFactory.getLogger ( CountingThreadPoolExecutor.class );

    public static interface Listener
    {
        public void countChanged ( int count );
    }

    private final Set<Listener> listeners = new CopyOnWriteArraySet<CountingThreadPoolExecutor.Listener> ();

    public CountingThreadPoolExecutor ( final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final RejectedExecutionHandler handler )
    {
        super ( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler );
    }

    public CountingThreadPoolExecutor ( final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final ThreadFactory threadFactory, final RejectedExecutionHandler handler )
    {
        super ( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler );
    }

    public CountingThreadPoolExecutor ( final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final ThreadFactory threadFactory )
    {
        super ( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory );
    }

    public CountingThreadPoolExecutor ( final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit, final BlockingQueue<Runnable> workQueue )
    {
        super ( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue );
    }

    public void addListener ( final Listener listener )
    {
        this.listeners.add ( listener );
    }

    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    protected void fireCountChanged ( final int count )
    {
        for ( final Listener listener : this.listeners )
        {
            try
            {
                listener.countChanged ( count );
            }
            catch ( final Exception e )
            {
                logger.info ( "Failed to fireCountChanged", e );
            }
        }
    }

    protected void updateCount ()
    {
        fireCountChanged ( getQueue ().size () );
    }

    @Override
    protected void afterExecute ( final Runnable r, final Throwable t )
    {
        super.afterExecute ( r, t );
        updateCount ();
    }

    @Override
    public void shutdown ()
    {
        super.shutdown ();
        updateCount ();
    }

    @Override
    public List<Runnable> shutdownNow ()
    {
        final List<Runnable> result = super.shutdownNow ();
        updateCount ();
        return result;
    }

    @Override
    public boolean remove ( final Runnable task )
    {
        final boolean result = super.remove ( task );
        updateCount ();
        return result;
    }

    @Override
    public Future<?> submit ( final Runnable task )
    {
        final Future<?> result = super.submit ( task );
        updateCount ();
        return result;
    }

    @Override
    public <T> Future<T> submit ( final Runnable task, final T result )
    {
        final Future<T> resultValue = super.submit ( task, result );
        updateCount ();
        return resultValue;
    }

    @Override
    public <T> Future<T> submit ( final Callable<T> task )
    {
        final Future<T> result = super.submit ( task );
        updateCount ();
        return result;
    }

    @Override
    public <T> T invokeAny ( final Collection<? extends Callable<T>> tasks ) throws InterruptedException, ExecutionException
    {
        final T result = super.invokeAny ( tasks );
        updateCount ();
        return result;
    }

    @Override
    public <T> T invokeAny ( final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException
    {
        final T result = super.invokeAny ( tasks, timeout, unit );
        updateCount ();
        return result;
    }

    @Override
    public <T> List<Future<T>> invokeAll ( final Collection<? extends Callable<T>> tasks ) throws InterruptedException
    {
        final List<Future<T>> result = super.invokeAll ( tasks );
        updateCount ();
        return result;
    }

    @Override
    public <T> List<Future<T>> invokeAll ( final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit ) throws InterruptedException
    {
        final List<Future<T>> result = super.invokeAll ( tasks, timeout, unit );
        updateCount ();
        return result;
    }

    @Override
    public void execute ( final Runnable command )
    {
        super.execute ( command );
        updateCount ();
    }
}
