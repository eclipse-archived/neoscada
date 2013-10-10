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
package org.eclipse.scada.hd.client;

import org.eclipse.scada.hd.ItemListListener;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;

/**
 * A client connection to the historical data server
 * 
 * @author Jens Reimann
 * @since 0.14.0
 */
public interface Connection extends org.eclipse.scada.core.client.Connection
{
    /**
     * Create a new query on the server
     * 
     * @param itemId
     *            the historical item to query
     * @param parameters
     *            the initial query parameters
     * @param listener
     *            the listener that will receive data
     * @param updateData
     *            <code>true</code> if the query should provide continuous
     *            updates, <code>false</code> if the query should only be
     *            executed once an not data
     *            updates should be delivered after the query state changed to
     *            {@link QueryState#COMPLETE}.
     * @return a new query instance, <code>null</code> is never returned
     */
    public Query createQuery ( String itemId, QueryParameters parameters, QueryListener listener, boolean updateData );

    /**
     * Add a new listener to the connection in order to receive item list
     * updates.
     * <p>
     * A new listener will also receive any already known items.
     * </p>
     * 
     * @param listener
     *            the listener to add
     */
    public void addListListener ( ItemListListener listener );

    /**
     * Remove a listener from the connection
     * 
     * @param listener
     *            the listener to remove
     */
    public void removeListListener ( ItemListListener listener );
}
