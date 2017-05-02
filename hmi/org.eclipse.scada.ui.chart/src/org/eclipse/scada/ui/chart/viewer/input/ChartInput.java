/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.Calendar;

import org.eclipse.scada.chart.swt.render.legend.SeriesInformation;
import org.eclipse.swt.graphics.Image;

public interface ChartInput extends SeriesInformation
{
    public static final String PROP_STATE = "state"; //$NON-NLS-1$

    public static final String PROP_PREVIEW = "preview"; //$NON-NLS-1$

    public void setSelection ( final boolean state );

    public void dispose ();

    public boolean tick ( final long now );

    public void setVisible ( boolean state );

    // required for bean introspection
    @Override
    public boolean isVisible ();

    public String getState ();

    public void setSelection ( Calendar date );

    /**
     * Get rendered preview
     * <p>
     * The chart input implementation must dispose the created image. If the
     * implementation cannot create the image for the requested size it must
     * return <code>null</code>.
     * </p>
     *
     * @param width
     *            the requested width
     * @param height
     *            the requested height
     * @return the rendered preview or <code>null</code>
     */
    public Image getPreview ( final int width, int height );

    public Object getPreview ();
}