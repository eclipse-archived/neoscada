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
package org.eclipse.scada.ui.chart.view;

import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.swt.widgets.Composite;

public class TransientChartView extends AbstractChartView
{
    public static final String VIEW_ID = "org.eclipse.scada.ui.chart.TransientChartView";

    private Chart configuration;

    @Override
    protected void createChartControl ( final Composite parent )
    {
    }

    @Override
    public Chart getConfiguration ()
    {
        return this.configuration;
    }

    public void setConfiguration ( final Chart configuration )
    {
        if ( this.configuration == null )
        {
            this.configuration = configuration;
            createView ( configuration );
        }
    }

}
