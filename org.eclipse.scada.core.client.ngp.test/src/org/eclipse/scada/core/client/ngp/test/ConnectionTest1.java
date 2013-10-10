/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.client.ngp.test;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.common.ClientBaseConnection;
import org.eclipse.scada.core.client.ngp.ProtocolIoHandlerFactory;
import org.eclipse.scada.protocol.ngp.common.DefaultProtocolConfigurationFactory;
import org.eclipse.scada.protocol.ngp.common.FilterChainBuilder;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionTest1 implements IApplication
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionTest1.class );

    private ClientBaseConnection connection;

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        final String uri = System.getProperty ( "connectionUri", "da:ngp://localhost:1202" );

        final ConnectionInformation connectionInformation = ConnectionInformation.fromURI ( uri );

        final ProtocolConfigurationFactory protocolConfigurationFactory = new DefaultProtocolConfigurationFactory ( connectionInformation ) {
            @Override
            protected void customizeConfiguration ( final ProtocolConfiguration configuration, final boolean clientMode )
            {
                addJavaProtocol ( "1", configuration, ConnectionTest1.class.getClassLoader () );
            }
        };

        logger.info ( "Start - Begin" );
        this.connection = new ClientBaseConnection ( new ProtocolIoHandlerFactory ( protocolConfigurationFactory ), new FilterChainBuilder ( true ), connectionInformation ) {
            @Override
            protected void handleMessage ( final Object message )
            {
                System.out.println ( "Received message: " + message );
            }
        };
        this.connection.addConnectionStateListener ( new DumpingStateListener () );
        this.connection.connect ();

        logger.info ( "Start - Sleep" );

        Thread.sleep ( 1000 * 1000 );

        logger.info ( "Start - End" );
        return null;
    }

    @Override
    public void stop ()
    {
        logger.info ( "Stop - Begin" );
        this.connection.dispose ();
        logger.info ( "Stop - End" );
    }

}
