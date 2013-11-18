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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;

public final class Properties
{
    private Properties ()
    {
    }

    public static PropertyEntry create ( final String key, final String value )
    {
        final PropertyEntry prop = OsgiFactory.eINSTANCE.createPropertyEntry ();
        prop.setKey ( key );
        prop.setValue ( value );
        return prop;
    }

    public static Map<String, String> makeAttributes ( final Collection<PropertyEntry> properties )
    {
        return makeAttributes ( null, properties );
    }

    public static Map<String, String> makeAttributes ( final String prefix, final Collection<PropertyEntry> properties )
    {
        final Map<String, String> result = new HashMap<> ();

        for ( final PropertyEntry entry : properties )
        {
            if ( prefix != null )
            {
                result.put ( prefix + entry.getKey (), entry.getValue () );
            }
            else
            {
                result.put ( entry.getKey (), entry.getValue () );
            }
        }

        return result;
    }

}
