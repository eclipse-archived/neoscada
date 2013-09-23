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
package org.eclipse.scada.chart.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ChartArea extends Canvas
{

    private final ChartRenderer chartRenderer;

    public ChartArea ( final Composite parent, final int style )
    {
        super ( parent, SWT.DOUBLE_BUFFERED );
        this.chartRenderer = new ChartAreaRenderer ( this );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );

        addPaintListener ( new PaintListener () {

            @Override
            public void paintControl ( final PaintEvent e )
            {
                onPaint ( e );
            }
        } );

        addListener ( SWT.Resize, new Listener () {

            @Override
            public void handleEvent ( final Event event )
            {
                resizeAll ( getClientArea () );
            }
        } );
    }

    public ChartRenderer getChartRenderer ()
    {
        return this.chartRenderer;
    }

    protected void resizeAll ( final Rectangle clientArea )
    {
        this.chartRenderer.resizeAll ( clientArea );
    }

    protected void onDispose ()
    {
        this.chartRenderer.dispose ();
    }

    protected void onPaint ( final PaintEvent e )
    {
        this.chartRenderer.paint ( new SWTGraphics ( e.gc ) );
    }
}
