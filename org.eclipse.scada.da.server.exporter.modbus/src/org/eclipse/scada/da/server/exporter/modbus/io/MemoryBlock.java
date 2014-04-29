/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.modbus.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager;
import org.eclipse.scada.da.server.exporter.common.SingleSubscriptionManager.Listener;
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

    public MemoryBlock ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties )
    {
        final ReadWriteLock lock = new ReentrantReadWriteLock ();
        this.readLock = lock.readLock ();
        this.writeLock = lock.writeLock ();

        this.manager = new SingleSubscriptionManager ( executor, hiveSource, properties );
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

            for ( final SourceDefinition def : oldDefs )
            {
                logger.debug ( "Remove: {}", def );
                final Listener listener = this.definitions.remove ( def );
                this.manager.removeListener ( def.getItemId (), listener );
            }
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
