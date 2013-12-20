/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.client.DataItemValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An OSGi based HiveSource
 * 
 * @author Jens Reimann
 * @since 0.1.0
 */
public class SingleSubscriptionManager extends AbstractSubscriptionManager
{
    private final static Logger logger = LoggerFactory.getLogger ( SingleSubscriptionManager.class );

    private final ScheduledExecutorService executor;

    public interface Listener
    {
        public void stateChanged ( final String itemId, DataItemValue value );
    }

    private final Map<String, Set<Listener>> listeners = new HashMap<> ();

    public SingleSubscriptionManager ( final ScheduledExecutorService executor, final HiveSource hiveSource, final Properties properties )
    {
        super ( hiveSource, properties, executor );
        this.executor = executor;
    }

    @Override
    protected synchronized void putState ( final String itemId, final DataItemValue value )
    {
        super.putState ( itemId, value );

        final Set<Listener> set = this.listeners.get ( itemId );
        if ( set == null )
        {
            logger.debug ( "No listener set for: {}", itemId );
            return;
        }

        for ( final Listener listener : set )
        {
            logger.trace ( "Notify listener - itemId: {}, listener: {}", itemId, listener );
            try
            {
                this.executor.execute ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        listener.stateChanged ( itemId, value );
                    }
                } );
            }
            catch ( final Throwable e )
            {
                logger.warn ( "Failed to notify", e );
            }
        }
    }

    public synchronized void addListener ( final String itemId, final Listener listener )
    {
        if ( itemId == null )
        {
            throw new NullPointerException ( "'itemId' must not be null" );
        }
        if ( listener == null )
        {
            throw new NullPointerException ( "'listener' must not be null" );
        }

        Set<Listener> set = this.listeners.get ( itemId );
        if ( set == null )
        {
            set = new HashSet<> ( 1 );
            this.listeners.put ( itemId, set );
        }

        if ( !set.add ( listener ) )
        {
            return;
        }

        if ( set.size () == 1 )
        {
            // subscribe
            subscribe ( itemId );
        }
        else
        {
            final DataItemValue value = this.cache.get ( itemId );
            this.executor.execute ( new Runnable () {
                @Override
                public void run ()
                {
                    listener.stateChanged ( itemId, value );
                }
            } );
        }
    }

    public synchronized void removeListener ( final String itemId, final Listener listener )
    {
        if ( itemId == null )
        {
            throw new NullPointerException ( "'itemId' must not be null" );
        }
        if ( listener == null )
        {
            throw new NullPointerException ( "'listener' must not be null" );
        }

        final Set<Listener> set = this.listeners.get ( itemId );
        if ( set == null )
        {
            return;
        }

        if ( !set.remove ( listener ) )
        {
            return;
        }

        if ( set.isEmpty () )
        {
            unsubscribe ( itemId );
        }

        // manually notify
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                listener.stateChanged ( itemId, null );
            }
        } );
    }

}
