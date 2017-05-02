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
package org.eclipse.scada.da.ui.connection.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public abstract class AbstractItemHandler extends AbstractSelectionHandler
{
    /**
     * Get all items from the selection
     *
     * @return a data of all selected items
     */
    protected Collection<Item> getItems ()
    {
        final Collection<Item> result = new LinkedList<Item> ();

        final IStructuredSelection sel = getSelection ();

        if ( sel != null && !sel.isEmpty () )
        {
            for ( final Iterator<?> i = sel.iterator (); i.hasNext (); )
            {
                final Object o = i.next ();

                final Item holder = AdapterHelper.adapt ( o, Item.class );
                if ( holder != null )
                {
                    result.add ( holder );
                }
            }
        }

        return result;
    }

    protected String asSecondardId ( final Item item )
    {
        return item.getId ().replace ( "_", "__" ).replace ( ':', '_' );
    }

}
