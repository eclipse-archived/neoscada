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
package org.eclipse.scada.ui.chart.viewer.controller.tools;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.ui.chart.viewer.controller.ChartControllerFactory;
import org.eclipse.scada.ui.chart.model.MouseController;
import org.eclipse.scada.ui.chart.model.ResetController;
import org.eclipse.scada.ui.chart.model.SeparatorController;

public class AdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( "rawtypes" )
    private static final Class[] CLASSES = new Class[] { ChartControllerFactory.class };

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( adaptableObject instanceof SeparatorController && adapterType == ChartControllerFactory.class )
        {
            return new SeparatorFactory ();
        }
        if ( adaptableObject instanceof MouseController && adapterType == ChartControllerFactory.class )
        {
            return new MouseControllerFactory ();
        }
        if ( adaptableObject instanceof ResetController && adapterType == ChartControllerFactory.class )
        {
            return new ResetControllerFactory ();
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
