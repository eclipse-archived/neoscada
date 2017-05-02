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
package org.eclipse.scada.core.ui.connection.views.tree.node;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.core.ui.connection.views.tree.ConnectionPoolManager;

public class GroupingNode extends GroupChildNode
{

    private final ISetChangeListener listener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            handleDiff ( event.diff );
        }
    };

    private final ConnectionPoolManager poolManager;

    private final GroupingProvider groupingProvider;

    private final Map<ConnectionDescriptor, List<String>> pathMap = new HashMap<ConnectionDescriptor, List<String>> ();

    public GroupingNode ( final Realm realm, final String name, final ConnectionPoolManager poolManager, final GroupingProvider groupingProvider )
    {
        super ( realm, name, null );

        this.poolManager = poolManager;
        this.groupingProvider = groupingProvider;

        poolManager.getAllConnections ().addSetChangeListener ( this.listener );
    }

    @Override
    public void dispose ()
    {
        this.poolManager.getAllConnections ().removeSetChangeListener ( this.listener );
        super.dispose ();
    };

    protected void handleDiff ( final SetDiff diff )
    {
        for ( final Object o : diff.getAdditions () )
        {
            final ConnectionHolder holder = (ConnectionHolder)o;
            final ConnectionDescriptor desc = holder.getConnectionInformation ();

            final List<String> path = makePath ( desc );
            addPath ( new LinkedList<String> ( path ), holder );
            this.pathMap.put ( desc, path );
        }

        for ( final Object o : diff.getRemovals () )
        {
            final ConnectionHolder holder = (ConnectionHolder)o;
            final ConnectionDescriptor desc = holder.getConnectionInformation ();

            final List<String> path = this.pathMap.get ( desc );
            if ( path != null )
            {
                removePath ( path, holder );
            }
        }
    }

    private List<String> makePath ( final ConnectionDescriptor desc )
    {
        try
        {
            return this.groupingProvider.getGroups ( desc );
        }
        catch ( final Exception e )
        {
            return Collections.emptyList ();
        }
    }
}
