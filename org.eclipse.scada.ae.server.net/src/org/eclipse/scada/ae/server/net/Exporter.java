/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.net;

import java.io.IOException;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.handler.multiton.SingleSessionIoHandler;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerDelegate;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerFactory;
import org.eclipse.scada.ae.server.Service;
import org.eclipse.scada.ae.server.exporter.ExporterBase;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.server.net.Server;

public class Exporter extends ExporterBase
{
    private Server server;

    public Exporter ( final Service service, final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( service, connectionInformation );
    }

    private void createServer () throws IOException
    {
        this.server = new Server ( this.connectionInformation );
        this.server.start ( createFactory () );
    }

    private SingleSessionIoHandlerDelegate createFactory ()
    {
        return new SingleSessionIoHandlerDelegate ( new SingleSessionIoHandlerFactory () {

            public SingleSessionIoHandler getHandler ( final IoSession session ) throws Exception
            {
                return new ServerConnectionHandler ( Exporter.this.service, session, Exporter.this.connectionInformation );
            }
        } );
    }

    public void start () throws Exception
    {
        createServer ();
    }

    public void stop () throws Exception
    {
        destroyServer ();
    }

    private void destroyServer ()
    {
        if ( this.server != null )
        {
            this.server.dispose ();
            this.server = null;
        }
    }
}
