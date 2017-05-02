/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views;

import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.scada.core.ui.connection.Activator;
import org.eclipse.scada.core.ui.connection.data.ConnectionDiscovererBean;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;

public class ConnectionContentProvider extends ObservableSetTreeContentProvider
{

    private final static class TreeStructureAdvisorExtension extends TreeStructureAdvisor
    {
        @Override
        public Object getParent ( final Object element )
        {
            if ( element instanceof ConnectionDiscovererBean )
            {
                return Activator.ROOT;
            }
            if ( element instanceof ConnectionHolder )
            {
                return ( (ConnectionHolder)element ).getDiscoverer ();
            }
            return super.getParent ( element );
        }
    }

    public ConnectionContentProvider ()
    {
        super ( new ConnectionObservableFactory (), new TreeStructureAdvisorExtension () );
    }

}
