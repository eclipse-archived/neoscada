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

import org.eclipse.scada.ui.chart.model.Controller;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ChartControllerFactory;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;

public class LegendControllerFactory implements ChartControllerFactory
{

    @Override
    public ChartController create ( final ControllerManager controllerManager, final Controller controller, final ChartContext chartContext )
    {
        return new LegendController ( controllerManager.getContext (), (org.eclipse.scada.ui.chart.model.LegendController)controller, chartContext );
    }

}
