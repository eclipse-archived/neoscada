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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartMouseListener;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

/**
 * This class allows to pan the chart area, moving into all directions
 */
public class MouseTransformer extends AbstractMouseHandler implements ChartMouseListener, ChartMouseMoveListener
{
    private boolean active;

    private int startX;

    private int startY;

    private final ChartRenderer chartArea;

    public MouseTransformer ( final ChartRenderer chartArea, final IObservableList/*XAxis*/xAxis, final IObservableList/*YAxis*/yAxis )
    {
        super ( xAxis, yAxis );

        this.chartArea = chartArea;

        chartArea.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );

        chartArea.addMouseListener ( this );
        chartArea.addMouseMoveListener ( this );
    }

    public void dispose ()
    {
        this.chartArea.removeMouseListener ( this );
        this.chartArea.removeMouseMoveListener ( this );
    }

    @Override
    public void onMouseDoubleClick ( final MouseState state )
    {
    }

    @Override
    public void onMouseDown ( final MouseState e )
    {
        if ( e.button != 1 || e.state != SWT.MOD1 )
        {
            return;
        }

        final Rectangle rect = this.chartArea.getClientAreaProxy ().getClientRectangle ();

        // check if we are outside the chart area
        if ( e.x < rect.x || e.x > rect.x + rect.width )
        {
            return;
        }
        if ( e.y < rect.y || e.y > rect.y + rect.height )
        {
            return;
        }

        // now start dragging

        this.active = true;

        this.startX = e.x;
        this.startY = e.y;
    }

    @Override
    public void onMouseUp ( final MouseState state )
    {
        this.active = false;
    }

    @Override
    public void onMouseMove ( final MouseState state )
    {
        if ( !this.active )
        {
            return;
        }

        final int diffX = this.startX - state.x;
        this.startX = state.x;

        final int diffY = this.startY - state.y;
        this.startY = state.y;

        final Rectangle rect = this.chartArea.getClientAreaProxy ().getClientRectangle ();
        boolean update = false;

        this.chartArea.setStale ( true );

        if ( rect.width > 0 )
        {
            processX ( new AxisFunction<XAxis> () {

                @Override
                public void process ( final XAxis axis )
                {
                    axis.transform ( diffX, rect.width );
                }
            } );
            update = true;
        }
        if ( rect.height > 0 )
        {
            processY ( new AxisFunction<YAxis> () {

                @Override
                public void process ( final YAxis axis )
                {
                    axis.transform ( diffY, rect.height );
                }
            } );
            update = true;
        }

        this.chartArea.setStale ( false );

        if ( update )
        {
            // this.chartArea.redraw ();
        }
    }

}
