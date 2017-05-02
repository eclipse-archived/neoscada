/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.memory.accessor.UInt8Accessor;

/**
 * Implement a single bit attribute
 *
 * @author Jens Reimann
 */
public class ByteAttribute extends AbstractAccessorAttribute<Short>
{

    public ByteAttribute ( final String name, final int index, final boolean enableTimestamp )
    {
        super ( name, index, null, enableTimestamp, UInt8Accessor.INSTANCE );
    }

    @Override
    protected Short getValue ( final Variant value )
    {
        final Integer i = value.asInteger ( null );
        if ( i == null )
        {
            return null;
        }
        else
        {
            return i.shortValue ();
        }
    }
}
