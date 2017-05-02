/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemManagerImpl implements ConnectionStateListener, ItemManager
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemManagerImpl.class );

    protected org.eclipse.scada.da.client.Connection connection;

    private final Map<String, ItemSyncController> itemListeners = new HashMap<String, ItemSyncController> ();

    private boolean connected;

    /**
     * Create a new item manager.
     * <p>
     * Only one item manager should be created per connection since the item
     * manager acquires the listeners for data items using
     * {@link Connection#setItemUpdateListener(String, ItemUpdateListener)}
     * which directs all further updates to this item manager an disconnects all
     * other item managers. So item managers should be shared.
     * </p>
     * 
     * @param connection
     *            the new connection to use for this item manager
     */
    public ItemManagerImpl ( final org.eclipse.scada.da.client.Connection connection )
    {
        super ();
        this.connection = connection;

        synchronized ( this )
        {
            this.connection.addConnectionStateListener ( this );
            this.connected = this.connection.getState () == ConnectionState.BOUND;
        }
    }

    public Executor getExecutor ()
    {
        // we don't cache the executor since it might change on the connection
        return this.connection.getExecutor ();
    }

    /**
     * Get the current assigned connection
     * 
     * @return the current connection or <code>null</code> if none is assigned.
     */
    public Connection getConnection ()
    {
        return this.connection;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.client.ItemManager#addItemUpdateListener(java.lang.String, org.eclipse.scada.da.client.ItemUpdateListener)
     */
    @Override
    public synchronized void addItemUpdateListener ( final String itemName, final ItemUpdateListener listener )
    {
        logger.debug ( "Adding item update listener - itemId: {}, listener: {}", itemName, listener );

        ItemSyncController controller = this.itemListeners.get ( itemName );
        if ( controller == null )
        {
            controller = new ItemSyncController ( this.connection, this, itemName );
            this.itemListeners.put ( itemName, controller );
        }
        controller.add ( listener );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.client.ItemManager#removeItemUpdateListener(java.lang.String, org.eclipse.scada.da.client.ItemUpdateListener)
     */
    @Override
    public synchronized void removeItemUpdateListener ( final String itemName, final ItemUpdateListener listener )
    {
        logger.debug ( "Removing item update listener - itemId: {}, listener: {}", itemName, listener );

        if ( itemName == null )
        {
            return;
        }

        final ItemSyncController controller = this.itemListeners.get ( itemName );
        if ( controller != null )
        {
            controller.remove ( listener );
        }
    }

    /**
     * Synchronized all items that are currently known
     */
    protected synchronized void resyncAllItems ()
    {
        logger.debug ( "Syncing all items ({})", this.itemListeners.size () );

        for ( final Map.Entry<String, ItemSyncController> entry : this.itemListeners.entrySet () )
        {
            entry.getValue ().sync ( true );
        }

        logger.debug ( "re-sync complete" );
    }

    protected synchronized void disconnectAllItems ()
    {
        logger.debug ( "Disconnecting all items" );

        for ( final Map.Entry<String, ItemSyncController> entry : this.itemListeners.entrySet () )
        {
            entry.getValue ().disconnect ();
        }

        logger.debug ( "Disconnecting all items: complete" );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.client.ItemManager#stateChange(org.eclipse.scada.core.client.Connection, org.eclipse.scada.core.client.ConnectionState, java.lang.Throwable)
     */
    @Override
    public synchronized void stateChange ( final org.eclipse.scada.core.client.Connection connection, final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case BOUND:
                if ( !this.connected )
                {
                    resyncAllItems ();
                    this.connected = true;
                }
                break;
            default:
                if ( this.connected )
                {
                    disconnectAllItems ();
                    this.connected = false;
                }
                break;
        }
    }

}
