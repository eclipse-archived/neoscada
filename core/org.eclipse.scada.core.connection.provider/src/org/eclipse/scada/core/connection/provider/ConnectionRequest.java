/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.connection.provider;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class ConnectionRequest
{
    private final String requestId;

    private final ConnectionInformation connectionInformation;

    private final Integer autoReconnectDelay;

    private final boolean initialOpen;

    public ConnectionRequest ( final String requestId, final ConnectionInformation connectionInformation, final Integer autoReconnectDelay, final boolean initialOpen )
    {
        this.requestId = requestId;
        this.connectionInformation = connectionInformation;
        this.autoReconnectDelay = autoReconnectDelay;
        this.initialOpen = initialOpen;
    }

    public boolean isPrivateRequest ()
    {
        return this.requestId != null;
    }

    public boolean isInitialOpen ()
    {
        return this.initialOpen;
    }

    public Integer getAutoReconnectDelay ()
    {
        return this.autoReconnectDelay;
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    public String getRequestId ()
    {
        return this.requestId;
    }

    @Override
    public String toString ()
    {
        return String.format ( "%s -> %s (Auto: %s, Open: %s, Private: %s)", this.requestId, this.connectionInformation, this.autoReconnectDelay, this.initialOpen, isPrivateRequest () );
    }
}
