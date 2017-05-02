/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.testing.test1;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.datasource.base.AbstractInputDataSource;

public abstract class ScheduledDataSource extends AbstractInputDataSource
{
    protected int timeDiff;

    protected final ScheduledExecutorService scheduler;

    protected ScheduledFuture<?> future;

    public ScheduledDataSource ( final ScheduledExecutorService scheduler )
    {
        super ();
        this.scheduler = scheduler;

        setDelay ( 250 );
    }

    private void setDelay ( final int delay )
    {
        if ( this.future != null )
        {
            this.future.cancel ( false );
        }

        this.future = this.scheduler.scheduleAtFixedRate ( new Runnable () {

            public void run ()
            {
                ScheduledDataSource.this.tick ();
            }
        }, 0, delay, TimeUnit.MILLISECONDS );
    }

    protected abstract void tick ();

    @Override
    protected Executor getExecutor ()
    {
        return this.scheduler;
    }

    public void dispose ()
    {
        this.future.cancel ( false );
    }

    protected static int getInteger ( final Map<String, String> properties, final String key, final int defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }
        try
        {
            return Integer.parseInt ( value );
        }
        catch ( final NumberFormatException e )
        {
            return defaultValue;
        }
    }

    protected static double getDouble ( final Map<String, String> properties, final String key, final double defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }
        try
        {
            return Double.parseDouble ( value );
        }
        catch ( final NumberFormatException e )
        {
            return defaultValue;
        }
    }

    protected static long getLong ( final Map<String, String> properties, final String key, final long defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }
        try
        {
            return Long.parseLong ( value );
        }
        catch ( final NumberFormatException e )
        {
            return defaultValue;
        }
    }

    public void update ( final Map<String, String> properties )
    {
        setDelay ( getInteger ( properties, "delay", 250 ) );

        this.timeDiff = getInteger ( properties, "time.diff", 0 );

    }

}