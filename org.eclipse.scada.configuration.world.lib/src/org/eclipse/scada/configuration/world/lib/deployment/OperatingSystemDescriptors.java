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
package org.eclipse.scada.configuration.world.lib.deployment;

import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

public final class OperatingSystemDescriptors
{
    private OperatingSystemDescriptors ()
    {
    }

    public static Boolean isProperty ( final OperatingSystemDescriptor operatingSystem, final String name, final Boolean defaultValue )
    {
        OperatingSystemDescriptor os = operatingSystem;

        while ( os != null )
        {
            final Boolean value = Properties.isProperty ( operatingSystem.getProperties (), name, null );
            if ( value != null )
            {
                return value;
            }

            os = os.getParent ();
        }

        return defaultValue;
    }

    public static String getProperty ( final OperatingSystemDescriptor operatingSystem, final String name, final String defaultValue )
    {
        OperatingSystemDescriptor os = operatingSystem;

        while ( os != null )
        {
            final String value = Properties.getProperty ( operatingSystem.getProperties (), name, null );
            if ( value != null )
            {
                return value;
            }

            os = os.getParent ();
        }

        return defaultValue;
    }

}
