/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input.composite;

import org.eclipse.scada.chart.SeriesDataListener;
import org.eclipse.scada.chart.SeriesViewData;
import org.eclipse.scada.ui.chart.viewer.input.ArchiveInput;
import org.eclipse.scada.ui.chart.viewer.input.QuerySeriesData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeSource
{

    private final static Logger logger = LoggerFactory.getLogger ( CompositeSource.class );

    private final SeriesDataListener listener = new SeriesDataListener () {

        @Override
        public void dataUpdate ( final long startTimestamp, final long endTimestamp )
        {
            handleDataUpdate ();
        }
    };

    private final QuerySeriesData data;

    private SeriesViewData viewData;

    private final CompositeQualityInput compositeQualityInput;

    public CompositeSource ( final CompositeQualityInput compositeQualityInput, final ArchiveInput archiveInput )
    {
        this.compositeQualityInput = compositeQualityInput;
        this.data = archiveInput.getData ();
        this.data.addListener ( this.listener );
    }

    public void dispose ()
    {
        this.data.removeListener ( this.listener );
    }

    protected void handleDataUpdate ()
    {
        logger.debug ( "Data update from: {}", this.data );

        this.viewData = this.data.getQualityData ();
        this.compositeQualityInput.performUpdate ();
    }

    public SeriesViewData getViewData ()
    {
        return this.viewData;
    }
}
