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

public class DoubleType extends AbstractSourceType
{
    private final static int DATA_LENGTH = 8;

    public final static int LENGTH = AbstractSourceType.COMMON_HEADER + DATA_LENGTH;

    private final Double factor;

    /**
     * A default instance with no scaling
     */
    public static final SourceType INSTANCE = new DoubleType ();

    public DoubleType ()
    {
        this ( null );
    }

    public DoubleType ( final Double factor )
    {
        super ( DATA_LENGTH ); // double length float
        this.factor = factor;
    }

    @Override
    public void putValue ( final IoBuffer slice, final Variant value )
    {
        slice.putDouble ( makeValue ( value ) );
    }

    @Override
    public Variant getValue ( final int localOffset, final IoBuffer value )
    {
        if ( localOffset == AbstractSourceType.COMMON_HEADER && value.remaining () == DATA_LENGTH )
        {
            return Variant.valueOf ( value.getDouble () );
        }
        return null;
    }

    private double makeValue ( final Variant value )
    {
        if ( value == null )
        {
            return Double.NaN;
        }
        final Double v = value.asDouble ( null );
        if ( v == null )
        {
            return Double.NaN;
        }
        if ( this.factor != null )
        {
            return this.factor * v;
        }
        else
        {
            return v;
        }
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.factor == null ? 0 : this.factor.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( ! ( obj instanceof DoubleType ) )
        {
            return false;
        }
        final DoubleType other = (DoubleType)obj;
        if ( this.factor == null )
        {
            if ( other.factor != null )
            {
                return false;
            }
        }
        else if ( !this.factor.equals ( other.factor ) )
        {
            return false;
        }
        return true;
    }

}
