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
package org.eclipse.scada.protocol.iec60870.server.data;

import io.netty.channel.ChannelHandlerContext;

import org.eclipse.scada.protocol.iec60870.apci.MessageSource;

public class ContextChannelWriter implements ChannelWriter
{
    private final ChannelHandlerContext ctx;

    ContextChannelWriter ( final ChannelHandlerContext ctx )
    {
        this.ctx = ctx;
    }

    @Override
    public void write ( final Object message )
    {
        this.ctx.write ( message );
    }

    @Override
    public void notifyMoreData ()
    {
        this.ctx.write ( MessageSource.NOTIFY_TOKEN );
    }

    @Override
    public void flush ()
    {
        this.ctx.flush ();
    }
}