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
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.render.AbstractPositionXRuler;
import org.eclipse.swt.graphics.Rectangle;

public class MouseHover extends AbstractPositionXRuler implements ChartMouseMoveListener
{
    public static interface Listener
    {
        public void mouseMove ( MouseState state, long timestamp );
    }

    private final ChartRenderer chart;

    private final XAxis xAxis;

    private final Listener listener;

    private long position;

    private Rectangle clientRect;

    public MouseHover ( final ChartRenderer chart, final XAxis xAxis, final Listener listener )
    {
        super ( xAxis );

        this.chart = chart;
        this.xAxis = xAxis;

        this.listener = listener;

        chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );

        chart.addMouseMoveListener ( this );
        chart.addRenderer ( this );
    }

    public void dispose ()
    {
        this.chart.removeRenderer ( this );
        this.chart.removeMouseMoveListener ( this );
    }

    @Override
    public void onMouseMove ( final MouseState state )
    {
        if ( this.listener != null )
        {
            this.position = this.xAxis.translateToValue ( this.clientRect.width, state.x - this.clientRect.x );
            this.listener.mouseMove ( state, this.position );
            if ( this.visible )
            {
                this.chart.redraw ();
            }
        }
    }

    @Override
    public Long getPosition ()
    {
        return this.position;
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        this.clientRect = clientRectangle;
        return super.resize ( clientRectangle );
    }

}
