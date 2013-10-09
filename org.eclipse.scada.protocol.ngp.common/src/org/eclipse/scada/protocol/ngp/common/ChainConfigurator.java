/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/


package org.eclipse.scada.protocol.ngp.common;

import javax.net.ssl.SSLContext;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.compression.CompressionFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.apache.mina.filter.ssl.SslFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelKeepAliceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChainConfigurator
{

    private final static Logger logger = LoggerFactory.getLogger ( ChainConfigurator.class );

    private final IoSession session;

    public ChainConfigurator ( final IoSession session )
    {
        this.session = session;
    }

    protected boolean hasFilter ( final String filterName )
    {
        return this.session.getFilterChain ().contains ( filterName );
    }

    protected void removeFilter ( final String filterName )
    {
        this.session.getFilterChain ().remove ( filterName );
    }

    public void startStreamCompression ( final int compressionLevel, final boolean startInactive )
    {
        logger.info ( "Starting stream compression: {} (startInactive: {})", compressionLevel, startInactive );

        if ( startInactive )
        {
            this.session.setAttribute ( CompressionFilter.DISABLE_COMPRESSION_ONCE, Boolean.TRUE );
        }

        if ( this.session.getFilterChain ().contains ( "logger" ) )
        {
            this.session.getFilterChain ().addBefore ( "logger", "streamCompression", new CompressionFilter ( compressionLevel ) );
        }
        else
        {
            this.session.getFilterChain ().addBefore ( "frameCodec", "streamCompression", new CompressionFilter ( compressionLevel ) );
        }
    }

    public void startKeepAlive ( final int pingFrequency, final int timeout /*in seconds */)
    {
        final int pingInterval = (int)Math.ceil ( (double)timeout / (double)pingFrequency );
        logger.info ( "Starting keep alive - frequency: {}, timeout: {} seconds, ping interval: {} seconds", new Object[] { pingFrequency, timeout, pingInterval } );
        this.session.getFilterChain ().addBefore ( "messageChannelCodec", "keepalive", new KeepAliveFilter ( new MessageChannelKeepAliceFactory (), IdleStatus.READER_IDLE, KeepAliveRequestTimeoutHandler.CLOSE, pingInterval, timeout ) );
    }

    public void startSsl ( final boolean startInactive, final boolean clientMode ) throws Exception
    {
        logger.info ( "Starting SSL (startInactive: {})", startInactive );

        final ProtocolConfiguration configuration = ProtocolConfiguration.fromSession ( this.session );

        final SslContextFactory sslFactory = configuration.getSslContextFactory ();

        final SSLContext sslContext = sslFactory.newInstance ();
        if ( startInactive )
        {
            this.session.setAttribute ( SslFilter.DISABLE_ENCRYPTION_ONCE, Boolean.TRUE );
        }

        final SslFilter filter = new SslFilter ( sslContext );
        filter.setUseClientMode ( clientMode );
        filter.setWantClientAuth ( false );
        filter.setNeedClientAuth ( false );

        if ( logger.isDebugEnabled () )
        {
            logger.debug ( "Enabled protocols:" );
            for ( final String protocol : sslContext.getDefaultSSLParameters ().getProtocols () )
            {
                logger.debug ( "\t" + protocol );
            }
            logger.debug ( "Enabled ciphers:" );
            for ( final String cipher : sslContext.getDefaultSSLParameters ().getCipherSuites () )
            {
                logger.debug ( "\t" + cipher );
            }
        }

        if ( this.session.getFilterChain ().contains ( "logger.raw" ) )
        {
            this.session.getFilterChain ().addAfter ( "logger.raw", "ssl", filter );
        }
        else
        {
            this.session.getFilterChain ().addFirst ( "ssl", filter );
        }

    }
}
