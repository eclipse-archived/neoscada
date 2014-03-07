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
package org.eclipse.scada.core.subscription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * Listen to the active subscriptions
 * <p>
 * All events are emitted from the domain of the executor
 * </p>
 * 
 * @param <T>
 *            The topic type
 */
public class ListenableSubscriptionManager<T> extends SubscriptionManager<T>
{
    private final Executor executor;

    private final Set<SubscriptionManagerListener<T>> listeners = new HashSet<> ();

    private final Set<T> cache = new HashSet<> ();

    public ListenableSubscriptionManager ( final Executor executor )
    {
        this.executor = executor;
    }

    public ListenableSubscriptionManager ( final Executor executor, final SubscriptionValidator<T> validator )
    {
        super ( validator );
        this.executor = executor;
    }

    @Override
    protected void topicSubscriptionAdded ( final T topic )
    {
        super.topicSubscriptionAdded ( topic );

        if ( this.cache.add ( topic ) )
        {
            final List<SubscriptionManagerListener<T>> listeners = new ArrayList<> ( this.listeners );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    fireAdded ( listeners, Collections.singleton ( topic ) );
                }
            } );
        }
    }

    @Override
    protected void topicSubscriptionRemoved ( final T topic )
    {
        super.topicSubscriptionRemoved ( topic );

        if ( this.cache.remove ( topic ) )
        {
            final List<SubscriptionManagerListener<T>> listeners = new ArrayList<> ( this.listeners );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    fireRemoved ( listeners, Collections.singleton ( topic ) );
                }
            } );
        }
    }

    /**
     * Add a listener to the manager
     * <p>
     * Adding the listener to the manager will trigger an initial call to
     * {@link SubscriptionManagerListener#subscriptionsAdded(Set)} with the
     * currently open topics.
     * </p>
     * 
     * @param listener
     *            the listener to add
     */
    public synchronized void addManagerListener ( final SubscriptionManagerListener<T> listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            final List<SubscriptionManagerListener<T>> listeners = new ArrayList<> ( this.listeners );
            final Set<T> cache = new HashSet<> ( this.cache );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    fireAdded ( listeners, cache );
                }
            } );
        }
    }

    public synchronized void removeManagerListener ( final SubscriptionManagerListener<T> listener )
    {
        this.listeners.remove ( listener );
    }

    protected void fireAdded ( final List<SubscriptionManagerListener<T>> listeners, final Set<T> topic )
    {
        for ( final SubscriptionManagerListener<T> listener : listeners )
        {
            try
            {
                listener.subscriptionsAdded ( topic );
            }
            catch ( final Exception e )
            {
            }
        }
    }

    protected void fireRemoved ( final List<SubscriptionManagerListener<T>> listeners, final Set<T> topic )
    {
        for ( final SubscriptionManagerListener<T> listener : listeners )
        {
            try
            {
                listener.subscriptionsRemoved ( topic );
            }
            catch ( final Exception e )
            {
            }
        }
    }

    public synchronized Set<T> getAllSubscribedTopics ()
    {
        return new HashSet<> ( this.cache );
    }

    public synchronized void dispose ()
    {
        this.cache.clear ();
        this.listeners.clear ();
    }
}
