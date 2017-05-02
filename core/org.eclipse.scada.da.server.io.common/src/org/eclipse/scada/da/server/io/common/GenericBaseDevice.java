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
package org.eclipse.scada.da.server.io.common;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericBaseDevice extends IoHandlerAdapter
{

    private static final Logger logger = LoggerFactory.getLogger ( GenericBaseDevice.class );

    protected final Set<ConnectionListener> connectionListeners = new CopyOnWriteArraySet<ConnectionListener> ();

    public GenericBaseDevice ()
    {
        super ();
    }

    public void addConnectionListener ( final ConnectionListener listener )
    {
        this.connectionListeners.add ( listener );
    }

    public void removeConnectionListener ( final ConnectionListener listener )
    {
        this.connectionListeners.remove ( listener );
    }

    protected void fireConnectionFailed ( final Throwable e )
    {
        logger.info ( "Connect failed", e );

        for ( final ConnectionListener listener : this.connectionListeners )
        {
            listener.connectFailed ( e );
        }
    }

    protected void fireDisconnected ( final Throwable e )
    {
        logger.info ( "Disconnected", e );

        for ( final ConnectionListener listener : this.connectionListeners )
        {
            listener.connectFailed ( e );
        }
    }

    protected void fireConnected ()
    {
        for ( final ConnectionListener listener : this.connectionListeners )
        {
            listener.opened ();
        }
    }

}