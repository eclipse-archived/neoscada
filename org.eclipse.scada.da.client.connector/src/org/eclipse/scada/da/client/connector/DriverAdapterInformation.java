/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.connector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

public class DriverAdapterInformation
{
    private final IConfigurationElement configurationElement;

    public DriverAdapterInformation ( final IConfigurationElement configurationElement )
    {
        this.configurationElement = configurationElement;
    }

    public String getName ()
    {
        return this.configurationElement.getAttribute ( "name" );
    }

    public DriverAdapter createDriverAdapter ()
    {
        try
        {
            return (DriverAdapter)this.configurationElement.createExecutableExtension ( "class" );
        }
        catch ( final CoreException e )
        {
            return null;
        }
    }

    public String getInterface ()
    {
        return this.configurationElement.getAttribute ( "interface" );
    }

    public String getType ()
    {
        return this.configurationElement.getAttribute ( "type" );
    }
}
