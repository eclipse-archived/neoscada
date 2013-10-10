/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.common;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientConnectionHandler implements IoHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( ClientConnectionHandler.class );

    protected final ClientBaseConnection connection;

    public ClientConnectionHandler ( final ClientBaseConnection connection )
    {
        this.connection = connection;
    }

    @Override
    public void exceptionCaught ( final IoSession session, final Throwable error ) throws Exception
    {
        logger.info ( "exceptionCaught - session: " + session, error );

        this.connection.performClosed ( session, error );
    }

    @Override
    public void messageReceived ( final IoSession session, final Object message ) throws Exception
    {
        this.connection.messageReceived ( session, message );
    }

    @Override
    public void messageSent ( final IoSession session, final Object message ) throws Exception
    {
    }

    @Override
    public void sessionClosed ( final IoSession session ) throws Exception
    {
        this.connection.performClosed ( session, null );
    }

    @Override
    public void sessionIdle ( final IoSession session, final IdleStatus idleState ) throws Exception
    {
    }

    @Override
    public void sessionOpened ( final IoSession session ) throws Exception
    {
        this.connection.performOpened ( session );
    }

    @Override
    public void sessionCreated ( final IoSession session ) throws Exception
    {
    }

}