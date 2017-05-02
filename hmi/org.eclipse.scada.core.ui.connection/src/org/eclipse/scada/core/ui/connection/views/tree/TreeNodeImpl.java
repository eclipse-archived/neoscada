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

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.WritableSet;

public class TreeNodeImpl implements TreeNode
{
    private final TreeNode parentNode;

    private final String name;

    private final WritableSet children;

    private final WritableSet connections;

    public TreeNodeImpl ( final Realm realm, final TreeNode parentNode, final String name )
    {
        this.parentNode = parentNode;
        this.name = name;
        this.children = new WritableSet ( realm );
        this.connections = new WritableSet ( realm );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.core.ui.connection.views.tree.TreeNode#dispose()
     */
    @Override
    public void dispose ()
    {
        this.connections.dispose ();
        for ( final Object o : this.children )
        {
            ( (TreeNode)o ).getChildren ().dispose ();
        }
        this.children.dispose ();
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.core.ui.connection.views.tree.TreeNode#getChildren()
     */
    @Override
    public WritableSet getChildren ()
    {
        return this.children;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.core.ui.connection.views.tree.TreeNode#getConnections()
     */
    @Override
    public WritableSet getConnections ()
    {
        return this.connections;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.core.ui.connection.views.tree.TreeNode#getName()
     */
    @Override
    public String getName ()
    {
        return this.name;
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.core.ui.connection.views.tree.TreeNode#getParentNode()
     */
    @Override
    public TreeNode getParentNode ()
    {
        return this.parentNode;
    }
}
