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
package org.eclipse.scada.ui.chart.viewer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.model.YAxis;

public class YAxisManager extends AbstractAxisManager<YAxis, YAxisViewer>
{
    private final Map<YAxis, YAxisViewer> axisMap = new HashMap<YAxis, YAxisViewer> ( 1 );

    private final boolean left;

    public YAxisManager ( final DataBindingContext dbc, final ChartRenderer manager, final boolean left )
    {
        super ( dbc, manager );

        this.left = left;
    }

    @Override
    protected void handleAdd ( final int index, final YAxis axis )
    {
        final YAxisViewer viewer = new YAxisViewer ( this.dbc, this.manager, axis, this.left );
        this.axisMap.put ( axis, viewer );
    }

    @Override
    protected void handleRemove ( final YAxis axis )
    {
        final YAxisViewer viewer = this.axisMap.remove ( axis );
        if ( viewer != null )
        {
            viewer.dispose ();
        }
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        for ( final YAxisViewer viewer : this.axisMap.values () )
        {
            viewer.dispose ();
        }
        this.axisMap.clear ();
    }

    @Override
    public YAxisViewer getAxis ( final YAxis axis )
    {
        return this.axisMap.get ( axis );
    }

    @Override
    public Collection<YAxisViewer> getAll ()
    {
        return this.axisMap.values ();
    }
}
