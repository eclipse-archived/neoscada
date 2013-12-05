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
package org.eclipse.scada.configuration.lib;

import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.Node;

public final class Endpoints
{
    private Endpoints ()
    {
    }

    public static Node findNode ( final Endpoint ep )
    {
        if ( ep.eContainer () instanceof Node )
        {
            return (Node)ep.eContainer ();
        }
        return null;
    }

    /**
     * Find the containing node which must be of the provided type
     * 
     * @param ep
     *            the endpoint
     * @param clazz
     *            the node clazz
     * @return the node
     * @throws IllegalStateException
     *             if the endpoint is not contained by the correct node type
     */
    public static <N extends Node> N findNode ( final Endpoint ep, final Class<N> clazz )
    {
        final Node node = findNode ( ep );
        if ( node != null && clazz.isAssignableFrom ( node.getClass () ) )
        {
            return clazz.cast ( node );
        }
        throw new IllegalStateException ( String.format ( "Endpoint %s is not contained by node of type %s", ep, clazz.getName () ) );
    }
}
