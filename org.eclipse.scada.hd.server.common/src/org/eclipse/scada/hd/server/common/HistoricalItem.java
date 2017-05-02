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
package org.eclipse.scada.hd.server.common;

import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.data.QueryParameters;

/**
 * An interface of a historical item
 * 
 * @author Jens Reimann
 */
public interface HistoricalItem
{
    /**
     * Create a new query
     * 
     * @param parameters
     *            the initial query parameters
     * @param listener
     *            the query listener
     * @param updateData
     *            if <code>true</code> then additional updates will be made by
     *            the query when
     *            data changes although the query is {@link QueryState#COMPLETE}
     * @return the new query or <code>null</code> if the query could be be
     *         created
     */
    public Query createQuery ( QueryParameters parameters, QueryListener listener, boolean updateData );

    /**
     * Get the item information
     * 
     * @return the item information
     */
    public HistoricalItemInformation getInformation ();
}
