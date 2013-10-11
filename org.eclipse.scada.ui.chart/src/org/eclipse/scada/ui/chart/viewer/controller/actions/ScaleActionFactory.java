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
package org.eclipse.scada.ui.chart.viewer.controller.actions;

import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ChartControllerFactory;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.scada.ui.chart.model.Controller;
import org.eclipse.scada.ui.chart.model.ScaleAction;

public class ScaleActionFactory implements ChartControllerFactory
{

    @Override
    public ChartController create ( final ControllerManager controllerManager, final Controller controller, final ChartContext chartContext )
    {
        return new ScaleActionController ( controllerManager, chartContext, (ScaleAction)controller );
    }

}
