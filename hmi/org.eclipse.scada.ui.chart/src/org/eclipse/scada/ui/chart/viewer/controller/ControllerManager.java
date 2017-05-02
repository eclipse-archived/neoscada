/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new AdapterHelper, bug fixes and extensions
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.controller;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.ui.chart.model.Controller;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class ControllerManager
{
    private final WritableList list;

    private final DataBindingContext ctx;

    private final ChartContext chartContext;

    private final Realm realm;

    public ControllerManager ( final DataBindingContext ctx, final Realm realm, final ChartContext chartContext )
    {
        this.ctx = ctx;
        this.realm = realm;
        this.chartContext = chartContext;
        this.list = new WritableList ();
        this.list.addListChangeListener ( new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                handleChange ( event.diff );
            }
        } );
    }

    protected void handleChange ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @Override
            public void handleRemove ( final int index, final Object element )
            {
                ControllerManager.this.handleRemove ( (Controller)element );
            }

            @Override
            public void handleAdd ( final int index, final Object element )
            {
                ControllerManager.this.handleAdd ( (Controller)element );
            }
        } );
    }

    private final Map<Controller, ChartController> controllerMap = new HashMap<Controller, ChartController> ();

    protected void handleAdd ( final Controller controller )
    {
        handleRemove ( controller );
        final ChartController chartController = createController ( controller );
        if ( chartController != null )
        {
            this.controllerMap.put ( controller, chartController );
        }
        this.chartContext.relayoutExtensionSpace ();
    }

    protected void handleRemove ( final Controller controller )
    {
        final ChartController chartController = this.controllerMap.get ( controller );
        if ( chartController != null )
        {
            chartController.dispose ();
        }
        this.chartContext.relayoutExtensionSpace ();
    }

    private ChartControllerFactory createFactory ( final Controller controller )
    {
        final ChartControllerFactory factory = AdapterHelper.adapt ( controller, ChartControllerFactory.class );
        if ( factory != null )
        {
            return factory;
        }
        return null;
    }

    private ChartController createController ( final Controller controller )
    {
        final ChartControllerFactory factory = createFactory ( controller );
        if ( factory == null )
        {
            return null;
        }

        return factory.create ( this, controller, this.chartContext );
    }

    public WritableList getList ()
    {
        return this.list;
    }

    public void dispose ()
    {
        for ( final ChartController chartController : this.controllerMap.values () )
        {
            chartController.dispose ();
        }
        this.controllerMap.clear ();

        this.list.dispose ();
    }

    public DataBindingContext getContext ()
    {
        return this.ctx;
    }

    public Realm getRealm ()
    {
        return this.realm;
    }

    public ChartContext getChartContext ()
    {
        return this.chartContext;
    }
}
