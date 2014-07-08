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
package org.eclipse.scada.protocol.iec60870.client.data;

import io.netty.channel.ChannelHandlerContext;

import org.eclipse.scada.protocol.iec60870.asdu.message.DataTransmissionMessage;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;
import org.eclipse.scada.protocol.iec60870.io.AbstractModuleHandler;

public class DataModuleHandler extends AbstractModuleHandler
{
    private final DataHandler dataHandler;

    public DataModuleHandler ( final DataHandler dataHandler )
    {
        this.dataHandler = dataHandler;
    }

    @Override
    public void channelActive ( final ChannelHandlerContext ctx ) throws Exception
    {
        super.channelActive ( ctx );
        ctx.writeAndFlush ( DataTransmissionMessage.REQUEST_START );
    }

    @Override
    public void channelRead ( final ChannelHandlerContext ctx, final Object msg ) throws Exception
    {
        if ( msg == DataTransmissionMessage.CONFIRM_START )
        {
            handleStarted ( ctx );
        }
        else if ( msg instanceof SinglePointInformationTimeSingle )
        {
            handleDataMessage ( (SinglePointInformationTimeSingle)msg );
        }
        else
        {
            super.channelRead ( ctx, msg );
        }
    }

    @Override
    public void channelInactive ( final ChannelHandlerContext ctx ) throws Exception
    {
        handleDisconnected ();
        super.channelInactive ( ctx );
    }

    protected void handleDisconnected ()
    {
        this.dataHandler.disconnected ();
    }

    protected void handleStarted ( final ChannelHandlerContext ctx )
    {
        this.dataHandler.connected ( ctx );
    }

    protected void handleDataMessage ( final SinglePointInformationTimeSingle msg )
    {
        this.dataHandler.process ( msg );
    }

}
