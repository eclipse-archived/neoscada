/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.server.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public abstract class AbstractBaseDataModel implements DataModel
{
    private final Set<DefaultSubscription> subscriptions = new HashSet<> ();

    private volatile int numberOfSubscriptions;

    protected final ListeningScheduledExecutorService executor;

    public AbstractBaseDataModel ( final String threadName )
    {
        this.executor = MoreExecutors.listeningDecorator ( Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( threadName, false, true ) ) );
    }

    @Override
    public synchronized Subscription subscribe ( final DataListener listener )
    {
        final DefaultSubscription subscription = new DefaultSubscription ( this, listener );
        this.subscriptions.add ( subscription );
        this.numberOfSubscriptions = this.subscriptions.size ();
        return subscription;
    }

    protected int getNumberOfSubscriptions ()
    {
        return this.numberOfSubscriptions;
    }

    protected synchronized ListenableFuture<Void> disposeSubscription ( final DefaultSubscription subscription )
    {
        this.subscriptions.remove ( subscription );
        this.numberOfSubscriptions = this.subscriptions.size ();

        if ( this.executor.isShutdown () )
        {
            // if we are already disposed
            return Futures.immediateFuture ( null );
        }

        // the completion will come from the executor, so the completion has to wait in line
        // with possible remaining updated
        return this.executor.submit ( new Callable<Void> () {
            @Override
            public Void call () throws Exception
            {
                // this is only a marker
                return null;
            }
        } );
    }

    protected synchronized void notifyChangeBoolean ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    sub.notifyChangeBoolean ( asduAddress, startAddress, values );
                }
            } );
        }
    }

    protected synchronized void notifyChangeFloat ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    sub.notifyChangeFloat ( asduAddress, startAddress, values );
                }
            } );
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.executor.shutdown ();
        this.subscriptions.clear ();
        this.numberOfSubscriptions = 0;
    }

    public void disposeAndWait () throws InterruptedException
    {
        dispose ();
        this.executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
    }

}