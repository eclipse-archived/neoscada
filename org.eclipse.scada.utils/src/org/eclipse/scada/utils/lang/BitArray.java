/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.lang;

public class BitArray
{
    private byte[] data;

    public BitArray ()
    {
        this.data = new byte[0];
    }

    public BitArray ( final int initialSize )
    {
        this.data = new byte[initialSize / 8 + 1];
    }

    public BitArray ( final byte[] data )
    {
        this.data = data;
    }

    public boolean get ( final int bit )
    {
        if ( bit < 0 )
        {
            return false;
        }

        final int pos = bit >> 8;
        if ( pos >= this.data.length )
        {
            return false;
        }

        return ( this.data[pos] & 1 << bit % 8 ) > 0;
    }

    public void set ( final int bit, final boolean value )
    {
        if ( bit < 0 )
        {
            return;
        }

        final int pos = bit / 8;
        ensureSize ( pos + 1 );

        if ( value )
        {
            this.data[pos] |= 1 << bit % 8;
        }
        else
        {
            this.data[pos] &= ~ ( 1 << bit % 8 );
        }
    }

    private void ensureSize ( final int size )
    {
        if ( this.data.length < size )
        {
            final byte[] newData = new byte[size];
            System.arraycopy ( this.data, 0, newData, 0, this.data.length );
            this.data = newData;
        }
    }

    public byte[] toArray ()
    {
        return this.data;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ( "[" );

        for ( final byte b : this.data )
        {
            sb.append ( String.format ( "%02x|", b ) );
        }

        sb.append ( "]" );

        return sb.toString ();
    }
}
