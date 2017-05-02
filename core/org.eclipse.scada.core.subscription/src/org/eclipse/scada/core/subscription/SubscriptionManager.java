/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - change interface
 *******************************************************************************/
package org.eclipse.scada.core.subscription;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Manage subscriptions.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 * @param T
 *            the type of the topic
 */
public class SubscriptionManager<T>
{
    private final Map<T, Subscription<T>> subscriptions = new HashMap<T, Subscription<T>> ();

    private final SubscriptionValidator<T> validator;

    public SubscriptionManager ( final SubscriptionValidator<T> validator )
    {
        this.validator = validator;
    }

    public SubscriptionManager ()
    {
        this.validator = null;
    }

    /**
     * Unsubscribe from all subscriptions that the listener has subscribed to
     * 
     * @param listener
     *            the listener to unsubscribe
     */
    public synchronized void unsubscribeAll ( final SubscriptionListener<T> listener )
    {
        for ( final Iterator<Map.Entry<T, Subscription<T>>> i = this.subscriptions.entrySet ().iterator (); i.hasNext (); )
        {
            final Map.Entry<T, Subscription<T>> entry = i.next ();
            entry.getValue ().unsubscribe ( listener );

            if ( entry.getValue ().isEmpty () )
            {
                i.remove ();
            }
        }
    }

    /**
     * Subscribe to a topic.
     * 
     * @param topic
     *            The topic to which the subscription should be made
     * @param listener
     *            The listener which will receive the events
     * @throws ValidationException
     *             thrown if the subscription cannot be established (e.g. the
     *             topic is invalid)
     */
    public synchronized void subscribe ( final T topic, final SubscriptionListener<T> listener ) throws ValidationException
    {
        subscribe ( topic, listener, null );
    }

    /**
     * Subscribe to a topic with a hint
     * 
     * @param topic
     *            The topic to which the subscription should be made
     * @param listener
     *            The listener which will receive the events
     * @param hint
     *            The hint is specific to the topic
     * @throws ValidationException
     *             thrown if the subscription cannot be established (e.g. the
     *             topic is invalid)
     */
    public synchronized void subscribe ( final T topic, final SubscriptionListener<T> listener, final Object hint ) throws ValidationException
    {
        // If we have a validator then do validate
        if ( this.validator != null )
        {
            if ( !this.validator.validate ( listener, topic ) )
            {
                throw new ValidationException ();
            }
        }

        // Get subscription or create one if there is none
        Subscription<T> s = this.subscriptions.get ( topic );
        if ( s == null )
        {
            s = new Subscription<T> ( topic );
            this.subscriptions.put ( topic, s );
        }

        final boolean wasSubscribed = s.isSubscribed ();

        s.subscribe ( listener, hint );

        if ( !wasSubscribed && s.isSubscribed () )
        {
            topicSubscriptionAdded ( topic );
        }
    }

    public synchronized void unsubscribe ( final T topic, final SubscriptionListener<T> listener )
    {
        final Subscription<T> s = this.subscriptions.get ( topic );
        if ( s == null )
        {
            return;
        }

        final boolean wasSubscribed = s.isSubscribed ();

        s.unsubscribe ( listener );

        if ( wasSubscribed && !s.isSubscribed () )
        {
            topicSubscriptionRemoved ( topic );
        }

        // if the subscription is empty we can erase it
        if ( s.isEmpty () )
        {
            this.subscriptions.remove ( topic );
        }
    }

    /**
     * Gets called when somebody subscribed to a topic that was not subscribed
     * before
     * 
     * @param topic
     *            the topic
     */
    protected void topicSubscriptionAdded ( final T topic )
    {
    }

    /**
     * Get called when somebody unsubscribed from a topic and it was the last
     * subscription
     * 
     * @param topic
     *            the topic
     */
    protected void topicSubscriptionRemoved ( final T topic )
    {
    }

    /**
     * Set a source for a topic.
     * This will cause all granted subscriptions to switch to connected for this
     * source
     * 
     * @param topic
     *            the topic
     * @param source
     *            the source to set
     */
    public synchronized void setSource ( final T topic, final SubscriptionSource<T> source )
    {
        Subscription<T> s = this.subscriptions.get ( topic );
        if ( s == null && source == null )
        {
            return;
        }

        if ( s == null )
        {
            s = new Subscription<T> ( topic );
            this.subscriptions.put ( topic, s );
        }

        s.setSource ( source );

        if ( s.isEmpty () )
        {
            this.subscriptions.remove ( topic );
        }
    }

    /**
     * Get the number of subscriptions currently registered
     * 
     * @return the number of subscriptions
     */
    public synchronized int getSubscriptionCount ()
    {
        return this.subscriptions.size ();
    }

    /**
     * Get all topics whose subscription is in granted state.
     * 
     * @return The list of topics whose subscription is in granted state.
     */
    public synchronized Set<T> getAllGrantedTopics ()
    {
        final Set<T> topicList = new HashSet<T> ();

        for ( final Map.Entry<T, Subscription<T>> entry : this.subscriptions.entrySet () )
        {
            if ( entry.getValue ().isGranted () )
            {
                topicList.add ( entry.getKey () );
            }
        }

        return topicList;
    }
}
