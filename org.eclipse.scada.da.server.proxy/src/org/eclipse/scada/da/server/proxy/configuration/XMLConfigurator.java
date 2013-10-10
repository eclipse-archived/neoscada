/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.configuration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.client.ConnectionFactory;
import org.eclipse.scada.da.client.Connection;
import org.eclipse.scada.da.proxy.configuration.ConnectionType;
import org.eclipse.scada.da.proxy.configuration.ProxyType;
import org.eclipse.scada.da.proxy.configuration.RootType;
import org.eclipse.scada.da.server.proxy.Hive;
import org.eclipse.scada.da.server.proxy.connection.ProxyConnection;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;

/**
 * @author Juergen Rose &lt;juergen.rose@th4-systems.com&gt;
 */
public class XMLConfigurator
{
    private final RootType root;

    private final Map<String, Connection> connections = new HashMap<String, Connection> ();

    /**
     * @param document
     */
    public XMLConfigurator ( final RootType root )
    {
        this.root = root;
    }

    /**
     * @param hive
     * @throws ClassNotFoundException
     * @throws InvalidOperationException
     * @throws NullValueException
     * @throws NotConvertableException
     * @throws ConfigurationError
     */
    public void configure ( final Hive hive ) throws ClassNotFoundException, InvalidOperationException, NullValueException, NotConvertableException
    {
        if ( this.root.isSetSeparator () )
        {
            hive.setSeparator ( this.root.getSeparator () );
        }
        for ( final ProxyType proxyConf : this.root.getProxy () )
        {
            final ProxyConnection proxyConnection = hive.addConnection ( new ProxyPrefixName ( proxyConf.getPrefix () ) );
            proxyConnection.setWait ( proxyConf.getWait () );

            for ( final ConnectionType connectionConf : proxyConf.getConnection () )
            {
                final Connection connection = createConnection ( connectionConf.getUri (), connectionConf.getClassName () );
                proxyConnection.addConnection ( connection, connectionConf.getId (), new ProxyPrefixName ( connectionConf.getPrefix () ) );
            }
        }
    }

    /**
     * @param uri
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    private Connection createConnection ( final String uri, final String className ) throws ClassNotFoundException
    {
        Connection connection = this.connections.get ( uri );
        if ( connection == null )
        {
            if ( className != null && className.length () > 0 )
            {
                Class.forName ( className );
            }
            connection = (Connection)ConnectionFactory.create ( ConnectionInformation.fromURI ( uri ) );
            this.connections.put ( uri, connection );
        }
        return connection;
    }
}
