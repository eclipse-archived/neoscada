/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
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

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.viewers.IViewerObservableSet;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

public class ChartInputSelector
{
    private final class ObservableMapLabelProviderExtension extends ObservableMapLabelProvider
    {
        private ObservableMapLabelProviderExtension ( final IObservableMap[] attributeMaps )
        {
            super ( attributeMaps );
        }

        @Override
        public Image getColumnImage ( final Object element, final int columnIndex )
        {
            if ( columnIndex != 0 )
            {
                return super.getColumnImage ( element, columnIndex );
            }
            if ( ! ( element instanceof ChartInput ) )
            {
                return super.getColumnImage ( element, columnIndex );
            }

            return ( (ChartInput)element ).getPreview ( 30, 15 );
        }
    }

    private final CheckboxTableViewer viewer;

    private final IObservableList inputs;

    private final IViewerObservableSet checked;

    private final ObservableListContentProvider contentProvider;

    private final IObservableMap visibleElements;

    public ChartInputSelector ( final Composite parent, final ChartViewer chart )
    {
        this ( parent, chart, false );
    }

    public ChartInputSelector ( final Composite parent, final ChartViewer chart, final boolean showHeader )
    {
        this.viewer = CheckboxTableViewer.newCheckList ( parent, SWT.FULL_SELECTION );
        this.viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        this.inputs = chart.getItems ();

        if ( showHeader )
        {
            final TableLayout layout = new TableLayout ();

            final TableViewerColumn col = new TableViewerColumn ( this.viewer, SWT.NONE );
            col.getColumn ().setText ( Messages.ChartInputSelector_Channels_Label );
            this.viewer.getTable ().setHeaderVisible ( true );

            layout.addColumnData ( new ColumnWeightData ( 100 ) );

            this.viewer.getTable ().setLayout ( layout );
        }

        this.contentProvider = new ObservableListContentProvider ();
        this.viewer.setContentProvider ( this.contentProvider );
        this.viewer.setLabelProvider ( new ObservableMapLabelProviderExtension ( Properties.observeEach ( this.contentProvider.getKnownElements (), new IValueProperty[] { BeanProperties.value ( ChartInput.PROP_LABEL ), BeanProperties.value ( ChartInput.PROP_PREVIEW ) } ) ) );
        this.viewer.setInput ( this.inputs );

        this.visibleElements = BeanProperties.value ( ChartInput.class, ChartInput.PROP_VISIBLE ).observeDetail ( this.contentProvider.getKnownElements () );
        this.checked = ViewersObservables.observeCheckedElements ( this.viewer, null );

        for ( final Object key : this.visibleElements.keySet () )
        {
            checkEntry ( key );
        }
        this.visibleElements.addMapChangeListener ( new IMapChangeListener () {

            @Override
            public void handleMapChange ( final MapChangeEvent event )
            {
                for ( final Object key : event.diff.getAddedKeys () )
                {
                    checkEntry ( key );
                }
                for ( final Object key : event.diff.getChangedKeys () )
                {
                    checkEntry ( key );
                }
            }

        } );

        this.checked.addSetChangeListener ( new ISetChangeListener () {

            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                for ( final Object o : event.diff.getRemovals () )
                {
                    ( (ChartInput)o ).setVisible ( false );
                }
                for ( final Object o : event.diff.getAdditions () )
                {
                    ( (ChartInput)o ).setVisible ( true );
                }
            }
        } );
    }

    private void checkEntry ( final Object key )
    {
        if ( ( (ChartInput)key ).isVisible () )
        {
            ChartInputSelector.this.checked.add ( key );
        }
        else
        {
            ChartInputSelector.this.checked.remove ( key );
        }
    }

    protected void handleDispose ()
    {
        this.visibleElements.dispose ();
        this.contentProvider.dispose ();

        this.checked.dispose ();
        this.inputs.dispose ();
    }

    public void dispose ()
    {
        this.viewer.getControl ().dispose ();
    }
}
