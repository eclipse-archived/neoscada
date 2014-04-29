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
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.hd.ui.connection.data.Item.Type;
import org.eclipse.scada.ui.chart.viewer.input.ArchiveInput;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.viewer.input.QuerySeriesData;
import org.eclipse.scada.ui.chart.model.ArchiveChannel;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.Item;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public class ArchiveSeriesViewer extends AbstractItemInputViewer
{
    public static final String PROP_INPUT = "input"; //$NON-NLS-1$

    public static final String PROP_QUERY_SERIES_DATA = "querySeriesData"; //$NON-NLS-1$

    private final WritableList channels = new WritableList ();

    private final Map<ArchiveChannel, ArchiveChannelViewer> viewerMap = new HashMap<ArchiveChannel, ArchiveChannelViewer> ();

    private final DataBindingContext dbc;

    private QuerySeriesData querySeriesData;

    private final IObservableValue inputObservable;

    private final IObservableValue linePropertiesObservable;

    private ArchiveInput input;

    public ArchiveSeriesViewer ( final DataBindingContext dbc, final ArchiveSeries element, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        super ( dbc, element, viewer, resourceManager, xLocator, yLocator );

        this.dbc = dbc;

        this.channels.addListChangeListener ( new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                event.diff.accept ( new ListDiffVisitor () {

                    @Override
                    public void handleRemove ( final int index, final Object element )
                    {
                        handleRemoveChannel ( (ArchiveChannel)element );
                    }

                    @Override
                    public void handleAdd ( final int index, final Object element )
                    {
                        handleAddChannel ( (ArchiveChannel)element );
                    }
                } );
            }
        } );
        addBinding ( dbc.bindList ( this.channels, EMFObservables.observeList ( element, ChartPackage.Literals.ARCHIVE_SERIES__CHANNELS ) ) );

        this.inputObservable = BeansObservables.observeValue ( this, PROP_INPUT );
        this.linePropertiesObservable = EMFObservables.observeValue ( element, ChartPackage.Literals.ARCHIVE_SERIES__LINE_PROPERTIES );

        addBindings ( LinePropertiesBinder.bind ( SWTObservables.getRealm ( viewer.getChartRenderer ().getDisplay () ), dbc, this.inputObservable, this.linePropertiesObservable ) );

        setInputObserable ( this.inputObservable );
    }

    protected void handleAddChannel ( final ArchiveChannel channel )
    {
        final ArchiveChannelViewer viewer = new ArchiveChannelViewer ( this.dbc, channel, this.viewer, this.resourceManager, this );
        final ArchiveChannelViewer oldViewer = this.viewerMap.put ( channel, viewer );
        if ( oldViewer != null )
        {
            oldViewer.dispose ();
        }
    }

    protected void handleRemoveChannel ( final ArchiveChannel channel )
    {
        final ArchiveChannelViewer viewer = this.viewerMap.remove ( channel );
        if ( viewer != null )
        {
            viewer.dispose ();
        }
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        this.inputObservable.dispose ();
        this.linePropertiesObservable.dispose ();

        this.channels.dispose ();
    }

    @Override
    protected void checkCreateInput ()
    {
        if ( this.item != null && this.xAxis != null && this.yAxis != null )
        {
            final org.eclipse.scada.hd.ui.connection.data.Item item = makeItem ( this.item );

            if ( item == null )
            {
                return;
            }

            setQuerySeriesData ( new QuerySeriesData ( item, this.viewer.getRealm (), this.xAxis.getAxis (), this.yAxis.getAxis () ) );
            final ArchiveInput input = new ArchiveInput ( item, this.viewer, this.querySeriesData, this.resourceManager );
            this.viewer.addInput ( input );
            setInput ( input );
        }
    }

    private void setInput ( final ArchiveInput input )
    {
        firePropertyChange ( PROP_INPUT, this.input, this.input = input );
    }

    public ArchiveInput getInput ()
    {
        return this.input;
    }

    private org.eclipse.scada.hd.ui.connection.data.Item makeItem ( final Item item )
    {
        if ( item instanceof IdItem )
        {
            return new org.eclipse.scada.hd.ui.connection.data.Item ( ( (IdItem)item ).getConnectionId (), item.getItemId (), Type.ID );
        }
        else if ( item instanceof UriItem )
        {
            return new org.eclipse.scada.hd.ui.connection.data.Item ( ( (UriItem)item ).getConnectionUri (), item.getItemId (), Type.URI );
        }
        else
        {
            return null;
        }
    }

    @Override
    protected void disposeInput ()
    {
        if ( this.input != null )
        {
            this.viewer.removeInput ( this.input );
            this.input.dispose ();
            setInput ( null );
        }
        if ( this.querySeriesData != null )
        {
            this.querySeriesData.dispose ();
            setQuerySeriesData ( null );
        }
    }

    @Override
    public boolean provides ( final ChartInput input )
    {
        return this.input == input;
    }

    public QuerySeriesData getQuerySeriesData ()
    {
        return this.querySeriesData;
    }

    public void setQuerySeriesData ( final QuerySeriesData querySeriesData )
    {
        firePropertyChange ( PROP_QUERY_SERIES_DATA, querySeriesData, this.querySeriesData = querySeriesData );
    }
}
