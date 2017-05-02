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

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.memory.accessor.FixedLengthBlobAccessor;

/**
 * Implement a fixed length string
 *
 * @author Jens Reimann
 */
public class FixedLengthBlobAttribute extends AbstractAccessorAttribute<String>
{
    public FixedLengthBlobAttribute ( final String name, final int index, final int length, final ByteOrder order, final boolean enableTimestamp )
    {
        super ( name, index, order, enableTimestamp, new FixedLengthBlobAccessor ( length ) );
    }

    @Override
    protected String getValue ( final Variant value )
    {
        return value.asString ( null );
    }
}
