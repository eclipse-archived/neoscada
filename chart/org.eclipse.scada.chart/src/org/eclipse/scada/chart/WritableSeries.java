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

public class WritableSeries extends AbstractSeriesData
{

    private WritableSeriesData data;

    public WritableSeries ( final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        super ( realm, xAxis, yAxis );
        this.data = new WritableSeriesData ( this );
    }

    public void setData ( final WritableSeriesData data )
    {
        this.data = data;
    }

    public WritableSeriesData getData ()
    {
        return this.data;
    }

    @Override
    public SeriesViewData getViewData ()
    {
        return this.data;
    }

    @Override
    public void setRequestWindow ( final long startTimestamp, final long endTimestamp )
    {
        // no-op
    }

    @Override
    public void setRequestWidth ( final int width )
    {
        // no-op
    }
}
