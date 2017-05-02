/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.SeriesData;
import org.eclipse.scada.chart.SeriesDataListener;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DataPoint;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.graphics.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDataSeriesRenderer implements Renderer
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractDataSeriesRenderer.class );

    protected final SeriesData seriesData;

    private SeriesDataListener listener;

    private final ChartRenderer chartArea;

    private boolean visible = true;

    public AbstractDataSeriesRenderer ( final ChartRenderer chartArea, final SeriesData seriesData )
    {
        this.chartArea = chartArea;
        this.seriesData = seriesData;

        seriesData.addListener ( this.listener = new SeriesDataListener () {

            @Override
            public void dataUpdate ( final long startTimestamp, final long endTimestamp )
            {
                handleDataUpdate ( startTimestamp, endTimestamp );
            }
        } );
    }

    public void setVisible ( final boolean visible )
    {
        this.visible = visible;
        this.chartArea.refresh ();
    }

    public boolean isVisible ()
    {
        return this.visible;
    }

    protected void handleDataUpdate ( final long startTimestamp, final long endTimestamp )
    {
        logger.trace ( "Data update - {} -> {}", startTimestamp, endTimestamp );
        if ( this.chartArea.isDisposed () )
        {
            return;
        }
        this.chartArea.refresh ();
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( !this.visible )
        {
            return;
        }
        else
        {
            performRender ( g, clientRectangle );
        }
    }

    protected abstract void performRender ( Graphics g, Rectangle clientRectangle );

    public void dispose ()
    {
        this.seriesData.removeListener ( this.listener );
    }

    @Override
    public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
    {
        this.seriesData.setRequestWidth ( clientRectangle.width );
        return null;
    }

    protected static boolean translateToPoint ( final Rectangle clientRect, final XAxis x, final YAxis y, final DataPoint point, final DataEntry entry )
    {
        // we always need X
        point.x = clientRect.x + x.translateToClient ( clientRect.width, entry.getTimestamp () );

        final Double value = entry.getValue ();
        if ( value == null || Double.isNaN ( value ) || Double.isInfinite ( value ) )
        {
            return false;
        }

        // we only provide Y if we really have a value

        point.y = clientRect.y + y.translateToClient ( clientRect.height, value );

        return true;
    }

}