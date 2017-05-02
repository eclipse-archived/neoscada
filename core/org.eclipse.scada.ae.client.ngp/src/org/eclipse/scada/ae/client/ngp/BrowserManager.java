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
package org.eclipse.scada.ae.client.ngp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.BrowserListener;
import org.eclipse.scada.ae.data.BrowserEntry;

public class BrowserManager
{

    private final Set<BrowserListener> browserListeners = new LinkedHashSet<BrowserListener> ();

    private final ConnectionImpl connection;

    private final Executor executor;

    private final Map<String, BrowserEntry> currentEntries = new HashMap<String, BrowserEntry> ();

    public BrowserManager ( final Executor executor, final ConnectionImpl connection )
    {
        this.executor = executor;
        this.connection = connection;
    }

    public void addBrowserListener ( final BrowserListener listener )
    {
        if ( listener == null )
        {
            throw new NullPointerException ();
        }

        final boolean wasEmpty = this.browserListeners.isEmpty ();
        if ( this.browserListeners.add ( listener ) )
        {
            if ( wasEmpty )
            {
                this.connection.sendStartBrowse ();

            }

            final List<BrowserEntry> values = new ArrayList<BrowserEntry> ( this.currentEntries.values () );

            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.dataChanged ( values, Collections.<String> emptySet (), true );
                }
            } );
        }
    }

    public void removeBrowserListener ( final BrowserListener listener )
    {
        if ( this.browserListeners.remove ( listener ) )
        {
            if ( this.browserListeners.isEmpty () )
            {
                // we removed some entry and now we are empty
                this.connection.sendStopBrowse ();
            }
        }
    }

    public void dispose ()
    {

    }

    public void onBound ()
    {
        if ( !this.browserListeners.isEmpty () )
        {
            this.connection.sendStartBrowse ();
        }
    }

    public void onClosed ()
    {
        setCurrentEntries ( Collections.<BrowserEntry> emptyList (), null, true );
    }

    private void setCurrentEntries ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        if ( full )
        {
            this.currentEntries.clear ();
        }

        if ( addedOrUpdated != null )
        {
            for ( final BrowserEntry entry : addedOrUpdated )
            {
                this.currentEntries.put ( entry.getId (), entry );
            }
        }

        if ( removed != null )
        {
            for ( final String id : removed )
            {
                this.currentEntries.remove ( id );
            }
        }

        for ( final BrowserListener listener : this.browserListeners )
        {
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.dataChanged ( addedOrUpdated, removed, full );
                };
            } );
        }
    }

    public void updateData ( final List<BrowserEntry> addedOrUpdated, final Set<String> removed )
    {
        setCurrentEntries ( addedOrUpdated, removed, false );
    }
}
