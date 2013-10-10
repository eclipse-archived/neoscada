/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.core.server;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;

/**
 * Interface for listening to data items
 * 
 * @author Jens Reimann
 */
public interface ItemChangeListener
{
    /**
     * A change on the data item occurred.
     * 
     * @param itemId
     *            The item id that changed
     * @param value
     *            The new value, or <code>null</code> if the value did not
     *            change
     * @param attributes
     *            The attributes that changed, may be <code>null</code> if no
     *            attribute change at all
     * @param cache
     *            Indicating that the change came from the cache, this means
     *            that the change was not triggered by a device and that
     *            <em>all</em> attribute where sent, not only the changed ones
     */
    public void dataChanged ( String itemId, Variant value, Map<String, Variant> attributes, boolean cache );

    /**
     * Indicating a change in the item subscription
     * 
     * @param itemId
     *            The item ID that changed
     * @param subscriptionState
     *            the new subscription state
     */
    public void subscriptionChanged ( String itemId, SubscriptionState subscriptionState );
}
