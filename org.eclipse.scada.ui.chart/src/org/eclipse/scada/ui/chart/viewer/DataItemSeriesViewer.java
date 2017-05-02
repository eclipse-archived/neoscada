/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - minor cleanup
 *     IBH SYSTEMS GmbH - bug fixes and extensions
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.Item;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.viewer.input.ItemObserver;

public class DataItemSeriesViewer extends AbstractItemInputViewer
{
    public static final String PROP_INPUT = "input"; //$NON-NLS-1$

    private final IObservableValue inputObservable;

    private final IObservableValue linePropertiesObservable;

    private ItemObserver input;

    public DataItemSeriesViewer ( final DataBindingContext dbc, final DataItemSeries element, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        super ( dbc, element, viewer, resourceManager, xLocator, yLocator );

        this.inputObservable = BeansObservables.observeValue ( this, PROP_INPUT );
        this.linePropertiesObservable = EMFObservables.observeValue ( element, ChartPackage.Literals.DATA_ITEM_SERIES__LINE_PROPERTIES );

        addBindings ( LinePropertiesBinder.bind ( dbc, this.inputObservable, this.linePropertiesObservable ) );

        setInputObserable ( this.inputObservable );
    }

    @Override
    public void dispose ()
    {
        this.inputObservable.dispose ();
        this.linePropertiesObservable.dispose ();
    }

    @Override
    protected void checkCreateInput ()
    {
        if ( this.item != null && this.xAxis != null && this.yAxis != null )
        {
            final org.eclipse.scada.da.ui.connection.data.Item item = makeItem ( this.item );
            if ( item == null )
            {
                return;
            }

            final ItemObserver input = new ItemObserver ( this.viewer, item, this.viewer.getRealm (), this.xAxis.getAxis (), this.yAxis.getAxis (), this.resourceManager );
            this.viewer.addInput ( input );
            setInput ( input );
        }
    }

    private void setInput ( final ItemObserver input )
    {
        firePropertyChange ( PROP_INPUT, this.input, this.input = input );
    }

    public ItemObserver getInput ()
    {
        return this.input;
    }

    private org.eclipse.scada.da.ui.connection.data.Item makeItem ( final Item item )
    {
        if ( item instanceof IdItem )
        {
            return new org.eclipse.scada.da.ui.connection.data.Item ( ( (IdItem)item ).getConnectionId (), item.getItemId (), Type.ID );
        }
        else if ( item instanceof UriItem )
        {
            return new org.eclipse.scada.da.ui.connection.data.Item ( ( (UriItem)item ).getConnectionUri (), item.getItemId (), Type.URI );
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean provides ( final ChartInput input )
    {
        return this.input == input;
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
    }

}
