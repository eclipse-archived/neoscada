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
package org.eclipse.scada.ae.ui.testing.views;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.scada.ae.Event;

final class EntryTimestampViewerComparator extends ViewerComparator
{
    @Override
    public int compare ( final Viewer viewer, final Object e1, final Object e2 )
    {
        if ( ! ( e1 instanceof Event ) || ! ( e2 instanceof Event ) )
        {
            return -super.compare ( viewer, e1, e2 );
        }
        final Event evt1 = (Event)e1;
        final Event evt2 = (Event)e2;

        return -evt1.getEntryTimestamp ().compareTo ( evt2.getEntryTimestamp () );
    }
}