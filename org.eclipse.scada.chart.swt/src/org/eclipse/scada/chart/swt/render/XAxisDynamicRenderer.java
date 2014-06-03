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

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.Helper;
import org.eclipse.scada.chart.swt.Helper.Entry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class XAxisDynamicRenderer extends AbstractRenderer
{

    private static final Point EMPTY_POINT = new Point ( 0, 0 );

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

    private RGB color;

    private DateFormat formatInstance;

    public XAxisDynamicRenderer ( final ChartRenderer chart )
    {
        super ( chart );
        this.chart = chart;

        this.lineAttributes = new LineAttributes ( 1.0f, SWT.CAP_FLAT, SWT.JOIN_BEVEL, SWT.LINE_SOLID, new float[0], 0.0f, 0.0f );
        this.labelSpacing = 20;
    }

    public void setColor ( final RGB color )
    {
        this.color = color;
        redraw ();
    }

    public RGB getColor ()
    {
        return this.color;
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
        this.formatInstance = null;
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
        g.setForeground ( this.color );
        g.setAntialias ( true );

        final int y = this.bottom ? this.rect.y : this.rect.y + this.rect.height;

        // fetch the actual chart area
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
                if ( marker.position < 0 )
                {
                    continue;
                }
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
                if ( marker.position < 0 )
                {
                    continue;
                }
                final int x = chartRect.x + marker.position;
                g.drawLine ( x, y, x, this.bottom ? y + this.markerSize : y - this.markerSize );
            }
        }

        g.setAntialias ( true );
    }

    @Override
    public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
    {
        final int height = this.height >= 0 ? this.height : calcHeight ( resourceManager );

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
        if ( this.formatInstance != null || !hasFormat () )
        {
            return this.formatInstance;
        }

        this.formatInstance = createFormatInstance ( timeRange );

        return this.formatInstance;
    }

    protected DateFormat createFormatInstance ( final long timeRange )
    {
        if ( hasFormat () )
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

    protected boolean hasFormat ()
    {
        return this.format != null && !this.format.isEmpty ();
    }

    private int calcHeight ( final ResourceManager resourceManager )
    {
        if ( this.axis == null )
        {
            return 0;
        }

        final GC gc = new GC ( resourceManager.getDevice () );
        try
        {
            gc.setFont ( makeFont ( resourceManager ) );

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

    private Font makeFont ( final ResourceManager resourceManager )
    {
        return null;
    }

    private Point getExtent ( final GC gc, final String string )
    {
        if ( string == null || string.isEmpty () )
        {
            return EMPTY_POINT;
        }
        else
        {
            return gc.textExtent ( string );
        }
    }
}
