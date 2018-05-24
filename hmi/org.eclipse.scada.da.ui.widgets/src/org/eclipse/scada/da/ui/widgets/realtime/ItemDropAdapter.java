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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.da.ui.connection.dnd.ItemTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemDropAdapter extends ViewerDropAdapter
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemDropAdapter.class );

    private final RealtimeListAdapter list;

    public ItemDropAdapter ( final Viewer viewer, final RealtimeListAdapter list )
    {
        super ( viewer );
        this.list = list;
        setFeedbackEnabled ( true );
        setSelectionFeedbackEnabled ( true );
    }

    @Override
    public boolean performDrop ( final Object data )
    {
        logger.debug ( "Dropping: {}", data );

        if ( data instanceof Item[] )
        {
            dropItems ( (Item[])data );
            return true;
        }
        if ( data instanceof String )
        {
            dropString ( data );
            return true;
        }
        return false;
    }

    private void dropString ( final Object data )
    {
        final TreeViewer viewer = (TreeViewer)getViewer ();
        final String toks[] = ( (String)data ).split ( "[\\n\\r]+" ); //$NON-NLS-1$
        for ( final String tok : toks )
        {
            try
            {
                final URI uri = new URI ( tok );
                if ( uri.getScheme () == null )
                {
                    final String[] stoks = tok.split ( "#" );
                    final Item item = new Item ( stoks[0], decodeItemId ( stoks[1] ), Type.ID );
                    dropItem ( item, viewer );
                }
                else if ( uri.getFragment () != null )
                {
                    final String[] stoks = tok.split ( "#", 2 );
                    final Item item = new Item ( stoks[0], decodeItemId ( stoks[1] ), Type.URI );
                    dropItem ( item, viewer );
                }

            }
            catch ( final URISyntaxException e )
            {
                final String[] stoks = tok.split ( "#" );
                final Item item = new Item ( stoks[0], decodeItemId ( stoks[1] ), Type.ID );
                dropItem ( item, viewer );
            }
        }
    }

    private String decodeItemId ( final String itemId )
    {
        try
        {
            return URLDecoder.decode ( itemId, "UTF-8" );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return itemId;
        }
    }

    private void dropItems ( final Item[] items )
    {
        final TreeViewer viewer = (TreeViewer)getViewer ();

        for ( final Item item : items )
        {
            dropItem ( item, viewer );
        }
    }

    private void dropItem ( final Item item, final TreeViewer viewer )
    {
        logger.info ( "Dropped item: {} ({})", item, item.getType () );

        final ListEntry entry = new ListEntry ();
        entry.setDataItem ( new Item ( item ) );
        this.list.add ( entry );
    }

    @Override
    public boolean validateDrop ( final Object target, final int operation, final TransferData transferData )
    {
        if ( ItemTransfer.getInstance ().isSupportedType ( transferData ) )
        {
            return true;
        }
        if ( TextTransfer.getInstance ().isSupportedType ( transferData ) )
        {
            return true;
        }
        return false;
    }

}
