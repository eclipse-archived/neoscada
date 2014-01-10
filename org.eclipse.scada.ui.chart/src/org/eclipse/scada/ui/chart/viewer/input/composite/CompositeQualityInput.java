/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
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

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.render.AbstractDataSeriesRenderer;
import org.eclipse.scada.chart.swt.render.QualityRenderer;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.input.AbstractInput;
import org.eclipse.scada.ui.chart.viewer.input.ArchiveInput;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositeQualityInput extends AbstractInput
{

    private final static Logger logger = LoggerFactory.getLogger ( CompositeQualityInput.class );

    private double threshold;

    private final IObservableList inputs;

    private IListChangeListener listener;

    private final MergedSeries data;

    private final AbstractDataSeriesRenderer renderer;

    private final ChartRenderer chartRenderer;

    private final Map<ArchiveInput, CompositeSource> sources = new HashMap<ArchiveInput, CompositeSource> ();

    public CompositeQualityInput ( final ChartViewer viewer, final ChartRenderer chartRenderer, final Realm realm, final XAxis xAxis, final YAxis yAxis, final IObservableList inputs )
    {
        this.inputs = inputs;
        this.chartRenderer = chartRenderer;

        this.data = new MergedSeries ( this.sources, realm, xAxis, yAxis );

        this.inputs.addListChangeListener ( this.listener = new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                handleDiff ( event.diff );
            }
        } );
        handleDiff ( Diffs.computeListDiff ( Collections.EMPTY_LIST, inputs ) );

        // this.renderer = new StepRenderer ( chartRenderer, this.data );
        this.renderer = new QualityRenderer ( chartRenderer, this.data ) {
            @Override
            protected boolean checkQuality ( final boolean hasData, final Double value )
            {
                if ( !hasData || value == null )
                {
                    return false;
                }

                return CompositeQualityInput.this.checkQuality ( value );
            }
        };
        this.chartRenderer.addRenderer ( this.renderer );

        attachHover ( viewer, xAxis );
    }

    protected boolean checkQuality ( final double value )
    {
        return value > this.threshold;
    }

    @Override
    public void dispose ()
    {
        this.chartRenderer.removeRenderer ( this.renderer );

        this.renderer.dispose ();

        this.inputs.removeListChangeListener ( this.listener );
        this.data.dispose ();
        super.dispose ();
    }

    protected void handleDiff ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @Override
            public void handleRemove ( final int index, final Object element )
            {
                CompositeQualityInput.this.handleRemove ( element );
            }

            @Override
            public void handleAdd ( final int index, final Object element )
            {
                CompositeQualityInput.this.handleAdd ( element );
            }
        } );
    }

    private void handleRemove ( final Object o )
    {
        logger.debug ( "Remove: {}", o );

        final CompositeSource source = this.sources.remove ( o );
        if ( source != null )
        {
            logger.debug ( "Disposing source" );
            source.dispose ();
        }
        performUpdate ();
    }

    private void handleAdd ( final Object o )
    {
        if ( ! ( o instanceof ArchiveInput ) )
        {
            return;
        }

        final ArchiveInput archiveInput = (ArchiveInput)o;
        final CompositeSource source = new CompositeSource ( this, archiveInput );
        this.sources.put ( archiveInput, source );
        performUpdate ();
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        if ( this.renderer != null )
        {
            this.renderer.setVisible ( visible );
        }
        super.setVisible ( visible );
    }

    @Override
    public void setSelection ( final boolean state )
    {
    }

    @Override
    public void tick ( final long now )
    {
    }

    @Override
    public String getState ()
    {
        return MessageFormat.format ( Messages.CompositeQualityInput_State_Format, this.sources.size () );
    }

    @Override
    public Image getPreview ( final int width, final int height )
    {
        return null;
    }

    public double getThreshold ()
    {
        return this.threshold;
    }

    public void setThreshold ( final double threshold )
    {
        this.threshold = threshold;
    }

    public void performUpdate ()
    {
        this.data.update ();
    }

    @Override
    protected void setSelectedTimestamp ( final Date selectedTimestamp )
    {
        super.setSelectedTimestamp ( selectedTimestamp );
        final DataEntry value = this.data.getViewData ().getEntries ().lower ( new DataEntry ( selectedTimestamp.getTime (), null ) );
        if ( value == null )
        {
            setSelectedValue ( null );
        }
        else
        {
            setSelectedValue ( value.toString () );
        }
    }

}
