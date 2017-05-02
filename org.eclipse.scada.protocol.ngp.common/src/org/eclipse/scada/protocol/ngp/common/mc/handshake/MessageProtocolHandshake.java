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


package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageProtocolHandshake implements Handshake
{

    private static final String PROP_CLIENT_PROTOCOL_PREFS = "preferredClientProtocols";

    private final static Logger logger = LoggerFactory.getLogger ( MessageProtocolHandshake.class );

    @Override
    public void request ( final HandshakeContext context, final Map<String, String> helloProperties )
    {
        final List<ProtocolDescriptor> protocols = context.getProtocolConfiguration ().getProtocols ();

        for ( final ProtocolDescriptor protocol : protocols )
        {
            logger.debug ( "Offering protocol : {}", protocol.getProtocolId () );
            helloProperties.put ( "protocol." + protocol.getProtocolId (), "true" );
        }

        if ( context.getProtocolConfiguration ().getPreferredProtocols () != null )
        {
            helloProperties.put ( PROP_CLIENT_PROTOCOL_PREFS, StringHelper.join ( context.getProtocolConfiguration ().getPreferredProtocols (), ", " ) );
        }
    }

    @Override
    public void handshake ( final HandshakeContext context, final Map<String, String> helloProperties, final Map<String, String> acceptedProperties ) throws Exception
    {
        final List<ProtocolDescriptor> protocols = context.getProtocolConfiguration ().getProtocols ();

        final List<String> preferredProtocols = context.getProtocolConfiguration ().getPreferredProtocols ();

        final List<String> possibleProtocols = new LinkedList<String> ();
        for ( final ProtocolDescriptor protocol : protocols )
        {
            if ( helloProperties.containsKey ( "protocol." + protocol.getProtocolId () ) )
            {
                logger.debug ( "Adding '{}' as possible protocol", protocol.getProtocolId () );
                possibleProtocols.add ( protocol.getProtocolId () );
            }
        }

        if ( possibleProtocols.isEmpty () )
        {
            throw new IllegalStateException ( "Unable to negotiate protocol. None found!" );
        }

        String chosenProtocol = null;
        for ( final String protocol : preferredProtocols )
        {
            if ( possibleProtocols.contains ( protocol ) )
            {
                // found a preferred protocol
                chosenProtocol = protocol;
                break;
            }

        }
        logger.debug ( "After preference selection: {}", chosenProtocol );

        if ( chosenProtocol == null )
        {
            final String preferredClientProtocols = helloProperties.get ( PROP_CLIENT_PROTOCOL_PREFS );
            logger.debug ( "Client preferences: {}", preferredClientProtocols );

            if ( preferredClientProtocols != null )
            {
                final String toks[] = preferredClientProtocols.split ( ", *" );
                for ( final String tok : toks )
                {
                    if ( possibleProtocols.contains ( tok ) )
                    {
                        chosenProtocol = tok;
                        break;
                    }
                }
            }

            logger.debug ( "After client selection: {}", chosenProtocol );
        }

        // choose first

        if ( chosenProtocol == null )
        {
            chosenProtocol = possibleProtocols.iterator ().next ();
            logger.debug ( "After any selection: {}", chosenProtocol );
        }

        logger.info ( "Using protocol: {}", chosenProtocol );
        acceptedProperties.put ( "protocol", chosenProtocol );
    }

    @Override
    public void apply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
        final String protocolId = acceptedProperties.get ( "protocol" );

        logger.debug ( "Activating protocol: {}", protocolId );

        if ( protocolId == null )
        {
            throw new IllegalStateException ( "Selected protocol cannot be null" );
        }

        final List<ProtocolDescriptor> protocols = context.getProtocolConfiguration ().getProtocols ();

        for ( final ProtocolDescriptor protocol : protocols )
        {
            if ( protocolId.equals ( protocol.getProtocolId () ) )
            {
                protocol.activate ( context.getSession () );
            }
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
