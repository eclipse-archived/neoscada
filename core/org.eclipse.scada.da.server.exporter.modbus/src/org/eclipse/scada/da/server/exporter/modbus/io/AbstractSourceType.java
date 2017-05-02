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
package org.eclipse.scada.da.server.exporter.modbus.io;

import java.util.Calendar;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSourceType implements SourceType
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractSourceType.class );

    public static final int COMMON_HEADER = 2 + 8;

    private final int length;

    public AbstractSourceType ( final int dataLength )
    {
        this.length = COMMON_HEADER + dataLength;
    }

    @Override
    public int getLength ()
    {
        return this.length;
    }

    /**
     * Render the value itself to the buffer slice
     *
     * @param slice
     *            the buffer slice
     * @param value
     *            the value, or <code>null</code> if "nothing" has to be encoded
     */
    public abstract void putValue ( final IoBuffer slice, final Variant value );

    @Override
    public void render ( final IoBuffer buffer, final int offset, final DataItemValue value )
    {
        final IoBuffer slice = buffer.getSlice ( offset, this.length );
        logger.trace ( "After Slice: {}", buffer );

        if ( value != null )
        {
            slice.put ( makeValidState ( value ) );
            slice.put ( makeState ( value ) );
            slice.putLong ( makeTimestamp ( value.getTimestamp () ) );
            putValue ( slice, value.getValue () );
        }
        else
        {
            slice.put ( (byte)0xFF ); // invalid
            slice.put ( makeState ( null ) );
            slice.putLong ( makeTimestamp ( null ) );
            putValue ( slice, null );
        }

        logger.trace ( "Buffer: {}", buffer );
    }

    private byte makeValidState ( final DataItemValue value )
    {
        byte state = 0;
        if ( !value.isConnected () )
        {
            state |= 0x01;
        }
        if ( value.isError () )
        {
            state |= 0x02;
        }
        return state;
    }

    private byte makeState ( final DataItemValue value )
    {
        if ( value == null )
        {
            return 0x00;
        }

        byte state = 0;
        if ( value.isAlarm () )
        {
            state |= 0x01;
        }
        if ( value.isWarning () )
        {
            state |= 0x02;
        }
        if ( value.isManual () )
        {
            state |= 0x04;
        }
        if ( value.isBlocked () )
        {
            state |= 0x08;
        }
        return state;
    }

    private long makeTimestamp ( final Calendar timestamp )
    {
        if ( timestamp == null )
        {
            return System.currentTimeMillis ();
        }
        else
        {
            return timestamp.getTimeInMillis ();
        }
    }

}