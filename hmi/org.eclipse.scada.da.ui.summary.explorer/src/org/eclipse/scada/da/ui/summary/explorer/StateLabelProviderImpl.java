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
package org.eclipse.scada.da.ui.summary.explorer;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.core.ui.styles.StateInformation;
import org.eclipse.scada.core.ui.styles.StateInformation.State;

public class StateLabelProviderImpl extends AbstractStyleListener
{
    private final State state;

    public StateLabelProviderImpl ( final IObservableSet itemsThatNeedLabels, final State state )
    {
        super ( itemsThatNeedLabels );
        this.state = state;
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object element = cell.getElement ();
        if ( ! ( element instanceof TreeNode ) )
        {
            return;
        }

        final boolean active = isActive ( (TreeNode)element );
        cell.setText ( active ? "X" : "" );
    }

    private boolean isActive ( final TreeNode node )
    {
        final StateInformation nodeState = node.getState ();
        return nodeState.getStates ().contains ( this.state );
    }
}