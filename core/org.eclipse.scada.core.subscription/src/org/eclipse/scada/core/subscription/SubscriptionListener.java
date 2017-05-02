/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - generic subscription manager
 *******************************************************************************/
package org.eclipse.scada.core.subscription;

import org.eclipse.scada.core.data.SubscriptionState;

/**
 * A basic subscription listener that acts as a base interface for all
 * subscriptions.
 * 
 * @author Jens Reimann
 */
public interface SubscriptionListener<T>
{
    /**
     * The subscription status update method. It is called by the
     * SubscriptionSource
     * whenever the subscription changed.
     * 
     * @param topic
     *            The topic that is notified
     * @param subscriptionState
     *            The new status of the subscription
     */
    public abstract void updateStatus ( T topic, SubscriptionState subscriptionState );
}
