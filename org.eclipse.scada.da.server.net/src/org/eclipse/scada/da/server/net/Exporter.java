/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.net;

import java.io.IOException;
import java.util.Collection;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.handler.multiton.SingleSessionIoHandler;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerDelegate;
import org.apache.mina.handler.multiton.SingleSessionIoHandlerFactory;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;
import org.eclipse.scada.core.server.net.Server;
import org.eclipse.scada.da.server.common.impl.ExporterBase;

public class Exporter extends ExporterBase implements LifecycleAware
{
    private Server server;

    private Collection<ConnectionInformation> startedConnections;

    public Exporter ( final Hive hive, final ConnectionInformation connectionInformation ) throws Exception
    {
        super ( hive, connectionInformation );
    }

    private Collection<ConnectionInformation> createServer () throws IOException
    {
        this.server = new Server ( this.connectionInformation );
        return this.server.start ( createFactory () );
    }

    private SingleSessionIoHandlerDelegate createFactory ()
    {
        return new SingleSessionIoHandlerDelegate ( new SingleSessionIoHandlerFactory () {

            @Override
            public SingleSessionIoHandler getHandler ( final IoSession session ) throws Exception
            {
                return new ServerConnectionHandler ( Exporter.this.hive, session, Exporter.this.connectionInformation );
            }
        } );
    }

    @Override
    public void start () throws Exception
    {
        this.startedConnections = createServer ();
    }

    public Collection<ConnectionInformation> getStartedConnections ()
    {
        return this.startedConnections;
    }

    @Override
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
