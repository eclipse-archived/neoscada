/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.connection.navigator;

import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

public class ConnectionContentProvider extends ObservableSetTreeContentProvider
{
    private final static class TreeStructureAdvisorExtension extends TreeStructureAdvisor
    {
        @Override
        public Object getParent ( final Object element )
        {
            return super.getParent ( element );
        }
    }

    public ConnectionContentProvider ()
    {
        super ( new ConnectionObservableFactory (), new TreeStructureAdvisorExtension () );
    }
}
