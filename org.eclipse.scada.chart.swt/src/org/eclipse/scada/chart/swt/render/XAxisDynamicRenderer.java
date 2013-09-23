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
package org.eclipse.scada.chart.swt.render;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import org.eclipse.swt.widgets.Display;

public class XAxisDynamicRenderer extends AbstractRenderer
{

    protected PropertyChangeListener propertyChangeListener;

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

        this.propertyChangeListener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };
    }

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        redraw ();
    }

    public void setAlign ( final int alignment )
    {
        this.bottom = ( alignment & SWT.TOP ) != SWT.TOP;
        redraw ();
    }

    public void setHeight ( final int height )
    {
        this.height = height;
        redraw ();
    }

    public void setFormat ( final String format )
    {
        this.format = format;
        redraw ();
    }

    public String getFormat ()
    {
        return this.format;
    }

    public void setShowLabels ( final boolean showLabels )
    {
        this.showLabels = showLabels;
        redraw ();
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
    }

    public int getTextPadding ()
    {
        return this.textPadding;
    }

    public void setStep ( final Long step )
    {
        this.step = step;
        redraw ();
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
            redraw ();
        }
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.rect.width == 0 || this.rect.height == 0 )
        {
            return;
        }

        g.setLineAttributes ( this.lineAttributes );

        final int y = this.bottom ? this.rect.y : this.rect.y + this.rect.height;

        final Rectangle chartRect = this.chart.getClientAreaProxy ().getClientRectangle ();

        // drawLabel

        {
            final String label = this.axis.getLabel ();
            if ( label != null )
            {
                final Point size = g.textExtent ( label );
                final int labelX = this.rect.x + this.rect.width / 2 - size.x / 2;
                g.drawText ( label, labelX, this.bottom ? this.rect.y + this.rect.height - ( size.y + this.textPadding ) : this.rect.y + this.textPadding, null );
            }
        }

        // draw line

        g.drawLine ( chartRect.x, y + ( this.bottom ? 0 : -1 ), chartRect.x + chartRect.width, y + ( this.bottom ? 0 : -1 ) );

        // draw markers

        final DateFormat format = makeFormat ( this.axis.getMax () - this.axis.getMin () );

        final Point sampleLabelSize = g.textExtent ( format.format ( new Date () ) );

        final List<Entry<Long>> markers = Helper.chartTimes ( this.axis.getMin (), this.axis.getMax (), chartRect.width, (int)Math.round ( 1.5 * sampleLabelSize.x ) + this.markerSpacing, format );
        for ( final Entry<Long> marker : markers )
        {
            final int x = chartRect.x + marker.position;
            g.drawText ( marker.label, x, this.bottom ? this.rect.y + this.markerSize + this.textPadding : this.rect.y + this.rect.height - ( sampleLabelSize.y + this.textPadding ), null );
            g.drawLine ( x, y, x, this.bottom ? y + this.markerSize : y - this.markerSize );
        }
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
        final GC gc = new GC ( Display.getCurrent () );
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
