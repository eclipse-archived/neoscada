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
package org.eclipse.scada.ca.connection.provider;

import org.eclipse.scada.core.connection.provider.AbstractConnectionService;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.ca.client.Connection;

public class ConnectionServiceImpl extends AbstractConnectionService implements ConnectionService
{
    private final Connection connection;

    public ConnectionServiceImpl ( final Connection connection, final Integer autoReconnectController )
    {
        super ( autoReconnectController, false );
        setConnection ( this.connection = connection );
    }

    @Override
    public org.eclipse.scada.ca.client.Connection getConnection ()
    {
        return this.connection;
    }

    @Override
    public Class<?>[] getSupportedInterfaces ()
    {
        return new Class<?>[] { org.eclipse.scada.core.connection.provider.ConnectionService.class, ConnectionService.class, ConnectionInformationProvider.class };
    }

}
