/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ui.server.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.scada.utils.ui.server.PageProvider;

public class TreeNode extends AbstractPropertyChange
{
    public static final String PROP_PROVIDER_SET = "providerSet";

    public static final String PROP_NAME = "name";

    private final String name;

    private final WritableList items;

    private final Realm realm;

    private PageProvider provider;

    public TreeNode ( final Realm realm, final String name )
    {
        this.realm = realm;
        this.name = name;
        this.items = new WritableList ( realm );
    }

    public TreeNode ( final Realm realm, final String name, final PageProvider provider )
    {
        this.realm = realm;
        this.name = name;
        this.provider = provider;
        this.items = new WritableList ( realm );
    }

    protected void setProvider ( final PageProvider provider )
    {
        firePropertyChange ( PROP_PROVIDER_SET, this.provider != null, ( this.provider = provider ) != null );
    }

    public boolean isProviderSet ()
    {
        return this.provider != null;
    }

    private final Map<String, TreeNode> map = new HashMap<> ();

    protected TreeNode addEntry ( final String name, final Queue<String> path, final PageProvider provider )
    {
        if ( path.isEmpty () )
        {
            // perform actual add
            if ( this.map.containsKey ( name ) )
            {
                final TreeNode node = this.map.get ( name );
                node.setProvider ( provider );
                return node;
            }
            else
            {
                final TreeNode node = new TreeNode ( this.realm, name, provider );
                this.map.put ( name, node );
                this.items.add ( node );
                return node;
            }
        }
        else
        {
            // go deeper
            final String ele = path.poll ();
            TreeNode node = this.map.get ( ele );
            if ( node == null )
            {
                node = new TreeNode ( this.realm, ele );
                this.map.put ( ele, node );
                this.items.add ( node );
            }
            return node.addEntry ( name, path, provider );
        }
    }

    protected void removeEntry ( final Queue<String> path, final PageProvider provider )
    {
        if ( path.isEmpty () )
        {
            final TreeNode node = this.map.get ( provider.getName () );
            node.setProvider ( null );
            if ( node.isEmpty () )
            {
                removeNode ( provider.getName (), node );
            }
        }
        else
        {
            // go deeper
            final String ele = path.poll ();
            final TreeNode node = this.map.get ( ele );
            if ( node != null )
            {
                node.removeEntry ( path, provider );
                if ( node.isEmpty () )
                {
                    removeNode ( ele, node );
                }
            }
        }
    }

    private void removeNode ( final String ele, final TreeNode node )
    {
        // node is empty, so remove
        this.map.remove ( ele );
        this.items.remove ( node );
        node.dispose ();
    }

    private boolean isEmpty ()
    {
        return this.items.isEmpty () && this.provider == null;
    }

    public void dispose ()
    {
        for ( final Object o : this.items )
        {
            ( (TreeNode)o ).dispose ();
        }
        this.items.dispose ();
    }

    public String getName ()
    {
        return this.name;
    }

    @Override
    public String toString ()
    {
        return this.name;
    }

    public IObservableList getItems ()
    {
        return this.items;
    }

    public PageProvider getProvider ()
    {
        return this.provider;
    }
}
