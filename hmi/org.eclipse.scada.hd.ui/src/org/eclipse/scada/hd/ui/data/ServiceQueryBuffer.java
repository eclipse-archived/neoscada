/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.data;

import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.eclipse.scada.core.connection.provider.ConnectionRequestTracker;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.core.connection.provider.ConnectionTracker;
import org.eclipse.scada.core.connection.provider.ConnectionTracker.Listener;
import org.eclipse.scada.hd.data.QueryParameters;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A query buffer based on a tracked connection service
 * <p>
 * The query buffer must the opened using the {@link #open()} call.
 * </p>
 * 
 * @author Jens Reimann
 */
public class ServiceQueryBuffer extends AbstractQueryBuffer
{

    private final static Logger logger = LoggerFactory.getLogger ( ServiceQueryBuffer.class );

    private final ConnectionTracker tracker;

    private org.eclipse.scada.hd.connection.provider.ConnectionService connection;

    private final Listener listener = new Listener () {

        @Override
        public void setConnection ( final ConnectionService connectionService )
        {
            ServiceQueryBuffer.this.setConnection ( connectionService );
        }
    };

    private final ConnectionStateListener connectionStateListener = new ConnectionStateListener () {

        @Override
        public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
        {
            handleConnectionStateChange ( connection, state, error );
        }
    };

    public ServiceQueryBuffer ( final BundleContext context, final ConnectionRequest connectionRequest, final String itemId, final QueryParameters initialRequestParameters )
    {
        super ( itemId );

        setRequestParameters ( initialRequestParameters );

        this.tracker = new ConnectionRequestTracker ( context, connectionRequest, this.listener, org.eclipse.scada.hd.connection.provider.ConnectionService.class );
    }

    public ServiceQueryBuffer ( final BundleContext context, final String connectionId, final String itemId, final QueryParameters initialRequestParameters )
    {
        super ( itemId );

        setRequestParameters ( initialRequestParameters );

        this.tracker = new ConnectionIdTracker ( context, connectionId, this.listener, org.eclipse.scada.hd.connection.provider.ConnectionService.class );
    }

    public void open ()
    {
        this.tracker.open ();
    }

    @Override
    public void close ()
    {
        super.close ();
        this.tracker.close ();
        detachConnection ();
    }

    protected void setConnection ( final ConnectionService connectionService )
    {
        logger.debug ( "Setting connection: {}", connectionService );

        detachConnection ();
        if ( connectionService != null )
        {
            attachConnection ( connectionService );
        }
    }

    private void attachConnection ( final ConnectionService connectionService )
    {
        if ( connectionService == null )
        {
            return;
        }
        if ( ! ( connectionService instanceof org.eclipse.scada.hd.connection.provider.ConnectionService ) )
        {
            return;
        }

        this.connection = (org.eclipse.scada.hd.connection.provider.ConnectionService)connectionService;
        this.connection.getConnection ().addConnectionStateListener ( this.connectionStateListener );

        final org.eclipse.scada.hd.client.Connection c = this.connection.getConnection ();
        // initial call
        handleConnectionStateChange ( c, c.getState (), null );
    }

    private void detachConnection ()
    {
        if ( this.connection == null )
        {
            return;
        }
        this.connection.getConnection ().removeConnectionStateListener ( this.connectionStateListener );
        this.connection = null;
    }

    protected void handleConnectionStateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        logger.debug ( "Handle connection state change - connection: {}, state: {}", connection, state );
        if ( state == ConnectionState.BOUND )
        {
            createQuery ( this.connection.getConnection (), this.itemId );
        }
        else
        {
            closeQuery ();
        }
    }

}
