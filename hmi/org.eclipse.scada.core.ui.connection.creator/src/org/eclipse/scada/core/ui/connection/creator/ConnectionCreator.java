/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.creator;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;

public interface ConnectionCreator
{
    /**
     * Create a new connection service
     * <p>
     * A connection may be requested with lazyActivation which means that the connection should only be established by the connection service when the first requests are placed (e.g. subscriptions).
     * The connection service must not support this and may decide for itself when the connection is opened and closed.
     * </p>
     * 
     * @param connectionInformation
     *            the connection information
     * @param autoReconnectDelay
     *            optionally an auto reconnect delay information
     * @param lazyActivation
     *            indicates that the connection service may establish the connection in lazy mode
     * @return a new connection service or <code>null</code> if none could be created for the request parameters
     */
    public ConnectionService createConnection ( ConnectionInformation connectionInformation, Integer autoReconnectDelay, boolean lazyActivation );
}
