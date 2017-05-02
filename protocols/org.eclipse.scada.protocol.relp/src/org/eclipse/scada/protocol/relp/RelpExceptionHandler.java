/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.relp;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;

import org.eclipse.scada.protocol.relp.data.ServerCloseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelpExceptionHandler extends ChannelDuplexHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( RelpExceptionHandler.class );

    @Override
    public void exceptionCaught ( final ChannelHandlerContext ctx, final Throwable cause ) throws Exception
    {
        logger.warn ( "Exception caught", cause );

        ctx.writeAndFlush ( ServerCloseMessage.INSTANCE );
        ctx.close ();
    }
}
