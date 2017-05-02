/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;

/**
 * Notifies a item on the client that data changed.
 * <p>
 * 
 * @author jens
 */
public interface ItemUpdateListener
{
    /**
     * A change on the data item occurred.
     * 
     * @param value
     *            The new value, or <code>null</code> if the value did not
     *            change
     * @param attributes
     *            The attributes that changed, may be <code>null</code> if no
     *            attribute change at all. The must be unmodifiable by the
     *            receiver
     * @param cache
     *            Indicating that the change came from the cache, this means
     *            that the change was not triggered by a device and that
     *            <em>all</em> attribute where sent, not only the changed ones
     */
    public void notifyDataChange ( Variant value, Map<String, Variant> attributes, boolean cache );

    /**
     * Notify a change in the subscription change
     * 
     * @param subscriptionState
     *            the new subscription change
     * @param subscriptionError
     *            the new subscription error or <code>null</code> if everything
     *            is ok
     */
    public void notifySubscriptionChange ( SubscriptionState subscriptionState, Throwable subscriptionError );
}
