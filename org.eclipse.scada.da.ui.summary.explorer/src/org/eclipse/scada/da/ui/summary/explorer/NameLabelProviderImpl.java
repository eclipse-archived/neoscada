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
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;

public class NameLabelProviderImpl extends AbstractStyleListener
{
    public NameLabelProviderImpl ( final IObservableSet itemsThatNeedLabels )
    {
        super ( itemsThatNeedLabels );
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object element = cell.getElement ();
        if ( element instanceof TreeNode )
        {
            final TreeNode node = (TreeNode)element;
            cell.setText ( node.getName () );

            final CurrentStyle style = node.getStyle ();
            cell.setImage ( style.image );
            cell.setFont ( style.font );
            cell.setForeground ( style.foreground );
            cell.setBackground ( style.background );
        }
    }

}