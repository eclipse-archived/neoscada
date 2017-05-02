/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class ConnectionPoolManager
{

    private final WritableSet connectionHolders;

    private final Map<ConnectionDescriptor, Set<DiscovererListener>> descriptorMap = new HashMap<ConnectionDescriptor, Set<DiscovererListener>> ();

    private final Map<ConnectionDescriptor, ConnectionHolder> holderMap = new HashMap<ConnectionDescriptor, ConnectionHolder> ();

    public ConnectionPoolManager ( final Realm realm )
    {
        this.connectionHolders = new WritableSet ( realm );
    }

    public void dispose ()
    {
        this.connectionHolders.clear ();
        this.connectionHolders.dispose ();
    }

    /**
     * Get an observable set containing {@link ConnectionHolder} instances
     * 
     * @return an observable set containing {@link ConnectionHolder} instances
     */
    public IObservableSet getAllConnections ()
    {
        return this.connectionHolders;
    }

    public void handleChange ( final DiscovererListener discovererListener, final Set<ConnectionDescriptor> additions, final Set<ConnectionDescriptor> removals )
    {
        this.connectionHolders.getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                applyChange ( discovererListener, additions, removals );
            }
        } );
    }

    private void applyChange ( final DiscovererListener discovererListener, final Set<ConnectionDescriptor> additions, final Set<ConnectionDescriptor> removals )
    {
        for ( final ConnectionDescriptor desc : removals )
        {
            remove ( discovererListener, desc );
        }
        for ( final ConnectionDescriptor desc : additions )
        {
            add ( discovererListener, desc );
        }
    }

    private void add ( final DiscovererListener discovererListener, final ConnectionDescriptor desc )
    {
        Set<DiscovererListener> listeners = this.descriptorMap.get ( desc );
        if ( listeners == null )
        {
            listeners = new HashSet<DiscovererListener> ();
            this.descriptorMap.put ( desc, listeners );

            final ConnectionHolder holder = new ConnectionHolder ( null, desc );
            this.holderMap.put ( desc, holder );
            this.connectionHolders.add ( holder );
        }
        listeners.add ( discovererListener );
    }

    private void remove ( final DiscovererListener discovererListener, final ConnectionDescriptor desc )
    {
        final Set<DiscovererListener> listeners = this.descriptorMap.get ( desc );
        if ( listeners == null )
        {
            return;
        }

        listeners.remove ( discovererListener );
        if ( listeners.isEmpty () )
        {
            this.descriptorMap.remove ( desc );
            final ConnectionHolder holder = this.holderMap.remove ( desc );
            if ( holder != null )
            {
                this.connectionHolders.remove ( holder );
                holder.dispose ();
            }
        }
    }

}
