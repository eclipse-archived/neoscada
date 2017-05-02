/*******************************************************************************
 * Copyright (c) 2010, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - cleanups and fixes, add "requireSsl"
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common;

import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.compression.CompressionFilter;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.Handshake;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.serialize.ObjectSerializationProtocolDescriptor;

public class ProtocolConfiguration
{
    private static final ProtocolConfiguration DEFAULT_CONFIGURATION;

    static
    {
        DEFAULT_CONFIGURATION = new ProtocolConfiguration ( null );
    }

    private int streamCompressionLevel = CompressionFilter.COMPRESSION_NONE;

    private int handshakeTimeout = Integer.getInteger ( "org.eclipse.scada.protocol.ngp.common.handshakeTimeout", 10000 );

    private int pingFrequency = 3;

    private int timeout = 10000;

    private SslContextFactory sslContextFactory;

    private boolean sslRequired = false;

    private List<String> preferredProtocols = new LinkedList<String> ();

    private List<ProtocolDescriptor> protocols = new LinkedList<ProtocolDescriptor> ();

    private List<Handshake> handshakeHandlers = new LinkedList<Handshake> ();

    /**
     * Create a new protocol configuration
     * <br>
     * This protocol configuration will have the
     * {@link ObjectSerializationProtocolDescriptor} added
     *
     * @param classLoader
     *            the class loader which is passed to the constructor
     *            {@link ObjectSerializationProtocolDescriptor#ObjectSerializationProtocolDescriptor(String, ClassLoader)}
     *            , may be {@code null}
     */
    public ProtocolConfiguration ( final ClassLoader classLoader )
    {
        this.protocols.add ( new ObjectSerializationProtocolDescriptor ( null, classLoader ) );
    }

    public ProtocolConfiguration ()
    {
    }

    public List<Handshake> getHandshakeHandlers ()
    {
        return this.handshakeHandlers;
    }

    public void setHandshakeHandlers ( final List<Handshake> handshakeHandlers )
    {
        this.handshakeHandlers = handshakeHandlers;
    }

    public void addHandshakeHandler ( final Handshake handshake )
    {
        this.handshakeHandlers.add ( handshake );
    }

    public void setPreferredProtocols ( final List<String> preferredProtocols )
    {
        this.preferredProtocols = preferredProtocols;
    }

    public List<String> getPreferredProtocols ()
    {
        return this.preferredProtocols;
    }

    public void setSslContextFactory ( final SslContextFactory sslContextFactory )
    {
        this.sslContextFactory = sslContextFactory;
    }

    public SslContextFactory getSslContextFactory ()
    {
        return this.sslContextFactory;
    }

    public void setSslRequired ( final boolean sslRequired )
    {
        this.sslRequired = sslRequired;
    }

    public boolean isSslRequired ()
    {
        return this.sslRequired;
    }

    public void setPingFrequency ( final int pingFrequency )
    {
        this.pingFrequency = pingFrequency;
    }

    public int getPingFrequency ()
    {
        return this.pingFrequency;
    }

    public void setTimeout ( final int timeout )
    {
        this.timeout = timeout;
    }

    public int getTimeout ()
    {
        return this.timeout;
    }

    public void setStreamCompressionLevel ( final int streamCompressionLevel )
    {
        this.streamCompressionLevel = streamCompressionLevel;
    }

    public int getStreamCompressionLevel ()
    {
        return this.streamCompressionLevel;
    }

    public void setHandshakeTimeout ( final int handshakeTimeout )
    {
        this.handshakeTimeout = handshakeTimeout;
    }

    public int getHandshakeTimeout ()
    {
        return this.handshakeTimeout;
    }

    public static ProtocolConfiguration fromSession ( final IoSession session )
    {
        final Object result = session.getAttribute ( "protocol.configuration" );
        if ( result != null )
        {
            return (ProtocolConfiguration)result;
        }

        return DEFAULT_CONFIGURATION;
    }

    public void assign ( final IoSession session )
    {
        session.setAttribute ( "protocol.configuration", this );
    }

    public List<ProtocolDescriptor> getProtocols ()
    {
        return this.protocols;
    }

    public void setProtocols ( final List<ProtocolDescriptor> protocols )
    {
        this.protocols = protocols;
    }
}
