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

import java.util.SortedSet;

import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.SeriesData;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DataPoint;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Rectangle;

public class LinearRenderer extends AbstractLineRender implements Renderer
{

    public LinearRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
    }

    @Override
    protected void performRender ( final Graphics g, final Rectangle clientRect )
    {

        final Path path = g.createPath ();

        try
        {
            // eval min/max
            final XAxis xAxis = this.seriesData.getXAxis ();
            final YAxis yAxis = this.seriesData.getYAxis ();

            final SortedSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
            if ( entries.isEmpty () )
            {
                return;
            }

            boolean first = true;

            final DataPoint point = new DataPoint ();

            for ( final DataEntry entry : entries )
            {
                final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );
                if ( hasData )
                {
                    if ( first )
                    {
                        first = false;
                        path.moveTo ( point.x, point.y );
                    }
                    else
                    {
                        path.lineTo ( point.x, point.y );
                    }
                }
                else
                {
                    first = true;
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
