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
package org.eclipse.scada.da.ui.connection.data;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class ItemSelectionHelper
{
    /**
     * Get all {@link Item} instances from the current selection
     * 
     * @param selection
     *            the selection
     * @return the item instances
     */
    public static Collection<Item> getSelection ( final ISelection selection )
    {
        final Collection<Item> items = new LinkedList<Item> ();

        if ( selection == null || selection.isEmpty () )
        {
            return items;
        }

        if ( selection instanceof IStructuredSelection )
        {
            final Iterator<?> i = ( (IStructuredSelection)selection ).iterator ();
            while ( i.hasNext () )
            {
                final Item item = AdapterHelper.adapt ( i.next (), Item.class );
                if ( item != null )
                {
                    items.add ( item );
                }
            }
        }

        return items;
    }

    public static Item getFirstFromSelection ( final ISelection selection )
    {
        for ( final Item item : getSelection ( selection ) )
        {
            return item;
        }
        return null;
    }
}
