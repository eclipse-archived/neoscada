/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - some bug fixes
 *******************************************************************************/
package org.eclipse.scada.da.datasource.data;

import java.io.Serializable;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataItemValueRange
{
    private DataItemValueLight firstValue = DataItemValueLight.DISCONNECTED;

    private final SortedSet<DataItemValueLight> values = new TreeSet<DataItemValueLight> ( DataItemValueLight.timestampComparator ); // 

    private final long rangeOrAlignment; // timespan to hold values since oldestPossibleTimestamp

    private final TimeUnit absolute; // align trimestamp to last TimeUnit (everything above nanoseconds)

    private long oldestPossibleTimestamp; // timestamp in milliseconds

    private ReadWriteLock lock = new ReentrantReadWriteLock ();

    public DataItemValueRange ( final long range )
    {
        this.rangeOrAlignment = range;
        this.absolute = null;
        this.oldestPossibleTimestamp = calculateOldestTimestamp ( System.currentTimeMillis () );
    }

    public DataItemValueRange ( final TimeUnit absolute, final long alignment )
    {
        this.rangeOrAlignment = alignment;
        if ( absolute == TimeUnit.NANOSECONDS )
        {
            throw new IllegalArgumentException ( String.format ( "%s is not allowed, %s works only with at least milliseconds resolution", absolute, this.getClass ().getName () ) );
        }
        this.absolute = absolute;
        this.oldestPossibleTimestamp = calculateOldestTimestamp ( System.currentTimeMillis () );
    }

    private long calculateOldestTimestamp ( final long timestamp )
    {
        if ( this.absolute != null )
        {
            return timestamp - ( timestamp % TimeUnit.MILLISECONDS.convert ( this.rangeOrAlignment, this.absolute ) );
        }
        else
        {
            return timestamp - this.rangeOrAlignment;
        }
    }

    public int add ( final DataItemValueLight dataItemValue )
    {
        lock.writeLock ().lock ();
        try
        {
            if ( DataItemValueRange.this.firstValue == DataItemValueLight.DISCONNECTED )
            {
                DataItemValueRange.this.firstValue = dataItemValue;
            }
            DataItemValueRange.this.values.add ( dataItemValue );
            checkRangeInternal ( calculateOldestTimestamp ( System.currentTimeMillis () ) );
            return DataItemValueRange.this.values.size ();
        }
        finally
        {
            lock.writeLock ().unlock ();
        }
    }

    public int checkRange ()
    {
        lock.writeLock ().lock ();
        try
        {
            return checkRangeInternal ( calculateOldestTimestamp ( System.currentTimeMillis () ) );
        }
        finally
        {
            lock.writeLock ().unlock ();
        }
    }

    public DataItemValueRangeInfo getInfo ()
    {
        lock.readLock ().lock ();
        try
        {
            return new DataItemValueRangeInfo ( DataItemValueRange.this.oldestPossibleTimestamp, DataItemValueRange.this.values.size (), DataItemValueRange.this.firstValue );
        }
        finally
        {
            lock.readLock ().unlock ();
        }
    }

    public DataItemValueRangeState getState ()
    {
        lock.readLock ().lock ();
        try
        {
            return new DataItemValueRangeState ( DataItemValueRange.this.oldestPossibleTimestamp, DataItemValueRange.this.values.size (), DataItemValueRange.this.firstValue, new TreeSet<DataItemValueLight> ( DataItemValueRange.this.values ) );
        }
        finally
        {
            lock.readLock ().unlock ();
        }
    }

    public long getRange ()
    {
        return this.rangeOrAlignment;
    }

    public TimeUnit getAbsolute ()
    {
        return this.absolute;
    }

    private int checkRangeInternal ( final long oldestPossibleTimestamp )
    {
        final TreeSet<DataItemValueLight> toRemove = new TreeSet<DataItemValueLight> ();
        for ( final DataItemValueLight dataItemValueLight : this.values )
        {
            if ( dataItemValueLight.getTimestamp () < oldestPossibleTimestamp )
            {
                toRemove.add ( dataItemValueLight );
            }
        }
        if ( !toRemove.isEmpty () )
        {
            this.firstValue = toRemove.last ();
            this.values.removeAll ( toRemove );
        }
        this.oldestPossibleTimestamp = oldestPossibleTimestamp;
        return this.values.size ();
    }

    public class DataItemValueRangeInfo implements Serializable
    {
        private static final long serialVersionUID = 1L;

        private final long oldestPossibleTimestamp;

        private final int size;

        private final DataItemValueLight firstValue;

        public DataItemValueRangeInfo ( final long oldestPossibleTimestamp, final int size, final DataItemValueLight firstValue )
        {
            this.oldestPossibleTimestamp = oldestPossibleTimestamp;
            this.size = size;
            this.firstValue = firstValue;
        }

        public long getOldestPossibleTimestamp ()
        {
            return this.oldestPossibleTimestamp;
        }

        public int getSize ()
        {
            return this.size;
        }

        public DataItemValueLight getFirstValue ()
        {
            return this.firstValue;
        }

        @Override
        public String toString ()
        {
            return "firstValue=" + this.firstValue + ", size=" + this.size + ", oldestPossibleTimestamp=" + String.format ( "[%1$tF %1$tT,%1$tL]", this.oldestPossibleTimestamp );
        }
    }

    public class DataItemValueRangeState extends DataItemValueRangeInfo
    {
        private static final long serialVersionUID = 1L;

        private final SortedSet<DataItemValueLight> values;

        public DataItemValueRangeState ( final long oldestPossibleTimestamp, final int size, final DataItemValueLight firstValue, final SortedSet<DataItemValueLight> values )
        {
            super ( oldestPossibleTimestamp, size, firstValue );
            this.values = values;
        }

        public SortedSet<DataItemValueLight> getValues ()
        {
            return this.values;
        }

        @Override
        public String toString ()
        {
            return super.toString () + ", values=" + this.values;
        }
    }
}
