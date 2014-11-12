/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow setting the chart configuration
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view;

import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.selector.ChartConfigurationInputSelector;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ChartInputSelectorView extends AbstractChartManagePart
{

    private Label placeholder;

    private Composite parent;

    private ChartConfigurationInputSelector selector;

    private Chart configuration;

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.parent = parent;
        this.placeholder = new Label ( parent, SWT.NONE );
        this.placeholder.setText ( "Select a chart view to see input channels" );

        attachSelectionService ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.placeholder != null )
        {
            this.placeholder.setFocus ();
        }
    }

    @Override
    public void setChartViewer ( final ChartViewer chartViewer )
    {
        final Chart newConfig = chartViewer.getChartConfiguration ();

        if ( newConfig == this.configuration )
        {
            return;
        }

        this.configuration = newConfig;

        if ( this.placeholder != null )
        {
            this.placeholder.dispose ();
            this.placeholder = null;
        }

        if ( this.selector != null )
        {
            this.selector.dispose ();
            this.selector = null;
        }
        this.selector = new ChartConfigurationInputSelector ( this.parent, chartViewer.getChartConfiguration () );
        this.parent.layout ();
    }
}
