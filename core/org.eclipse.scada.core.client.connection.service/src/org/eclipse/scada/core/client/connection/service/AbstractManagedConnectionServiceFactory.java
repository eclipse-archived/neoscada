/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.connection.service;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.core.connection.provider.ConnectionService;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractManagedConnectionServiceFactory<ConnectionServiceType extends ConnectionService> implements ConfigurationFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractManagedConnectionServiceFactory.class );

    public static final String CONNECTION_URI = "connection.uri";

    private final Map<String, AbstractConnectionManager<ConnectionServiceType>> connections = new HashMap<String, AbstractConnectionManager<ConnectionServiceType>> ();

    @Override
    public void delete ( final UserInformation userInformation, final String pid )
    {
        logger.info ( "Request to delete: {}", pid ); //$NON-NLS-1$

        AbstractConnectionManager<ConnectionServiceType> connection;
        synchronized ( this )
        {
            connection = this.connections.remove ( pid );
        }
        if ( connection != null )
        {
            connection.dispose ();
        }
    }

    @Override
    public void update ( final UserInformation userInformation, final String pid, final Map<String, String> properties )
    {
        logger.info ( "Update request: {} ({})", pid, properties ); //$NON-NLS-1$

        final String uri = properties.get ( CONNECTION_URI );

        if ( uri == null )
        {
            throw new RuntimeException ( String.format ( "'%s' is not set", CONNECTION_URI ) ); //$NON-NLS-1$
        }

        synchronized ( this )
        {
            // delete first
            delete ( userInformation, pid );

            // create
            final AbstractConnectionManager<ConnectionServiceType> newManager = createConnectionManager ( pid, uri );
            if ( newManager != null )
            {
                publishConnection ( pid, newManager );
            }
        }
    }

    protected abstract AbstractConnectionManager<ConnectionServiceType> createConnectionManager ( String pid, String uri );

    private void publishConnection ( final String pid, final AbstractConnectionManager<ConnectionServiceType> manager )
    {
        this.connections.put ( pid, manager );
    }

    public void dispose ()
    {
        final Map<String, AbstractConnectionManager<ConnectionServiceType>> connections;

        synchronized ( this )
        {
            connections = new HashMap<String, AbstractConnectionManager<ConnectionServiceType>> ( this.connections );
            this.connections.clear ();
        }
        for ( final AbstractConnectionManager<ConnectionServiceType> manager : connections.values () )
        {
            manager.dispose ();
        }

    }
}