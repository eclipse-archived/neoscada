/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * A DataAccess (DA) connection.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 */
public interface Connection extends org.eclipse.scada.core.client.Connection
{

    /**
     * Browse a server folder for items. The operation will return immediately.
     * 
     * @param location
     *            The path to browse
     * @param callback
     *            The callback that shall receive notifications of the operation
     */
    public abstract void browse ( Location location, BrowseOperationCallback callback );

    /**
     * @deprecated use
     *             {@link #startWrite(String, Variant, OperationParameters, CallbackHandler)}
     *             instead
     */
    @Deprecated
    public abstract void write ( String itemId, Variant value, OperationParameters operationParameters, WriteOperationCallback callback );

    /**
     * @deprecated use
     *             {@link #startWriteAttributes(String, Map, OperationParameters, CallbackHandler)}
     *             instead
     */
    @Deprecated
    public abstract void writeAttributes ( String itemId, Map<String, Variant> attributes, OperationParameters operationParameters, WriteAttributeOperationCallback callback );

    public abstract NotifyFuture<WriteResult> startWrite ( String itemId, Variant value, OperationParameters operationParameters, CallbackHandler callbackHandler );

    public abstract NotifyFuture<WriteAttributeResults> startWriteAttributes ( String itemId, Map<String, Variant> attributes, OperationParameters operationParameters, CallbackHandler callbackHandler );

    public abstract void subscribeFolder ( Location location ) throws NoConnectionException, OperationException;

    public abstract void unsubscribeFolder ( Location location ) throws NoConnectionException, OperationException;

    /**
     * Set the listener for this location.
     * 
     * @param location
     *            The location for which to set the listener
     * @param listener
     *            The listener to set
     * @return The previous set listener or <code>null</code> if there was no
     *         previous listener
     */
    public abstract FolderListener setFolderListener ( Location location, FolderListener listener );

    public abstract void subscribeItem ( String itemId ) throws NoConnectionException, OperationException;

    public abstract void unsubscribeItem ( String itemId ) throws NoConnectionException, OperationException;

    /**
     * Set the listener for this item.
     * 
     * @param itemId
     *            The item for which to set the listener
     * @param listener
     *            The listener to set
     * @return The previous set listener or <code>null</code> if there was no
     *         previous listener
     */
    public abstract ItemUpdateListener setItemUpdateListener ( String itemId, ItemUpdateListener listener );

    /**
     * Retrieve the executor that is currently set
     * 
     * @return the currently used executor. Implementations must never return
     *         <code>null</code>
     */
    public abstract ScheduledExecutorService getExecutor ();
}
