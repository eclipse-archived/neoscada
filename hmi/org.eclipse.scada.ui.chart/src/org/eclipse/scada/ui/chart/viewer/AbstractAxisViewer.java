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
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.scada.ui.chart.model.Axis;

public abstract class AbstractAxisViewer<A> extends AbstractObserver
{
    protected final DataBindingContext dbc;

    protected final ChartRenderer manager;

    public AbstractAxisViewer ( final DataBindingContext dbc, final ChartRenderer manager, final Axis axis )
    {
        this.dbc = dbc;
        this.manager = manager;

        manager.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                dispose ();
            }
        } );
    }

    public abstract A getAxis ();

}
