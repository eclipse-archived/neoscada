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
package org.eclipse.scada.da.client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataItem extends Observable
{
    private static final String PROP_VALUE = "snapshotValue";

    private final static Logger logger = LoggerFactory.getLogger ( DataItem.class );

    private final String itemId;

    /**
     * The item manager
     */
    private ItemManager itemManager;

    /**
     * The stored item value
     */
    private volatile DataItemValue value = DataItemValue.DISCONNECTED;

    /**
     * The listener used to register with the item manager
     */
    private final ItemUpdateListener listener;

    private final PropertyChangeSupport propertySupport = new PropertyChangeSupport ( this );

    /**
     * create a new data item structure.
     * <p>
     * Note that the item is initially unconnected
     * 
     * @param itemId
     *            the id of the item to register later
     */
    public DataItem ( final String itemId )
    {
        this.itemId = itemId;

        // create the item listener
        this.listener = new ItemUpdateListener () {

            @Override
            public void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
            {
                DataItem.this.performNotifyDataChange ( value, attributes, cache );
            }

            @Override
            public void notifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
            {
                DataItem.this.performNotifySubscriptionChange ( subscriptionState, subscriptionError );
            }
        };
    }

    /**
     * create a new data item structure.
     * <p>
     * Note that the item is initially connected to the item manager provided.
     * You must call {@link #unregister()} when you want to clear the
     * subscription with the item on the server.
     * 
     * @param itemId
     *            the id of the item to register
     * @param itemManager
     *            the item manager to which the item will register
     */
    public DataItem ( final String itemId, final ItemManager itemManager )
    {
        this ( itemId );

        if ( itemManager != null )
        {
            register ( itemManager );
        }
    }

    public void register ( final ItemManager itemManager )
    {
        if ( this.itemManager == itemManager )
        {
            return;
        }
        unregister ();

        this.itemManager = itemManager;
        this.itemManager.addItemUpdateListener ( this.itemId, this.listener );
    }

    /**
     * Unregister from the currently registered item manager
     */
    public void unregister ()
    {
        final ItemManager manager = this.itemManager;

        this.itemManager = null;

        if ( manager != null )
        {
            manager.removeItemUpdateListener ( this.itemId, this.listener );
        }
    }

    protected void handlePerformNotifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        final DataItemValue.Builder newValue = new Builder ( this.value );

        if ( cache )
        {
            setChanged ();
            newValue.setAttributes ( new HashMap<String, Variant> ( attributes ) );
        }
        else
        {
            AttributesHelper.mergeAttributes ( newValue.getAttributes (), attributes );
        }

        if ( attributes != null )
        {
            setChanged ();
        }

        if ( value != null )
        {
            setChanged ();
            newValue.setValue ( value );
        }

        final DataItemValue oldValue = this.value;
        this.value = newValue.build ();

        try
        {
            notifyObservers ( this.value );
            this.propertySupport.firePropertyChange ( PROP_VALUE, oldValue, this.value );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to notify data change", e );
        }
    }

    protected void performNotifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        handlePerformNotifyDataChange ( value, attributes, cache );
    }

    protected void handlePerformNotifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        final DataItemValue.Builder newValue = new DataItemValue.Builder ( this.value );
        newValue.setSubscriptionState ( subscriptionState );
        newValue.setSubscriptionError ( subscriptionError );

        final DataItemValue oldValue = this.value;
        this.value = newValue.build ();

        setChanged ();

        try
        {
            notifyObservers ( this.value );
            this.propertySupport.firePropertyChange ( PROP_VALUE, oldValue, this.value );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to notify subscription change", e );
        }
    }

    protected void performNotifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        handlePerformNotifySubscriptionChange ( subscriptionState, subscriptionError );
    }

    /**
     * Get the complete state of the current data item in an atomic operation
     * 
     * @return the current state of the data item
     */
    public DataItemValue getSnapshotValue ()
    {
        return this.value;
    }

    /**
     * Fetch the current cached attributes.
     * <b>Note:</b> The returned object may not be modified!
     * 
     * @return the current attributes
     * @deprecated You should use {@link #getSnapshotValue()} instead to get a
     *             consistent value
     */
    @Deprecated
    public Map<String, Variant> getAttributes ()
    {
        return this.value.getAttributes ();
    }

    /**
     * Get the subscription state
     * 
     * @return the subscription state
     * @deprecated You should use {@link #getSnapshotValue()} instead to get a
     *             consistent value
     */
    @Deprecated
    public SubscriptionState getSubscriptionState ()
    {
        return this.value.getSubscriptionState ();
    }

    /**
     * Get the item ID
     * 
     * @return the item Id
     */
    public String getItemId ()
    {
        return this.itemId;
    }

    /**
     * Get the subscription error or <code>null</code> if there was none
     * 
     * @return the subscription error
     * @deprecated You should use {@link #getSnapshotValue()} instead to get a
     *             consistent value
     */
    @Deprecated
    public Throwable getSubscriptionError ()
    {
        return this.value.getSubscriptionError ();
    }

    public void addPropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.propertySupport.addPropertyChangeListener ( listener );
    }

    public void addPropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.propertySupport.addPropertyChangeListener ( propertyName, listener );
    }

    public void removePropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.propertySupport.removePropertyChangeListener ( listener );
    }

    public void removePropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.propertySupport.removePropertyChangeListener ( propertyName, listener );
    }

}
