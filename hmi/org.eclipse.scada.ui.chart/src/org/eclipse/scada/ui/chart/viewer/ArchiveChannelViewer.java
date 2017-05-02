/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - bug fixes and extensions
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.chart.model.ArchiveChannel;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.viewer.input.ArchiveChannelInput;
import org.eclipse.scada.ui.chart.viewer.input.QueryChannelSeriesData;
import org.eclipse.scada.ui.chart.viewer.input.QuerySeriesData;

public class ArchiveChannelViewer extends AbstractObserver
{
    public static final String PROP_INPUT = "input"; //$NON-NLS-1$

    private String channelName;

    private QuerySeriesData querySeriesData;

    private final ChartViewer viewer;

    private QueryChannelSeriesData data;

    private ArchiveChannelInput input;

    private XAxisViewer xAxisViewer;

    private YAxisViewer yAxisViewer;

    private final IObservableValue inputObservable;

    private final IObservableValue linePropertiesObservable;

    private final ResourceManager resourceManager;

    public ArchiveChannelViewer ( final DataBindingContext dbc, final ArchiveChannel element, final ChartViewer viewer, final ResourceManager resourceManager, final ArchiveSeriesViewer archiveSeriesViewer )
    {
        super ();

        this.viewer = viewer;

        this.resourceManager = resourceManager;

        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "channelName" ), EMFObservables.observeValue ( element, ChartPackage.Literals.ARCHIVE_CHANNEL__NAME ) ) ); //$NON-NLS-1$
        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "querySeriesData" ), BeansObservables.observeValue ( archiveSeriesViewer, ArchiveSeriesViewer.PROP_QUERY_SERIES_DATA ) ) ); //$NON-NLS-1$

        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "XAxisViewer" ), BeansObservables.observeValue ( archiveSeriesViewer, AbstractInputViewer.PROP_X_AXIS ) ) ); //$NON-NLS-1$
        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "YAxisViewer" ), BeansObservables.observeValue ( archiveSeriesViewer, AbstractInputViewer.PROP_Y_AXIS ) ) ); //$NON-NLS-1$

        this.inputObservable = BeansObservables.observeValue ( this, PROP_INPUT );
        this.linePropertiesObservable = EMFObservables.observeValue ( element, ChartPackage.Literals.ARCHIVE_CHANNEL__LINE_PROPERTIES );

        addBinding ( dbc.bindValue ( PojoObservables.observeDetailValue ( this.inputObservable, "label", null ), EMFObservables.observeValue ( element, ChartPackage.Literals.ARCHIVE_CHANNEL__LABEL ) ) ); //$NON-NLS-1$

        addBindings ( LinePropertiesBinder.bind ( dbc, this.inputObservable, this.linePropertiesObservable ) );
    }

    public void setChannelName ( final String channelName )
    {
        disposeInput ();

        this.channelName = channelName;

        checkCreateInput ();
    }

    public String getChannelName ()
    {
        return this.channelName;
    }

    public QuerySeriesData getQuerySeriesData ()
    {
        return this.querySeriesData;
    }

    public void setQuerySeriesData ( final QuerySeriesData querySeriesData )
    {
        disposeInput ();

        this.querySeriesData = querySeriesData;

        checkCreateInput ();
    }

    private void checkCreateInput ()
    {
        if ( this.querySeriesData != null && this.xAxisViewer != null && this.yAxisViewer != null && this.channelName != null )
        {
            this.data = new QueryChannelSeriesData ( this.viewer.getRealm (), this.xAxisViewer.getAxis (), this.yAxisViewer.getAxis (), this.querySeriesData, this.channelName );
            setInput ( new ArchiveChannelInput ( this.viewer, this.data, this.resourceManager ) );
        }
    }

    @Override
    public void dispose ()
    {
        this.inputObservable.dispose ();
        this.linePropertiesObservable.dispose ();

        disposeInput ();
        super.dispose ();
    }

    private void disposeInput ()
    {
        if ( this.input != null )
        {
            this.input.dispose ();
            setInput ( null );
        }
        if ( this.data != null )
        {
            this.data.dispose ();
            this.data = null;
        }
    }

    public XAxisViewer getXAxisViewer ()
    {
        return this.xAxisViewer;
    }

    public void setXAxisViewer ( final XAxisViewer xAxisViewer )
    {
        disposeInput ();

        this.xAxisViewer = xAxisViewer;

        checkCreateInput ();
    }

    public YAxisViewer getYAxisViewer ()
    {
        return this.yAxisViewer;
    }

    public void setYAxisViewer ( final YAxisViewer yAxisViewer )
    {
        disposeInput ();

        this.yAxisViewer = yAxisViewer;

        checkCreateInput ();
    }

    public ArchiveChannelInput getInput ()
    {
        return this.input;
    }

    public void setInput ( final ArchiveChannelInput input )
    {
        firePropertyChange ( PROP_INPUT, this.input, this.input = input );
    }
}
