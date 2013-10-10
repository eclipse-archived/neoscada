/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base.handlers;

import org.eclipse.scada.net.base.MessageListener;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.net.utils.MessageCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingHandler implements MessageListener
{

    private final static Logger logger = LoggerFactory.getLogger ( PingHandler.class );

    private final Messenger messenger;

    public PingHandler ( final Messenger messenger )
    {
        this.messenger = messenger;
    }

    public void messageReceived ( final Message message )
    {
        logger.debug ( "Ping request: {}", message.getValues ().get ( "ping-data" ) );

        this.messenger.sendMessage ( MessageCreator.createPong ( message ) );
    }

}
