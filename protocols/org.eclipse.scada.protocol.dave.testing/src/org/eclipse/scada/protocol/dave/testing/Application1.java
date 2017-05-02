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

package org.eclipse.scada.protocol.dave.testing;

import java.net.InetSocketAddress;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.handler.multiton.SingleSessionIoHandler;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerDelegate;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.protocol.dave.DaveFilter;
import org.eclipse.scada.protocol.iso8073.COTPFilter;
import org.eclipse.scada.protocols.tkpt.TPKTFilter;

public class Application1 implements IApplication
{
    private volatile boolean running = true;

    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        final NioSocketConnector connector = new NioSocketConnector ();

        connector.setHandler ( new SingleSessionIoHandlerDelegate ( new SingleSessionIoHandlerFactory () {

            @Override
            public SingleSessionIoHandler getHandler ( final IoSession session ) throws Exception
            {
                return new DaveHandler ( session );
            }
        } ) );

        connector.getFilterChain ().addLast ( "logger", new LoggingFilter ( this.getClass ().getName () ) );
        connector.getFilterChain ().addLast ( "tpkt", new TPKTFilter ( 3 ) );
        connector.getFilterChain ().addLast ( "cotp", new COTPFilter ( 0, (byte)3 ) );
        connector.getFilterChain ().addLast ( "dave", new DaveFilter () );

        connector.connect ( new InetSocketAddress ( "192.168.1.83", 102 ) );

        while ( this.running )
        {
            Thread.sleep ( 1000 );
        }

        return null;
    }

    @Override
    public void stop ()
    {
        this.running = false;
    }

}
