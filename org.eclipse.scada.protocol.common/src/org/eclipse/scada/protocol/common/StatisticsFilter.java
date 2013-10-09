/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.protocol.common;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.eclipse.scada.core.info.StatisticsImpl;

public class StatisticsFilter extends IoFilterAdapter
{
    public static final AttributeKey STATS_KEY = new AttributeKey ( StatisticsFilter.class, "stats" );

    private final static Object STATS_READ_BYTES = new Object ();

    private final static Object STATS_WRITTEN_BYTES = new Object ();

    private final static Object STATS_SCHEDULED_WRITE_BYTES = new Object ();

    private final static Object STATS_READ_BYTES_THROUGHPUT = new Object ();

    private final static Object STATS_WRITTEN_BYTES_THROUGHPUT = new Object ();

    public static final String DEFAULT_NAME = "core.stats";

    private final Set<StatisticsImpl> statsMapper = Collections.synchronizedSet ( new HashSet<StatisticsImpl> () );

    @Override
    public void sessionClosed ( final NextFilter nextFilter, final IoSession session ) throws Exception
    {
        this.statsMapper.remove ( session );
        super.sessionClosed ( nextFilter, session );
    }

    private StatisticsImpl getStats ( final IoSession session )
    {
        final Object o = session.getAttribute ( StatisticsFilter.STATS_KEY );
        if ( o instanceof StatisticsImpl )
        {
            final StatisticsImpl stats = (StatisticsImpl)o;
            if ( this.statsMapper.add ( stats ) )
            {
                init ( stats );
            }
            return stats;
        }
        else
        {
            return null;
        }
    }

    private void init ( final StatisticsImpl stats )
    {
        stats.setLabel ( STATS_READ_BYTES, "Read bytes" );
        stats.setLabel ( STATS_WRITTEN_BYTES, "Written bytes" );
        stats.setLabel ( STATS_SCHEDULED_WRITE_BYTES, "Scheduled write bytes" );
        stats.setLabel ( STATS_READ_BYTES_THROUGHPUT, "Read bytes throughput" );
        stats.setLabel ( STATS_WRITTEN_BYTES_THROUGHPUT, "Written bytes throughput" );
    }

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        updateStats ( session );

        super.filterWrite ( nextFilter, session, writeRequest );
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        updateStats ( session );

        super.messageReceived ( nextFilter, session, message );
    }

    private void updateStats ( final IoSession session )
    {
        final StatisticsImpl stats = getStats ( session );

        if ( stats != null )
        {
            stats.setCurrentValue ( STATS_READ_BYTES, session.getReadBytes () );
            stats.setCurrentValue ( STATS_WRITTEN_BYTES, session.getWrittenBytes () );
            stats.setCurrentValue ( STATS_SCHEDULED_WRITE_BYTES, session.getScheduledWriteBytes () );
            stats.setCurrentValue ( STATS_READ_BYTES_THROUGHPUT, session.getReadBytesThroughput () );
            stats.setCurrentValue ( STATS_WRITTEN_BYTES_THROUGHPUT, session.getWrittenBytesThroughput () );
        }
    }

    @Override
    public void messageSent ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        updateStats ( session );

        super.messageSent ( nextFilter, session, writeRequest );
    }
}
