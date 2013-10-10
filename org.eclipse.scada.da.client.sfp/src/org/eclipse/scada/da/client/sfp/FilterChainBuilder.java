/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.eclipse.scada.protocol.common.IoLoggerFilterChainBuilder;
import org.eclipse.scada.protocol.common.StatisticsFilter;
import org.eclipse.scada.protocol.sfp.ProtocolDecoderImpl;
import org.eclipse.scada.protocol.sfp.ProtocolEncoderImpl;

public class FilterChainBuilder implements IoLoggerFilterChainBuilder
{
    private String loggerName;

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
        if ( this.loggerName != null && Boolean.getBoolean ( "org.eclipse.scada.protocol.sfp.common.logger.raw" ) )
        {
            chain.addFirst ( "logger.raw", new LoggingFilter ( this.loggerName ) );
        }

        if ( !Boolean.getBoolean ( "org.eclipse.scada.protocol.sfp.common.disableStats" ) )
        {
            chain.addFirst ( StatisticsFilter.DEFAULT_NAME, new StatisticsFilter () );
        }

        if ( this.loggerName != null && Boolean.getBoolean ( "org.eclipse.scada.protocol.sfp.common.logger" ) )
        {
            chain.addFirst ( "logger", new LoggingFilter ( this.loggerName ) );
        }

        chain.addLast ( "closeidle", new IoFilterAdapter () {
            @Override
            public void sessionIdle ( final NextFilter nextFilter, final IoSession session, final IdleStatus status ) throws Exception
            {
                session.close ( true );
            }
        } );
        chain.addLast ( "codec", new ProtocolCodecFilter ( new ProtocolEncoderImpl (), new ProtocolDecoderImpl () ) );
    }
}
