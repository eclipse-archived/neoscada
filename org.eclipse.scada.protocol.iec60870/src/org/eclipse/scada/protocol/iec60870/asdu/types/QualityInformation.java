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

public class QualityInformation
{
    private static final int MASK_VALID = 0b10000000;

    private static final int MASK_TOPICAL = 0b01000000;

    private static final int MASK_SUBSTITUTED = 0b00100000;

    private static final int MASK_BLOCKED = 0b00010000;

    public static final QualityInformation OK = new QualityInformation ( false, false, true, true );

    public static final QualityInformation INVALID = new QualityInformation ( false, false, true, false );

    private final boolean blocked;

    private final boolean substituted;

    private final boolean topical;

    private final boolean valid;

    public QualityInformation ( final boolean blocked, final boolean substituted, final boolean topical, final boolean valid )
    {
        this.blocked = blocked;
        this.substituted = substituted;
        this.topical = topical;
        this.valid = valid;
    }

    public boolean isBlocked ()
    {
        return this.blocked;
    }

    public boolean isSubstituted ()
    {
        return this.substituted;
    }

    public boolean isTopical ()
    {
        return this.topical;
    }

    public boolean isValid ()
    {
        return this.valid;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s%s%s%s]", this.blocked ? "B" : "", this.substituted ? "S" : "", this.topical ? "T" : "", this.valid ? "V" : "" );
    }

    public byte apply ( byte siq )
    {
        siq = apply ( siq, this.blocked, (byte)MASK_BLOCKED );
        siq = apply ( siq, this.substituted, (byte)MASK_SUBSTITUTED );
        siq = apply ( siq, !this.topical, (byte)MASK_TOPICAL );
        siq = apply ( siq, !this.valid, (byte)MASK_VALID );
        return siq;
    }

    private static byte apply ( byte siq, final boolean value, final byte mask )
    {
        if ( value )
        {
            siq |= mask;
        }
        else
        {
            siq &= ~mask;
        }
        return siq;
    }

    public static QualityInformation parse ( final byte siq )
    {
        // TODO: this could be optimized to fetch everything from an array .. pre-created, since we only have 16 different possibilities

        final boolean blocked = ( siq & MASK_BLOCKED ) > 0;
        final boolean substituted = ( siq & MASK_SUBSTITUTED ) > 0;
        final boolean topical = ( siq & MASK_TOPICAL ) == 0;
        final boolean valid = ( siq & MASK_VALID ) == 0;

        return new QualityInformation ( blocked, substituted, topical, valid );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.blocked ? 1231 : 1237 );
        result = prime * result + ( this.substituted ? 1231 : 1237 );
        result = prime * result + ( this.topical ? 1231 : 1237 );
        result = prime * result + ( this.valid ? 1231 : 1237 );
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
        final QualityInformation other = (QualityInformation)obj;
        if ( this.blocked != other.blocked )
        {
            return false;
        }
        if ( this.substituted != other.substituted )
        {
            return false;
        }
        if ( this.topical != other.topical )
        {
            return false;
        }
        if ( this.valid != other.valid )
        {
            return false;
        }
        return true;
    }

}
