/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.connection;

import java.util.HashMap;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.proxy.Hive;
import org.eclipse.scada.da.server.proxy.item.ProxyDataItem;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class ProxyConnection implements LifecycleAware
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyConnection.class );

    /**
     * item name for items which are only relevant for proxy server
     */
    public static final String ITEM_PREFIX = "proxy.connection";

    private final Hive hive;

    private final ProxyGroup group;

    private final FolderCommon connectionsFolder;

    private final String separator;

    private WriteHandlerItem activeConnectionItem;

    private DataItemInputChained switchStarted;

    private DataItemInputChained switchEnded;

    private DataItemInputChained switchInProgress;

    private DataItemInputChained switchDuration;

    private final FolderCommon connectionFolder;

    private DataItemCommand connectItem;

    private DataItemCommand disconnectItem;

    private final ProxyDataItemFactory factory;

    /**
     * @param hive
     * @param prefix
     * @param connectionsFolder
     */
    public ProxyConnection ( final Hive hive, final ProxyPrefixName prefix, final FolderCommon connectionsFolder )
    {
        this.hive = hive;
        this.connectionsFolder = connectionsFolder;
        this.group = new ProxyGroup ( hive, prefix );
        this.separator = this.hive.getSeparator ();

        this.connectionFolder = new FolderCommon ();
        this.group.setConnectionFolder ( this.connectionFolder );
        this.connectionsFolder.add ( this.group.getPrefix ().getName (), this.connectionFolder, new HashMap<String, Variant> () );

        this.factory = new ProxyDataItemFactory ( prefix, this, hive, this.separator );
    }

    protected DataItemInputChained createItem ( final String localId )
    {
        final DataItemInputChained item = new DataItemInputChained ( itemName ( localId ), this.hive.getOperationService () );

        this.hive.registerItem ( item );
        this.connectionFolder.add ( localId, item, new MapBuilder<String, Variant> ().getMap () );

        return item;
    }

    private String itemName ( final String localId )
    {
        return this.group.getPrefix ().getName () + this.separator + ITEM_PREFIX + this.separator + localId;
    }

    /**
     * 
     */
    @Override
    public void start ()
    {
        this.switchStarted = createItem ( "switch.started" );
        this.switchEnded = createItem ( "switch.ended" );
        this.switchInProgress = createItem ( "switch.inprogress" );
        this.switchDuration = createItem ( "switch.duration" );

        // active Connection
        this.activeConnectionItem = new WriteHandlerItem ( itemName ( "active" ), new WriteHandler () {

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                final String newId = value.asString ( null );
                ProxyConnection.this.switchTo ( newId );
            }
        }, this.hive.getOperationService () );
        this.hive.registerItem ( this.activeConnectionItem );

        // fill active connection information
        final HashMap<String, Variant> availableConnections = new HashMap<String, Variant> ();
        for ( final ProxySubConnection subConnection : this.group.getSubConnections ().values () )
        {
            availableConnections.put ( "available.connection." + subConnection.getId (), Variant.valueOf ( subConnection.getPrefix ().getName () ) );
        }
        this.connectionFolder.add ( "active", this.activeConnectionItem, availableConnections );

        this.activeConnectionItem.updateData ( Variant.valueOf ( this.group.getCurrentConnection ().toString () ), availableConnections, AttributeMode.SET );

        this.connectItem = new DataItemCommand ( itemName ( "connect" ), this.hive.getOperationService () );
        this.connectItem.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value ) throws Exception
            {
                ProxyConnection.this.group.connectCurrentConnection ();
            }
        } );
        this.hive.registerItem ( this.connectItem );
        this.connectionFolder.add ( "connect", this.connectItem, new MapBuilder<String, Variant> ().getMap () );

        this.disconnectItem = new DataItemCommand ( itemName ( "disconnect" ), this.hive.getOperationService () );
        this.disconnectItem.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value ) throws Exception
            {
                ProxyConnection.this.group.connectCurrentConnection ();
            }
        } );
        this.hive.registerItem ( this.disconnectItem );
        this.connectionFolder.add ( "disconnect", this.disconnectItem, new MapBuilder<String, Variant> ().getMap () );

        this.group.addConnectionStateListener ( new NotifyConnectionErrorListener ( this.group ) );

        // add proxy folder for actual items
        this.group.start ();

        // add our factory to the hive
        this.hive.addItemFactory ( this.factory );
    }

    protected void switchTo ( final String newId )
    {
        try
        {
            final ProxySubConnection newSubConnection = ProxyConnection.this.group.getSubConnections ().get ( new ProxySubConnectionId ( newId ) );
            if ( newSubConnection != null )
            {
                ProxyConnection.this.switchTo ( newSubConnection.getId () );
            }
        }
        catch ( final Throwable e )
        {
            logger.error ( String.format ( "Failed to switch to: %s", newId ), e );
        }
    }

    protected void switchTo ( final ProxySubConnectionId id )
    {
        // mark start of switch
        final long start = System.currentTimeMillis ();
        this.switchStarted.updateData ( Variant.valueOf ( start ), null, AttributeMode.UPDATE );
        this.switchInProgress.updateData ( Variant.TRUE, null, AttributeMode.UPDATE );

        try
        {
            // perform switch
            this.group.switchTo ( id );
            this.activeConnectionItem.updateData ( Variant.valueOf ( id ), null, null );
        }
        finally
        {
            // mark end of switch
            this.switchInProgress.updateData ( Variant.FALSE, null, AttributeMode.UPDATE );
            final long end = System.currentTimeMillis ();
            this.switchEnded.updateData ( Variant.valueOf ( end ), null, AttributeMode.UPDATE );
            this.switchDuration.updateData ( Variant.valueOf ( end - start ), null, AttributeMode.UPDATE );
        }
    }

    /**
     * @param id
     * @return item
     */
    public ProxyDataItem realizeItem ( final String id )
    {
        return this.group.realizeItem ( id );
    }

    /**
     * 
     */
    @Override
    public void stop ()
    {
        this.hive.removeItemFactory ( this.factory );
        this.group.stop ();
    }

    public ProxyPrefixName getPrefix ()
    {
        return this.group.getPrefix ();
    }

    public void setWait ( final int wait )
    {
        this.group.setWait ( wait );
    }

    public void addConnection ( final Connection connection, final String id, final ProxyPrefixName proxyPrefixName ) throws InvalidOperationException, NullValueException, NotConvertableException
    {
        this.group.addConnection ( connection, id, proxyPrefixName, this.connectionFolder );

    }
}
