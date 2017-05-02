/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.nio.charset.Charset;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.memory.accessor.FixedLengthStringAccessor;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;

public class FixedLengthStringVariable extends AbstractAccessorVariable<String>
{
    public FixedLengthStringVariable ( final String name, final int index, final ByteOrder order, final int length, final Charset charset, final Executor executor, final ManageableObjectPool<DataItem> itemPool, final Attribute... attributes )
    {
        super ( name, index, order, executor, itemPool, new FixedLengthStringAccessor ( length, charset ), attributes );
    }

    @Override
    protected String getValue ( final Variant value )
    {
        return value.asString ( null );
    }
}
