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
package org.eclipse.scada.protocol.iec60870;

import io.netty.buffer.ByteBuf;

public enum InformationObjectAddressType
{
    SIZE_1
    {
        @Override
        public int read ( final ByteBuf data )
        {
            return data.readUnsignedByte ();
        }

        @Override
        public void write ( final int address, final ByteBuf out )
        {
            out.writeByte ( address );
        }
    },
    SIZE_2
    {
        @Override
        public int read ( final ByteBuf data )
        {
            return data.readUnsignedShort ();
        }

        @Override
        public void write ( final int address, final ByteBuf out )
        {
            out.writeShort ( address );
        }
    },
    SIZE_3
    {
        @Override
        public int read ( final ByteBuf data )
        {
            return data.readUnsignedMedium ();
        }

        @Override
        public void write ( final int address, final ByteBuf out )
        {
            out.writeMedium ( address );
        }
    };

    public abstract int read ( ByteBuf data );

    public abstract void write ( int address, ByteBuf out );
}
