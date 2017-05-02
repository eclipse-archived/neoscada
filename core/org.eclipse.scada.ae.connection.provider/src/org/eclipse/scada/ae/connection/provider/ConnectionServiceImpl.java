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
package org.eclipse.scada.ae.connection.provider;

import org.eclipse.scada.ae.client.Connection;
import org.eclipse.scada.ae.client.EventManager;
import org.eclipse.scada.ae.client.MonitorManager;
import org.eclipse.scada.core.connection.provider.AbstractConnectionService;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;

public class ConnectionServiceImpl extends AbstractConnectionService implements ConnectionService
{
    private final EventManager eventManager;

    private final MonitorManager monitorManager;

    private final Connection connection;

    public ConnectionServiceImpl ( final Connection connection, final Integer autoReconnectController )
    {
        super ( autoReconnectController, false );
        setConnection ( this.connection = connection );
        this.eventManager = new EventManager ( connection );
        this.monitorManager = new MonitorManager ( connection );
    }

    @Override
    public org.eclipse.scada.ae.client.Connection getConnection ()
    {
        return this.connection;
    }

    @Override
    public Class<?>[] getSupportedInterfaces ()
    {
        return new Class<?>[] { org.eclipse.scada.core.connection.provider.ConnectionService.class, ConnectionService.class, ConnectionInformationProvider.class };
    }

    @Override
    public EventManager getEventManager ()
    {
        return this.eventManager;
    }

    @Override
    public MonitorManager getMonitorManager ()
    {
        return this.monitorManager;
    }
}
