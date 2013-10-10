/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.client.ngp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.hd.ItemListListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;

public class ItemManager
{

    private final Set<ItemListListener> itemListeners = new LinkedHashSet<ItemListListener> ();

    private final Map<String, HistoricalItemInformation> itemCache = new HashMap<String, HistoricalItemInformation> ();

    private final Executor executor;

    private final ConnectionImpl connection;

    private boolean disposed;

    public ItemManager ( final Executor executor, final ConnectionImpl connection )
    {
        this.executor = executor;
        this.connection = connection;
    }

    public synchronized void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        onConnectionClosed ();
        this.disposed = true;
    }

    public synchronized void addListListener ( final ItemListListener listener )
    {
        // we are empty and adding an element
        if ( this.itemListeners.isEmpty () )
        {
            // ... so start browsing
            this.connection.sendBrowseRequestState ( true );
        }

        if ( this.itemListeners.add ( listener ) )
        {
            final Set<HistoricalItemInformation> itemCache = new HashSet<HistoricalItemInformation> ( this.itemCache.values () );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.listChanged ( itemCache, Collections.<String> emptySet (), true );
                }
            } );
        }
    }

    /**
     * Updates data to the cache
     * 
     * @param addedOrModified
     *            the items that where added or modified
     * @param removed
     *            the items that where removed
     * @param full
     *            <code>true</code> if this is a full update and not a delta
     *            update
     */
    private void applyChange ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean full )
    {
        if ( full )
        {
            this.itemCache.clear ();
        }
        if ( removed != null )
        {
            for ( final String item : removed )
            {
                this.itemCache.remove ( item );
            }
        }
        if ( addedOrModified != null )
        {
            for ( final HistoricalItemInformation item : addedOrModified )
            {
                this.itemCache.put ( item.getItemId (), item );
            }
        }
    }

    private void fireListChanged ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean fullUpdate )
    {
        if ( this.disposed )
        {
            return;
        }

        applyChange ( addedOrModified, removed, fullUpdate );

        // make a clone copy
        final Collection<ItemListListener> listeners = new ArrayList<ItemListListener> ( this.itemListeners );

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ItemListListener listener : listeners )
                {
                    listener.listChanged ( addedOrModified, removed, fullUpdate );
                }
            }
        } );
    }

    public synchronized void removeListListener ( final ItemListListener listener )
    {
        this.itemListeners.remove ( listener );
        if ( this.itemListeners.isEmpty () )
        {
            // no listeners ... we can stop listening
            this.connection.sendBrowseRequestState ( false );
        }
    }

    public synchronized void onConnectionBound ()
    {
        if ( !this.itemListeners.isEmpty () )
        {
            this.connection.sendBrowseRequestState ( true );
        }
    }

    public synchronized void onConnectionClosed ()
    {
        fireListChanged ( null, null, true );
    }

    public synchronized void handleListUpdate ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean fullUpdate )
    {
        fireListChanged ( addedOrModified, removed, fullUpdate );
    }

}
