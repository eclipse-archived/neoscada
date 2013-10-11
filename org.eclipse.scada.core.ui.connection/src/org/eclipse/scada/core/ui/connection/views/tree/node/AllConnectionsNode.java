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

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.scada.core.ui.connection.views.tree.ConnectionPoolManager;

public class AllConnectionsNode extends DelegatingTreeNode implements ISetChangeListener
{

    private final ConnectionPoolManager poolManager;

    public AllConnectionsNode ( final Realm realm, final ConnectionPoolManager poolManager )
    {
        super ( realm, "All Connections" );

        this.poolManager = poolManager;
        this.poolManager.getAllConnections ().addSetChangeListener ( this );
    }

    @Override
    public void handleSetChange ( final SetChangeEvent event )
    {
        this.implNode.getConnections ().removeAll ( event.diff.getRemovals () );
        this.implNode.getConnections ().addAll ( event.diff.getAdditions () );
    }

    @Override
    public void dispose ()
    {
        this.poolManager.getAllConnections ().removeSetChangeListener ( this );
        super.dispose ();
    }
}