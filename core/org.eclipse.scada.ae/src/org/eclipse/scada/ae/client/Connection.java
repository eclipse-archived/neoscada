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
package org.eclipse.scada.ae.client;

import java.util.Date;

import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * Interface for client connection
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public interface Connection extends org.eclipse.scada.core.client.Connection
{
    // Monitors
    /**
     * Set the listener that should receive monitor updates
     */
    public void setMonitorListener ( String monitorQueryId, MonitorListener listener );

    // Event - online
    /**
     * Set the listener that should receive event updates
     */
    public void setEventListener ( String eventQueryId, EventListener listener );

    // Event - offline
    public Query createQuery ( String queryType, String queryData, QueryListener listener );

    /**
     * Add browser listener
     * 
     * @param listener
     *            the listener to add
     */
    public void addBrowserListener ( BrowserListener listener );

    public void removeBrowserListener ( BrowserListener listener );

    /**
     * Acknowledge the monitor if the akn state was reached at or before the
     * provided timestamp
     * 
     * @param monitorId
     *            the id of the condition
     * @param aknTimestamp
     *            the timestamp up to which the state may be acknowledged
     * @param operationParameters
     *            optionally provide some user information which performs the
     *            aknowledgement. If the information is not provided the current
     *            logged in user will be used. If the information is present but
     *            the current logged in user is not allowed to change the user
     *            performing acknowledgement the server may fall back to use the
     *            actual information of the logged in user instead.
     */
    public NotifyFuture<Void> acknowledge ( String monitorId, Date aknTimestamp, OperationParameters operationParameters, CallbackHandler callbackHandler );
}
