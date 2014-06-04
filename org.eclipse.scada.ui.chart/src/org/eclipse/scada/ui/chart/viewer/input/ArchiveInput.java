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
import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchiveInput extends QueryInput
{

    private final static Logger logger = LoggerFactory.getLogger ( ArchiveInput.class );

    private boolean disposed;

    private final ChartViewer viewer;

    private final StepRenderer renderer;

    private final QuerySeriesData data;

    public ArchiveInput ( final Item item, final ChartViewer viewer, final QuerySeriesData querySeriesData, final ResourceManager resourceManager )
    {
        super ( resourceManager );

        this.viewer = viewer;
        this.data = querySeriesData;

        this.renderer = new StepRenderer ( this.viewer.getChartRenderer (), querySeriesData );
        viewer.getChartRenderer ().addRenderer ( this.renderer );

        attachHover ( viewer, querySeriesData.getXAxis () );

        setQuery ( querySeriesData.getQuery (), "AVG" ); //$NON-NLS-1$
    }

    public QuerySeriesData getData ()
    {
        return this.data;
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        super.setVisible ( visible );

        logger.debug ( "Setting channel visibility - name: {}#{}, visiblity: {}", new Object[] { this.data, getChannelName (), visible } ); //$NON-NLS-1$

        if ( visible )
        {
            this.data.open ();
        }
        else
        {
            this.data.close ();
        }
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
        if ( this.data != null )
        {
            this.data.dispose ();
        }

        super.dispose ();
    }

}
