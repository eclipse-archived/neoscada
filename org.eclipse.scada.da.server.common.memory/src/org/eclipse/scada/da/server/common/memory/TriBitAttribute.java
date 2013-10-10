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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implement a single bit attribute
 * 
 * @author Jens Reimann
 */
public class TriBitAttribute extends AbstractAttribute implements Attribute
{

    private final static Logger logger = LoggerFactory.getLogger ( TriBitAttribute.class );

    private final int readIndex;

    private final int readSubIndex;

    private final int writeTrueIndex;

    private final int writeTrueSubIndex;

    private final int writeFalseIndex;

    private final int writeFalseSubIndex;

    private final boolean invertRead;

    private Boolean lastValue;

    private Variant lastTimestamp;

    private final boolean enableTimestamp;

    private long stopped;

    public TriBitAttribute ( final String name, final int readIndex, final int readSubIndex, final int writeTrueIndex, final int writeTrueSubIndex, final int writeFalseIndex, final int writeFalseSubIndex, final boolean invertRead, final boolean enableTimestamp )
    {
        super ( name );
        this.readIndex = readIndex;
        this.readSubIndex = readSubIndex;
        this.writeTrueIndex = writeTrueIndex;
        this.writeTrueSubIndex = writeTrueSubIndex;
        this.writeFalseIndex = writeFalseIndex;
        this.writeFalseSubIndex = writeFalseSubIndex;
        this.invertRead = invertRead;
        this.enableTimestamp = enableTimestamp;
    }

    @Override
    public void handleData ( final IoBuffer data, final Map<String, Variant> attributes, final Variant timestamp )
    {
        final byte b = data.get ( toAddress ( this.readIndex ) );
        final boolean flag = ( b & 1 << this.readSubIndex ) != 0;
        if ( this.invertRead )
        {
            attributes.put ( this.name, flag ? Variant.FALSE : Variant.TRUE );
        }
        else
        {
            attributes.put ( this.name, flag ? Variant.TRUE : Variant.FALSE );
        }

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
    public void stop ()
    {
        this.stopped = System.currentTimeMillis ();
        super.stop ();
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
            logger.warn ( "Was stopped: {}", this.stopped );
            throw new IllegalStateException ( "Device is not connected" );
        }

        final boolean flag = value.asBoolean ();
        if ( flag )
        {
            block.writeBit ( toAddress ( this.writeTrueIndex ), this.writeTrueSubIndex, true );
        }
        else
        {
            block.writeBit ( toAddress ( this.writeFalseIndex ), this.writeFalseSubIndex, true );
        }
    }
}
