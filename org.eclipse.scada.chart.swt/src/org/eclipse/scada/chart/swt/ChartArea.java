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
package org.eclipse.scada.chart.swt;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
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

    private final LocalResourceManager resourceManager;

    public ChartArea ( final Composite parent, final int style )
    {
        super ( parent, SWT.DOUBLE_BUFFERED );
        this.chartRenderer = new ChartAreaRenderer ( this );
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( parent.getDisplay () ) );

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
        this.resourceManager.dispose ();
        this.chartRenderer.dispose ();
    }

    protected void onPaint ( final PaintEvent e )
    {
        final SWTGraphics g = new SWTGraphics ( e.gc, this.resourceManager );
        try
        {
            this.chartRenderer.paint ( g );
        }
        finally
        {
            g.dispose ();
        }
    }
}
