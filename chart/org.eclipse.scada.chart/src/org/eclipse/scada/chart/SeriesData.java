/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart;

public interface SeriesData
{
    public void addListener ( final SeriesDataListener listener );

    public void removeListener ( final SeriesDataListener listener );

    public XAxis getXAxis ();

    public YAxis getYAxis ();

    public void setRequestWindow ( final long startTimestamp, final long endTimestamp );

    public void setRequestWidth ( final int width );

    public SeriesViewData getViewData ();
}