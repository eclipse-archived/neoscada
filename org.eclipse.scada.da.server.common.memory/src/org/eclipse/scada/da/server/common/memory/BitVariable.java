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

import java.util.Map;
import java.util.concurrent.Executor;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.da.server.common.DataItem;

public class BitVariable extends ScalarVariable
{
    private final int subIndex;

    public BitVariable ( final String name, final int index, final int subIndex, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        super ( name, index, executor, itemPool, attributes );
        this.subIndex = subIndex;
    }

    @Override
    protected Variant extractValue ( final IoBuffer data, final Map<String, Variant> attributes )
    {
        final byte b = data.get ( toAddress ( this.index ) );
        final boolean flag = ( b & 1 << this.subIndex ) != 0;
        return Variant.valueOf ( flag );
    }

    @Override
    protected NotifyFuture<WriteResult> handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;

        if ( block == null )
        {
            return new InstantErrorFuture<WriteResult> ( new OperationException ( "Device not connected" ).fillInStackTrace () );
        }

        block.writeBit ( toAddress ( this.index ), this.subIndex, value.asBoolean () );

        return new InstantFuture<WriteResult> ( new WriteResult () );
    }
}
