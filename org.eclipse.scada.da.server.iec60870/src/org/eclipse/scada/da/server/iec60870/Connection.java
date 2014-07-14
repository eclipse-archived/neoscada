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

import java.util.Collections;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.client.AutoConnectClient;
import org.eclipse.scada.protocol.iec60870.client.ClientModule;
import org.eclipse.scada.protocol.iec60870.client.data.DataHandler;
import org.eclipse.scada.protocol.iec60870.client.data.DataModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connection
{

    private final static Logger logger = LoggerFactory.getLogger ( Connection.class );

    private DataHandler handler;

    private final AutoConnectClient client;

    public Connection ( final ConnectionConfiguration configuration )
    {
        final DataModule dataModule = new DataModule ( this.handler );

        final List<ClientModule> modules = Collections.singletonList ( (ClientModule)dataModule );

        this.client = new AutoConnectClient ( configuration.getHost (), configuration.getPort (), configuration.getProtocolOptions (), modules, null );
    }

    public void dispose ()
    {
        try
        {
            this.client.close ();
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( "Failed to close client", e );
        }
    }
}
