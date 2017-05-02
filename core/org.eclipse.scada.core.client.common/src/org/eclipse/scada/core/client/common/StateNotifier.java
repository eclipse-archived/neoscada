/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.client.common;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.client.ConnectionStateListener;

public class StateNotifier
{
    private volatile boolean disposed;

    private final ExecutorService executor;

    private final AtomicReference<Set<ConnectionStateListener>> connectionStateListeners = new AtomicReference<Set<ConnectionStateListener>> ( Collections.<ConnectionStateListener> emptySet () );

    private final Connection connection;

    public StateNotifier ( final ExecutorService executor, final Connection connection )
    {
        this.executor = executor;
        this.connection = connection;
    }

    public void fireConnectionStateChange ( final ConnectionState connectionState, final Throwable error )
    {
        if ( this.disposed )
        {
            return;
        }

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                doFireConnectionStateChange ( connectionState, error );
            };
        } );
    }

    protected void doFireConnectionStateChange ( final ConnectionState connectionState, final Throwable error )
    {
        if ( this.disposed )
        {
            return;
        }

        final Set<ConnectionStateListener> listeners = this.connectionStateListeners.get ();
        for ( final ConnectionStateListener listener : listeners )
        {
            listener.stateChange ( this.connection, connectionState, error );
        }
    }

    public void addConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        Set<ConnectionStateListener> update;
        Set<ConnectionStateListener> expect;
        do
        {
            expect = this.connectionStateListeners.get ();
            update = new LinkedHashSet<ConnectionStateListener> ( this.connectionStateListeners.get () );
            update.add ( connectionStateListener );
        } while ( !this.connectionStateListeners.compareAndSet ( expect, update ) );
    }

    public void removeConnectionStateListener ( final ConnectionStateListener connectionStateListener )
    {
        Set<ConnectionStateListener> update;
        Set<ConnectionStateListener> expect;
        do
        {
            expect = this.connectionStateListeners.get ();
            update = new LinkedHashSet<ConnectionStateListener> ( this.connectionStateListeners.get () );
            update.remove ( connectionStateListener );
        } while ( !this.connectionStateListeners.compareAndSet ( expect, update ) );
    }

    public void dispose ()
    {
        this.disposed = true;
    }

}
