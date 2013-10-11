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
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.Date;

import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartMouseMoveListener;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AbstractInput extends AbstractPropertyChange implements ChartInput
{

    private Date selectedTimestamp;

    private String selectedValue;

    private String selectedQuality;

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
    public Date getSelectedTimestamp ()
    {
        return this.selectedTimestamp;
    }

    protected void setSelectedTimestamp ( final Date selectedTimestamp )
    {
        firePropertyChange ( PROP_SELECTED_TIMESTAMP, this.selectedTimestamp, this.selectedTimestamp = selectedTimestamp );
    }

    @Override
    public void setSelection ( final Date date )
    {
        setSelectedTimestamp ( date );
    }

    protected void setSelectedValue ( final String selectedValue )
    {
        firePropertyChange ( PROP_SELECTED_VALUE, this.selectedValue, this.selectedValue = selectedValue );
    }

    @Override
    public String getSelectedValue ()
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
        setSelectedTimestamp ( new Date ( timestamp ) );
    }

    @Override
    public void dispose ()
    {
        detachHover ();
    }

    @Override
    public String getSelectedQuality ()
    {
        return this.selectedQuality;
    }

    protected void setSelectedQuality ( final String selectedQuality )
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
