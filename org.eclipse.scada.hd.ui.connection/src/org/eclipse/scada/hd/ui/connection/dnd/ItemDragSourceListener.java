/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.dnd;

import java.util.Collection;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.scada.hd.ui.connection.data.ItemSelectionHelper;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemDragSourceListener implements DragSourceListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemDragSourceListener.class );

    private final Viewer viewer;

    public ItemDragSourceListener ( final Viewer viewer )
    {
        this.viewer = viewer;
    }

    @Override
    public void dragFinished ( final DragSourceEvent event )
    {
    }

    @Override
    public void dragSetData ( final DragSourceEvent event )
    {
        try
        {
            if ( ItemTransfer.getInstance ().isSupportedType ( event.dataType ) )
            {
                final IStructuredSelection selection = (IStructuredSelection)LocalSelectionTransfer.getTransfer ().getSelection ();
                final Collection<Item> items = ItemSelectionHelper.getSelection ( selection );
                event.data = items.toArray ( new Item[items.size ()] );
                event.doit = true;
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to set drag data", e );
            event.doit = false;
        }

    }

    @Override
    public void dragStart ( final DragSourceEvent event )
    {
        event.doit = false;

        if ( ! ( this.viewer.getSelection () instanceof IStructuredSelection ) )
        {
            return;
        }

        final Collection<Item> items = ItemSelectionHelper.getSelection ( this.viewer.getSelection () );
        if ( !items.isEmpty () )
        {
            LocalSelectionTransfer.getTransfer ().setSelection ( this.viewer.getSelection () );
            event.doit = true;
        }

    }

}
