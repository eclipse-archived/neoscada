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

import java.util.Calendar;

import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AbstractInput extends AbstractPropertyChange implements ChartInput
{
    private Calendar selectedTimestamp;

    private Double selectedValue;

    /**
     * The selected quality. Between 0.0 to 1.0. May be <code>null</code> if not
     * available
     */
    private Double selectedQuality;

    private ChartMouseMoveListener mouseMoveListener;

    private ChartRenderer chartRenderer;

    private boolean visible;

    private String label;

    @Override
    public void setVisible ( final boolean visible )
    {
        firePropertyChange ( PROP_VISIBLE, this.visible, this.visible = visible );
    }

    @Override
    public boolean isVisible ()
    {
        return this.visible;
    }

    @Override
    public Calendar getSelectedTimestamp ()
    {
        return this.selectedTimestamp;
    }

    protected void setSelectedTimestamp ( final Calendar selectedTimestamp )
    {
        firePropertyChange ( PROP_SELECTED_TIMESTAMP, this.selectedTimestamp, this.selectedTimestamp = selectedTimestamp );
    }

    @Override
    public void setSelection ( final Calendar date )
    {
        setSelectedTimestamp ( date );
    }

    protected void setSelectedValue ( final Double selectedValue )
    {
        firePropertyChange ( PROP_SELECTED_VALUE, this.selectedValue, this.selectedValue = selectedValue );
    }

    @Override
    public Double getSelectedValue ()
    {
        return this.selectedValue;
    }

    protected void attachHover ( final ChartViewer viewer, final XAxis xAxis )
    {
        detachHover ();

        this.chartRenderer = viewer.getChartRenderer ();
        this.mouseMoveListener = new ChartMouseMoveListener () {

            @Override
            public void onMouseMove ( final MouseState state )
            {
                final Rectangle chartRect = AbstractInput.this.chartRenderer.getClientAreaProxy ().getClientRectangle ();
                handeMouseMove ( state, xAxis.translateToValue ( chartRect.width, state.x - chartRect.x ) );
            }
        };
        this.chartRenderer.addMouseMoveListener ( this.mouseMoveListener );
    }

    protected void detachHover ()
    {
        if ( this.mouseMoveListener != null && this.chartRenderer != null )
        {
            this.chartRenderer.removeMouseMoveListener ( this.mouseMoveListener );
            this.mouseMoveListener = null;
            this.chartRenderer = null;
        }
    }

    protected void handeMouseMove ( final MouseState e, final long timestamp )
    {
        final Calendar c = Calendar.getInstance ();
        c.setTimeInMillis ( timestamp );
        setSelectedTimestamp ( c );
    }

    @Override
    public void dispose ()
    {
        detachHover ();
    }

    @Override
    public Double getSelectedQuality ()
    {
        return this.selectedQuality;
    }

    protected void setSelectedQuality ( final Double selectedQuality )
    {
        firePropertyChange ( PROP_SELECTED_QUALITY, this.selectedQuality, this.selectedQuality = selectedQuality );
    }

    public void setLabel ( final String label )
    {
        firePropertyChange ( PROP_LABEL, this.label, this.label = label );
    }

    @Override
    public String getLabel ()
    {
        return this.label;
    }

    private Object preview;

    private void setPreview ( final Object preview )
    {
        firePropertyChange ( PROP_PREVIEW, this.preview, this.preview = preview );
    }

    @Override
    public Object getPreview ()
    {
        // this is just a dummy method required for triggering updates
        return this.preview;
    }

    protected void fireUpdatePreviews ()
    {
        setPreview ( new Object () );
    }

}
