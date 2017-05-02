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
package org.eclipse.scada.da.ui.widgets.realtime;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class ListEntryComparator extends ViewerComparator
{
    @Override
    public int compare ( final Viewer viewer, final Object e1, final Object e2 )
    {
        if ( e1 instanceof ListEntry && e2 instanceof ListEntry )
        {
            final ListEntry l1 = (ListEntry)e1;
            final ListEntry l2 = (ListEntry)e2;
            return l1.getDataItem ().getItem ().getId ().compareTo ( l2.getDataItem ().getItem ().getId () );
        }
        if ( e1 instanceof AttributePair && e2 instanceof AttributePair )
        {
            final AttributePair l1 = (AttributePair)e1;
            final AttributePair l2 = (AttributePair)e2;
            return l1.key.compareTo ( l2.key );
        }
        return super.compare ( viewer, e1, e2 );
    }
}