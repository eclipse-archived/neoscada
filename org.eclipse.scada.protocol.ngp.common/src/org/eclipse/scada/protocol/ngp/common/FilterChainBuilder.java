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

import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.eclipse.scada.protocol.common.IoLoggerFilterChainBuilder;
import org.eclipse.scada.protocol.common.StatisticsFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelCodecFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelFilter;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameDecoder;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameEncoder;

public class FilterChainBuilder implements IoLoggerFilterChainBuilder
{
    private final boolean clientMode;

    private String loggerName;

    public FilterChainBuilder ( final boolean clientMode )
    {
        this.clientMode = clientMode;
    }

    @Override
    public void setLoggerName ( final String loggerName )
    {
        this.loggerName = loggerName;
    }

    public String getLoggerName ()
    {
        return this.loggerName;
    }

    @Override
    public void buildFilterChain ( final IoFilterChain chain )
    {
        if ( this.loggerName != null && Boolean.getBoolean ( "org.eclipse.scada.protocol.ngp.common.logger.raw" ) )
        {
            chain.addFirst ( "logger.raw", new LoggingFilter ( this.loggerName ) );
        }

        if ( !Boolean.getBoolean ( "org.eclipse.scada.protocol.ngp.common.disableStats" ) )
        {
            chain.addFirst ( StatisticsFilter.DEFAULT_NAME, new StatisticsFilter () );
        }

        if ( this.loggerName != null && Boolean.getBoolean ( "org.eclipse.scada.protocol.ngp.common.logger" ) )
        {
            chain.addFirst ( "logger", new LoggingFilter ( this.loggerName ) );
        }

        chain.addLast ( "frameCodec", new ProtocolCodecFilter ( new FrameEncoder (), new FrameDecoder () ) );

        chain.addLast ( "messageChannelCodec", new MessageChannelCodecFilter () );
        chain.addLast ( "messageChannel", new MessageChannelFilter ( this.clientMode ) );
    }
}
