/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes
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

    public StepRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
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
            Float previousY = null;

            logger.trace ( "Render steps" );

            for ( final DataEntry entry : entries )
            {
                final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

                logger.trace ( "Entry - {}, hasData: {}, point: {}", new Object[] { entry, hasData, point } );

                if ( hasData )
                {
                    if ( first )
                    {
                        first = false;
                        path.moveTo ( point.x, point.y );
                    }
                    else
                    {
                        path.lineTo ( point.x, previousY );
                        path.lineTo ( point.x, point.y );
                    }
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
                }
            }

            g.setAlpha ( 255 );
            g.setLineAttributes ( this.lineAttributes );
            g.setForeground ( this.lineColor );

            g.setClipping ( clientRect );
            g.drawPath ( path );
        }
        finally
        {
            path.dispose ();
        }
    }
}
