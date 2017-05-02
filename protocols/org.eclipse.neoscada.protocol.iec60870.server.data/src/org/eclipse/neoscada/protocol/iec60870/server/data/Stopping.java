/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * A class for tracking shutdown of a service
 * <p>
 * When a service gets called to stop it can return a {@link Stopping} instance
 * which can be used to identify the end of the stopping process. A standard
 * call to a stop method will initiate the shutdown process of this service.
 * However when the stop method returns it is not ensured that all resources are
 * already freed.
 * </p>
 * <p>
 * The {@link Stopping} interface allows to wait for the actual shutdown of all
 * resources while staying outside of service instances and its locks.
 * </p>
 * <p>
 * The {@link Stopping} interface can be compared to {@link Future} or
 * {@link CompletionStage}, although it is not that sophisticated and more
 * targeted to this specific task.
 * </p>
 */
public interface Stopping
{
    /**
     * Synchronously wait for the end of the process
     *
     * @throws Exception
     *             if anything goes wrong
     */
    public void await () throws Exception;

    /**
     * An empty stopping instance which does nothing.
     * <p>
     * This can be used if the service actually is stopped when the stop method
     * returns. It has a few optimizations over using a custom empty Stopping
     * instance.
     * </p>
     */
    public static final Stopping EMPTY = new Stopping () {

        @Override
        public void await () throws Exception
        {
        }

        @Override
        public Stopping andThen ( final Stopping other )
        {
            return other;
        }

        @Override
        public CompletableFuture<?> completion ()
        {
            return CompletableFuture.completedFuture ( null );
        }

        @Override
        public CompletableFuture<?> completion ( final Executor executor )
        {
            return CompletableFuture.completedFuture ( null );
        }

        @Override
        public void awaitAsync ( final Executor executor )
        {
        }

        @Override
        public void awaitAsync ()
        {
        }

        @Override
        public void awaitSeperately ()
        {
        }
    };

    /**
     * Return a new, combined instance of this and the other instance
     *
     * @param other
     *            the other instance to wait for as well
     * @return a new instance which waits for this and the other instance
     */
    public default Stopping andThen ( final Stopping other )
    {
        Objects.requireNonNull ( other );

        return new Stopping () {

            @Override
            public void await () throws Exception
            {
                Stopping.this.await ();
                other.await ();
            }
        };
    }

    /**
     * Execute the waiting code on a the {@link ForkJoinPool#commonPool()} and
     * wait for the result in this thread
     */
    public default void awaitAsync ()
    {
        completion ().join ();
    }

    /**
     * Execute the waiting code on the provided executor and wait for the result
     * in this thread
     *
     * @param executor
     *            the execute to run the {@link #await()} method in
     */
    public default void awaitAsync ( final Executor executor )
    {
        Objects.requireNonNull ( executor );

        completion ( executor ).join ();
    }

    /**
     * Execute the waiting code in a freshly created {@link ExecutorService},
     * wait for the result and shut down the pool
     */
    public default void awaitSeperately ()
    {
        final ExecutorService executor = Executors.newSingleThreadExecutor ();
        final CompletableFuture<?> future = completion ( executor );
        executor.shutdown ();
        future.join ();
    }

    /**
     * Wrap this instance in a {@link CompletableFuture} on the
     * {@link ForkJoinPool#commonPool()}
     *
     * @return a new {@link CompletableFuture}
     */
    public default CompletableFuture<?> completion ()
    {
        return CompletableFuture.runAsync ( () -> {
            try
            {
                await ();
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        } );
    }

    /**
     * Wrap this instance in a {@link CompletableFuture} on the
     * provided executor
     *
     * @param executor
     *            the executor to use
     * @return a new {@link CompletableFuture}
     */
    public default CompletableFuture<?> completion ( final Executor executor )
    {
        Objects.requireNonNull ( executor );

        return CompletableFuture.runAsync ( () -> {
            try
            {
                await ();
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        }, executor );
    }
}
