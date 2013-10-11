/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
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
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.Date;

import org.eclipse.swt.graphics.Image;

public interface ChartInput
{
    public static final String PROP_SELECTED_TIMESTAMP = "selectedTimestamp"; //$NON-NLS-1$

    public static final String PROP_SELECTED_VALUE = "selectedValue"; //$NON-NLS-1$

    public static final String PROP_SELECTED_QUALITY = "selectedQuality"; //$NON-NLS-1$

    public static final String PROP_VISIBLE = "visible"; //$NON-NLS-1$

    public static final String PROP_STATE = "state"; //$NON-NLS-1$

    public static final String PROP_PREVIEW = "preview"; //$NON-NLS-1$

    public static final String PROP_LABEL = "label"; //$NON-NLS-1$

    public void setSelection ( final boolean state );

    public void dispose ();

    public void tick ( final long now );

    public void setVisible ( boolean state );

    public boolean isVisible ();

    public String getLabel ();

    public String getState ();

    public String getSelectedValue ();

    public String getSelectedQuality ();

    public Date getSelectedTimestamp ();

    public void setSelection ( Date date );

    /**
     * Get rendered preview
     * <p>
     * The chart input implementation must dispose the created image. If the implementation cannot create the image for the requested size it must return <code>null</code>.
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