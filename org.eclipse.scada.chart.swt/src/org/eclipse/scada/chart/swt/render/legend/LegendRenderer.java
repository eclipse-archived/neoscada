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
package org.eclipse.scada.chart.swt.render.legend;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.Graphics;
import org.eclipse.scada.chart.swt.render.Renderer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public class LegendRenderer implements Renderer
{
    public static final String PROP_TIMETSAMP_FORMAT = "timestampFormat";

    private static final Point EMPTY_POINT = new Point ( 0, 0 );

    private final IObservableList infos;

    private IListChangeListener listener;

    private final int textPadding = 5;

    private final int padding = 10;

    private final int margin = 10;

    private class Entry implements Comparable<Entry>, IValueChangeListener
    {
        private final int index;

        private final SeriesInformation information;

        private final Set<IObservableValue> values = new HashSet<> ();

        public Entry ( final int index, final SeriesInformation information )
        {
            this.index = index;
            this.information = information;

            // must use BeansObversvables to actually receive changes
            addListener ( BeansObservables.observeValue ( information, SeriesInformation.PROP_LABEL ) );
            addListener ( BeansObservables.observeValue ( information, SeriesInformation.PROP_SELECTED_QUALITY ) );
            addListener ( BeansObservables.observeValue ( information, SeriesInformation.PROP_SELECTED_VALUE ) );
            addListener ( BeansObservables.observeValue ( information, SeriesInformation.PROP_SELECTED_TIMESTAMP ) );

        }

        private void addListener ( final IObservableValue value )
        {
            this.values.add ( value );
            value.addValueChangeListener ( Entry.this );
        }

        public void dispose ()
        {
            for ( final IObservableValue v : this.values )
            {
                v.removeValueChangeListener ( Entry.this );
            }
        }

        @Override
        public int compareTo ( final Entry o )
        {
            return Integer.compare ( this.index, o.index );
        }

        public SeriesInformation getInformation ()
        {
            return this.information;
        }

        @Override
        public void handleValueChange ( final ValueChangeEvent event )
        {
            LegendRenderer.this.renderer.redraw ();
        }
    }

    public static int max ( final int firstValue, final int... values )
    {
        int v = firstValue;
        for ( final int nv : values )
        {
            if ( nv > v )
            {
                v = nv;
            }
        }

        return v;
    }

    private static class Data
    {
        RGB color;

        String name;

        String value;

        String timestamp;

        String quality;

        Point nameSize;

        Point valueSize;

        Point timestampSize;

        Point qualitySize;

        int getHeight ()
        {
            return max ( this.nameSize.y, this.valueSize.y, this.timestampSize.y, this.qualitySize.y );
        }
    }

    private static class DataSet
    {
        List<Data> allData;

        int height;

        int maxNameSize;

        int maxValueSize;

        int maxTimestampSize;

        int maxQualitySize;

        int width;
    }

    private final List<Entry> entries = new ArrayList<> ();

    private final ChartRenderer renderer;

    private String timestampFormat;

    private DateFormat timestampFormatImpl;

    private final NumberFormat qualityFormatImpl = NumberFormat.getPercentInstance ();

    private final NumberFormat valueFormatImpl = NumberFormat.getNumberInstance ();

    private final int previewSize = 15;

    public LegendRenderer ( final ChartRenderer renderer, final IObservableList/*SeriesInformation*/informations )
    {
        this.renderer = renderer;
        this.infos = informations;

        setTimestampFormat ( null );

        this.infos.addListChangeListener ( this.listener = new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                LegendRenderer.this.processListChange ( event.diff );
            }
        } );

        // add initial entries

        int i = 0;
        for ( final Object o : this.infos )
        {
            addEntry ( i, o );
            i++;
        }
    }

    public void setTimestampFormat ( final String timestampFormat )
    {
        this.timestampFormat = timestampFormat;
        if ( timestampFormat == null )
        {
            this.timestampFormatImpl = DateFormat.getDateTimeInstance ();
        }
        else
        {
            try
            {
                this.timestampFormatImpl = new SimpleDateFormat ( timestampFormat );
            }
            catch ( final Exception e )
            {
                this.timestampFormatImpl = DateFormat.getDateTimeInstance ();
            }
        }
        this.renderer.redraw ();
    }

    public String getTimestampFormat ()
    {
        return this.timestampFormat;
    }

    protected void processListChange ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @Override
            public void handleRemove ( final int index, final Object element )
            {
                final Iterator<Entry> i = LegendRenderer.this.entries.iterator ();
                while ( i.hasNext () )
                {
                    final Entry next = i.next ();
                    if ( next == element )
                    {
                        i.remove ();
                        next.dispose ();
                    }
                }
            }

            @Override
            public void handleAdd ( final int index, final Object element )
            {
                addEntry ( index, element );
            }

        } );
        this.renderer.redraw ();
    }

    public void dispose ()
    {
        this.infos.removeListChangeListener ( this.listener );
    }

    protected void addEntry ( final int index, final Object element )
    {
        this.entries.add ( new Entry ( index, (SeriesInformation)element ) );
    }

    @Override
    public void render ( final Graphics g, final Rectangle clientRectangle )
    {
        final Rectangle chartRect = this.renderer.getClientAreaProxy ().getClientRectangle ();

        final DataSet data = makeAllData ( g );

        renderData ( g, chartRect, data );
    }

    private void renderData ( final Graphics g, final Rectangle chartRect, final DataSet data )
    {
        int y = chartRect.y + this.margin;
        int x = chartRect.x + this.margin;

        g.setAntialias ( true );
        g.setForeground ( new RGB ( 180, 180, 180 ) );
        g.setBackground ( new RGB ( 240, 240, 240 ) );

        // draw the frame
        g.fillRoundRectangle ( x, y, data.width + this.padding * 2, data.height + this.padding * 2, 10, 10 );
        g.drawRoundRectangle ( x, y, data.width + this.padding * 2, data.height + this.padding * 2, 10, 10 );

        x += this.padding;
        y += this.padding;

        g.setForeground ( new RGB ( 0, 0, 0 ) );

        for ( final Data d : data.allData )
        {
            renderDataEntry ( g, data, d, x, y );
            y += Math.max ( d.getHeight (), this.previewSize ) + this.textPadding;
        }
    }

    /**
     * Render the actual data entry
     */
    private void renderDataEntry ( final Graphics g, final DataSet data, final Data d, int x, final int y )
    {
        g.setBackground ( d.color );
        g.fillRectangle ( x, y, this.previewSize, this.previewSize );
        g.drawRectangle ( x, y, this.previewSize, this.previewSize );

        x += this.previewSize + this.textPadding;

        if ( d.name != null )
        {
            g.drawText ( d.name, x, y, null );
            x += data.maxNameSize + this.textPadding;
        }

        if ( d.value != null )
        {
            // right align values
            final int off = data.maxValueSize - d.valueSize.x;
            g.drawText ( d.value, x + off, y, null );
            x += data.maxValueSize + this.textPadding;
        }

        if ( d.timestamp != null )
        {
            g.drawText ( d.timestamp, x, y, null );
            x += data.maxTimestampSize + this.textPadding;
        }

        if ( d.quality != null )
        {
            g.drawText ( d.quality, x, y, null );
            x += data.maxQualitySize + this.textPadding;
        }
    }

    protected DataSet makeAllData ( final Graphics g )
    {
        final DataSet result = new DataSet ();
        result.allData = new ArrayList<> ( this.entries.size () );

        for ( final Entry entry : this.entries )
        {
            final SeriesInformation info = entry.getInformation ();
            if ( !info.isVisible () )
            {
                continue;
            }

            final Data data = makeData ( info, g );

            result.height += Math.max ( data.getHeight (), this.previewSize );

            result.maxNameSize = Math.max ( result.maxNameSize, data.nameSize.x );
            result.maxValueSize = Math.max ( result.maxValueSize, data.valueSize.x );
            result.maxTimestampSize = Math.max ( result.maxTimestampSize, data.timestampSize.x );
            result.maxQualitySize = Math.max ( result.maxQualitySize, data.qualitySize.x );

            result.allData.add ( data );
        }

        final int len = result.allData.size ();

        if ( len > 1 )
        {
            result.height += ( len - 1 ) * this.textPadding;
        }

        result.width = this.previewSize + result.maxNameSize + result.maxQualitySize + result.maxTimestampSize + result.maxValueSize + this.textPadding * 4;

        return result;
    }

    protected Data makeData ( final SeriesInformation info, final Graphics g )
    {
        final Data data = new Data ();

        data.color = info.getColor ();
        data.name = info.getLabel ();
        data.value = makeValue ( info );
        data.timestamp = makeTimestamp ( info );
        data.quality = makeQuality ( info );

        data.nameSize = makeSize ( g, data.name );
        data.valueSize = makeSize ( g, data.value );
        data.timestampSize = makeSize ( g, data.timestamp );
        data.qualitySize = makeSize ( g, data.quality );

        return data;
    }

    private Point makeSize ( final Graphics g, final String string )
    {
        if ( string == null )
        {
            return EMPTY_POINT;
        }
        else
        {
            return g.textExtent ( string );
        }
    }

    private String makeTimestamp ( final SeriesInformation info )
    {
        final Calendar timestamp = info.getSelectedTimestamp ();
        if ( timestamp != null )
        {
            this.timestampFormatImpl.setCalendar ( timestamp );
            return this.timestampFormatImpl.format ( timestamp.getTime () );
        }
        else
        {
            return null;
        }
    }

    private String makeValue ( final SeriesInformation info )
    {
        final Double value = info.getSelectedValue ();
        if ( value == null )
        {
            return null;
        }
        return this.valueFormatImpl.format ( value );
    }

    private String makeQuality ( final SeriesInformation info )
    {
        final Double quality = info.getSelectedQuality ();
        if ( quality != null )
        {
            return this.qualityFormatImpl.format ( quality );
        }
        else
        {
            return null;
        }
    }

    @Override
    public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
    {
        // we don't consume space
        return null;
    }

}
