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
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.chart.model.ChartView;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.ui.draw2d.BasicViewElementFactory;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.FactoryContext;
import org.eclipse.scada.vi.ui.draw2d.Helper;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.scada.vi.ui.draw2d.loader.SymbolLoader;

public class ViewElementFactory implements org.eclipse.scada.vi.ui.draw2d.ViewElementFactory
{

    @Override
    public Controller create ( final SymbolController controller, final Primitive element, final SymbolLoader symbolLoader, final ResourceManager manager, final BasicViewElementFactory basicViewElementFactory, final FactoryContext context )
    {
        try
        {
            final ChartView view = (ChartView)element;
            return new ChartController ( controller, manager, view, symbolLoader, context );
        }
        catch ( final Exception e )
        {
            return Helper.createErrorController ( e );
        }
    }

}
