/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.creator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.ConnectionService;

public class ConnectionCreatorHelper
{
    public static ConnectionService createConnection ( final ConnectionInformation info, final Integer autoReconnectDelay, final boolean lazyActivation )
    {
        if ( info == null )
        {
            return null;
        }

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( Activator.EXTP_CONNECTON_CREATOR ) )
        {
            final String interfaceName = ele.getAttribute ( "interface" );
            final String driverName = ele.getAttribute ( "driver" );
            if ( interfaceName == null || driverName == null )
            {
                continue;
            }
            if ( interfaceName.equals ( info.getInterface () ) && driverName.equals ( info.getDriver () ) )
            {
                final ConnectionService service = createConnection ( info, ele, autoReconnectDelay, lazyActivation );
                if ( service != null )
                {
                    return service;
                }
            }
        }
        return null;
    }

    /**
     * Create a new connection from the connection created defined in the element
     * 
     * @param connectionInformation
     *            the connection information
     * @param ele
     *            the configuration element
     * @param autoReconnectDelay
     *            the automatic reconnect delay or <code>null</code> if not automatic reconnect should be used
     * @return a new {@link ConnectionService} or <code>null</code>
     */
    private static ConnectionService createConnection ( final ConnectionInformation connectionInformation, final IConfigurationElement ele, final Integer autoReconnectDelay, final boolean lazyActivation )
    {
        try
        {
            final Object o = ele.createExecutableExtension ( "class" );
            if ( ! ( o instanceof ConnectionCreator ) )
            {
                return null;
            }

            return ( (ConnectionCreator)o ).createConnection ( connectionInformation, autoReconnectDelay, lazyActivation );
        }
        catch ( final CoreException e )
        {
            Activator.getDefault ().getLog ().log ( e.getStatus () );
            return null;
        }
    }
}
