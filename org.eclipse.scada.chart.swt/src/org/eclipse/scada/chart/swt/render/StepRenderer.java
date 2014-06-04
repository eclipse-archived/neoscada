/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes, allow antialising
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import java.util.NavigableSet;

import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.SeriesData;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DataPoint;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepRenderer extends AbstractLineRender implements Renderer
{

    private final static Logger logger = LoggerFactory.getLogger ( StepRenderer.class );

    private boolean noFuture;

    private final ChartRenderer chartArea;

    public StepRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
        this.chartArea = chartArea;
    }

    public void setNoFuture ( final boolean noFuture )
    {
        this.noFuture = noFuture;
        this.chartArea.refresh ();
    }

    public boolean isNoFuture ()
    {
        return this.noFuture;
    }

    @Override
    protected void performRender ( final Graphics g, final Rectangle clientRect )
    {
        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        final NavigableSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
        if ( entries.isEmpty () )
        {
            return;
        }

        final Path path = g.createPath ();
        try
        {
            boolean first = true;

            final DataPoint point = new DataPoint ();
            Float previousX = null;
            Float previousY = null;

            logger.trace ( "Render steps" );

            final long now = System.currentTimeMillis ();

            for ( final DataEntry entry : entries )
            {
                final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

                logger.trace ( "Entry - {}, hasData: {}, point: {}", new Object[] { entry, hasData, point } );

                final boolean skip = this.noFuture && entry.getTimestamp () > now;

                if ( hasData && !skip )
                {
                    if ( first )
                    {
                        first = false;
                        path.moveTo ( point.x, point.y );
                    }
                    else
                    {
                        if ( previousX != null && previousX + 1 == point.x )
                        {
                            /* is the special case were we only advance one pixel.
                             * so we can draw a direct line and allow the
                             * antialiasing to kick in */

                            path.lineTo ( point.x, point.y );
                        }
                        else
                        {
                            path.lineTo ( point.x, previousY );
                            path.lineTo ( point.x, point.y );
                        }
                    }
                    previousX = point.x;
                    previousY = point.y;
                }
                else
                {
                    first = true;
                    if ( previousY != null )
                    {
                        path.lineTo ( point.x, previousY );
                        previousY = null;
                    }
                    previousX = null;
                }
            }

            g.setAlpha ( 255 );
            g.setLineAttributes ( this.lineAttributes );
            g.setForeground ( this.lineColor );
            g.setAntialias ( true );

            g.setClipping ( clientRect );
            g.drawPath ( path );
        }
        finally
        {
            path.dispose ();
        }
    }
}
