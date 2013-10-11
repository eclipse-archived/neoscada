/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.NullExtensionSpace;
import org.eclipse.swt.graphics.Rectangle;

public class ChartFigure extends Figure
{
    private ChartRenderer renderer;

    private ChartViewer viewer;

    private Chart configuration;

    private boolean realize;

    public ChartFigure ()
    {
    }

    public void setConfiguration ( final Chart configuration )
    {
        // dispose if created
        doDisposeRenderer ();

        // set configuration
        this.configuration = configuration;

        // check to create .. will only created if was created due to the realize flag
        checkCreate ();
    }

    @Override
    public void addNotify ()
    {
        super.addNotify ();
        createRenderer ();
    }

    @Override
    public void removeNotify ()
    {
        disposeRenderer ();
        super.removeNotify ();
    };

    private static Chart makeDefaultConfiguration ()
    {
        final Chart configuration = ChartFactory.eINSTANCE.createChart ();

        final YAxis y = ChartFactory.eINSTANCE.createYAxis ();
        y.setLabel ( "Values" );
        configuration.getLeft ().add ( y );

        final XAxis x = ChartFactory.eINSTANCE.createXAxis ();
        x.setLabel ( "Time" );
        x.setFormat ( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL" );
        x.setMinimum ( System.currentTimeMillis () );
        x.setMaximum ( System.currentTimeMillis () + 900 * 1000 );
        configuration.getBottom ().add ( x );

        configuration.setSelectedXAxis ( x );
        configuration.setSelectedYAxis ( y );

        return configuration;
    }

    protected void disposeRenderer ()
    {
        this.realize = false;
        doDisposeRenderer ();
    }

    private void doDisposeRenderer ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
            this.viewer = null;
        }
        if ( this.renderer != null )
        {
            this.renderer.dispose ();
            this.renderer = null;
        }
    }

    protected void createRenderer ()
    {
        disposeRenderer ();
        this.realize = true;
        checkCreate ();
    }

    private void doCreateRenderer ()
    {
        this.renderer = new FigureRenderer ( this );
        this.viewer = new ChartViewer ( this.renderer, this.configuration != null ? this.configuration : makeDefaultConfiguration (), new NullExtensionSpace (), null );
    }

    private void checkCreate ()
    {
        if ( this.configuration != null && this.realize )
        {
            doCreateRenderer ();
        }
    }

    @Override
    public void setSize ( final int w, final int h )
    {
        super.setSize ( w, h );
        if ( this.renderer != null )
        {
            this.renderer.resizeAll ( new Rectangle ( 0, 0, w, h ) );
        }
    }

    @Override
    protected void paintClientArea ( final Graphics graphics )
    {
        if ( this.renderer != null )
        {
            final Draw2DGraphics g = new Draw2DGraphics ( graphics );
            this.renderer.paint ( g );
        }
    }
}