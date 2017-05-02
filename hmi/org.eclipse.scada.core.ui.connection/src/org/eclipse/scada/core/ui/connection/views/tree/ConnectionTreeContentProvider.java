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
package org.eclipse.scada.core.ui.connection.views.tree;

import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

public class ConnectionTreeContentProvider extends ObservableSetTreeContentProvider
{

    private final static class TreeStructureAdvisorExtension extends TreeStructureAdvisor
    {
        @Override
        public Object getParent ( final Object element )
        {
            if ( element instanceof TreeNode )
            {
                final TreeNode parentNode = ( (TreeNode)element ).getParentNode ();
                if ( parentNode != null )
                {
                    return parentNode;
                }
            }
            return super.getParent ( element );
        }
    }

    public ConnectionTreeContentProvider ()
    {
        super ( new ConnectionTreeObservableFactory (), new TreeStructureAdvisorExtension () );
    }

}
