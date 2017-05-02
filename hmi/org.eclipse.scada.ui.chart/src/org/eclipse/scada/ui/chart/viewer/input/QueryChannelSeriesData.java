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
package org.eclipse.scada.ui.chart.viewer.input;

import org.eclipse.scada.chart.AbstractSeriesData;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.SeriesDataListener;
import org.eclipse.scada.chart.SeriesViewData;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.hd.ui.data.ServiceQueryBuffer;

public class QueryChannelSeriesData extends AbstractSeriesData
{

    private final QuerySeriesData masterData;

    private String channelName;

    private final SeriesDataListener listener = new SeriesDataListener () {

        @Override
        public void dataUpdate ( final long startTimestamp, final long endTimestamp )
        {
            handleUpdate ( startTimestamp, endTimestamp );
        }
    };

    public QueryChannelSeriesData ( final Realm realm, final XAxis xAxis, final YAxis yAxis, final QuerySeriesData masterData, final String channelName )
    {
        super ( realm, xAxis, yAxis );
        this.masterData = masterData;
        this.channelName = channelName;

        masterData.addListener ( this.listener );
    }

    @Override
    public void dispose ()
    {
        this.masterData.removeListener ( this.listener );
        super.dispose ();
    }

    public ServiceQueryBuffer getQuery ()
    {
        return this.masterData.getQuery ();
    }

    protected void handleUpdate ( final long startTimestamp, final long endTimestamp )
    {
        fireUpdateListener ( startTimestamp, endTimestamp );
    }

    @Override
    public void setRequestWindow ( final long startTimestamp, final long endTimestamp )
    {
        // not supported
    }

    @Override
    public void setRequestWidth ( final int width )
    {
        // not supported
    }

    @Override
    public SeriesViewData getViewData ()
    {
        return this.masterData.getViewData ( this.channelName );
    }

    public String getChannelName ()
    {
        return this.channelName;
    }

    public void setChannelName ( final String channelName )
    {
        this.channelName = channelName;
        fireUpdateListener ( 0, Long.MAX_VALUE );
    }

}
