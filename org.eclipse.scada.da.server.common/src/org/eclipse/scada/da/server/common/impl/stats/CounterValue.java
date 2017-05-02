/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterValue implements Tickable
{

    private final static Logger logger = LoggerFactory.getLogger ( CounterValue.class );

    private long total = 0;

    private long lastTickValue = 0;

    private long lastTimestamp = 0;

    private CounterOutput output;

    public synchronized void add ( final long value )
    {
        this.total += value;
        this.lastTickValue = this.lastTickValue + Math.abs ( value );
        logger.debug ( "Adding: {}, LastTickValue: {}", value, this.lastTickValue );
    }

    @Override
    public synchronized void tick ()
    {
        // get now
        final long ts = System.currentTimeMillis ();

        // get the difference ( in seconds )
        long diff = ( ts - this.lastTimestamp ) / 1000;
        this.lastTimestamp = ts;

        // just in case
        if ( diff == 0 )
        {
            diff = 1;
        }

        // we need to do this here ... since otherwise the update call later will
        // increment the counter and setting the tickValue to null will discard
        // this information
        final long lastTickValue = this.lastTickValue;
        this.lastTickValue = 0;

        // calculate the average
        final double avg = (double)lastTickValue / (double)diff;
        logger.debug ( "LastTickValue: {}, Diff: {}, Avg: {}", new Object[] { lastTickValue, diff, avg } );
        this.output.setTickValue ( avg, this.total );
    }

    public void setOutput ( final CounterOutput output )
    {
        this.output = output;
    }
}
