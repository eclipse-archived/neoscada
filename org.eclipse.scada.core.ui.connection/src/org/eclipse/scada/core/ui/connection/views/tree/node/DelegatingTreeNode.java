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
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.scada.core.ui.connection.views.tree.TreeNode;
import org.eclipse.scada.core.ui.connection.views.tree.TreeNodeImpl;

public class DelegatingTreeNode implements TreeNode
{

    protected final TreeNodeImpl implNode;

    public DelegatingTreeNode ( final Realm realm, final String name )
    {
        this.implNode = new TreeNodeImpl ( realm, null, name );
    }

    @Override
    public IObservableSet getChildren ()
    {
        return this.implNode.getChildren ();
    }

    @Override
    public IObservableSet getConnections ()
    {
        return this.implNode.getConnections ();
    }

    @Override
    public String getName ()
    {
        return this.implNode.getName ();
    }

    @Override
    public TreeNode getParentNode ()
    {
        return this.implNode.getParentNode ();
    }

    @Override
    public void dispose ()
    {
        this.implNode.dispose ();
    }

}