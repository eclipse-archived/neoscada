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
package org.eclipse.scada.ui.chart.viewer.controller.tools;

import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ChartController;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SeparatorController extends AbstractObserver implements ChartController
{

    private Label label;

    public SeparatorController ( final ControllerManager controllerManager, final ChartContext chartContext, final org.eclipse.scada.ui.chart.model.SeparatorController controller )
    {
        final Composite space = chartContext.getExtensionSpaceProvider ().getExtensionSpace ();
        if ( space != null )
        {
            this.label = new Label ( space, SWT.SEPARATOR | SWT.VERTICAL );
            this.label.setLayoutData ( new RowData ( 20, SWT.DEFAULT ) );
            space.layout ();
        }
        else
        {
            this.label = null;
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.label != null )
        {
            this.label.dispose ();
        }
        super.dispose ();
    }

}
