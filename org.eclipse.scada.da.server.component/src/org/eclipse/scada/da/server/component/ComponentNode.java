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
package org.eclipse.scada.da.server.component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentNode
{
    private final static Logger logger = LoggerFactory.getLogger ( ComponentNode.class );

    private final Map<String, ComponentNode> nodes = new HashMap<> ();

    private final Map<String, Component> components = new HashMap<> ();

    private final FolderCommon folder;

    private final ComponentNode parentNode;

    public ComponentNode ( final ComponentNode parentNode, final FolderCommon folder )
    {
        this.parentNode = parentNode;
        this.folder = folder;
    }

    public void registerComponent ( final LinkedList<String> prefix, final ComponentFolder componentFolder, final Component component )
    {
        logger.debug ( "Register - prefix: {}, componentFolder: {}, component: {}", prefix, componentFolder, component );

        // first get the name
        final String next = prefix.pop ();

        if ( prefix.isEmpty () )
        {
            add ( next, componentFolder, component );
        }
        else
        {
            // add another sub level
            ComponentNode node = this.nodes.get ( next );
            if ( node == null )
            {
                if ( this.components.containsKey ( next ) )
                {
                    // blocked by component

                    // remove all folders we might have created
                    checkRemove ();
                    // throw exception
                    throw new IllegalStateException ( "Namespace blocked by other component" );
                }

                final FolderCommon folder = new FolderCommon ();
                this.folder.add ( next, folder, null );

                node = new ComponentNode ( this, folder );
                this.nodes.put ( next, node );
            }
            node.registerComponent ( prefix, componentFolder, component );
        }
    }

    public void unregisterComponent ( final LinkedList<String> prefix, final Component component )
    {
        // first get the name
        final String next = prefix.pop ();

        logger.debug ( "Checking: {}", next );

        if ( prefix.isEmpty () )
        {
            remove ( next, component );
        }
        else
        {
            logger.debug ( "Passing to sub node" );
            final ComponentNode node = this.nodes.get ( next );
            if ( node == null )
            {
                logger.debug ( "Sub node not found" );
                return;
            }
            node.unregisterComponent ( prefix, component );
        }
    }

    private void add ( final String name, final ComponentFolder componentFolder, final Component component )
    {
        if ( this.components.containsKey ( name ) )
        {
            throw new IllegalStateException ( "There is already a component registered with this name" );
        }
        if ( !this.folder.add ( name, componentFolder, null ) )
        {
            throw new IllegalStateException ( "Namespace is blocked by other component" );
        }
        this.components.put ( name, component );
    }

    private void remove ( final String name, final Component component )
    {
        logger.debug ( "Removing - name: {}, component: {}", name, component );

        final Component c = this.components.get ( name );
        if ( c == component )
        {
            // it is our component
            this.components.remove ( name );
            this.folder.remove ( name );
            checkRemove ();
        }
    }

    private void checkRemove ()
    {
        if ( this.parentNode != null && this.folder.size () == 0 )
        {
            logger.debug ( "Node is empty, remove from parent" );
            this.parentNode.remove ( this );
        }
    }

    private void remove ( final ComponentNode componentNode )
    {
        final Iterator<Map.Entry<String, ComponentNode>> i = this.nodes.entrySet ().iterator ();
        while ( i.hasNext () )
        {
            final Entry<String, ComponentNode> entry = i.next ();
            if ( entry.getValue () == componentNode )
            {
                final String key = entry.getKey ();
                i.remove ();
                // also remove from folder
                this.folder.remove ( key );
            }
        }

        checkRemove ();
    }

}
