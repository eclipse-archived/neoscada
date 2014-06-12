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

public enum CauseOfTransmissionType
{
    SIZE_1
    {
        @Override
        public byte readCause ( final ByteBuf data )
        {
            return data.readByte ();
        }

        @Override
        public byte readOriginatorAddress ( final ByteBuf data )
        {
            return 0x00; // defaults to zero
        }

        @Override
        public void write ( final byte cause, final byte originatorAddress, final ByteBuf out )
        {
            out.writeByte ( cause );
        }
    },
    SIZE_2
    {
        @Override
        public byte readCause ( final ByteBuf data )
        {
            return data.readByte ();
        }

        @Override
        public byte readOriginatorAddress ( final ByteBuf data )
        {
            return data.readByte ();
        }

        @Override
        public void write ( final byte cause, final byte originatorAddress, final ByteBuf out )
        {
            out.writeByte ( cause );
            out.writeByte ( originatorAddress );
        }
    };

    public abstract byte readCause ( ByteBuf data );

    public abstract byte readOriginatorAddress ( ByteBuf data );

    public abstract void write ( final byte casue, byte originatorAddress, final ByteBuf out );
}
