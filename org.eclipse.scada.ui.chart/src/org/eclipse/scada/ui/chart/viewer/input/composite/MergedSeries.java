/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
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
package org.eclipse.scada.ui.chart.viewer.input.composite;

import java.util.Map;

import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.WritableSeries;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.ui.chart.viewer.input.ArchiveInput;

public class MergedSeries extends WritableSeries
{

    private long startTimestamp;

    private long endTimestamp;

    private int width;

    private final Map<ArchiveInput, CompositeSource> sources;

    public MergedSeries ( final Map<ArchiveInput, CompositeSource> sources, final Realm realm, final XAxis xAxis, final YAxis yAxis )
    {
        super ( realm, xAxis, yAxis );
        this.sources = sources;
    }

    @Override
    public void setRequestWindow ( final long startTimestamp, final long endTimestamp )
    {
        if ( this.startTimestamp == startTimestamp && this.endTimestamp == endTimestamp )
        {
            return;
        }

        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        update ();
    }

    @Override
    public void setRequestWidth ( final int width )
    {
        if ( this.width == width )
        {
            return;
        }

        this.width = width;
        update ();
    }

    public void update ()
    {
        final MergeQualityData merger = new MergeQualityData ( this.sources.values (), this.startTimestamp, this.endTimestamp, this.width );
        merger.merge ();
        setData ( merger.getData () );
    }

}
