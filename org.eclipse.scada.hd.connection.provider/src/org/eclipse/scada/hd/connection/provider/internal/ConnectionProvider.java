/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.connection.provider.internal;

import org.eclipse.scada.core.connection.provider.AbstractConnectionManager;
import org.eclipse.scada.core.connection.provider.AbstractConnectionProvider;
import org.eclipse.scada.core.connection.provider.ConnectionRequest;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionProvider extends AbstractConnectionProvider
{
    @SuppressWarnings ( "unused" )
    private final static Logger logger = LoggerFactory.getLogger ( ConnectionProvider.class );

    public ConnectionProvider ( final BundleContext context )
    {
        super ( context, "hd" );
    }

    @Override
    protected AbstractConnectionManager createConnectionManager ( final ConnectionRequest request )
    {
        return new ConnectionManager ( this.context, request.getRequestId (), request.getConnectionInformation (), request.getAutoReconnectDelay (), request.isInitialOpen () );
    }
}
