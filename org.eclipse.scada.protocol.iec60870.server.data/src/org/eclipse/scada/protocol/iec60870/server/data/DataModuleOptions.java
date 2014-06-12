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
package org.eclipse.scada.protocol.iec60870.server.data;

public class DataModuleOptions
{

    /**
     * the number of spontaneous updates that will be buffered when the send
     * buffer is full, for each information object before these updates will be
     * discarded
     */
    private int spontaneousDuplicates = 10;

    /**
     * The delay between background scans in milliseconds
     */
    private int backgroundScanPeriod = 60_000;

    private boolean booleansWithTimestamp = true;

    private boolean floatsWithTimestamp = true;

    private DataModuleOptions ()
    {
    }

    private DataModuleOptions ( final DataModuleOptions other )
    {
        this.spontaneousDuplicates = other.spontaneousDuplicates;
        this.backgroundScanPeriod = other.backgroundScanPeriod;
        this.booleansWithTimestamp = other.booleansWithTimestamp;
        this.floatsWithTimestamp = other.floatsWithTimestamp;
    }

    public boolean isBooleansWithTimestamp ()
    {
        return this.booleansWithTimestamp;
    }

    public boolean isFloatsWithTimestamp ()
    {
        return this.floatsWithTimestamp;
    }

    public int getSpontaneousDuplicates ()
    {
        return this.spontaneousDuplicates;
    }

    public boolean isSpontaneous ()
    {
        return this.spontaneousDuplicates > 0;
    }

    public int getBackgroundScanPeriod ()
    {
        return this.backgroundScanPeriod;
    }

    public static class Builder
    {
        private final DataModuleOptions value = new DataModuleOptions ();

        public void setBooleansWithTimestamp ( final boolean booleansWithTimestamp )
        {
            this.value.booleansWithTimestamp = booleansWithTimestamp;
        }

        public boolean isBooleansWithTimestamp ()
        {
            return this.value.booleansWithTimestamp;
        }

        public void setFloatsWithTimestamp ( final boolean floatsWithTimestamp )
        {
            this.value.floatsWithTimestamp = floatsWithTimestamp;
        }

        public boolean isFloatsWithTimestamp ()
        {
            return this.value.floatsWithTimestamp;
        }

        public void setSpontaneousDuplicates ( final int spontaneousDuplicates )
        {
            this.value.spontaneousDuplicates = spontaneousDuplicates;
        }

        public int getSpontaneousDuplicates ()
        {
            return this.value.spontaneousDuplicates;
        }

        public void setBackgroundScanPeriod ( final int backgroundScanPeriod )
        {
            this.value.backgroundScanPeriod = backgroundScanPeriod;
        }

        public int getBackgroundScanPeriod ()
        {
            return this.value.backgroundScanPeriod;
        }

        public DataModuleOptions build ()
        {
            return new DataModuleOptions ( this.value );
        }
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.backgroundScanPeriod;
        result = prime * result + ( this.booleansWithTimestamp ? 1231 : 1237 );
        result = prime * result + ( this.floatsWithTimestamp ? 1231 : 1237 );
        result = prime * result + this.spontaneousDuplicates;
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
        final DataModuleOptions other = (DataModuleOptions)obj;
        if ( this.backgroundScanPeriod != other.backgroundScanPeriod )
        {
            return false;
        }
        if ( this.booleansWithTimestamp != other.booleansWithTimestamp )
        {
            return false;
        }
        if ( this.floatsWithTimestamp != other.floatsWithTimestamp )
        {
            return false;
        }
        if ( this.spontaneousDuplicates != other.spontaneousDuplicates )
        {
            return false;
        }
        return true;
    }
}
