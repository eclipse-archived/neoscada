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
package org.eclipse.scada.core.client.ngp;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenCallbacksManager
{

    private final static Logger logger = LoggerFactory.getLogger ( OpenCallbacksManager.class );

    private static final Object STAT_OPEN_CALLBACK_FUTURES = new Object ();

    private final StatisticsImpl statistics;

    private final ScheduledExecutorService executor;

    private final Set<NotifyFuture<Callback[]>> openFutures = new HashSet<NotifyFuture<Callback[]>> ();

    private final Object lock;

    public OpenCallbacksManager ( final Object lock, final StatisticsImpl statistics, final ScheduledExecutorService executor )
    {
        this.lock = lock;
        this.statistics = statistics;
        this.executor = executor;

        statistics.setLabel ( STAT_OPEN_CALLBACK_FUTURES, "Active callbacks" );
    }

    public void disconnected ()
    {
        logger.debug ( "Disconnected" );

        for ( final NotifyFuture<Callback[]> future : this.openFutures )
        {
            future.cancel ( true );
        }
        this.openFutures.clear ();
        this.statistics.setCurrentValue ( STAT_OPEN_CALLBACK_FUTURES, 0 );
    }

    public NotifyFuture<Callback[]> processCallbacks ( final CallbackHandler callbackHandler, final Callback[] callbacks, final Long timeout )
    {
        logger.debug ( "Process callbacks: {}", (Object)callbacks );

        final NotifyFuture<Callback[]> future = Callbacks.callback ( callbackHandler, callbacks );

        logger.debug ( "Future opened: {}", (Object)callbacks );

        if ( timeout != null && timeout > 0 && !future.isDone () ) // check also for isDone since it might be an instant future
        {
            this.executor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    if ( !future.isCancelled () )
                    {
                        future.cancel ( true );
                    }
                }
            }, timeout, TimeUnit.MILLISECONDS );
        }

        // add before adding the listener since it might be removed in the next call if the future is instant
        this.openFutures.add ( future );

        future.addListener ( new Runnable () {

            @Override
            public void run ()
            {
                closeFuture ( future );
            }
        } );

        this.statistics.setCurrentValue ( STAT_OPEN_CALLBACK_FUTURES, this.openFutures.size () );

        return future;
    }

    protected void closeFuture ( final NotifyFuture<Callback[]> future )
    {
        logger.debug ( "Future closed: {}", future );

        synchronized ( this.lock )
        {
            this.openFutures.remove ( future );
            this.statistics.setCurrentValue ( STAT_OPEN_CALLBACK_FUTURES, this.openFutures.size () );
        }
    }
}
