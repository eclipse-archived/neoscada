/*******************************************************************************
 * Copyright (c) 2011, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds;

import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * A data store service interface
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public interface DataStore
{
    /**
     * Attach a listener to a data node
     * <p>
     * The listener is called with the current status of the node when
     * attaching.
     * </p>
     * 
     * @param nodeId
     *            the node id to attach to
     * @param listener
     *            the listener that will receive events
     */
    public void attachListener ( String nodeId, DataListener listener );

    public void detachListener ( String nodeId, DataListener listener );

    public NotifyFuture<Void> deleteNode ( String nodeId );

    public NotifyFuture<Void> writeNode ( DataNode node );

    /**
     * Get the data node
     * 
     * @param nodeId
     *            the id of the node to get
     * @return the future to the read request. The future will
     *         return <code>null</code> if the node does not exists.
     */
    public NotifyFuture<DataNode> readNode ( String nodeId );
}
