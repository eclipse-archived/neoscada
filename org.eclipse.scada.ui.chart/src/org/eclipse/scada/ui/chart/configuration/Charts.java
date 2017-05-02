/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - add more methods
 *******************************************************************************/
package org.eclipse.scada.ui.chart.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.ItemDataSeries;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.swt.graphics.RGB;

public class Charts
{

    public static Chart makeDefaultConfiguration ()
    {
        final Chart configuration = ChartFactory.eINSTANCE.createChart ();

        final YAxis y = ChartFactory.eINSTANCE.createYAxis ();
        y.setLabel ( Messages.Charts_Label_Values );
        configuration.getLeft ().add ( y );

        final XAxis x = ChartFactory.eINSTANCE.createXAxis ();
        x.setLabel ( Messages.Charts_Label_Time );
        x.setMinimum ( System.currentTimeMillis () );
        x.setMaximum ( System.currentTimeMillis () + 900 * 1000 );
        configuration.getBottom ().add ( x );

        configuration.getSelectedXAxis ().add ( x );
        configuration.getSelectedYAxis ().add ( y );
        configuration.setTimeRulerAxis ( x );

        configuration.getControllers ().add ( ChartFactory.eINSTANCE.createMouseController () );

        return configuration;
    }

    private static RGB[] DEFAULT_COLORS = new RGB[] { //
    new RGB ( 255, 0, 0 ), // red
    new RGB ( 0, 255, 0 ), // green
    new RGB ( 0, 255, 255 ), // blue
    new RGB ( 255, 194, 0 ), // yellow
    new RGB ( 255, 0, 255 ), // magenta
    new RGB ( 0, 255, 255 ), // cyan
    };

    public static RGB nextFreeColor ( final Chart configuration )
    {
        return DEFAULT_COLORS[configuration.getInputs ().size () % DEFAULT_COLORS.length];
    }

    public static void addItem ( final Chart chart, final org.eclipse.scada.hd.ui.connection.data.Item item )
    {
        final XAxis x = chart.getTimeRulerAxis ();
        if ( x == null )
        {
            return;
        }

        YAxis y;
        try
        {
            y = chart.getSelectedYAxis ().get ( 0 );
        }
        catch ( final IndexOutOfBoundsException e )
        {
            return;
        }

        org.eclipse.scada.ui.chart.model.Item itemRef = null;

        switch ( item.getType () )
        {
            case ID:
            {
                itemRef = ChartFactory.eINSTANCE.createIdItem ();
                itemRef.setItemId ( item.getId () );
                ( (IdItem)itemRef ).setConnectionId ( item.getConnectionString () );
                break;
            }
            case URI:
            {
                itemRef = ChartFactory.eINSTANCE.createUriItem ();
                itemRef.setItemId ( item.getId () );
                ( (UriItem)itemRef ).setConnectionUri ( item.getConnectionString () );
                break;
            }
        }

        if ( itemRef == null )
        {
            return;
        }

        final ArchiveSeries input = ChartFactory.eINSTANCE.createArchiveSeries ();
        input.setLabel ( item.toLabel () );
        input.setItem ( itemRef );
        input.setX ( x );
        input.setY ( y );
        input.getLineProperties ().setColor ( Charts.nextFreeColor ( chart ) );

        addInput ( chart, input );
    }

    public static void addItem ( final Chart chart, final Item item )
    {
        final XAxis x = chart.getTimeRulerAxis ();
        if ( x == null )
        {
            return;
        }

        YAxis y;
        try
        {
            y = chart.getSelectedYAxis ().get ( 0 );
        }
        catch ( final IndexOutOfBoundsException e )
        {
            return;
        }

        org.eclipse.scada.ui.chart.model.Item itemRef = null;

        switch ( item.getType () )
        {
            case ID:
            {
                itemRef = ChartFactory.eINSTANCE.createIdItem ();
                ( (IdItem)itemRef ).setConnectionId ( item.getId () );
                itemRef.setItemId ( item.getId () );
                break;
            }
            case URI:
            {
                itemRef = ChartFactory.eINSTANCE.createUriItem ();
                ( (UriItem)itemRef ).setConnectionUri ( item.getConnectionString () );
                itemRef.setItemId ( item.getId () );
                break;
            }
        }

        if ( itemRef == null )
        {
            return;
        }

        final DataItemSeries input = ChartFactory.eINSTANCE.createDataItemSeries ();
        input.setLabel ( item.toLabel () );
        input.setItem ( itemRef );
        input.setX ( x );
        input.setY ( y );
        input.getLineProperties ().setColor ( Charts.nextFreeColor ( chart ) );

        addInput ( chart, input );
    }

    private static void addInput ( final Chart chart, final ItemDataSeries input )
    {
        chart.getInputs ().add ( input );
    }

    public static void addCompositeQuality ( final Chart configuration )
    {
        final EList<XAxis> x = configuration.getSelectedXAxis ();
        final EList<YAxis> y = configuration.getSelectedYAxis ();

        if ( x.isEmpty () )
        {
            return;
        }

        if ( y.isEmpty () )
        {
            return;
        }

        final CompositeArchiveQualitySeries q = ChartFactory.eINSTANCE.createCompositeArchiveQualitySeries ();
        q.setX ( x.get ( 0 ) );
        q.setY ( y.get ( 0 ) );
        q.setVisible ( true );
        q.setThreshold ( 0.75 );

        configuration.getInputs ().add ( q );
    }

}
