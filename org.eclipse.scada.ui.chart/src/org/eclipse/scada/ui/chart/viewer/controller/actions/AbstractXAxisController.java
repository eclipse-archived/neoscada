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
package org.eclipse.scada.ui.chart.viewer.controller.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.ui.chart.viewer.AbstractObserver;
import org.eclipse.scada.ui.chart.viewer.AxisLocator;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.XAxisViewer;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.XAxisController;

public class AbstractXAxisController extends AbstractObserver
{
    private final AxisLocator<XAxis, XAxisViewer> xLocator;

    private final WritableList list;

    public AbstractXAxisController ( final DataBindingContext ctx, final ChartContext chartContext, final XAxisController controller )
    {
        this.list = new WritableList ( ctx.getValidationRealm () );

        this.xLocator = chartContext.getxAxisLocator ();
        addBinding ( ctx.bindList ( this.list, EMFObservables.observeList ( controller, ChartPackage.Literals.XAXIS_CONTROLLER__AXIS ) ) );
    }

    protected boolean isAllAxisIfEmpty ()
    {
        return true;
    }

    protected List<XAxisViewer> getCurrentViewers ()
    {
        final List<XAxisViewer> result = new LinkedList<XAxisViewer> ();

        if ( this.list.isEmpty () && isAllAxisIfEmpty () )
        {
            return this.xLocator.getAll ();
        }

        for ( final Object o : this.list )
        {
            if ( ! ( o instanceof XAxis ) )
            {
                continue;
            }
            final XAxisViewer x = this.xLocator.findAxis ( (XAxis)o );
            result.add ( x );
        }

        return result;
    }
}
