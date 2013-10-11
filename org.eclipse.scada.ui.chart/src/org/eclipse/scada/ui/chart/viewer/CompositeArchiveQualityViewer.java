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
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.viewer.input.composite.CompositeQualityInput;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public class CompositeArchiveQualityViewer extends AbstractInputViewer
{

    private static final String PROP_THRESHOLD = "threshold"; //$NON-NLS-1$

    public static final String PROP_INPUT = "input"; //$NON-NLS-1$

    private CompositeQualityInput input;

    private final IObservableValue inputObservable;

    public CompositeArchiveQualityViewer ( final DataBindingContext dbc, final CompositeArchiveQualitySeries element, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        super ( dbc, element, viewer, resourceManager, xLocator, yLocator );

        this.inputObservable = BeansObservables.observeValue ( this, PROP_INPUT );

        addBinding ( dbc.bindValue ( PojoObservables.observeDetailValue ( this.inputObservable, PROP_THRESHOLD, null ), EMFObservables.observeValue ( element, ChartPackage.Literals.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD ) ) );

        setInputObserable ( this.inputObservable );
    }

    @Override
    public void dispose ()
    {
        this.inputObservable.dispose ();
        super.dispose ();
    }

    @Override
    protected void checkCreateInput ()
    {
        if ( this.xAxis != null && this.yAxis != null )
        {
            final CompositeQualityInput input = new CompositeQualityInput ( this.viewer, this.viewer.getChartRenderer (), this.viewer.getRealm (), this.xAxis.getAxis (), this.yAxis.getAxis (), this.viewer.getItems () );
            this.viewer.addInput ( input );

            setInput ( input );
        }
    }

    protected void setInput ( final CompositeQualityInput input )
    {
        firePropertyChange ( PROP_INPUT, this.input, this.input = input );
    }

    public CompositeQualityInput getInput ()
    {
        return this.input;
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

    @Override
    public boolean provides ( final ChartInput input )
    {
        return this.input == input;
    }
}
