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
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.render.AbstractLineRender;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public abstract class LineInput extends AbstractInput implements LinePropertiesSupporter
{

    private final LocalResourceManager resourceManager;

    private Color lineColor;

    private final Map<Point, Image> previews = new HashMap<Point, Image> ();

    public LineInput ( final ResourceManager resourceManager )
    {
        this.resourceManager = new LocalResourceManager ( resourceManager );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.resourceManager.dispose ();
        disposePreviews ();
    }

    protected abstract AbstractLineRender getLineRenderer ();

    @Override
    public void setVisible ( final boolean visible )
    {
        final AbstractLineRender renderer = getLineRenderer ();
        if ( renderer != null )
        {
            renderer.setVisible ( visible );
        }
        super.setVisible ( visible );
    }

    @Override
    public void setLineColor ( final RGB rgb )
    {
        if ( this.lineColor != null )
        {
            this.resourceManager.destroyColor ( this.lineColor.getRGB () );
            this.lineColor = null;
        }
        if ( rgb != null )
        {
            this.lineColor = this.resourceManager.createColor ( rgb );
            getLineRenderer ().setLineColor ( this.lineColor );
        }
        fireUpdatePreviews ();
    }

    @Override
    public RGB getLineColor ()
    {
        if ( this.lineColor == null )
        {
            return null;
        }
        if ( this.lineColor.isDisposed () )
        {
            return null;
        }
        return this.lineColor.getRGB ();
    }

    @Override
    public void setLineWidth ( final float width )
    {
        getLineRenderer ().setLineWidth ( width );
        fireUpdatePreviews ();
    }

    @Override
    public float getLineWidth ()
    {
        return getLineRenderer ().getLineWidth ();
    }

    @Override
    protected void fireUpdatePreviews ()
    {
        disposePreviews ();
        super.fireUpdatePreviews ();
    }

    private void disposePreviews ()
    {
        for ( final Image image : this.previews.values () )
        {
            image.dispose ();
        }
        this.previews.clear ();
    }

    @Override
    public Image getPreview ( final int width, final int height )
    {
        final Point p = new Point ( width, height );
        final Image img = this.previews.get ( p );
        if ( img == null )
        {
            final Image newImage = makePreview ( Display.getDefault (), getLineRenderer ().getLineAttributes (), getLineRenderer ().getLineColor (), p );
            this.previews.put ( p, newImage );
            return newImage;
        }
        return img;

    }

    public static Image makePreview ( final Display display, final LineAttributes lineAttributes, final Color lineColor, final Point p )
    {
        final Image img = new Image ( display, p.x, p.y );

        final GC gc = new GC ( img );
        try
        {
            gc.setForeground ( img.getDevice ().getSystemColor ( SWT.COLOR_WHITE ) );
            gc.setBackground ( img.getDevice ().getSystemColor ( SWT.COLOR_WHITE ) );
            gc.fillRectangle ( 0, 0, p.x, p.y );

            gc.setLineAttributes ( lineAttributes );

            if ( lineColor != null )
            {
                gc.setForeground ( lineColor );
            }

            gc.drawLine ( 0, p.y / 2, p.x, p.y / 2 );
        }
        finally
        {
            gc.dispose ();
        }

        return img;
    }
}
