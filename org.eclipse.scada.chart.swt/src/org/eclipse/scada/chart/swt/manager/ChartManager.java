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
package org.eclipse.scada.chart.swt.manager;

import org.eclipse.scada.chart.SeriesData;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartArea;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.Renderer;
import org.eclipse.scada.chart.swt.render.StepRenderer;
import org.eclipse.scada.chart.swt.render.XAxisDynamicRenderer;
import org.eclipse.scada.chart.swt.render.YAxisDynamicRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ChartManager extends Composite
{
    private final ChartArea chartArea;

    private final Label title;

    public ChartManager ( final Composite parent, final int style )
    {
        super ( parent, style );

        setLayout ( makeLayout () );

        // title row

        this.title = new Label ( this, SWT.NONE );
        this.title.setLayoutData ( new GridData ( GridData.CENTER, GridData.FILL, true, false, 1, 1 ) );

        // row 2

        this.chartArea = new ChartArea ( this, SWT.NONE );
        this.chartArea.setLayoutData ( makeMainLayoutData () );

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                onDispose ();
            }
        } );
    }

    private static GridLayout makeLayout ()
    {
        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        return layout;
    }

    private Object makeMainLayoutData ()
    {
        return new GridData ( SWT.FILL, SWT.FILL, true, true );
    }

    protected void onDispose ()
    {
    }

    public ChartArea getChartArea ()
    {
        return this.chartArea;
    }

    public ChartRenderer getChartRenderer ()
    {
        return this.chartArea.getChartRenderer ();
    }

    public void setChartBackground ( final Color color )
    {
        checkWidget ();

        this.chartArea.setBackground ( color );
    }

    public XAxisDynamicRenderer addDynamicXAxis ( final XAxis x, final boolean top )
    {
        checkWidget ();

        final XAxisDynamicRenderer renderer = new XAxisDynamicRenderer ( this.chartArea.getChartRenderer () );
        renderer.setAxis ( x );
        renderer.setAlign ( top ? SWT.TOP : SWT.BOTTOM );
        addRenderer ( renderer, -2 );
        return renderer;
    }

    public YAxisDynamicRenderer addDynamicYAxis ( final YAxis y, final boolean left )
    {
        checkWidget ();

        final YAxisDynamicRenderer renderer = new YAxisDynamicRenderer ( this.chartArea.getChartRenderer () );
        renderer.setAxis ( y );
        renderer.setAlign ( left ? SWT.LEFT : SWT.RIGHT );
        addRenderer ( renderer, -1 );
        return renderer;
    }

    public StepRenderer createStepSeries ( final SeriesData abstractSeriesData )
    {
        checkWidget ();

        final StepRenderer renderer = new StepRenderer ( this.chartArea.getChartRenderer (), abstractSeriesData );
        addRenderer ( renderer, 0 );
        return renderer;
    }

    public void setTitle ( final String title )
    {
        checkWidget ();

        this.title.setText ( title );
        this.title.pack ();
        layout ();
    }

    public String getTitle ()
    {
        checkWidget ();

        return this.title.getText ();
    }

    public DropTarget createDropTarget ( final Transfer[] transfers, final DropTargetListener dropTargetListener )
    {
        checkWidget ();

        final DropTarget target = new DropTarget ( this.chartArea, DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_LINK );
        target.setTransfer ( transfers );
        target.addDropListener ( dropTargetListener );
        return target;
    }

    public void addRenderer ( final Renderer renderer, final int order )
    {
        checkWidget ();

        this.chartArea.getChartRenderer ().addRenderer ( renderer, order );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        checkWidget ();

        this.chartArea.getChartRenderer ().removeRenderer ( renderer );
    }

}
