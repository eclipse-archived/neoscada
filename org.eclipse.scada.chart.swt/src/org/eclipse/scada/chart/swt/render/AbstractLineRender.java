/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import org.eclipse.scada.chart.SeriesData;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.swt.graphics.LineAttributes;
import org.eclipse.swt.graphics.RGB;

public abstract class AbstractLineRender extends AbstractDataSeriesRenderer
{
    protected RGB lineColor;

    protected LineAttributes lineAttributes;

    public AbstractLineRender ( final ChartRenderer chart, final SeriesData abstractSeriesData )
    {
        super ( chart, abstractSeriesData );
        this.lineAttributes = new LineAttributes ( 1.0f );
    }

    public void setLineAttributes ( final LineAttributes lineAttributes )
    {
        this.lineAttributes = lineAttributes;
    }

    public void setLineWidth ( final float width )
    {
        this.lineAttributes.width = width;
    }

    public float getLineWidth ()
    {
        return this.lineAttributes.width;
    }

    public void setLineColor ( final RGB lineColor )
    {
        this.lineColor = lineColor;
    }

    public RGB getLineColor ()
    {
        return this.lineColor;
    }

    public LineAttributes getLineAttributes ()
    {
        return this.lineAttributes;
    }
}