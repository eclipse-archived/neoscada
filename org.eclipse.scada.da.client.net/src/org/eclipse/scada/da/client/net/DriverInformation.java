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
import org.eclipse.scada.core.client.Connection;

public class DriverInformation implements org.eclipse.scada.core.client.DriverInformation
{
    public static final String PROP_DEFAULT_ASYNC = "defaultAsyncExecutor";

    public Connection create ( final ConnectionInformation connectionInformation )
    {
        if ( connectionInformation.getSecondaryTarget () == null )
        {
            return null;
        }

        return new org.eclipse.scada.da.client.net.Connection ( connectionInformation );
    }

    public Class<?> getConnectionClass ()
    {
        return org.eclipse.scada.da.client.net.Connection.class;
    }

    public void validate ( final ConnectionInformation connectionInformation ) throws Throwable
    {
    }

}
