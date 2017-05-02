/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *     IBH SYSTEMS GmbH - bug fixes and extensions, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

public interface ChartContext
{
    public AxisLocator<XAxis, XAxisViewer> getxAxisLocator ();

    public AxisLocator<YAxis, YAxisViewer> getyAxisLocator ();

    public ExtensionSpaceProvider getExtensionSpaceProvider ();

    public ChartRenderer getChartRenderer ();

    public Chart getChart ();

    public ResetHandler getResetHandler ();

    public void relayoutExtensionSpace ();

    public IObservableList getInformations ();
}