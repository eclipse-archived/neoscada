/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class TitleRenderer extends AbstractRenderer
{
    private final Map<Device, Font> fontCache = new HashMap<> ();

    private String title;

    private int padding = 10;

    private Rectangle rect;

    private int fontSize = -1;

    public TitleRenderer ( final ChartRenderer chart )
    {
        super ( chart );
    }

    @Override
    public void dispose ()
    {
        for ( final Font font : this.fontCache.values () )
        {
            font.dispose ();
        }
        this.fontCache.clear ();

        super.dispose ();
    }

    public void setTitle ( final String title )
    {
        this.title = title;
        relayoutParent ();
    }

    public String getTitle ()
    {
        return this.title;
    }

    public void setFontSize ( final int fontSize )
    {
        this.fontSize = fontSize;
        relayoutParent ();
    }

    public int getFontSize ()
    {
        return this.fontSize;
    }

    public void setPadding ( final int padding )
    {
        this.padding = padding;
        relayoutParent ();
    }

    public int getPadding ()
    {
        return this.padding;
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        if ( this.title == null || this.title.isEmpty () )
        {
            return;
        }

        g.setClipping ( this.rect );

        g.setFont ( createFont ( g.getResourceManager () ) );

        final Point size = g.textExtent ( this.title );

        final int x = this.rect.width / 2 - size.x / 2;
        final int y = this.padding;
        g.drawText ( this.title, this.rect.x + x, this.rect.y + y, null );

        g.setClipping ( clientRectangle );
    }

    @Override
    public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
    {
        if ( this.title == null || this.title.isEmpty () )
        {
            return null;
        }

        final GC gc = new GC ( resourceManager.getDevice () );
        gc.setFont ( createFont ( resourceManager ) );

        try
        {
            final Point size = gc.textExtent ( this.title );
            this.rect = new Rectangle ( clientRectangle.x, clientRectangle.y, clientRectangle.width, size.y + this.padding * 2 );
            return new Rectangle ( clientRectangle.x, this.rect.y + this.rect.height, clientRectangle.width, clientRectangle.height - this.rect.height );
        }
        finally
        {
            gc.dispose ();
        }
    }

    private Font createFont ( final ResourceManager resourceManager )
    {
        final Font defaultFont = resourceManager.getDevice ().getSystemFont ();

        if ( defaultFont == null )
        {
            return null;
        }

        final FontData fd[] = FontDescriptor.copy ( defaultFont.getFontData () );
        if ( fd == null )
        {
            return null;
        }

        for ( final FontData f : fd )
        {
            if ( this.fontSize > 0 )
            {
                f.setHeight ( this.fontSize );
            }
        }
        return resourceManager.createFont ( FontDescriptor.createFrom ( fd ) );
    }
}
