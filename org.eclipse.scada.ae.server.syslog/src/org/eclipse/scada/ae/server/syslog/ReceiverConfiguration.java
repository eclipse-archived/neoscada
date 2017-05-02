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
package org.eclipse.scada.ae.server.syslog;

import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;

public class ReceiverConfiguration
{
    private final int port;

    private final String host;

    public ReceiverConfiguration ( final String host, final int port )
    {
        this.host = host;
        this.port = port;
    }

    public int getPort ()
    {
        return this.port;
    }

    public String getHost ()
    {
        return this.host;
    }

    public static ReceiverConfiguration parse ( final String configurationId, final Map<String, String> parameters )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String host = cfg.getString ( "host", null );
        final int port = cfg.getIntegerChecked ( "port", "'port' is required" );

        if ( port <= 0 || port > 64 * 1024 )
        {
            throw new IllegalArgumentException ( String.format ( "Invalid port number: %s", port ) );
        }

        return new ReceiverConfiguration ( host, port );
    }

}
