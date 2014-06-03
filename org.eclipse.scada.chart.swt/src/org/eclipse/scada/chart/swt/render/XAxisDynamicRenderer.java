/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup property handling
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.Helper;
import org.eclipse.scada.chart.swt.Helper.Entry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class XAxisDynamicRenderer extends AbstractRenderer
{

    protected final LineAttributes lineAttributes;

    protected int labelSpacing;

    private XAxis axis;

    private boolean bottom = true;

    private Long step;

    private String format = "%tc";

    private int height = -1;

    private Rectangle rect;

    private final int markerSize = 5;

    private int textPadding = 5;

    private final ChartRenderer chart;

    private boolean showLabels;

    private final int markerSpacing = 0;

    public XAxisDynamicRenderer ( final ChartRenderer chart )
    {
        super ( chart );
        this.chart = chart;

        this.lineAttributes = new LineAttributes ( 1.0f, SWT.CAP_FLAT, SWT.JOIN_BEVEL, SWT.LINE_SOLID, new float[0], 0.0f, 0.0f );
        this.labelSpacing = 20;
    }

    public void setAlign ( final int alignment )
    {
        this.bottom = ( alignment & SWT.TOP ) != SWT.TOP;
        relayoutParent ();
    }

    public void setHeight ( final int height )
    {
        this.height = height;
        relayoutParent ();
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

    public int getHeight ()
    {
        return this.height;
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

    public void setStep ( final Long step )
    {
        this.step = step;
        relayoutParent ();
    }

    public Long getStep ()
    {
        return this.step;
    }

    @Override
    public void dispose ()
    {
        setAxis ( null );
        super.dispose ();
    }

    public void setAxis ( final XAxis axis )
    {
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
            // nothing to draw
            return;
        }

        g.setLineAttributes ( this.lineAttributes );
        g.setAntialias ( true );

        final int y = this.bottom ? this.rect.y : this.rect.y + this.rect.height;

        final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

        // drawLabel

        final String label = this.axis.getLabel ();
        if ( label != null )
        {
            final Point size = g.textExtent ( label );
            final int labelX = this.rect.x + this.rect.width / 2 - size.x / 2;
            g.drawText ( label, labelX, this.bottom ? this.rect.y + this.rect.height - ( size.y + this.textPadding ) : this.rect.y + this.textPadding, null );
        }

        // draw markers

        final List<Entry<Long>> markers;

        if ( this.showLabels )
        {
            final DateFormat format = makeFormat ( this.axis.getMax () - this.axis.getMin () );
            final Point sampleLabelSize = g.textExtent ( format.format ( new Date () ) );
            markers = Helper.chartTimes ( this.axis.getMin (), this.axis.getMax (), chartRect.width, (int)Math.round ( 1.5 * sampleLabelSize.x ) + this.markerSpacing, format );
            for ( final Entry<Long> marker : markers )
            {
                final int x = chartRect.x + marker.position;
                g.drawText ( marker.label, x, this.bottom ? this.rect.y + this.markerSize + this.textPadding : this.rect.y + this.rect.height - ( sampleLabelSize.y + this.textPadding ), null );
            }
        }
        else
        {
            markers = null;
        }

        // draw lines

        /*
         * Lines get draw without anti-aliasing since this causes some artifacts at the line ends
         */

        g.setAntialias ( false );

        // draw main line

        g.drawLine ( chartRect.x, y + ( this.bottom ? 0 : -1 ), chartRect.x + chartRect.width, y + ( this.bottom ? 0 : -1 ) );

        // draw marker ticks

        if ( this.showLabels )
        {
            for ( final Entry<Long> marker : markers )
            {
                final int x = chartRect.x + marker.position;
                g.drawLine ( x, y, x, this.bottom ? y + this.markerSize : y - this.markerSize );
            }
        }

        g.setAntialias ( true );
    }

    @Override
    public Rectangle resize ( final Rectangle clientRectangle )
    {
        final int height = this.height >= 0 ? this.height : calcHeight ();

        if ( this.bottom )
        {
            this.rect = new Rectangle ( clientRectangle.x, clientRectangle.y + clientRectangle.height - height, clientRectangle.width, height );
            return new Rectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width, clientRectangle.height - height );
        }
        else
        {
            this.rect = new Rectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width, height );
            return new Rectangle ( clientRectangle.x, clientRectangle.y + height, clientRectangle.width, clientRectangle.height - height );
        }
    }

    private DateFormat makeFormat ( final long timeRange )
    {
        if ( this.format != null && !this.format.isEmpty () )
        {
            try
            {
                return new SimpleDateFormat ( this.format );
            }
            catch ( final IllegalArgumentException e )
            {
                return DateFormat.getInstance ();
            }
        }
        else
        {
            return Helper.makeFormat ( timeRange );
        }
    }

    private int calcHeight ()
    {
        if ( this.axis == null )
        {
            return 0;
        }

        final GC gc = new GC ( this.display );
        try
        {
            final DateFormat format = makeFormat ( this.axis.getMax () - this.axis.getMin () );

            final Point markerSize = getExtent ( gc, format.format ( new Date () ) );
            final Point labelSize = getExtent ( gc, this.axis.getLabel () );

            int height = markerSize.y + labelSize.y + this.textPadding * 2 + this.markerSize;

            if ( labelSize.y > 0 )
            {
                height += this.textPadding;
            }

            return height;
        }
        finally
        {
            gc.dispose ();
        }
    }

    private Point getExtent ( final GC gc, final String string )
    {
        if ( string == null || string.isEmpty () )
        {
            return new Point ( 0, 0 );
        }
        else
        {
            return gc.textExtent ( string );
        }
    }
}
