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
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;

public class MouseWheelZoomer implements MouseWheelListener
{
    private final XAxis x;

    private final YAxis y;

    private final ChartRenderer chart;

    public MouseWheelZoomer ( final ChartRenderer chart, final XAxis x, final YAxis y )
    {
        this.x = x;
        this.y = y;
        this.chart = chart;

        this.chart.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );
        this.chart.addMouseWheelListener ( this );
    }

    public void dispose ()
    {
        this.chart.removeMouseWheelListener ( this );
    }

    @Override
    public void mouseScrolled ( final MouseEvent e )
    {
        if ( e.stateMask == 0 )
        {
            this.x.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        else if ( ( e.stateMask & SWT.MOD1 ) > 0 )
        {
            this.y.zoom ( e.count < 0 ? 0.1 : -0.1 );
        }
        this.chart.redraw ();
    }
}