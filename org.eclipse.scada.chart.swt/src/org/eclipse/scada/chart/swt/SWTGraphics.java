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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

public class SWTGraphics implements Graphics
{

    private final GC gc;

    public SWTGraphics ( final GC gc )
    {
        this.gc = gc;
    }

    @Override
    public void setAlpha ( final int alpha )
    {
        this.gc.setAlpha ( alpha );
    }

    @Override
    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.gc.setLineAttributes ( lineAttributes );
    }

    @Override
    public void drawLine ( final int x1, final int y1, final int x2, final int y2 )
    {
        this.gc.drawLine ( x1, y1, x2, y2 );
    }

    @Override
    public void fillRectangle ( final int x, final int y, final int width, final int height )
    {
        this.gc.fillRectangle ( x, y, width, height );
    }

    @Override
    public void setBackground ( final Color color )
    {
        this.gc.setBackground ( color );
    }

    @Override
    public void setClipping ( final Rectangle rect )
    {
        this.gc.setClipping ( rect );
    }

    @Override
    public void setForeground ( final Color color )
    {
        this.gc.setForeground ( color );
    }

    @Override
    public Color getSystemColor ( final int color )
    {
        return this.gc.getDevice ().getSystemColor ( color );
    }

    @Override
    public void drawRectangle ( final int x, final int y, final int width, final int height )
    {
        this.gc.drawRectangle ( x, y, width, height );
    }

    @Override
    public void drawRectangle ( final Rectangle rect )
    {
        this.gc.drawRectangle ( rect );
    }

    @Override
    public Path createPath ()
    {
        return new Path ( this.gc.getDevice () );
    }

    @Override
    public void drawPath ( final Path path )
    {
        this.gc.drawPath ( path );
    }

    @Override
    public void fillRectangle ( final Rectangle rect )
    {
        this.gc.fillRectangle ( rect );
    }

    @Override
    public void drawText ( final String string, final int x, final int y, final Float rotate )
    {
        final Transform t;

        if ( rotate != null )
        {
            t = new Transform ( this.gc.getDevice () );
            t.rotate ( rotate );
            this.gc.setTransform ( t );
        }
        else
        {
            t = null;
        }

        this.gc.drawText ( string, x, y, SWT.DRAW_DELIMITER | SWT.DRAW_TAB | SWT.DRAW_TRANSPARENT );

        if ( t != null )
        {
            this.gc.setTransform ( null );
            t.dispose ();
        }
    }

    @Override
    public Point textExtent ( final String string )
    {
        return this.gc.textExtent ( string );
    }

    @Override
    public void setAntialias ( final boolean state )
    {
        this.gc.setAntialias ( state ? SWT.ON : SWT.OFF );
    }

    @Override
    public FontMetrics getFontMetrics ()
    {
        return this.gc.getFontMetrics ();
    }
}
