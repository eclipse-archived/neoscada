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
package org.eclipse.scada.ae.client;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ae.client.internal.EventSyncController;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;

public class EventManager implements ConnectionStateListener
{
    private final Connection connection;

    private boolean connected;

    private final Map<String, EventSyncController> eventListeners = new HashMap<String, EventSyncController> ();

    public EventManager ( final Connection connection )
    {
        super ();
        if ( connection == null )
        {
            throw new IllegalArgumentException ( "connection is null" );
        }
        this.connection = connection;

        synchronized ( this )
        {
            this.connection.addConnectionStateListener ( this );
            this.connected = this.connection.getState () == ConnectionState.BOUND;
        }
    }

    @Override
    public void stateChange ( final org.eclipse.scada.core.client.Connection connection, final ConnectionState state, final Throwable error )
    {
        switch ( state )
        {
            case BOUND:
                if ( !this.connected )
                {
                    this.connected = true;
                }
                break;
            case CLOSED:
                for ( final EventSyncController controller : this.eventListeners.values () )
                {
                    controller.dispose ();
                }
                this.eventListeners.clear ();
                //$FALL-THROUGH$
            default:
                if ( this.connected )
                {
                    this.connected = false;
                }
                break;
        }
    }

    public synchronized void addEventListener ( final String id, final EventListener listener )
    {
        EventSyncController eventSyncController = this.eventListeners.get ( id );
        if ( eventSyncController == null )
        {
            eventSyncController = new EventSyncController ( this.connection, id );
            this.eventListeners.put ( id, eventSyncController );
        }
        eventSyncController.addListener ( listener );
    }

    public synchronized void removeEventListener ( final String id, final EventListener listener )
    {
        final EventSyncController eventSyncController = this.eventListeners.get ( id );
        if ( eventSyncController == null )
        {
            return;
        }
        eventSyncController.removeListener ( listener );
    }

    public boolean isConnected ()
    {
        return this.connected;
    }
}
