/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerDelegate;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.net.ConnectionHelper;
import org.eclipse.scada.net.mina.SocketImpl;
import org.eclipse.scada.core.server.common.NetworkHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server
{

    private final static Logger logger = LoggerFactory.getLogger ( Server.class );

    private IoAcceptor acceptor;

    private final ConnectionInformation connectionInformation;

    public Server ( final ConnectionInformation connectionInformation )
    {
        this.connectionInformation = connectionInformation;
    }

    public Set<ConnectionInformation> start ( final SingleSessionIoHandlerDelegate ioHandler ) throws IOException
    {
        this.acceptor = createAcceptor ( ioHandler );
        return NetworkHelper.getLocalInterfaces ( this.acceptor, this.connectionInformation );
    }

    private IoAcceptor createAcceptor ( final IoHandler ioHandler ) throws IOException
    {
        IoAcceptor acceptor = null;

        final SocketImpl socketImpl = SocketImpl.fromName ( this.connectionInformation.getProperties ().get ( "socketImpl" ) );

        // create the acceptor
        acceptor = socketImpl.createAcceptor ();

        // set up the filter chain
        ConnectionHelper.setupFilterChain ( this.connectionInformation, acceptor.getFilterChain (), false );

        // set the session handler
        acceptor.setHandler ( ioHandler );

        // check if the primary target is the wildcard target
        String host = this.connectionInformation.getTarget ();
        if ( host != null && ( host.length () == 0 || "*".equals ( host ) ) )
        {
            host = null;
        }

        // bind
        if ( host != null )
        {
            acceptor.bind ( socketImpl.doLookup ( host, this.connectionInformation.getSecondaryTarget () ) );
        }
        else
        {
            acceptor.bind ( new InetSocketAddress ( this.connectionInformation.getSecondaryTarget () ) );
        }

        return acceptor;
    }

    public void dispose ()
    {
        if ( this.acceptor != null )
        {
            this.acceptor.dispose ();
            this.acceptor = null;
        }
    }
}
