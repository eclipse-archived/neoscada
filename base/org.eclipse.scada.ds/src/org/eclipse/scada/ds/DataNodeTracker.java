/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.utils.osgi.FilterUtil;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class DataNodeTracker
{
    private final SingleServiceTracker<DataStore> tracker;

    private DataStore service;

    private final Map<String, Set<DataListener>> listeners = new HashMap<String, Set<DataListener>> ();

    private static Filter FILTER;

    static
    {
        try
        {
            FILTER = FilterUtil.createClassFilter ( DataStore.class.getName () );
        }
        catch ( final InvalidSyntaxException e )
        {
            throw new RuntimeException ( e );
        }
    }

    public DataNodeTracker ( final BundleContext context )
    {
        this.tracker = new SingleServiceTracker<DataStore> ( context, FILTER, new SingleServiceListener<DataStore> () {

            @Override
            public void serviceChange ( final ServiceReference<DataStore> reference, final DataStore service )
            {
                handleService ( service );
            }
        } );
    }

    protected synchronized void handleService ( final DataStore service )
    {
        if ( this.service != null )
        {
            // Detach from all
            for ( final Map.Entry<String, Set<DataListener>> listeners : this.listeners.entrySet () )
            {
                for ( final DataListener listener : listeners.getValue () )
                {
                    this.service.detachListener ( listeners.getKey (), listener );
                }
            }
        }

        this.service = service;

        if ( this.service != null )
        {
            // attach to all
            for ( final Map.Entry<String, Set<DataListener>> listeners : this.listeners.entrySet () )
            {
                for ( final DataListener listener : listeners.getValue () )
                {
                    this.service.attachListener ( listeners.getKey (), listener );
                }
            }
        }
    }

    public void open ()
    {
        this.tracker.open ();
    }

    public void close ()
    {
        this.tracker.close ();
    }

    /**
     * Add a listener for a data node
     * 
     * @param nodeId
     *            the node to listen to
     * @param listener
     *            the listener to add
     */
    public synchronized void addListener ( final String nodeId, final DataListener listener )
    {
        Set<DataListener> set = this.listeners.get ( nodeId );
        if ( set == null )
        {
            set = new HashSet<DataListener> ( 1 );
            this.listeners.put ( nodeId, set );
        }

        if ( set.add ( listener ) && this.service != null )
        {
            this.service.attachListener ( nodeId, listener );
        }
    }

    /**
     * Remove a listener for a data node
     * 
     * @param nodeId
     *            the node to remove the listener from
     * @param listener
     *            the listener to remove
     */
    public synchronized void removeListener ( final String nodeId, final DataListener listener )
    {
        final Set<DataListener> set = this.listeners.get ( nodeId );
        if ( set == null )
        {
            return;
        }

        if ( set.remove ( listener ) && this.service != null )
        {
            this.service.detachListener ( nodeId, listener );
        }

        if ( set.isEmpty () )
        {
            this.listeners.remove ( nodeId );
        }
    }

    /**
     * Write to the data node if there currently is a service attached
     * 
     * @param node
     *            the node to write
     * @return <code>true</code> if the service was attached an the request was
     *         passed on to the service, <code>false</code> otherwise.
     */
    public boolean write ( final DataNode node )
    {
        final DataStore store = this.service;
        if ( store != null )
        {
            store.writeNode ( node );
            return true;
        }
        else
        {
            return false;
        }
    }
}
