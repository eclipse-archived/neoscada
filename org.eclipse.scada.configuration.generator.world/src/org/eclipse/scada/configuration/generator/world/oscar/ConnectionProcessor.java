/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.world.Nodes;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

public class ConnectionProcessor extends BasicOscarProcessor
{

    private final EquinoxApplication app;

    public ConnectionProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        for ( final Connection connection : this.app.getConnections () )
        {
            createConnection ( connection );
        }
    }

    private void createConnection ( final Connection connection )
    {
        final Map<String, String> data = new HashMap<> ();

        final String configurationId = Names.makeName ( connection );

        final Endpoint ep = connection.getEndpoint ();

        final boolean isLocal = Nodes.isLocal ( ep.getNode (), this.app );

        data.put ( "connection.uri", connection.makeUri ( isLocal ) ); //$NON-NLS-1$

        // FIXME: this is the factory name, which could be different than the following schema
        addData ( connection.getTypeTag () + ".connection", configurationId, data );
    }
}
