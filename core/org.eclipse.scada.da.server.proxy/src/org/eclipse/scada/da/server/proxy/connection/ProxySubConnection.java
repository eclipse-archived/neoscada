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
package org.eclipse.scada.da.server.proxy.connection;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.AutoReconnectController;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.FolderManager;
import org.eclipse.scada.da.client.ItemManager;
import org.eclipse.scada.da.client.ItemManagerImpl;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.da.server.proxy.Hive;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class ProxySubConnection implements ConnectionStateListener
{
    private final Connection connection;

    private final ItemManager itemManager;

    private final ProxyPrefixName prefix;

    private final ProxySubConnectionId id;

    private final FolderManager folderManager;

    private final Hive hive;

    private final FolderItemFactory itemFactory;

    private final DataItemInputChained stateItem;

    private final DataItemCommand connectItem;

    private final DataItemCommand disconnectItem;

    private final AutoReconnectController controller;

    /**
     * @param connection
     * @param id
     * @param prefix
     * @param connectionFolder
     * @param hive
     */
    public ProxySubConnection ( final Connection connection, final ProxyPrefixName parentName, final ProxySubConnectionId id, final ProxyPrefixName prefix, final Hive hive, final FolderCommon connectionFolder )
    {
        this.connection = connection;
        this.itemManager = new ItemManagerImpl ( this.connection );
        this.folderManager = new FolderManager ( this.connection );
        this.prefix = prefix;
        this.id = id;
        this.hive = hive;
        this.itemFactory = new FolderItemFactory ( this.hive, connectionFolder, parentName.getName () + ".connections." + id, id.getName () );

        // setup state watcher
        this.stateItem = this.itemFactory.createInput ( "state", null );
        this.connection.addConnectionStateListener ( this );

        this.connectItem = this.itemFactory.createCommand ( "connect", null );
        this.connectItem.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value ) throws Exception
            {
                ProxySubConnection.this.connect ();
            }
        } );

        this.disconnectItem = this.itemFactory.createCommand ( "disconnect", null );
        this.disconnectItem.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value ) throws Exception
            {
                ProxySubConnection.this.disconnect ();
            }
        } );

        this.controller = new AutoReconnectController ( this.connection );
        connect ();
    }

    protected void disconnect ()
    {
        this.controller.disconnect ();
    }

    protected void connect ()
    {
        this.controller.connect ();
    }

    /**
     * @return itemManager
     */
    public ItemManager getItemManager ()
    {
        return this.itemManager;
    }

    /**
     * @return actual connection
     */
    public Connection getConnection ()
    {
        return this.connection;
    }

    /**
     * @return item prefix which should be substituted
     */
    public ProxyPrefixName getPrefix ()
    {
        return this.prefix;
    }

    /**
     * @return id of subconnection
     */
    public ProxySubConnectionId getId ()
    {
        return this.id;
    }

    /**
     * @return folderManager
     */
    public FolderManager getFolderManager ()
    {
        return this.folderManager;
    }

    public void dispose ()
    {
        disconnect ();
        this.itemFactory.dispose ();
    }

    @Override
    public void stateChange ( final org.eclipse.scada.core.client.Connection connection, final ConnectionState state, final Throwable error )
    {
        this.stateItem.updateData ( Variant.valueOf ( state.toString () ), null, null );
    }
}
