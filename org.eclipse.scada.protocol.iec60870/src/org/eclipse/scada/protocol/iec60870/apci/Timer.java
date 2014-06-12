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
package org.eclipse.scada.protocol.iec60870.apci;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Timer
{

    private final static Logger logger = LoggerFactory.getLogger ( Timer.class );

    private final ChannelHandlerContext ctx;

    private final TimerHandler handler;

    private final Runnable runnable = new Runnable () {

        @Override
        public void run ()
        {
            handleTimeout ();
        }
    };

    private ScheduledFuture<?> future;

    private final String name;

    public Timer ( final ChannelHandlerContext ctx, final String name, final TimerHandler timerHandler )
    {
        this.ctx = ctx;
        this.name = name;
        this.handler = timerHandler;
    }

    public synchronized void restart ( final long timeout )
    {
        logger.trace ( this.name + ": restart:  {}", timeout );
        internalStop ();
        internalStart ( timeout );
    }

    public synchronized void start ( final long timeout )
    {
        logger.trace ( this.name + ": start: {}", timeout );

        internalStart ( timeout );
    }

    private void internalStart ( final long timeout )
    {
        if ( this.future == null )
        {
            this.future = this.ctx.executor ().schedule ( this.runnable, timeout, TimeUnit.MILLISECONDS );
        }
    }

    public synchronized void stop ()
    {
        logger.trace ( this.name + ": stop" );
        internalStop ();
    }

    private void internalStop ()
    {
        if ( this.future != null )
        {
            this.future.cancel ( false );
            this.future = null;
        }
    }

    protected void handleTimeout ()
    {
        logger.debug ( this.name + ": expired" );

        boolean doCall;
        synchronized ( this )
        {
            doCall = this.future != null;
            this.future = null;
        }
        if ( doCall )
        {
            this.handler.handleTimeout ();
        }
    }

    public void dispose ()
    {
        synchronized ( this )
        {
            if ( this.future != null )
            {
                this.future.cancel ( false );
                this.future = null;
            }
        }
    }

}
