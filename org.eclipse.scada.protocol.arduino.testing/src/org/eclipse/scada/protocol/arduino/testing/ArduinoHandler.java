/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino.testing;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.handler.multiton.SingleSessionIoHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArduinoHandler implements SingleSessionIoHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( ArduinoHandler.class );

    private final IoSession session;

    public ArduinoHandler ( final IoSession session )
    {
        this.session = session;
    }

    @Override
    public void exceptionCaught ( final Throwable error ) throws Exception
    {
        System.out.println ( "Exception: " );
        error.printStackTrace ();
    }

    @Override
    public void messageReceived ( final Object message ) throws Exception
    {
        System.out.println ( System.currentTimeMillis () + " Received: " + this.session + " -> " + message );
    }

    @Override
    public void messageSent ( final Object message ) throws Exception
    {
        System.out.println ( "Sent: " + this.session + " -> " + message );
    }

    @Override
    public void sessionClosed () throws Exception
    {
        System.out.println ( "Closed: " + this.session );
    }

    @Override
    public void sessionCreated () throws Exception
    {
        System.out.println ( "Created: " + this.session );
    }

    @Override
    public void sessionIdle ( final IdleStatus status ) throws Exception
    {
        System.out.println ( "Idle: " + this.session + " -> " + status );
    }

    @Override
    public void sessionOpened () throws Exception
    {
        logger.debug ( "Session opened" );
    }

}
