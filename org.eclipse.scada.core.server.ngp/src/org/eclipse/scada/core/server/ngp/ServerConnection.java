/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.ngp;

import java.util.Collection;
import java.util.Map;

import javax.net.ssl.SSLSession;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.ssl.SslFilter;
import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.core.server.common.stats.ManagedConnection;
import org.eclipse.scada.protocol.common.StatisticsFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServerConnection
{

    private final static Logger logger = LoggerFactory.getLogger ( ServerConnection.class );

    private static final Object STATS_MESSAGES_SENT = new Object ();

    private static final Object STATS_MESSAGES_RECEIVED = new Object ();

    private final IoSession session;

    protected final StatisticsImpl statistics;

    private ManagedConnection mxBean;

    private final Object writeLock = new Object ();

    public ServerConnection ( final IoSession session )
    {
        logger.info ( "Creating new server connection: {}", session );

        this.statistics = new StatisticsImpl ();

        this.session = session;

        this.mxBean = ManagedConnection.register ( new ManagedConnection () {
            @Override
            protected Collection<StatisticEntry> getEntries ()
            {
                return ServerConnection.this.statistics.getEntries ();
            }

            @Override
            public void close ()
            {
                ServerConnection.this.session.close ( false );
            }

            @Override
            public Map<String, String> getTransportProperties ()
            {
                final MessageChannelFilter mcf = (MessageChannelFilter)session.getFilterChain ().get ( MessageChannelFilter.class );
                if ( mcf != null )
                {
                    return mcf.getAcceptedProperties ();
                }
                else
                {
                    return null;
                }
            }
        }, session.getRemoteAddress (), "org.eclipse.scada.core.server.ngp" );

        this.statistics.setLabel ( STATS_MESSAGES_SENT, "Messages sent" );
        this.statistics.setLabel ( STATS_MESSAGES_RECEIVED, "Messages received" );

        session.setAttribute ( StatisticsFilter.STATS_KEY, this.statistics );
    }

    public void dispose ()
    {
        logger.info ( "Disposing server connection: {}", this.session );

        if ( this.mxBean != null )
        {
            this.mxBean.dispose ();
            this.mxBean = null;
        }

        requestClose ( true );
    }

    protected void sendMessage ( final Object message )
    {
        logger.trace ( "Sending message: {}", message );

        this.statistics.changeCurrentValue ( STATS_MESSAGES_SENT, 1 );

        synchronized ( this.writeLock )
        {
            // only one thread may write at a time, otherwise MINA's filters may get corrupted
            // also see https://issues.apache.org/jira/browse/DIRMINA-653
            this.session.write ( message );
        }
    }

    public void requestClose ( final boolean immediately )
    {
        this.session.close ( immediately );
    }

    public abstract void messageReceived ( Object message ) throws Exception;

    public void handleMessageReceived ( final Object message ) throws Exception
    {
        logger.trace ( "Message received: {}", message );

        this.statistics.changeCurrentValue ( STATS_MESSAGES_RECEIVED, 1 );
        messageReceived ( message );
    }

    public SSLSession getSslSession ()
    {
        final IoSession session = this.session;
        if ( session == null )
        {
            return null;
        }
        final Object sslSession = session.getAttribute ( SslFilter.SSL_SESSION );

        if ( sslSession instanceof SSLSession )
        {
            return (SSLSession)sslSession;
        }
        else
        {
            return null;
        }
    }

}
