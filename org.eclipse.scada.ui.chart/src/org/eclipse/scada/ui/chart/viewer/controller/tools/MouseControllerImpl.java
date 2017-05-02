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
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.controller.tools;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.swt.controller.MouseDragZoomer;
import org.eclipse.scada.chart.swt.controller.MouseTransformer;
import org.eclipse.scada.chart.swt.controller.MouseWheelZoomer;
import org.eclipse.scada.ui.chart.AxisConverter;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.MouseController;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;

public class MouseControllerImpl extends AbstractObserver implements ChartController
{
    private final ChartContext chartContext;

    private MouseTransformer mouseTransformer;

    private MouseDragZoomer mouseDragZoomer;

    private MouseWheelZoomer mouseWheelZoomer;

    private final WritableList selectedXAxis = new WritableList/*XAxisViewer*/();

    private final WritableList selectedYAxis = new WritableList/*YAxisViewer*/();

    public MouseControllerImpl ( final ControllerManager controllerManager, final ChartContext chartContext, final MouseController controller )
    {
        this.chartContext = chartContext;

        final Chart chart = chartContext.getChart ();

        final DataBindingContext ctx = controllerManager.getContext ();

        ctx.bindList ( this.selectedXAxis, EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__SELECTED_XAXIS ), null, new UpdateListStrategy ().setConverter ( new AxisConverter<> ( XAxis.class, org.eclipse.scada.chart.XAxis.class, chartContext.getxAxisLocator () ) ) );
        ctx.bindList ( this.selectedYAxis, EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__SELECTED_YAXIS ), null, new UpdateListStrategy ().setConverter ( new AxisConverter<> ( YAxis.class, org.eclipse.scada.chart.YAxis.class, chartContext.getyAxisLocator () ) ) );

        this.mouseTransformer = new MouseTransformer ( this.chartContext.getChartRenderer (), this.selectedXAxis, this.selectedYAxis );
        this.mouseDragZoomer = new MouseDragZoomer ( this.chartContext.getChartRenderer (), this.selectedXAxis, this.selectedYAxis );
        this.mouseWheelZoomer = new MouseWheelZoomer ( this.chartContext.getChartRenderer (), this.selectedXAxis, this.selectedYAxis );
    }

    @Override
    public void dispose ()
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
        super.dispose ();
    }

}
