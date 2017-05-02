/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.common.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorQuery
{
    private final static Logger logger = LoggerFactory.getLogger ( MonitorQuery.class );

    private final Set<MonitorQueryListener> listeners;

    private final Map<String, MonitorStatusInformation> cachedData;

    private final Executor executor;

    public MonitorQuery ( final Executor executor )
    {
        this.executor = executor;
        this.cachedData = new HashMap<String, MonitorStatusInformation> ();
        this.listeners = new LinkedHashSet<MonitorQueryListener> ();
    }

    /**
     * Add a listener to the monitor query
     * <p>
     * If the listener was already added this operation has no effect
     * </p>
     * <p>
     * The listener will receive all current known elements in a first update
     * call.
     * </p>
     * 
     * @param listener
     *            the listener to add
     */
    public synchronized void addListener ( final MonitorQueryListener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            listener.dataChanged ( new ArrayList<MonitorStatusInformation> ( this.cachedData.values () ), null, true );
        }
    }

    public synchronized void removeListener ( final MonitorQueryListener listener )
    {
        this.listeners.remove ( listener );
    }

    private synchronized void fireListener ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
    {
        for ( final MonitorQueryListener listener : this.listeners )
        {
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    try
                    {
                        listener.dataChanged ( addedOrUpdated, removed, full );
                    }
                    catch ( final Exception e )
                    {
                        logger.warn ( "Failed to notify", e );
                    }
                }
            } );
        }
    }

    protected synchronized void updateData ( final List<MonitorStatusInformation> data, final Set<String> removed, final boolean full )
    {
        if ( full )
        {
            this.cachedData.clear ();
        }

        if ( data != null )
        {
            for ( final MonitorStatusInformation info : data )
            {
                this.cachedData.put ( info.getId (), info );
            }
        }

        final Set<String> removedItems = new HashSet<String> ();
        if ( removed != null )
        {
            for ( final String entry : removed )
            {
                if ( this.cachedData.remove ( entry ) != null )
                {
                    removedItems.add ( entry );
                }
            }
        }

        fireListener ( data, removedItems, full );
    }

    public synchronized void dispose ()
    {
        clear ();
        this.listeners.clear ();
    }

    /**
     * Set current data set. Will handle notifications accordingly.
     * 
     * @param data
     *            the new data set
     */
    protected synchronized void setData ( final MonitorStatusInformation[] data )
    {
        logger.debug ( "Set new data: {}", data.length );

        clear ();

        final ArrayList<MonitorStatusInformation> newData = new ArrayList<MonitorStatusInformation> ( data.length );
        for ( final MonitorStatusInformation ci : data )
        {
            newData.add ( ci );
            final MonitorStatusInformation oldCi = this.cachedData.put ( ci.getId (), ci );
            if ( oldCi != null )
            {
                newData.remove ( oldCi );
            }
        }
        fireListener ( newData, null, true );
    }

    protected synchronized void clear ()
    {
        fireListener ( null, null, true );
        this.cachedData.clear ();
    }
}
