/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.printing;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.Printer;

public class PrintProcessor
{

    private final List<ValueInformation> valueInformation;

    private final Map<String, List<Double>> values;

    public PrintProcessor ( final List<ValueInformation> vis, final Map<String, List<Double>> values )
    {
        this.valueInformation = vis;
        this.values = values;
    }

    public void print ( final Printer printer )
    {
        // generate min/max for X
        double maxX = Double.NEGATIVE_INFINITY;
        double minX = Double.POSITIVE_INFINITY;

        for ( final List<Double> vs : this.values.values () )
        {
            for ( final Double d : vs )
            {
                if ( d > maxX )
                {
                    maxX = d;
                }
                if ( d < minX )
                {
                    minX = d;
                }
            }
        }

        minX = 0;
        maxX = maxX * 1.5;

        // get min/max Y
        Calendar startTimestamp = null;
        Calendar endTimestamp = null;
        for ( final ValueInformation vi : this.valueInformation )
        {
            if ( startTimestamp == null || startTimestamp.after ( vi.getStartTimestamp () ) )
            {
                startTimestamp = Calendar.getInstance ();
                startTimestamp.setTimeInMillis ( vi.getStartTimestamp () );
            }
            if ( endTimestamp == null || endTimestamp.before ( vi.getEndTimestamp () ) )
            {
                endTimestamp = Calendar.getInstance ();
                endTimestamp.setTimeInMillis ( vi.getEndTimestamp () );
            }
        }

        GC gc = null;
        try
        {
            printer.startJob ( "Chart" );

            printer.startPage ();

            gc = new GC ( printer );

            drawChart ( printer, gc, minX, maxX, startTimestamp, endTimestamp );

            gc.dispose ();
            gc = null;

            printer.endPage ();

            printer.endJob ();
        }
        finally
        {
            if ( gc != null )
            {
                gc.dispose ();
            }
        }

    }

    private void drawChart ( final Device device, final GC gc, final double minX, final double maxX, final Calendar startTimestamp, final Calendar endTimestamp )
    {
        final Rectangle bounds = device.getBounds ();

        final Color color = new Color ( device, new RGB ( 0, 0, 0 ) );

        final Rectangle drawBounds = new Rectangle ( bounds.x + 10, bounds.y + 10, bounds.width - 20, bounds.height - 20 );
        gc.setForeground ( color );
        gc.drawRectangle ( drawBounds );

        for ( final Map.Entry<String, List<Double>> row : this.values.entrySet () )
        {
            drawRow ( device, gc, row.getKey (), row.getValue (), drawBounds, minX, maxX );
        }
    }

    private void drawRow ( final Device device, final GC gc, final String label, final List<Double> data, final Rectangle bounds, final double minX, final double maxX )
    {
        final Rectangle deviceBounds = device.getBounds ();

        gc.setLineWidth ( 1 );

        final int size = data.size ();

        final double diff = maxX - minX;

        Point lastPoint = null;
        for ( int i = 0; i < size; i++ )
        {
            // final Value v = data[i];
            final ValueInformation info = this.valueInformation.get ( i );

            if ( info.getQuality () > 0.75 )
            {
                final double posX = (double)bounds.width / (double)size * i;
                final double posY = data.get ( i ) / diff * bounds.height;

                final Point point = new Point ( (int)posX + bounds.x, (int)posY + bounds.y );

                if ( lastPoint != null )
                {
                    gc.drawLine ( lastPoint.x, deviceBounds.height - lastPoint.y, point.x, deviceBounds.height - lastPoint.y );
                    gc.drawLine ( point.x, deviceBounds.height - lastPoint.y, point.x, deviceBounds.height - point.y );
                }

                lastPoint = point;
            }
            else
            {
                lastPoint = null;
            }
        }
    }
}
