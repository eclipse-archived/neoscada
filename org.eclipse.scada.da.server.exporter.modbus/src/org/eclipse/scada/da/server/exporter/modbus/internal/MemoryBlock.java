/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager.Listener;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemoryBlock
{
    private final static Logger logger = LoggerFactory.getLogger ( MemoryBlock.class );

    private final SingleSubscriptionManager manager;

    private final Map<SourceDefinition, Listener> definitions = new HashMap<> ();

    private IoBuffer buffer = IoBuffer.allocate ( 0 );

    private final Lock readLock;

    private final Lock writeLock;

    private final Map<Integer, SourceDefinition> writeMap = new TreeMap<> ();

    /**
     * Create a new memory block
     * 
     * @param executor
     *            a single threaded executor for sending out events
     * @param hiveSource
     *            the source of the hive to export
     * @param properties
     *            properties to log on to the hive
     * @param logName
     *            an optional logging name
     */
    public MemoryBlock ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties, final String logName )
    {
        final ReadWriteLock lock = new ReentrantReadWriteLock ();
        this.readLock = lock.readLock ();
        this.writeLock = lock.writeLock ();

        this.manager = new SingleSubscriptionManager ( executor, hiveSource, properties, logName );
        this.manager.start ();
    }

    public void dispose ()
    {
        this.writeLock.lock ();
        try
        {
            this.manager.stop ();
            this.buffer = IoBuffer.allocate ( 0 );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    public IoBuffer readData ( final int offset, final int length )
    {
        this.readLock.lock ();
        try
        {
            return performRead ( offset, length );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    private IoBuffer performRead ( final int offset, final int length )
    {
        logger.debug ( "Perform read - offset: {}, length: {}, capacity: {}", offset, length, this.buffer.capacity () );

        if ( length == 0 )
        {
            return null;
        }

        if ( offset < 0 )
        {
            return null;
        }

        if ( offset + length > this.buffer.capacity () )
        {
            return null;
        }

        final IoBuffer result = IoBuffer.allocate ( length );

        result.put ( this.buffer.getSlice ( offset, length ) );

        return result;
    }

    public int write ( final int address, final IoBuffer value )
    {
        this.readLock.lock ();
        try
        {
            return performWrite ( address, value );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    private int performWrite ( final int address, final IoBuffer value )
    {
        final int startAddress = address * 2;

        if ( startAddress < 0 || startAddress >= 0xFFFF )
        {
            return 0x02; /*invalid address*/
        }

        final SourceDefinition def = this.writeMap.get ( startAddress );
        if ( def == null )
        {
            return 0x02; /*invalid address*/
        }

        final int localOffset = startAddress - def.getOffset ();

        final Variant writeValue = def.getType ().getValue ( localOffset, value );

        if ( writeValue == null )
        {
            return 0x03; /*invalid data value*/
        }

        this.manager.writeValue ( def.getItemId (), writeValue, null, null );

        return 0;
    }

    public void setConfiguration ( final List<SourceDefinition> definitions )
    {
        this.writeLock.lock ();

        try
        {
            logger.debug ( "Setting definitions: {}", definitions );
            logger.debug ( "Current definitions: {}", this.definitions );

            final List<SourceDefinition> newDefs = new ArrayList<> ( definitions );
            newDefs.removeAll ( this.definitions.values () );

            final List<SourceDefinition> oldDefs = new ArrayList<> ( this.definitions.keySet () );
            oldDefs.removeAll ( definitions );

            logger.debug ( "Remove definitions: {}", oldDefs );
            logger.debug ( "Add definitions: {}", newDefs );

            // destroy old

            for ( final SourceDefinition def : oldDefs )
            {
                logger.debug ( "Remove: {}", def );
                final Listener listener = this.definitions.remove ( def );
                this.manager.removeListener ( def.getItemId (), listener );

                for ( int i = def.getOffset (); i < def.getOffset () + def.getType ().getLength (); i++ )
                {
                    this.writeMap.remove ( i );
                }
            }

            // build new

            for ( final SourceDefinition def : newDefs )
            {
                logger.debug ( "Add: {}", def );
                final Listener listener = new Listener () {
                    @Override
                    public void stateChanged ( final String itemId, final DataItemValue value )
                    {
                        logger.trace ( "stateChanged - itemId: {}, value: {}, definition: {}", itemId, value, def );
                        handleStateChange ( def, value );
                    }
                };

                for ( int i = def.getOffset (); i < def.getOffset () + def.getType ().getLength (); i++ )
                {
                    this.writeMap.put ( i, def );
                }

                this.manager.addListener ( def.getItemId (), listener );
                this.definitions.put ( def, listener );
            }

            // get current state
            final Map<String, DataItemValue> cache = this.manager.getCacheCopy ();

            if ( !definitions.isEmpty () )
            {
                // get expected size
                int maxOffset = -1;
                int maxOffsetLength = 0;
                for ( final SourceDefinition def : definitions )
                {
                    if ( def.getOffset () > maxOffset )
                    {
                        maxOffset = def.getOffset ();
                        maxOffsetLength = def.getType ().getLength ();
                    }
                }

                // create new buffer and allow to expand
                final IoBuffer buffer = IoBuffer.allocate ( maxOffset + maxOffsetLength );
                buffer.setAutoExpand ( false );
                logger.debug ( "Buffer: {}", buffer );
                logger.debug ( "Limit: {}", buffer.limit () );

                // render current state
                for ( final SourceDefinition def : definitions )
                {
                    final DataItemValue value = cache.get ( def.getItemId () );
                    logger.debug ( "Render value - def: {}, value: {}", def, value );
                    def.getType ().render ( buffer, def.getOffset (), value );
                }

                this.buffer = buffer;
            }
            else
            {
                this.buffer = IoBuffer.allocate ( 0 );
            }
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    protected void handleStateChange ( final SourceDefinition definition, final DataItemValue value )
    {
        logger.trace ( "Value change - definition: {}, value: {}", definition, value );

        this.writeLock.lock ();
        try
        {
            definition.getType ().render ( this.buffer, definition.getOffset (), value );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

}
