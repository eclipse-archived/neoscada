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
package org.eclipse.scada.ui.chart.selector;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.DataSeries;

public class ChartConfigurationInputSelector
{
    private final CheckboxTableViewer viewer;

    private final IObservableList inputs;

    private final IViewerObservableSet checked;

    public ChartConfigurationInputSelector ( final Composite parent, final Chart chart )
    {
        this ( parent, chart, false );
    }

    public ChartConfigurationInputSelector ( final Composite parent, final Chart chart, final boolean showHeader )
    {
        this.viewer = CheckboxTableViewer.newCheckList ( parent, SWT.FULL_SELECTION );
        this.viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        this.inputs = EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__INPUTS );

        if ( showHeader )
        {
            final TableLayout layout = new TableLayout ();

            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( Messages.ChartConfigurationInputSelector_Channels_Label );
            this.viewer.getTable ().setHeaderVisible ( true );

            layout.addColumnData ( new ColumnWeightData ( 100 ) );

            this.viewer.getTable ().setLayout ( layout );
        }

        ViewerSupport.bind ( this.viewer, this.inputs, EMFProperties.value ( ChartPackage.Literals.DATA_SERIES__LABEL ) );

        final IObservableSet elements = ( (ObservableListContentProvider)this.viewer.getContentProvider () ).getKnownElements ();
        final IObservableMap[] visibile = Properties.observeEach ( elements, new IValueProperty[] { EMFProperties.value ( ChartPackage.Literals.DATA_SERIES__VISIBLE ) } );

        this.checked = ViewersObservables.observeCheckedElements ( this.viewer, null );

        // initial set
        for ( final DataSeries series : chart.getInputs () )
        {
            if ( series.isVisible () )
            {
                this.checked.add ( series );
            }
        }

        this.checked.addSetChangeListener ( new ISetChangeListener () {

            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                for ( final Object o : event.diff.getAdditions () )
                {
                    ( (DataSeries)o ).setVisible ( true );
                }
                for ( final Object o : event.diff.getRemovals () )
                {
                    ( (DataSeries)o ).setVisible ( false );
                }
            }
        } );

        visibile[0].addMapChangeListener ( new IMapChangeListener () {

            @Override
            public void handleMapChange ( final MapChangeEvent event )
            {
                for ( final Object o : event.diff.getChangedKeys () )
                {
                    if ( (Boolean)event.diff.getNewValue ( o ) )
                    {
                        ChartConfigurationInputSelector.this.checked.add ( o );
                    }
                    else
                    {
                        ChartConfigurationInputSelector.this.checked.remove ( o );
                    }
                }
            }
        } );

    }

    protected void handleDispose ()
    {
        this.viewer.getLabelProvider ().dispose ();
        this.viewer.getContentProvider ().dispose ();

        this.checked.dispose ();
        this.inputs.dispose ();
    }

    public void dispose ()
    {
        this.viewer.getControl ().dispose ();
    }
}
