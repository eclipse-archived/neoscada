/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExportedExecutorService implements ExecutorService
{
    private final ExecutorService executor;

    private final ExecutorServiceExporterImpl executorExporter;

    public ExportedExecutorService ( final String name, final int corePoolSize, final int maximumPoolSize, final long keepAliveTime, final TimeUnit unit )
    {
        this.executor = new ThreadPoolExecutor ( corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<Runnable> (), new NamedThreadFactory ( name ) );
        this.executorExporter = new ExecutorServiceExporterImpl ( this.executor, name );
    }

    @Override
    public void execute ( final Runnable command )
    {
        this.executor.execute ( command );
    }

    @Override
    public void shutdown ()
    {
        this.executorExporter.dispose ();
        this.executor.shutdown ();
    }

    @Override
    protected void finalize () throws Throwable
    {
        shutdown ();
        super.finalize ();
    }

    @Override
    public List<Runnable> shutdownNow ()
    {
        return this.executor.shutdownNow ();
    }

    @Override
    public boolean isShutdown ()
    {
        return this.executor.isShutdown ();
    }

    @Override
    public boolean isTerminated ()
    {
        return this.executor.isTerminated ();
    }

    @Override
    public boolean awaitTermination ( final long timeout, final TimeUnit unit ) throws InterruptedException
    {
        return this.executor.awaitTermination ( timeout, unit );
    }

    @Override
    public <T> Future<T> submit ( final Callable<T> task )
    {
        return this.executor.submit ( task );
    }

    @Override
    public <T> Future<T> submit ( final Runnable task, final T result )
    {
        return this.executor.submit ( task, result );
    }

    @Override
    public Future<?> submit ( final Runnable task )
    {
        return this.executor.submit ( task );
    }

    @Override
    public <T> List<Future<T>> invokeAll ( final Collection<? extends Callable<T>> tasks ) throws InterruptedException
    {
        return this.executor.invokeAll ( tasks );
    }

    @Override
    public <T> List<Future<T>> invokeAll ( final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit ) throws InterruptedException
    {
        return this.executor.invokeAll ( tasks, timeout, unit );
    }

    @Override
    public <T> T invokeAny ( final Collection<? extends Callable<T>> tasks ) throws InterruptedException, ExecutionException
    {
        return this.executor.invokeAny ( tasks );
    }

    @Override
    public <T> T invokeAny ( final Collection<? extends Callable<T>> tasks, final long timeout, final TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException
    {
        return this.executor.invokeAny ( tasks, timeout, unit );
    }
}
