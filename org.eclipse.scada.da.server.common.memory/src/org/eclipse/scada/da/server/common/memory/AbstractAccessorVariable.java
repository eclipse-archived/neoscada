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
import java.util.concurrent.Executor;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.memory.accessor.Accessor;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;

/**
 * An abstract variable implementation which is using {@link Accessor}s for
 * accessing the data
 *
 * @param <T>
 *            the type of the accessor
 */
public abstract class AbstractAccessorVariable<T> extends ScalarVariable
{
    private final ByteOrder order;

    private final Accessor<T> accessor;

    public AbstractAccessorVariable ( final String name, final int index, final ByteOrder order, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Accessor<T> accessor, final Attribute... attributes )
    {
        super ( name, index, executor, itemPool, attributes );
        this.order = order;
        this.accessor = accessor;
    }

    protected abstract T getValue ( Variant value );

    @Override
    protected NotifyFuture<WriteResult> handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;
        if ( block == null )
        {
            return new InstantErrorFuture<> ( new IllegalStateException ( "Device is not connected" ) );
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
            return new InstantFuture<> ( WriteResult.OK );
        }
        else
        {
            return new InstantErrorFuture<> ( new IllegalArgumentException ( String.format ( "Can only write doubles: %s is not a double", value ) ) );
        }
    }

    @Override
    protected Variant extractValue ( final IoBuffer data, final Map<String, Variant> attributes )
    {
        final T value;

        if ( this.order != null )
        {
            value = this.order.get ( data, toAddress ( this.index ), this.accessor );
        }
        else
        {
            value = this.accessor.get ( data, toAddress ( this.index ) );
        }
        return Variant.valueOf ( value );
    }

}