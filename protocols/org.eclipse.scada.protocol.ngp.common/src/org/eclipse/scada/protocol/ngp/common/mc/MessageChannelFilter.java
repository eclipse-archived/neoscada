/*******************************************************************************
 * Copyright (c) 2013, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     Jürgen Rose - changes, fixes and modifications for timeout handling
 *     IBH SYSTEMS GmbH - add some logging, fix regression
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain.Entry;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.DefaultWriteRequest;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.filter.compression.CompressionFilter;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.Handshake;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.HandshakeContext;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.MessageProtocolHandshake;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.SslFeatureHandshake;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.StartSessionHandshake;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.StreamCompressionHandshake;
import org.eclipse.scada.protocol.ngp.common.mc.handshake.TimeoutHandshake;
import org.eclipse.scada.protocol.ngp.common.mc.message.AcceptMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.CloseMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.DataMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.HelloMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.StartMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageChannelFilter extends IoFilterAdapter
{

    private final static Logger logger = LoggerFactory.getLogger ( MessageChannelFilter.class );

    public static final int MAX_TIMEOUT = Integer.getInteger ( "org.eclipse.scada.protocol.ngp.common.mc.maxTimeoutSeconds", 10 * 60 ) * 1000; //$NON-NLS-1$ // max 10 minutes

    public static final int MIN_TIMEOUT = Integer.getInteger ( "org.eclipse.scada.protocol.ngp.common.mc.minTimeoutSeconds", 10 ) * 1000; //$NON-NLS-1$ // less than 10 seconds makes no sense

    private final boolean clientMode;

    private final List<Handshake> handshakeHandlers = new LinkedList<Handshake> ();

    private Map<String, String> acceptedProperties;

    public MessageChannelFilter ( final boolean clientMode )
    {
        this.clientMode = clientMode;

        // the order is important
        this.handshakeHandlers.add ( new StartSessionHandshake () );
        this.handshakeHandlers.add ( new SslFeatureHandshake () );
        this.handshakeHandlers.add ( new TimeoutHandshake () );
        this.handshakeHandlers.add ( new StreamCompressionHandshake ( CompressionFilter.COMPRESSION_DEFAULT ) );
        this.handshakeHandlers.add ( new MessageProtocolHandshake () );
    }

    private List<Handshake> getHanshakeHandlers ( final ProtocolConfiguration protocolConfiguration )
    {
        final List<Handshake> result = new LinkedList<Handshake> ( this.handshakeHandlers );

        result.addAll ( protocolConfiguration.getHandshakeHandlers () );

        return result;
    }

    @Override
    public void sessionOpened ( final NextFilter nextFilter, final IoSession session ) throws Exception
    {
        final ProtocolConfiguration configuration = ProtocolConfiguration.fromSession ( session );

        // init timeout for handshake
        // FIXME: this is not a real timeout but a read idle timeout only
        session.getConfig ().setReaderIdleTime ( (int)Math.ceil ( configuration.getHandshakeTimeout () / 1000.0 ) );

        if ( this.clientMode )
        {
            nextFilter.filterWrite ( session, new DefaultWriteRequest ( createHelloMessage ( session, nextFilter ) ) );
        }
    }

    @Override
    public void filterWrite ( final NextFilter nextFilter, final IoSession session, final WriteRequest writeRequest ) throws Exception
    {
        if ( ! ( writeRequest.getMessage () instanceof DataMessage ) )
        {
            throw new IllegalStateException ( String.format ( "Can only handle messages of type %s (this is: %s)", DataMessage.class, writeRequest.getMessage () ) ); //$NON-NLS-1$
        }

        super.filterWrite ( nextFilter, session, writeRequest );
    }

    @Override
    public void messageReceived ( final NextFilter nextFilter, final IoSession session, final Object message ) throws Exception
    {
        logger.debug ( "messageReceived - message: {}, session: {}", message, session ); //$NON-NLS-1$

        final boolean opened = isOpened ( session );

        if ( message instanceof HelloMessage && !opened && !this.clientMode )
        {
            // received hello when we need it
            final Object reply = createSession ( session, nextFilter, (HelloMessage)message );
            logger.info ( "Reply to session creation: {}", reply ); //$NON-NLS-1$

            if ( reply instanceof AcceptMessage )
            {
                this.acceptedProperties = Collections.unmodifiableMap ( ( (AcceptMessage)reply ).getProperties () );

                // configure the session, enable filters
                configureSession ( session, nextFilter, this.acceptedProperties );

                /*
                 * send reply - this must be the first message after the configureSession call
                 * so that filter can reset their initial flag. The first message must still be
                 * un-filtered since the other side needs to adapt its filter chain first. However
                 * this must be an atomic operation since sending and changing the filter in two
                 * separate steps could mean that we already receive the reply to our ACCEPT
                 * before we had a chance to change our filter chain. 
                 */
                nextFilter.filterWrite ( session, new DefaultWriteRequest ( reply ) );

                // post configure the session
                postConfigureSession ( session, nextFilter, this.acceptedProperties );

                if ( isOpened ( session ) )
                {
                    // if the session is marked "open" by the StartSessionHandshake, then notify the open state immediately
                    startSession ( session, nextFilter );
                }
            }
            else
            {
                // send reply
                nextFilter.filterWrite ( session, new DefaultWriteRequest ( reply ) );
                // close - after message was sent
                session.close ( false );
            }
            dumpFilterChain ( session );
            logger.debug ( "Done handling HelloMessage" );
        }
        else if ( message instanceof AcceptMessage && !opened && this.clientMode )
        {
            this.acceptedProperties = Collections.unmodifiableMap ( ( (AcceptMessage)message ).getProperties () );
            configureSession ( session, nextFilter, this.acceptedProperties );
            postConfigureSession ( session, nextFilter, this.acceptedProperties );
            markOpened ( session );
            startSession ( session, nextFilter );
            dumpFilterChain ( session );
        }
        else if ( message instanceof CloseMessage )
        {
            // remote will close
            session.setAttribute ( "closeReason.message", ( (CloseMessage)message ).getMessage () ); //$NON-NLS-1$
            session.setAttribute ( "closeReason.code", ( (CloseMessage)message ).getCode () ); //$NON-NLS-1$
            session.close ( true );
        }
        else if ( message instanceof DataMessage && opened )
        {
            nextFilter.messageReceived ( session, message );
        }
        else if ( message instanceof StartMessage && !opened )
        {
            logger.debug ( "Starting session" );
            markOpened ( session );
            startSession ( session, nextFilter );
            dumpFilterChain ( session );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "(opened: %s) Message type: %s", opened, message.getClass () ) ); //$NON-NLS-1$
        }
    }

    public Map<String, String> getAcceptedProperties ()
    {
        return this.acceptedProperties;
    }

    private void startSession ( final IoSession session, final NextFilter nextFilter ) throws Exception
    {
        if ( logger.isDebugEnabled () )
        {
            logger.debug ( "Starting channel: {}", session );
            logProperties ( "Configure session - acceptedProperties", this.acceptedProperties ); //$NON-NLS-1$
        }

        final HandshakeContext context = new HandshakeContext ( ProtocolConfiguration.fromSession ( session ), this.clientMode, session, nextFilter );

        for ( final Handshake handshake : getHanshakeHandlers ( ProtocolConfiguration.fromSession ( session ) ) )
        {
            handshake.sessionStarted ( context, this.acceptedProperties );
        }

        nextFilter.sessionOpened ( session );
    }

    private void dumpFilterChain ( final IoSession session )
    {
        if ( logger.isInfoEnabled () )
        {
            logger.info ( "Filter chain:" );

            for ( final Entry entry : session.getFilterChain ().getAll () )
            {
                logger.info ( "\t{} -> {}", entry.getName (), entry.getFilter () );
            }
        }
    }

    private Object createHelloMessage ( final IoSession session, final NextFilter nextFilter )
    {
        final HandshakeContext context = new HandshakeContext ( ProtocolConfiguration.fromSession ( session ), this.clientMode, session, nextFilter );

        final Map<String, String> helloProperties = new HashMap<String, String> ();

        for ( final Handshake handshake : getHanshakeHandlers ( ProtocolConfiguration.fromSession ( session ) ) )
        {
            handshake.request ( context, helloProperties );
        }

        if ( logger.isDebugEnabled () )
        {
            logProperties ( "Request session - helloProperties", helloProperties ); //$NON-NLS-1$
        }

        return new HelloMessage ( helloProperties );
    }

    private void configureSession ( final IoSession session, final NextFilter nextFilter, final Map<String, String> acceptedProperties ) throws Exception
    {
        final HandshakeContext context = new HandshakeContext ( ProtocolConfiguration.fromSession ( session ), this.clientMode, session, nextFilter );

        if ( logger.isDebugEnabled () )
        {
            logProperties ( "Configure session - acceptedProperties", acceptedProperties ); //$NON-NLS-1$
        }

        logger.debug ( "Running apply" );

        for ( final Handshake handshake : getHanshakeHandlers ( ProtocolConfiguration.fromSession ( session ) ) )
        {
            handshake.apply ( context, acceptedProperties );
        }
    }

    private void postConfigureSession ( final IoSession session, final NextFilter nextFilter, final Map<String, String> acceptedProperties ) throws Exception
    {
        final HandshakeContext context = new HandshakeContext ( ProtocolConfiguration.fromSession ( session ), this.clientMode, session, nextFilter );

        logger.debug ( "Running post apply" );

        for ( final Handshake handshake : getHanshakeHandlers ( ProtocolConfiguration.fromSession ( session ) ) )
        {
            handshake.postApply ( context, acceptedProperties );
        }
    }

    private Object createSession ( final IoSession session, final NextFilter nextFilter, final HelloMessage message )
    {
        final Map<String, String> acceptedProperties = new HashMap<String, String> ();
        final Map<String, String> helloProperties = message.getProperties ();

        final ProtocolConfiguration protocolConfiguration = ProtocolConfiguration.fromSession ( session );

        final HandshakeContext context = new HandshakeContext ( protocolConfiguration, this.clientMode, session, nextFilter );

        if ( logger.isDebugEnabled () )
        {
            logProperties ( "Create session - helloProperties", helloProperties ); //$NON-NLS-1$
        }

        try
        {
            for ( final Handshake handshake : getHanshakeHandlers ( ProtocolConfiguration.fromSession ( session ) ) )
            {
                handshake.handshake ( context, helloProperties, acceptedProperties );
            }

            if ( logger.isDebugEnabled () )
            {
                logProperties ( "Create session - acceptedProperties", acceptedProperties ); //$NON-NLS-1$
            }

            return new AcceptMessage ( acceptedProperties );
        }
        catch ( final Exception e )
        {
            return new CloseMessage ( "Failed handshake on message channel properties: " + e.getMessage (), -2 ); //$NON-NLS-1$
        }
    }

    private void logProperties ( final String string, final Map<String, String> properties )
    {
        final StringBuilder sb = new StringBuilder ( string );
        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            sb.append ( "\n\t'" ); //$NON-NLS-1$
            sb.append ( entry.getKey () );
            sb.append ( "' => '" ); //$NON-NLS-1$
            sb.append ( entry.getValue () );
            sb.append ( '\'' );
        }
        logger.debug ( sb.toString () );
    }

    public static boolean isOpened ( final IoSession session )
    {
        return Boolean.TRUE.equals ( session.getAttribute ( "opened", Boolean.FALSE ) ); //$NON-NLS-1$
    }

    public static void markOpened ( final IoSession session )
    {
        session.setAttribute ( "opened", Boolean.TRUE ); //$NON-NLS-1$
    }
}
