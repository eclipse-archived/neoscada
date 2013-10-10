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
package org.eclipse.scada.core.server.ngp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Set;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.eclipse.scada.core.server.common.NetworkHelper;
import org.eclipse.scada.protocol.ngp.common.FilterChainBuilder;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServerBase
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerBase.class );

    private final NioSocketAcceptor acceptor;

    private final Collection<InetSocketAddress> addresses;

    private final FilterChainBuilder chainBuilder;

    public ServerBase ( final Collection<InetSocketAddress> addresses, final ProtocolConfigurationFactory protocolConfigurationFactory ) throws Exception
    {
        this.addresses = addresses;

        this.acceptor = new NioSocketAcceptor ();
        this.acceptor.setReuseAddress ( true );

        this.chainBuilder = new FilterChainBuilder ( false );
        this.chainBuilder.setLoggerName ( ServerBase.class.getName () + ".protocol" );

        this.acceptor.setFilterChainBuilder ( this.chainBuilder );
        this.acceptor.setHandler ( new ServerBaseHandler ( this, protocolConfigurationFactory.createConfiguration ( false ) ) );
    }

    public Set<InetSocketAddress> start () throws IOException
    {
        logger.info ( "Starting server for: {}", this.addresses );

        this.acceptor.bind ( this.addresses );

        return NetworkHelper.getLocalAddresses ( this.acceptor );
    }

    public void stop ()
    {
        this.acceptor.unbind ();
    }

    public void dispose ()
    {
        this.acceptor.dispose ();
    }

    public abstract ServerConnection createNewConnection ( final IoSession session );
}
