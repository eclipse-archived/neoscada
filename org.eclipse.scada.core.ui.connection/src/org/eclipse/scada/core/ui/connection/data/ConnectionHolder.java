/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.data;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.data.ConnectionManager.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHolder extends AbstractPropertyChange implements ConnectionStateListener, IAdaptable
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionHolder.class );

    public static final String PROP_CONNECTION_SERVICE = "connectionService";

    public static final String PROP_CONNECTION_STATE = "connectionState";

    public static final String PROP_CONNECTION_ERROR = "connectionError";

    private final ConnectionDescriptor info;

    private final ConnectionDiscovererBean discoverer;

    private volatile ConnectionService connectionService;

    private volatile ConnectionState connectionState;

    private Throwable connectionError;

    private Entry entry;

    public ConnectionHolder ( final ConnectionDiscovererBean discoverer, final ConnectionDescriptor info )
    {
        this.info = info;
        this.discoverer = discoverer;

        createConnection ();
    }

    private synchronized void createConnection ()
    {
        this.entry = Activator.getDefaultConectionManager ().getConnection ( this.info );
        if ( this.entry != null )
        {
            this.entry.getConnectionService ().getConnection ().addConnectionStateListener ( this );

            setConnectionService ( this.entry.getConnectionService () );
            setConnectionState ( ConnectionState.CLOSED );
            setConnectionError ( null );
        }
    }

    private synchronized void destroyConnection ()
    {
        if ( this.entry != null )
        {
            this.entry.getConnectionService ().getConnection ().removeConnectionStateListener ( this );
            this.entry.dispose ();
        }
        setConnectionService ( null );
        setConnectionState ( null );
        setConnectionError ( null );
    }

    public synchronized void connect ()
    {
        if ( this.connectionService != null )
        {
            this.connectionService.connect ();
        }
    }

    public synchronized void disconnect ()
    {
        if ( this.connectionService != null )
        {
            this.connectionService.disconnect ();
        }
    }

    public ConnectionDiscovererBean getDiscoverer ()
    {
        return this.discoverer;
    }

    @Override
    public String toString ()
    {
        return this.info.toString ();
    }

    public void dispose ()
    {
        destroyConnection ();
    }

    public ConnectionService getConnectionService ()
    {
        return this.connectionService;
    }

    public ConnectionDescriptor getConnectionInformation ()
    {
        return this.info;
    }

    public ConnectionState getConnectionState ()
    {
        return this.connectionState;
    }

    protected void setConnectionState ( final ConnectionState connectionState )
    {
        final ConnectionState oldConnectionState = this.connectionState;
        this.connectionState = connectionState;
        firePropertyChange ( PROP_CONNECTION_STATE, oldConnectionState, connectionState );
    }

    public Throwable getConnectionError ()
    {
        return this.connectionError;
    }

    protected void setConnectionService ( final ConnectionService connectionService )
    {
        final ConnectionService oldConnectionService = connectionService;
        this.connectionService = connectionService;
        firePropertyChange ( PROP_CONNECTION_SERVICE, oldConnectionService, connectionService );
    }

    protected void setConnectionError ( final Throwable connectionError )
    {
        final Throwable oldConnectionError = connectionError;
        this.connectionError = connectionError;
        firePropertyChange ( PROP_CONNECTION_ERROR, oldConnectionError, connectionError );
    }

    @Override
    public void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        logger.debug ( "Connection state changed: {}", state );

        setConnectionState ( state );
        setConnectionError ( error );
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        logger.debug ( "Adapting: {}", adapter );

        if ( adapter == ConnectionService.class )
        {
            return this.connectionService;
        }
        else if ( adapter == IPropertySource.class )
        {
            return new PropertySourceWrapper ( this );
        }
        return null;
    }

    public void setConnectCallbackHandler ( final CallbackHandler callbackHandler )
    {
        if ( this.connectionService != null )
        {
            this.connectionService.setConnectCallbackHandler ( callbackHandler );
        }
    }

    public void connect ( final DisplayCallbackHandler callbackHandler )
    {
        setConnectCallbackHandler ( callbackHandler );
        connect ();
    }
}
