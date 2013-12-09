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
import java.util.concurrent.Executor;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.memory.accessor.Int32Accessor;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;

public class DoubleIntegerVariable extends ScalarVariable
{
    private ByteOrder order = ByteOrder.BIG_ENDIAN;

    public DoubleIntegerVariable ( final String name, final int index, final ByteOrder order, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        super ( name, index, executor, itemPool, attributes );
        this.order = order;
    }

    @Override
    protected NotifyFuture<WriteResult> handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;
        if ( block == null )
        {
            return new InstantErrorFuture<> ( new IllegalStateException ( "Device is not connected" ) );
        }

        final Integer i = value.asInteger ( null );
        if ( i != null )
        {

            final IoBuffer data = IoBuffer.allocate ( 4 );
            this.order.put ( data, Int32Accessor.INSTANCE, i );
            block.writeData ( toAddress ( this.index ), data.array () );
            return new InstantFuture<> ( new WriteResult () );
        }
        else
        {
            return new InstantErrorFuture<> ( new IllegalArgumentException ( String.format ( "Can only write doubles: %s is not a double", value ) ) );
        }
    }

    @Override
    protected Variant extractValue ( final IoBuffer data, final Map<String, Variant> attributes )
    {
        final int value = this.order.get ( data, toAddress ( this.index ), Int32Accessor.INSTANCE );
        return Variant.valueOf ( value );
    }
}
