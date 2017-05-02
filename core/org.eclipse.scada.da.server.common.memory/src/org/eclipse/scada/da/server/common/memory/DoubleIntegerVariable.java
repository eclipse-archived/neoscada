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
package org.eclipse.scada.da.server.common.memory;

import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.memory.accessor.UInt32Accessor;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;

public class DoubleIntegerVariable extends AbstractAccessorVariable<Long>
{
    public DoubleIntegerVariable ( final String name, final int index, final ByteOrder order, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        super ( name, index, order, executor, itemPool, UInt32Accessor.INSTANCE, attributes );
    }

    @Override
    protected Long getValue ( final Variant value )
    {
        return value.asLong ( null );
    }
}
