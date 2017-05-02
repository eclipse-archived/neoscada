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
package org.eclipse.scada.ae.server.monitor.proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractMonitorQueryListener
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractMonitorQueryListener.class );

    private final Map<String, MonitorStatusInformation> dataCache = new HashMap<String, MonitorStatusInformation> ();

    protected final Lock lock;

    private final ProxyMonitorQuery proxyMonitorQuery;

    protected final String info;

    private boolean disposed;

    public AbstractMonitorQueryListener ( final ProxyMonitorQuery proxyMonitorQuery, final Lock lock, final String info )
    {
        this.lock = lock;
        this.proxyMonitorQuery = proxyMonitorQuery;
        this.info = info;
    }

    protected void clearAll ()
    {
        this.lock.lock ();
        try
        {
            performClearAll ();
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    private void performClearAll ()
    {
        final Set<String> removed = new HashSet<String> ( this.dataCache.keySet () );
        this.dataCache.clear ();
        notifyChange ( null, removed );
    }

    protected void handleDataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        logger.debug ( "Data of {} changed - added: @{}, removed: @{}", new Object[] { this.info, addedOrUpdated == null ? -1 : addedOrUpdated.size (), removed == null ? -1 : removed.size () } );

        this.lock.lock ();

        try
        {
            final Set<String> removedIds = new HashSet<String> ();
            if ( full )
            {
                // remember all as removed
                removedIds.addAll ( this.dataCache.keySet () );
                this.dataCache.clear ();
            }

            if ( addedOrUpdated != null )
            {
                for ( final MonitorStatusInformation info : addedOrUpdated )
                {
                    this.dataCache.put ( info.getId (), info );
                    if ( full )
                    {
                        // maybe we need to re-add the item that was removed due to the "full" clear before
                        removedIds.remove ( info.getId () );
                    }
                }
            }
            if ( removed != null )
            {
                for ( final String id : removed )
                {
                    if ( this.dataCache.remove ( id ) != null )
                    {
                        removedIds.add ( id );
                    }
                }
            }
            notifyChange ( addedOrUpdated, removed );
        }
        finally
        {
            this.lock.unlock ();
        }
    }

    protected void notifyChange ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed )
    {
        if ( this.disposed )
        {
            logger.info ( "We are disposed. Discard event" );
            return;
        }

        // we may only send updates, since we don't know the full state
        this.proxyMonitorQuery.handleDataUpdate ( addedOrUpdated, removed );
    }

    public void dispose ()
    {
        this.lock.lock ();
        if ( this.disposed )
        {
            return;
        }

        // clear all first
        performClearAll ();

        try
        {
            // setting disposed state
            this.disposed = true;
        }
        finally
        {
            this.lock.unlock ();
        }
    }
}
