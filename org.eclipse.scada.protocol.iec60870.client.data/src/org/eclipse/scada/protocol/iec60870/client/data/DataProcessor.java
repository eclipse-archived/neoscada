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

import java.util.concurrent.Executor;

import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.message.InterrogationCommand;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

public class DataProcessor implements DataHandler
{
    private final DataListener listener;

    private final Executor executor;

    public DataProcessor ( final Executor executor, final DataListener listener )
    {
        this.executor = executor;
        this.listener = listener;
    }

    @Override
    public void connected ( final ChannelHandlerContext ctx )
    {
        ctx.writeAndFlush ( new InterrogationCommand ( new ASDUHeader ( CauseOfTransmission.ACTIVATED, ASDUAddress.BROADCAST ), StandardCause.STATION_REQUEST.getValue () ) );
    }

    @Override
    public void disconnected ()
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                DataProcessor.this.listener.disconnected ();
            };
        } );
    }

    @Override
    public void process ( final SinglePointInformationTimeSingle msg )
    {
        for ( final InformationEntry<Boolean> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    protected void fireEntry ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<Boolean> value )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                DataProcessor.this.listener.update ( asduAddress, address, value );
            }
        } );
    }

}
