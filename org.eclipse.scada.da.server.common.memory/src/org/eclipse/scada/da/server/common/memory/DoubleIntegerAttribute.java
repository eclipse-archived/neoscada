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
package org.eclipse.scada.da.server.common.memory;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.memory.accessor.Int32Accessor;

/**
 * Implement a single bit attribute
 * 
 * @author Jens Reimann
 */
public class DoubleIntegerAttribute extends AbstractAttribute implements Attribute
{
    private final int index;

    private Integer lastValue;

    private Variant lastTimestamp;

    private final boolean enableTimestamp;

    private final ByteOrder order;

    public DoubleIntegerAttribute ( final String name, final int index, final ByteOrder order, final boolean enableTimestamp )
    {
        super ( name );
        this.index = index;
        this.enableTimestamp = enableTimestamp;
        this.order = order;
    }

    @Override
    public void handleData ( final IoBuffer data, final Map<String, Variant> attributes, final Variant timestamp )
    {
        final int s = this.order.get ( data, this.index, Int32Accessor.INSTANCE );
        attributes.put ( this.name, Variant.valueOf ( s ) );

        if ( !Integer.valueOf ( s ).equals ( this.lastValue ) )
        {
            this.lastValue = s;
            this.lastTimestamp = timestamp;
        }

        if ( this.enableTimestamp )
        {
            attributes.put ( this.name + ".timestamp", this.lastTimestamp );
        }
    }

    @Override
    public void handleError ( final Map<String, Variant> attributes )
    {
        this.lastValue = null;
        this.lastTimestamp = null;
    }

    @Override
    public void handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;

        if ( block == null )
        {
            throw new IllegalStateException ( "Device is not connected" );
        }

        final Integer i = value.asInteger ( null );
        if ( i != null )
        {
            final IoBuffer data = IoBuffer.allocate ( 4 );
            this.order.put ( data, Int32Accessor.INSTANCE, i );
            block.writeData ( toAddress ( this.index ), data.array () );
        }
    }

}
