/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - clean up filter registration
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common;

import javax.net.ssl.SSLContext;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain.Entry;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.compression.CompressionFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.filter.util.NoopFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelKeepAliveFactory;
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

    /**
     * Replace an IOFilter that as pre-registered as {@link NoopFilter} with the
     * ".marker" suffix
     * 
     * @param name
     *            the name, without the ".marker" suffix
     * @param filter
     *            the filter replacement
     */
    protected void replaceMarker ( final String name, final IoFilter filter )
    {
        final Entry entry = this.session.getFilterChain ().getEntry ( name + ".marker" );
        if ( entry == null )
        {
            throw new IllegalStateException ( String.format ( "Filter with name '%s.marker' is missing", name ) );
        }
        entry.addAfter ( name, filter );
        entry.remove ();
    }

    public void startStreamCompression ( final int compressionLevel, final boolean startInactive )
    {
        logger.info ( "Starting stream compression: {} (startInactive: {})", compressionLevel, startInactive );

        if ( startInactive )
        {
            this.session.setAttribute ( CompressionFilter.DISABLE_COMPRESSION_ONCE, Boolean.TRUE );
        }
        replaceMarker ( "streamCompression", new CompressionFilter ( compressionLevel ) );
    }

    public void startKeepAlive ( final int pingFrequency, final int timeout /*in seconds */)
    {
        final int pingInterval = (int)Math.ceil ( (double)timeout / (double)pingFrequency );
        logger.info ( "Starting keep alive - frequency: {}, timeout: {} seconds, ping interval: {} seconds", new Object[] { pingFrequency, timeout, pingInterval } );
        replaceMarker ( "keepalive", new KeepAliveFilter ( new MessageChannelKeepAliveFactory (), IdleStatus.READER_IDLE, KeepAliveRequestTimeoutHandler.CLOSE, pingInterval, timeout ) );
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

        replaceMarker ( "ssl", filter );
    }
}
