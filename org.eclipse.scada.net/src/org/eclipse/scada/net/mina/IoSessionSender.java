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
package org.eclipse.scada.net.mina;

import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.net.base.data.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IoSessionSender implements MessageSender
{
    private static final long MAX_SEQUENCE = 0x7FFFFFFF;

    private static final long INIT_SEQUENCE = 1;

    private long sequence = INIT_SEQUENCE;

    private final IoSession session;

    public static Object STATS_QUEUED_BYTES = new Object ();

    private final StatisticsImpl statistics;

    private final static Logger logger = LoggerFactory.getLogger ( IoSessionSender.class );

    public IoSessionSender ( final IoSession session, final StatisticsImpl statistics )
    {
        this.session = session;
        this.statistics = statistics;
        statistics.setLabel ( STATS_QUEUED_BYTES, "Scheduled write bytes" );
    }

    @Override
    public synchronized WriteFuture sendMessage ( final Message message, final PrepareSendHandler handler )
    {
        message.setSequence ( nextSequence () );

        // if we have a prepare send handler .. notify
        if ( handler != null )
        {
            handler.prepareSend ( message );
        }

        final WriteFuture future = this.session.write ( message );

        logger.trace ( "Scheduled write bytes: {}", this.session.getScheduledWriteBytes () );
        this.statistics.setCurrentValue ( STATS_QUEUED_BYTES, this.session.getScheduledWriteBytes () );

        return future;
    }

    private long nextSequence ()
    {
        final long seq = this.sequence++;
        if ( this.sequence >= MAX_SEQUENCE )
        {
            this.sequence = INIT_SEQUENCE;
        }
        return seq;
    }

    @Override
    public void close ()
    {
        this.session.close ( true );
    }

    @Override
    public String toString ()
    {
        return this.session.toString ();
    }

}
