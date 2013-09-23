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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AsyncFunctionSeriesData extends AbstractFunctionSeriesData
{

    private final static Logger logger = LoggerFactory.getLogger ( AsyncFunctionSeriesData.class );

    private final ExecutorService executor;

    private WritableSeriesData data;

    private Request nextRequest;

    private final int sleep;

    public AsyncFunctionSeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis, final int sleep )
    {
        super ( realm, xAxis, yAxis );
        this.sleep = sleep;
        this.executor = Executors.newSingleThreadExecutor ();

        this.data = new WritableSeriesData ();
        setRequest ( new Request ( xAxis.getMin (), xAxis.getMax (), 1 ) ); // initial load
    }

    @Override
    public SeriesViewData getViewData ()
    {
        return this.data;
    }

    @Override
    protected void setRequest ( final Request request )
    {
        super.setRequest ( request );

        boolean start;
        synchronized ( this )
        {
            start = this.nextRequest == null;
            this.nextRequest = request;
        }

        if ( start )
        {
            logger.debug ( "Starting request by: {}", request );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    generateData ();
                }
            } );
        }
    }

    protected void generateData ()
    {
        Request request;

        synchronized ( this )
        {
            request = this.nextRequest;
            this.nextRequest = null;
        }

        logger.debug ( "Processing request: {}", request );

        setData ( makeData ( request ) );
    }

    protected void setData ( final WritableSeriesData data )
    {
        if ( this.sleep > 0 )
        {
            try
            {
                Thread.sleep ( this.sleep );
            }
            catch ( final InterruptedException e )
            {
            }
        }
        this.data = data;
        fireUpdateListener ( data.getMinTimestamp (), data.getMaxTimestamp () );
    }

    @Override
    protected abstract Double eval ( long timestamp );

    public void regenerate ()
    {
        setRequest ( this.request );
    }

}
