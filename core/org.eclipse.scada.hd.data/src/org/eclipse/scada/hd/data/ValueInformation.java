/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.data;

public class ValueInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ValueInformation ( final double quality, final double manualPercentage, final long startTimestamp, final long endTimestamp, final long sourceValues )
    {
        this.quality = quality;
        this.manualPercentage = manualPercentage;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.sourceValues = sourceValues;
    }

    /**
     * The percent count (from 0.0 to 1.0) of valid values
     */
    private final double quality;

    public double getQuality ()
    {
        return this.quality;
    }

    /**
     * The percent count (from 0.0 to 1.0) of manual values
     */
    private final double manualPercentage;

    public double getManualPercentage ()
    {
        return this.manualPercentage;
    }

    private final long startTimestamp;

    public long getStartTimestamp ()
    {
        return this.startTimestamp;
    }

    private final long endTimestamp;

    public long getEndTimestamp ()
    {
        return this.endTimestamp;
    }

    /**
     * The number of level 0 entries that where used to generate this value
     */
    private final long sourceValues;

    public long getSourceValues ()
    {
        return this.sourceValues;
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

        if ( ! ( obj instanceof ValueInformation ) )
        {
            return false;
        }
        final ValueInformation other = (ValueInformation)obj;

        if ( this.quality != other.quality )
        {
            return false;
        }

        if ( this.manualPercentage != other.manualPercentage )
        {
            return false;
        }

        if ( this.startTimestamp != other.startTimestamp )
        {
            return false;
        }

        if ( this.endTimestamp != other.endTimestamp )
        {
            return false;
        }

        if ( this.sourceValues != other.sourceValues )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        long temp;

        final int prime = 31;
        int result = 1;

        temp = Double.doubleToLongBits ( this.quality );
        result = prime * result + (int) ( temp ^ temp >>> 32 );
        temp = Double.doubleToLongBits ( this.manualPercentage );
        result = prime * result + (int) ( temp ^ temp >>> 32 );
        result = prime * result + (int) ( this.startTimestamp ^ this.startTimestamp >>> 32 );
        result = prime * result + (int) ( this.endTimestamp ^ this.endTimestamp >>> 32 );
        result = prime * result + (int) ( this.sourceValues ^ this.sourceValues >>> 32 );

        return result;
    }

    @Override
    public String toString ()
    {
        return "[ValueInformation - " + "quality: " + this.quality + ", " + "manualPercentage: " + this.manualPercentage + ", " + "startTimestamp: " + this.startTimestamp + ", " + "endTimestamp: " + this.endTimestamp + ", " + "sourceValues: " + this.sourceValues + "]";
    }
}
