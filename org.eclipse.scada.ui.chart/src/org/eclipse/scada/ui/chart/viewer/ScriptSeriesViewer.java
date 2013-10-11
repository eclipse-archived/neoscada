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
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.viewer.input.ScriptInput;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.ScriptSeries;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public class ScriptSeriesViewer extends AbstractInputViewer implements InputViewer
{
    public static final String PROP_INPUT = "input"; //$NON-NLS-1$

    private ScriptInput input;

    private final IObservableValue inputObservable;

    private final IObservableValue linePropertiesObservable;

    public ScriptSeriesViewer ( final DataBindingContext dbc, final ScriptSeries element, final ChartViewer viewer, final ResourceManager resourceManager, final AxisLocator<XAxis, XAxisViewer> xLocator, final AxisLocator<YAxis, YAxisViewer> yLocator )
    {
        super ( dbc, element, viewer, resourceManager, xLocator, yLocator );

        this.inputObservable = BeansObservables.observeValue ( this, PROP_INPUT );
        this.linePropertiesObservable = EMFObservables.observeValue ( element, ChartPackage.Literals.SCRIPT_SERIES__LINE_PROPERTIES );

        addBinding ( dbc.bindValue ( PojoObservables.observeDetailValue ( this.inputObservable, "script", null ), EMFObservables.observeValue ( element, ChartPackage.Literals.SCRIPT_SERIES__SCRIPT ) ) ); //$NON-NLS-1$
        addBindings ( LinePropertiesBinder.bind ( SWTObservables.getRealm ( viewer.getChartRenderer ().getDisplay () ), dbc, this.inputObservable, this.linePropertiesObservable ) );

        setInputObserable ( this.inputObservable );
    }

    @Override
    public void dispose ()
    {
        this.inputObservable.dispose ();
        this.linePropertiesObservable.dispose ();
        super.dispose ();
    }

    @Override
    protected void checkCreateInput ()
    {
        if ( this.xAxis != null && this.yAxis != null )
        {
            final ScriptInput input = new ScriptInput ( this.viewer, this.viewer.getRealm (), this.resourceManager, this.xAxis.getAxis (), this.yAxis.getAxis () );
            this.viewer.addInput ( input );
            setInput ( input );
        }
    }

    protected void setInput ( final ScriptInput input )
    {
        firePropertyChange ( PROP_INPUT, this.input, this.input = input );
    }

    public ScriptInput getInput ()
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
