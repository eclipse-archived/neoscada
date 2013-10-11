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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;
import org.eclipse.scada.core.ui.connection.views.tree.node.AllConnectionsNode;
import org.eclipse.scada.core.ui.connection.views.tree.node.GroupingNode;
import org.eclipse.scada.core.ui.connection.views.tree.node.TargetGroupingProvider;
import org.eclipse.scada.core.ui.connection.views.tree.node.UriGroupingProvider;

public class ConnectionTreeManager
{

    private final IObservableSet discoverers;

    private final ISetChangeListener listener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            handleDiff ( event.diff );
        }
    };

    private final Map<ConnectionDiscovererBean, DiscovererListener> listenerMap = new HashMap<ConnectionDiscovererBean, DiscovererListener> ();

    private final Realm realm;

    private final WritableSet treeRoot;

    private final ConnectionPoolManager poolManager;

    public ConnectionTreeManager ( final WritableSet treeRoot )
    {
        this.realm = treeRoot.getRealm ();

        this.treeRoot = treeRoot;

        this.poolManager = new ConnectionPoolManager ( this.realm );

        this.discoverers = Activator.getDefault ().getDiscovererSet ();
        this.discoverers.addSetChangeListener ( this.listener );
        handleDiff ( Diffs.createSetDiff ( this.discoverers, Collections.emptySet () ) );

        treeRoot.getRealm ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                addInitial ( treeRoot );
            }
        } );
    }

    private void addInitial ( final WritableSet treeRoot )
    {
        treeRoot.add ( new AllConnectionsNode ( this.realm, this.poolManager ) );
        treeRoot.add ( new GroupingNode ( this.realm, "By URI", this.poolManager, new UriGroupingProvider () ) );
        treeRoot.add ( new GroupingNode ( this.realm, "By Target", this.poolManager, new TargetGroupingProvider () ) );
    }

    public void dispose ()
    {
        this.realm.exec ( new Runnable () {

            @Override
            public void run ()
            {
                handleDispose ();
            }
        } );
    }

    private void handleDispose ()
    {
        this.discoverers.removeSetChangeListener ( this.listener );

        this.poolManager.dispose ();

        for ( final Object o : this.treeRoot )
        {
            if ( o instanceof TreeNode )
            {
                ( (TreeNode)o ).dispose ();
            }
        }
        this.treeRoot.clear ();
    }

    protected void handleDiff ( final SetDiff diff )
    {
        for ( final Object o : diff.getAdditions () )
        {
            handleAdd ( (ConnectionDiscovererBean)o );
        }
        for ( final Object o : diff.getRemovals () )
        {
            handleRemove ( (ConnectionDiscovererBean)o );
        }
    }

    private void handleRemove ( final ConnectionDiscovererBean connectionDiscoverer )
    {
        final DiscovererListener listener = this.listenerMap.remove ( connectionDiscoverer );
        if ( listener != null )
        {
            listener.dispose ();
        }
    }

    private void handleAdd ( final ConnectionDiscovererBean connectionDiscoverer )
    {
        final DiscovererListener listener = new DiscovererListener ( connectionDiscoverer, this.poolManager );
        this.listenerMap.put ( connectionDiscoverer, listener );
    }

}
