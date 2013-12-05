/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib;

import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Node;

public final class Nodes
{
    private Nodes ()
    {
    }

    public static boolean isLocal ( final Node node1, final Node node2 )
    {
        if ( node1 == null || node2 == null )
        {
            return false;
        }

        return node1.getHostName ().equalsIgnoreCase ( node2.getHostName () );
    }

    public static Node fromApp ( final Application app )
    {
        if ( app == null )
        {
            return null;
        }
        if ( ! ( app.eContainer () instanceof Node ) )
        {
            return null;
        }
        return (Node)app.eContainer ();
    }

    public static boolean isLocal ( final Node node1, final Application app )
    {
        return isLocal ( node1, fromApp ( app ) );
    }

    public static boolean isLocal ( final Application app1, final Application app2 )
    {
        return isLocal ( fromApp ( app1 ), fromApp ( app2 ) );
    }

    /**
     * return the name of the node
     * <p>
     * This is the name or the hostname if a name is not set.
     * </p>
     * 
     * @param node
     *            a node
     * @return the name of the node, or <code>null</code> if it could not be
     *         determined
     */
    public static String makeName ( final Node node )
    {
        if ( node == null )
        {
            return null;
        }
        if ( node.getName () != null )
        {
            return node.getName ();
        }
        return node.getHostName ();
    }
}
