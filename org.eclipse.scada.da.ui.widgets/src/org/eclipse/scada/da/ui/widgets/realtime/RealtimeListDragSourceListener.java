/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.da.ui.connection.dnd.ItemTransfer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.URLTransfer;

public class RealtimeListDragSourceListener implements DragSourceListener
{

    private Viewer viewer = null;

    public RealtimeListDragSourceListener ( final Viewer viewer )
    {
        super ();
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
            final IStructuredSelection selection = (IStructuredSelection)LocalSelectionTransfer.getTransfer ().getSelection ();
            if ( ItemTransfer.getInstance ().isSupportedType ( event.dataType ) )
            {
                final List<Item> items = new ArrayList<Item> ();
                for ( final Iterator<?> i = selection.iterator (); i.hasNext (); )
                {
                    final ListEntry entry = (ListEntry)i.next ();
                    items.add ( entry.getItem () );
                }
                event.data = items.toArray ( new Item[items.size ()] );
            }
            else if ( TextTransfer.getInstance ().isSupportedType ( event.dataType ) )
            {
                setItemUriData ( event, selection );
            }
            else if ( URLTransfer.getInstance ().isSupportedType ( event.dataType ) )
            {
                setItemUriData ( event, selection );
            }
        }
        catch ( final Exception e )
        {
            event.doit = false;
        }
    }

    protected void setItemUriData ( final DragSourceEvent event, final IStructuredSelection selection )
    {
        final StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        for ( final Iterator<?> i = selection.iterator (); i.hasNext (); )
        {
            final ListEntry entry = (ListEntry)i.next ();

            if ( cnt > 0 )
            {
                sb.append ( "\n" ); //$NON-NLS-1$
            }

            final Item item = entry.getItem ();

            if ( item.getType () != Type.URI )
            {
                throw new IllegalStateException ( Messages.RealtimeListDragSourceListener_TypeError );
            }

            sb.append ( item.getConnectionString () );
            sb.append ( "#" ); //$NON-NLS-1$
            try
            {
                sb.append ( URLEncoder.encode ( item.getId (), "UTF-8" ) );
            }
            catch ( final UnsupportedEncodingException e )
            {
                sb.append ( item.getId () );
            }

            cnt++;
        }
        event.data = sb.toString ();
    }

    protected void setItemStringData ( final DragSourceEvent event, final IStructuredSelection selection )
    {
        final StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        for ( final Iterator<?> i = selection.iterator (); i.hasNext (); )
        {
            final ListEntry entry = (ListEntry)i.next ();
            if ( cnt > 0 )
            {
                sb.append ( "\n" ); //$NON-NLS-1$
            }

            sb.append ( entry.getDataItem ().getItem ().getId () );
            cnt++;
        }
        event.data = sb.toString ();
    }

    @Override
    public void dragStart ( final DragSourceEvent event )
    {
        event.doit = false;

        if ( ! ( this.viewer.getSelection () instanceof IStructuredSelection ) )
        {
            return;
        }

        final IStructuredSelection selection = (IStructuredSelection)this.viewer.getSelection ();
        if ( selection.isEmpty () )
        {
            return;
        }

        for ( final Iterator<?> i = selection.iterator (); i.hasNext (); )
        {
            final Object o = i.next ();
            if ( ! ( o instanceof ListEntry ) )
            {
                return;
            }
        }

        LocalSelectionTransfer.getTransfer ().setSelection ( this.viewer.getSelection () );

        event.doit = true;
    }

}
