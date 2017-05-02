/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.hd.QueryListener;

/**
 * A query buffer that can be updated with new data later
 * 
 * @author Jens Reimann
 */
public class UpdatableQueryBuffer extends QueryBuffer
{
    private final List<Entry> updateList = new LinkedList<Entry> ();

    private final int updateListMax = Integer.getInteger ( "org.eclipse.scada.hd.server.storage.hds.updateListMax", 10 );

    private final long updateTimeMax = Long.getLong ( "org.eclipse.scada.hd.server.storage.hds.updateTimeMax", 1000 );

    private ScheduledFuture<?> flushFuture;

    private final ScheduledExecutorService scheduledExecutor;

    public UpdatableQueryBuffer ( final QueryListener listener, final ScheduledExecutorService executor, final Date fixedStartDate, final Date fixedEndDate )
    {
        super ( listener, executor, fixedStartDate, fixedEndDate );
        this.scheduledExecutor = executor;
    }

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