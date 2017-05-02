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
package org.eclipse.scada.da.master.analyzer;

import org.eclipse.scada.core.client.ConnectionState;

public class ConnectionAnalyzerStatus
{
    private ConnectionState state;

    private boolean connected;

    private String uri;

    private String lastError;

    private String lastException;

    public String getLastError ()
    {
        return this.lastError;
    }

    public void setLastError ( final String lastError )
    {
        this.lastError = lastError;
    }

    public String getLastException ()
    {
        return this.lastException;
    }

    public void setLastException ( final String lastException )
    {
        this.lastException = lastException;
    }

    public ConnectionState getState ()
    {
        return this.state;
    }

    public void setState ( final ConnectionState state )
    {
        this.state = state;
    }

    public void setConnected ( final boolean connected )
    {
        this.connected = connected;
    }

    public boolean isConnected ()
    {
        return this.connected;
    }

    public String getUri ()
    {
        return this.uri;
    }

    public void setUri ( final String uri )
    {
        this.uri = uri;
    }

}
