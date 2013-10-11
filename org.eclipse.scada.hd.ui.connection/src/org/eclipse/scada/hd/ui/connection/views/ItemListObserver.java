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
package org.eclipse.scada.hd.ui.connection.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.hd.ItemListListener;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.ui.connection.internal.ConnectionWrapper;
import org.eclipse.scada.hd.ui.connection.internal.ItemWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemListObserver extends WritableSet implements ItemListListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemListObserver.class );

    private final ConnectionService service;

    private final ConnectionWrapper connection;

    private final Map<String, ItemWrapper> items = new HashMap<String, ItemWrapper> ();

    public ItemListObserver ( final ConnectionWrapper connection )
    {
        this.connection = connection;
        this.service = connection.getService ();
        synchronized ( this )
        {
            this.service.getConnection ().addListListener ( this );
        }
    }

    @Override
    public synchronized void dispose ()
    {
        this.service.getConnection ().removeListListener ( this );
        super.dispose ();
    }

    @Override
    public void listChanged ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean full )
    {
        logger.debug ( "List changed: {} / {}", new Object[] { addedOrModified, removed } );

        if ( !isDisposed () )
        {
            getRealm ().asyncExec ( new Runnable () {
                @Override
                public void run ()
                {
                    handleUpdate ( addedOrModified, removed, full );
                }
            } );
        }
    }

    protected void handleUpdate ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean full )
    {
        if ( isDisposed () )
        {
            return;
        }

        setStale ( true );
        try
        {
            if ( full )
            {
                // full transmission ... clear first
                clear ();
            }

            if ( removed != null )
            {
                for ( final String itemId : removed )
                {
                    final ItemWrapper info = this.items.remove ( itemId );
                    if ( info != null )
                    {
                        remove ( info );
                    }
                }
            }
            if ( addedOrModified != null )
            {
                for ( final HistoricalItemInformation item : addedOrModified )
                {
                    final ItemWrapper wrapper = new ItemWrapper ( this.connection, item );
                    this.items.put ( item.getItemId (), wrapper );
                    add ( wrapper );
                }
            }
        }
        finally
        {
            setStale ( false );
        }
    }
}
