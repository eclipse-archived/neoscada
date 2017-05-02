/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds.storage;

import java.util.concurrent.Executor;

import org.eclipse.scada.ds.DataListener;
import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.DataStore;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public abstract class AbstractStorage implements DataStore
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractStorage.class );

    private final Multimap<String, DataListener> listeners = HashMultimap.create ();

    @Override
    public abstract NotifyFuture<DataNode> readNode ( final String nodeId );

    /**
     * Provide an executor for sending events
     * <p>
     * This method is only called after the constructor is completed
     * </p>
     * 
     * @return the executor to use, must never return <code>null</code>
     */
    protected abstract Executor getExecutor ();

    /**
     * Dispose the service.
     * <p>
     * This method still needs a valid executor using {@link #getExecutor()}.
     * </p>
     */
    public synchronized void dispose ()
    {
        for ( final DataListener listener : this.listeners.values () )
        {
            getExecutor ().execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.nodeChanged ( null );
                }
            } );
        }
        this.listeners.clear ();
    }

    @Override
    public synchronized void attachListener ( final String nodeId, final DataListener listener )
    {
        if ( this.listeners.put ( nodeId, listener ) )
        {
            final NotifyFuture<DataNode> task = readNode ( nodeId );

            // fire events in executor thread
            getExecutor ().execute ( new Runnable () {

                @Override
                public void run ()
                {
                    try
                    {
                        listener.nodeChanged ( task.get () );
                    }
                    catch ( final Exception e )
                    {
                        listener.nodeChanged ( null );
                        logger.info ( "Failed to initially load data node", e );
                    }
                }
            } );

        }
    }

    @Override
    public synchronized void detachListener ( final String nodeId, final DataListener listener )
    {
        this.listeners.remove ( nodeId, listener );
    }

    protected synchronized void fireUpdate ( final DataNode node )
    {
        for ( final DataListener listener : this.listeners.get ( node.getId () ) )
        {
            getExecutor ().execute ( new Runnable () {

                @Override
                public void run ()
                {
                    listener.nodeChanged ( node );
                }
            } );
        }
    }

}