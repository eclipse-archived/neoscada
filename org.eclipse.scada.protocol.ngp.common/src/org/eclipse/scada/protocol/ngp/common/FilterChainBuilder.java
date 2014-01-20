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
 *     IBH SYSTEMS GmbH - extend the filter chain to re-use filters and
 *                        add a Executor filter
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.util.NoopFilter;
import org.eclipse.scada.protocol.common.IoLoggerFilterChainBuilder;
import org.eclipse.scada.protocol.common.StatisticsFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelCodecFilter;
import org.eclipse.scada.protocol.ngp.common.mc.MessageChannelFilter;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameDecoder;
import org.eclipse.scada.protocol.ngp.common.mc.frame.FrameEncoder;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;

public class FilterChainBuilder implements IoLoggerFilterChainBuilder
{
    private static AtomicLong THREAD_COUNTER = new AtomicLong ();

    private String loggerName;

    private static interface IoFilterFactory
    {
        public IoFilter create ();

        public void dispose () throws Exception;
    }

    private static abstract class IoFilterFactoryAdapter implements IoFilterFactory
    {
        @Override
        public void dispose ()
        {
        }
    }

    private static class StaticIoFilterFactory implements IoFilterFactory
    {
        private final IoFilter filter;

        public StaticIoFilterFactory ( final IoFilter filter )
        {
            this.filter = filter;
        }

        @Override
        public IoFilter create ()
        {
            return this.filter;
        }

        @Override
        public void dispose () throws Exception
        {
            this.filter.destroy ();
        }
    }

    private static class MarkerFactory extends IoFilterFactoryAdapter
    {
        @Override
        public IoFilter create ()
        {
            return new NoopFilter ();
        }
    }

    private final class LoggerFactory extends IoFilterFactoryAdapter
    {
        @Override
        public IoFilter create ()
        {
            if ( FilterChainBuilder.this.loggerName != null && Boolean.getBoolean ( "org.eclipse.scada.protocol.ngp.common.logger" ) )
            {
                return new LoggingFilter ( FilterChainBuilder.this.loggerName );
            }
            else
            {
                return null;
            }
        }
    }

    private static class Entry
    {
        private final String name;

        private final IoFilterFactory factory;

        public Entry ( final String name )
        {
            this ( name + ".marker", new MarkerFactory () );
        }

        public Entry ( final String name, final IoFilterFactory factory )
        {
            this.name = name;
            this.factory = factory;
        }

        public Entry ( final String name, final IoFilter filter )
        {
            this ( name, new StaticIoFilterFactory ( filter ) );
        }

        public IoFilterFactory getFactory ()
        {
            return this.factory;
        }

        public String getName ()
        {
            return this.name;
        }
    }

    private final List<Entry> filters = new LinkedList<> ();

    public FilterChainBuilder ( final boolean clientMode )
    {
        if ( !Boolean.getBoolean ( "org.eclipse.scada.protocol.ngp.common.disableStats" ) )
        {
            this.filters.add ( new Entry ( StatisticsFilter.DEFAULT_NAME, new StatisticsFilter () ) );
        }

        this.filters.add ( new Entry ( "logger.raw", new LoggerFactory () ) );

        this.filters.add ( new Entry ( "ssl" ) );
        this.filters.add ( new Entry ( "streamCompression" ) );

        this.filters.add ( new Entry ( "logger", new LoggerFactory () ) );

        this.filters.add ( new Entry ( "sync", new ExecutorFilter ( 0, 1, 1, TimeUnit.MINUTES, new NamedThreadFactory ( "org.eclipse.scada.protocol.ngp.common.FilterChainSync", false, true, THREAD_COUNTER ) ) ) );
        this.filters.add ( new Entry ( "frameCodec", new ProtocolCodecFilter ( new FrameEncoder (), new FrameDecoder () ) ) );

        this.filters.add ( new Entry ( "keepalive" ) );

        this.filters.add ( new Entry ( "messageChannelCodec", new MessageChannelCodecFilter () ) );
        this.filters.add ( new Entry ( "messageChannel", new IoFilterFactoryAdapter () {

            @Override
            public IoFilter create ()
            {
                // we need new instances of MessageChannelFilter
                return new MessageChannelFilter ( clientMode );
            }
        } ) );
    }

    @Override
    public void dispose ()
    {
        for ( final Entry entry : this.filters )
        {
            try
            {
                entry.factory.dispose ();
            }
            catch ( final Exception e )
            {
            }
        }
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
        for ( final Entry entry : this.filters )
        {
            final IoFilter filter = entry.getFactory ().create ();
            if ( filter != null )
            {
                chain.addLast ( entry.getName (), filter );
            }
        }

    }
}
