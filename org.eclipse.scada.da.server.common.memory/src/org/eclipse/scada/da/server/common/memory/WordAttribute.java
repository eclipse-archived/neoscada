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
import org.eclipse.scada.da.server.common.memory.accessor.UInt16Accessor;

/**
 * Implement a single bit attribute
 *
 * @author Jens Reimann
 */
public class WordAttribute extends AbstractAccessorAttribute<Integer>
{
    public WordAttribute ( final String name, final int index, final ByteOrder order, final boolean enableTimestamp )
    {
        super ( name, index, order, enableTimestamp, UInt16Accessor.INSTANCE );
    }

    @Override
    protected Integer getValue ( final Variant value )
    {
        return value.asInteger ( null );
    }

}
