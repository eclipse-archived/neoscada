/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.proxy.item.ProxyDataItem;

/**
 * encapsulates notification of items in case of a connection error
 * 
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class NotifyConnectionErrorListener implements ConnectionStateListener
{
    private final ProxyGroup proxyConnection;

    private ConnectionState currentState;

    private Timer timer;

    /**
     * needs connection to iterate over registered items
     * @param proxyConnection
     */
    public NotifyConnectionErrorListener ( final ProxyGroup proxyConnection )
    {
        this.proxyConnection = proxyConnection;
    }

    /**
     * either sends connection state straight away, or schedules it for later execution
     * @see org.eclipse.scada.core.client.ConnectionStateListener#stateChange(org.eclipse.scada.core.client.Connection, org.eclipse.scada.core.client.ConnectionState, java.lang.Throwable)
     */
    @Override
    public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        this.currentState = state;
        if ( this.proxyConnection.getWait () > 0 && !ConnectionState.BOUND.equals ( state ) )
        {
            scheduleItemUpdate ( state );
        }
        else
        {
            sendConnectionState ( state );
        }
    }

    /**
     * schedules sending of connections state to registered items
     * connection state is only sent if it differs from last one
     * @param state
     */
    private void scheduleItemUpdate ( final ConnectionState state )
    {
        synchronized ( this )
        {
            if ( this.timer == null )
            {
                this.timer = new Timer ();
                this.timer.schedule ( new TimerTask () {
                    @Override
                    public void run ()
                    {
                        if ( !state.equals ( NotifyConnectionErrorListener.this.currentState ) )
                        {
                            sendConnectionState ( NotifyConnectionErrorListener.this.currentState );
                        }
                        NotifyConnectionErrorListener.this.timer = null;
                    }
                }, this.proxyConnection.getWait () );
            }
        }
    }

    /**
     * sends error attribute to all registered items 
     * @param state
     */
    private void sendConnectionState ( final ConnectionState state )
    {
        for ( final ProxyDataItem item : this.proxyConnection.getRegisteredItems ().values () )
        {
            final Map<String, Variant> attrs = new HashMap<String, Variant> ();
            if ( ConnectionState.BOUND.equals ( state ) )
            {
                attrs.put ( "proxy.error", null );
                attrs.put ( "proxy.error.message", null );
            }
            else
            {
                attrs.put ( "proxy.error", Variant.TRUE );
                attrs.put ( "proxy.error.message", Variant.valueOf ( "Underlying connection in state " + state ) );
            }
            item.updateData ( null, attrs, AttributeMode.UPDATE );
        }
    }
}
