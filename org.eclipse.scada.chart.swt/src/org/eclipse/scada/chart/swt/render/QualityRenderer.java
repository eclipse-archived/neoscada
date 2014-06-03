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
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class QualityRenderer extends AbstractDataSeriesRenderer
{
    public QualityRenderer ( final ChartRenderer chartArea, final SeriesData abstractSeriesData )
    {
        super ( chartArea, abstractSeriesData );
    }

    @Override
    protected void performRender ( final Graphics g, final Rectangle clientRect )
    {
        final XAxis xAxis = this.seriesData.getXAxis ();
        final YAxis yAxis = this.seriesData.getYAxis ();

        g.setBackground ( new RGB ( 255, 0, 0 ) );
        g.setAlpha ( 128 );

        final SortedSet<DataEntry> entries = this.seriesData.getViewData ().getEntries ();
        if ( entries.isEmpty () )
        {
            g.fillRectangle ( clientRect );
            return;
        }

        g.setClipping ( clientRect );

        final DataPoint point = new DataPoint ();

        Integer lastPosition = null;
        Integer lastValidPosition = null;

        final DataEntry first = entries.first ();
        translateToPoint ( clientRect, xAxis, yAxis, point, first );
        if ( point.x > 0 )
        {
            g.fillRectangle ( clientRect.x, clientRect.y, (int)point.x - clientRect.x, clientRect.height );
        }

        final DataEntry last = entries.last ();
        translateToPoint ( clientRect, xAxis, yAxis, point, last );
        if ( point.x >= 0 && point.x < clientRect.width )
        {
            g.fillRectangle ( (int)point.x, clientRect.y, (int) ( clientRect.width - ( point.x - 1 - clientRect.x ) ), clientRect.height );
        }
        else if ( point.x < 0 )
        {
            g.fillRectangle ( clientRect );
        }

        for ( final DataEntry entry : entries )
        {
            final boolean hasData = translateToPoint ( clientRect, xAxis, yAxis, point, entry );

            final boolean qualityOk = checkQuality ( hasData, entry.getValue () );

            if ( lastPosition != null )
            {
                g.fillRectangle ( lastPosition, clientRect.y, (int)point.x - lastPosition, clientRect.height );
            }

            if ( !qualityOk )
            {
                if ( lastValidPosition != null && lastPosition == null )
                {
                    g.fillRectangle ( lastValidPosition, clientRect.y, (int)point.x - lastValidPosition, clientRect.height );
                }
                lastPosition = (int)point.x;
            }
            else
            {
                lastValidPosition = (int)point.x;
                lastPosition = null;
            }
        }

        g.setClipping ( clientRect );
    }

    protected boolean checkQuality ( final boolean hasData, final Double value )
    {
        return hasData;
    }
}
