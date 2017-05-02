/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.client.ItemManager;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.InvisibleStorage;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.PatternNameProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.proxy.Hive;
import org.eclipse.scada.da.server.proxy.item.ProxyDataItem;
import org.eclipse.scada.da.server.proxy.item.ProxyItemUpdateListener;
import org.eclipse.scada.da.server.proxy.item.ProxyValueHolder;
import org.eclipse.scada.da.server.proxy.item.ProxyWriteHandler;
import org.eclipse.scada.da.server.proxy.item.ProxyWriteHandlerImpl;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;
import org.eclipse.scada.da.server.proxy.utils.ProxyUtils;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class ProxyGroup implements LifecycleAware
{
    private static final String FOLDER_NAME_REGISTERED_ITEMS = "registeredItems";

    private final static Logger logger = LoggerFactory.getLogger ( ProxyGroup.ThreadFactoryImplementation.class );

    private final static class ThreadFactoryImplementation implements ThreadFactory
    {
        private final String name;

        public ThreadFactoryImplementation ( final String name )
        {
            this.name = name;
        }

        @Override
        public Thread newThread ( final Runnable r )
        {
            final Thread t = new Thread ( r, "ProxyItemListener/" + this.name );
            t.setDaemon ( true );
            return t;
        }
    }

    private static Executor defaultExecutor = new Executor () {
        @Override
        public void execute ( final Runnable r )
        {
            r.run ();
        }
    };

    private final Set<ConnectionStateListener> connectionStateListeners = new CopyOnWriteArraySet<ConnectionStateListener> ();

    private ProxySubConnectionId currentConnection;

    private ProxyPrefixName prefix;

    private final Map<String, ProxyDataItem> registeredItems = new ConcurrentHashMap<String, ProxyDataItem> ();

    private FolderCommon connectionFolder;

    private final Hive hive;

    private final Lock switchLock = new ReentrantLock ();

    private Executor itemListenerExecutor = defaultExecutor;

    private final Map<ProxySubConnectionId, ProxySubConnection> subConnections = new HashMap<ProxySubConnectionId, ProxySubConnection> ();

    private int wait;

    private ProxyFolder proxyFolder;

    private final Object realizeMutex = new Object ();

    private InvisibleStorage registeredItemsStorage;

    private GroupFolder registeredItemsFolder;

    /**
     * @param hive
     * @param prefix
     */
    public ProxyGroup ( final Hive hive, final ProxyPrefixName prefix )
    {
        this.hive = hive;
        this.prefix = prefix;

        if ( Boolean.getBoolean ( "org.eclipse.scada.da.server.proxy.asyncListener" ) )
        {
            final ThreadFactory tf = new ThreadFactoryImplementation ( prefix.getName () );
            this.itemListenerExecutor = Executors.newSingleThreadExecutor ( tf );
        }
    }

    @Override
    public void start ()
    {
        createProxyFolder ();

        this.registeredItemsStorage = new InvisibleStorage ();
        this.registeredItemsFolder = new GroupFolder ( new SplitGroupProvider ( new IDNameProvider (), Pattern.quote ( this.hive.getSeparator () ) ), new PatternNameProvider ( new IDNameProvider (), Pattern.compile ( "^.*" + Pattern.quote ( this.hive.getSeparator () ) + "(.*?)$" ), 1 ) );
        this.connectionFolder.add ( FOLDER_NAME_REGISTERED_ITEMS, this.registeredItemsFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "The folder which contains all realized items" ) ).getMap () );
        this.registeredItemsStorage.addChild ( this.registeredItemsFolder );
    }

    @Override
    public void stop ()
    {

        this.connectionFolder.remove ( FOLDER_NAME_REGISTERED_ITEMS );
        this.registeredItemsStorage.removeChild ( this.registeredItemsFolder );
        this.registeredItemsStorage = null;
        this.registeredItemsFolder = null;
        destroyProxyFolder ();
    }

    /**
     * @return folder which holds items and connection information
     */
    public FolderCommon getConnectionFolder ()
    {
        return this.connectionFolder;
    }

    /**
     * @param connectionFolder
     */
    public void setConnectionFolder ( final FolderCommon connectionFolder )
    {
        this.connectionFolder = connectionFolder;
    }

    /**
     * @return the current selected connection
     */
    private Connection currentConnection ()
    {
        return currentSubConnection ().getConnection ();
    }

    /**
     * @return the current selected connection
     */
    private ProxySubConnection currentSubConnection ()
    {
        return this.subConnections.get ( this.currentConnection );
    }

    /**
     * @param connection
     * @param id
     * @param prefix
     * @param folderCommon
     * @throws InvalidOperationException
     * @throws NullValueException
     * @throws NotConvertableException
     */
    public void addConnection ( final Connection connection, final String id, final ProxyPrefixName prefix, final FolderCommon connectionFolder ) throws InvalidOperationException, NullValueException, NotConvertableException
    {
        final ProxySubConnectionId proxySubConnectionId = new ProxySubConnectionId ( id );
        if ( this.subConnections.containsKey ( proxySubConnectionId ) )
        {
            throw new IllegalArgumentException ( "connection with id " + proxySubConnectionId + " already exists!" );
        }
        logger.info ( "Adding new connection: {} -> {}", id, connection.getConnectionInformation () );
        final ProxySubConnection proxySubConnection = new ProxySubConnection ( connection, this.prefix, proxySubConnectionId, prefix, this.hive, connectionFolder );
        this.subConnections.put ( proxySubConnectionId, proxySubConnection );

        if ( this.currentConnection == null )
        {
            this.currentConnection = proxySubConnectionId;
        }
    }

    /**
     * @param connectionStateListener
     */
    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connectionStateListeners.add ( connectionStateListener );
        currentConnection ().addConnectionStateListener ( connectionStateListener );
    }

    /**
     * @return name of currently active connection
     */
    public ProxySubConnectionId getCurrentConnection ()
    {
        return this.currentConnection;
    }

    /**
     * @return item prefix for this proxy, which will replace original prefix
     */
    public ProxyPrefixName getPrefix ()
    {
        return this.prefix;
    }

    /**
     * @return all available items which are already subscribed
     */
    public Map<String, ProxyDataItem> getRegisteredItems ()
    {
        return this.registeredItems;
    }

    /**
     * @return separator which separates prefix from rest of item name
     */
    public String getSeparator ()
    {
        return this.hive.getSeparator ();
    }

    /**
     * @return map with all added subconnections
     */
    public Map<ProxySubConnectionId, ProxySubConnection> getSubConnections ()
    {
        return this.subConnections;
    }

    /**
     * @return time how long proxy should wait if subconnection is lost,
     *         before item is set on error
     */
    public int getWait ()
    {
        return this.wait;
    }

    /**
     * @param itemId
     * @return original item id
     */
    public String convertToOriginalId ( final String itemId )
    {
        return ProxyUtils.originalItemId ( itemId, this.hive.getSeparator (), getPrefix (), currentSubConnection ().getPrefix () );
    }

    /**
     * @param itemId
     *            the item id to convert (from the original source)
     * @return return name of item in proxy or <code>null</code> if the item
     *         does not match the proxy group
     */
    public String convertToProxyId ( final String itemId )
    {
        if ( ProxyUtils.isOriginalItemForProxyGroup ( itemId, this.hive.getSeparator (), currentSubConnection ().getPrefix () ) )
        {
            return ProxyUtils.proxyItemId ( itemId, this.hive.getSeparator (), getPrefix (), currentSubConnection ().getPrefix () );
        }
        return null;
    }

    /**
     * 
     */
    public void disconnectCurrentConnection ()
    {
        currentSubConnection ().disconnect ();
    }

    /**
     * 
     */
    public void connectCurrentConnection ()
    {
        currentSubConnection ().connect ();
    }

    /**
     * @param id
     * @return creates item and puts it in map
     */
    public ProxyDataItem realizeItem ( final String id )
    {
        synchronized ( this.realizeMutex )
        {
            ProxyDataItem item = this.registeredItems.get ( id );
            if ( item == null )
            {
                // create actual item
                final ProxyValueHolder pvh = new ProxyValueHolder ( this.hive.getSeparator (), getPrefix (), getCurrentConnection (), id );
                final ProxyWriteHandler pwh = new ProxyWriteHandlerImpl ( this.hive.getSeparator (), getPrefix (), getSubConnections (), getCurrentConnection (), id );
                item = new ProxyDataItem ( id, pvh, pwh, this.hive.getOperationService () );
                this.registeredItems.put ( id, item );

                setUpItem ( item, id );
            }
            return item;
        }
    }

    private void setUpItem ( final ProxyDataItem item, final String requestId )
    {
        // add to storage
        this.registeredItemsStorage.added ( new ItemDescriptor ( item, new MapBuilder<String, Variant> ().getMap () ) );

        // hook up item
        for ( final ProxySubConnection subConnection : getSubConnections ().values () )
        {
            final ItemManager itemManager = subConnection.getItemManager ();
            final String originalItemId = ProxyUtils.originalItemId ( requestId, this.hive.getSeparator (), getPrefix (), subConnection.getPrefix () );

            itemManager.addItemUpdateListener ( originalItemId, new ProxyItemUpdateListener ( this.itemListenerExecutor, item, subConnection ) );
        }
    }

    /**
     * @param connectionStateListener
     */
    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.connectionStateListeners.remove ( connectionStateListener );
        currentConnection ().removeConnectionStateListener ( connectionStateListener );
    }

    /**
     * @param prefix
     */
    public void setPrefix ( final ProxyPrefixName prefix )
    {
        this.prefix = prefix;
    }

    /**
     * @param wait
     */
    public void setWait ( final int wait )
    {
        this.wait = wait;
    }

    /**
     * @param newConnectionId
     */
    public void switchTo ( final ProxySubConnectionId newConnectionId )
    {
        logger.warn ( "Switching from '{}' to '{}'", this.currentConnection, newConnectionId );

        boolean locked = false;
        try
        {
            locked = this.switchLock.tryLock ( Integer.getInteger ( "org.eclipse.scada.da.server.proxy.switchLockTimeout", 2000 ), TimeUnit.MILLISECONDS );
        }
        catch ( final InterruptedException e )
        {
            logger.warn ( String.format ( "Failed switching from '%s' to '%s'. Got interrupted while waiting!", this.currentConnection, newConnectionId ), e );
            return;
        }

        if ( !locked )
        {
            logger.warn ( "Failed switching from '{]' to '{}'. Switching is still in progress!", this.currentConnection, newConnectionId );
            return;
        }

        try
        {
            // remove 
            for ( final ConnectionStateListener listener : this.connectionStateListeners )
            {
                currentConnection ().removeConnectionStateListener ( listener );
            }

            for ( final ProxyDataItem proxyDataItem : this.registeredItems.values () )
            {
                proxyDataItem.getProxyValueHolder ().switchTo ( newConnectionId );
            }
            this.currentConnection = newConnectionId;
            for ( final ConnectionStateListener listener : this.connectionStateListeners )
            {
                currentConnection ().addConnectionStateListener ( listener );
            }

            // create the proxy folder
            createProxyFolder ();
        }
        finally
        {
            logger.info ( "Release switch lock" );
            this.switchLock.unlock ();
        }

    }

    private void destroyProxyFolder ()
    {
        // remove old folder
        if ( this.proxyFolder != null )
        {
            this.connectionFolder.remove ( this.proxyFolder );
            this.proxyFolder = null;
        }
    }

    private void createProxyFolder ()
    {
        // add new folder
        destroyProxyFolder ();

        this.proxyFolder = new ProxyFolder ( currentSubConnection ().getFolderManager (), this, new Location () );

        this.connectionFolder.add ( "items", this.proxyFolder, null );
    }

}
