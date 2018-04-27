/*******************************************************************************
 * Copyright (c) 2014, 2017 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public abstract class AbstractBaseDataModel implements DataModel
{
    private final Set<DefaultSubscription> subscriptions = new HashSet<> ();

    private final String threadName;

    private volatile int numberOfSubscriptions;

    protected ListeningScheduledExecutorService executor;

    public AbstractBaseDataModel ( final String threadName )
    {
        this.threadName = threadName;
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
        return this.executor.submit ( () -> null );
    }

    protected synchronized void notifyChangeBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeBoolean ( cause, asduAddress, startAddress, values ) );
        }
    }

    protected synchronized void notifyChangeBoolean ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Boolean>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeBoolean ( cause, asduAddress, values ) );
        }
    }

    protected synchronized void notifyChangeFloat ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeFloat ( cause, asduAddress, startAddress, values ) );
        }
    }

    protected synchronized void notifyChangeFloat ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Float>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeFloat ( cause, asduAddress, values ) );
        }
    }

    protected synchronized void notifyChangeShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Short>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeShort ( cause, asduAddress, startAddress, values ) );
        }
    }

    protected synchronized void notifyChangeShort ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final List<InformationEntry<Short>> values )
    {
        for ( final DefaultSubscription sub : this.subscriptions )
        {
            this.executor.execute ( () -> sub.notifyChangeShort ( cause, asduAddress, values ) );
        }
    }

    @Override
    public synchronized void start ()
    {
        if ( this.executor != null )
        {
            // double start
            return;
        }

        this.executor = MoreExecutors.listeningDecorator ( Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( this.threadName, false, true ) ) );
    }

    @Override
    public synchronized Stopping stop ()
    {
        final ExecutorService executor = this.executor;

        if ( executor == null )
        {
            return Stopping.EMPTY;
        }

        this.executor = null;
        this.subscriptions.clear ();
        this.numberOfSubscriptions = 0;

        executor.shutdown ();

        return new Stopping () {

            @Override
            public void await () throws InterruptedException
            {
                executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
            }
        };
    }
}
