/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.connection.provider.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.connection.provider.AbstractConnectionManager;
import org.eclipse.scada.core.connection.provider.AbstractConnectionService;
import org.eclipse.scada.hd.client.Connection;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.hd.connection.provider.ConnectionServiceImpl;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionManager extends AbstractConnectionManager
{
    private static final Logger logger = LoggerFactory.getLogger ( ConnectionManager.class );

	private final static Set<String> interfaces;
	
	static
	{
		Set<String> create = new HashSet<String> ();
		create.add ( ConnectionService.class.getName () );
		
		interfaces = Collections.unmodifiableSet ( create ); 
	}
    
    public ConnectionManager ( final BundleContext context, final String connectionId, final ConnectionInformation connectionInformation, final Integer autoReconnectDelay, final boolean initialOpen )
    {
        super ( context, connectionInformation, connectionId, autoReconnectDelay, initialOpen );
    }

    protected AbstractConnectionService createConnection ()
    {
        logger.debug ( "Create new HD connection: {}", getConnectionInformation () );

        final Connection connection = (Connection)getFactory ().getDriverInformation ( getConnectionInformation () ).create ( getConnectionInformation () );

        if ( connection == null )
        {
            logger.warn ( "Failed to create new HD connection: {}", getConnectionInformation () );
            return null;
        }

        return new ConnectionServiceImpl ( connection, getAutoReconnectDelay () );
    }
    
    @Override
    protected Set<String> getInterfaces ()
    {
    	return interfaces;
    }

}
