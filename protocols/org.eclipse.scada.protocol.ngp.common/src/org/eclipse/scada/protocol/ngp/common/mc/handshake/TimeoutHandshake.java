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

import java.util.Map;

import org.eclipse.scada.protocol.ngp.common.ChainConfigurator;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelFilter;
import org.eclipse.scada.protocol.ngp.common.mc.message.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeoutHandshake extends AbstractHandshake
{
    private final static Logger logger = LoggerFactory.getLogger ( TimeoutHandshake.class );

    @Override
    public void request ( final HandshakeContext handshakeContext, final Map<String, String> helloProperties )
    {
        helloProperties.put ( Constants.PROP_TIMEOUT, "" + handshakeContext.getProtocolConfiguration ().getTimeout () );
    }

    @Override
    public void handshake ( final HandshakeContext handshakeContext, final Map<String, String> helloProperties, final Map<String, String> acceptedProperties ) throws Exception
    {
        final Integer timeout = getInteger ( helloProperties, Constants.PROP_TIMEOUT, null );
        if ( timeout != null )
        {
            final int newTimeout = Math.min ( Math.max ( timeout, MessageChannelFilter.MIN_TIMEOUT ), MessageChannelFilter.MAX_TIMEOUT );
            logger.info ( "Timeout setting = {}", newTimeout );
            acceptedProperties.put ( Constants.PROP_TIMEOUT, "" + newTimeout );
        }
    }

    @Override
    public void apply ( final HandshakeContext handshakeContext, final Map<String, String> acceptedProperties ) throws Exception
    {
    }

    @Override
    public void postApply ( final HandshakeContext handshakeContext, final Map<String, String> acceptedProperties ) throws Exception
    {
    }

    @Override
    public void sessionStarted ( final HandshakeContext handshakeContext, final Map<String, String> acceptedProperties ) throws Exception
    {
        // the pinging is started when the session got opened
        final Integer timeout = getInteger ( acceptedProperties, Constants.PROP_TIMEOUT, null );

        if ( timeout != null )
        {
            final int pingFrequency = Integer.getInteger ( "org.eclipse.scada.protocol.ngp.common.mc.pingFrequency", 3 );
            new ChainConfigurator ( handshakeContext.getSession () ).startKeepAlive ( pingFrequency, (int)Math.ceil ( timeout / 1000.0 ) );
            return;
        }

        new ChainConfigurator ( handshakeContext.getSession () ).startKeepAlive ( handshakeContext.getProtocolConfiguration ().getPingFrequency (), (int)Math.ceil ( handshakeContext.getProtocolConfiguration ().getTimeout () / 1000.0 ) );
    }
}
