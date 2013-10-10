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

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;

/**
 * Implement a single bit attribute
 * 
 * @author Jens Reimann
 */
public class BitAttribute extends AbstractAttribute implements Attribute
{

    private final int index;

    private final int subIndex;

    private Boolean lastValue;

    private Variant lastTimestamp;

    private final boolean enableTimestamp;

    public BitAttribute ( final String name, final int index, final int subIndex, final boolean enableTimestamp )
    {
        super ( name );
        this.index = index;
        this.subIndex = subIndex;
        this.enableTimestamp = enableTimestamp;
    }

    @Override
    public void handleData ( final IoBuffer data, final Map<String, Variant> attributes, final Variant timestamp )
    {
        final byte b = data.get ( toAddress ( this.index ) );
        final boolean flag = ( b & 1 << this.subIndex ) != 0;
        attributes.put ( this.name, Variant.valueOf ( flag ) );

        if ( !Boolean.valueOf ( flag ).equals ( this.lastValue ) )
        {
            this.lastValue = flag;
            this.lastTimestamp = timestamp;
        }

        if ( this.enableTimestamp )
        {
            attributes.put ( this.name + ".timestamp", this.lastTimestamp );
        }
    }

    @Override
    public void handleError ( final Map<String, Variant> attributes )
    {
        this.lastValue = null;
        this.lastTimestamp = null;
    }

    @Override
    public void handleWrite ( final Variant value )
    {
        final MemoryRequestBlock block = this.block;

        if ( block == null )
        {
            throw new IllegalStateException ( "Device is not connected" );
        }

        block.writeBit ( toAddress ( this.index ), this.subIndex, value.asBoolean () );
    }

}
