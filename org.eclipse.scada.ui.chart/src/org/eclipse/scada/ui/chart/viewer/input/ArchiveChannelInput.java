/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.swt.render.AbstractLineRender;
import org.eclipse.scada.chart.swt.render.StepRenderer;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;

public class ArchiveChannelInput extends QueryInput
{

    private boolean disposed;

    private final ChartViewer viewer;

    private final StepRenderer renderer;

    private QuerySeriesData data;

    public ArchiveChannelInput ( final ChartViewer viewer, final QueryChannelSeriesData data, final ResourceManager resourceManager )
    {
        super ( resourceManager );

        this.viewer = viewer;

        this.renderer = new StepRenderer ( this.viewer.getChartRenderer (), data );
        this.viewer.getChartRenderer ().addRenderer ( this.renderer, 0 );

        viewer.addInput ( this );

        attachHover ( viewer, data.getXAxis () );

        setQuery ( data.getQuery (), data.getChannelName () );
    }

    @Override
    public void setSelection ( final boolean state )
    {
    }

    @Override
    protected AbstractLineRender getLineRenderer ()
    {
        return this.renderer;
    }

    @Override
    public void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;
        this.viewer.removeInput ( this );
        this.viewer.getChartRenderer ().removeRenderer ( this.renderer );

        this.renderer.dispose ();
        this.data.dispose ();

        super.dispose ();
    }

    @Override
    public String getState ()
    {
        return null;
    }
}
