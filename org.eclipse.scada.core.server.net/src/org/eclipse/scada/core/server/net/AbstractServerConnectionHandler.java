/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.net;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.handler.multiton.SingleSessionIoHandler;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.info.StatisticEntry;
import org.eclipse.scada.core.info.StatisticsImpl;
import org.eclipse.scada.core.net.ConnectionHelper;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.net.Constants;
import org.eclipse.scada.net.base.PingService;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.IoSessionSender;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.core.server.common.stats.ManagedConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractServerConnectionHandler implements SingleSessionIoHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractServerConnectionHandler.class );

    private static final Object STATS_PINGS_SENT = new Object ();

    private static final Object STATS_SESSION_BYTES_READ = new Object ();

    private static final Object STATS_SESSION_BYTES_WRITTEN = new Object ();

    private static final Object STATS_SESSION_STARTED = new Object ();

    private static final int DEFAULT_TIMEOUT = 10000;

    protected IoSession ioSession;

    protected final Messenger messenger;

    protected final PingService pingService;

    protected final ConnectionInformation connectionInformation;

    private final StatisticsImpl statistics;

    private ManagedConnection mxBean;

    private boolean sessionStarted;

    private Set<String> privileges;

    public AbstractServerConnectionHandler ( final IoSession ioSession, final ConnectionInformation connectionInformation )
    {
        super ();
        this.ioSession = ioSession;
        this.connectionInformation = connectionInformation;

        this.statistics = new StatisticsImpl ();

        this.messenger = new Messenger ( getMessageTimeout (), this.statistics );

        this.pingService = new PingService ( this.messenger );

        this.ioSession.getConfig ().setReaderIdleTime ( getPingPeriod () / 1000 );

        this.messenger.connected ( new IoSessionSender ( this.ioSession, this.statistics ) );

        this.mxBean = ManagedConnection.register ( new ManagedConnection () {
            @Override
            protected Collection<StatisticEntry> getEntries ()
            {
                return AbstractServerConnectionHandler.this.statistics.getEntries ();
            }

            @Override
            public Map<String, String> getTransportProperties ()
            {
                return null;
            }

            @Override
            public void close ()
            {
                AbstractServerConnectionHandler.this.ioSession.close ( false );
            }
        }, ioSession.getRemoteAddress (), "org.eclipse.scada.core.server.net" );

        this.statistics.setLabel ( STATS_PINGS_SENT, "Pings sent" );
        this.statistics.setLabel ( STATS_SESSION_BYTES_READ, "Bytes read in session" );
        this.statistics.setLabel ( STATS_SESSION_BYTES_WRITTEN, "Bytes written in session" );
        this.statistics.setLabel ( STATS_SESSION_STARTED, "Session started" );
    }

    protected void sessionConfigured ( final Map<String, String> properties )
    {
        logger.info ( "Configure session" );

        modifyFilterChain ( this.ioSession, properties );
    }

    protected void sendPrivilegeChange ( final Set<String> privileges )
    {
        this.privileges = privileges;
        if ( this.sessionStarted && privileges != null )
        {
            this.messenger.sendMessage ( MessageHelper.createPrivilegeChange ( privileges ) );
        }
    }

    protected void modifyFilterChain ( final IoSession ioSession, final Map<String, String> properties )
    {
        ConnectionHelper.injectCompression ( ioSession, properties.get ( Constants.PROP_TR_COMPRESSION ) );
    }

    protected Map<String, String> getTransportProperties ( final Properties props )
    {
        final Map<String, String> transportProperties = new HashMap<String, String> ();
        if ( props.containsKey ( "transport.request.compression" ) )
        {
            if ( isCompressionDenied () )
            {
                logger.info ( "Remote peer requested compression but we don't allow compression" );
            }
            else
            {
                transportProperties.put ( "transport.request.compression", props.getProperty ( "transport.request.compression" ) );
            }
        }
        return transportProperties;
    }

    private boolean isCompressionDenied ()
    {
        if ( getBooleanProperty ( "transport.reject.compression", false ) )
        {
            return true;
        }
        else if ( Boolean.getBoolean ( "org.eclipse.scada.core.server.net.rejectCompression" ) )
        {
            return true;
        }
        return false;
    }

    protected void replySessionCreated ( final Properties originalProperties, final Message originalMessage, final Map<String, String> sessionProperties )
    {
        logger.debug ( "Reply session created: {}", originalMessage );

        final Map<String, String> transportProperties = getTransportProperties ( originalProperties );

        logger.debug ( "Transport properties: {}", transportProperties );

        this.messenger.sendMessage ( MessageHelper.createSessionACK ( originalMessage, sessionProperties, transportProperties ) );

        sessionConfigured ( transportProperties );

        if ( !originalProperties.containsKey ( MessageHelper.PROP_USING_SESSION_START ) )
        {
            logger.debug ( "Starting session directly" );
            // we are using an old version, start directly 
            startSession ();
        }
    }

    @Override
    public void exceptionCaught ( final Throwable cause ) throws Exception
    {
        logger.warn ( "Something failed", cause );
    }

    @Override
    public void messageReceived ( final Object message ) throws Exception
    {
        if ( message instanceof Message )
        {
            this.statistics.setCurrentValue ( STATS_SESSION_BYTES_READ, this.ioSession.getReadBytes () );

            if ( ( (Message)message ).getCommandCode () == MessageHelper.CC_START_SESSION )
            {
                startSession ();
            }
            else
            {
                this.messenger.messageReceived ( (Message)message );
            }
        }
    }

    protected void startSession ()
    {
        logger.info ( "Received request to start session" ); //$NON-NLS-1$

        if ( this.sessionStarted )
        {
            logger.warn ( "Received session start multiple times" );
            return;
        }

        this.sessionStarted = true;
        this.statistics.setCurrentValue ( STATS_SESSION_STARTED, 1.0 );

        // re-send current known privileges
        if ( this.privileges != null && !this.privileges.isEmpty () )
        {
            sendPrivilegeChange ( this.privileges );
        }

        this.pingService.start ();
    }

    @Override
    public void messageSent ( final Object message ) throws Exception
    {
        this.statistics.setCurrentValue ( STATS_SESSION_BYTES_WRITTEN, this.ioSession.getWrittenBytes () );
        this.statistics.setCurrentValue ( IoSessionSender.STATS_QUEUED_BYTES, this.ioSession.getScheduledWriteBytes () );
    }

    @Override
    public void sessionClosed () throws Exception
    {
        cleanUp ();
    }

    protected void cleanUp ()
    {
        if ( this.mxBean != null )
        {
            this.mxBean.dispose ();
            this.mxBean = null;
        }

        if ( this.ioSession != null )
        {
            this.messenger.disconnected ();
            this.ioSession.close ( true );
            this.ioSession = null;
        }
    }

    @Override
    public void sessionCreated () throws Exception
    {
    }

    @Override
    public void sessionIdle ( final IdleStatus status ) throws Exception
    {
        this.pingService.sendPing ();
        this.statistics.changeCurrentValue ( STATS_PINGS_SENT, 1 );
    }

    @Override
    public void sessionOpened () throws Exception
    {
    }

    public int getPingPeriod ()
    {
        return getIntProperty ( "pingPeriod", getIntProperty ( "timeout", DEFAULT_TIMEOUT ) / getIntProperty ( "pingFrequency", 3 ) );
    }

    public int getMessageTimeout ()
    {
        return getIntProperty ( "messageTimeout", getIntProperty ( "timeout", DEFAULT_TIMEOUT ) );
    }

    protected boolean getBooleanProperty ( final String propertyName, final boolean defaultValue )
    {
        try
        {
            final String timeout = this.connectionInformation.getProperties ().get ( propertyName );
            return Boolean.parseBoolean ( timeout );
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    protected int getIntProperty ( final String propertyName, final int defaultValue )
    {
        try
        {
            final String timeout = this.connectionInformation.getProperties ().get ( propertyName );
            final int i = Integer.parseInt ( timeout );
            if ( i <= 0 )
            {
                return defaultValue;
            }
            return i;
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }
}