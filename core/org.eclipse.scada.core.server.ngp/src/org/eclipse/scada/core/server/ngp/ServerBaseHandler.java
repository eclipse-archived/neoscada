/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.server.ngp;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.mc.message.CloseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerBaseHandler implements IoHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerBaseHandler.class );

    private final ServerBase server;

    private final ProtocolConfiguration protocolConfiguration;

    public ServerBaseHandler ( final ServerBase server, final ProtocolConfiguration protocolConfiguration )
    {
        this.server = server;
        this.protocolConfiguration = protocolConfiguration;
    }

    @Override
    public void exceptionCaught ( final IoSession session, final Throwable error ) throws Exception
    {
        logger.warn ( String.format ( "Session (%s) failed. Closing!", session ), error );
        session.close ( true );
    }

    @Override
    public void messageReceived ( final IoSession session, final Object message ) throws Exception
    {
        logger.trace ( "Received message: {}", message );

        final Object o = session.getAttribute ( "connection" );
        if ( o instanceof ServerConnection )
        {
            ( (ServerConnection)o ).handleMessageReceived ( message );
        }
    }

    @Override
    public void messageSent ( final IoSession session, final Object message ) throws Exception
    {
    }

    @Override
    public void sessionClosed ( final IoSession session ) throws Exception
    {
        logger.info ( "Session closed" );

        final Object o = session.getAttribute ( "connection" );
        if ( o instanceof ServerConnection )
        {
            ( (ServerConnection)o ).dispose ();
        }
    }

    @Override
    public void sessionCreated ( final IoSession session ) throws Exception
    {
        this.protocolConfiguration.assign ( session );
    }

    @Override
    public void sessionIdle ( final IoSession session, final IdleStatus idleStatus ) throws Exception
    {
    }

    @Override
    public void sessionOpened ( final IoSession session ) throws Exception
    {
        try
        {
            final ServerConnection connection = this.server.createNewConnection ( session );
            session.setAttribute ( "connection", connection );
        }
        catch ( final Exception e )
        {
            session.write ( new CloseMessage ( "Failed to create server side connection: " + e, -1 ) );
            session.close ( false );
        }
    }
}
