/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.subscription;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.data.SubscriptionState;

public class Subscription
{
    private final Map<SubscriptionInformation, Object> listeners = new HashMap<SubscriptionInformation, Object> ( 1 );

    private SubscriptionSource source = null;

    private Object topic = null;

    public Subscription ( final Object topic )
    {
        super ();
        this.topic = topic;
    }

    /**
     * Check if the subscription is empty or nor.
     * A subscription is empty if it neither has a subscription source set nor
     * listeners
     * attached to it.
     * 
     * @return <code>true</code> if the subscription is empty,
     *         <code>false</code> otherwise
     */
    public synchronized boolean isEmpty ()
    {
        return this.source == null && this.listeners.isEmpty ();
    }

    /**
     * Check if the subscription is in granted state. This means that no source
     * is connected but there are listeners attached.
     * 
     * @return <code>true</code> if the subscription is in granted state,
     *         <code>false</code> otherwise
     */
    public synchronized boolean isGranted ()
    {
        return this.source == null && !this.listeners.isEmpty ();
    }

    public synchronized void subscribe ( final SubscriptionListener listener, final Object hint )
    {
        final SubscriptionInformation subscriptionInformation = new SubscriptionInformation ( listener, hint );

        if ( this.listeners.containsKey ( subscriptionInformation ) )
        {
            return;
        }
        this.listeners.put ( subscriptionInformation, hint );

        if ( this.source == null )
        {
            listener.updateStatus ( this.topic, SubscriptionState.GRANTED );
        }
        else
        {
            listener.updateStatus ( this.topic, SubscriptionState.CONNECTED );
            this.source.addListener ( Arrays.asList ( subscriptionInformation ) );
        }
    }

    public synchronized void unsubscribe ( final SubscriptionListener listener )
    {
        final SubscriptionInformation subscriptionInformation = new SubscriptionInformation ( listener, null );
        if ( this.listeners.containsKey ( subscriptionInformation ) )
        {
            final Object hint = this.listeners.remove ( subscriptionInformation );
            subscriptionInformation.setHint ( hint );

            if ( this.source != null )
            {
                this.source.removeListener ( Arrays.asList ( subscriptionInformation ) );
            }

            listener.updateStatus ( this.topic, SubscriptionState.DISCONNECTED );
        }
    }

    public synchronized void setSource ( final SubscriptionSource source )
    {
        // We only act on changes
        if ( this.source == source )
        {
            return;
        }

        if ( this.source != null )
        {
            this.source.removeListener ( this.listeners.keySet () );
        }

        final Set<SubscriptionInformation> keys = this.listeners.keySet ();
        if ( source != null )
        {
            for ( final SubscriptionInformation information : keys )
            {
                information.getListener ().updateStatus ( this.topic, SubscriptionState.CONNECTED );
            }
            if ( !keys.isEmpty () )
            {
                source.addListener ( keys );
            }
        }
        else
        {
            for ( final SubscriptionInformation information : keys )
            {
                information.getListener ().updateStatus ( this.topic, SubscriptionState.GRANTED );
            }
        }

        this.source = source;
    }
}
