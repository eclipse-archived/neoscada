/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.net;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.ConnectionFactory;
import org.eclipse.scada.core.client.DriverInformation;

public class DriverFactory implements org.eclipse.scada.core.client.DriverFactory
{
    public DriverInformation getDriverInformation ( final ConnectionInformation connectionInformation )
    {
        if ( !connectionInformation.getInterface ().equalsIgnoreCase ( "da" ) )
        {
            return null;
        }
        if ( ! ( connectionInformation.getDriver ().equalsIgnoreCase ( "net" ) || connectionInformation.getDriver ().equalsIgnoreCase ( "gmpp" ) ) )
        {
            return null;
        }

        if ( connectionInformation.getSecondaryTarget () == null )
        {
            return null;
        }

        return new org.eclipse.scada.da.client.net.DriverInformation ();
    }

    public static void registerDriver ()
    {
        ConnectionFactory.registerDriverFactory ( new DriverFactory () );
    }
}