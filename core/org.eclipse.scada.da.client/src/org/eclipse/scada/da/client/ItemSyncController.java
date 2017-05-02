/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A controller that synchronizes the subscription state for one item.
 * 
 * @author Jens Reimann <jens.reimann@th4-systems.com>
 */
public class ItemSyncController implements ItemUpdateListener
{
    private final static Logger logger = LoggerFactory.getLogger ( ItemSyncController.class );

    private final org.eclipse.scada.da.client.Connection connection;

    private final String itemId;

    private boolean subscribed;

    private Variant cachedValue = Variant.NULL;

    private final Map<String, Variant> cachedAttributes = new HashMap<String, Variant> ( 0 );

    private SubscriptionState subscriptionState = SubscriptionState.DISCONNECTED;

    private Throwable subscriptionError;

    /**
     * Holds some additional listener information
     * 
     * @author Jens Reimann
     */
    private static class ListenerInfo
    {
        private final ItemUpdateListener listener;

        public ListenerInfo ( final ItemUpdateListener listener )
        {
            this.listener = listener;
        }

        public ItemUpdateListener getListener ()
        {
            return this.listener;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( obj == null )
            {
                return false;
            }
            if ( obj == this )
            {
                return true;
            }

            if ( obj instanceof ItemUpdateListener )
            {
                return obj == this.listener;
            }
            else if ( obj instanceof ListenerInfo )
            {
                return ( (ListenerInfo)obj ).listener == this.listener;
            }
            else
            {
                return false;
            }
        }

        @Override
        public int hashCode ()
        {
            return this.listener.hashCode ();
        }
    }

    private final Map<ItemUpdateListener, ListenerInfo> listeners = new HashMap<ItemUpdateListener, ListenerInfo> ( 0 );

    private final ItemManagerImpl itemManager;

    public ItemSyncController ( final org.eclipse.scada.da.client.Connection connection, final ItemManagerImpl itemManager, final String itemId )
    {
        this.connection = connection;
        this.itemManager = itemManager;
        this.itemId = itemId;

        synchronized ( this )
        {
            this.connection.setItemUpdateListener ( this.itemId, this );
        }
    }

    public String getItemName ()
    {
        return this.itemId;
    }

    public synchronized void add ( final ItemUpdateListener listener )
    {
        if ( !this.listeners.containsKey ( listener ) )
        {
            this.listeners.put ( listener, new ListenerInfo ( listener ) );

            final SubscriptionState state = this.subscriptionState;
            final Throwable error = this.subscriptionError;
            final Variant value = this.cachedValue;
            final Map<String, Variant> attributes = new HashMap<String, Variant> ( this.cachedAttributes );

            logger.trace ( "Sending out cache values - itemId: {}, state: {}, value: {}, attributes: {}", new Object[] { this.itemId, state, value, attributes } );

            // send the initial update
            this.itemManager.getExecutor ().execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( state, error );
                    listener.notifyDataChange ( value, attributes, true );
                }
            } );

            sync ( false );
        }
    }

    public synchronized void remove ( final ItemUpdateListener listener )
    {
        final ListenerInfo result = this.listeners.remove ( listener );
        if ( result != null )
        {
            sync ( false );
        }
    }

    public synchronized void sync ( final boolean force )
    {
        final boolean subscribe = !this.listeners.isEmpty ();

        if ( this.subscribed == subscribe && !force )
        {
            // nothing to do
            return;
        }

        if ( subscribe )
        {
            subscribe ();
        }
        else
        {
            unsubscribe ();
        }
    }

    protected synchronized void subscribe ()
    {
        try
        {
            logger.debug ( "Syncing listen state: active" );
            this.subscribed = true;
            this.connection.subscribeItem ( this.itemId );
        }
        catch ( final Throwable e )
        {
            handleError ( e );
        }
    }

    protected synchronized void unsubscribe ()
    {
        try
        {
            logger.debug ( "Syncing listen state: inactive" );
            this.subscribed = false;

            this.cachedValue = null;
            this.cachedAttributes.clear ();

            notifySubscriptionChange ( SubscriptionState.DISCONNECTED, null );
            this.connection.unsubscribeItem ( this.itemId );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to handle unsubscribe", e );
        }
    }

    private synchronized void handleError ( final Throwable e )
    {
        logger.warn ( "Failed to change subscription state", e );
        this.subscribed = false;
        notifySubscriptionChange ( SubscriptionState.DISCONNECTED, e );
    }

    @Override
    public synchronized void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        boolean change = false;

        // update value
        if ( this.cachedValue == null || !this.cachedValue.equals ( value ) )
        {
            change = true;
            this.cachedValue = value;
        }

        // update attributes
        if ( attributes != null )
        {
            if ( !attributes.isEmpty () || cache )
            {
                AttributesHelper.mergeAttributes ( this.cachedAttributes, attributes, cache );
                change = true;
            }
        }

        if ( change )
        {
            final ListenerInfo[] listeners = ItemSyncController.this.listeners.values ().toArray ( new ListenerInfo[this.listeners.size ()] );

            this.itemManager.getExecutor ().execute ( new Runnable () {

                @Override
                public void run ()
                {
                    for ( final ListenerInfo listenerInfo : listeners )
                    {
                        try
                        {
                            listenerInfo.getListener ().notifyDataChange ( value, attributes, cache );
                        }
                        catch ( final Exception e )
                        {
                            logger.info ( "Failed to notify listener for data change", e );
                        }
                    }
                }
            } );
        }
    }

    @Override
    public synchronized void notifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable e )
    {
        if ( this.subscriptionState.equals ( subscriptionState ) && this.subscriptionError == e )
        {
            return;
        }

        this.subscriptionState = subscriptionState;
        this.subscriptionError = e;

        final ListenerInfo[] listeners = ItemSyncController.this.listeners.values ().toArray ( new ListenerInfo[this.listeners.size ()] );

        this.itemManager.getExecutor ().execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ListenerInfo listenerInfo : listeners )
                {
                    try
                    {
                        listenerInfo.getListener ().notifySubscriptionChange ( subscriptionState, e );
                    }
                    catch ( final Exception e )
                    {
                        logger.info ( "Failed to notify listener subscription change", e );
                    }
                }
            }
        } );

    }

    public synchronized void disconnect ()
    {
        notifySubscriptionChange ( SubscriptionState.DISCONNECTED, null );
        notifyDataChange ( Variant.NULL, Collections.<String, Variant> emptyMap (), true );
    }
}
