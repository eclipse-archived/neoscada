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
package org.eclipse.scada.da.server.exporter.modbus.io;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;

/**
 * Defines a value type rendered to the memory buffer
 * <p>
 * It is important that the length is word aligned (16bits, 2bytes). If
 * necessary a null byte must be appended.
 * </p>
 *
 * @author Jens Reimann
 * @since 0.1.0
 */
public interface SourceType
{
    @Override
    public int hashCode ();

    @Override
    public boolean equals ( final Object obj );

    public void render ( IoBuffer buffer, int offset, DataItemValue value );

    /**
     * Get the full length required in the buffer
     *
     * @return the full data length
     */
    public int getLength ();

    /**
     * parse the value to write from a write request
     *
     * @param localOffset
     *            the local offset were the write was placed inside the data
     *            type structure
     * @param value
     *            the value to write, or <code>null</code> if the value cannot
     *            be written
     * @return the value to write, or <code>null</code>
     */
    public Variant getValue ( int localOffset, IoBuffer value );
}
