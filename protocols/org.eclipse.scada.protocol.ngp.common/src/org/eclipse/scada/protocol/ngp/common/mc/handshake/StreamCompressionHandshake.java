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
 *     IBH SYSTEMS GmbH - fix a possible NPE when the stream compression
 *                        was disabled in the constructor, fix regression
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.Map;

import org.apache.mina.filter.compression.CompressionFilter;
import org.eclipse.scada.protocol.ngp.common.ChainConfigurator;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.mc.message.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamCompressionHandshake extends AbstractHandshake
{

    private static final String PROP_DISABLE_COMPRESSION = "org.eclipse.scada.protocol.ngp.common.mc.handshake.disableCompression";

    private final static Logger logger = LoggerFactory.getLogger ( StreamCompressionHandshake.class );

    private final Integer maxStreamCompressionLevel;

    public StreamCompressionHandshake ( final Integer maxStreamCompressionLevel )
    {
        if ( Boolean.getBoolean ( PROP_DISABLE_COMPRESSION ) )
        {
            logger.info ( "Stream compression disabled by system property (%s)", PROP_DISABLE_COMPRESSION );
            this.maxStreamCompressionLevel = null;
        }
        else if ( maxStreamCompressionLevel != null )
        {
            this.maxStreamCompressionLevel = Math.min ( maxStreamCompressionLevel, CompressionFilter.COMPRESSION_MAX );
        }
        else
        {
            this.maxStreamCompressionLevel = null;
        }
    }

    @Override
    public void request ( final HandshakeContext handshakeContext, final Map<String, String> helloProperties )
    {
        if ( Boolean.getBoolean ( PROP_DISABLE_COMPRESSION ) )
        {
            logger.info ( "Stream compression disabled by system property (%s)", PROP_DISABLE_COMPRESSION );
            return;
        }

        final ProtocolConfiguration protocolConfiguration = handshakeContext.getProtocolConfiguration ();
        logger.debug ( "Stream compression in protocol configuration: {}", protocolConfiguration.getStreamCompressionLevel () );

        if ( protocolConfiguration.getStreamCompressionLevel () == -1 || protocolConfiguration.getStreamCompressionLevel () > 0 )
        {
            final String value = String.format ( "%s", protocolConfiguration.getStreamCompressionLevel () );
            logger.info ( "Requesting stream compression level = {}", value );
            helloProperties.put ( Constants.PROP_STREAM_COMPRESSION_LEVEL, value );
        }
    }

    @Override
    public void handshake ( final HandshakeContext handshakeContext, final Map<String, String> helloProperties, final Map<String, String> acceptedProperties ) throws Exception
    {
        final Integer streamCompressionLevel = performHandshake ( helloProperties, acceptedProperties );
        logger.info ( "Setting stream compression to: {}", streamCompressionLevel );

        if ( streamCompressionLevel != null )
        {
            acceptedProperties.put ( Constants.PROP_STREAM_COMPRESSION_LEVEL, "" + streamCompressionLevel );
        }
    }

    protected Integer performHandshake ( final Map<String, String> helloProperties, final Map<String, String> acceptedProperties )
    {
        final Integer streamCompressionLevel = getInteger ( helloProperties, Constants.PROP_STREAM_COMPRESSION_LEVEL, null );

        logger.debug ( "Stream compression level settings - ours: {}, theirs: {}", this.maxStreamCompressionLevel, streamCompressionLevel );

        if ( streamCompressionLevel == null )
        {
            // client does not support stream compression
            return null;
        }
        if ( this.maxStreamCompressionLevel == null )
        {
            // server does not support stream compression
            return null;
        }

        if ( streamCompressionLevel < 0 )
        {
            // the server may fully decide
            return this.maxStreamCompressionLevel;
        }
        else if ( this.maxStreamCompressionLevel < 0 )
        {
            // the client may fully decide
            return streamCompressionLevel;
        }
        else
        {
            return Math.min ( this.maxStreamCompressionLevel, streamCompressionLevel );
        }
    }

    @Override
    public void apply ( final HandshakeContext handshakeContext, final Map<String, String> acceptedProperties ) throws Exception
    {
        final Integer streamCompressionLevel = getInteger ( acceptedProperties, Constants.PROP_STREAM_COMPRESSION_LEVEL, null );
        if ( streamCompressionLevel != null )
        {
            /* if we are in client mode the first packet (START) must already be compressed.
             * on the server side the first packet (ACCECPT) must must be unfiltered */
            new ChainConfigurator ( handshakeContext.getSession () ).startStreamCompression ( streamCompressionLevel, !handshakeContext.isClientMode () );
        }
    }

    @Override
    public void postApply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
    }

    @Override
    public void sessionStarted ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
    }
}
