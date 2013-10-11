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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class GroupChildNode extends DelegatingTreeNode
{

    private final GroupChildNode parentNode;

    private final Map<String, GroupChildNode> children = new HashMap<String, GroupChildNode> ();

    private final Realm realm;

    public GroupChildNode ( final Realm realm, final String name, final GroupChildNode parentNode )
    {
        super ( realm, name );
        this.realm = realm;
        this.parentNode = parentNode;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
    }

    protected void addPath ( final List<String> path, final ConnectionHolder holder )
    {
        if ( path.isEmpty () )
        {
            // add
            this.implNode.getConnections ().add ( holder );
        }
        else
        {
            // pass on
            final String name = path.get ( 0 );
            path.remove ( 0 );

            GroupChildNode child = this.children.get ( name );
            if ( child == null )
            {
                child = new GroupChildNode ( this.realm, name, this );
                this.children.put ( name, child );
                this.implNode.getChildren ().add ( child );
            }
            child.addPath ( path, holder );
        }
    }

    protected void removePath ( final List<String> path, final ConnectionHolder holder )
    {
        if ( path.isEmpty () )
        {
            // remove
            this.implNode.getConnections ().remove ( holder );
            if ( this.implNode.getConnections ().isEmpty () && this.parentNode != null )
            {
                this.parentNode.notifyEmpty ( this, this.implNode.getName () );
            }
        }
        else
        {
            // pass on
            final String name = path.get ( 0 );
            path.remove ( 0 );

            final GroupChildNode child = this.children.get ( name );
            if ( child != null )
            {
                child.removePath ( path, holder );
            }
        }
    }

    protected void notifyEmpty ( final GroupChildNode groupChildNode, final String name )
    {
        this.implNode.getChildren ().remove ( groupChildNode );
        groupChildNode.dispose ();
        this.children.remove ( name );
    }

}