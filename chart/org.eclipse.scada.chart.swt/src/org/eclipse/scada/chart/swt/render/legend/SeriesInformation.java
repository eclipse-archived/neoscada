/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render.legend;

import java.util.Calendar;

import org.eclipse.swt.graphics.RGB;

public interface SeriesInformation
{
    public static final String PROP_LABEL = "label"; //$NON-NLS-1$

    public static final String PROP_COLOR = "color"; //$NON-NLS-1$

    public static final String PROP_VISIBLE = "visible"; //$NON-NLS-1$

    public static final String PROP_SELECTED_TIMESTAMP = "selectedTimestamp"; //$NON-NLS-1$

    public static final String PROP_SELECTED_VALUE = "selectedValue"; //$NON-NLS-1$

    public static final String PROP_SELECTED_QUALITY = "selectedQuality"; //$NON-NLS-1$

    public String getLabel ();

    public RGB getColor ();

    public boolean isVisible ();

    public Double getSelectedValue ();

    public Double getSelectedQuality ();

    public Calendar getSelectedTimestamp ();

}
