/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.QueryState;
import org.eclipse.scada.hd.data.QueryParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryBuffer extends QueryDataBuffer
{

    private final static Logger logger = LoggerFactory.getLogger ( QueryBuffer.class );

    private QueryParameters parameters;

    private static class Entry implements Comparable<Entry>
    {
        private final double value;

        private final Date timestamp;

        private final boolean error;

        private final boolean manual;

        public Entry ( final double value, final Date timestamp, final boolean error, final boolean manual )
        {
            this.value = value;
            this.timestamp = timestamp;
            this.error = error;
            this.manual = manual;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.timestamp == null ? 0 : this.timestamp.hashCode () );
            return result;
        }

        public Date getTimestamp ()
        {
            return this.timestamp;
        }

        public double getValue ()
        {
            return this.value;
        }

        public boolean isError ()
        {
            return this.error;
        }

        public boolean isManual ()
        {
            return this.manual;
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
            final Entry other = (Entry)obj;
            if ( this.timestamp == null )
            {
                if ( other.timestamp != null )
                {
                    return false;
                }
            }
            else if ( !this.timestamp.equals ( other.timestamp ) )
            {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo ( final Entry o )
        {
            return this.timestamp.compareTo ( o.timestamp );
        }

        @Override
        public String toString ()
        {
            return String.format ( "[timestamp: %tc, value: %s, error: %s, manual: %s]", this.timestamp, this.value, this.error, this.manual );
        }
    }

    protected static class Data extends QueryDataBuffer.Data
    {

        private final TreeSet<Entry> entries = new TreeSet<QueryBuffer.Entry> ();

        private long entryCount;

        public Data ( final Date start, final Date end )
        {
            super ( start, end );
        }

        public void add ( final Entry entry )
        {
            if ( !entry.getTimestamp ().before ( this.start ) && entry.getTimestamp ().before ( this.end ) )
            {
                // we only accept entries for start <= timestamp < end
                this.entries.add ( entry );
                if ( !Double.isNaN ( entry.value ) )
                {
                    this.entryCount++;
                }
            }
        }

        @Override
        public long getEntryCount ()
        {
            return this.entryCount;
        }

        public SortedSet<Entry> getEntries ()
        {
            return this.entries;
        }

    }

    private Entry firstEntry;

    private final SortedSet<Entry> entries = new TreeSet<QueryBuffer.Entry> ();

    private Data[] data;

    private final boolean useNaNs = Boolean.getBoolean ( "org.eclipse.scada.hd.server.storage.hds.useNaNs" );

    private final boolean renderWhileLoading = Boolean.getBoolean ( "org.eclipse.scada.hd.server.storage.hds.renderWhileLoading" );

    private final ScheduledExecutorService scheduledExecutor;

    public QueryBuffer ( final QueryListener listener, final ScheduledExecutorService executor, final Date fixedStartDate, final Date fixedEndDate )
    {
        super ( listener, executor, fixedStartDate, fixedEndDate );
        this.scheduledExecutor = executor;
    }

    @Override
    protected QueryDataBuffer.Data[] getData ()
    {
        return this.data;
    }

    public synchronized void changeParameters ( final QueryParameters parameters )
    {
        this.parameters = parameters;
        notifyStateUpdate ( QueryState.LOADING );
        notifyParameterUpdate ( parameters, new HashSet<String> ( Arrays.asList ( QueryDataBuffer.AVG, QueryDataBuffer.MIN, QueryDataBuffer.MAX, QueryDataBuffer.STDDEV ) ) );

        // clear
        this.entries.clear ();
        this.firstEntry = null;
        this.data = new Data[parameters.getNumberOfEntries ()];

        fillDataCells ( this.data, parameters.getStartTimestamp (), parameters.getEndTimestamp (), new DataFactory () {

            @Override
            public QueryDataBuffer.Data create ( final Date start, final Date end )
            {
                return new Data ( start, end );
            }
        } );

    }

    public QueryParameters getParameters ()
    {
        return this.parameters;
    }

    public synchronized void insertData ( final double value, final Date timestamp, final boolean error, final boolean manual )
    {
        insertData ( new Entry ( value, timestamp, error, manual ) );
    }

    /**
     * Insert data when loading
     */
    public synchronized void insertData ( final Entry entry )
    {
        final Date timestamp = entry.getTimestamp ();
        logger.debug ( "Received new data: {}", entry );

        if ( timestamp.before ( new Date ( this.parameters.getStartTimestamp () ) ) )
        {
            if ( this.firstEntry == null || this.firstEntry.getTimestamp ().before ( timestamp ) )
            {
                logger.debug ( "Evaluating entry as first entry: {}", entry );
                if ( !Double.isNaN ( entry.getValue () ) || this.useNaNs )
                {
                    logger.debug ( "Using entry as first entry" );
                    this.firstEntry = entry;
                }
            }
        }
        else if ( !timestamp.after ( new Date ( this.parameters.getEndTimestamp () ) ) )
        {
            logger.debug ( "Adding entry: {}", entry );
            this.entries.add ( entry );

            final int i = getDataIndex ( timestamp );

            logger.debug ( "Inserting into cell: {}", i );

            if ( i >= 0 && i < this.parameters.getNumberOfEntries () )
            {
                this.data[i].add ( entry );

                if ( this.renderWhileLoading && this.state == QueryState.LOADING )
                {
                    render ( i, i + 1 );
                }
            }
        }
    }

    /**
     * Render buffer from provided start index to the end of the buffer
     * 
     * @param startIndex
     *            the start index
     */
    private void render ( final int startIndex )
    {
        render ( startIndex, Integer.MAX_VALUE );
    }

    /**
     * render the buffer from the provided start to the provided end
     * 
     * @param startIndex
     *            the start index
     * @param endIndex
     *            the end index
     */
    private void render ( final int startIndex, int endIndex )
    {
        endIndex = Math.min ( endIndex, this.parameters.getNumberOfEntries () );

        Entry currentEntry = findPreviousEntry ( startIndex );

        double max = Double.NaN;
        double min = Double.NaN;

        final RunningAverage avg = new RunningAverage ();
        final RunningAverage quality = new RunningAverage ();
        final RunningAverage manual = new RunningAverage ();
        if ( currentEntry != null )
        {
            avg.next ( currentEntry.getValue (), currentEntry.getTimestamp ().getTime () );
            quality.next ( currentEntry.isError () ? 0.0 : 1.0, currentEntry.getTimestamp ().getTime () );
            manual.next ( currentEntry.isManual () ? 1.0 : 0.0, currentEntry.getTimestamp ().getTime () );
            if ( !Double.isNaN ( currentEntry.getValue () ) )
            {
                min = max = currentEntry.getValue ();
            }
        }

        for ( int i = startIndex; i < endIndex; i++ )
        {
            // reset to start of cell
            avg.step ( this.data[i].getStart ().getTime () );
            quality.step ( this.data[i].getStart ().getTime () );
            manual.step ( this.data[i].getStart ().getTime () );

            for ( final Entry entry : this.data[i].getEntries () )
            {
                quality.next ( entry.isError () ? 0.0 : 1.0, entry.getTimestamp ().getTime () );
                manual.next ( entry.isManual () ? 1.0 : 0.0, entry.getTimestamp ().getTime () );

                if ( !Double.isNaN ( entry.getValue () ) || this.useNaNs )
                {
                    avg.next ( entry.getValue (), entry.getTimestamp ().getTime () );
                    if ( Double.isNaN ( max ) || Double.compare ( entry.getValue (), max ) > 0 )
                    {
                        max = entry.getValue ();
                    }
                    if ( Double.isNaN ( min ) || Double.compare ( entry.getValue (), min ) < 0 )
                    {
                        min = entry.getValue ();
                    }
                    currentEntry = entry;
                }
            }

            this.data[i].setAverage ( avg.getAverage ( this.data[i].getEnd ().getTime () ) );
            this.data[i].setStdDev ( avg.getDeviation ( this.data[i].getEnd ().getTime () ) );
            this.data[i].setQuality ( quality.getAverage ( this.data[i].getEnd ().getTime () ) );
            this.data[i].setManual ( manual.getAverage ( this.data[i].getEnd ().getTime () ) );
            this.data[i].setMin ( min );
            this.data[i].setMax ( max );

            if ( currentEntry != null )
            {
                min = max = currentEntry.getValue ();
            }
        }

        notifyData ( startIndex, endIndex );
    }

    protected Entry findPreviousEntry ( final int i )
    {
        if ( i <= 0 )
        {
            return this.firstEntry;
        }
        else
        {
            if ( this.data[i - 1].getEntries ().isEmpty () )
            {
                return findPreviousEntry ( i - 1 );
            }
            else
            {
                return this.data[i - 1].getEntries ().last ();
            }
        }
    }

    protected Entry findNextEntry ( final int i )
    {
        if ( i + 1 >= this.parameters.getNumberOfEntries () )
        {
            return null;
        }
        else
        {
            if ( this.data[i + 1].getEntries ().isEmpty () )
            {
                return findNextEntry ( i + 1 );
            }
            else
            {
                return this.data[i + 1].getEntries ().first ();
            }
        }
    }

    private int getDataIndex ( final Date timestamp )
    {
        if ( timestamp.before ( new Date ( this.parameters.getStartTimestamp () ) ) )
        {
            return -1;
        }

        final double period = getPeriod ();

        final long offset = timestamp.getTime () - this.parameters.getStartTimestamp ();

        return (int) ( offset / period );
    }

    private double getPeriod ()
    {
        return (double) ( this.parameters.getEndTimestamp () - this.parameters.getStartTimestamp () ) / (double)this.parameters.getNumberOfEntries ();
    }

    public synchronized void complete ()
    {
        render ( 0 );
        notifyStateUpdate ( QueryState.COMPLETE );
    }

    public synchronized void close ()
    {
        notifyStateUpdate ( QueryState.DISCONNECTED );
    }

    private final List<Entry> updateList = new LinkedList<Entry> ();

    private final int updateListMax = Integer.getInteger ( "org.eclipse.scada.hd.server.storage.hds.updateListMax", 10 );

    private final long updateTimeMax = Long.getLong ( "org.eclipse.scada.hd.server.storage.hds.updateTimeMax", 1000 );

    private ScheduledFuture<?> flushFuture;

    /**
     * Update data after loading has completed
     */
    public synchronized void updateData ( final double value, final Date timestamp, final boolean error, final boolean manual )
    {
        this.updateList.add ( new Entry ( value, timestamp, error, manual ) );
        if ( this.updateList.size () > this.updateListMax )
        {
            flushUpdateQueue ();
        }
        else if ( this.flushFuture == null )
        {
            this.flushFuture = this.scheduledExecutor.schedule ( new Runnable () {

                @Override
                public void run ()
                {
                    flushUpdateQueue ();

                }
            }, this.updateTimeMax, TimeUnit.MILLISECONDS );
        }
    }

    private synchronized void flushUpdateQueue ()
    {
        this.flushFuture = null;

        for ( final Entry entry : this.updateList )
        {
            insertData ( entry );
        }
        this.updateList.clear ();
        complete ();
    }

}
