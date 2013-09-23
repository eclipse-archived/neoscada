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
package org.eclipse.scada.chart.swt.controller;

import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartMouseListener;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;

public class MouseTransformer implements ChartMouseListener, ChartMouseMoveListener
{
    private boolean active;

    private int startX;

    private int startY;

    private final ChartRenderer chartArea;

    private final XAxis xAxis;

    private final YAxis yAxis;

    public MouseTransformer ( final ChartRenderer chartArea, final XAxis xAxis, final YAxis yAxis )
    {
        this.chartArea = chartArea;
        this.xAxis = xAxis;
        this.yAxis = yAxis;

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
        if ( rect.width > 0 )
        {
            this.xAxis.transform ( diffX, rect.width );
            update = true;
        }
        if ( rect.height > 0 )
        {
            this.yAxis.transform ( diffY, rect.height );
            update = true;
        }

        if ( update )
        {
            this.chartArea.redraw ();
        }
    }

}
