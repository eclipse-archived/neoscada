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
package org.eclipse.scada.da.server.proxy.item;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 *
 */
public class ProxyValueHolder extends ProxyItemSupport
{

    private final static Logger logger = LoggerFactory.getLogger ( ProxyValueHolder.class );

    protected final Map<ProxySubConnectionId, DataItemValue.Builder> values = new HashMap<ProxySubConnectionId, DataItemValue.Builder> ();

    protected ItemUpdateListener listener = null;

    /**
     * @param currentConnection
     */
    public ProxyValueHolder ( final String separator, final ProxyPrefixName prefix, final ProxySubConnectionId currentConnection, final String itemId )
    {
        super ( separator, prefix, currentConnection, itemId );
    }

    @Override
    public void switchTo ( final ProxySubConnectionId newConnection )
    {
        synchronized ( this )
        {
            final DataItemValue.Builder oldData = getItemValue ( this.currentConnection );
            final DataItemValue.Builder newData = getItemValue ( newConnection );

            if ( !oldData.equals ( newData ) )
            {
                if ( newData.getValue () != null && !newData.getValue ().equals ( oldData.getValue () ) )
                {
                    this.listener.notifyDataChange ( newData.getValue (), newData.getAttributes (), true );
                }
                else if ( newData.getAttributes () != null && !newData.getAttributes ().equals ( oldData.getAttributes () ) )
                {
                    this.listener.notifyDataChange ( newData.getValue (), newData.getAttributes (), true );
                }
            }
            super.switchTo ( newConnection );
        }
    }

    /**
     * @param connection
     * @param value
     * @param attributes
     * @param mode
     */
    public void updateData ( final ProxySubConnectionId connection, final Variant value, final Map<String, Variant> attributes, final AttributeMode mode )
    {
        try
        {
            handleUpdateData ( connection, value, attributes, mode );
        }
        catch ( final Throwable e )
        {
            logger.error ( String.format ( "Failed to update data of item '%s'", this.proxyItemId ), e );
        }
    }

    /**
     * Wrap the event of data updates
     * @param connection the connection on which the even occurred
     * @param value the new value
     * @param attributes the new attributes
     * @param mode the attribute mode
     */
    private void handleUpdateData ( final ProxySubConnectionId connection, final Variant value, final Map<String, Variant> attributes, AttributeMode mode )
    {
        final DataItemValue.Builder div;
        final boolean doSend;

        synchronized ( this )
        {
            boolean changed = false;
            div = getItemValue ( connection );

            if ( value != null && !div.getValue ().equals ( value ) )
            {
                div.setValue ( value );
                changed = true;
            }
            if ( attributes != null )
            {
                if ( mode == null )
                {
                    mode = AttributeMode.UPDATE;
                }

                final Map<String, Variant> diff = new HashMap<String, Variant> ();
                if ( mode == AttributeMode.SET )
                {
                    AttributesHelper.set ( div.getAttributes (), attributes, diff );
                }
                else
                {
                    AttributesHelper.mergeAttributes ( div.getAttributes (), attributes, diff );
                }
                changed = changed || !diff.isEmpty ();
            }

            // check if we should send changes directly
            doSend = connection.equals ( this.currentConnection );
        }

        // now send outside of sync
        if ( doSend )
        {
            this.listener.notifyDataChange ( value, attributes, false );
        }
    }

    /**
     * must be called synchronized
     * @param id if the connection
     * @return the data item value for this connection
     */
    protected DataItemValue.Builder getItemValue ( final ProxySubConnectionId id )
    {
        DataItemValue.Builder div = this.values.get ( id );
        if ( div == null )
        {
            logger.debug ( "Creating item value for {} on connection {}", this.proxyItemId, id.getName () );

            // if the value holder is not set up to know .. create one
            this.values.put ( id, div = new DataItemValue.Builder () );
        }
        return div;
    }

    /**
     * @return return current attribs
     */
    public Map<String, Variant> getAttributes ()
    {
        final DataItemValue.Builder div = this.values.get ( this.currentConnection );
        return div.getAttributes ();
    }

    /**
     * @return return current value
     */
    public Variant getValue ()
    {
        final DataItemValue.Builder div = this.values.get ( this.currentConnection );
        return div.getValue ();
    }

    /**
     * @param listener
     */
    public void setListener ( final ItemUpdateListener listener )
    {
        this.listener = listener;
    }

    /**
     * @param connection
     * @param subscriptionState
     * @param subscriptionError
     */
    public void updateSubscriptionState ( final ProxySubConnectionId connection, final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        try
        {
            handleUpdateSubscriptionChange ( connection, subscriptionState, subscriptionError );
        }
        catch ( final Throwable e )
        {
            logger.error ( String.format ( "Failed to change subscription state of item '%s'", this.proxyItemId ), e );
        }
    }

    /**
     * Handle the actual subscription change and wrap the call
     * @param connection the connection that changed 
     * @param subscriptionState the new state
     * @param subscriptionError the optional error
     */
    private void handleUpdateSubscriptionChange ( final ProxySubConnectionId connection, final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        final boolean doSend;

        synchronized ( this )
        {
            final DataItemValue.Builder div = getItemValue ( connection );
            div.setSubscriptionState ( subscriptionState );
            div.setSubscriptionError ( subscriptionError );
            doSend = connection.equals ( this.currentConnection );
        }

        if ( doSend )
        {
            this.listener.notifySubscriptionChange ( subscriptionState, subscriptionError );
        }
    }

    public DataItemValue getCurrentValue ()
    {
        return this.values.get ( this.currentConnection ).build ();
    }
}
