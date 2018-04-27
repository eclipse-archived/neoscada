/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.da.server.iec60870;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.exporter.ItemOptions;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class ClientState extends AbstractPropertyChange
{
    public static final String PROP_CONNECTION_STATE = "connectionState";

    public static final String PROP_DATA_STARTED = "dataStarted";

    @ItemOptions ( readonly = true )
    private String connectionState;

    @ItemOptions ( readonly = true )
    private boolean dataStarted;

    private final Connection connection;

    public ClientState ( final Connection connection )
    {
        this.connection = connection;
    }

    public void setConnectionState ( final String connectionState )
    {
        firePropertyChange ( PROP_CONNECTION_STATE, this.connectionState, this.connectionState = connectionState );
    }

    public String getConnectionState ()
    {
        return this.connectionState;
    }

    public void setDataStarted ( final boolean dataStarted )
    {
        firePropertyChange ( PROP_DATA_STARTED, this.dataStarted, this.dataStarted = dataStarted );
    }

    public boolean isDataStarted ()
    {
        return this.dataStarted;
    }

    public void setReconnect ( final Variant dummyValue )
    {
        this.connection.reconnect ();
    }

    public void setStart ( final Variant dummyValue )
    {
        this.connection.requestStartData ();
    }
}
