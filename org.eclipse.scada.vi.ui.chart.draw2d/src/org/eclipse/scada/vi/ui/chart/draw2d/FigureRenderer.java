/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *     IBH SYSTEMS GmbH - bug fixes and enhancements
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.swt.ChartMouseListener;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisplayRealm;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class FigureRenderer extends ChartRenderer
{

    public class FigureListenerImpl implements FigureListener
    {
        @Override
        public void figureMoved ( final IFigure source )
        {
            handleResize ();
        }
    }

    private final ChartFigure chartFigure;

    private final FigureListenerImpl figureListener;

    private final Realm realm;

    public FigureRenderer ( final ChartFigure chartFigure, final ResourceManager resourceManager )
    {
        super ( resourceManager );

        this.realm = new DisplayRealm ( Display.getCurrent () );

        this.chartFigure = chartFigure;
        this.figureListener = new FigureListenerImpl ();
        this.chartFigure.addFigureListener ( this.figureListener );
    }

    @Override
    public void dispose ()
    {
        this.chartFigure.removeFigureListener ( this.figureListener );
        super.dispose ();
    }

    protected void handleResize ()
    {
        resizeAll ( getClientArea () );
    }

    @Override
    protected void redraw ()
    {
        this.chartFigure.getUpdateManager ().addDirtyRegion ( this.chartFigure, this.chartFigure.getBounds () );
    }

    @Override
    public Rectangle getClientArea ()
    {
        final org.eclipse.draw2d.geometry.Rectangle rect = this.chartFigure.getClientArea ();
        return new Rectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    private final Map<ChartMouseListener, org.eclipse.draw2d.MouseListener> mouseListenerMap = new HashMap<ChartMouseListener, org.eclipse.draw2d.MouseListener> ();

    @Override
    public void addMouseListener ( final ChartMouseListener mouseListener )
    {
        removeMouseListener ( mouseListener );
        final org.eclipse.draw2d.MouseListener proxyListener = new org.eclipse.draw2d.MouseListener () {
            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                mouseListener.onMouseDoubleClick ( convertEvent ( me ) );
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                mouseListener.onMouseDown ( convertEvent ( me ) );
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
                mouseListener.onMouseUp ( convertEvent ( me ) );
            }
        };
        this.mouseListenerMap.put ( mouseListener, proxyListener );
        this.chartFigure.addMouseListener ( proxyListener );
    }

    @Override
    public void removeMouseListener ( final ChartMouseListener mouseListener )
    {
        final org.eclipse.draw2d.MouseListener proxyListener = this.mouseListenerMap.remove ( mouseListener );
        if ( proxyListener != null )
        {
            this.chartFigure.removeMouseListener ( proxyListener );
        }
    }

    private final Map<ChartMouseMoveListener, MouseMotionListener> mouseMoveListenerMap = new HashMap<ChartMouseMoveListener, MouseMotionListener> ();

    @Override
    public void addMouseMoveListener ( final ChartMouseMoveListener mouseMoveListener )
    {
        removeMouseMoveListener ( mouseMoveListener );
        final MouseMotionListener proxyListener = new MouseMotionListener () {

            @Override
            public void mouseMoved ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }

            @Override
            public void mouseHover ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
            }

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
            }

            @Override
            public void mouseDragged ( final MouseEvent me )
            {
                mouseMoveListener.onMouseMove ( convertEvent ( me ) );
            }
        };
        this.mouseMoveListenerMap.put ( mouseMoveListener, proxyListener );
        this.chartFigure.addMouseMotionListener ( proxyListener );
    }

    @Override
    public void removeMouseMoveListener ( final ChartMouseMoveListener mouseMoveListener )
    {
        final MouseMotionListener proxyListener = this.mouseMoveListenerMap.remove ( mouseMoveListener );
        if ( proxyListener != null )
        {
            this.chartFigure.removeMouseMotionListener ( proxyListener );
        }
    }

    @Override
    public void addMouseWheelListener ( final MouseWheelListener listener )
    {
    }

    @Override
    public void removeMouseWheelListener ( final MouseWheelListener listener )
    {
    }

    @Override
    public Realm getRealm ()
    {
        return this.realm;
    }

    private MouseState convertEvent ( final MouseEvent me )
    {
        final MouseState state = new MouseState ();
        state.button = me.button;
        state.x = me.x;
        state.y = me.y;
        state.state = me.getState ();
        return state;
    }
}
