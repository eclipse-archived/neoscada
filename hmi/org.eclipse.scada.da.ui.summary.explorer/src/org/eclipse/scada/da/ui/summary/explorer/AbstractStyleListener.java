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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.scada.ui.databinding.ListeningStyledCellLabelProvider;

public abstract class AbstractStyleListener extends ListeningStyledCellLabelProvider implements PropertyChangeListener
{
    public AbstractStyleListener ( final IObservableSet itemsThatNeedLabels )
    {
        super ( itemsThatNeedLabels );
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        if ( next instanceof TreeNode )
        {
            ( (TreeNode)next ).removePropertyChangeListener ( TreeNode.PROP_STYLE, this );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        if ( next instanceof TreeNode )
        {
            ( (TreeNode)next ).addPropertyChangeListener ( TreeNode.PROP_STYLE, this );
        }
    }

    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        fireLabelProviderChanged ( new LabelProviderChangedEvent ( this, evt.getSource () ) );
    }

}
