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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.memory.accessor.Int64Accessor;

/**
 * Implement a single bit attribute
 *
 * @author Jens Reimann
 */
public class Int64Attribute extends AbstractAccessorAttribute<Long>
{

    public Int64Attribute ( final String name, final int index, final ByteOrder order, final boolean enableTimestamp )
    {
        super ( name, index, order, enableTimestamp, Int64Accessor.INSTANCE );
    }

    @Override
    protected Long getValue ( final Variant value )
    {
        return value.asLong ( null );
    }

}
