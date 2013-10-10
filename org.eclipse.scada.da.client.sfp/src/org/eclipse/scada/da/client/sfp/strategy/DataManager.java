/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp.strategy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.sfp.ConnectionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataManager
{

    private final static Logger logger = LoggerFactory.getLogger ( DataManager.class );

    private final ConnectionHandler connectionHandler;

    private final Map<String, ItemUpdateListener> itemListeners = new HashMap<String, ItemUpdateListener> ();

    private final Map<Integer, DataItemValue> cache = new HashMap<> ();

    private final Map<Integer, String> registerMap = new HashMap<> ();

    private final Map<String, Integer> itemIdMap = new HashMap<> ();

    private final Set<String> activeSet = new HashSet<> ();

    public DataManager ( final ConnectionHandler connectionHandler )
    {
        this.connectionHandler = connectionHandler;
    }

    /**
     * Find the register number from an item id
     * 
     * @param itemId
     *            the item id to look up
     * @return the register number or <code>null</code> if none was found
     */
    public Integer findRegister ( final String itemId )
    {
        return this.itemIdMap.get ( itemId );
    }

    public void updateData ( final int registerNumber, final DataItemValue value )
    {
        logger.debug ( "Update data - registerNumer: {}, value: {}", registerNumber, value );

        final DataItemValue oldValue = this.cache.get ( registerNumber );

        this.cache.put ( registerNumber, value );
        final String itemId = this.registerMap.get ( registerNumber );

        final ItemUpdateListener listener = this.itemListeners.get ( itemId );
        logger.debug ( "Listener: {}, active: {}", listener, this.activeSet.contains ( itemId ) );

        if ( listener == null || !this.activeSet.contains ( itemId ) )
        {
            // no body is interested in this value
            return;
        }

        if ( oldValue != null )
        {
            final Variant valueChange;
            if ( !oldValue.getValue ().equals ( value.getValue () ) )
            {
                valueChange = value.getValue ();
            }
            else
            {
                valueChange = null;
            }

            final Map<String, Variant> attributesChange = AttributesHelper.diff ( oldValue.getAttributes (), value.getAttributes () );

            execute ( new Runnable () {

                @Override
                public void run ()
                {
                    if ( oldValue.getSubscriptionState () != SubscriptionState.CONNECTED )
                    {
                        listener.notifySubscriptionChange ( SubscriptionState.CONNECTED, null );
                    }
                    listener.notifyDataChange ( valueChange, attributesChange.isEmpty () ? null : attributesChange, false );
                }
            } );
        }
        else
        {
            execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( SubscriptionState.CONNECTED, null );
                    listener.notifyDataChange ( value.getValue (), value.getAttributes (), false );
                }
            } );
        }
    }

    public void removeRegister ( final int registerNumber )
    {
        final String oldItemId = this.registerMap.remove ( registerNumber );
        if ( oldItemId != null )
        {
            this.itemIdMap.remove ( oldItemId );
        }

        final DataItemValue oldValue = this.cache.remove ( registerNumber );

        if ( oldValue == null )
        {
            return;
        }

        final ItemUpdateListener listener = this.itemListeners.get ( oldItemId );
        if ( listener == null )
        {
            // no body is interested in this value
            return;
        }

        execute ( new Runnable () {
            @Override
            public void run ()
            {
                listener.notifySubscriptionChange ( SubscriptionState.GRANTED, null );
            };
        } );
    }

    public void dispose ()
    {
        for ( final ItemUpdateListener listener : this.itemListeners.values () )
        {
            execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( SubscriptionState.DISCONNECTED, null );
                }
            } );
        }
        this.itemListeners.clear ();
    }

    public void setItemUpateListener ( final String itemId, final ItemUpdateListener listener )
    {
        if ( listener != null )
        {
            this.itemListeners.put ( itemId, listener );
        }
        else
        {
            this.itemListeners.remove ( itemId );
        }
    }

    public void setAllItemListeners ( final Map<String, ItemUpdateListener> itemListeners )
    {
        for ( final Map.Entry<String, ItemUpdateListener> entry : itemListeners.entrySet () )
        {
            setItemUpateListener ( entry.getKey (), entry.getValue () );
        }
    }

    protected void execute ( final Runnable command )
    {
        this.connectionHandler.getExecutor ().execute ( command );
    }

    public void addMapping ( final int register, final String itemId, final String unit )
    {
        logger.debug ( "Adding mapping - register: {}, itemId: {}", register, itemId );

        this.registerMap.put ( register, itemId );
        this.itemIdMap.put ( itemId, register );

        final DataItemValue value = this.cache.get ( register );
        final ItemUpdateListener listener = this.itemListeners.get ( itemId );
        if ( listener != null && value != null && this.activeSet.contains ( itemId ) )
        {
            logger.debug ( "Sending last known state" );

            execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.notifySubscriptionChange ( SubscriptionState.CONNECTED, null );
                    listener.notifyDataChange ( value.getValue (), value.getAttributes (), true );
                };
            } );
        }
    }

    public void removeMapping ( final String itemId )
    {
        final Integer registerNumber = this.itemIdMap.remove ( itemId );
        if ( registerNumber != null )
        {
            this.registerMap.remove ( registerNumber );
        }

        fireSubscriptionChange ( itemId, SubscriptionState.GRANTED );
    }

    protected void fireSubscriptionChange ( final String itemId, final SubscriptionState state )
    {
        final ItemUpdateListener listener = this.itemListeners.get ( itemId );

        if ( listener == null || !this.activeSet.contains ( itemId ) )
        {
            return;
        }

        execute ( new Runnable () {
            @Override
            public void run ()
            {
                listener.notifySubscriptionChange ( state, null );
            }
        } );
    }

    public void subscribeItem ( final String itemId )
    {
        logger.debug ( "Subscribe item: {}", itemId );

        this.activeSet.add ( itemId );

        // map to register number
        final Integer registerNumber = this.itemIdMap.get ( itemId );

        final DataItemValue value;

        if ( registerNumber != null )
        {
            value = this.cache.get ( registerNumber );
        }
        else
        {
            value = null;
        }

        final ItemUpdateListener listener = this.itemListeners.get ( itemId );
        if ( listener == null )
        {
            return;
        }

        final ConnectionState state = this.connectionHandler.getConnectionState ();

        execute ( new Runnable () {

            @Override
            public void run ()
            {
                if ( state != ConnectionState.BOUND )
                {
                    listener.notifySubscriptionChange ( SubscriptionState.DISCONNECTED, null );
                }
                else if ( value != null )
                {
                    listener.notifySubscriptionChange ( SubscriptionState.CONNECTED, null );
                    listener.notifyDataChange ( value.getValue (), value.getAttributes (), true );
                }
                else
                {
                    listener.notifySubscriptionChange ( SubscriptionState.GRANTED, null );
                }
            }
        } );
    }

    public void unsubscribeItem ( final String itemId )
    {
        fireSubscriptionChange ( itemId, SubscriptionState.DISCONNECTED );
        this.activeSet.remove ( itemId );
    }

}
