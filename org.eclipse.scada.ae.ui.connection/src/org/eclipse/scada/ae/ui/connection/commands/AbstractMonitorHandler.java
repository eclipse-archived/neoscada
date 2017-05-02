/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new adapter helper
 *******************************************************************************/
package org.eclipse.scada.ae.ui.connection.commands;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.ae.ui.connection.data.MonitorStatusBean;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public abstract class AbstractMonitorHandler extends AbstractSelectionHandler
{
    protected List<MonitorStatusBean> getMonitors ()
    {
        final IStructuredSelection sel = getSelection ();
        if ( sel == null )
        {
            return new LinkedList<MonitorStatusBean> ();
        }

        final List<MonitorStatusBean> result = new LinkedList<MonitorStatusBean> ();

        final Iterator<?> i = sel.iterator ();
        while ( i.hasNext () )
        {
            final Object o = i.next ();
            final MonitorStatusBean bean = AdapterHelper.adapt ( o, MonitorStatusBean.class );
            if ( bean != null )
            {
                result.add ( bean );
            }
        }
        return result;
    }

}