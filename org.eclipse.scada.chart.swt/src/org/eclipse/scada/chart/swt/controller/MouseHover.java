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

import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.render.AbstractRuler;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class MouseHover extends AbstractRuler implements ChartMouseMoveListener
{
    public static interface Listener
    {
        public void mouseMove ( MouseState state, long timestamp );
    }

    private final ChartRenderer chart;

    private Integer position;

    private final RGB color = new RGB ( 0, 0, 0 );

    public MouseHover ( final ChartRenderer chart )
    {
        this.chart = chart;

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
        final Rectangle rect = this.chart.getClientAreaProxy ().getClientRectangle ();

        final int x = state.x;
        final int y = state.y;

        this.position = null;

        if ( x < rect.x || x > rect.x + rect.width )
        {
            return;
        }
        if ( y < rect.y || y > rect.y + rect.height )
        {
            return;
        }

        this.position = x;

        if ( this.visible )
        {
            this.chart.refresh ();
        }
    }

    @Override
    protected void doRender ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.position == null )
        {
            return;
        }

        final int x = this.position;
        g.setForeground ( this.color );
        g.drawLine ( x, clientRectangle.y, x, clientRectangle.y + clientRectangle.height );
    }

}
