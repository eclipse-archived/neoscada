/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - minor cleanups
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.asdu.types;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;

import io.netty.buffer.ByteBuf;

public class CauseOfTransmission
{
    public static final CauseOfTransmission ACTIVATED = new CauseOfTransmission ( StandardCause.ACTIVATED );

    public static final CauseOfTransmission REQUEST = new CauseOfTransmission ( StandardCause.REQUEST );

    public static final CauseOfTransmission BACKGROUND = new CauseOfTransmission ( StandardCause.BACKGROUND );

    public static final CauseOfTransmission SPONTANEOUS = new CauseOfTransmission ( StandardCause.SPONTANEOUS );

    public static final CauseOfTransmission PERIODIC = new CauseOfTransmission ( StandardCause.PERIODIC );

    private static final int CAUSE_MASK = 0b00111111;

    private static final int ACK_BIT = 0b0100000000;

    private static final int TEST_BIT = 0b10000000;

    private Cause cause;

    private boolean test;

    private boolean positive;

    private byte sourceAddress;

    private CauseOfTransmission ()
    {
    }

    public CauseOfTransmission ( final Cause cause )
    {
        this ( cause, (byte)0 );
    }

    public CauseOfTransmission ( final Cause cause, final Byte sourceAddress )
    {
        this ( cause, sourceAddress, true, false );
    }

    public CauseOfTransmission ( final Cause cause, final Byte sourceAddress, final boolean acknowledge, final boolean test )
    {
        this.cause = cause;
        this.sourceAddress = sourceAddress == null ? (byte)0 : sourceAddress;
        this.positive = acknowledge;
        this.test = test;
    }

    public Cause getCause ()
    {
        return this.cause;
    }

    private void setCause ( final Cause cause )
    {
        this.cause = cause;
    }

    public boolean isTest ()
    {
        return this.test;
    }

    private void setTest ( final boolean test )
    {
        this.test = test;
    }

    public boolean isPositive ()
    {
        return this.positive;
    }

    private void setPositive ( final boolean positive )
    {
        this.positive = positive;
    }

    public byte getSourceAddress ()
    {
        return this.sourceAddress;
    }

    private void setSourceAddress ( final byte sourceAddress )
    {
        this.sourceAddress = sourceAddress;
    }

    public static CauseOfTransmission parse ( final ProtocolOptions options, final ByteBuf data )
    {
        final CauseOfTransmission result = new CauseOfTransmission ();

        final byte first = options.getCauseOfTransmissionType ().readCause ( data );
        result.setCause ( Causes.valueOf ( first & 0b00111111 ) );
        result.setTest ( ( first & TEST_BIT ) > 0 );
        result.setPositive ( ( first & ACK_BIT ) == 0 );
        result.setSourceAddress ( options.getCauseOfTransmissionType ().readOriginatorAddress ( data ) );

        return result;
    }

    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        byte first = 0;
        if ( this.test )
        {
            first |= TEST_BIT;
        }
        if ( !this.positive )
        {
            first |= ACK_BIT;
        }
        first |= this.cause.getValue () & CAUSE_MASK;

        options.getCauseOfTransmissionType ().write ( first, this.sourceAddress, out );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s:%s(0x%02x):%s%s]", this.cause, this.sourceAddress & 0xFF, this.sourceAddress, this.test ? "T" : "", this.positive ? "A" : "" );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.positive ? 1231 : 1237 );
        result = prime * result + ( this.cause == null ? 0 : (byte)this.cause.getValue () ); // compare by cause value
        result = prime * result + this.sourceAddress;
        result = prime * result + ( this.test ? 1231 : 1237 );
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
        final CauseOfTransmission other = (CauseOfTransmission)obj;
        if ( this.positive != other.positive )
        {
            return false;
        }
        if ( this.cause == null )
        {
            if ( other.cause != null )
            {
                return false;
            }
        }
        else if ( other.cause == null || this.cause.getValue () != other.cause.getValue () )
        {
            // compare by cause value
            return false;
        }
        if ( this.sourceAddress != other.sourceAddress )
        {
            return false;
        }
        if ( this.test != other.test )
        {
            return false;
        }
        return true;
    }

}
