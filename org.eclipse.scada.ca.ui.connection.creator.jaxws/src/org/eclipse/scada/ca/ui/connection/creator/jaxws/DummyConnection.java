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
package org.eclipse.scada.ca.ui.connection.creator.jaxws;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;
import org.eclipse.scada.core.client.PrivilegeListener;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.sec.callback.CallbackFactory;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.ca.client.Connection;
import org.eclipse.scada.ca.client.FactoriesListener;

public class DummyConnection implements Connection
{

    private final ConnectionInformation connectionInformation;

    private final Set<ConnectionStateListener> listeners = new CopyOnWriteArraySet<ConnectionStateListener> ();

    public DummyConnection ( final ConnectionInformation connectionInformation )
    {
        this.connectionInformation = connectionInformation;
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public void setCallbackFactory ( final CallbackFactory callbackFactory )
    {
    }

    @Override
    public void connect ( final CallbackHandler callbackHandler )
    {
        connect ();
    }

    @Override
    public void connect ()
    {
        for ( final ConnectionStateListener csl : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    csl.stateChange ( DummyConnection.this, ConnectionState.CLOSED, new UnsupportedOperationException ( "The JAXWS protocol is no longer supported for the CA interface. Please migrate to NGP instead." ) );
                }
            } );
        }
    }

    @Override
    public void disconnect ()
    {
    }

    @Override
    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        if ( this.listeners.add ( connectionStateListener ) )
        {
            connectionStateListener.stateChange ( this, getState (), null );
        }
    }

    @Override
    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        this.listeners.remove ( connectionStateListener );
    }

    @Override
    public ConnectionState getState ()
    {
        return ConnectionState.CLOSED;
    }

    @Override
    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    @Override
    public Map<String, String> getSessionProperties ()
    {
        return Collections.emptyMap ();
    }

    @Override
    public void addFactoriesListener ( final FactoriesListener listener )
    {
    }

    @Override
    public void removeFactoriesListener ( final FactoriesListener listener )
    {
    }

    @Override
    public NotifyFuture<FactoryInformation[]> getFactories ()
    {
        return new InstantErrorFuture<FactoryInformation[]> ( new UnsupportedOperationException () );
    }

    @Override
    public NotifyFuture<FactoryInformation> getFactoryWithData ( final String factoryId )
    {
        return new InstantErrorFuture<FactoryInformation> ( new UnsupportedOperationException () );
    }

    @Override
    public NotifyFuture<ConfigurationInformation> getConfiguration ( final String factoryId, final String configurationId )
    {
        return new InstantErrorFuture<ConfigurationInformation> ( new UnsupportedOperationException () );
    }

    @Override
    public NotifyFuture<Void> applyDiff ( final List<DiffEntry> changeSet, final OperationParameters operationParameters, final CallbackHandler callbackHandler )
    {
        return new InstantErrorFuture<Void> ( new UnsupportedOperationException () );
    }

    @Override
    public void addPrivilegeListener ( final PrivilegeListener listener )
    {
    }

    @Override
    public void removePrivilegeListener ( final PrivilegeListener listener )
    {
    }

    @Override
    public Set<String> getPrivileges ()
    {
        return Collections.emptySet ();
    }

}
