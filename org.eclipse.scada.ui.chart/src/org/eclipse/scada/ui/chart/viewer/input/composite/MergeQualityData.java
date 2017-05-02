/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - fix alignment issue
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input.composite;

import java.util.Collection;
import java.util.NavigableSet;

import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.SeriesViewData;
import org.eclipse.scada.chart.WritableSeriesData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;

public class MergeQualityData
{
    private final static Logger logger = LoggerFactory.getLogger ( MergeQualityData.class );

    private final Collection<CompositeSource> sources;

    private WritableSeriesData data;

    private final long startTimestamp;

    private final long endTimestamp;

    private final int width;

    public MergeQualityData ( final Collection<CompositeSource> sources, final long startTimestamp, final long endTimestamp, final int width )
    {
        this.sources = sources;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.width = width;
    }

    private static class Entry
    {
        public Double value;

        public long timestamp;
    }

    public void merge ()
    {
        this.data = new WritableSeriesData ();

        if ( this.width <= 0 || this.startTimestamp >= this.endTimestamp )
        {
            logger.debug ( "Skip merge - width: {}, start: {}, end: {}", this.width, this.startTimestamp, this.endTimestamp );
            return;
        }

        final Profiler p = new Profiler ( "Merge" ); //$NON-NLS-1$
        p.setLogger ( logger );

        final long start = System.currentTimeMillis ();

        try
        {
            p.start ( "Init" ); //$NON-NLS-1$
            final Entry[] data = new Entry[this.width];

            final long diff = this.endTimestamp - this.startTimestamp;
            final double step = (double)diff / (double)this.width;
            double c = 0.0;

            for ( int i = 0; i < data.length; i++ )
            {
                data[i] = new Entry ();
                data[i].timestamp = this.startTimestamp + (long)c;
                c += step;
            }

            p.start ( "Perform merge" ); //$NON-NLS-1$
            performMerge ( data, step );

            p.start ( "Convert" ); //$NON-NLS-1$
            for ( final Entry entry : data )
            {
                this.data.add ( new DataEntry ( entry.timestamp, entry.value ) );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to merge data", e ); //$NON-NLS-1$
        }
        finally
        {
            p.stop ();

            final boolean tooLong = System.currentTimeMillis () - start > 10 * 1000;

            if ( tooLong || logger.isTraceEnabled () )
            {
                p.log ();
            }
        }
    }

    private void performMerge ( final Entry[] data, final double step )
    {
        logger.debug ( "Running merge for {} sources", this.sources.size () ); //$NON-NLS-1$

        for ( final CompositeSource source : this.sources )
        {
            final SeriesViewData viewData = source.getViewData ();
            if ( viewData == null )
            {
                logger.trace ( "No view data" );
                continue;
            }
            final NavigableSet<DataEntry> entries = viewData.getEntries ();
            if ( entries == null )
            {
                logger.trace ( "No entries" );
                continue;
            }

            for ( final DataEntry entry : entries )
            {
                if ( entry.getTimestamp () < this.startTimestamp || entry.getTimestamp () >= this.endTimestamp )
                {
                    continue;
                }

                final int idx = (int)Math.ceil ( ( entry.getTimestamp () - this.startTimestamp ) / step );
                logger.trace ( "ts: {}, start: {}, step: {} => {}", entry.getTimestamp (), this.startTimestamp, step, ( entry.getTimestamp () - this.startTimestamp ) / step );

                // if we have no quality value, it is zero
                final double q = entry.getValue () == null ? 0.0 : entry.getValue ();

                logger.trace ( "merged quality [{}]: {}", idx, q );

                if ( idx >= data.length )
                {
                    logger.debug ( "Break loop early" );
                    break;
                }

                if ( data[idx].value == null )
                {
                    // first value .. so we simply assign
                    data[idx].value = q;
                }
                else
                {
                    data[idx].value = Math.min ( data[idx].value, q );
                }
            }
        }
    }

    public WritableSeriesData getData ()
    {
        return this.data;
    }
}
