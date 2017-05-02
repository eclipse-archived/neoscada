/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.connection.provider;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class ConnectionIdTracker extends ConnectionTracker
{

    private final String connectionId;

    public ConnectionIdTracker ( final BundleContext context, final String connectionId, final Listener listener )
    {
        this ( context, connectionId, listener, null );
    }

    public ConnectionIdTracker ( final BundleContext context, final String connectionId, final Listener listener, final Class<? extends ConnectionService> clazz )
    {
        super ( context, listener, clazz );
        this.connectionId = connectionId;
    }

    @Override
    protected Map<String, String> createFilterParameters ()
    {
        final Map<String, String> parameters = new HashMap<String, String> ();

        parameters.put ( Constants.SERVICE_PID, this.connectionId );

        return parameters;
    }

    public String getConnectionId ()
    {
        return this.connectionId;
    }
}
