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
package org.eclipse.scada.core.server.ngp.test;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.eclipse.scada.protocol.ngp.common.SslHelper;
import org.eclipse.scada.core.server.ngp.ServerBase;
import org.eclipse.scada.core.server.ngp.ServerConnection;

public class ServerTest1 implements IApplication
{

    private ServerBase server;

    private static ProtocolConfiguration makeProtocolConfiguration () throws Exception
    {
        final ProtocolConfiguration protocolConfiguration = new ProtocolConfiguration ( ServerTest1.class.getClassLoader () );
        protocolConfiguration.setSslContextFactory ( makeSslContextFactory ( System.getProperties () ) );
        return protocolConfiguration;
    }

    private static SslContextFactory makeSslContextFactory ( final Properties properties ) throws Exception
    {
        final Map<String, String> p = new HashMap<String, String> ();
        for ( final Map.Entry<Object, Object> entry : properties.entrySet () )
        {
            p.put ( "" + entry.getKey (), "" + entry.getValue () );
        }
        return SslHelper.createDefaultSslFactory ( p, false );
    }

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        final ProtocolConfigurationFactory factory = new ProtocolConfigurationFactory () {
            @Override
            public ProtocolConfiguration createConfiguration ( final boolean clientMode ) throws Exception
            {
                return makeProtocolConfiguration ();
            }
        };

        this.server = new ServerBase ( Arrays.asList ( new InetSocketAddress ( 1202 ) ), factory ) {
            @Override
            public org.eclipse.scada.core.server.ngp.ServerConnection createNewConnection ( final IoSession session )
            {
                return new ServerConnection ( session ) {

                    @Override
                    public void messageReceived ( final Object message )
                    {
                        System.out.println ( "Message received: " + message );
                    }
                };
            };
        };
        this.server.start ();
        return null;
    }

    @Override
    public void stop ()
    {
        this.server.dispose ();
    }

}
