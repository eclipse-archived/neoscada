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
package org.eclipse.scada.chart;

import java.util.NavigableSet;
import java.util.TreeSet;

public class WritableSeriesData implements SeriesViewData
{

    private double minValue = Double.POSITIVE_INFINITY;

    private double maxValue = Double.NEGATIVE_INFINITY;

    private long minTimestamp = Long.MAX_VALUE;

    private long maxTimestamp = Long.MIN_VALUE;

    private final TreeSet<DataEntry> entries = new TreeSet<DataEntry> ();

    private final WritableSeries writableSeries;

    public WritableSeriesData ()
    {
        this ( null );
    }

    public WritableSeriesData ( final WritableSeries writableSeries )
    {
        this.writableSeries = writableSeries;
    }

    public boolean add ( final DataEntry entry )
    {
        this.minValue = minValue ( this.minValue, entry.getValue () );
        this.maxValue = maxValue ( this.maxValue, entry.getValue () );
        this.minTimestamp = Math.min ( this.minTimestamp, entry.getTimestamp () );
        this.maxTimestamp = Math.max ( this.maxTimestamp, entry.getTimestamp () );

        final boolean result = this.entries.add ( entry );

        if ( this.writableSeries != null )
        {
            this.writableSeries.fireUpdateListener ( entry.getTimestamp (), entry.getTimestamp () );
        }

        return result;
    }

    public void addAsLast ( final DataEntry entry )
    {
        this.entries.tailSet ( entry, true ).clear ();
        add ( entry );
    }

    public boolean remove ( final DataEntry entry )
    {
        final boolean result = this.entries.remove ( entry );

        this.writableSeries.fireUpdateListener ( entry.getTimestamp (), entry.getTimestamp () );

        return result;
    }

    private static double minValue ( final double a, final Double b )
    {
        if ( b == null )
        {
            return a;
        }

        return Math.min ( a, b );
    }

    private static double maxValue ( final double a, final Double b )
    {
        if ( b == null )
        {
            return a;
        }

        return Math.max ( a, b );
    }

    @Override
    public long getMaxTimestamp ()
    {
        return this.maxTimestamp;
    }

    @Override
    public long getMinTimestamp ()
    {
        return this.minTimestamp;
    }

    @Override
    public double getMaxValue ()
    {
        return this.maxValue;
    }

    @Override
    public double getMinValue ()
    {
        return this.minValue;
    }

    @Override
    public NavigableSet<DataEntry> getEntries ()
    {
        return this.entries;
    }
}
