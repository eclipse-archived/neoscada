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

public interface MemoryRequestBlock
{
    /**
     * Write a bit
     * 
     * @param blockAddress
     *            the address relative to the block start address
     * @param subIndex
     *            the bit index at the block address (normally 0..8)
     * @param value
     *            the value to write
     */
    public void writeBit ( int blockAddress, int subIndex, boolean value );

    public void writeData ( int blockAddress, byte[] data );

    public int getStartAddress ();
}
