/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.connection.provider;

import org.eclipse.scada.core.connection.provider.AbstractConnectionService;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.FolderManager;
import org.eclipse.scada.da.client.ItemManager;
import org.eclipse.scada.da.client.ItemManagerImpl;
import org.eclipse.scada.da.connection.provider.internal.CountingItemManager;
import org.eclipse.scada.da.connection.provider.internal.LazyConnectionWrapper;

public class ConnectionServiceImpl extends AbstractConnectionService implements ConnectionService
{
    private final static Object GET_ON_IM = new Object ();

    private final ItemManager itemManager;

    private final FolderManager folderManager;

    private final Connection connection;

    private boolean shouldConnect;

    public ConnectionServiceImpl ( final Connection connection, final Integer autoReconnectController, final boolean lazyActivation )
    {
        super ( autoReconnectController, lazyActivation );

        // for now we are using the autoReconnectController timeout as lingering timeout ...
        this.connection = lazyActivation ? new LazyConnectionWrapper ( connection, autoReconnectController ) {

            @Override
            protected void performDisconnect ()
            {
                setShouldConnect ( false );
            }

            @Override
            protected void performConnect ()
            {
                setShouldConnect ( true );
            }
        } : connection;

        setConnection ( this.connection );

        this.itemManager = new CountingItemManager ( new ItemManagerImpl ( this.connection ), this.statistics );
        this.folderManager = new FolderManager ( this.connection );

        this.statistics.setLabel ( ConnectionServiceImpl.GET_ON_IM, "getItemManager called" );
        this.statistics.setLabel ( CountingItemManager.REGISTERED_ITEMS, "Registered items" );
    }

    protected synchronized void setShouldConnect ( final boolean state )
    {
        this.shouldConnect = state;
        checkConnect ();
    }

    @Override
    protected boolean shouldConnect ()
    {
        return this.shouldConnect;
    }

    @Override
    public Connection getConnection ()
    {
        return this.connection;
    }

    @Override
    public FolderManager getFolderManager ()
    {
        return this.folderManager;
    }

    @Override
    public ItemManager getItemManager ()
    {
        this.statistics.changeCurrentValue ( ConnectionServiceImpl.GET_ON_IM, 1 );
        return this.itemManager;
    }

    @Override
    public Class<?>[] getSupportedInterfaces ()
    {
        return new Class<?>[] { org.eclipse.scada.core.connection.provider.ConnectionService.class, ConnectionService.class, ConnectionInformationProvider.class };
    }

}
