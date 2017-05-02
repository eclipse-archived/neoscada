/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.dnd;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonDragAdapterAssistant extends org.eclipse.ui.navigator.CommonDragAdapterAssistant
{

    private final static Logger logger = LoggerFactory.getLogger ( CommonDragAdapterAssistant.class );

    private static final String NL = System.getProperty ( "line.separator", "\n" );

    @Override
    public Transfer[] getSupportedTransferTypes ()
    {
        return new Transfer[] { ItemTransfer.getInstance (), TextTransfer.getInstance (), URLTransfer.getInstance () };
    }

    @Override
    public void dragStart ( final DragSourceEvent event, final IStructuredSelection selection )
    {
        event.doit = !ItemSelectionHelper.getSelection ( selection ).isEmpty ();
    }

    @Override
    public boolean setDragData ( final DragSourceEvent event, final IStructuredSelection selection )
    {
        logger.debug ( "setDragData ( event: {}, selection: {}", event, selection );

        final Collection<Item> items = ItemSelectionHelper.getSelection ( selection );
        if ( items.isEmpty () )
        {
            logger.info ( "Empty item set for setDragData" );
            return false;
        }

        if ( ItemTransfer.getInstance ().isSupportedType ( event.dataType ) )
        {
            event.data = items.toArray ( new Item[items.size ()] );
            return true;
        }
        else if ( TextTransfer.getInstance ().isSupportedType ( event.dataType ) )
        {
            event.data = getItemUriData ( items );
            return true;
        }
        else if ( URLTransfer.getInstance ().isSupportedType ( event.dataType ) )
        {
            event.data = getItemUriData ( items );
            return true;
        }

        logger.debug ( "No possible transfer" );

        return false;
    }

    private Object getItemUriData ( final Collection<Item> items )
    {
        final StringBuilder sb = new StringBuilder ();
        int i = 0;
        for ( final Item item : items )
        {
            if ( i > 0 )
            {
                sb.append ( NL );
            }
            sb.append ( item.getConnectionString () );
            sb.append ( '#' );
            try
            {
                sb.append ( URLEncoder.encode ( item.getId (), "UTF-8" ) );
            }
            catch ( final UnsupportedEncodingException e )
            {
                sb.append ( item.getId () );
            }

            i++;
        }

        return sb.toString ();
    }

}
