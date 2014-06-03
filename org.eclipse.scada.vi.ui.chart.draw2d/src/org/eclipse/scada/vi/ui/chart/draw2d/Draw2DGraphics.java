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

import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.resource.DeviceResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

public class Draw2DGraphics implements Graphics
{
    private final org.eclipse.draw2d.Graphics g;

    private final ResourceManager resourceManager;

    public Draw2DGraphics ( final org.eclipse.draw2d.Graphics g, final Device device )
    {
        this.g = g;
        this.resourceManager = new DeviceResourceManager ( device );
    }

    public void dispose ()
    {
        this.resourceManager.dispose ();
    }

    @Override
    public void setAlpha ( final int alpha )
    {
        this.g.setAlpha ( alpha );
    }

    @Override
    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.g.setLineAttributes ( lineAttributes );
    }

    @Override
    public void drawLine ( final int x1, final int y1, final int x2, final int y2 )
    {
        this.g.drawLine ( x1, y1, x2, y2 );
    }

    @Override
    public void fillRectangle ( final int x, final int y, final int width, final int height )
    {
        this.g.fillRectangle ( x, y, width, height );
    }

    @Override
    public void setForeground ( final RGB color )
    {
        this.g.setForegroundColor ( this.resourceManager.createColor ( color ) );
    }

    @Override
    public void setBackground ( final RGB color )
    {
        this.g.setBackgroundColor ( this.resourceManager.createColor ( color ) );
    }

    @Override
    public void setClipping ( final Rectangle rect )
    {
        this.g.setClip ( new org.eclipse.draw2d.geometry.Rectangle ( rect.x, rect.y, rect.width, rect.height ) );
    }

    @Override
    public void drawRectangle ( final int x, final int y, final int width, final int height )
    {
        this.g.drawRectangle ( x, y, width, height );
    }

    @Override
    public void drawRectangle ( final Rectangle rect )
    {
        this.g.drawRectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    @Override
    public Path createPath ()
    {
        return new Path ( Display.getCurrent () );
    }

    @Override
    public void drawPath ( final Path path )
    {
        this.g.drawPath ( path );
    }

    @Override
    public void fillRectangle ( final Rectangle rect )
    {
        this.g.fillRectangle ( rect.x, rect.y, rect.width, rect.height );
    }

    @Override
    public void drawText ( final String string, final int x, final int y, final Float rotate )
    {

        if ( rotate != null )
        {
            this.g.pushState ();
            this.g.rotate ( rotate );
        }

        this.g.drawText ( string, x, y );

        if ( rotate != null )
        {
            this.g.popState ();
        }
    }

    @Override
    public Point textExtent ( final String string )
    {
        final Dimension result = TextUtilities.INSTANCE.getTextExtents ( string, this.g.getFont () );
        return new Point ( result.width, result.height );
    }

    @Override
    public FontMetrics getFontMetrics ()
    {
        return this.g.getFontMetrics ();
    }

    @Override
    public void setAntialias ( final boolean state )
    {
        this.g.setAntialias ( state ? SWT.ON : SWT.OFF );
    }

    @Override
    public void setFont ( final Font font )
    {
        this.g.setFont ( font );
    }

    @Override
    public ResourceManager getResourceManager ()
    {
        return this.resourceManager;
    }
}
