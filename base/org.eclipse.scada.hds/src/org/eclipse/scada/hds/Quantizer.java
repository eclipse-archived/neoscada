/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add some documentation, cleanup a bit
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A helper class to calculate quantized time frames <br/>
 * <p>
 * The basic idea is to align timestamp. This is done by splitting up time in
 * quantized time frames. The size of these time frames is defined by time and
 * unit.
 * </p>
 * <p>
 * This class provides some helper methods to calculate timestamp based on
 * parameters provided in the constructor.
 * </p>
 * <p>
 * The Quantizer can also be initialized with a maximum number of time frames
 * (count).
 * </p>
 */
public class Quantizer
{

    private final static Logger logger = LoggerFactory.getLogger ( Quantizer.class );

    /**
     * the millisTime in milliseconds
     */
    private final long millisTime;

    private final int count;

    private final long time;

    private final TimeUnit unit;

    public Quantizer ( final long time, final TimeUnit unit )
    {
        this ( time, unit, Integer.MAX_VALUE );
    }

    public Quantizer ( final long time, final TimeUnit unit, final int count )
    {
        this.millisTime = TimeUnit.MILLISECONDS.convert ( time, unit );
        this.time = time;
        this.unit = unit;
        this.count = count;
    }

    public Date getEndOfPeriod ( final Date now )
    {
        // TODO: the result date is un-aligned, is this really what we want?
        if ( now == null )
        {
            return new Date ( System.currentTimeMillis () - this.millisTime * this.count );
        }
        else
        {
            return new Date ( now.getTime () - this.millisTime * this.count );
        }
    }

    protected Date getValidStart ( final Date timestamp, final Date now )
    {
        final Date start = getStart ( timestamp );

        final Date end = getEndOfPeriod ( now );

        if ( start.before ( end ) )
        {
            return null;
        }
        else
        {
            return start;
        }
    }

    /**
     * Get a quantized start timestamp if the timestamp is in the valid period
     * of the quantizer <br/>
     * This method calculates a quantized timestamp pointing at the start of the
     * time frame the timestamp is in. If the timestamp is outside the valid
     * range
     * of the quantizer ( before "count * time" ) then it returns
     * <code>null</code>.
     * 
     * @param timestamp
     *            an un-quantized timestamp
     * @return the quantized start timestamp or <code>null</code> if the
     *         timestamp is out of range
     */
    public Date getValidStart ( final Date timestamp )
    {
        return getValidStart ( timestamp, new Date () );
    }

    /**
     * Quantize to starting point before or at given timestamp
     * 
     * @param timestamp
     *            the given timestamp (not quantized)
     * @return the quantized timestamp or <code>null</code> if given timestamp
     *         was null
     */
    public Date getStart ( final Date timestamp )
    {
        if ( timestamp == null )
        {
            return null;
        }

        final long time = timestamp.getTime ();
        final long tix = time / this.millisTime * this.millisTime;
        logger.trace ( "Timestamp {} -> {}", time, tix );
        return new Date ( tix );
    }

    /**
     * Get the timestamp following a quantized timestamp
     * 
     * @param start
     *            an already quantized timestamp
     * @return the timestamp which is exactly one step behind the given timstamp
     */
    public Date getNext ( final Date start )
    {
        if ( start == null )
        {
            return null;
        }
        else
        {
            return new Date ( start.getTime () + this.millisTime );
        }
    }

    /**
     * Get the timestamp preceeding a quantized timestamp
     * 
     * @param start
     *            an already quantized timestamp
     * @return the timestamp which is exactly one step before the given timstamp
     */
    public Date getPrevious ( final Date start )
    {
        if ( start == null )
        {
            return null;
        }
        else
        {
            return new Date ( start.getTime () - this.millisTime );
        }
    }

    /**
     * Get the end timestamp of a time frame
     * 
     * @param timestamp
     *            an already quantized timestamp
     * @return the timestamp of the end of the time frame the timestamp is in.
     */
    public Date getEnd ( final Date timestamp )
    {
        return getNext ( getStart ( timestamp ) );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s|%s|%s]", this.time, this.unit, this.count );
    }
}
