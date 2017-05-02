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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.ui.chart.model.XAxis;

public class XAxisManager extends AbstractAxisManager<XAxis, XAxisViewer>
{
    private final Map<XAxis, XAxisViewer> axisMap = new HashMap<XAxis, XAxisViewer> ( 1 );

    private final boolean top;

    public XAxisManager ( final DataBindingContext dbc, final ChartRenderer manager, final boolean top )
    {
        super ( dbc, manager );
        this.top = top;
    }

    @Override
    protected void handleAdd ( final int index, final XAxis axis )
    {
        final XAxisViewer viewer = new XAxisViewer ( this.dbc, this.manager, axis, this.top );
        this.axisMap.put ( axis, viewer );
    }

    @Override
    protected void handleRemove ( final XAxis axis )
    {
        final XAxisViewer viewer = this.axisMap.remove ( axis );
        if ( viewer != null )
        {
            viewer.dispose ();
        }
    }

    @Override
    public void dispose ()
    {
        super.dispose ();

        for ( final XAxisViewer viewer : this.axisMap.values () )
        {
            viewer.dispose ();
        }
        this.axisMap.clear ();
    }

    @Override
    public XAxisViewer getAxis ( final XAxis axis )
    {
        return this.axisMap.get ( axis );
    }

    @Override
    public Collection<XAxisViewer> getAll ()
    {
        return this.axisMap.values ();
    }
}
