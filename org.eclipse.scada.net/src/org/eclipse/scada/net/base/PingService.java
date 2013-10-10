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
package org.eclipse.scada.net.base;

import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.handlers.PingHandler;
import org.eclipse.scada.net.base.handlers.PongHandler;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.net.utils.MessageCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingService
{
    private final static Logger logger = LoggerFactory.getLogger ( PingService.class );

    private final Messenger messenger;

    private volatile boolean started;

    public PingService ( final Messenger messenger )
    {
        this.messenger = messenger;

        this.messenger.setHandler ( Message.CC_PING, new PingHandler ( this.messenger ) );
        this.messenger.setHandler ( Message.CC_PONG, new PongHandler () );
    }

    public void sendPing ()
    {
        if ( this.started )
        {
            logger.debug ( "Sending ping" );
            this.messenger.sendMessage ( MessageCreator.createPing () );
        }
        else
        {
            logger.info ( "Skipping ping. Not started!" );
        }
    }

    public void start ()
    {
        logger.info ( "Starting ping service" );
        this.started = true;
    }

    public void stop ()
    {
        logger.info ( "Stopping ping service" );
        this.started = false;
    }

}
