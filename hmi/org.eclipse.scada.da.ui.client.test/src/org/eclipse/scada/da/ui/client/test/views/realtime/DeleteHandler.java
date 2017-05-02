/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.test.views.realtime;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.da.ui.widgets.realtime.ListEntry;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public class DeleteHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final RealTimeList part = (RealTimeList)getActivePage ().getActivePart ();

        final Collection<ListEntry> entries = SelectionHelper.list ( getSelection (), ListEntry.class );
        part.removeEntries ( entries );

        for ( final ListEntry entry : entries )
        {
            entry.dispose ();
        }
        return null;
    }
}
