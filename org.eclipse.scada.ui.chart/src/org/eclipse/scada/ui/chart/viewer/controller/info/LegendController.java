/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.controller.info;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.legend.LegendRenderer;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;

public class LegendController extends AbstractObserver implements ChartController
{
    private boolean disposed;

    private final LegendRenderer renderer;

    private final ChartRenderer chartRenderer;

    public LegendController ( final DataBindingContext ctx, final org.eclipse.scada.ui.chart.model.LegendController controller, final ChartContext chartContext )
    {
        this.chartRenderer = chartContext.getChartRenderer ();
        this.renderer = new LegendRenderer ( this.chartRenderer, chartContext.getInformations () );
        this.chartRenderer.addRenderer ( this.renderer, 200 );

        addBinding ( ctx.bindValue ( PojoObservables.observeValue ( this.renderer, LegendRenderer.PROP_TIMETSAMP_FORMAT ), EMFObservables.observeValue ( controller, ChartPackage.Literals.LEGEND_CONTROLLER__TIMESTAMP_FORMAT ) ) );
    }

    @Override
    public void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;
        this.chartRenderer.removeRenderer ( this.renderer );
        this.renderer.dispose ();

        super.dispose ();
    }

}
