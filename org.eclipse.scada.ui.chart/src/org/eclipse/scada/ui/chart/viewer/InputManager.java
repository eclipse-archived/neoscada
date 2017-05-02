/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.DataSeries;
import org.eclipse.scada.ui.chart.model.ScriptSeries;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public class InputManager
{

    private final WritableList list;

    protected final DataBindingContext dbc;

    private IListChangeListener listener;

    private final Map<DataSeries, InputViewer> inputMap = new HashMap<DataSeries, InputViewer> ();

    private final ChartViewer viewer;

    private final AxisLocator<XAxis, XAxisViewer> xLocator;

    private final AxisLocator<YAxis, YAxisViewer> yLocator;

    private final ResourceManager resourceManager;

    public InputManager ( final DataBindingContext dbc, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        this.list = new WritableList ( dbc.getValidationRealm () );

        this.dbc = dbc;
        this.viewer = viewer;
        this.resourceManager = resourceManager;

        this.xLocator = xLocator;
        this.yLocator = yLocator;

        this.list.addListChangeListener ( this.listener = new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                handleListeChange ( event.diff );
            }
        } );
    }

    protected void handleListeChange ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @Override
            public void handleRemove ( final int index, final Object element )
            {
                InputManager.this.handleRemove ( (DataSeries)element );
            }

            @Override
            public void handleAdd ( final int index, final Object element )
            {
                InputManager.this.handleAdd ( (DataSeries)element );
            }
        } );
    }

    protected void handleAdd ( final DataSeries element )
    {
        if ( element instanceof DataItemSeries )
        {
            addInput ( element, new DataItemSeriesViewer ( this.dbc, (DataItemSeries)element, this.viewer, this.resourceManager, this.xLocator, this.yLocator ) );
        }
        else if ( element instanceof ArchiveSeries )
        {
            addInput ( element, new ArchiveSeriesViewer ( this.dbc, (ArchiveSeries)element, this.viewer, this.resourceManager, this.xLocator, this.yLocator ) );
        }
        else if ( element instanceof ScriptSeries )
        {
            addInput ( element, new ScriptSeriesViewer ( this.dbc, (ScriptSeries)element, this.viewer, this.resourceManager, this.xLocator, this.yLocator ) );
        }
        else if ( element instanceof CompositeArchiveQualitySeries )
        {
            addInput ( element, new CompositeArchiveQualityViewer ( this.dbc, (CompositeArchiveQualitySeries)element, this.viewer, this.resourceManager, this.xLocator, this.yLocator ) );
        }
    }

    protected void addInput ( final DataSeries element, final InputViewer viewer )
    {
        final InputViewer oldItem = this.inputMap.put ( element, viewer );
        if ( oldItem != null )
        {
            oldItem.dispose ();
        }
    }

    protected void handleRemove ( final DataSeries element )
    {
        final InputViewer value = this.inputMap.remove ( element );

        if ( value != null )
        {
            value.dispose ();
        }
    }

    public void dispose ()
    {
        this.list.removeListChangeListener ( this.listener );

        for ( final InputViewer input : this.inputMap.values () )
        {
            input.dispose ();
        }
        this.inputMap.clear ();
    }

    public WritableList getList ()
    {
        return this.list;
    }

}