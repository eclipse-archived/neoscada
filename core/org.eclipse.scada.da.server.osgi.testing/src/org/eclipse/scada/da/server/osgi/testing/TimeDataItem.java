/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.testing;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;

public class TimeDataItem extends DataItemInputChained
{

    private ScheduledExecutorService scheduledExecutor;

    private ScheduledFuture<?> job;

    private String format;

    public TimeDataItem ( final String id, final ScheduledExecutorService executor )
    {
        super ( id, executor );
        this.scheduledExecutor = executor;
    }

    public synchronized void update ( final Map<String, String> parameters )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        setPeriod ( cfg.getIntegerChecked ( "period", "'period' must be set to a positive integer value" ) );
        this.format = cfg.getString ( "format", null );
    }

    private synchronized void setPeriod ( final int period )
    {
        if ( this.job != null )
        {
            this.job.cancel ( false );
            this.job = null;
        }

        this.job = this.scheduledExecutor.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                tick ();
            }
        }, 0, period, TimeUnit.MILLISECONDS );
    }

    public void tick ()
    {
        final Variant value;
        synchronized ( this )
        {
            if ( this.format == null )
            {
                value = Variant.valueOf ( System.currentTimeMillis () );
            }
            else
            {
                value = Variant.valueOf ( String.format ( this.format, new Date () ) );
            }
        }
        updateData ( value, null, null );
    }

    public synchronized void dispose ()
    {
        this.scheduledExecutor = null;
        this.job.cancel ( false );
        this.job = null;
    }

}
