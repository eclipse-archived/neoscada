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
package org.eclipse.scada.ui.chart.viewer.controller.info;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.ui.chart.model.LegendController;
import org.eclipse.scada.ui.chart.viewer.controller.ChartControllerFactory;

public class AdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( "rawtypes" )
    private static final Class[] CLASSES = new Class[] { ChartControllerFactory.class };

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( adaptableObject instanceof LegendController && adapterType == ChartControllerFactory.class )
        {
            return new LegendControllerFactory ();
        }
        return null;
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Class[] getAdapterList ()
    {
        return CLASSES;
    }

}
