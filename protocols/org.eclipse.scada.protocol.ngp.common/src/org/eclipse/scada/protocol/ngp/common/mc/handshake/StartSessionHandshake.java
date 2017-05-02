/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.Map;

import org.apache.mina.core.write.DefaultWriteRequest;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelFilter;
import org.eclipse.scada.protocol.ngp.common.mc.message.StartMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartSessionHandshake implements Handshake
{
    private final static Logger logger = LoggerFactory.getLogger ( StartSessionHandshake.class );

    private static final String PROP_ENABLE = "startSession.enable";

    protected boolean isEnabled ( final Map<String, String> properties )
    {
        final String value = properties.get ( PROP_ENABLE );

        logger.debug ( "Property value: {}", value );

        if ( value == null )
        {
            return false;
        }
        return Boolean.parseBoolean ( value );
    }

    @Override
    public void request ( final HandshakeContext context, final Map<String, String> helloProperties )
    {
        logger.debug ( "Requesting enable" );
        helloProperties.put ( PROP_ENABLE, "true" );
    }

    @Override
    public void handshake ( final HandshakeContext context, final Map<String, String> helloProperties, final Map<String, String> acceptedProperties ) throws Exception
    {
        if ( isEnabled ( helloProperties ) )
        {
            logger.debug ( "Enable session start handling" );
            acceptedProperties.put ( PROP_ENABLE, "true" );
        }
    }

    @Override
    public void apply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
        // nothing to do here ... we are waiting for all other to set themselves up
    }

    @Override
    public void postApply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
        if ( isEnabled ( acceptedProperties ) )
        {
            if ( context.isClientMode () )
            {
                // the feature is enabled and we are on the client side, tell the server we are ready
                logger.debug ( "Sending session start" );
                context.getNextFilter ().filterWrite ( context.getSession (), new DefaultWriteRequest ( new StartMessage () ) );
            }
        }
        else
        {
            if ( !context.isClientMode () )
            {
                // the feature is disabled and we are on the server side, we are ready then
                // otherwise we need to wait for a response from the client
                // yet we only mark the session as open, it well actually be opened by the MessageChannelFilter for us
                logger.debug ( "Marking session directly as opened since we are not enabled" );
                MessageChannelFilter.markOpened ( context.getSession () );
            }
        }
    }

    @Override
    public void sessionStarted ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
        // nothing to do here, we started the session
    }

}
