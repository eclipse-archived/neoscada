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
package org.eclipse.scada.chart.swt.controller;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartMouseListener;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.render.Renderer;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class MouseDragZoomer implements Renderer
{
    private final ChartRenderer chart;

    private final ChartMouseMoveListener mouseMoveListener;

    private Point start;

    private Rectangle selection;

    private final XAxis xAxis;

    private final YAxis yAxis;

    private final ChartMouseListener mouseListener;

    public MouseDragZoomer ( final ChartRenderer chart, final XAxis xAxis, final YAxis yAxis )
    {
        this.chart = chart;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

        chart.addRenderer ( this );

        this.mouseMoveListener = new ChartMouseMoveListener () {

            @Override
            public void onMouseMove ( final MouseState state )
            {
                handleMouseMove ( state );
            }
        };

        chart.addMouseListener ( this.mouseListener = new ChartMouseListener () {

            @Override
            public void onMouseDoubleClick ( final MouseState state )
            {
            }

            @Override
            public void onMouseDown ( final MouseState state )
            {
                if ( state.button == 1 && state.state == 0 )
                {
                    startZoom ( state );
                }
            }

            @Override
            public void onMouseUp ( final MouseState state )
            {
                endZoom ( state );
            }

        } );

        chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );
    }

    private void detachMouseMoveListener ()
    {
        this.chart.removeMouseMoveListener ( this.mouseMoveListener );
    }

    public void dispose ()
    {
        this.chart.removeMouseListener ( this.mouseListener );
        this.chart.removeRenderer ( this );
        detachMouseMoveListener ();
    }

    protected void endZoom ( final MouseState e )
    {
        processZoom ( this.selection );
        detachMouseMoveListener ();
        this.selection = null;
        this.chart.redraw ();
    }

    protected void startZoom ( final MouseState state )
    {
        this.chart.addMouseMoveListener ( this.mouseMoveListener );

        final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

        this.start = new Point ( state.x - chartRect.x, state.y - chartRect.y );
    }

    protected void handleMouseMove ( final MouseState state )
    {
        this.selection = makeSelection ( new Point ( state.x, state.y ) );
        this.chart.redraw ();
    }

    private Rectangle makeSelection ( final Point point )
    {
        final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

        return new Rectangle ( this.start.x, this.start.y, point.x - chartRect.x - this.start.x, point.y - chartRect.y - this.start.y );
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.selection != null )
        {
            final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

            g.setLineAttributes ( new LineAttributes ( 1.0f ) );
            g.setForeground ( null );

            g.drawRectangle ( this.selection.x + chartRect.x, this.selection.y + chartRect.y, this.selection.width, this.selection.height );
        }
    }

    @Override
    public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
    {
        // NO-OP
        return null;
    }

    private void processZoom ( final Rectangle selection )
    {
        if ( selection == null )
        {
            return;
        }

        final Rectangle client = this.chart.getClientAreaProxy ().getClientRectangle ();

        if ( selection.width == 0 || selection.width == 0 )
        {
            // if one of them is zero it won't work
            return;
        }

        if ( selection.width > 0 && selection.height > 0 )
        {
            // zoom in
            final long minTimestamp = this.xAxis.translateToValue ( client.width, selection.x );
            final long maxTimestamp = this.xAxis.translateToValue ( client.width, selection.x + selection.width );

            final double maxValue = this.yAxis.translateToValue ( client.height, selection.y );
            final double minValue = this.yAxis.translateToValue ( client.height, selection.y + selection.height );

            this.xAxis.setMinMax ( minTimestamp, maxTimestamp );
            this.yAxis.setMinMax ( minValue, maxValue );
        }
        else
        {
            final int widthSelection = Math.abs ( selection.width );
            final int heightSelection = Math.abs ( selection.height );
            final int widthClient = client.width;
            final int heightClient = client.height;

            this.xAxis.zoom ( 1.0 + Math.abs ( (double)widthSelection ) / widthClient );
            this.yAxis.zoom ( 1.0 + Math.abs ( (double)heightSelection ) / heightClient );
        }
    }
}
