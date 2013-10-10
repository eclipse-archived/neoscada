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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PongHandler implements MessageListener
{

    private final static Logger logger = LoggerFactory.getLogger ( PongHandler.class );

    public void messageReceived ( final Message message )
    {
        // no-op
        logger.debug ( "Pong request: {}", message.getValues ().get ( "pong-data" ) );
    }

}
