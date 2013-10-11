/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
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
package org.eclipse.scada.ui.chart.viewer.controller.tools;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.swt.controller.MouseDragZoomer;
import org.eclipse.scada.chart.swt.controller.MouseTransformer;
import org.eclipse.scada.chart.swt.controller.MouseWheelZoomer;
import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.XAxisViewer;
import org.eclipse.scada.ui.chart.viewer.YAxisViewer;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.MouseController;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public class MouseControllerImpl extends AbstractObserver implements ChartController
{

    private final ChartContext chartContext;

    private MouseTransformer mouseTransformer;

    private MouseDragZoomer mouseDragZoomer;

    private MouseWheelZoomer mouseWheelZoomer;

    private XAxisViewer selectedXAxis;

    private YAxisViewer selectedYAxis;

    private YAxis selectedYAxisElement;

    private XAxis selectedXAxisElement;

    public MouseControllerImpl ( final ControllerManager controllerManager, final ChartContext chartContext, final MouseController controller )
    {
        this.chartContext = chartContext;

        final Chart chart = chartContext.getChart ();

        final DataBindingContext ctx = controllerManager.getContext ();
        ctx.bindValue ( PojoObservables.observeValue ( this, "selectedXAxis" ), EMFObservables.observeValue ( chart, ChartPackage.Literals.CHART__SELECTED_XAXIS ) ); //$NON-NLS-1$
        ctx.bindValue ( PojoObservables.observeValue ( this, "selectedYAxis" ), EMFObservables.observeValue ( chart, ChartPackage.Literals.CHART__SELECTED_YAXIS ) ); //$NON-NLS-1$
    }

    protected void activate ( final org.eclipse.scada.chart.XAxis x, final org.eclipse.scada.chart.YAxis y )
    {
        this.mouseTransformer = new MouseTransformer ( this.chartContext.getChartRenderer (), x, y );
        this.mouseDragZoomer = new MouseDragZoomer ( this.chartContext.getChartRenderer (), x, y );
        this.mouseWheelZoomer = new MouseWheelZoomer ( this.chartContext.getChartRenderer (), x, y );
    }

    protected void deactivate ()
    {
        if ( this.mouseTransformer != null )
        {
            this.mouseTransformer.dispose ();
            this.mouseTransformer = null;
        }

        if ( this.mouseDragZoomer != null )
        {
            this.mouseDragZoomer.dispose ();
            this.mouseDragZoomer = null;
        }

        if ( this.mouseWheelZoomer != null )
        {
            this.mouseWheelZoomer.dispose ();
            this.mouseWheelZoomer = null;
        }
    }

    protected void updateState ()
    {
        final org.eclipse.scada.chart.XAxis x;
        final org.eclipse.scada.chart.YAxis y;

        x = getSelectedXAxisViewer ();
        y = getSelectedYAxisViewer ();

        // update mouse controllers

        if ( this.mouseTransformer != null )
        {
            this.mouseTransformer.dispose ();
            this.mouseTransformer = null;
        }
        if ( this.mouseDragZoomer != null )
        {
            this.mouseDragZoomer.dispose ();
            this.mouseDragZoomer = null;
        }
        if ( this.mouseWheelZoomer != null )
        {
            this.mouseWheelZoomer.dispose ();
            this.mouseWheelZoomer = null;
        }
        if ( x != null && y != null )
        {
            activate ( x, y );
        }
        else
        {
            deactivate ();
        }
    }

    private org.eclipse.scada.chart.YAxis getSelectedYAxisViewer ()
    {
        return this.selectedYAxis != null ? this.selectedYAxis.getAxis () : null;
    }

    private org.eclipse.scada.chart.XAxis getSelectedXAxisViewer ()
    {
        return this.selectedXAxis != null ? this.selectedXAxis.getAxis () : null;
    }

    public XAxis getSelectedXAxis ()
    {
        return this.selectedXAxisElement;
    }

    public YAxis getSelectedYAxis ()
    {
        return this.selectedYAxisElement;
    }

    public void setSelectedXAxis ( final XAxis axis )
    {
        final XAxisViewer newSelection = this.chartContext.getxAxisLocator ().findAxis ( axis );
        if ( this.selectedXAxis == newSelection )
        {
            return;
        }
        this.selectedXAxis = newSelection;
        this.selectedXAxisElement = axis;
        updateState ();
    }

    public void setSelectedYAxis ( final YAxis axis )
    {
        final YAxisViewer newSelection = this.chartContext.getyAxisLocator ().findAxis ( axis );
        if ( this.selectedYAxis == newSelection )
        {
            return;
        }
        this.selectedYAxis = newSelection;
        this.selectedYAxisElement = axis;
        updateState ();
    }

    @Override
    public void dispose ()
    {
        deactivate ();
        super.dispose ();
    }

}
