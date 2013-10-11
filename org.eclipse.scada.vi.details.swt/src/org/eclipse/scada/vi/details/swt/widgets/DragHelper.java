/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Collection;

import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.dnd.ItemTransfer;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

public final class DragHelper
{
    private DragHelper ()
    {
    }

    protected static void setItemUriData ( final DragSourceEvent event, final Collection<Item> items )
    {
        final StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        for ( final Item item : items )
        {
            if ( cnt > 0 )
            {
                sb.append ( "\n" ); //$NON-NLS-1$
            }

            sb.append ( item.getConnectionString () );
            sb.append ( "#" ); //$NON-NLS-1$
            sb.append ( item.getId () );

            cnt++;
        }
        event.data = sb.toString ();
    }

    public static void addDragSupport ( final Control control, final RegistrationManager registrationManager )
    {
        final Transfer[] types = new Transfer[] { ItemTransfer.getInstance (), TextTransfer.getInstance () };

        final DragSource source = new DragSource ( control, DND.DROP_LINK | DND.DROP_MOVE | DND.DROP_COPY );
        source.setTransfer ( types );
        source.addDragListener ( new DragSourceAdapter () {

            @Override
            public void dragStart ( final DragSourceEvent event )
            {
                if ( registrationManager.getItems ().isEmpty () )
                {
                    event.doit = false;
                }
            };

            @Override
            public void dragSetData ( final DragSourceEvent event )
            {
                final Collection<Item> items = registrationManager.getItems ();
                if ( ItemTransfer.getInstance ().isSupportedType ( event.dataType ) )
                {
                    event.data = items.toArray ( new Item[items.size ()] );
                }
                else if ( TextTransfer.getInstance ().isSupportedType ( event.dataType ) )
                {
                    setItemUriData ( event, items );
                }
            }
        } );
    }
}
