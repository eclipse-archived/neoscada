/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.core.service.SimpleIoProcessorPool;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.server.common.osgi.factory.ObjectPoolDataItemFactory;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.common.StaticHiveSource;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceDefinition;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceType;

public class StaticModbusExport extends ModbusExport
{

    public static class Builder
    {
        private final HiveSource hiveSource;

        private ThreadFactory threadFactory;

        private IoProcessor<NioSession> processor;

        private Properties hiveProperies = new Properties ();

        private int readTimeout = 30_000;

        private int port = 1502;

        private short slaveId = 1;

        private List<SourceDefinition> definitions = new LinkedList<> ();

        public Builder ( final Hive hive )
        {
            this.hiveSource = new StaticHiveSource ( hive );
        }

        /**
         * Set the hive session creation properties (e.g. username/password)
         *
         * @param hiveProperies
         *            the hive session creation properties
         */
        public void setHiveProperies ( final Properties hiveProperies )
        {
            this.hiveProperies = hiveProperies;
        }

        /**
         * Set a new read timeout in milliseconds <br/>
         * The default read timeout is 30000ms (30 seconds)
         *
         * @param readTimeout
         *            the new read timeout
         */
        public void setReadTimeout ( final int readTimeout )
        {
            if ( readTimeout <= 0 )
            {
                throw new IllegalArgumentException ( String.format ( "'readTimeout' must not be negative or zero" ) );
            }
            this.readTimeout = readTimeout;
        }

        public void setPort ( final int port )
        {
            if ( port <= 0 || port >= 0xFFFF )
            {
                throw new IllegalArgumentException ( String.format ( "'port' must be between 0 (exclusive) and 0xFFFF (exclusive) but is %s", port ) );
            }
            this.port = port;
        }

        public void setSlaveId ( final short slaveId )
        {
            if ( slaveId <= 0 || slaveId >= 0xFF )
            {
                throw new IllegalArgumentException ( String.format ( "'slaveId' must be between 0 (exclusive) and 0xFFFF (exclusive) but is %s", slaveId ) );
            }
            this.slaveId = slaveId;
        }

        /**
         * Set a custom thread factory <br/>
         * If the thread factory is <code>null</code>, or not set then a default
         * thread factory will be used
         *
         * @param threadFactory
         *            the thread factory to use
         */
        public void setThreadFactory ( final ThreadFactory threadFactory )
        {
            this.threadFactory = threadFactory;
        }

        /**
         * Set a custom IO processor
         *
         * @param processor
         */
        public void setIoProcessor ( final IoProcessor<NioSession> processor )
        {
            this.processor = processor;
        }

        /**
         * Set (replace) all current source definitions
         *
         * @param definitions
         *            the new source definitions
         */
        public void setDefinitions ( final Collection<SourceDefinition> definitions )
        {
            if ( definitions != null )
            {
                this.definitions = new LinkedList<> ( definitions );
            }
            else
            {
                this.definitions = new LinkedList<> ();
            }
        }

        /**
         * Add an export (source definition) to the current set
         *
         * @param itemId
         *            the ID of the item
         * @param offset
         *            the offset (in bytes) were to map the item to
         * @param type
         *            the data type provider
         */
        public void addExport ( final String itemId, final int offset, final SourceType type )
        {
            if ( itemId == null )
            {
                throw new IllegalArgumentException ( String.format ( "'itemId' must not be null" ) );
            }
            if ( offset < 0 )
            {
                throw new IllegalArgumentException ( String.format ( "'offset' must not be negative (%s)", offset ) );
            }
            if ( offset >= 0xFFFF )
            {
                throw new IllegalArgumentException ( String.format ( "'offset' be less then 0xFFFF (%s)", offset ) );
            }
            if ( type == null )
            {
                throw new IllegalArgumentException ( String.format ( "'type' must not be null" ) );
            }

            this.definitions.add ( new SourceDefinition ( itemId, offset, type ) );
        }

        /**
         * Build a new modbus export instance based on the current builder state <br/>
         * <em>Note:</em> The call is responsible for disposing the created
         * instance using {@link ModbusExport#dispose()}.
         *
         * @return a newly created modbus instance
         */
        public ModbusExport build ()
        {
            final ScheduledExecutorService executor;
            if ( this.threadFactory == null )
            {
                executor = Executors.newScheduledThreadPool ( 1 );
            }
            else
            {
                executor = Executors.newScheduledThreadPool ( 1, this.threadFactory );
            }

            boolean disposeProcessor;
            final IoProcessor<NioSession> processor;
            if ( this.processor == null )
            {
                processor = new SimpleIoProcessorPool<> ( NioProcessor.class );
                disposeProcessor = true;
            }
            else
            {
                processor = this.processor;
                disposeProcessor = false;
            }

            final StaticModbusExport result = new StaticModbusExport ( executor, processor, this.hiveSource, null, disposeProcessor );

            try
            {
                result.setProperties ( this.hiveProperies );

                result.setReadTimeout ( this.readTimeout );
                result.setSlaveId ( this.slaveId );
                result.setPort ( this.port );

                // we must call this after "setProperties", since this method creates the block
                result.setBlockConfiguration ( this.definitions );

                return result;
            }
            catch ( final Throwable e )
            {
                result.dispose ();
                throw new RuntimeException ( "Failed to start exporter", e );
            }
        }
    }

    private final ScheduledExecutorService executor;

    private final boolean disposeProcessor;

    private final IoProcessor<NioSession> processor;

    private StaticModbusExport ( final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ObjectPoolDataItemFactory itemFactory, final boolean disposeProcessor )
    {
        super ( executor, processor, hiveSource, itemFactory );
        this.executor = executor;
        this.processor = processor;
        this.disposeProcessor = disposeProcessor;
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        if ( this.disposeProcessor )
        {
            this.processor.dispose ();
        }
        this.executor.shutdown ();
    }
}
