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
package org.eclipse.scada.configuration.component.lib;

import java.util.LinkedList;

import org.eclipse.scada.configuration.component.Configuration;

public final class Configurations
{
    private Configurations ()
    {
    }

    public static <T extends Configuration> T findDefaultConfiguration ( final org.eclipse.scada.configuration.component.ComponentWorld system, final Class<T> clazz )
    {
        final LinkedList<Configuration> candidates = new LinkedList<> ();

        for ( final Configuration cfg : system.getConfigurations () )
        {
            if ( clazz.isAssignableFrom ( cfg.getClass () ) )
            {
                candidates.add ( cfg );
            }
        }

        if ( candidates.isEmpty () )
        {
            return null;
        }

        if ( candidates.size () > 1 )
        {
            throw new IllegalStateException ( String.format ( "Found more than one (%s) default configuration for type %s", candidates.size (), clazz.getName () ) );
        }

        return clazz.cast ( candidates.getFirst () );
    }
}
