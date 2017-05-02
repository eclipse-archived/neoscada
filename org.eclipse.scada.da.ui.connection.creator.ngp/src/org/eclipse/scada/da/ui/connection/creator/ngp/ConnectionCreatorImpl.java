/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use shared socket connector
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.creator.ngp;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.DriverFactory;
import org.eclipse.scada.core.client.DriverInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.ui.connection.creator.ConnectionCreator;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.connection.provider.ConnectionServiceImpl;

public class ConnectionCreatorImpl implements ConnectionCreator
{
    private final DriverFactory factory = org.eclipse.scada.da.client.ngp.internal.Activator.getDriverFactory ();

    @Override
    public ConnectionService createConnection ( final ConnectionInformation connectionInformation, final Integer autoReconnectDelay, final boolean lazyActivation )
    {
        final DriverInformation di = this.factory.getDriverInformation ( connectionInformation );
        if ( di == null )
        {
            return null;
        }
        final Connection c = (Connection)di.create ( connectionInformation );
        return new ConnectionServiceImpl ( c, autoReconnectDelay, lazyActivation );
    }
}
