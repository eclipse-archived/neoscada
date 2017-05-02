/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new AdapterHelper
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.hd.ui.connection.internal.ItemWrapper;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class CreateQueryHandler extends AbstractSelectionHandler
{

    protected Collection<ItemWrapper> getItems ()
    {
        final Collection<ItemWrapper> result = new LinkedList<ItemWrapper> ();

        final IStructuredSelection sel = getSelection ();

        if ( sel != null && !sel.isEmpty () )
        {
            for ( final Iterator<?> i = sel.iterator (); i.hasNext (); )
            {
                final Object o = i.next ();

                final ItemWrapper item = AdapterHelper.adapt ( o, ItemWrapper.class );
                if ( item != null )
                {
                    result.add ( item );
                }
            }
        }

        return result;
    }

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final ItemWrapper item : getItems () )
        {
            item.getConnection ().getQueryManager ().createQuery ( item.getItemInformation ().getItemId () );
        }
        return null;
    }

}
