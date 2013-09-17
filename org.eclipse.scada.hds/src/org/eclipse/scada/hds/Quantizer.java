/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        if ( now == null )
        {
            return new Date ( System.currentTimeMillis () - this.millisTime * this.count );
        }
        else
        {
            return new Date ( now.getTime () - this.millisTime * this.count );
        }
    }

    public Date getValidStart ( final Date timestamp, final Date now )
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

    public Date getValidStart ( final Date timestamp )
    {
        return getValidStart ( timestamp, new Date () );
    }

    public Date getStart ( final Date timestamp )
    {
        final long tix = timestamp.getTime () / this.millisTime * this.millisTime;
        logger.trace ( "Timestamp {} -> {}", timestamp.getTime (), tix );
        return new Date ( tix );
    }

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
