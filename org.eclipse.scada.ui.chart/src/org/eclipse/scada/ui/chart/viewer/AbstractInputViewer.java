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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.DataSeries;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public abstract class AbstractInputViewer extends AbstractObserver implements InputViewer
{

    public static final String PROP_X_AXIS = "XAxis"; //$NON-NLS-1$

    public static final String PROP_Y_AXIS = "YAxis"; //$NON-NLS-1$

    protected final ChartViewer viewer;

    protected XAxisViewer xAxis;

    protected YAxisViewer yAxis;

    private final AxisLocator<XAxis, XAxisViewer> xLocator;

    private final AxisLocator<YAxis, YAxisViewer> yLocator;

    protected XAxis x;

    protected YAxis y;

    protected final ResourceManager resourceManager;

    private boolean visibile;

    private final DataSeries element;

    private final DataBindingContext dbc;

    public AbstractInputViewer ( final DataBindingContext dbc, final DataSeries element, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        this.element = element;
        this.viewer = viewer;
        this.dbc = dbc;

        this.resourceManager = new LocalResourceManager ( resourceManager );

        this.xLocator = xLocator;
        this.yLocator = yLocator;

        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "x" ), EMFObservables.observeValue ( element, ChartPackage.Literals.DATA_SERIES__X ) ) ); //$NON-NLS-1$
        addBinding ( dbc.bindValue ( PojoObservables.observeValue ( this, "y" ), EMFObservables.observeValue ( element, ChartPackage.Literals.DATA_SERIES__Y ) ) ); //$NON-NLS-1$
    }

    protected void setInputObserable ( final IObservableValue inputObservable )
    {
        addBinding ( this.dbc.bindValue ( PojoObservables.observeDetailValue ( inputObservable, ChartInput.PROP_VISIBLE, Boolean.class ), EMFObservables.observeValue ( this.element, ChartPackage.Literals.DATA_SERIES__VISIBLE ) ) );
        addBinding ( this.dbc.bindValue ( PojoObservables.observeDetailValue ( inputObservable, ChartInput.PROP_LABEL, String.class ), EMFObservables.observeValue ( this.element, ChartPackage.Literals.DATA_SERIES__LABEL ) ) );
    }

    protected abstract void checkCreateInput ();

    protected abstract void disposeInput ();

    public void setVisibile ( final boolean visibile )
    {
        this.visibile = visibile;
    }

    public boolean isVisibile ()
    {
        return this.visibile;
    }

    public void setX ( final org.eclipse.scada.ui.chart.model.XAxis x )
    {
        disposeInput ();

        this.x = x;
        setXAxis ( this.xLocator.findAxis ( x ) );

        checkCreateInput ();
    }

    public XAxis getX ()
    {
        return this.x;
    }

    public void setY ( final org.eclipse.scada.ui.chart.model.YAxis y )
    {
        disposeInput ();

        this.y = y;
        setYAxis ( this.yLocator.findAxis ( y ) );

        checkCreateInput ();
    }

    public YAxis getY ()
    {
        return this.y;
    }

    public YAxisViewer getYAxis ()
    {
        return this.yAxis;
    }

    public void setYAxis ( final YAxisViewer yAxis )
    {
        firePropertyChange ( PROP_Y_AXIS, this.yAxis, this.yAxis = yAxis );
    }

    public XAxisViewer getXAxis ()
    {
        return this.xAxis;
    }

    public void setXAxis ( final XAxisViewer xAxis )
    {
        firePropertyChange ( PROP_X_AXIS, this.xAxis, this.xAxis = xAxis );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        disposeInput ();

        this.resourceManager.dispose ();
    }

}
