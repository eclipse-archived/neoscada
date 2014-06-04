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

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

/**
 * @author Jens Reimann
 * @see org.eclipse.swt.graphics.GC
 */
public interface Graphics
{
    public void setAlpha ( int alpha );

    public void setLineAttributes ( LineAttributes lineAttributes );

    public void drawLine ( int x1, int y1, int x2, int y2 );

    public void fillRectangle ( int x, int y, int width, int height );

    public void setForeground ( RGB color );

    public void setBackground ( RGB color );

    public void setClipping ( Rectangle rect );

    public void drawRectangle ( int x, int y, int width, int height );

    public void drawRectangle ( Rectangle rect );

    public Path createPath ();

    public void drawPath ( Path path );

    public void fillRectangle ( Rectangle rect );

    public void fillRoundRectangle ( int x, int y, int width, int height, int arcWidth, int arcHeight );

    public void drawRoundRectangle ( int x, int y, int width, int height, int arcWidth, int arcHeight );

    public void drawText ( String string, int x, int y, Float rotate );

    public Point textExtent ( String string );

    public void setAntialias ( boolean state );

    public void setFont ( Font font );

    public FontMetrics getFontMetrics ();

    public ResourceManager getResourceManager ();
}
