/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup property handling, fix label rendering
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.Helper;
import org.eclipse.scada.chart.swt.Helper.Entry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class YAxisDynamicRenderer extends AbstractRenderer
{
    private YAxis axis;

    private Color color;

    private boolean left;

    private Rectangle rect;

    private int width = -1;

    protected final LineAttributes lineAttributes;

    private int labelSpacing = 15;

    private final int markerSize = 8;

    private int textPadding = 10;

    private final ChartRenderer chart;

    protected final ResourceManager resourceManager;

    private boolean showLabels = true;

    private String format;

    public YAxisDynamicRenderer ( final ChartRenderer chart )
    {
        super ( chart );
        this.chart = chart;
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( chart.getDisplay () ) );

        this.color = this.resourceManager.createColor ( new RGB ( 0, 0, 0 ) );
        this.lineAttributes = new LineAttributes ( 1.0f, SWT.CAP_FLAT, SWT.JOIN_BEVEL, SWT.LINE_SOLID, new float[0], 0.0f, 0.0f );
    }

    public void setFormat ( final String format )
    {
        this.format = format;
        relayoutParent ();
    }

    public String getFormat ()
    {
        return this.format;
    }

    public void setShowLabels ( final boolean showLabels )
    {
        this.showLabels = showLabels;
        relayoutParent ();
    }

    public boolean isShowLabels ()
    {
        return this.showLabels;
    }

    public void setLabelSpacing ( final int labelSpacing )
    {
        this.labelSpacing = labelSpacing;
        relayoutParent ();
    }

    public void setWidth ( final int width )
    {
        this.width = width;
        relayoutParent ();
    }

    public int getWidth ()
    {
        return this.width;
    }

    public void setTextPadding ( final int textPadding )
    {
        this.textPadding = textPadding;
        relayoutParent ();
    }

    public int getTextPadding ()
    {
        return this.textPadding;
    }

    public void setAlign ( final int alignment )
    {
        this.left = ( alignment & SWT.RIGHT ) != SWT.RIGHT;
        relayoutParent ();
    }

    public void setColor ( final RGB color )
    {
        this.color = this.resourceManager.createColor ( color );
        redraw ();
    }

    public RGB getColor ()
    {
        return this.color.getRGB ();
    }

    public void setAxis ( final YAxis axis )
    {
        checkWidget ();

        if ( this.axis != null )
        {
            this.axis.removePropertyChangeListener ( this.propertyChangeListener );
            this.axis = null;
        }

        this.axis = axis;

        if ( this.axis != null )
        {
            this.axis.addPropertyChangeListener ( this.propertyChangeListener );
        }

        relayoutParent ();
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.rect.width == 0 || this.rect.height == 0 || this.axis == null )
        {
            return;
        }

        final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

        final Rectangle clippingRect = new Rectangle ( this.rect.x, this.rect.y - 10, this.rect.width, this.rect.height + 20 );
        g.setClipping ( clippingRect );

        g.setLineAttributes ( this.lineAttributes );
        g.setForeground ( this.color );

        final int x = ( this.left ? this.rect.width - 1 : 0 ) + this.rect.x;

        g.drawLine ( x, this.rect.y, x, this.rect.y + this.rect.height );

        if ( this.showLabels )
        {
            final int fontHeight = g.getFontMetrics ().getHeight ();
            final List<Entry<Double>> markers = Helper.chartValues ( this.axis.getMin (), this.axis.getMax (), chartRect.height, fontHeight + this.labelSpacing );
            for ( final Entry<Double> marker : markers )
            {
                final Point labelSize = g.textExtent ( marker.label );
                final int y = marker.position + this.rect.y;
                g.drawText ( marker.label, this.left ? x - ( labelSize.x + this.textPadding + this.markerSize ) : x + this.textPadding, y - labelSize.y / 2, null );
                g.drawLine ( x, y, x + ( this.left ? -1 : 1 ) * this.markerSize, y );
            }
        }

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            final Point size = g.textExtent ( label );

            final int tx;
            if ( this.left )
            {
                tx = this.rect.x + this.textPadding;
            }
            else
            {
                tx = this.rect.x + this.textPadding + this.rect.width - size.x;
            }
            final int ty = this.rect.y + this.rect.height - this.rect.height / 2 + size.x / 2;
            g.drawText ( label, -ty, tx, -90.0f );
        }

        g.setClipping ( clientRectangle );
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        final int width = this.width >= 0 ? this.width : calcWidth ( clientRectangle.height );

        if ( this.left )
        {
            this.rect = new Rectangle ( clientRectangle.x, clientRectangle.y, width, clientRectangle.height );
            return new Rectangle ( clientRectangle.x + width, clientRectangle.y, clientRectangle.width - width, clientRectangle.height );
        }
        else
        {
            this.rect = new Rectangle ( clientRectangle.x + clientRectangle.width - width, clientRectangle.y, width, clientRectangle.height );
            return new Rectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width - width, clientRectangle.height );
        }
    }

    private int calcWidth ( final int height )
    {
        int maxTextWidth = 0;

        if ( this.axis == null || this.axis.getMax () - this.axis.getMin () <= 0 )
        {
            return 0;
        }

        final GC gc = new GC ( Display.getCurrent () );

        final Point axisLabelSize;
        try
        {
            if ( this.axis.getLabel () != null && !this.axis.getLabel ().isEmpty () )
            {
                axisLabelSize = gc.textExtent ( this.axis.getLabel () );
            }
            else
            {
                axisLabelSize = new Point ( 0, 0 );
            }

            if ( this.showLabels )
            {
                final int fontHeight = gc.getFontMetrics ().getHeight ();
                final List<Entry<Double>> markers = Helper.chartValues ( this.axis.getMin (), this.axis.getMax (), height, fontHeight + this.labelSpacing );

                for ( final Entry<Double> marker : markers )
                {
                    final Point sampleLabelSize = gc.textExtent ( marker.label );
                    maxTextWidth = Math.max ( maxTextWidth, sampleLabelSize.x );
                }
            }
        }
        finally
        {
            gc.dispose ();
        }

        return maxTextWidth + ( this.showLabels ? 2 * this.textPadding + this.markerSize : 0 ) + axisLabelSize.y + this.textPadding + 1;
    }

    @Override
    public void dispose ()
    {
        this.resourceManager.dispose ();
        super.dispose ();
    }
}
