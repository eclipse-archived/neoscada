/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.core.server;

import java.util.Map;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.server.Service;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.core.server.browser.HiveBrowser;
import org.eclipse.scada.sec.PermissionDeniedException;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface Hive extends Service<Session>
{

    /**
     * Register to an item for event notification
     * 
     * @param session
     *            the session to use
     * @param item
     *            the item to register for
     * @param initial
     *            trigger an initial cache read with the registration
     * @throws InvalidSessionException
     *             In the case the session is not a valid session
     * @throws InvalidItemException
     *             In the case the item is not valid
     */
    public void subscribeItem ( Session session, String item ) throws InvalidSessionException, InvalidItemException;

    /**
     * Unregister from an an item for event notification
     * 
     * @param session
     *            the session to use
     * @param item
     * @throws InvalidSessionException
     *             In the case the session is not a valid session
     * @throws InvalidItemException
     *             In the case the item is not valid
     */
    public void unsubscribeItem ( Session session, String item ) throws InvalidSessionException, InvalidItemException;

    /**
     * Start a write operation
     * The operation is not started unless {@link #thawOperation(Session, long)}
     * is called.
     * 
     * @param session
     *            the session to use
     * @param itemId
     *            The item to write to
     * @param value
     *            The value to write
     * @param operationParameters
     *            additional parameters to the write request, can be
     *            <code>null</code>
     * @param callbackHandler
     *            can be null
     * @return An operation ID which can be used to cancel or run the operation
     * @throws InvalidSessionException
     *             In the case the session is not a valid session
     * @throws InvalidItemException
     *             In the case the item is not valid
     * @throws PermissionDeniedException
     *             if the user has no permission to perform this operation
     */

    public NotifyFuture<WriteResult> startWrite ( Session session, String itemId, Variant value, OperationParameters operationParameters, CallbackHandler callbackHandler ) throws InvalidSessionException, InvalidItemException, PermissionDeniedException;

    /**
     * Start a write attributes operation
     * The operation is not started unless {@link #thawOperation(Session, long)}
     * is called.
     * 
     * @param session
     *            the session to use
     * @param itemId
     *            The item to write to
     * @param attribute
     *            The attributes to write
     * @param operationParameters
     *            additional parameters to the write request, can be
     *            <code>null</code>
     * @return An operation ID which can be used to cancel or run the operation
     * @throws InvalidSessionException
     *             In the case the session is not a valid session
     * @throws InvalidItemException
     *             In the case the item is not valid
     * @throws PermissionDeniedException
     *             if the user has no permission to perform this operation
     */

    public NotifyFuture<WriteAttributeResults> startWriteAttributes ( Session session, String itemId, Map<String, Variant> attribute, OperationParameters operationParameters, CallbackHandler callbackHandler ) throws InvalidSessionException, InvalidItemException, PermissionDeniedException;

    public HiveBrowser getBrowser ();
}
