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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Configurations
{
    private Configurations ()
    {
    }

    // FIXME: check if this should be in sync with the app generator on attribute summaries
    public static final Set<String> groupsSum = new HashSet<String> ( Arrays.asList ( "manual", "error", "alarm", "ackRequired", "blocked", "info", "warning" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$

    public static void applyInfoAttributes ( final Map<String, String> attributes, final Map<String, String> data )
    {
        injectAttributes ( attributes, "info.", data ); //$NON-NLS-1$
    }

    public static void fillAttributesWithHierarchy ( final Map<String, String> attributes, final List<String> hierarchy )
    {
        int i = 0;
        for ( final String level : hierarchy )
        {
            attributes.put ( String.format ( "level.%d", i ), level );
            i++;
        }
    }

    private static void injectAttributes ( final Map<String, String> attributes, final String prefix, final Map<String, String> data )
    {
        if ( attributes == null )
        {
            return;
        }

        for ( final Map.Entry<String, String> entry : attributes.entrySet () )
        {
            if ( entry.getKey () == null || entry.getKey ().isEmpty () )
            {
                //ignore empty keys
                continue;
            }

            data.put ( prefix + entry.getKey (), entry.getValue () );
        }
    }
}
