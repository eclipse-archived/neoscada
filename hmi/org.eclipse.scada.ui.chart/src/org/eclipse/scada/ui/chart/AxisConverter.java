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
package org.eclipse.scada.ui.chart;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.scada.ui.chart.viewer.AbstractAxisViewer;
import org.eclipse.scada.ui.chart.viewer.AxisLocator;

public class AxisConverter<FromAxis, ToAxis, AxisViewer extends AbstractAxisViewer<ToAxis>> extends Converter
{
    private final AxisLocator<FromAxis, AxisViewer> locator;

    public AxisConverter ( final Object fromType, final Class<? extends ToAxis> toType, final AxisLocator<FromAxis, AxisViewer> locator )
    {
        super ( fromType, toType );
        this.locator = locator;
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public Object convert ( final Object fromObject )
    {
        return this.locator.findAxis ( (FromAxis)fromObject ).getAxis ();
    }
}