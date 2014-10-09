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
package org.eclipse.scada.da.server.common.memory;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.memory.accessor.Accessor;

public abstract class AbstractAccessorAttribute<T> extends AbstractAttribute
{
    private final int index;

    private T lastValue;

    private Variant lastTimestamp;

    private final boolean enableTimestamp;

    private final ByteOrder order;

    private final Accessor<T> accessor;

    public AbstractAccessorAttribute ( final String name, final int index, final ByteOrder order, final boolean enableTimestamp, final Accessor<T> accessor )
    {
        super ( name );
        this.index = index;
        this.enableTimestamp = enableTimestamp;
        this.order = order;
        this.accessor = accessor;
    }

    protected abstract T getValue ( Variant value );

    @Override
    public void handleData ( final IoBuffer data, final Map<String, Variant> attributes, final Variant timestamp )
    {
        final T s;

        if ( this.order != null )
        {
            s = this.order.get ( data, this.index, this.accessor );
        }
        else
        {
            s = this.accessor.get ( data, this.index );
        }

        attributes.put ( this.name, Variant.valueOf ( s ) );

        if ( !s.equals ( this.lastValue ) )
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
    public void handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;

        if ( block == null )
        {
            throw new IllegalStateException ( "Device is not connected" );
        }

        final T cvtValue = getValue ( value );
        if ( cvtValue != null )
        {
            final IoBuffer data = IoBuffer.allocate ( this.accessor.getBufferSize ( cvtValue ) );
            if ( this.order != null )
            {
                this.order.put ( data, this.accessor, cvtValue );
            }
            else
            {
                this.accessor.put ( data, cvtValue );
            }
            block.writeData ( toAddress ( this.index ), data.array () );
        }
    }

    @Override
    public void handleError ( final Map<String, Variant> attributes )
    {
        this.lastValue = null;
        this.lastTimestamp = null;
    }

}