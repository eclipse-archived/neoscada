/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.iec60870;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;

public class ConnectionConfiguration
{
    private final String host;

    private final int port;

    private final ProtocolOptions protocolOptions;

    public ConnectionConfiguration ( final String host, final int port, final ProtocolOptions protocolOptions )
    {
        this.host = host;
        this.port = port;
        this.protocolOptions = protocolOptions;
    }

    public String getHost ()
    {
        return this.host;
    }

    public int getPort ()
    {
        return this.port;
    }

    public ProtocolOptions getProtocolOptions ()
    {
        return this.protocolOptions;
    }
}
