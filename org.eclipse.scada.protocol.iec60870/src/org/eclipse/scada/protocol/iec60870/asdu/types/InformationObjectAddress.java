/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu.types;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;

public class InformationObjectAddress
{
    public static final InformationObjectAddress DEFAULT = new InformationObjectAddress ( 0 );

    private final int address;

    public static InformationObjectAddress valueOf ( final int address )
    {
        return new InformationObjectAddress ( address );
    }

    public InformationObjectAddress ( final int address )
    {
        this.address = address;
    }

    public int getAddress ()
    {
        return this.address;
    }

    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        options.getInformationObjectAddressType ().write ( this.address, out );

    }

    public static InformationObjectAddress parse ( final ProtocolOptions options, final ByteBuf data )
    {
        return new InformationObjectAddress ( options.getInformationObjectAddressType ().read ( data ) );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.address;
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
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final InformationObjectAddress other = (InformationObjectAddress)obj;
        if ( this.address != other.address )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        final ByteBuf buf = Unpooled.buffer ( 4 );
        buf.writeMedium ( this.address );
        return String.format ( "[%d-%d-%d # %d]", buf.getUnsignedByte ( 0 ), buf.getUnsignedByte ( 1 ), buf.getUnsignedByte ( 2 ), this.address );
    }

}
