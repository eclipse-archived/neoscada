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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class DiscovererListener
{
    private final ConnectionDiscovererBean connectionDiscoverer;

    private final ISetChangeListener setListener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            DiscovererListener.this.handleSetChange ( event.diff );
        }

    };

    private final ConnectionPoolManager poolManager;

    public DiscovererListener ( final ConnectionDiscovererBean connectionDiscoverer, final ConnectionPoolManager poolManager )
    {
        this.connectionDiscoverer = connectionDiscoverer;
        this.poolManager = poolManager;

        connectionDiscoverer.getKnownConnections ().addSetChangeListener ( this.setListener );
        handleSetChange ( Diffs.createSetDiff ( connectionDiscoverer.getKnownConnections (), Collections.emptySet () ) );
    }

    protected void handleSetChange ( final SetDiff diff )
    {
        final Set<ConnectionDescriptor> additions = new HashSet<ConnectionDescriptor> ( diff.getAdditions ().size () );
        final Set<ConnectionDescriptor> removals = new HashSet<ConnectionDescriptor> ( diff.getRemovals ().size () );

        for ( final Object o : diff.getAdditions () )
        {
            if ( o instanceof ConnectionHolder )
            {
                additions.add ( ( (ConnectionHolder)o ).getConnectionInformation () );
            }
        }

        for ( final Object o : diff.getRemovals () )
        {
            if ( o instanceof ConnectionHolder )
            {
                removals.add ( ( (ConnectionHolder)o ).getConnectionInformation () );
            }
        }

        this.poolManager.handleChange ( this, additions, removals );
    }

    public void dispose ()
    {
        this.connectionDiscoverer.getKnownConnections ().removeSetChangeListener ( this.setListener );
        handleSetChange ( Diffs.createSetDiff ( Collections.emptySet (), this.connectionDiscoverer.getKnownConnections () ) );
    }

    public IObservableSet getConnections ()
    {
        return this.connectionDiscoverer.getKnownConnections ();
    }

}
