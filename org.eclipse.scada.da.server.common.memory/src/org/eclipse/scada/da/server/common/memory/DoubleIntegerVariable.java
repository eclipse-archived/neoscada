/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.da.server.common.DataItem;

public class DoubleIntegerVariable extends ScalarVariable
{
    public DoubleIntegerVariable ( final String name, final int index, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        super ( name, index, executor, itemPool, attributes );
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
            final ByteBuffer b = ByteBuffer.allocate ( 4 );
            b.putInt ( i );
            block.writeData ( toAddress ( this.index ), b.array () );
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
        return Variant.valueOf ( data.getInt ( toAddress ( this.index ) ) );
    }
}
