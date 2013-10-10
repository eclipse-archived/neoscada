/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.connection.service.internal;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.DriverFactory;
import org.eclipse.scada.core.client.connection.service.AbstractConnectionManager;
import org.eclipse.scada.core.connection.provider.AbstractConnectionService;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.connection.provider.ConnectionServiceImpl;
import org.osgi.framework.BundleContext;

public class ConnectionManager extends AbstractConnectionManager<ConnectionService>
{
    public ConnectionManager ( final BundleContext context, final String connectionId, final ConnectionInformation connectionInformation )
    {
        super ( ConnectionService.class, context, connectionId, connectionInformation );
    }

    @Override
    protected AbstractConnectionService createConnectionService ( final DriverFactory factory, final ConnectionInformation connectionInformation )
    {
        final Connection connection = (Connection)factory.getDriverInformation ( connectionInformation ).create ( connectionInformation );
        if ( connection == null )
        {
            return null;
        }
        return new ConnectionServiceImpl ( connection, 10000, false );
    }

}
