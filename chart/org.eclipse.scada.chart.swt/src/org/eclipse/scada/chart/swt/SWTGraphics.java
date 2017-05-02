/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.chart.swt;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;

public class SWTGraphics implements Graphics
{
    private final GC gc;

    private final ResourceManager resourceManager;

    public SWTGraphics ( final GC gc, final ResourceManager resourceManager )
    {
        this.gc = gc;
        this.resourceManager = resourceManager;
    }

    public void dispose ()
    {
        // we only dispose what we created ourself
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
    public void setBackground ( final RGB color )
    {
        if ( color != null )
        {
            this.gc.setBackground ( (Color)this.resourceManager.get ( ColorDescriptor.createFrom ( color ) ) );
        }
        else
        {
            this.gc.setBackground ( this.gc.getDevice ().getSystemColor ( SWT.COLOR_WIDGET_BACKGROUND ) );
        }
    }

    @Override
    public void setForeground ( final RGB color )
    {
        if ( color != null )
        {
            this.gc.setForeground ( (Color)this.resourceManager.get ( ColorDescriptor.createFrom ( color ) ) );
        }
        else
        {
            this.gc.setForeground ( this.gc.getDevice ().getSystemColor ( SWT.COLOR_WIDGET_FOREGROUND ) );
        }
    }

    @Override
    public void setClipping ( final Rectangle rect )
    {
        this.gc.setClipping ( rect );
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

    @Override
    public void setFont ( final Font font )
    {
        this.gc.setFont ( font );
    }

    @Override
    public ResourceManager getResourceManager ()
    {
        return this.resourceManager;
    }

    @Override
    public void drawRoundRectangle ( final int x, final int y, final int width, final int height, final int arcWidth, final int arcHeight )
    {
        this.gc.drawRoundRectangle ( x, y, width, height, arcWidth, arcHeight );
    }

    @Override
    public void fillRoundRectangle ( final int x, final int y, final int width, final int height, final int arcWidth, final int arcHeight )
    {
        this.gc.fillRoundRectangle ( x, y, width, height, arcWidth, arcHeight );
    }

}
